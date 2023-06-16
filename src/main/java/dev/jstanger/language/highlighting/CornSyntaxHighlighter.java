package dev.jstanger.language.highlighting;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import dev.jstanger.language.CornLexerAdapter;
import dev.jstanger.language.psi.CornTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class CornSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey COMMENT = createTextAttributesKey("CORN_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey PATH = createTextAttributesKey("CORN_LABEL", DefaultLanguageHighlighterColors.LABEL);
    public static final TextAttributesKey KEYWORD = createTextAttributesKey("CORN_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey NUMBER = createTextAttributesKey("CORN_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey STRING = createTextAttributesKey("CORN_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey INPUT = createTextAttributesKey("CORN_CONSTANT", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey BRACES = createTextAttributesKey("CORN_BRACES", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey BRACKETS = createTextAttributesKey("CORN_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);
    public static final TextAttributesKey DOT = createTextAttributesKey("CORN_DOT", DefaultLanguageHighlighterColors.DOT);
    public static final TextAttributesKey EQUALS = createTextAttributesKey("CORN_OPERATION_SIGN", DefaultLanguageHighlighterColors.OPERATION_SIGN);

    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] PATH_KEYS = new TextAttributesKey[]{PATH};
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] INPUT_KEYS = new TextAttributesKey[]{INPUT};
    private static final TextAttributesKey[] BRACE_KEYS = new TextAttributesKey[]{BRACES};
    private static final TextAttributesKey[] BRACKET_KEYS = new TextAttributesKey[]{BRACKETS};
    private static final TextAttributesKey[] DOT_KEYS = new TextAttributesKey[]{DOT};
    private static final TextAttributesKey[] EQUALS_KEYS = new TextAttributesKey[]{EQUALS};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new CornLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(CornTypes.COMMENT)) {
            return COMMENT_KEYS;
        }
        if (tokenType.equals(CornTypes.TRUE) || tokenType.equals(CornTypes.FALSE) || tokenType.equals(CornTypes.NULL) || tokenType.equals(CornTypes.LET) || tokenType.equals(CornTypes.IN)) {
            return KEYWORD_KEYS;
        }
        if (tokenType.equals(CornTypes.INTEGER) || tokenType.equals(CornTypes.FLOAT)) {
            return NUMBER_KEYS;
        }
        if (tokenType.equals(CornTypes.STRING) || tokenType.equals(CornTypes.CHAR) || tokenType.equals(CornTypes.DOUBLE_QUOTE)) {
            return STRING_KEYS;
        }
        if (tokenType.equals(CornTypes.PATH_SEG)) {
            return PATH_KEYS;
        }
        if (tokenType.equals(CornTypes.INPUT_TOKEN)) {
            return INPUT_KEYS;
        }
        if (tokenType.equals(CornTypes.LEFT_BRACE) || tokenType.equals(CornTypes.RIGHT_BRACE)) {
            return BRACE_KEYS;
        }
        if (tokenType.equals(CornTypes.LEFT_BRACKET) || tokenType.equals(CornTypes.RIGHT_BRACKET)) {
            return BRACKET_KEYS;
        }
        if (tokenType.equals(CornTypes.DOT)) {
            return DOT_KEYS;
        }
        if (tokenType.equals(CornTypes.OP_EQ)) {
            return EQUALS_KEYS;
        }

        return EMPTY_KEYS;
    }
}
