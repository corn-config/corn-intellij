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
        return "let {\n" +
                "    $entry = \"dist/index.js\"\n" +
                "    $author = { name = \"John smith\" email = \"mail@example.com\" }\n" +
                "} in {\n" +
                "    name = \"example-package\"\n" +
                "    version = \"1.0.0\"\n" +
                "    main = $entry\n" +
                "    bin.filebrowser = $entry\n" +
                "    private = false\n" +
                "\n" +
                "    author = $author\n" +
                "    author.url = \"https://example.com\"\n" +
                "\n" +
                "    contributors = [ $author ]\n" +
                "\n" +
                "    scripts.build = \"tsc\"\n" +
                "    scripts.run = \"node dist\"\n" +
                "\n" +
                "    dependencies = {\n" +
                "        dotenv = \"^8.2.0\"\n" +
                "        // put the rest of your deps here...\n" +
                "    }\n" +
                "\n" +
                "    devDependencies.typescript = \"^4.5\"\n" +
                "\n" +
                "    config.port = 8080\n" +
                "    config.hostname = null\n" +
                "}";
    }
}
