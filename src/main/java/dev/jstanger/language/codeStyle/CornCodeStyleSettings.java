package dev.jstanger.language.codeStyle;

import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class CornCodeStyleSettings extends CustomCodeStyleSettings {
    protected CornCodeStyleSettings(CodeStyleSettings container) {
        super("CornCodeStyleSettings", container);
    }
}
