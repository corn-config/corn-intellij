package dev.jstanger.language.formatting;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.tree.IElementType;
import dev.jstanger.language.CornLanguage;
import dev.jstanger.language.codeStyle.CornCodeStyleSettings;
import dev.jstanger.language.psi.CornTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CornFormatter {
    private final @NotNull CommonCodeStyleSettings commonSettings;
    private final CornCodeStyleSettings customSettings;
    private final SpacingBuilder spacingBuilder;

    CornFormatter(CodeStyleSettings settings, SpacingBuilder spacingBuilder) {
        this.commonSettings = settings.getCommonSettings(CornLanguage.INSTANCE);
        this.customSettings = settings.getCustomSettings(CornCodeStyleSettings.class);

        this.spacingBuilder = spacingBuilder;
    }

    public @Nullable Spacing getSpacing(Block parent, @Nullable Block child1, @NotNull Block child2) {
        return spacingBuilder.getSpacing(parent, child1, child2);
    }

    public Indent getIndent(ASTNode parent, ASTNode child) {
        IElementType parentType = parent.getElementType();
        IElementType childType = child.getElementType();

        if ((parentType == CornTypes.OBJECT && (childType == CornTypes.PAIR || childType == CornTypes.COMMENT))
                || parentType == CornTypes.ARRAY
                || (parentType == CornTypes.ASSIGN_BLOCK && (childType == CornTypes.ASSIGNMENT || childType == CornTypes.COMMENT))) {
            return Indent.getNormalIndent();
        }

        return Indent.getNoneIndent();
    }

    public Wrap getWrap(WrapCache wrapCache, ASTNode parent, ASTNode child) {
        IElementType parentType = parent.getElementType();
        IElementType childType = child.getElementType();

        if ((parentType == CornTypes.OBJECT && childType == CornTypes.PAIR)
                || (parentType == CornTypes.ASSIGN_BLOCK && childType == CornTypes.ASSIGNMENT)) {
            return wrapCache.objectEntryWrap;
        }
        if (parentType == CornTypes.ARRAY && childType == CornTypes.VALUE) {
            return wrapCache.arrayEntryMap;
        }
        if ((parentType == CornTypes.PAIR && childType == CornTypes.OP_EQ)
                || (parentType == CornTypes.ASSIGNMENT && childType == CornTypes.OP_EQ)) {
            return wrapCache.keyValueSeparatorWrap;
        }
        if ((parentType == CornTypes.PAIR && childType == CornTypes.VALUE)
                || (parentType == CornTypes.ASSIGNMENT && childType == CornTypes.VALUE)) {
            return wrapCache.fieldValueWrap;
        }

        return null;
    }

    public Alignment getAlignment(AlignmentCache alignmentCache, ASTNode parent, ASTNode child) {
        IElementType parentType = parent.getElementType();
        IElementType childType = child.getElementType();

        if ((parentType == CornTypes.OBJECT && childType == CornTypes.PAIR)
                || (parentType == CornTypes.ASSIGN_BLOCK && childType == CornTypes.ASSIGNMENT)) {
            return alignmentCache.objectEntryAlignment;
        }

        if (parentType == CornTypes.ARRAY) {
            return alignmentCache.arrayEntryAlignment;
        }

        return null;
    }

    public Indent getChildIndent(ASTNode parent) {
        IElementType parentType = parent.getElementType();

        if (parentType == CornTypes.OBJECT || parentType == CornTypes.ARRAY || parentType == CornTypes.ASSIGN_BLOCK) {
            return Indent.getNormalIndent();
        }
        if (parentType == CornTypes.PAIR || parentType == CornTypes.ASSIGNMENT) {
            return Indent.getContinuationIndent();
        }

        return Indent.getNoneIndent();
    }

    public Alignment getChildAlignment(AlignmentCache alignmentCache, ASTNode parent) {
        IElementType parentType = parent.getElementType();

        if (parentType == CornTypes.OBJECT || parentType == CornTypes.ASSIGN_BLOCK) {
            return alignmentCache.objectEntryAlignment;
        }

        if (parentType == CornTypes.ARRAY) {
            return alignmentCache.arrayEntryAlignment;
        }

        return null;
    }

    public WrapCache createWrapCache() {
        return new WrapCache();
    }

    public AlignmentCache createAlignmentCache() {
        return new AlignmentCache();
    }


    class WrapCache {
        Wrap objectEntryWrap = Wrap.createWrap(customSettings.OBJECTS_WRAP, false);
        Wrap arrayEntryMap = Wrap.createWrap(customSettings.ARRAYS_WRAP, false);

        Wrap fieldInnerWrap = Wrap.createWrap(customSettings.OBJECT_FIELDS_WRAP, true);
        Wrap keyValueSeparatorWrap = customSettings.OBJECT_FIELDS_ASSIGNMENT_ON_NEXT_LINE ? fieldInnerWrap : null;

        Wrap fieldValueWrap = keyValueSeparatorWrap == null ? fieldInnerWrap : null;
    }

    class AlignmentCache {
        Alignment objectEntryAlignment = customSettings.OBJECTS_ALIGN_WHEN_MULTILINE ? Alignment.createAlignment() : null;
        Alignment arrayEntryAlignment = customSettings.ARRAYS_ALIGN_WHEN_MULTILINE ? Alignment.createAlignment() : null;
    }
}


