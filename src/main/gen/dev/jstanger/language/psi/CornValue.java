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
  CornString getString();

  @Nullable
  PsiElement getFloat();

  @Nullable
  PsiElement getInteger();

  String getName();

  ItemPresentation getPresentation();

}
