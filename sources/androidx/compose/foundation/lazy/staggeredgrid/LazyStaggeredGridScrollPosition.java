package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProviderKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.snapshots.Snapshot;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00126\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\fJ\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007J\u0018\u0010 \u001a\u00020\u001d2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003H\u0002J\u000e\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&H\u0007R>\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R+\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00038F@FX\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R+\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00038F@FX\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014¨\u0006'"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridScrollPosition;", "", "initialIndices", "", "initialOffsets", "fillIndices", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "targetIndex", "laneCount", "([I[ILkotlin/jvm/functions/Function2;)V", "hadFirstNotEmptyLayout", "", "<set-?>", "indices", "getIndices", "()[I", "setIndices", "([I)V", "indices$delegate", "Landroidx/compose/runtime/MutableState;", "lastKnownFirstItemKey", "offsets", "getOffsets", "setOffsets", "offsets$delegate", "requestPosition", "", "index", "scrollOffset", "update", "updateFromMeasureResult", "measureResult", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "updateScrollPositionIfTheFirstItemWasMoved", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalFoundationApi
public final class LazyStaggeredGridScrollPosition {
    @NotNull
    private final Function2<Integer, Integer, int[]> fillIndices;
    private boolean hadFirstNotEmptyLayout;
    @NotNull
    private final MutableState indices$delegate;
    @Nullable
    private Object lastKnownFirstItemKey;
    @NotNull
    private final MutableState offsets$delegate;

    public LazyStaggeredGridScrollPosition(@NotNull int[] iArr, @NotNull int[] iArr2, @NotNull Function2<? super Integer, ? super Integer, int[]> function2) {
        Intrinsics.checkNotNullParameter(iArr, "initialIndices");
        Intrinsics.checkNotNullParameter(iArr2, "initialOffsets");
        Intrinsics.checkNotNullParameter(function2, "fillIndices");
        this.fillIndices = function2;
        this.indices$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(iArr, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.offsets$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(iArr2, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    private final void update(int[] iArr, int[] iArr2) {
        if (!Arrays.equals(iArr, getIndices())) {
            setIndices(iArr);
        }
        if (!Arrays.equals(iArr2, getOffsets())) {
            setOffsets(iArr2);
        }
    }

    @NotNull
    public final int[] getIndices() {
        return (int[]) this.indices$delegate.getValue();
    }

    @NotNull
    public final int[] getOffsets() {
        return (int[]) this.offsets$delegate.getValue();
    }

    public final void requestPosition(int i11, int i12) {
        int[] invoke = this.fillIndices.invoke(Integer.valueOf(i11), Integer.valueOf(getIndices().length));
        int length = invoke.length;
        int[] iArr = new int[length];
        for (int i13 = 0; i13 < length; i13++) {
            iArr[i13] = i12;
        }
        update(invoke, iArr);
        this.lastKnownFirstItemKey = null;
    }

    public final void setIndices(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.indices$delegate.setValue(iArr);
    }

    public final void setOffsets(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.offsets$delegate.setValue(iArr);
    }

    public final void updateFromMeasureResult(@NotNull LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResult) {
        Object obj;
        Snapshot makeCurrent;
        Intrinsics.checkNotNullParameter(lazyStaggeredGridMeasureResult, "measureResult");
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfo = (LazyStaggeredGridItemInfo) CollectionsKt___CollectionsKt.firstOrNull(lazyStaggeredGridMeasureResult.getVisibleItemsInfo());
        if (lazyStaggeredGridItemInfo != null) {
            obj = lazyStaggeredGridItemInfo.getKey();
        } else {
            obj = null;
        }
        this.lastKnownFirstItemKey = obj;
        if (this.hadFirstNotEmptyLayout || lazyStaggeredGridMeasureResult.getTotalItemsCount() > 0) {
            this.hadFirstNotEmptyLayout = true;
            Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
            try {
                makeCurrent = createNonObservableSnapshot.makeCurrent();
                update(lazyStaggeredGridMeasureResult.getFirstVisibleItemIndices(), lazyStaggeredGridMeasureResult.getFirstVisibleItemScrollOffsets());
                Unit unit = Unit.INSTANCE;
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
                createNonObservableSnapshot.dispose();
            } catch (Throwable th2) {
                createNonObservableSnapshot.dispose();
                throw th2;
            }
        }
    }

    @ExperimentalFoundationApi
    public final void updateScrollPositionIfTheFirstItemWasMoved(@NotNull LazyLayoutItemProvider lazyLayoutItemProvider) {
        Snapshot makeCurrent;
        Intrinsics.checkNotNullParameter(lazyLayoutItemProvider, "itemProvider");
        Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
        try {
            makeCurrent = createNonObservableSnapshot.makeCurrent();
            Object obj = this.lastKnownFirstItemKey;
            int i11 = 0;
            Integer orNull = ArraysKt___ArraysKt.getOrNull(getIndices(), 0);
            if (orNull != null) {
                i11 = orNull.intValue();
            }
            int findIndexByKey = LazyLayoutItemProviderKt.findIndexByKey(lazyLayoutItemProvider, obj, i11);
            if (!ArraysKt___ArraysKt.contains(getIndices(), findIndexByKey)) {
                update(this.fillIndices.invoke(Integer.valueOf(findIndexByKey), Integer.valueOf(getIndices().length)), getOffsets());
            }
            Unit unit = Unit.INSTANCE;
            createNonObservableSnapshot.restoreCurrent(makeCurrent);
            createNonObservableSnapshot.dispose();
        } catch (Throwable th2) {
            createNonObservableSnapshot.dispose();
            throw th2;
        }
    }
}
