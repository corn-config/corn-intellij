package dev.jstanger.language.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;
import dev.jstanger.language.psi.CornAssignment;
import dev.jstanger.language.psi.CornNamedElement;
import dev.jstanger.language.psi.CornTypes;
import dev.jstanger.language.psi.CornValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CornNamedElementImpl extends ASTWrapperPsiElement implements CornNamedElement {
    public CornNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public @Nullable PsiElement getNameIdentifier() {
        return null;
    }

    @Override
    public PsiElement setName(@NlsSafe @NotNull String name) throws IncorrectOperationException {
        return null;
    }
}
