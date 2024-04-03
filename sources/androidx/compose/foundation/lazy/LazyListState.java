package androidx.compose.foundation.lazy;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 |2\u00020\u0001:\u0001|B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J#\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020\u00032\b\b\u0002\u0010]\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010^J\u0015\u0010_\u001a\u00020[2\u0006\u0010`\u001a\u00020aH\u0000¢\u0006\u0002\bbJ\u0010\u0010c\u001a\u00020[2\u0006\u0010d\u001a\u00020*H\u0002J\u0010\u0010e\u001a\u00020T2\u0006\u0010f\u001a\u00020TH\u0016J\u0010\u0010g\u001a\u00020[2\u0006\u0010f\u001a\u00020TH\u0002J\u0015\u0010h\u001a\u00020T2\u0006\u0010i\u001a\u00020TH\u0000¢\u0006\u0002\bjJB\u0010k\u001a\u00020[2\u0006\u0010l\u001a\u00020m2'\u0010n\u001a#\b\u0001\u0012\u0004\u0012\u00020p\u0012\n\u0012\b\u0012\u0004\u0012\u00020[0q\u0012\u0006\u0012\u0004\u0018\u00010r0o¢\u0006\u0002\bsH@ø\u0001\u0000¢\u0006\u0002\u0010tJ#\u0010u\u001a\u00020[2\u0006\u0010\\\u001a\u00020\u00032\b\b\u0002\u0010]\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010^J\u001d\u0010v\u001a\u00020[2\u0006\u0010\\\u001a\u00020\u00032\u0006\u0010]\u001a\u00020\u0003H\u0000¢\u0006\u0002\bwJ\u0015\u0010x\u001a\u00020[2\u0006\u0010y\u001a\u00020zH\u0000¢\u0006\u0002\b{R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00148@@@X\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\u000e\u0010\u001f\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0011R\u0011\u0010)\u001a\u00020*8F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020*0.X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010/\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001dR/\u00102\u001a\u0004\u0018\u0001012\b\u0010\u000e\u001a\u0004\u0018\u0001018@@@X\u0002¢\u0006\u0012\n\u0004\b7\u0010\u001b\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0014\u00108\u001a\u000209X\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0011\"\u0004\b>\u0010?R4\u0010A\u001a\u00020@2\u0006\u0010\u000e\u001a\u00020@8@@@X\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\bF\u0010\u001b\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER/\u0010H\u001a\u0004\u0018\u00010G2\b\u0010\u000e\u001a\u0004\u0018\u00010G8@@BX\u0002¢\u0006\u0012\n\u0004\bM\u0010\u001b\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020OX\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010QR\u000e\u0010R\u001a\u00020SX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010U\u001a\u00020T2\u0006\u0010\u000e\u001a\u00020T@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bV\u0010WR\u000e\u0010X\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006}"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "firstVisibleItemIndex", "", "firstVisibleItemScrollOffset", "(II)V", "animateScrollScope", "Landroidx/compose/foundation/lazy/LazyListAnimateScrollScope;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation_release", "()Landroidx/compose/foundation/lazy/AwaitFirstLayoutModifier;", "canScrollBackward", "", "<set-?>", "canScrollForward", "getCanScrollForward$foundation_release", "()Z", "currentPrefetchHandle", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "Landroidx/compose/ui/unit/Density;", "density", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation_release", "(Landroidx/compose/ui/unit/Density;)V", "density$delegate", "Landroidx/compose/runtime/MutableState;", "getFirstVisibleItemIndex", "()I", "getFirstVisibleItemScrollOffset", "indexToPrefetch", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isScrollInProgress", "layoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "layoutInfoState", "Landroidx/compose/runtime/MutableState;", "numMeasurePasses", "getNumMeasurePasses$foundation_release", "Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;", "placementAnimator", "getPlacementAnimator$foundation_release", "()Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;", "setPlacementAnimator$foundation_release", "(Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;)V", "placementAnimator$delegate", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "prefetchingEnabled", "getPrefetchingEnabled$foundation_release", "setPrefetchingEnabled$foundation_release", "(Z)V", "Landroidx/compose/ui/unit/Constraints;", "premeasureConstraints", "getPremeasureConstraints-msEJaDk$foundation_release", "()J", "setPremeasureConstraints-BRTryo0$foundation_release", "(J)V", "premeasureConstraints$delegate", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurement", "getRemeasurement$foundation_release", "()Landroidx/compose/ui/layout/Remeasurement;", "setRemeasurement", "(Landroidx/compose/ui/layout/Remeasurement;)V", "remeasurement$delegate", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation_release", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "scrollPosition", "Landroidx/compose/foundation/lazy/LazyListScrollPosition;", "", "scrollToBeConsumed", "getScrollToBeConsumed$foundation_release", "()F", "scrollableState", "wasScrollingForward", "animateScrollToItem", "", "index", "scrollOffset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyMeasureResult", "result", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "applyMeasureResult$foundation_release", "cancelPrefetchIfVisibleItemsChanged", "info", "dispatchRawDelta", "delta", "notifyPrefetch", "onScroll", "distance", "onScroll$foundation_release", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToItem", "snapToItemIndexInternal", "snapToItemIndexInternal$foundation_release", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "updateScrollPositionIfTheFirstItemWasMoved$foundation_release", "Companion", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Stable
public final class LazyListState implements ScrollableState {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Saver<LazyListState, ?> Saver = ListSaverKt.listSaver(LazyListState$Companion$Saver$1.INSTANCE, LazyListState$Companion$Saver$2.INSTANCE);
    @NotNull
    private final LazyListAnimateScrollScope animateScrollScope;
    @NotNull
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private boolean canScrollBackward;
    private boolean canScrollForward;
    @Nullable
    private LazyLayoutPrefetchState.PrefetchHandle currentPrefetchHandle;
    @NotNull
    private final MutableState density$delegate;
    private int indexToPrefetch;
    @NotNull
    private final MutableInteractionSource internalInteractionSource;
    @NotNull
    private final MutableState<LazyListLayoutInfo> layoutInfoState;
    private int numMeasurePasses;
    @NotNull
    private final MutableState placementAnimator$delegate;
    @NotNull
    private final LazyLayoutPrefetchState prefetchState;
    private boolean prefetchingEnabled;
    @NotNull
    private final MutableState premeasureConstraints$delegate;
    @NotNull
    private final MutableState remeasurement$delegate;
    @NotNull
    private final RemeasurementModifier remeasurementModifier;
    @NotNull
    private final LazyListScrollPosition scrollPosition;
    private float scrollToBeConsumed;
    @NotNull
    private final ScrollableState scrollableState;
    private boolean wasScrollingForward;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/lazy/LazyListState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Saver<LazyListState, ?> getSaver() {
            return LazyListState.Saver;
        }
    }

    public LazyListState() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    public LazyListState(int i11, int i12) {
        this.scrollPosition = new LazyListScrollPosition(i11, i12);
        this.animateScrollScope = new LazyListAnimateScrollScope(this);
        this.layoutInfoState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(EmptyLazyListLayoutInfo.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
        this.density$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(DensityKt.Density(1.0f, 1.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.scrollableState = ScrollableStateKt.ScrollableState(new LazyListState$scrollableState$1(this));
        this.prefetchingEnabled = true;
        this.indexToPrefetch = -1;
        this.remeasurement$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.remeasurementModifier = new LazyListState$remeasurementModifier$1(this);
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        this.placementAnimator$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.premeasureConstraints$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Constraints.m5410boximpl(ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, (Object) null)), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.prefetchState = new LazyLayoutPrefetchState();
    }

    public static /* synthetic */ Object animateScrollToItem$default(LazyListState lazyListState, int i11, int i12, Continuation continuation, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i12 = 0;
        }
        return lazyListState.animateScrollToItem(i11, i12, continuation);
    }

    private final void cancelPrefetchIfVisibleItemsChanged(LazyListLayoutInfo lazyListLayoutInfo) {
        if (this.indexToPrefetch != -1 && (!lazyListLayoutInfo.getVisibleItemsInfo().isEmpty()) && this.indexToPrefetch != ((LazyListItemInfo) CollectionsKt___CollectionsKt.first(lazyListLayoutInfo.getVisibleItemsInfo())).getIndex() - 1 && this.indexToPrefetch != ((LazyListItemInfo) CollectionsKt___CollectionsKt.last(lazyListLayoutInfo.getVisibleItemsInfo())).getIndex() + 1) {
            this.indexToPrefetch = -1;
            LazyLayoutPrefetchState.PrefetchHandle prefetchHandle = this.currentPrefetchHandle;
            if (prefetchHandle != null) {
                prefetchHandle.cancel();
            }
            this.currentPrefetchHandle = null;
        }
    }

    private final void notifyPrefetch(float f11) {
        boolean z11;
        int i11;
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle;
        if (this.prefetchingEnabled) {
            LazyListLayoutInfo layoutInfo = getLayoutInfo();
            boolean z12 = true;
            if (!layoutInfo.getVisibleItemsInfo().isEmpty()) {
                if (f11 < 0.0f) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    i11 = ((LazyListItemInfo) CollectionsKt___CollectionsKt.last(layoutInfo.getVisibleItemsInfo())).getIndex() + 1;
                } else {
                    i11 = ((LazyListItemInfo) CollectionsKt___CollectionsKt.first(layoutInfo.getVisibleItemsInfo())).getIndex() - 1;
                }
                if (i11 != this.indexToPrefetch) {
                    if (i11 < 0 || i11 >= layoutInfo.getTotalItemsCount()) {
                        z12 = false;
                    }
                    if (z12) {
                        if (!(this.wasScrollingForward == z11 || (prefetchHandle = this.currentPrefetchHandle) == null)) {
                            prefetchHandle.cancel();
                        }
                        this.wasScrollingForward = z11;
                        this.indexToPrefetch = i11;
                        this.currentPrefetchHandle = this.prefetchState.m760schedulePrefetch0kLqBqw(i11, m646getPremeasureConstraintsmsEJaDk$foundation_release());
                    }
                }
            }
        }
    }

    public static /* synthetic */ Object scrollToItem$default(LazyListState lazyListState, int i11, int i12, Continuation continuation, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i12 = 0;
        }
        return lazyListState.scrollToItem(i11, i12, continuation);
    }

    /* access modifiers changed from: private */
    public final void setRemeasurement(Remeasurement remeasurement) {
        this.remeasurement$delegate.setValue(remeasurement);
    }

    @Nullable
    public final Object animateScrollToItem(int i11, int i12, @NotNull Continuation<? super Unit> continuation) {
        Object animateScrollToItem = LazyAnimateScrollKt.animateScrollToItem(this.animateScrollScope, i11, i12, continuation);
        return animateScrollToItem == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateScrollToItem : Unit.INSTANCE;
    }

    public final void applyMeasureResult$foundation_release(@NotNull LazyListMeasureResult lazyListMeasureResult) {
        int i11;
        Intrinsics.checkNotNullParameter(lazyListMeasureResult, "result");
        this.scrollPosition.updateFromMeasureResult(lazyListMeasureResult);
        this.scrollToBeConsumed -= lazyListMeasureResult.getConsumedScroll();
        this.layoutInfoState.setValue(lazyListMeasureResult);
        this.canScrollForward = lazyListMeasureResult.getCanScrollForward();
        LazyMeasuredItem firstVisibleItem = lazyListMeasureResult.getFirstVisibleItem();
        boolean z11 = false;
        if (firstVisibleItem != null) {
            i11 = firstVisibleItem.getIndex();
        } else {
            i11 = 0;
        }
        if (!(i11 == 0 && lazyListMeasureResult.getFirstVisibleItemScrollOffset() == 0)) {
            z11 = true;
        }
        this.canScrollBackward = z11;
        this.numMeasurePasses++;
        cancelPrefetchIfVisibleItemsChanged(lazyListMeasureResult);
    }

    public float dispatchRawDelta(float f11) {
        return this.scrollableState.dispatchRawDelta(f11);
    }

    @NotNull
    public final AwaitFirstLayoutModifier getAwaitLayoutModifier$foundation_release() {
        return this.awaitLayoutModifier;
    }

    public final boolean getCanScrollForward$foundation_release() {
        return this.canScrollForward;
    }

    @NotNull
    public final Density getDensity$foundation_release() {
        return (Density) this.density$delegate.getValue();
    }

    public final int getFirstVisibleItemIndex() {
        return this.scrollPosition.m643getIndexjQJCoq8();
    }

    public final int getFirstVisibleItemScrollOffset() {
        return this.scrollPosition.getScrollOffset();
    }

    @NotNull
    public final InteractionSource getInteractionSource() {
        return this.internalInteractionSource;
    }

    @NotNull
    public final MutableInteractionSource getInternalInteractionSource$foundation_release() {
        return this.internalInteractionSource;
    }

    @NotNull
    public final LazyListLayoutInfo getLayoutInfo() {
        return this.layoutInfoState.getValue();
    }

    public final int getNumMeasurePasses$foundation_release() {
        return this.numMeasurePasses;
    }

    @Nullable
    public final LazyListItemPlacementAnimator getPlacementAnimator$foundation_release() {
        return (LazyListItemPlacementAnimator) this.placementAnimator$delegate.getValue();
    }

    @NotNull
    public final LazyLayoutPrefetchState getPrefetchState$foundation_release() {
        return this.prefetchState;
    }

    public final boolean getPrefetchingEnabled$foundation_release() {
        return this.prefetchingEnabled;
    }

    /* renamed from: getPremeasureConstraints-msEJaDk$foundation_release  reason: not valid java name */
    public final long m646getPremeasureConstraintsmsEJaDk$foundation_release() {
        return ((Constraints) this.premeasureConstraints$delegate.getValue()).m5428unboximpl();
    }

    @Nullable
    public final Remeasurement getRemeasurement$foundation_release() {
        return (Remeasurement) this.remeasurement$delegate.getValue();
    }

    @NotNull
    public final RemeasurementModifier getRemeasurementModifier$foundation_release() {
        return this.remeasurementModifier;
    }

    public final float getScrollToBeConsumed$foundation_release() {
        return this.scrollToBeConsumed;
    }

    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    public final float onScroll$foundation_release(float f11) {
        boolean z11;
        if ((f11 < 0.0f && !this.canScrollForward) || (f11 > 0.0f && !this.canScrollBackward)) {
            return 0.0f;
        }
        if (Math.abs(this.scrollToBeConsumed) <= 0.5f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            float f12 = this.scrollToBeConsumed + f11;
            this.scrollToBeConsumed = f12;
            if (Math.abs(f12) > 0.5f) {
                float f13 = this.scrollToBeConsumed;
                Remeasurement remeasurement$foundation_release = getRemeasurement$foundation_release();
                if (remeasurement$foundation_release != null) {
                    remeasurement$foundation_release.forceRemeasure();
                }
                if (this.prefetchingEnabled) {
                    notifyPrefetch(f13 - this.scrollToBeConsumed);
                }
            }
            if (Math.abs(this.scrollToBeConsumed) <= 0.5f) {
                return f11;
            }
            float f14 = f11 - this.scrollToBeConsumed;
            this.scrollToBeConsumed = 0.0f;
            return f14;
        }
        throw new IllegalStateException(("entered drag with non-zero pending scroll: " + this.scrollToBeConsumed).toString());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: kotlin.jvm.functions.Function2<? super androidx.compose.foundation.gestures.ScrollScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object scroll(@org.jetbrains.annotations.NotNull androidx.compose.foundation.MutatePriority r6, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.foundation.gestures.ScrollScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof androidx.compose.foundation.lazy.LazyListState$scroll$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            androidx.compose.foundation.lazy.LazyListState$scroll$1 r0 = (androidx.compose.foundation.lazy.LazyListState$scroll$1) r0
            int r1 = r0.f2810m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f2810m = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.foundation.lazy.LazyListState$scroll$1 r0 = new androidx.compose.foundation.lazy.LazyListState$scroll$1
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f2808k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f2810m
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0045
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x006c
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            java.lang.Object r6 = r0.f2807j
            r7 = r6
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r6 = r0.f2806i
            androidx.compose.foundation.MutatePriority r6 = (androidx.compose.foundation.MutatePriority) r6
            java.lang.Object r2 = r0.f2805h
            androidx.compose.foundation.lazy.LazyListState r2 = (androidx.compose.foundation.lazy.LazyListState) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x005a
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.compose.foundation.lazy.AwaitFirstLayoutModifier r8 = r5.awaitLayoutModifier
            r0.f2805h = r5
            r0.f2806i = r6
            r0.f2807j = r7
            r0.f2810m = r4
            java.lang.Object r8 = r8.waitForFirstLayout(r0)
            if (r8 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r2 = r5
        L_0x005a:
            androidx.compose.foundation.gestures.ScrollableState r8 = r2.scrollableState
            r2 = 0
            r0.f2805h = r2
            r0.f2806i = r2
            r0.f2807j = r2
            r0.f2810m = r3
            java.lang.Object r6 = r8.scroll(r6, r7, r0)
            if (r6 != r1) goto L_0x006c
            return r1
        L_0x006c:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListState.scroll(androidx.compose.foundation.MutatePriority, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public final Object scrollToItem(int i11, int i12, @NotNull Continuation<? super Unit> continuation) {
        Object a11 = c.a(this, (MutatePriority) null, new LazyListState$scrollToItem$2(this, i11, i12, (Continuation<? super LazyListState$scrollToItem$2>) null), continuation, 1, (Object) null);
        return a11 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a11 : Unit.INSTANCE;
    }

    public final void setDensity$foundation_release(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "<set-?>");
        this.density$delegate.setValue(density);
    }

    public final void setPlacementAnimator$foundation_release(@Nullable LazyListItemPlacementAnimator lazyListItemPlacementAnimator) {
        this.placementAnimator$delegate.setValue(lazyListItemPlacementAnimator);
    }

    public final void setPrefetchingEnabled$foundation_release(boolean z11) {
        this.prefetchingEnabled = z11;
    }

    /* renamed from: setPremeasureConstraints-BRTryo0$foundation_release  reason: not valid java name */
    public final void m647setPremeasureConstraintsBRTryo0$foundation_release(long j11) {
        this.premeasureConstraints$delegate.setValue(Constraints.m5410boximpl(j11));
    }

    public final void snapToItemIndexInternal$foundation_release(int i11, int i12) {
        this.scrollPosition.m644requestPositionAhXoVpI(DataIndex.m612constructorimpl(i11), i12);
        LazyListItemPlacementAnimator placementAnimator$foundation_release = getPlacementAnimator$foundation_release();
        if (placementAnimator$foundation_release != null) {
            placementAnimator$foundation_release.reset();
        }
        Remeasurement remeasurement$foundation_release = getRemeasurement$foundation_release();
        if (remeasurement$foundation_release != null) {
            remeasurement$foundation_release.forceRemeasure();
        }
    }

    public final void updateScrollPositionIfTheFirstItemWasMoved$foundation_release(@NotNull LazyListItemProvider lazyListItemProvider) {
        Intrinsics.checkNotNullParameter(lazyListItemProvider, "itemProvider");
        this.scrollPosition.updateScrollPositionIfTheFirstItemWasMoved(lazyListItemProvider);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyListState(int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 0 : i11, (i13 & 2) != 0 ? 0 : i12);
    }
}
