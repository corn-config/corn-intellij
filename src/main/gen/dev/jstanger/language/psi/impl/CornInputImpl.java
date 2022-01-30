// This is a generated file. Not intended for manual editing.
package dev.jstanger.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static dev.jstanger.language.psi.CornTypes.*;
import dev.jstanger.language.psi.*;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.util.IncorrectOperationException;

public class CornInputImpl extends CornNamedElementImpl implements CornInput {

  public CornInputImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CornVisitor visitor) {
    visitor.visitInput(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CornVisitor) accept((CornVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getInputToken() {
    return findNotNullChildByType(INPUT_TOKEN);
  }

  @Override
  public String getName() {
    return CornPsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return CornPsiImplUtil.setName(this, newName);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return CornPsiImplUtil.getNameIdentifier(this);
  }

  @Override
  public ItemPresentation getPresentation() {
    return CornPsiImplUtil.getPresentation(this);
  }

}
