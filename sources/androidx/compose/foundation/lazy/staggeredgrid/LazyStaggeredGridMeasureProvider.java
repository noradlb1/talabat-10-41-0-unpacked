package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureProvider;", "", "isVertical", "", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "measureScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "resolvedSlotSums", "", "measuredItemFactory", "Landroidx/compose/foundation/lazy/staggeredgrid/MeasuredItemFactory;", "(ZLandroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;[ILandroidx/compose/foundation/lazy/staggeredgrid/MeasuredItemFactory;)V", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "slot", "", "childConstraints-OenEA2s", "(I)J", "getAndMeasure", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "index", "lane", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class LazyStaggeredGridMeasureProvider {
    private final boolean isVertical;
    @NotNull
    private final LazyLayoutItemProvider itemProvider;
    @NotNull
    private final LazyLayoutMeasureScope measureScope;
    @NotNull
    private final MeasuredItemFactory measuredItemFactory;
    @NotNull
    private final int[] resolvedSlotSums;

    public LazyStaggeredGridMeasureProvider(boolean z11, @NotNull LazyLayoutItemProvider lazyLayoutItemProvider, @NotNull LazyLayoutMeasureScope lazyLayoutMeasureScope, @NotNull int[] iArr, @NotNull MeasuredItemFactory measuredItemFactory2) {
        Intrinsics.checkNotNullParameter(lazyLayoutItemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(lazyLayoutMeasureScope, "measureScope");
        Intrinsics.checkNotNullParameter(iArr, "resolvedSlotSums");
        Intrinsics.checkNotNullParameter(measuredItemFactory2, "measuredItemFactory");
        this.isVertical = z11;
        this.itemProvider = lazyLayoutItemProvider;
        this.measureScope = lazyLayoutMeasureScope;
        this.resolvedSlotSums = iArr;
        this.measuredItemFactory = measuredItemFactory2;
    }

    /* renamed from: childConstraints-OenEA2s  reason: not valid java name */
    private final long m777childConstraintsOenEA2s(int i11) {
        int i12;
        if (i11 == 0) {
            i12 = 0;
        } else {
            i12 = this.resolvedSlotSums[i11 - 1];
        }
        int i13 = this.resolvedSlotSums[i11] - i12;
        if (this.isVertical) {
            return Constraints.Companion.m5432fixedWidthOenEA2s(i13);
        }
        return Constraints.Companion.m5431fixedHeightOenEA2s(i13);
    }

    @NotNull
    public final LazyStaggeredGridMeasuredItem getAndMeasure(int i11, int i12) {
        return this.measuredItemFactory.createItem(i11, i12, this.itemProvider.getKey(i11), this.measureScope.m738measure0kLqBqw(i11, m777childConstraintsOenEA2s(i12)));
    }
}
