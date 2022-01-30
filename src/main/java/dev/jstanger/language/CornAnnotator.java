package dev.jstanger.language;

import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.psi.PsiElement;
import dev.jstanger.language.psi.CornAssignment;
import dev.jstanger.language.psi.CornInput;
import dev.jstanger.language.psi.CornValue;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CornAnnotator implements Annotator {
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if(element instanceof CornValue) {
            CornValue literalValue = (CornValue) element;

            if(literalValue.getInput() == null) {
                return;
            }

            PsiElement input = literalValue.getInput().getInputToken();
            String inputName = input.getText();

            // environment variable inputs don't need to be declared
            if (inputName.startsWith("$env_")) {
                return;
            }

            Project project = ProjectManager.getInstance().getOpenProjects()[0];
            List<CornAssignment> assignments = CornUtil.findAssignments(project, inputName);

            if (assignments == null || assignments.isEmpty()) {
                holder.newAnnotation(HighlightSeverity.ERROR, String.format("Input `%s` is not defined", inputName))
                        .range(element.getTextRange())
                        .highlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL).create();
            }
        } else if (element instanceof CornAssignment) {
            PsiElement input = ((CornAssignment) element).getInput().getInputToken();
            String inputName = input.getText();

            Project project = ProjectManager.getInstance().getOpenProjects()[0];
            List<CornInput> inputs = CornUtil.findInputs(project, inputName, false);

            if(inputs.isEmpty()) {
                holder.newAnnotation(HighlightSeverity.WEAK_WARNING, String.format("Input `%s` is unused", inputName))
                        .range(((CornAssignment) element).getInput().getTextRange())
                        .highlightType(ProblemHighlightType.LIKE_UNUSED_SYMBOL).create();
            }
        }
    }
}
