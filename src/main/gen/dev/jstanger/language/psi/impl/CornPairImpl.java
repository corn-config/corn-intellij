// This is a generated file. Not intended for manual editing.
package dev.jstanger.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static dev.jstanger.language.psi.CornTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import dev.jstanger.language.psi.*;
import com.intellij.navigation.ItemPresentation;

public class CornPairImpl extends ASTWrapperPsiElement implements CornPair {

  public CornPairImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CornVisitor visitor) {
    visitor.visitPair(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CornVisitor) accept((CornVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public CornPath getPath() {
    return findNotNullChildByClass(CornPath.class);
  }

  @Override
  @Nullable
  public CornValue getValue() {
    return findChildByClass(CornValue.class);
  }

  @Override
  public String getName() {
    return CornPsiImplUtil.getName(this);
  }

  @Override
  public ItemPresentation getPresentation() {
    return CornPsiImplUtil.getPresentation(this);
  }

}
