package dev.jstanger.language.structure;

import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.StructureViewModelBase;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.psi.PsiFile;

public class CornStructureViewModel extends StructureViewModelBase implements StructureViewModel.ElementInfoProvider {

    public CornStructureViewModel(PsiFile psiFile) {
        super(psiFile, new CornStructureViewTreeElement(psiFile));
    }

//    @NotNull
//    public Sorter @NotNull [] getSorters() {
//        return new Sorter[]{Sorter.ALPHA_SORTER};
//    }

    @Override
    public boolean isAlwaysShowsPlus(StructureViewTreeElement element) {
        return false;
    }

    @Override
    public boolean isAlwaysLeaf(StructureViewTreeElement element) {
//        Object value = element.getValue();
//        return value instanceof CornObject || value instanceof CornArray || value instanceof CornAssignBlock;
        return false;
    }
}
