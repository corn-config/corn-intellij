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

public class CornObjectImpl extends ASTWrapperPsiElement implements CornObject {

  public CornObjectImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CornVisitor visitor) {
    visitor.visitObject(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CornVisitor) accept((CornVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<CornPair> getPairList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CornPair.class);
  }

}
