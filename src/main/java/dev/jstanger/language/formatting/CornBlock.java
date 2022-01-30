package dev.jstanger.language.formatting;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.TokenType;
import com.intellij.psi.formatter.common.AbstractBlock;
import com.intellij.psi.tree.IElementType;
import dev.jstanger.language.psi.CornFile;
import dev.jstanger.language.psi.CornTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CornBlock extends AbstractBlock {
    private final SpacingBuilder spacingBuilder;

    protected CornBlock(@NotNull ASTNode node, @Nullable Wrap wrap, @Nullable Alignment alignment, SpacingBuilder spacingBuilder) {
        super(node, wrap, alignment);
        this.spacingBuilder = spacingBuilder;
    }

    @Override
    protected List<Block> buildChildren() {
        List<Block> blocks = new ArrayList<>();
        ASTNode child = myNode.getFirstChildNode();
        while (child != null) {
            IElementType childType = child.getElementType();
            if (childType != TokenType.WHITE_SPACE) {
                Wrap wrap = childType == CornTypes.PAIR ?
                        Wrap.createWrap(WrapType.ALWAYS, false) :
                        Wrap.createWrap(WrapType.NONE, false);

                Block block = new CornBlock(child, wrap, null, spacingBuilder);
                blocks.add(block);
            }
            child = child.getTreeNext();
        }
        return blocks;
    }

    @Override
    public Indent getIndent() {
        ASTNode parent = myNode.getTreeParent();
        if (parent == null) {
            return Indent.getSmartIndent(Indent.Type.CONTINUATION);
        }

        IElementType type = myNode.getElementType();

        if (type == CornTypes.ASSIGNMENT || type == CornTypes.PAIR || type == CornTypes.COMMENT) {
            return Indent.getNormalIndent();
        }

//        if()

        return Indent.getNoneIndent();

//        if (parent.getPsi() instanceof CornFile || type == CornTypes.RIGHT_BRACE || type == CornTypes.LEFT_BRACE) {
//            return Indent.getNoneIndent();
//        }
//
////        IElementType parentType = parent.getElementType();
////        if(parentType instanceof CornFile)
//        return Indent.getNormalIndent();
    }

    @Override
    public @Nullable Spacing getSpacing(@Nullable Block child1, @NotNull Block child2) {
        return spacingBuilder.getSpacing(this, child1, child2);
    }

    @Override
    public boolean isLeaf() {
        return myNode.getFirstChildNode() == null;
    }
}
