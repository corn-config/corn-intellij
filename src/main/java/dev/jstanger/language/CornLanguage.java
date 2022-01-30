package dev.jstanger.language;

import com.intellij.lang.Language;

public class CornLanguage extends Language {
    public static final CornLanguage INSTANCE = new CornLanguage();

    private CornLanguage() {
        super("Corn");
    }
}
