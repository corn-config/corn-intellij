package dev.jstanger.language.psi;

import com.intellij.psi.tree.IElementType;
import dev.jstanger.language.CornLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class CornElementType extends IElementType {
    public CornElementType(java.lang.@NonNls @NotNull String debugName) {
        super(debugName, CornLanguage.INSTANCE);
    }
}
