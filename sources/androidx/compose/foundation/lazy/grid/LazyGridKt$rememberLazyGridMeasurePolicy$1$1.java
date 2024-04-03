package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class LazyGridKt$rememberLazyGridMeasurePolicy$1$1 extends Lambda implements Function2<LazyLayoutMeasureScope, Constraints, LazyGridMeasureResult> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f2923g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ PaddingValues f2924h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f2925i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ LazyGridState f2926j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ LazyGridItemProvider f2927k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Density, Constraints, List<Integer>> f2928l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Vertical f2929m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Arrangement.Horizontal f2930n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ LazyGridItemPlacementAnimator f2931o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ OverscrollEffect f2932p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyGridKt$rememberLazyGridMeasurePolicy$1$1(boolean z11, PaddingValues paddingValues, boolean z12, LazyGridState lazyGridState, LazyGridItemProvider lazyGridItemProvider, Function2<? super Density, ? super Constraints, ? extends List<Integer>> function2, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, OverscrollEffect overscrollEffect) {
        super(2);
        this.f2923g = z11;
        this.f2924h = paddingValues;
        this.f2925i = z12;
        this.f2926j = lazyGridState;
        this.f2927k = lazyGridItemProvider;
        this.f2928l = function2;
        this.f2929m = vertical;
        this.f2930n = horizontal;
        this.f2931o = lazyGridItemPlacementAnimator;
        this.f2932p = overscrollEffect;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m694invoke0kLqBqw((LazyLayoutMeasureScope) obj, ((Constraints) obj2).m5428unboximpl());
    }

    @NotNull
    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final LazyGridMeasureResult m694invoke0kLqBqw(@NotNull LazyLayoutMeasureScope lazyLayoutMeasureScope, long j11) {
        Orientation orientation;
        int i11;
        int i12;
        int i13;
        int i14;
        float f11;
        float f12;
        int i15;
        long j12;
        Snapshot makeCurrent;
        int i16;
        int i17;
        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
        long j13 = j11;
        Intrinsics.checkNotNullParameter(lazyLayoutMeasureScope2, "$this$null");
        if (this.f2923g) {
            orientation = Orientation.Vertical;
        } else {
            orientation = Orientation.Horizontal;
        }
        CheckScrollableContainerConstraintsKt.m192checkScrollableContainerConstraintsK40F9xA(j13, orientation);
        if (this.f2923g) {
            i11 = lazyLayoutMeasureScope2.m5441roundToPx0680j_4(this.f2924h.m497calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i11 = lazyLayoutMeasureScope2.m5441roundToPx0680j_4(PaddingKt.calculateStartPadding(this.f2924h, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        if (this.f2923g) {
            i12 = lazyLayoutMeasureScope2.m5441roundToPx0680j_4(this.f2924h.m498calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i12 = lazyLayoutMeasureScope2.m5441roundToPx0680j_4(PaddingKt.calculateEndPadding(this.f2924h, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        int r42 = lazyLayoutMeasureScope2.m5441roundToPx0680j_4(this.f2924h.m499calculateTopPaddingD9Ej5fM());
        int r52 = lazyLayoutMeasureScope2.m5441roundToPx0680j_4(this.f2924h.m496calculateBottomPaddingD9Ej5fM());
        int i18 = r42 + r52;
        int i19 = i11 + i12;
        boolean z11 = this.f2923g;
        if (z11) {
            i13 = i18;
        } else {
            i13 = i19;
        }
        if (z11 && !this.f2925i) {
            i14 = r42;
        } else if (z11 && this.f2925i) {
            i14 = r52;
        } else if (z11 || this.f2925i) {
            i14 = i12;
        } else {
            i14 = i11;
        }
        int i21 = i13 - i14;
        long r27 = ConstraintsKt.m5438offsetNN6EwU(j13, -i19, -i18);
        this.f2926j.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(this.f2927k);
        LazyGridSpanLayoutProvider spanLayoutProvider = this.f2927k.getSpanLayoutProvider();
        List invoke = this.f2928l.invoke(lazyLayoutMeasureScope2, Constraints.m5410boximpl(j11));
        spanLayoutProvider.setSlotsPerLine(invoke.size());
        this.f2926j.setDensity$foundation_release(lazyLayoutMeasureScope2);
        this.f2926j.setSlotsPerLine$foundation_release(invoke.size());
        if (this.f2923g) {
            Arrangement.Vertical vertical = this.f2929m;
            if (vertical != null) {
                f11 = vertical.m423getSpacingD9Ej5fM();
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        } else {
            Arrangement.Horizontal horizontal = this.f2930n;
            if (horizontal != null) {
                f11 = horizontal.m409getSpacingD9Ej5fM();
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        int r102 = lazyLayoutMeasureScope2.m5441roundToPx0680j_4(f11);
        if (this.f2923g) {
            Arrangement.Horizontal horizontal2 = this.f2930n;
            if (horizontal2 != null) {
                f12 = horizontal2.m409getSpacingD9Ej5fM();
            } else {
                f12 = Dp.m5478constructorimpl((float) 0);
            }
        } else {
            Arrangement.Vertical vertical2 = this.f2929m;
            if (vertical2 != null) {
                f12 = vertical2.m423getSpacingD9Ej5fM();
            } else {
                f12 = Dp.m5478constructorimpl((float) 0);
            }
        }
        int r72 = lazyLayoutMeasureScope2.m5441roundToPx0680j_4(f12);
        int itemCount = this.f2927k.getItemCount();
        if (this.f2923g) {
            i15 = Constraints.m5421getMaxHeightimpl(j11) - i18;
        } else {
            i15 = Constraints.m5422getMaxWidthimpl(j11) - i19;
        }
        int i22 = i15;
        if (!this.f2925i || i22 > 0) {
            j12 = IntOffsetKt.IntOffset(i11, r42);
        } else {
            boolean z12 = this.f2923g;
            if (!z12) {
                i11 += i22;
            }
            if (z12) {
                r42 += i22;
            }
            j12 = IntOffsetKt.IntOffset(i11, r42);
        }
        long j14 = j12;
        LazyGridItemProvider lazyGridItemProvider = this.f2927k;
        LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 = r2;
        int i23 = i18;
        int i24 = i19;
        int i25 = r72;
        int i26 = itemCount;
        LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider = spanLayoutProvider;
        int i27 = r102;
        LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$12 = new LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1(lazyLayoutMeasureScope, this.f2923g, this.f2925i, i14, i21, this.f2931o, j14);
        LazyMeasuredItemProvider lazyMeasuredItemProvider = new LazyMeasuredItemProvider(lazyGridItemProvider, lazyLayoutMeasureScope2, i27, lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1);
        boolean z13 = this.f2923g;
        List list = invoke;
        final LazyMeasuredLineProvider lazyMeasuredLineProvider = new LazyMeasuredLineProvider(z13, list, i25, i26, i27, lazyMeasuredItemProvider, lazyGridSpanLayoutProvider, new LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1(z13, list, lazyLayoutMeasureScope2, i25));
        final LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider2 = lazyGridSpanLayoutProvider;
        this.f2926j.setPrefetchInfoRetriever$foundation_release(new Function1<LineIndex, ArrayList<Pair<? extends Integer, ? extends Constraints>>>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return m695invokebKFJvoY(((LineIndex) obj).m732unboximpl());
            }

            @NotNull
            /* renamed from: invoke-bKFJvoY  reason: not valid java name */
            public final ArrayList<Pair<Integer, Constraints>> m695invokebKFJvoY(int i11) {
                LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = lazyGridSpanLayoutProvider2.getLineConfiguration(i11);
                int r02 = ItemIndex.m666constructorimpl(lineConfiguration.getFirstItemIndex());
                ArrayList<Pair<Integer, Constraints>> arrayList = new ArrayList<>(lineConfiguration.getSpans().size());
                List<GridItemSpan> spans = lineConfiguration.getSpans();
                LazyMeasuredLineProvider lazyMeasuredLineProvider = lazyMeasuredLineProvider;
                int size = spans.size();
                int i12 = 0;
                for (int i13 = 0; i13 < size; i13++) {
                    int r62 = GridItemSpan.m660getCurrentLineSpanimpl(spans.get(i13).m663unboximpl());
                    arrayList.add(TuplesKt.to(Integer.valueOf(r02), Constraints.m5410boximpl(lazyMeasuredLineProvider.m718childConstraintsJhjzzOo$foundation_release(i12, r62))));
                    r02 = ItemIndex.m666constructorimpl(r02 + 1);
                    i12 += r62;
                }
                return arrayList;
            }
        });
        Snapshot.Companion companion = Snapshot.Companion;
        LazyGridState lazyGridState = this.f2926j;
        Snapshot createNonObservableSnapshot = companion.createNonObservableSnapshot();
        try {
            makeCurrent = createNonObservableSnapshot.makeCurrent();
            int i28 = i26;
            if (lazyGridState.getFirstVisibleItemIndex() >= i28) {
                if (i28 > 0) {
                    i17 = lazyGridSpanLayoutProvider2.m712getLineIndexOfItem_Ze7BM(i28 - 1);
                    i16 = 0;
                    Unit unit = Unit.INSTANCE;
                    createNonObservableSnapshot.restoreCurrent(makeCurrent);
                    createNonObservableSnapshot.dispose();
                    int size = list.size();
                    float scrollToBeConsumed$foundation_release = this.f2926j.getScrollToBeConsumed$foundation_release();
                    boolean z14 = this.f2923g;
                    Arrangement.Vertical vertical3 = this.f2929m;
                    Arrangement.Horizontal horizontal3 = this.f2930n;
                    boolean z15 = this.f2925i;
                    LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator = this.f2931o;
                    AnonymousClass3 r26 = r2;
                    final LazyLayoutMeasureScope lazyLayoutMeasureScope3 = lazyLayoutMeasureScope;
                    final long j15 = j11;
                    final int i29 = i24;
                    final int i31 = i23;
                    AnonymousClass3 r22 = new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() {
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (Function1<? super Placeable.PlacementScope, Unit>) (Function1) obj3);
                        }

                        @NotNull
                        public final MeasureResult invoke(int i11, int i12, @NotNull Function1<? super Placeable.PlacementScope, Unit> function1) {
                            Intrinsics.checkNotNullParameter(function1, "placement");
                            return lazyLayoutMeasureScope3.layout(ConstraintsKt.m5436constrainWidthK40F9xA(j15, i11 + i29), ConstraintsKt.m5435constrainHeightK40F9xA(j15, i12 + i31), MapsKt__MapsKt.emptyMap(), function1);
                        }
                    };
                    LazyGridMeasureResult r02 = LazyGridMeasureKt.m699measureLazyGridzIfe3eg(i28, lazyMeasuredLineProvider, lazyMeasuredItemProvider, i22, size, i14, i21, i17, i16, scrollToBeConsumed$foundation_release, r27, z14, vertical3, horizontal3, z15, lazyLayoutMeasureScope, lazyGridItemPlacementAnimator, r26);
                    LazyGridState lazyGridState2 = this.f2926j;
                    OverscrollEffect overscrollEffect = this.f2932p;
                    lazyGridState2.applyMeasureResult$foundation_release(r02);
                    LazyGridKt.refreshOverscrollInfo(overscrollEffect, r02);
                    return r02;
                }
            }
            int r53 = lazyGridSpanLayoutProvider2.m712getLineIndexOfItem_Ze7BM(lazyGridState.getFirstVisibleItemIndex());
            i16 = lazyGridState.getFirstVisibleItemScrollOffset();
            i17 = r53;
            Unit unit2 = Unit.INSTANCE;
            createNonObservableSnapshot.restoreCurrent(makeCurrent);
            createNonObservableSnapshot.dispose();
            int size2 = list.size();
            float scrollToBeConsumed$foundation_release2 = this.f2926j.getScrollToBeConsumed$foundation_release();
            boolean z142 = this.f2923g;
            Arrangement.Vertical vertical32 = this.f2929m;
            Arrangement.Horizontal horizontal32 = this.f2930n;
            boolean z152 = this.f2925i;
            LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator2 = this.f2931o;
            AnonymousClass3 r262 = r22;
            final LazyLayoutMeasureScope lazyLayoutMeasureScope32 = lazyLayoutMeasureScope;
            final long j152 = j11;
            final int i292 = i24;
            final int i312 = i23;
            AnonymousClass3 r222 = new Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (Function1<? super Placeable.PlacementScope, Unit>) (Function1) obj3);
                }

                @NotNull
                public final MeasureResult invoke(int i11, int i12, @NotNull Function1<? super Placeable.PlacementScope, Unit> function1) {
                    Intrinsics.checkNotNullParameter(function1, "placement");
                    return lazyLayoutMeasureScope32.layout(ConstraintsKt.m5436constrainWidthK40F9xA(j152, i11 + i292), ConstraintsKt.m5435constrainHeightK40F9xA(j152, i12 + i312), MapsKt__MapsKt.emptyMap(), function1);
                }
            };
            LazyGridMeasureResult r022 = LazyGridMeasureKt.m699measureLazyGridzIfe3eg(i28, lazyMeasuredLineProvider, lazyMeasuredItemProvider, i22, size2, i14, i21, i17, i16, scrollToBeConsumed$foundation_release2, r27, z142, vertical32, horizontal32, z152, lazyLayoutMeasureScope, lazyGridItemPlacementAnimator2, r262);
            LazyGridState lazyGridState22 = this.f2926j;
            OverscrollEffect overscrollEffect2 = this.f2932p;
            lazyGridState22.applyMeasureResult$foundation_release(r022);
            LazyGridKt.refreshOverscrollInfo(overscrollEffect2, r022);
            return r022;
        } catch (Throwable th2) {
            createNonObservableSnapshot.dispose();
            throw th2;
        }
    }
}
