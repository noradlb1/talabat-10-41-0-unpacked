package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ-\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyMeasuredItemProvider;", "", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "measureScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "defaultMainAxisSpacing", "", "measuredItemFactory", "Landroidx/compose/foundation/lazy/grid/MeasuredItemFactory;", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;ILandroidx/compose/foundation/lazy/grid/MeasuredItemFactory;)V", "keyToIndexMap", "", "getKeyToIndexMap", "()Ljava/util/Map;", "getAndMeasure", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredItem;", "index", "Landroidx/compose/foundation/lazy/grid/ItemIndex;", "mainAxisSpacing", "constraints", "Landroidx/compose/ui/unit/Constraints;", "getAndMeasure-ednRnyU", "(IIJ)Landroidx/compose/foundation/lazy/grid/LazyMeasuredItem;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LazyMeasuredItemProvider {
    private final int defaultMainAxisSpacing;
    @NotNull
    private final LazyGridItemProvider itemProvider;
    @NotNull
    private final LazyLayoutMeasureScope measureScope;
    @NotNull
    private final MeasuredItemFactory measuredItemFactory;

    @ExperimentalFoundationApi
    public LazyMeasuredItemProvider(@NotNull LazyGridItemProvider lazyGridItemProvider, @NotNull LazyLayoutMeasureScope lazyLayoutMeasureScope, int i11, @NotNull MeasuredItemFactory measuredItemFactory2) {
        Intrinsics.checkNotNullParameter(lazyGridItemProvider, "itemProvider");
        Intrinsics.checkNotNullParameter(lazyLayoutMeasureScope, "measureScope");
        Intrinsics.checkNotNullParameter(measuredItemFactory2, "measuredItemFactory");
        this.itemProvider = lazyGridItemProvider;
        this.measureScope = lazyLayoutMeasureScope;
        this.defaultMainAxisSpacing = i11;
        this.measuredItemFactory = measuredItemFactory2;
    }

    /* renamed from: getAndMeasure-ednRnyU$default  reason: not valid java name */
    public static /* synthetic */ LazyMeasuredItem m715getAndMeasureednRnyU$default(LazyMeasuredItemProvider lazyMeasuredItemProvider, int i11, int i12, long j11, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i12 = lazyMeasuredItemProvider.defaultMainAxisSpacing;
        }
        return lazyMeasuredItemProvider.m716getAndMeasureednRnyU(i11, i12, j11);
    }

    @NotNull
    /* renamed from: getAndMeasure-ednRnyU  reason: not valid java name */
    public final LazyMeasuredItem m716getAndMeasureednRnyU(int i11, int i12, long j11) {
        int r102;
        Object key = this.itemProvider.getKey(i11);
        List<Placeable> r62 = this.measureScope.m738measure0kLqBqw(i11, j11);
        if (Constraints.m5420getHasFixedWidthimpl(j11)) {
            r102 = Constraints.m5424getMinWidthimpl(j11);
        } else if (Constraints.m5419getHasFixedHeightimpl(j11)) {
            r102 = Constraints.m5423getMinHeightimpl(j11);
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        return this.measuredItemFactory.m733createItemPU_OBEw(i11, key, r102, i12, r62);
    }

    @NotNull
    public final Map<Object, Integer> getKeyToIndexMap() {
        return this.itemProvider.getKeyToIndexMap();
    }
}
