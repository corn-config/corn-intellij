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

public class CornQuotedPathSegImpl extends ASTWrapperPsiElement implements CornQuotedPathSeg {

  public CornQuotedPathSegImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CornVisitor visitor) {
    visitor.visitQuotedPathSeg(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CornVisitor) accept((CornVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getQuotedPathSeq() {
    return findNotNullChildByType(QUOTED_PATH_SEQ);
  }

}
