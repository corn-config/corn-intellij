package dev.jstanger.language.formatting;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.TokenType;
import com.intellij.psi.formatter.common.AbstractBlock;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CornBlock extends AbstractBlock {
    private final CornFormatter formatter;
    private final CornFormatter.WrapCache wrapCache;
    private final CornFormatter.AlignmentCache alignmentCache;
    private final Indent indent;

    protected CornBlock(CornFormatter formatter, @NotNull ASTNode node, @Nullable Indent indent, @Nullable Wrap wrap, @Nullable Alignment alignment) {
        super(node, wrap, alignment);

        this.formatter = formatter;

        this.indent = indent;

        this.wrapCache = formatter.createWrapCache();
        this.alignmentCache = formatter.createAlignmentCache();
    }

    @Override
    protected List<Block> buildChildren() {
        List<Block> blocks = new ArrayList<>();
        ASTNode child = myNode.getFirstChildNode();
        while (child != null) {
            IElementType childType = child.getElementType();
            if (childType != TokenType.WHITE_SPACE) {
                blocks.add(createChildBlock(child));
            }
            child = child.getTreeNext();
        }
        return blocks;
    }

    @Override
    public Indent getIndent() {
        return indent;
    }

    @Override
    public @NotNull ChildAttributes getChildAttributes(int newChildIndex) {
        return new ChildAttributes(formatter.getChildIndent(myNode), formatter.getChildAlignment(alignmentCache, myNode));
    }

    @Override
    public @Nullable Spacing getSpacing(@Nullable Block child1, @NotNull Block child2) {
        return formatter.getSpacing(this, child1, child2);
    }

    @Override
    public boolean isLeaf() {
        return myNode.getFirstChildNode() == null;
    }

    private CornBlock createChildBlock(ASTNode child) {
        return new CornBlock(formatter, child,
                formatter.getIndent(myNode, child),
                formatter.getWrap(wrapCache, myNode, child),
                formatter.getAlignment(alignmentCache, myNode, child)
        );
    }
}
