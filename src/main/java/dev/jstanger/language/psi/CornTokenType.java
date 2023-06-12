package dev.jstanger.language.psi;

import com.intellij.psi.tree.IElementType;
import dev.jstanger.language.CornLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class CornTokenType extends IElementType {
    public CornTokenType(@NotNull @NonNls String debugName) {
        super(debugName, CornLanguage.INSTANCE);
    }
}
