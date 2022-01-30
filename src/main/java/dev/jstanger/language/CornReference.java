package dev.jstanger.language;

import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import dev.jstanger.language.psi.CornInput;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CornReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {
    private final String key;

    public CornReference(@NotNull PsiElement element, TextRange textRange) {
        super(element, textRange);
        key = element.getText().substring(textRange.getStartOffset(), textRange.getEndOffset());
    }

    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        System.out.println("Multi resolve??");

        Project project = myElement.getProject();
        final List<CornInput> inputs = CornUtil.findInputs(project, key, true);

        List<ResolveResult> results = new ArrayList<>();
        for (CornInput input : inputs) {
            results.add(new PsiElementResolveResult(input));
        }

        return results.toArray(new ResolveResult[results.size()]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        System.out.println("Resolve??");

        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }

    @Override
    public Object @NotNull [] getVariants() {
        System.out.println("Get variants??");

        Project project = myElement.getProject();
        final List<CornInput> inputs = CornUtil.findInputs(project, null, true);
        List<LookupElement> variants = new ArrayList<>();

        for (CornInput input : inputs) {
            variants.add(LookupElementBuilder.create(input)
                    .withIcon(CornIcons.FILE)
                    .withTypeText(input.getContainingFile().getName())
            );
        }

        return variants.toArray();
    }
}
