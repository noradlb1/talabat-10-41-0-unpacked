package com.talabat.feature.ridertips.presentation.view.mainview;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.designsystem.ds_theme.DSThemeKt;
import com.talabat.feature.ridertips.presentation.displaymodel.RiderTipDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a¡\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u000526\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0014\u001a\u00020\fH\u0001¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"RiderTipContentView", "", "onInfoClicked", "Lkotlin/Function0;", "displayModel", "Lcom/talabat/feature/ridertips/presentation/displaymodel/RiderTipDisplayModel;", "onTipOptionTap", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "index", "", "selected", "onReuseTipTap", "onTipCustomInputTextChange", "Lkotlin/Function1;", "", "onTipCustomInputCtaTap", "onClearTipTap", "isDefaultTipEnabled", "(Lkotlin/jvm/functions/Function0;Lcom/talabat/feature/ridertips/presentation/displaymodel/RiderTipDisplayModel;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "com_talabat_feature_ridertips_presentation_presentation"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class RiderTipContentViewKt {
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void RiderTipContentView(@NotNull Function0<Unit> function0, @NotNull RiderTipDisplayModel riderTipDisplayModel, @NotNull Function2<? super Integer, ? super Boolean, Unit> function2, @NotNull Function0<Unit> function02, @NotNull Function1<? super String, Unit> function1, @NotNull Function0<Unit> function03, @NotNull Function0<Unit> function04, boolean z11, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(function0, "onInfoClicked");
        Intrinsics.checkNotNullParameter(riderTipDisplayModel, "displayModel");
        Intrinsics.checkNotNullParameter(function2, "onTipOptionTap");
        Intrinsics.checkNotNullParameter(function02, "onReuseTipTap");
        Intrinsics.checkNotNullParameter(function1, "onTipCustomInputTextChange");
        Intrinsics.checkNotNullParameter(function03, "onTipCustomInputCtaTap");
        Function0<Unit> function05 = function04;
        Intrinsics.checkNotNullParameter(function05, "onClearTipTap");
        Composer startRestartGroup = composer.startRestartGroup(-1547111682);
        RiderTipContentViewKt$RiderTipContentView$1 riderTipContentViewKt$RiderTipContentView$1 = r1;
        RiderTipContentViewKt$RiderTipContentView$1 riderTipContentViewKt$RiderTipContentView$12 = new RiderTipContentViewKt$RiderTipContentView$1(riderTipDisplayModel, function0, i11, function1, function03, function2, function02, function05, z11);
        DSThemeKt.DSTheme(ComposableLambdaKt.composableLambda(startRestartGroup, 987524015, true, riderTipContentViewKt$RiderTipContentView$1), startRestartGroup, 6);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new RiderTipContentViewKt$RiderTipContentView$2(function0, riderTipDisplayModel, function2, function02, function1, function03, function04, z11, i11));
        }
    }
}
