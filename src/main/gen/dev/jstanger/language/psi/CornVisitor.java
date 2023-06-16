// This is a generated file. Not intended for manual editing.
package dev.jstanger.language.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class CornVisitor extends PsiElementVisitor {

  public void visitArray(@NotNull CornArray o) {
    visitPsiElement(o);
  }

  public void visitArrayValue(@NotNull CornArrayValue o) {
    visitPsiElement(o);
  }

  public void visitAssignBlock(@NotNull CornAssignBlock o) {
    visitPsiElement(o);
  }

  public void visitAssignment(@NotNull CornAssignment o) {
    visitPsiElement(o);
  }

  public void visitBoolean(@NotNull CornBoolean o) {
    visitPsiElement(o);
  }

  public void visitInput(@NotNull CornInput o) {
    visitNamedElement(o);
  }

  public void visitObject(@NotNull CornObject o) {
    visitPsiElement(o);
  }

  public void visitObjectValue(@NotNull CornObjectValue o) {
    visitPsiElement(o);
  }

  public void visitPair(@NotNull CornPair o) {
    visitPsiElement(o);
  }

  public void visitPath(@NotNull CornPath o) {
    visitPsiElement(o);
  }

  public void visitSpread(@NotNull CornSpread o) {
    visitPsiElement(o);
  }

  public void visitString(@NotNull CornString o) {
    visitPsiElement(o);
  }

  public void visitValue(@NotNull CornValue o) {
    visitPsiElement(o);
  }

  public void visitNamedElement(@NotNull CornNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
