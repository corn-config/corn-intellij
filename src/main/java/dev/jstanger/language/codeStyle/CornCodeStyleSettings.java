package dev.jstanger.language.codeStyle;

import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;

public class CornCodeStyleSettings extends CustomCodeStyleSettings {
    protected CornCodeStyleSettings(CodeStyleSettings container) {
        super("CornCodeStyleSettings", container);
    }

    // Wrapping and braces
    public final int OBJECTS_WRAP = CommonCodeStyleSettings.DO_NOT_WRAP;
    public final boolean OBJECTS_ALIGN_WHEN_MULTILINE = false;
    public final int OBJECT_FIELDS_WRAP = CommonCodeStyleSettings.DO_NOT_WRAP;
    public final boolean OBJECT_FIELDS_ASSIGNMENT_ON_NEXT_LINE = false;

    public final int ARRAYS_WRAP = CommonCodeStyleSettings.DO_NOT_WRAP;
    public final boolean ARRAYS_ALIGN_WHEN_MULTILINE = false;
}
