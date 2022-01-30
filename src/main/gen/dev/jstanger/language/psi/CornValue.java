// This is a generated file. Not intended for manual editing.
package dev.jstanger.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;

public interface CornValue extends PsiElement {

  @Nullable
  CornArray getArray();

  @Nullable
  CornBoolean getBoolean();

  @Nullable
  CornInput getInput();

  @Nullable
  CornObject getObject();

  @Nullable
  PsiElement getFloat();

  @Nullable
  PsiElement getInteger();

  @Nullable
  PsiElement getString();

  String getName();

  ItemPresentation getPresentation();

}
