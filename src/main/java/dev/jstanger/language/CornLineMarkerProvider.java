package dev.jstanger.language;

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider;
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.psi.PsiElement;
import dev.jstanger.language.psi.CornAssignment;
import dev.jstanger.language.psi.CornInput;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

public class CornLineMarkerProvider extends RelatedItemLineMarkerProvider {
    @Override
    protected void collectNavigationMarkers(@NotNull PsiElement element, @NotNull Collection<? super RelatedItemLineMarkerInfo<?>> result) {
        if (!(element instanceof CornInput input)) {
            return;
        }

        if(element.getParent() instanceof CornAssignment) {
            return;
        }

        String inputName = input.getText();

        // environment variable inputs don't need to be declared
        if (inputName.startsWith("$env_")) {
            return;
        }

        Project project = ProjectManager.getInstance().getOpenProjects()[0];
        List<CornAssignment> assignments = CornUtil.findAssignments(project, inputName);

        if (!assignments.isEmpty()) {
            NavigationGutterIconBuilder<PsiElement> builder = NavigationGutterIconBuilder
                    .create(AllIcons.Gutter.ImplementingMethod)
                    .setTargets(assignments.get(assignments.size() - 1))
                    .setTooltipText("Navigate to input declaration");

            result.add(builder.createLineMarkerInfo(input.getInputToken()));
        }
    }
}
