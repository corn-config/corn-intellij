package dev.jstanger.language.formatting;

import com.intellij.formatting.*;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import dev.jstanger.language.CornLanguage;
import dev.jstanger.language.psi.CornTypes;
import org.jetbrains.annotations.NotNull;

public class CornFormattingModelBuilder implements FormattingModelBuilder {

    private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
        return new SpacingBuilder(settings, CornLanguage.INSTANCE)
                .around(CornTypes.OP_EQ).spaceIf(settings.getCommonSettings(CornLanguage.INSTANCE.getID()).SPACE_AROUND_ASSIGNMENT_OPERATORS);
    }

    @Override
    public @NotNull FormattingModel createModel(@NotNull FormattingContext formattingContext) {
        final CodeStyleSettings codeStyleSettings = formattingContext.getCodeStyleSettings();
        SpacingBuilder spacingBuilder = createSpaceBuilder(codeStyleSettings);
        CornFormatter formatter = new CornFormatter(codeStyleSettings, spacingBuilder);

        CornBlock rootBlock = new CornBlock(
                formatter,
                formattingContext.getNode(),
                null, null, null
        );

        return FormattingModelProvider
                .createFormattingModelForPsiFile(formattingContext.getContainingFile(), rootBlock, codeStyleSettings);
    }
}
