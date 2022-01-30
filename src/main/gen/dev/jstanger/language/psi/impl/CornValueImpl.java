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

public class CornValueImpl extends ASTWrapperPsiElement implements CornValue {

  public CornValueImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CornVisitor visitor) {
    visitor.visitValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CornVisitor) accept((CornVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public CornArray getArray() {
    return findChildByClass(CornArray.class);
  }

  @Override
  @Nullable
  public CornBoolean getBoolean() {
    return findChildByClass(CornBoolean.class);
  }

  @Override
  @Nullable
  public CornInput getInput() {
    return findChildByClass(CornInput.class);
  }

  @Override
  @Nullable
  public CornObject getObject() {
    return findChildByClass(CornObject.class);
  }

  @Override
  @Nullable
  public PsiElement getFloat() {
    return findChildByType(FLOAT);
  }

  @Override
  @Nullable
  public PsiElement getInteger() {
    return findChildByType(INTEGER);
  }

  @Override
  @Nullable
  public PsiElement getString() {
    return findChildByType(STRING);
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
