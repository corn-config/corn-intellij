package dev.jstanger.language;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import dev.jstanger.language.psi.CornAssignment;
import dev.jstanger.language.psi.CornTypes;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CornCompletionContributor extends CompletionContributor {

    public CornCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(CornTypes.INPUT_TOKEN),
                new CompletionProvider<>() {
                    @Override
                    protected void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet result) {
                        Project project = ProjectManager.getInstance().getOpenProjects()[0];
                        List<CornAssignment> assignments = CornUtil.findAssignments(project, null);

                        for (CornAssignment assignment : assignments) {
                            result.addElement(LookupElementBuilder.create(assignment.getInputName()));
                        }
                    }
                }
        );
    }

    @Override
    public void fillCompletionVariants(@NotNull CompletionParameters parameters, @NotNull CompletionResultSet result) {
        super.fillCompletionVariants(parameters, result);
    }
}
