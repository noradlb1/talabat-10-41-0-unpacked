package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
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

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J#\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0005J%\u0010\u0019\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0003H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u000e\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R4\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R+\u0010\u0012\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00038F@BX\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListScrollPosition;", "", "initialIndex", "", "initialScrollOffset", "(II)V", "hadFirstNotEmptyLayout", "", "<set-?>", "Landroidx/compose/foundation/lazy/DataIndex;", "index", "getIndex-jQJCoq8", "()I", "setIndex-ZjPyQlc", "(I)V", "index$delegate", "Landroidx/compose/runtime/MutableState;", "lastKnownFirstItemKey", "scrollOffset", "getScrollOffset", "setScrollOffset", "scrollOffset$delegate", "requestPosition", "", "requestPosition-AhXoVpI", "update", "update-AhXoVpI", "updateFromMeasureResult", "measureResult", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LazyListScrollPosition {
    private boolean hadFirstNotEmptyLayout;
    @NotNull
    private final MutableState index$delegate;
    @Nullable
    private Object lastKnownFirstItemKey;
    @NotNull
    private final MutableState scrollOffset$delegate;

    public LazyListScrollPosition() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    public LazyListScrollPosition(int i11, int i12) {
        this.index$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(DataIndex.m610boximpl(DataIndex.m612constructorimpl(i11)), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.scrollOffset$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(i12), (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    private final void setScrollOffset(int i11) {
        this.scrollOffset$delegate.setValue(Integer.valueOf(i11));
    }

    /* renamed from: update-AhXoVpI  reason: not valid java name */
    private final void m642updateAhXoVpI(int i11, int i12) {
        boolean z11;
        if (((float) i11) >= 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (!DataIndex.m615equalsimpl0(i11, m643getIndexjQJCoq8())) {
                m645setIndexZjPyQlc(i11);
            }
            if (i12 != getScrollOffset()) {
                setScrollOffset(i12);
                return;
            }
            return;
        }
        throw new IllegalArgumentException(("Index should be non-negative (" + i11 + ')').toString());
    }

    /* renamed from: getIndex-jQJCoq8  reason: not valid java name */
    public final int m643getIndexjQJCoq8() {
        return ((DataIndex) this.index$delegate.getValue()).m622unboximpl();
    }

    public final int getScrollOffset() {
        return ((Number) this.scrollOffset$delegate.getValue()).intValue();
    }

    /* renamed from: requestPosition-AhXoVpI  reason: not valid java name */
    public final void m644requestPositionAhXoVpI(int i11, int i12) {
        m642updateAhXoVpI(i11, i12);
        this.lastKnownFirstItemKey = null;
    }

    /* renamed from: setIndex-ZjPyQlc  reason: not valid java name */
    public final void m645setIndexZjPyQlc(int i11) {
        this.index$delegate.setValue(DataIndex.m610boximpl(i11));
    }

    public final void updateFromMeasureResult(@NotNull LazyListMeasureResult lazyListMeasureResult) {
        Object obj;
        Snapshot makeCurrent;
        Intrinsics.checkNotNullParameter(lazyListMeasureResult, "measureResult");
        LazyMeasuredItem firstVisibleItem = lazyListMeasureResult.getFirstVisibleItem();
        if (firstVisibleItem != null) {
            obj = firstVisibleItem.getKey();
        } else {
            obj = null;
        }
        this.lastKnownFirstItemKey = obj;
        if (this.hadFirstNotEmptyLayout || lazyListMeasureResult.getTotalItemsCount() > 0) {
            boolean z11 = true;
            this.hadFirstNotEmptyLayout = true;
            int firstVisibleItemScrollOffset = lazyListMeasureResult.getFirstVisibleItemScrollOffset();
            int i11 = 0;
            if (((float) firstVisibleItemScrollOffset) < 0.0f) {
                z11 = false;
            }
            if (z11) {
                Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
                try {
                    makeCurrent = createNonObservableSnapshot.makeCurrent();
                    LazyMeasuredItem firstVisibleItem2 = lazyListMeasureResult.getFirstVisibleItem();
                    if (firstVisibleItem2 != null) {
                        i11 = firstVisibleItem2.getIndex();
                    }
                    m642updateAhXoVpI(DataIndex.m612constructorimpl(i11), firstVisibleItemScrollOffset);
                    Unit unit = Unit.INSTANCE;
                    createNonObservableSnapshot.restoreCurrent(makeCurrent);
                    createNonObservableSnapshot.dispose();
                } catch (Throwable th2) {
                    createNonObservableSnapshot.dispose();
                    throw th2;
                }
            } else {
                throw new IllegalStateException(("scrollOffset should be non-negative (" + firstVisibleItemScrollOffset + ')').toString());
            }
        }
    }

    @ExperimentalFoundationApi
    public final void updateScrollPositionIfTheFirstItemWasMoved(@NotNull LazyListItemProvider lazyListItemProvider) {
        Snapshot makeCurrent;
        Intrinsics.checkNotNullParameter(lazyListItemProvider, "itemProvider");
        Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
        try {
            makeCurrent = createNonObservableSnapshot.makeCurrent();
            m642updateAhXoVpI(DataIndex.m612constructorimpl(LazyLayoutItemProviderKt.findIndexByKey(lazyListItemProvider, this.lastKnownFirstItemKey, m643getIndexjQJCoq8())), getScrollOffset());
            Unit unit = Unit.INSTANCE;
            createNonObservableSnapshot.restoreCurrent(makeCurrent);
            createNonObservableSnapshot.dispose();
        } catch (Throwable th2) {
            createNonObservableSnapshot.dispose();
            throw th2;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LazyListScrollPosition(int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 0 : i11, (i13 & 2) != 0 ? 0 : i12);
    }
}
