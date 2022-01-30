package dev.jstanger.language;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import dev.jstanger.language.psi.CornTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CornBraceMatcher implements PairedBraceMatcher {
    public static final BracePair[] PAIRS = new BracePair[]{
        new BracePair(CornTypes.LEFT_BRACE, CornTypes.RIGHT_BRACE, true),
                new BracePair(CornTypes.LEFT_BRACKET, CornTypes.RIGHT_BRACKET, true)
    };

    @Override
    public BracePair @NotNull [] getPairs() {
        return PAIRS;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
        return false;
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }
}
