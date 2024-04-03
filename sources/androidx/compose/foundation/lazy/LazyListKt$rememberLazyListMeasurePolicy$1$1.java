package androidx.compose.foundation.lazy;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyListKt$rememberLazyListMeasurePolicy$1$1 extends Lambda implements Function2<LazyLayoutMeasureScope, Constraints, LazyListMeasureResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f2770g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f2771h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f2772i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ LazyListState f2773j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ LazyListItemProvider f2774k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Vertical f2775l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Horizontal f2776m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ LazyListItemPlacementAnimator f2777n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ LazyListBeyondBoundsInfo f2778o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Alignment.Horizontal f2779p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Alignment.Vertical f2780q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ OverscrollEffect f2781r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyListKt$rememberLazyListMeasurePolicy$1$1(boolean z11, PaddingValues paddingValues, boolean z12, LazyListState lazyListState, LazyListItemProvider lazyListItemProvider, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, LazyListItemPlacementAnimator lazyListItemPlacementAnimator, LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo, Alignment.Horizontal horizontal2, Alignment.Vertical vertical2, OverscrollEffect overscrollEffect) {
        super(2);
        this.f2770g = z11;
        this.f2771h = paddingValues;
        this.f2772i = z12;
        this.f2773j = lazyListState;
        this.f2774k = lazyListItemProvider;
        this.f2775l = vertical;
        this.f2776m = horizontal;
        this.f2777n = lazyListItemPlacementAnimator;
        this.f2778o = lazyListBeyondBoundsInfo;
        this.f2779p = horizontal2;
        this.f2780q = vertical2;
        this.f2781r = overscrollEffect;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m634invoke0kLqBqw((LazyLayoutMeasureScope) obj, ((Constraints) obj2).m5428unboximpl());
    }

    @NotNull
    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final LazyListMeasureResult m634invoke0kLqBqw(@NotNull LazyLayoutMeasureScope lazyLayoutMeasureScope, long j11) {
        Orientation orientation;
        int i11;
        int i12;
        int i13;
        int i14;
        float f11;
        int i15;
        long j12;
        Snapshot makeCurrent;
        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
        long j13 = j11;
        Intrinsics.checkNotNullParameter(lazyLayoutMeasureScope2, "$this$null");
        if (this.f2770g) {
            orientation = Orientation.Vertical;
        } else {
            orientation = Orientation.Horizontal;
        }
        CheckScrollableContainerConstraintsKt.m192checkScrollableContainerConstraintsK40F9xA(j13, orientation);
        if (this.f2770g) {
            i11 = lazyLayoutMeasureScope2.m5441roundToPx0680j_4(this.f2771h.m497calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i11 = lazyLayoutMeasureScope2.m5441roundToPx0680j_4(PaddingKt.calculateStartPadding(this.f2771h, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        if (this.f2770g) {
            i12 = lazyLayoutMeasureScope2.m5441roundToPx0680j_4(this.f2771h.m498calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i12 = lazyLayoutMeasureScope2.m5441roundToPx0680j_4(PaddingKt.calculateEndPadding(this.f2771h, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        int r42 = lazyLayoutMeasureScope2.m5441roundToPx0680j_4(this.f2771h.m499calculateTopPaddingD9Ej5fM());
        int r52 = lazyLayoutMeasureScope2.m5441roundToPx0680j_4(this.f2771h.m496calculateBottomPaddingD9Ej5fM());
        int i16 = r42 + r52;
        int i17 = i11 + i12;
        boolean z11 = this.f2770g;
        if (z11) {
            i13 = i16;
        } else {
            i13 = i17;
        }
        if (z11 && !this.f2772i) {
            i14 = r42;
        } else if (z11 && this.f2772i) {
            i14 = r52;
        } else if (z11 || this.f2772i) {
            i14 = i12;
        } else {
            i14 = i11;
        }
        int i18 = i13 - i14;
        long r27 = ConstraintsKt.m5438offsetNN6EwU(j13, -i17, -i16);
        this.f2773j.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(this.f2774k);
        this.f2773j.setDensity$foundation_release(lazyLayoutMeasureScope2);
        this.f2774k.getItemScope().setMaxSize(Constraints.m5422getMaxWidthimpl(r27), Constraints.m5421getMaxHeightimpl(r27));
        if (this.f2770g) {
            Arrangement.Vertical vertical = this.f2775l;
            if (vertical != null) {
                f11 = vertical.m423getSpacingD9Ej5fM();
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        } else {
            Arrangement.Horizontal horizontal = this.f2776m;
            if (horizontal != null) {
                f11 = horizontal.m409getSpacingD9Ej5fM();
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        int r53 = lazyLayoutMeasureScope2.m5441roundToPx0680j_4(f11);
        int itemCount = this.f2774k.getItemCount();
        if (this.f2770g) {
            i15 = Constraints.m5421getMaxHeightimpl(j11) - i16;
        } else {
            i15 = Constraints.m5422getMaxWidthimpl(j11) - i17;
        }
        int i19 = i15;
        if (!this.f2772i || i19 > 0) {
            j12 = IntOffsetKt.IntOffset(i11, r42);
        } else {
            boolean z12 = this.f2770g;
            if (!z12) {
                i11 += i19;
            }
            if (z12) {
                r42 += i19;
            }
            j12 = IntOffsetKt.IntOffset(i11, r42);
        }
        boolean z13 = this.f2770g;
        LazyListItemProvider lazyListItemProvider = this.f2774k;
        boolean z14 = z13;
        int i21 = i17;
        LazyMeasuredItemProvider lazyMeasuredItemProvider = new LazyMeasuredItemProvider(r27, z14, lazyListItemProvider, lazyLayoutMeasureScope, new LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1(itemCount, r53, lazyLayoutMeasureScope, z13, this.f2779p, this.f2780q, this.f2772i, i14, i18, this.f2777n, j12), (DefaultConstructorMarker) null);
        this.f2773j.m647setPremeasureConstraintsBRTryo0$foundation_release(lazyMeasuredItemProvider.m649getChildConstraintsmsEJaDk());
        Snapshot.Companion companion = Snapshot.Companion;
        LazyListState lazyListState = this.f2773j;
        Snapshot createNonObservableSnapshot = companion.createNonObservableSnapshot();
        try {
            makeCurrent = createNonObservableSnapshot.makeCurrent();
            int r13 = DataIndex.m612constructorimpl(lazyListState.getFirstVisibleItemIndex());
            int firstVisibleItemScrollOffset = lazyListState.getFirstVisibleItemScrollOffset();
            Unit unit = Unit.INSTANCE;
            createNonObservableSnapshot.restoreCurrent(makeCurrent);
            createNonObservableSnapshot.dispose();
            final int i22 = i16;
            float scrollToBeConsumed$foundation_release = this.f2773j.getScrollToBeConsumed$foundation_release();
            boolean z15 = this.f2770g;
            List<Integer> headerIndexes = this.f2774k.getHeaderIndexes();
            Arrangement.Vertical vertical2 = this.f2775l;
            Arrangement.Horizontal horizontal2 = this.f2776m;
            boolean z16 = this.f2772i;
            LazyListItemPlacementAnimator lazyListItemPlacementAnimator = this.f2777n;
            LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo = this.f2778o;
            AnonymousClass2 r26 = r2;
            final LazyLayoutMeasureScope lazyLayoutMeasureScope3 = lazyLayoutMeasureScope;
            final long j14 = j11;
            final int i23 = i21;
            AnonymousClass2 r22 = new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (Function1<? super Placeable.PlacementScope, Unit>) (Function1) obj3);
                }

                @NotNull
                public final MeasureResult invoke(int i11, int i12, @NotNull Function1<? super Placeable.PlacementScope, Unit> function1) {
                    Intrinsics.checkNotNullParameter(function1, "placement");
                    return lazyLayoutMeasureScope3.layout(ConstraintsKt.m5436constrainWidthK40F9xA(j14, i11 + i23), ConstraintsKt.m5435constrainHeightK40F9xA(j14, i12 + i22), MapsKt__MapsKt.emptyMap(), function1);
                }
            };
            LazyListMeasureResult r02 = LazyListMeasureKt.m638measureLazyList7Xnphek(itemCount, lazyMeasuredItemProvider, i19, i14, i18, r13, firstVisibleItemScrollOffset, scrollToBeConsumed$foundation_release, r27, z15, headerIndexes, vertical2, horizontal2, z16, lazyLayoutMeasureScope, lazyListItemPlacementAnimator, lazyListBeyondBoundsInfo, r26);
            LazyListState lazyListState2 = this.f2773j;
            OverscrollEffect overscrollEffect = this.f2781r;
            lazyListState2.applyMeasureResult$foundation_release(r02);
            LazyListKt.refreshOverscrollInfo(overscrollEffect, r02);
            return r02;
        } catch (Throwable th2) {
            createNonObservableSnapshot.dispose();
            throw th2;
        }
    }
}
