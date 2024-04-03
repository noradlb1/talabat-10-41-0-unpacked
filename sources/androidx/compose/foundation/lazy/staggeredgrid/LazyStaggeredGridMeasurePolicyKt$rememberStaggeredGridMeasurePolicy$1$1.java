package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1 extends Lambda implements Function2<LazyLayoutMeasureScope, Constraints, LazyStaggeredGridMeasureResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Orientation f3152g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Density, Constraints, int[]> f3153h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LazyStaggeredGridState f3154i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f3155j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f3156k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Vertical f3157l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Horizontal f3158m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ LazyLayoutItemProvider f3159n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ OverscrollEffect f3160o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyStaggeredGridMeasurePolicyKt$rememberStaggeredGridMeasurePolicy$1$1(Orientation orientation, Function2<? super Density, ? super Constraints, int[]> function2, LazyStaggeredGridState lazyStaggeredGridState, PaddingValues paddingValues, boolean z11, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, LazyLayoutItemProvider lazyLayoutItemProvider, OverscrollEffect overscrollEffect) {
        super(2);
        this.f3152g = orientation;
        this.f3153h = function2;
        this.f3154i = lazyStaggeredGridState;
        this.f3155j = paddingValues;
        this.f3156k = z11;
        this.f3157l = vertical;
        this.f3158m = horizontal;
        this.f3159n = lazyLayoutItemProvider;
        this.f3160o = overscrollEffect;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m776invoke0kLqBqw((LazyLayoutMeasureScope) obj, ((Constraints) obj2).m5428unboximpl());
    }

    @NotNull
    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final LazyStaggeredGridMeasureResult m776invoke0kLqBqw(@NotNull LazyLayoutMeasureScope lazyLayoutMeasureScope, long j11) {
        boolean z11;
        int i11;
        long j12;
        float f11;
        float f12;
        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
        long j13 = j11;
        Intrinsics.checkNotNullParameter(lazyLayoutMeasureScope2, "$this$null");
        CheckScrollableContainerConstraintsKt.m192checkScrollableContainerConstraintsK40F9xA(j13, this.f3152g);
        int[] invoke = this.f3153h.invoke(lazyLayoutMeasureScope2, Constraints.m5410boximpl(j11));
        boolean z12 = true;
        if (this.f3152g == Orientation.Vertical) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.f3154i.setLaneWidthsPrefixSum$foundation_release(invoke);
        this.f3154i.setVertical$foundation_release(z11);
        int r13 = lazyLayoutMeasureScope2.m5441roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.beforePadding(this.f3155j, this.f3152g, this.f3156k, lazyLayoutMeasureScope.getLayoutDirection()));
        int r14 = lazyLayoutMeasureScope2.m5441roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.afterPadding(this.f3155j, this.f3152g, this.f3156k, lazyLayoutMeasureScope.getLayoutDirection()));
        int r42 = lazyLayoutMeasureScope2.m5441roundToPx0680j_4(LazyStaggeredGridMeasurePolicyKt.startPadding(this.f3155j, this.f3152g, lazyLayoutMeasureScope.getLayoutDirection()));
        if (z11) {
            i11 = Constraints.m5421getMaxHeightimpl(j11);
        } else {
            i11 = Constraints.m5422getMaxWidthimpl(j11);
        }
        int i12 = (i11 - r13) - r14;
        if (z11) {
            j12 = IntOffsetKt.IntOffset(r42, r13);
        } else {
            j12 = IntOffsetKt.IntOffset(r13, r42);
        }
        long j14 = j12;
        if (z11) {
            f11 = this.f3157l.m423getSpacingD9Ej5fM();
        } else {
            f11 = this.f3158m.m409getSpacingD9Ej5fM();
        }
        int r19 = lazyLayoutMeasureScope2.m5441roundToPx0680j_4(f11);
        if (z11) {
            f12 = this.f3158m.m409getSpacingD9Ej5fM();
        } else {
            f12 = this.f3157l.m423getSpacingD9Ej5fM();
        }
        int r202 = lazyLayoutMeasureScope2.m5441roundToPx0680j_4(f12);
        PaddingValues paddingValues = this.f3155j;
        int r43 = lazyLayoutMeasureScope2.m5441roundToPx0680j_4(Dp.m5478constructorimpl(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()) + PaddingKt.calculateEndPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection())));
        PaddingValues paddingValues2 = this.f3155j;
        int r52 = lazyLayoutMeasureScope2.m5441roundToPx0680j_4(Dp.m5478constructorimpl(paddingValues2.m499calculateTopPaddingD9Ej5fM() + paddingValues2.m496calculateBottomPaddingD9Ej5fM()));
        LazyStaggeredGridMeasureResult r12 = LazyStaggeredGridMeasureKt.m775measureStaggeredGridyR9pz_M(lazyLayoutMeasureScope, this.f3154i, this.f3159n, invoke, Constraints.m5413copyZbe2FdA$default(j11, ConstraintsKt.m5436constrainWidthK40F9xA(j13, r43), 0, ConstraintsKt.m5435constrainHeightK40F9xA(j13, r52), 0, 10, (Object) null), z11, j14, i12, r19, r202, r13, r14);
        LazyStaggeredGridState lazyStaggeredGridState = this.f3154i;
        OverscrollEffect overscrollEffect = this.f3160o;
        lazyStaggeredGridState.applyMeasureResult$foundation_release(r12);
        if (!r12.getCanScrollForward() && !r12.getCanScrollBackward()) {
            z12 = false;
        }
        overscrollEffect.setEnabled(z12);
        return r12;
    }
}
