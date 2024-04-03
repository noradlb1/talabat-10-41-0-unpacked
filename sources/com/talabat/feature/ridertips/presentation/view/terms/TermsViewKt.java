package com.talabat.feature.ridertips.presentation.view.terms;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.designsystem.ds_theme.DSThemeKt;
import com.talabat.feature.ridertips.presentation.displaymodel.TermsDisplayModel;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"TermsView", "", "terms", "Lcom/talabat/feature/ridertips/presentation/displaymodel/TermsDisplayModel;", "(Lcom/talabat/feature/ridertips/presentation/displaymodel/TermsDisplayModel;Landroidx/compose/runtime/Composer;I)V", "com_talabat_feature_ridertips_presentation_presentation"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TermsViewKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void TermsView(@Nullable TermsDisplayModel termsDisplayModel, @Nullable Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(2036555196);
        if (termsDisplayModel != null) {
            DSThemeKt.DSTheme(ComposableLambdaKt.composableLambda(startRestartGroup, 1185363780, true, new TermsViewKt$TermsView$1$1(termsDisplayModel)), startRestartGroup, 6);
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TermsViewKt$TermsView$2(termsDisplayModel, i11));
        }
    }
}
