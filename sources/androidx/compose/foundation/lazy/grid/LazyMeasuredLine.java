package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001BT\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\rø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0006\u0010\u001d\u001a\u00020\u000bJ$\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\b2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\rR\u000e\u0010\u0011\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\u001b\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u000e\u0010\u0010\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006#"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyMeasuredLine;", "", "index", "Landroidx/compose/foundation/lazy/grid/LineIndex;", "items", "", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredItem;", "spans", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "isVertical", "", "slotsPerLine", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "mainAxisSpacing", "crossAxisSpacing", "(I[Landroidx/compose/foundation/lazy/grid/LazyMeasuredItem;Ljava/util/List;ZILandroidx/compose/ui/unit/LayoutDirection;IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIndex-hA7yfN8", "()I", "I", "getItems", "()[Landroidx/compose/foundation/lazy/grid/LazyMeasuredItem;", "[Landroidx/compose/foundation/lazy/grid/LazyMeasuredItem;", "mainAxisSize", "getMainAxisSize", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "isEmpty", "position", "Landroidx/compose/foundation/lazy/grid/LazyGridPositionedItem;", "offset", "layoutWidth", "layoutHeight", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LazyMeasuredLine {
    private final int crossAxisSpacing;
    private final int index;
    private final boolean isVertical;
    @NotNull
    private final LazyMeasuredItem[] items;
    @NotNull
    private final LayoutDirection layoutDirection;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private final int mainAxisSpacing;
    private final int slotsPerLine;
    @NotNull
    private final List<GridItemSpan> spans;

    private LazyMeasuredLine(int i11, LazyMeasuredItem[] lazyMeasuredItemArr, List<GridItemSpan> list, boolean z11, int i12, LayoutDirection layoutDirection2, int i13, int i14) {
        this.index = i11;
        this.items = lazyMeasuredItemArr;
        this.spans = list;
        this.isVertical = z11;
        this.slotsPerLine = i12;
        this.layoutDirection = layoutDirection2;
        this.mainAxisSpacing = i13;
        this.crossAxisSpacing = i14;
        int i15 = 0;
        for (LazyMeasuredItem mainAxisSize2 : lazyMeasuredItemArr) {
            i15 = Math.max(i15, mainAxisSize2.getMainAxisSize());
        }
        this.mainAxisSize = i15;
        this.mainAxisSizeWithSpacings = i15 + this.mainAxisSpacing;
    }

    public /* synthetic */ LazyMeasuredLine(int i11, LazyMeasuredItem[] lazyMeasuredItemArr, List list, boolean z11, int i12, LayoutDirection layoutDirection2, int i13, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, lazyMeasuredItemArr, list, z11, i12, layoutDirection2, i13, i14);
    }

    /* renamed from: getIndex-hA7yfN8  reason: not valid java name */
    public final int m717getIndexhA7yfN8() {
        return this.index;
    }

    @NotNull
    public final LazyMeasuredItem[] getItems() {
        return this.items;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    public final int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    public final boolean isEmpty() {
        return this.items.length == 0;
    }

    @NotNull
    public final List<LazyGridPositionedItem> position(int i11, int i12, int i13) {
        int i14;
        int i15;
        LazyMeasuredItem[] lazyMeasuredItemArr = this.items;
        ArrayList arrayList = new ArrayList(lazyMeasuredItemArr.length);
        int length = lazyMeasuredItemArr.length;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (i16 < length) {
            LazyMeasuredItem lazyMeasuredItem = lazyMeasuredItemArr[i16];
            int i21 = i17 + 1;
            int r52 = GridItemSpan.m660getCurrentLineSpanimpl(this.spans.get(i17).m663unboximpl());
            if (this.layoutDirection == LayoutDirection.Rtl) {
                i14 = (this.slotsPerLine - i18) - r52;
            } else {
                i14 = i18;
            }
            boolean z11 = this.isVertical;
            if (z11) {
                i15 = this.index;
            } else {
                i15 = i14;
            }
            if (!z11) {
                i14 = this.index;
            }
            LazyGridPositionedItem position = lazyMeasuredItem.position(i11, i19, i12, i13, i15, i14, this.mainAxisSize);
            i19 += lazyMeasuredItem.getCrossAxisSize() + this.crossAxisSpacing;
            i18 += r52;
            arrayList.add(position);
            i16++;
            i17 = i21;
        }
        return arrayList;
    }
}
