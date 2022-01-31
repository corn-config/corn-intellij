package dev.jstanger.language.codeStyle;

import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;

public class CornCodeStyleSettings extends CustomCodeStyleSettings {
    protected CornCodeStyleSettings(CodeStyleSettings container) {
        super("CornCodeStyleSettings", container);
    }

    // Wrapping and braces
    public int OBJECTS_WRAP = CommonCodeStyleSettings.DO_NOT_WRAP;
    public boolean OBJECTS_ALIGN_WHEN_MULTILINE = false;
    public int OBJECT_FIELDS_WRAP = CommonCodeStyleSettings.DO_NOT_WRAP;
    public boolean OBJECT_FIELDS_ASSIGNMENT_ON_NEXT_LINE = false;

    public int ARRAYS_WRAP = CommonCodeStyleSettings.DO_NOT_WRAP;
    public boolean ARRAYS_ALIGN_WHEN_MULTILINE = false;
}
