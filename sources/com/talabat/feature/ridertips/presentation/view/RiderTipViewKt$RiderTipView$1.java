package com.talabat.feature.ridertips.presentation.view;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import com.talabat.feature.ridertips.presentation.displaymodel.RiderTipDisplayModel;
import com.talabat.feature.ridertips.presentation.view.mainview.RiderTipContentViewKt;
import com.talabat.feature.ridertips.presentation.viewmodel.RiderTipViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class RiderTipViewKt$RiderTipView$1 extends Lambda implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ RiderTipDisplayModel f58809g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Double, Unit> f58810h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f58811i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f58812j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ RiderTipViewModel f58813k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RiderTipViewKt$RiderTipView$1(RiderTipDisplayModel riderTipDisplayModel, Function1<? super Double, Unit> function1, Function0<Unit> function0, int i11, RiderTipViewModel riderTipViewModel) {
        super(3);
        this.f58809g = riderTipDisplayModel;
        this.f58810h = function1;
        this.f58811i = function0;
        this.f58812j = i11;
        this.f58813k = riderTipViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((AnimatedVisibilityScope) obj, (Composer) obj2, ((Number) obj3).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@NotNull AnimatedVisibilityScope animatedVisibilityScope, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(animatedVisibilityScope, "$this$AnimatedVisibility");
        RiderTipDisplayModel riderTipDisplayModel = this.f58809g;
        if (riderTipDisplayModel != null) {
            Function1<Double, Unit> function1 = this.f58810h;
            Function0<Unit> function0 = this.f58811i;
            int i12 = this.f58812j;
            RiderTipViewModel riderTipViewModel = this.f58813k;
            if (function1 != null) {
                function1.invoke(riderTipDisplayModel.getTipAmount());
            }
            RiderTipContentViewKt.RiderTipContentView(function0, riderTipDisplayModel, new RiderTipViewKt$RiderTipView$1$1$1(riderTipViewModel), new RiderTipViewKt$RiderTipView$1$1$2(riderTipViewModel), new RiderTipViewKt$RiderTipView$1$1$3(riderTipViewModel), new RiderTipViewKt$RiderTipView$1$1$4(riderTipViewModel), new RiderTipViewKt$RiderTipView$1$1$5(riderTipViewModel), riderTipDisplayModel.isDefaultTipEnabled(), composer, ((i12 >> 3) & 14) | 64);
        }
    }
}
