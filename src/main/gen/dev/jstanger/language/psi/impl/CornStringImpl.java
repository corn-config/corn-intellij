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

public class CornStringImpl extends ASTWrapperPsiElement implements CornString {

  public CornStringImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CornVisitor visitor) {
    visitor.visitString(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CornVisitor) accept((CornVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<CornInput> getInputList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CornInput.class);
  }

}
