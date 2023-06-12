package dev.jstanger.language.psi.impl;

import com.intellij.icons.AllIcons;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import dev.jstanger.language.CornIcons;
import dev.jstanger.language.psi.*;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class CornPsiImplUtil {
    public static String getInputName(CornAssignment element) {
        ASTNode inputNode = element.getNode().findChildByType(CornTypes.INPUT);
        if(inputNode != null) {
            return ((CornInput)inputNode.getPsi()).getName();
        } else {
            return null;
        }
    }

    public static String getInputName(CornValue element) {
        ASTNode inputNode = element.getNode().findChildByType(CornTypes.INPUT);
        if(inputNode != null) {
            return ((CornInput)inputNode.getPsi()).getName();
        } else {
            return null;
        }
    }

    public static String getName(CornInput element) {
        return element.getInputToken().getText();
    }

    public static PsiElement setName(CornInput element, String newName) {
        Project project = ProjectManager.getInstance().getOpenProjects()[0];
        CornInputImpl input = (CornInputImpl)CornElementFactory.createInput(project, newName);
        element.replace(input);
        return element;
    }

    public static PsiElement getNameIdentifier(CornInput element) {
        return element.getInputToken();
    }

    public static PsiElement handleElementRename(CornInput element, String newName) {
        System.out.println("Triggering rename");
        return setName(element, newName);
    }

    public static String getName(CornPair element) {
        return element.getText();
    }

    public static ItemPresentation getPresentation(final CornPair element) {
        return new ItemPresentation() {
            @Override
            public @NlsSafe @Nullable String getPresentableText() {
                return element.getName();
            }

            @Override
            public Icon getIcon(boolean unused) {
                return CornIcons.FILE;
            }

            @Nullable
            @Override
            public String getLocationString() {
                PsiFile containingFile = element.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }
        };
    }

    public static String getName(CornValue element) {
        return element.getText();
    }

    public static ItemPresentation getPresentation(final CornValue element) {
        return new ItemPresentation() {
            @Override
            public @NlsSafe @Nullable String getPresentableText() {
                return element.getName();
            }

            @Override
            public Icon getIcon(boolean unused) {
                return CornIcons.FILE;
            }

            @Nullable
            @Override
            public String getLocationString() {
                PsiFile containingFile = element.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }
        };
    }

    public static ItemPresentation getPresentation(final CornInput element) {
        return new ItemPresentation() {
            @Override
            public @NlsSafe @Nullable String getPresentableText() {
                return element.getName();
            }

            @Override
            public Icon getIcon(boolean unused) {
                return CornIcons.FILE;
            }

            @Nullable
            @Override
            public String getLocationString() {
                PsiFile containingFile = element.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }
        };
    }

    public static String getName(CornPath element) {
        return element.getText();
    }

    public static ItemPresentation getPresentation(final CornPath element) {
        return new ItemPresentation() {
            @Override
            public @NlsSafe @Nullable String getPresentableText() {
                return element.getName();
            }

            @Override
            public Icon getIcon(boolean unused) {
                return CornIcons.FILE;
            }

            @Nullable
            @Override
            public String getLocationString() {
                PsiFile containingFile = element.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }
        };
    }

    public static ItemPresentation getPresentation(final CornAssignBlock element) {
        return new ItemPresentation() {
            @Override
            public @NlsSafe String getPresentableText() {
                return "Input block";
            }

            @Override
            public Icon getIcon(boolean unused) {
                return AllIcons.Json.Object;
            }

            @Nullable
            @Override
            public String getLocationString() {
                PsiFile containingFile = element.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }
        };
    }
}
