package dev.jstanger.language.highlighting;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.intellij.openapi.util.NlsContexts;
import dev.jstanger.language.CornIcons;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class CornColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Keyword", CornSyntaxHighlighter.KEYWORD),
            new AttributesDescriptor("Comment", CornSyntaxHighlighter.COMMENT),
            new AttributesDescriptor("Path", CornSyntaxHighlighter.PATH),
            new AttributesDescriptor("Input", CornSyntaxHighlighter.INPUT),
            new AttributesDescriptor("Number", CornSyntaxHighlighter.NUMBER),
            new AttributesDescriptor("String", CornSyntaxHighlighter.STRING),
            new AttributesDescriptor("Braces", CornSyntaxHighlighter.BRACES),
            new AttributesDescriptor("Brackets", CornSyntaxHighlighter.BRACKETS),
            new AttributesDescriptor("Dot", CornSyntaxHighlighter.DOT),
            new AttributesDescriptor("Equals", CornSyntaxHighlighter.EQUALS),
    };

    @Override
    public @Nullable Icon getIcon() {
        return CornIcons.FILE;
    }

    @Override
    public @NotNull SyntaxHighlighter getHighlighter() {
        return new CornSyntaxHighlighter();
    }

    @Override
    public @Nullable Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @Override
    public @NotNull @NlsContexts.ConfigurableName String getDisplayName() {
        return "Corn";
    }

    @Override
    public @NonNls @NotNull String getDemoText() {
        return """
                let {
                    $entry = "dist/index.js"
                    $author = { name = "John smith" email = "mail@example.com" }
                } in {
                    name = "example-package"
                    version = "1.0.0"
                    main = $entry
                    bin.filebrowser = $entry
                    private = false

                    author = $author
                    author.url = "https://example.com"

                    contributors = [ $author ]

                    scripts.build = "tsc"
                    scripts.run = "node dist"

                    dependencies = {
                        dotenv = "^8.2.0"
                        // put the rest of your deps here...
                    }

                    devDependencies.typescript = "^4.5"

                    config.port = 8080
                    config.hostname = null
                }""";
    }
}
