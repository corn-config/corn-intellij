// This is a generated file. Not intended for manual editing.
package dev.jstanger.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.navigation.ItemPresentation;

public interface CornAssignBlock extends PsiElement {

  @NotNull
  List<CornAssignment> getAssignmentList();

  ItemPresentation getPresentation();

}
