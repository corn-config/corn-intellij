package dev.jstanger.language.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import dev.jstanger.language.CornFileType;
import dev.jstanger.language.CornLanguage;
import org.jetbrains.annotations.NotNull;

public class CornFile extends PsiFileBase {
    public CornFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, CornLanguage.INSTANCE);
    }

    @Override
    public @NotNull FileType getFileType() {
        return CornFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Corn config";
    }
}
