package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.lazy.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J#\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020\u00032\b\b\u0002\u0010n\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010oJ\u0015\u0010p\u001a\u00020l2\u0006\u0010q\u001a\u00020rH\u0000¢\u0006\u0002\bsJ\u0010\u0010t\u001a\u00020l2\u0006\u0010u\u001a\u00020/H\u0002J\u0010\u0010v\u001a\u00020`2\u0006\u0010w\u001a\u00020`H\u0016J\u0010\u0010x\u001a\u00020l2\u0006\u0010w\u001a\u00020`H\u0002J\u0015\u0010y\u001a\u00020`2\u0006\u0010z\u001a\u00020`H\u0000¢\u0006\u0002\b{JH\u0010|\u001a\u00020l2\u0006\u0010}\u001a\u00020~2,\u0010\u001a(\b\u0001\u0012\u0005\u0012\u00030\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020l0\u0001\u0012\u0007\u0012\u0005\u0018\u00010\u00010\u0001¢\u0006\u0003\b\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J$\u0010\u0001\u001a\u00020l2\u0006\u0010m\u001a\u00020\u00032\b\b\u0002\u0010n\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010oJ\u001f\u0010\u0001\u001a\u00020l2\u0006\u0010m\u001a\u00020\u00032\u0006\u0010n\u001a\u00020\u0003H\u0000¢\u0006\u0003\b\u0001J\u0019\u0010\u0001\u001a\u00020l2\b\u0010\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\b\u0001R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\u0002\n\u0000R+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u00158@@@X\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020%X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0011R+\u0010)\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r8@@@X\u0002¢\u0006\u0012\n\u0004\b-\u0010\u001c\u001a\u0004\b*\u0010\u0011\"\u0004\b+\u0010,R\u0011\u0010.\u001a\u00020/8F¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020/03X\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001e\u00105\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001eR/\u00108\u001a\u0004\u0018\u0001072\b\u0010\u000e\u001a\u0004\u0018\u0001078@@@X\u0002¢\u0006\u0012\n\u0004\b=\u0010\u001c\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0001\u0010F\u001a/\u0012\u0013\u0012\u00110?¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(B\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020E0D0C0>23\u0010\u000e\u001a/\u0012\u0013\u0012\u00110?¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(B\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020E0D0C0>8@@@X\u0002ø\u0001\u0000¢\u0006\u0012\n\u0004\bK\u0010\u001c\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0014\u0010L\u001a\u00020MX\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u001a\u0010P\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0011\"\u0004\bR\u0010,R/\u0010T\u001a\u0004\u0018\u00010S2\b\u0010\u000e\u001a\u0004\u0018\u00010S8B@BX\u0002¢\u0006\u0012\n\u0004\bY\u0010\u001c\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u0014\u0010Z\u001a\u00020[X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u000e\u0010^\u001a\u00020_X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010a\u001a\u00020`2\u0006\u0010\u000e\u001a\u00020`@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bb\u0010cR\u000e\u0010d\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R+\u0010e\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00038@@@X\u0002¢\u0006\u0012\n\u0004\bi\u0010\u001c\u001a\u0004\bf\u0010\u001e\"\u0004\bg\u0010hR\u000e\u0010j\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridState;", "Landroidx/compose/foundation/gestures/ScrollableState;", "firstVisibleItemIndex", "", "firstVisibleItemScrollOffset", "(II)V", "animateScrollScope", "Landroidx/compose/foundation/lazy/grid/LazyGridAnimateScrollScope;", "awaitLayoutModifier", "Landroidx/compose/foundation/lazy/AwaitFirstLayoutModifier;", "getAwaitLayoutModifier$foundation_release", "()Landroidx/compose/foundation/lazy/AwaitFirstLayoutModifier;", "canScrollBackward", "", "<set-?>", "canScrollForward", "getCanScrollForward$foundation_release", "()Z", "currentLinePrefetchHandles", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "Landroidx/compose/ui/unit/Density;", "density", "getDensity$foundation_release", "()Landroidx/compose/ui/unit/Density;", "setDensity$foundation_release", "(Landroidx/compose/ui/unit/Density;)V", "density$delegate", "Landroidx/compose/runtime/MutableState;", "getFirstVisibleItemIndex", "()I", "getFirstVisibleItemScrollOffset", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "getInteractionSource", "()Landroidx/compose/foundation/interaction/InteractionSource;", "internalInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getInternalInteractionSource$foundation_release", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isScrollInProgress", "isVertical", "isVertical$foundation_release", "setVertical$foundation_release", "(Z)V", "isVertical$delegate", "layoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "layoutInfoState", "Landroidx/compose/runtime/MutableState;", "lineToPrefetch", "numMeasurePasses", "getNumMeasurePasses$foundation_release", "Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "placementAnimator", "getPlacementAnimator$foundation_release", "()Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "setPlacementAnimator$foundation_release", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;)V", "placementAnimator$delegate", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/grid/LineIndex;", "Lkotlin/ParameterName;", "name", "line", "", "Lkotlin/Pair;", "Landroidx/compose/ui/unit/Constraints;", "prefetchInfoRetriever", "getPrefetchInfoRetriever$foundation_release", "()Lkotlin/jvm/functions/Function1;", "setPrefetchInfoRetriever$foundation_release", "(Lkotlin/jvm/functions/Function1;)V", "prefetchInfoRetriever$delegate", "prefetchState", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "getPrefetchState$foundation_release", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState;", "prefetchingEnabled", "getPrefetchingEnabled$foundation_release", "setPrefetchingEnabled$foundation_release", "Landroidx/compose/ui/layout/Remeasurement;", "remeasurement", "getRemeasurement", "()Landroidx/compose/ui/layout/Remeasurement;", "setRemeasurement", "(Landroidx/compose/ui/layout/Remeasurement;)V", "remeasurement$delegate", "remeasurementModifier", "Landroidx/compose/ui/layout/RemeasurementModifier;", "getRemeasurementModifier$foundation_release", "()Landroidx/compose/ui/layout/RemeasurementModifier;", "scrollPosition", "Landroidx/compose/foundation/lazy/grid/LazyGridScrollPosition;", "", "scrollToBeConsumed", "getScrollToBeConsumed$foundation_release", "()F", "scrollableState", "slotsPerLine", "getSlotsPerLine$foundation_release", "setSlotsPerLine$foundation_release", "(I)V", "slotsPerLine$delegate", "wasScrollingForward", "animateScrollToItem", "", "index", "scrollOffset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyMeasureResult", "result", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "applyMeasureResult$foundation_release", "cancelPrefetchIfVisibleItemsChanged", "info", "dispatchRawDelta", "delta", "notifyPrefetch", "onScroll", "distance", "onScroll$foundation_release", "scroll", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToItem", "snapToItemIndexInternal", "snapToItemIndexInternal$foundation_release", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "updateScrollPositionIfTheFirstItemWasMoved$foundation_release", "Companion", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Stable
public final class LazyGridState implements ScrollableState {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Saver<LazyGridState, ?> Saver = ListSaverKt.listSaver(LazyGridState$Companion$Saver$1.INSTANCE, LazyGridState$Companion$Saver$2.INSTANCE);
    @NotNull
    private final LazyGridAnimateScrollScope animateScrollScope;
    @NotNull
    private final AwaitFirstLayoutModifier awaitLayoutModifier;
    private boolean canScrollBackward;
    private boolean canScrollForward;
    @NotNull
    private final MutableVector<LazyLayoutPrefetchState.PrefetchHandle> currentLinePrefetchHandles;
    @NotNull
    private final MutableState density$delegate;
    @NotNull
    private final MutableInteractionSource internalInteractionSource;
    @NotNull
    private final MutableState isVertical$delegate;
    @NotNull
    private final MutableState<LazyGridLayoutInfo> layoutInfoState;
    private int lineToPrefetch;
    private int numMeasurePasses;
    @NotNull
    private final MutableState placementAnimator$delegate;
    @NotNull
    private final MutableState prefetchInfoRetriever$delegate;
    @NotNull
    private final LazyLayoutPrefetchState prefetchState;
    private boolean prefetchingEnabled;
    @NotNull
    private final MutableState remeasurement$delegate;
    @NotNull
    private final RemeasurementModifier remeasurementModifier;
    @NotNull
    private final LazyGridScrollPosition scrollPosition;
    private float scrollToBeConsumed;
    @NotNull
    private final ScrollableState scrollableState;
    @NotNull
    private final MutableState slotsPerLine$delegate;
    private boolean wasScrollingForward;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\f\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u00030\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/lazy/grid/LazyGridState;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Saver<LazyGridState, ?> getSaver() {
            return LazyGridState.Saver;
        }
    }

    public LazyGridState() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    public LazyGridState(int i11, int i12) {
        this.scrollPosition = new LazyGridScrollPosition(i11, i12);
        this.layoutInfoState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(EmptyLazyGridLayoutInfo.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.internalInteractionSource = InteractionSourceKt.MutableInteractionSource();
        this.slotsPerLine$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.density$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(DensityKt.Density(1.0f, 1.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.isVertical$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.scrollableState = ScrollableStateKt.ScrollableState(new LazyGridState$scrollableState$1(this));
        this.prefetchingEnabled = true;
        this.lineToPrefetch = -1;
        this.currentLinePrefetchHandles = new MutableVector<>(new LazyLayoutPrefetchState.PrefetchHandle[16], 0);
        this.remeasurement$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.remeasurementModifier = new LazyGridState$remeasurementModifier$1(this);
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        this.prefetchInfoRetriever$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(LazyGridState$prefetchInfoRetriever$2.INSTANCE, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.placementAnimator$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.animateScrollScope = new LazyGridAnimateScrollScope(this);
        this.prefetchState = new LazyLayoutPrefetchState();
    }

    public static /* synthetic */ Object animateScrollToItem$default(LazyGridState lazyGridState, int i11, int i12, Continuation continuation, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i12 = 0;
        }
        return lazyGridState.animateScrollToItem(i11, i12, continuation);
    }

    private final void cancelPrefetchIfVisibleItemsChanged(LazyGridLayoutInfo lazyGridLayoutInfo) {
        int i11;
        int i12;
        if (this.lineToPrefetch != -1 && (!lazyGridLayoutInfo.getVisibleItemsInfo().isEmpty())) {
            LazyGridItemInfo lazyGridItemInfo = (LazyGridItemInfo) CollectionsKt___CollectionsKt.first(lazyGridLayoutInfo.getVisibleItemsInfo());
            if (isVertical$foundation_release()) {
                i11 = lazyGridItemInfo.getRow();
            } else {
                i11 = lazyGridItemInfo.getColumn();
            }
            LazyGridItemInfo lazyGridItemInfo2 = (LazyGridItemInfo) CollectionsKt___CollectionsKt.last(lazyGridLayoutInfo.getVisibleItemsInfo());
            if (isVertical$foundation_release()) {
                i12 = lazyGridItemInfo2.getRow();
            } else {
                i12 = lazyGridItemInfo2.getColumn();
            }
            int i13 = this.lineToPrefetch;
            if (i13 != i11 - 1 && i13 != i12 + 1) {
                this.lineToPrefetch = -1;
                MutableVector<LazyLayoutPrefetchState.PrefetchHandle> mutableVector = this.currentLinePrefetchHandles;
                int size = mutableVector.getSize();
                if (size > 0) {
                    Object[] content = mutableVector.getContent();
                    Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                    int i14 = 0;
                    do {
                        ((LazyLayoutPrefetchState.PrefetchHandle) content[i14]).cancel();
                        i14++;
                    } while (i14 < size);
                }
                this.currentLinePrefetchHandles.clear();
            }
        }
    }

    private final Remeasurement getRemeasurement() {
        return (Remeasurement) this.remeasurement$delegate.getValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ca A[LOOP:1: B:36:0x00c8->B:37:0x00ca, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void notifyPrefetch(float r9) {
        /*
            r8 = this;
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r0 = r8.prefetchState
            boolean r1 = r8.prefetchingEnabled
            if (r1 != 0) goto L_0x0007
            return
        L_0x0007:
            androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo r1 = r8.getLayoutInfo()
            java.util.List r2 = r1.getVisibleItemsInfo()
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r3 = 1
            r2 = r2 ^ r3
            if (r2 == 0) goto L_0x00f0
            r2 = 0
            int r9 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            r2 = 0
            if (r9 >= 0) goto L_0x0021
            r9 = r3
            goto L_0x0022
        L_0x0021:
            r9 = r2
        L_0x0022:
            if (r9 == 0) goto L_0x004e
            java.util.List r4 = r1.getVisibleItemsInfo()
            java.lang.Object r4 = kotlin.collections.CollectionsKt___CollectionsKt.last(r4)
            androidx.compose.foundation.lazy.grid.LazyGridItemInfo r4 = (androidx.compose.foundation.lazy.grid.LazyGridItemInfo) r4
            boolean r5 = r8.isVertical$foundation_release()
            if (r5 == 0) goto L_0x0039
            int r4 = r4.getRow()
            goto L_0x003d
        L_0x0039:
            int r4 = r4.getColumn()
        L_0x003d:
            int r4 = r4 + r3
            java.util.List r5 = r1.getVisibleItemsInfo()
            java.lang.Object r5 = kotlin.collections.CollectionsKt___CollectionsKt.last(r5)
            androidx.compose.foundation.lazy.grid.LazyGridItemInfo r5 = (androidx.compose.foundation.lazy.grid.LazyGridItemInfo) r5
            int r5 = r5.getIndex()
            int r5 = r5 + r3
            goto L_0x0078
        L_0x004e:
            java.util.List r4 = r1.getVisibleItemsInfo()
            java.lang.Object r4 = kotlin.collections.CollectionsKt___CollectionsKt.first(r4)
            androidx.compose.foundation.lazy.grid.LazyGridItemInfo r4 = (androidx.compose.foundation.lazy.grid.LazyGridItemInfo) r4
            boolean r5 = r8.isVertical$foundation_release()
            if (r5 == 0) goto L_0x0063
            int r4 = r4.getRow()
            goto L_0x0067
        L_0x0063:
            int r4 = r4.getColumn()
        L_0x0067:
            int r4 = r4 + -1
            java.util.List r5 = r1.getVisibleItemsInfo()
            java.lang.Object r5 = kotlin.collections.CollectionsKt___CollectionsKt.first(r5)
            androidx.compose.foundation.lazy.grid.LazyGridItemInfo r5 = (androidx.compose.foundation.lazy.grid.LazyGridItemInfo) r5
            int r5 = r5.getIndex()
            int r5 = r5 - r3
        L_0x0078:
            int r6 = r8.lineToPrefetch
            if (r4 == r6) goto L_0x00f0
            if (r5 < 0) goto L_0x0086
            int r1 = r1.getTotalItemsCount()
            if (r5 >= r1) goto L_0x0086
            r1 = r3
            goto L_0x0087
        L_0x0086:
            r1 = r2
        L_0x0087:
            if (r1 == 0) goto L_0x00f0
            boolean r1 = r8.wasScrollingForward
            if (r1 == r9) goto L_0x00a9
            androidx.compose.runtime.collection.MutableVector<androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle> r1 = r8.currentLinePrefetchHandles
            int r5 = r1.getSize()
            if (r5 <= 0) goto L_0x00a9
            java.lang.Object[] r1 = r1.getContent()
            java.lang.String r6 = "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r6)
            r6 = r2
        L_0x009f:
            r7 = r1[r6]
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle r7 = (androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle) r7
            r7.cancel()
            int r6 = r6 + r3
            if (r6 < r5) goto L_0x009f
        L_0x00a9:
            r8.wasScrollingForward = r9
            r8.lineToPrefetch = r4
            androidx.compose.runtime.collection.MutableVector<androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle> r9 = r8.currentLinePrefetchHandles
            r9.clear()
            kotlin.jvm.functions.Function1 r9 = r8.getPrefetchInfoRetriever$foundation_release()
            int r1 = androidx.compose.foundation.lazy.grid.LineIndex.m722constructorimpl(r4)
            androidx.compose.foundation.lazy.grid.LineIndex r1 = androidx.compose.foundation.lazy.grid.LineIndex.m720boximpl(r1)
            java.lang.Object r9 = r9.invoke(r1)
            java.util.List r9 = (java.util.List) r9
            int r1 = r9.size()
        L_0x00c8:
            if (r2 >= r1) goto L_0x00f0
            java.lang.Object r3 = r9.get(r2)
            kotlin.Pair r3 = (kotlin.Pair) r3
            androidx.compose.runtime.collection.MutableVector<androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle> r4 = r8.currentLinePrefetchHandles
            java.lang.Object r5 = r3.getFirst()
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            java.lang.Object r3 = r3.getSecond()
            androidx.compose.ui.unit.Constraints r3 = (androidx.compose.ui.unit.Constraints) r3
            long r6 = r3.m5428unboximpl()
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState$PrefetchHandle r3 = r0.m760schedulePrefetch0kLqBqw(r5, r6)
            r4.add(r3)
            int r2 = r2 + 1
            goto L_0x00c8
        L_0x00f0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridState.notifyPrefetch(float):void");
    }

    public static /* synthetic */ Object scrollToItem$default(LazyGridState lazyGridState, int i11, int i12, Continuation continuation, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i12 = 0;
        }
        return lazyGridState.scrollToItem(i11, i12, continuation);
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

    public final void applyMeasureResult$foundation_release(@NotNull LazyGridMeasureResult lazyGridMeasureResult) {
        int i11;
        Intrinsics.checkNotNullParameter(lazyGridMeasureResult, "result");
        this.scrollPosition.updateFromMeasureResult(lazyGridMeasureResult);
        this.scrollToBeConsumed -= lazyGridMeasureResult.getConsumedScroll();
        this.layoutInfoState.setValue(lazyGridMeasureResult);
        this.canScrollForward = lazyGridMeasureResult.getCanScrollForward();
        LazyMeasuredLine firstVisibleLine = lazyGridMeasureResult.getFirstVisibleLine();
        boolean z11 = false;
        if (firstVisibleLine != null) {
            i11 = firstVisibleLine.m717getIndexhA7yfN8();
        } else {
            i11 = 0;
        }
        if (!(i11 == 0 && lazyGridMeasureResult.getFirstVisibleLineScrollOffset() == 0)) {
            z11 = true;
        }
        this.canScrollBackward = z11;
        this.numMeasurePasses++;
        cancelPrefetchIfVisibleItemsChanged(lazyGridMeasureResult);
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
        return this.scrollPosition.m710getIndexVZbfaAc();
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
    public final LazyGridLayoutInfo getLayoutInfo() {
        return this.layoutInfoState.getValue();
    }

    public final int getNumMeasurePasses$foundation_release() {
        return this.numMeasurePasses;
    }

    @Nullable
    public final LazyGridItemPlacementAnimator getPlacementAnimator$foundation_release() {
        return (LazyGridItemPlacementAnimator) this.placementAnimator$delegate.getValue();
    }

    @NotNull
    public final Function1<LineIndex, List<Pair<Integer, Constraints>>> getPrefetchInfoRetriever$foundation_release() {
        return (Function1) this.prefetchInfoRetriever$delegate.getValue();
    }

    @NotNull
    public final LazyLayoutPrefetchState getPrefetchState$foundation_release() {
        return this.prefetchState;
    }

    public final boolean getPrefetchingEnabled$foundation_release() {
        return this.prefetchingEnabled;
    }

    @NotNull
    public final RemeasurementModifier getRemeasurementModifier$foundation_release() {
        return this.remeasurementModifier;
    }

    public final float getScrollToBeConsumed$foundation_release() {
        return this.scrollToBeConsumed;
    }

    public final int getSlotsPerLine$foundation_release() {
        return ((Number) this.slotsPerLine$delegate.getValue()).intValue();
    }

    public boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    public final boolean isVertical$foundation_release() {
        return ((Boolean) this.isVertical$delegate.getValue()).booleanValue();
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
                Remeasurement remeasurement = getRemeasurement();
                if (remeasurement != null) {
                    remeasurement.forceRemeasure();
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
            boolean r0 = r8 instanceof androidx.compose.foundation.lazy.grid.LazyGridState$scroll$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            androidx.compose.foundation.lazy.grid.LazyGridState$scroll$1 r0 = (androidx.compose.foundation.lazy.grid.LazyGridState$scroll$1) r0
            int r1 = r0.f2962m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f2962m = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.foundation.lazy.grid.LazyGridState$scroll$1 r0 = new androidx.compose.foundation.lazy.grid.LazyGridState$scroll$1
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f2960k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f2962m
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
            java.lang.Object r6 = r0.f2959j
            r7 = r6
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r6 = r0.f2958i
            androidx.compose.foundation.MutatePriority r6 = (androidx.compose.foundation.MutatePriority) r6
            java.lang.Object r2 = r0.f2957h
            androidx.compose.foundation.lazy.grid.LazyGridState r2 = (androidx.compose.foundation.lazy.grid.LazyGridState) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x005a
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r8)
            androidx.compose.foundation.lazy.AwaitFirstLayoutModifier r8 = r5.awaitLayoutModifier
            r0.f2957h = r5
            r0.f2958i = r6
            r0.f2959j = r7
            r0.f2962m = r4
            java.lang.Object r8 = r8.waitForFirstLayout(r0)
            if (r8 != r1) goto L_0x0059
            return r1
        L_0x0059:
            r2 = r5
        L_0x005a:
            androidx.compose.foundation.gestures.ScrollableState r8 = r2.scrollableState
            r2 = 0
            r0.f2957h = r2
            r0.f2958i = r2
            r0.f2959j = r2
            r0.f2962m = r3
            java.lang.Object r6 = r8.scroll(r6, r7, r0)
            if (r6 != r1) goto L_0x006c
            return r1
        L_0x006c:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridState.scroll(androidx.compose.foundation.MutatePriority, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public final Object scrollToItem(int i11, int i12, @NotNull Continuation<? super Unit> continuation) {
        Object a11 = c.a(this, (MutatePriority) null, new LazyGridState$scrollToItem$2(this, i11, i12, (Continuation<? super LazyGridState$scrollToItem$2>) null), continuation, 1, (Object) null);
        return a11 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a11 : Unit.INSTANCE;
    }

    public final void setDensity$foundation_release(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "<set-?>");
        this.density$delegate.setValue(density);
    }

    public final void setPlacementAnimator$foundation_release(@Nullable LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator) {
        this.placementAnimator$delegate.setValue(lazyGridItemPlacementAnimator);
    }

    public final void setPrefetchInfoRetriever$foundation_release(@NotNull Function1<? super LineIndex, ? extends List<Pair<Integer, Constraints>>> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.prefetchInfoRetriever$delegate.setValue(function1);
    }

    public final void setPrefetchingEnabled$foundation_release(boolean z11) {
        this.prefetchingEnabled = z11;
    }

    public final void setSlotsPerLine$foundation_release(int i11) {
        this.slotsPerLine$delegate.setValue(Integer.valueOf(i11));
    }

    public final void setVertical$foundation_release(boolean z11) {
        this.isVertical$delegate.setValue(Boolean.valueOf(z11));
    }

    public final void snapToItemIndexInternal$foundation_release(int i11, int i12) {
        this.scrollPosition.m711requestPositionyO3Fmg4(ItemIndex.m666constructorimpl(i11), i12);
        LazyGridItemPlacementAnimator placementAnimator$foundation_release = getPlacementAnimator$foundation_release();
        if (placementAnimator$foundation_release != null) {
            placementAnimator$foundation_release.reset();
        }
        Remeasurement remeasurement = getRemeasurement();
        if (remeasurement != null) {
            remeasurement.forceRemeasure();
        }
    }

    public final void updateScrollPositionIfTheFirstItemWasMoved$foundation_release(@NotNull LazyGridItemProvider lazyGridItemProvider) {
        Intrinsics.checkNotNullParameter(lazyGridItemProvider, "itemProvider");
        this.scrollPosition.updateScrollPositionIfTheFirstItemWasMoved(lazyGridItemProvider);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyGridState(int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 0 : i11, (i13 & 2) != 0 ? 0 : i12);
    }
}
