package dev.jstanger.language;

public class CornLexerAdapter extends com.intellij.lexer.FlexAdapter {
    public CornLexerAdapter() {
       super(new CornLexer(null));
    }
}
