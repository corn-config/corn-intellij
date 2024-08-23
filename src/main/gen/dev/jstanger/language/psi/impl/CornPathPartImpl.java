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

public class CornPathPartImpl extends ASTWrapperPsiElement implements CornPathPart {

  public CornPathPartImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CornVisitor visitor) {
    visitor.visitPathPart(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CornVisitor) accept((CornVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public CornQuotedPathSeg getQuotedPathSeg() {
    return findChildByClass(CornQuotedPathSeg.class);
  }

  @Override
  @Nullable
  public PsiElement getPathSeg() {
    return findChildByType(PATH_SEG);
  }

}
