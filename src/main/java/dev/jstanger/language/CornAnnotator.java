package dev.jstanger.language;

import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import dev.jstanger.language.psi.*;
import org.apache.commons.io.FilenameUtils;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CornAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof CornInput input) checkHighlightInput(input, holder);
        else if (element instanceof CornPath path) checkHighlightPath(path, holder);
    }

    private void checkHighlightInput(@NotNull CornInput input, @NotNull AnnotationHolder holder) {
        var project = ProjectManager.getInstance().getOpenProjects()[0];

        var parent = input.getParent();
        var isAssignment = parent instanceof CornAssignment;
        var isSpread = parent instanceof CornSpread;

        if (isAssignment) {
            checkHighlightInputAssignment(input, holder, project);
        } else {
            checkHighlightInputUsage(input, holder, project);
        }

        if (isSpread) {
            checkHighlightSpread(input, holder, project);
        }
    }

    private void checkHighlightInputAssignment(@NotNull CornInput input, @NotNull AnnotationHolder holder, @NotNull Project project) {
        var inputToken = input.getInputToken();
        String inputName = inputToken.getText();

        List<CornInput> inputs = CornUtil.findInputs(project, inputName, true);

        // result will contain assignment if present
        if (inputs.size() <= 1) {
            holder.newAnnotation(HighlightSeverity.WEAK_WARNING, String.format("Input `%s` is unused.", inputName))
                    .range(input.getTextRange())
                    .highlightType(ProblemHighlightType.LIKE_UNUSED_SYMBOL).create();
        }

        var assignments = CornUtil.findAssignments(project, inputName);
        if (assignments.size() > 1) {
            holder.newAnnotation(HighlightSeverity.WARNING, String.format("Input `%s` is declared multiple times.", inputName))
                    .range(input.getTextRange())
                    .highlightType(ProblemHighlightType.WARNING).create();
        }
    }

    private void checkHighlightInputUsage(@NotNull CornInput input, @NotNull AnnotationHolder holder, @NotNull Project project) {
        PsiElement inputToken = input.getInputToken();
        String inputName = inputToken.getText();

        // environment variable inputs don't need to be declared
        if (inputName.startsWith("$env_")) {
            return;
        }

        List<CornAssignment> assignments = CornUtil.findAssignments(project, inputName);

        if (assignments.isEmpty()) {
            holder.newAnnotation(HighlightSeverity.ERROR, String.format("Input `%s` is not defined.", inputName))
                    .range(input.getTextRange())
                    .highlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL).create();
        }
    }

    private void checkHighlightSpread(@NotNull CornInput input, @NotNull AnnotationHolder holder, @NotNull Project project) {
        var spreadParent = input.getParent().getParent();
        var isInObject = spreadParent instanceof CornObjectValue;
        var isInArray = spreadParent instanceof CornArrayValue;

        PsiElement inputToken = input.getInputToken();
        String inputName = inputToken.getText();

        var assignments = CornUtil.findAssignments(project, inputName);
        CornValue value = null;
        if (!assignments.isEmpty()) value = assignments.get(0).getValue();

        if (value != null) {
            if (isInObject && value.getObject() == null) {
                holder.newAnnotation(HighlightSeverity.ERROR, "You can only spread object inputs into objects.")
                        .range(input.getTextRange())
                        .highlightType(ProblemHighlightType.GENERIC_ERROR).create();
            }

            if (isInArray && value.getArray() == null) {
                holder.newAnnotation(HighlightSeverity.ERROR, "You can only spread array inputs into arrays.")
                        .range(input.getTextRange())
                        .highlightType(ProblemHighlightType.GENERIC_ERROR).create();
            }
        }
    }

    private void checkHighlightPath(@NotNull CornPath path, @NotNull AnnotationHolder holder) {
        var project = ProjectManager.getInstance().getOpenProjects()[0];
        var name = path.getName();

        var parentObj = PsiTreeUtil.getParentOfType(path, CornObject.class);
        if (parentObj == null) return;
        var pairs = parentObj.getObjectValueList().stream().map(CornObjectValue::getPair).filter(Objects::nonNull).toList();

        var isDuplicate = pairs.stream().map(pair -> pair.getPath().getName()).filter(n -> Objects.equals(n, name)).count() > 1;
        if (isDuplicate) {
            holder.newAnnotation(HighlightSeverity.WARNING, String.format("Path `%s` is declared multiple times.", name))
                    .range(path.getTextRange())
                    .highlightType(ProblemHighlightType.WARNING).create();
        }

        var isMulti = name.contains(".");
        if (isMulti) {
            var parentPathName = FilenameUtils.removeExtension(name);
            var parent = pairs
                    .stream()
                    .filter(p -> Objects.equals(p.getPath().getName(), parentPathName))
                    .findAny()
                    .map(CornPair::getValue)
                    .orElse(null);

            if (parent != null) {
                var value = parent.getObject();
                if (value == null) {
                    var input = parent.getInput();
                    if (input != null) {
                        var assignments = CornUtil.findAssignments(project, input.getName());
                        value = assignments
                                .stream()
                                .map(CornAssignment::getValue)
                                .map(v -> Optional.ofNullable(v.getObject()))
                                .flatMap(Optional::stream)
                                .findAny()
                                .orElse(null);
                    }
                }

                if (value == null) {
                    holder.newAnnotation(HighlightSeverity.ERROR, String.format("Value at `%s` is not an object", parentPathName))
                            .range(path.getTextRange())
                            .highlightType(ProblemHighlightType.GENERIC_ERROR).create();
                }
            }
        }

    }
}
