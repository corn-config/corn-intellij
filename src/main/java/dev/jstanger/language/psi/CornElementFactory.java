package dev.jstanger.language.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.util.PsiTreeUtil;
import dev.jstanger.language.CornFileType;

import java.util.Objects;

public class CornElementFactory {
    public static CornInput createInput(Project project, String name) {
        String text = getCreateInputText(name);

        final CornFile dummyFile = createFile(project, text);
        CornObject object = PsiTreeUtil.getChildOfType(dummyFile, CornObject.class);
        assert object != null;
        return Objects.requireNonNull(object.getPairList().get(0).getValue()).getInput();
    }

    private static String getCreateInputText(String name) {
        return String.format("{ dummy = %s }", name);
    }

    private static CornFile createFile(Project project, String text) {
        String name = "dummy.corn";
        return (CornFile) PsiFileFactory.getInstance(project).createFileFromText(name, CornFileType.INSTANCE, text);
    }
}
