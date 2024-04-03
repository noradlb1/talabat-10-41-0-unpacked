package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001f\u0010 R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006!"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyMeasuredLineProvider;", "", "isVertical", "", "slotSizesSums", "", "", "crossAxisSpacing", "gridItemsCount", "spaceBetweenLines", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredItemProvider;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "measuredLineFactory", "Landroidx/compose/foundation/lazy/grid/MeasuredLineFactory;", "(ZLjava/util/List;IIILandroidx/compose/foundation/lazy/grid/LazyMeasuredItemProvider;Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;Landroidx/compose/foundation/lazy/grid/MeasuredLineFactory;)V", "keyToIndexMap", "", "getKeyToIndexMap", "()Ljava/util/Map;", "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "startSlot", "span", "childConstraints-JhjzzOo$foundation_release", "(II)J", "getAndMeasure", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredLine;", "lineIndex", "Landroidx/compose/foundation/lazy/grid/LineIndex;", "getAndMeasure-bKFJvoY", "(I)Landroidx/compose/foundation/lazy/grid/LazyMeasuredLine;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LazyMeasuredLineProvider {
    private final int crossAxisSpacing;
    private final int gridItemsCount;
    private final boolean isVertical;
    @NotNull
    private final LazyMeasuredItemProvider measuredItemProvider;
    @NotNull
    private final MeasuredLineFactory measuredLineFactory;
    @NotNull
    private final List<Integer> slotSizesSums;
    private final int spaceBetweenLines;
    @NotNull
    private final LazyGridSpanLayoutProvider spanLayoutProvider;

    public LazyMeasuredLineProvider(boolean z11, @NotNull List<Integer> list, int i11, int i12, int i13, @NotNull LazyMeasuredItemProvider lazyMeasuredItemProvider, @NotNull LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider, @NotNull MeasuredLineFactory measuredLineFactory2) {
        Intrinsics.checkNotNullParameter(list, "slotSizesSums");
        Intrinsics.checkNotNullParameter(lazyMeasuredItemProvider, "measuredItemProvider");
        Intrinsics.checkNotNullParameter(lazyGridSpanLayoutProvider, "spanLayoutProvider");
        Intrinsics.checkNotNullParameter(measuredLineFactory2, "measuredLineFactory");
        this.isVertical = z11;
        this.slotSizesSums = list;
        this.crossAxisSpacing = i11;
        this.gridItemsCount = i12;
        this.spaceBetweenLines = i13;
        this.measuredItemProvider = lazyMeasuredItemProvider;
        this.spanLayoutProvider = lazyGridSpanLayoutProvider;
        this.measuredLineFactory = measuredLineFactory2;
    }

    /* renamed from: childConstraints-JhjzzOo$foundation_release  reason: not valid java name */
    public final long m718childConstraintsJhjzzOo$foundation_release(int i11, int i12) {
        int i13;
        int intValue = this.slotSizesSums.get((i11 + i12) - 1).intValue();
        if (i11 == 0) {
            i13 = 0;
        } else {
            i13 = this.slotSizesSums.get(i11 - 1).intValue();
        }
        int coerceAtLeast = RangesKt___RangesKt.coerceAtLeast((intValue - i13) + (this.crossAxisSpacing * (i12 - 1)), 0);
        if (this.isVertical) {
            return Constraints.Companion.m5432fixedWidthOenEA2s(coerceAtLeast);
        }
        return Constraints.Companion.m5431fixedHeightOenEA2s(coerceAtLeast);
    }

    @NotNull
    /* renamed from: getAndMeasure-bKFJvoY  reason: not valid java name */
    public final LazyMeasuredLine m719getAndMeasurebKFJvoY(int i11) {
        int i12;
        LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = this.spanLayoutProvider.getLineConfiguration(i11);
        int size = lineConfiguration.getSpans().size();
        if (size == 0 || lineConfiguration.getFirstItemIndex() + size == this.gridItemsCount) {
            i12 = 0;
        } else {
            i12 = this.spaceBetweenLines;
        }
        LazyMeasuredItem[] lazyMeasuredItemArr = new LazyMeasuredItem[size];
        int i13 = 0;
        for (int i14 = 0; i14 < size; i14++) {
            int r62 = GridItemSpan.m660getCurrentLineSpanimpl(lineConfiguration.getSpans().get(i14).m663unboximpl());
            LazyMeasuredItem r72 = this.measuredItemProvider.m716getAndMeasureednRnyU(ItemIndex.m666constructorimpl(lineConfiguration.getFirstItemIndex() + i14), i12, m718childConstraintsJhjzzOo$foundation_release(i13, r62));
            i13 += r62;
            Unit unit = Unit.INSTANCE;
            lazyMeasuredItemArr[i14] = r72;
        }
        return this.measuredLineFactory.m734createLineH9FfpSk(i11, lazyMeasuredItemArr, lineConfiguration.getSpans(), i12);
    }

    @NotNull
    public final Map<Object, Integer> getKeyToIndexMap() {
        return this.measuredItemProvider.getKeyToIndexMap();
    }
}
