package dev.jstanger.language.structure;

import com.intellij.icons.AllIcons;
import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import dev.jstanger.language.psi.*;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CornStructureViewTreeElement implements StructureViewTreeElement {

    private final NavigatablePsiElement myElement;

    public CornStructureViewTreeElement(NavigatablePsiElement element) {
        this.myElement = element;

    }

    @Override
    public Object getValue() {
        return myElement;
    }

    @Override
    public void navigate(boolean requestFocus) {
        myElement.navigate(requestFocus);
    }

    @Override
    public boolean canNavigate() {
        return myElement.canNavigate();
    }

    @Override
    public boolean canNavigateToSource() {
        return myElement.canNavigateToSource();
    }

    @NotNull
    @Override
    public ItemPresentation getPresentation() {
        ItemPresentation presentation = myElement.getPresentation();

        if (presentation == null) {
            presentation = new PresentationData();
        }

        if (myElement instanceof CornObject && myElement.getParent() instanceof CornFile) {
            return new PresentationData("Top object", presentation.getLocationString(), AllIcons.Json.Object, null);
        }

        if (myElement instanceof CornAssignment) {
            return new PresentationData(((CornAssignment) myElement).getInputName(), ((CornAssignment) myElement).getValue().getName(), AllIcons.Nodes.Constant, null);
        }

        if (myElement instanceof CornPath) {
            CornValue value = ((CornPair) myElement.getParent()).getValue();
            String locationString = value != null && value.getObject() == null && value.getArray() == null ? value.getName() : "";
            Icon icon = null;
            if (value != null && value.getObject() != null) {
                icon = AllIcons.Json.Object;
            } else if (value != null && value.getArray() != null) {
                icon = AllIcons.Json.Array;
            } else if (value != null) {
                icon = AllIcons.Nodes.Property;
            }
            return new PresentationData(presentation.getPresentableText(), locationString, icon, null);
        }

        if(myElement instanceof CornValue) {
            CornValue value = (CornValue) myElement;
            String locationString = value.getObject() == null && value.getArray() == null ? value.getName() : "";
            Icon icon;
            if (value.getObject() != null) {
                icon = AllIcons.Json.Object;
            } else if (value.getArray() != null) {
                icon = AllIcons.Json.Array;
            } else {
                icon = AllIcons.Nodes.Property;
            }
            return new PresentationData(presentation.getPresentableText(), locationString, icon, null);
        }

        return presentation;
    }

    @Override
    public TreeElement @NotNull [] getChildren() {
        NavigatablePsiElement element = myElement;

        if (element instanceof CornPath) {
            CornValue value = ((CornPair) element.getParent()).getValue();

            if (value == null) {
                return EMPTY_ARRAY;
            }

            if (value.getArray() != null) {
                element = (NavigatablePsiElement) value.getArray();
            } else if (value.getObject() != null) {
                element = (NavigatablePsiElement) value.getObject();
            }
        }

        if (element instanceof CornValue) {
            CornValue value = (CornValue) element;
            if (value.getArray() != null) {
                element = (NavigatablePsiElement) value.getArray();
            } else if (value.getObject() != null) {
                element = (NavigatablePsiElement) value.getObject();
            }
        }

        if (element instanceof CornFile) {
            List<TreeElement> treeElements = new ArrayList<>();

            CornAssignBlock assignBlock = PsiTreeUtil.getChildOfType(element, CornAssignBlock.class);
            CornObject topObject = PsiTreeUtil.getChildOfType(element, CornObject.class);

            if (assignBlock != null) {
                treeElements.add(createChild(assignBlock));
            }
            if (topObject != null) {
                treeElements.add(createChild(topObject));
            }

            return treeElements.toArray(new TreeElement[treeElements.size()]);
        }

        if (element instanceof CornAssignBlock) {
            List<CornAssignment> assignments = ((CornAssignBlock) element).getAssignmentList();
            List<TreeElement> treeElements = new ArrayList<>(assignments.size());

            for (CornAssignment assignment : assignments) {
                treeElements.add(createChild(assignment));
            }

            return treeElements.toArray(new TreeElement[0]);
        }

        if (element instanceof CornObject) {
            List<CornPair> pairs = ((CornObject) element).getPairList();
            List<TreeElement> treeElements = new ArrayList<>(pairs.size());

            for (CornPair pair : pairs) {
                treeElements.add(createChild(pair.getPath()));
            }

            return treeElements.toArray(new TreeElement[0]);
        }

        if (element instanceof CornArray) {
            List<CornValue> values = ((CornArray) element).getValueList();
            List<TreeElement> treeElements = new ArrayList<>(values.size());

            for (CornValue value : values) {
                treeElements.add(createChild(value));
            }

            return treeElements.toArray(new TreeElement[0]);
        }

        return EMPTY_ARRAY;
    }

    protected CornStructureViewTreeElement createChild(final PsiElement element) {
        return new CornStructureViewTreeElement((NavigatablePsiElement) element);
    }
}
