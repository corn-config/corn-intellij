// This is a generated file. Not intended for manual editing.
package dev.jstanger.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;

public interface CornPair extends PsiElement {

  @NotNull
  CornPath getPath();

  @NotNull
  CornValue getValue();

  String getName();

  ItemPresentation getPresentation();

}
