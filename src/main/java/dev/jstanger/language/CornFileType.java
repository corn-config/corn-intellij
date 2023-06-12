package dev.jstanger.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.NlsSafe;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class CornFileType extends LanguageFileType {
    public static final CornFileType INSTANCE = new CornFileType();

    private CornFileType() {
        super(CornLanguage.INSTANCE);
    }

    @Override
    public @NonNls @NotNull String getName() {
        return "Corn config";
    }

    @Override
    public @NlsContexts.Label @NotNull String getDescription() {
        return "Corn configuration language";
    }

    @Override
    public @NlsSafe @NotNull String getDefaultExtension() {
        return "corn";
    }

    @Override
    public @Nullable Icon getIcon() {
        return CornIcons.FILE;
    }
}
