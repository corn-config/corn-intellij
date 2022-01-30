// This is a generated file. Not intended for manual editing.
package dev.jstanger.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.util.IncorrectOperationException;

public interface CornInput extends CornNamedElement {

  @NotNull
  PsiElement getInputToken();

  String getName();

  PsiElement setName(@NlsSafe @NotNull String name) throws IncorrectOperationException;

  @Nullable PsiElement getNameIdentifier();

  ItemPresentation getPresentation();

}
