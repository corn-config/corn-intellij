// This is a generated file. Not intended for manual editing.
package dev.jstanger.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;

public interface CornInput extends CornNamedElement {

  @NotNull
  PsiElement getInputToken();

  String getName();

  @Nullable PsiElement getNameIdentifier();

  ItemPresentation getPresentation();

}
