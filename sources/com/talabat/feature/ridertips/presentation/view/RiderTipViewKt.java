package com.talabat.feature.ridertips.presentation.view;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.ExperimentalAnimationApi;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.talabat.feature.ridertips.presentation.displaymodel.RiderTipDisplayModel;
import com.talabat.feature.ridertips.presentation.viewmodel.RiderTipViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"RiderTipView", "", "viewModel", "Lcom/talabat/feature/ridertips/presentation/viewmodel/RiderTipViewModel;", "onInfoClicked", "Lkotlin/Function0;", "onRiderTipValueChange", "Lkotlin/Function1;", "", "(Lcom/talabat/feature/ridertips/presentation/viewmodel/RiderTipViewModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "com_talabat_feature_ridertips_presentation_presentation"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class RiderTipViewKt {
    @ExperimentalAnimationApi
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void RiderTipView(@NotNull RiderTipViewModel riderTipViewModel, @NotNull Function0<Unit> function0, @Nullable Function1<? super Double, Unit> function1, @Nullable Composer composer, int i11) {
        boolean z11;
        RiderTipViewModel riderTipViewModel2 = riderTipViewModel;
        Function0<Unit> function02 = function0;
        Intrinsics.checkNotNullParameter(riderTipViewModel2, "viewModel");
        Intrinsics.checkNotNullParameter(function02, "onInfoClicked");
        Composer startRestartGroup = composer.startRestartGroup(-1256445763);
        RiderTipDisplayModel viewState$com_talabat_feature_ridertips_presentation_presentation = riderTipViewModel.getViewState$com_talabat_feature_ridertips_presentation_presentation();
        if (viewState$com_talabat_feature_ridertips_presentation_presentation != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        AnimatedVisibilityKt.AnimatedVisibility(z11, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, (Function3<? super AnimatedVisibilityScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, 1279177957, true, new RiderTipViewKt$RiderTipView$1(viewState$com_talabat_feature_ridertips_presentation_presentation, function1, function0, i11, riderTipViewModel)), startRestartGroup, 196608, 30);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new RiderTipViewKt$RiderTipView$2(riderTipViewModel2, function02, function1, i11));
        }
    }
}
