package dev.jstanger.language.codeStyle;

import com.intellij.lang.Language;
import com.intellij.psi.codeStyle.CodeStyleSettingsCustomizable;
import com.intellij.psi.codeStyle.CodeStyleSettingsCustomizableOptions;
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider;
import dev.jstanger.language.CornLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.intellij.psi.codeStyle.CodeStyleSettingsCustomizable.WRAP_VALUES;

public class CornLanguageCodeStyleSettingsProvider extends LanguageCodeStyleSettingsProvider {
    @Override
    public @NotNull Language getLanguage() {
        return CornLanguage.INSTANCE;
    }

    @Override
    public void customizeSettings(@NotNull CodeStyleSettingsCustomizable consumer, @NotNull SettingsType settingsType) {
        CodeStyleSettingsCustomizableOptions customizableOptions = CodeStyleSettingsCustomizableOptions.getInstance();

        switch (settingsType) {
            case SPACING_SETTINGS: {
                consumer.showStandardOptions("SPACE_AROUND_ASSIGNMENT_OPERATORS");
                consumer.renameStandardOption("SPACE_AROUND_ASSIGNMENT_OPERATORS", "Assignment operator");

                break;
            }
            case WRAPPING_AND_BRACES_SETTINGS:
                consumer.showCustomOption(CornCodeStyleSettings.class, "OBJECTS_WRAP", "Objects", "Objects", customizableOptions.WRAP_OPTIONS, WRAP_VALUES);
                consumer.showCustomOption(CornCodeStyleSettings.class, "OBJECTS_ALIGN_WHEN_MULTILINE", "Align when multiline", "Objects");
                consumer.showCustomOption(CornCodeStyleSettings.class, "OBJECT_FIELDS_WRAP", "Fields", "Objects", customizableOptions.WRAP_OPTIONS, WRAP_VALUES);
                consumer.showCustomOption(CornCodeStyleSettings.class, "OBJECT_FIELDS_ASSIGNMENT_ON_NEXT_LINE", "Align fields when multiline", "Objects");

                consumer.showCustomOption(CornCodeStyleSettings.class, "ARRAYS_WRAP", "Arrays", "Arrays", customizableOptions.WRAP_OPTIONS, WRAP_VALUES);
                consumer.showCustomOption(CornCodeStyleSettings.class, "ARRAYS_ALIGN_WHEN_MULTILINE", "Align when multiline", "Arrays");

                break;
        }
    }

    @Override
    public @Nullable String getCodeSample(@NotNull SettingsType settingsType) {
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
