package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.snapshots.Snapshot;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J#\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0005J%\u0010\u0019\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0003H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R4\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@BX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R+\u0010\u0012\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038F@BX\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridScrollPosition;", "", "initialIndex", "", "initialScrollOffset", "(II)V", "hadFirstNotEmptyLayout", "", "<set-?>", "Landroidx/compose/foundation/lazy/grid/ItemIndex;", "index", "getIndex-VZbfaAc", "()I", "setIndex-YGsSkvE", "(I)V", "index$delegate", "Landroidx/compose/runtime/MutableState;", "lastKnownFirstItemKey", "scrollOffset", "getScrollOffset", "setScrollOffset", "scrollOffset$delegate", "requestPosition", "", "requestPosition-yO3Fmg4", "update", "update-yO3Fmg4", "updateFromMeasureResult", "measureResult", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LazyGridScrollPosition {
    private boolean hadFirstNotEmptyLayout;
    @NotNull
    private final MutableState index$delegate;
    @Nullable
    private Object lastKnownFirstItemKey;
    @NotNull
    private final MutableState scrollOffset$delegate;

    public LazyGridScrollPosition() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    public LazyGridScrollPosition(int i11, int i12) {
        this.index$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ItemIndex.m664boximpl(ItemIndex.m666constructorimpl(i11)), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.scrollOffset$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(i12), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    /* renamed from: setIndex-YGsSkvE  reason: not valid java name */
    private final void m708setIndexYGsSkvE(int i11) {
        this.index$delegate.setValue(ItemIndex.m664boximpl(i11));
    }

    private final void setScrollOffset(int i11) {
        this.scrollOffset$delegate.setValue(Integer.valueOf(i11));
    }

    /* renamed from: update-yO3Fmg4  reason: not valid java name */
    private final void m709updateyO3Fmg4(int i11, int i12) {
        boolean z11;
        if (((float) i11) >= 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (!ItemIndex.m669equalsimpl0(i11, m710getIndexVZbfaAc())) {
                m708setIndexYGsSkvE(i11);
            }
            if (i12 != getScrollOffset()) {
                setScrollOffset(i12);
                return;
            }
            return;
        }
        throw new IllegalArgumentException(("Index should be non-negative (" + i11 + ')').toString());
    }

    /* renamed from: getIndex-VZbfaAc  reason: not valid java name */
    public final int m710getIndexVZbfaAc() {
        return ((ItemIndex) this.index$delegate.getValue()).m676unboximpl();
    }

    public final int getScrollOffset() {
        return ((Number) this.scrollOffset$delegate.getValue()).intValue();
    }

    /* renamed from: requestPosition-yO3Fmg4  reason: not valid java name */
    public final void m711requestPositionyO3Fmg4(int i11, int i12) {
        m709updateyO3Fmg4(i11, i12);
        this.lastKnownFirstItemKey = null;
    }

    public final void updateFromMeasureResult(@NotNull LazyGridMeasureResult lazyGridMeasureResult) {
        Object obj;
        Snapshot makeCurrent;
        LazyMeasuredItem[] items;
        LazyMeasuredItem lazyMeasuredItem;
        LazyMeasuredItem[] items2;
        LazyMeasuredItem lazyMeasuredItem2;
        Intrinsics.checkNotNullParameter(lazyGridMeasureResult, "measureResult");
        LazyMeasuredLine firstVisibleLine = lazyGridMeasureResult.getFirstVisibleLine();
        if (firstVisibleLine == null || (items2 = firstVisibleLine.getItems()) == null || (lazyMeasuredItem2 = (LazyMeasuredItem) ArraysKt___ArraysKt.firstOrNull((T[]) items2)) == null) {
            obj = null;
        } else {
            obj = lazyMeasuredItem2.getKey();
        }
        this.lastKnownFirstItemKey = obj;
        if (this.hadFirstNotEmptyLayout || lazyGridMeasureResult.getTotalItemsCount() > 0) {
            boolean z11 = true;
            this.hadFirstNotEmptyLayout = true;
            int firstVisibleLineScrollOffset = lazyGridMeasureResult.getFirstVisibleLineScrollOffset();
            int i11 = 0;
            if (((float) firstVisibleLineScrollOffset) < 0.0f) {
                z11 = false;
            }
            if (z11) {
                Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
                try {
                    makeCurrent = createNonObservableSnapshot.makeCurrent();
                    LazyMeasuredLine firstVisibleLine2 = lazyGridMeasureResult.getFirstVisibleLine();
                    if (!(firstVisibleLine2 == null || (items = firstVisibleLine2.getItems()) == null || (lazyMeasuredItem = (LazyMeasuredItem) ArraysKt___ArraysKt.firstOrNull((T[]) items)) == null)) {
                        i11 = lazyMeasuredItem.m714getIndexVZbfaAc();
                    }
                    m709updateyO3Fmg4(ItemIndex.m666constructorimpl(i11), firstVisibleLineScrollOffset);
                    Unit unit = Unit.INSTANCE;
                    createNonObservableSnapshot.restoreCurrent(makeCurrent);
                    createNonObservableSnapshot.dispose();
                } catch (Throwable th2) {
                    createNonObservableSnapshot.dispose();
                    throw th2;
                }
            } else {
                throw new IllegalStateException(("scrollOffset should be non-negative (" + firstVisibleLineScrollOffset + ')').toString());
            }
        }
    }

    public final void updateScrollPositionIfTheFirstItemWasMoved(@NotNull LazyGridItemProvider lazyGridItemProvider) {
        Snapshot makeCurrent;
        Intrinsics.checkNotNullParameter(lazyGridItemProvider, "itemProvider");
        Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
        try {
            makeCurrent = createNonObservableSnapshot.makeCurrent();
            m709updateyO3Fmg4(ItemIndex.m666constructorimpl(LazyLayoutItemProviderKt.findIndexByKey(lazyGridItemProvider, this.lastKnownFirstItemKey, m710getIndexVZbfaAc())), getScrollOffset());
            Unit unit = Unit.INSTANCE;
            createNonObservableSnapshot.restoreCurrent(makeCurrent);
            createNonObservableSnapshot.dispose();
        } catch (Throwable th2) {
            createNonObservableSnapshot.dispose();
            throw th2;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyGridScrollPosition(int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 0 : i11, (i13 & 2) != 0 ? 0 : i12);
    }
}
