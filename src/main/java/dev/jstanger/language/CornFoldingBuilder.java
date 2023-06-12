package dev.jstanger.language;

import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilderEx;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import dev.jstanger.language.psi.CornArray;
import dev.jstanger.language.psi.CornAssignBlock;
import dev.jstanger.language.psi.CornObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CornFoldingBuilder extends FoldingBuilderEx implements DumbAware {
    @Override
    public FoldingDescriptor @NotNull [] buildFoldRegions(@NotNull PsiElement root, @NotNull Document document, boolean quick) {
        List<FoldingDescriptor> descriptors = new ArrayList<>();

        Collection<PsiElement> blocks = PsiTreeUtil.findChildrenOfAnyType(root, CornObject.class, CornArray.class);

        for (PsiElement block : blocks) {
            TextRange textRange = block.getTextRange();
            if (textRange.getEndOffset() - 1 > textRange.getStartOffset() + 1)
                descriptors.add(new FoldingDescriptor(block.getNode(), new TextRange(textRange.getStartOffset() + 1, textRange.getEndOffset() - 1)));
        }

        PsiElement assignBlock = PsiTreeUtil.findChildOfType(root, CornAssignBlock.class);

        if (assignBlock != null) {
            String blockText = assignBlock.getText();
            descriptors.add(new FoldingDescriptor(assignBlock.getNode(), new TextRange(blockText.indexOf('{') + 1, blockText.lastIndexOf('}'))));
        }

        return descriptors.toArray(new FoldingDescriptor[0]);
    }

    @Override
    public @Nullable String getPlaceholderText(@NotNull ASTNode node) {
        return "...";
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return false;
    }
}
