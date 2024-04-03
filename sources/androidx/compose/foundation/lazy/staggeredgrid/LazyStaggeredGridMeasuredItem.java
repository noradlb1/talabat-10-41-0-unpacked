package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B>\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u001e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003R\u001c\u0010\n\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006$"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "", "index", "", "key", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "spacing", "(ILjava/lang/Object;Ljava/util/List;ZJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContentOffset-nOcc-ac", "()J", "J", "crossAxisSize", "getCrossAxisSize", "()I", "getIndex", "()Z", "getKey", "()Ljava/lang/Object;", "mainAxisSize", "getMainAxisSize", "getPlaceables", "()Ljava/util/List;", "sizeWithSpacings", "getSizeWithSpacings", "getSpacing", "position", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridPositionedItem;", "lane", "mainAxis", "crossAxis", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class LazyStaggeredGridMeasuredItem {
    private final long contentOffset;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    @NotNull
    private final Object key;
    private final int mainAxisSize;
    @NotNull
    private final List<Placeable> placeables;
    private final int sizeWithSpacings;
    private final int spacing;

    private LazyStaggeredGridMeasuredItem(int i11, Object obj, List<? extends Placeable> list, boolean z11, long j11, int i12) {
        Integer num;
        int i13;
        int i14;
        int i15;
        this.index = i11;
        this.key = obj;
        this.placeables = list;
        this.isVertical = z11;
        this.contentOffset = j11;
        this.spacing = i12;
        Integer num2 = 0;
        int size = list.size();
        for (int i16 = 0; i16 < size; i16++) {
            Placeable placeable = (Placeable) list.get(i16);
            int intValue = num2.intValue();
            if (this.isVertical) {
                i15 = placeable.getHeight();
            } else {
                i15 = placeable.getWidth();
            }
            num2 = Integer.valueOf(intValue + i15);
        }
        int intValue2 = num2.intValue();
        this.mainAxisSize = intValue2;
        this.sizeWithSpacings = intValue2 + this.spacing;
        List<Placeable> list2 = this.placeables;
        if (list2.isEmpty()) {
            num = null;
        } else {
            Placeable placeable2 = list2.get(0);
            if (this.isVertical) {
                i13 = placeable2.getWidth();
            } else {
                i13 = placeable2.getHeight();
            }
            num = Integer.valueOf(i13);
            int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list2);
            int i17 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Placeable placeable3 = list2.get(i17);
                    if (this.isVertical) {
                        i14 = placeable3.getWidth();
                    } else {
                        i14 = placeable3.getHeight();
                    }
                    Integer valueOf = Integer.valueOf(i14);
                    num = valueOf.compareTo(num) > 0 ? valueOf : num;
                    if (i17 == lastIndex) {
                        break;
                    }
                    i17++;
                }
            }
        }
        Intrinsics.checkNotNull(num);
        this.crossAxisSize = num.intValue();
    }

    public /* synthetic */ LazyStaggeredGridMeasuredItem(int i11, Object obj, List list, boolean z11, long j11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, obj, list, z11, j11, i12);
    }

    /* renamed from: getContentOffset-nOcc-ac  reason: not valid java name */
    public final long m779getContentOffsetnOccac() {
        return this.contentOffset;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public final int getIndex() {
        return this.index;
    }

    @NotNull
    public final Object getKey() {
        return this.key;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    @NotNull
    public final List<Placeable> getPlaceables() {
        return this.placeables;
    }

    public final int getSizeWithSpacings() {
        return this.sizeWithSpacings;
    }

    public final int getSpacing() {
        return this.spacing;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    @NotNull
    public final LazyStaggeredGridPositionedItem position(int i11, int i12, int i13) {
        long j11;
        if (this.isVertical) {
            j11 = IntOffsetKt.IntOffset(i13, i12);
        } else {
            int i14 = i12;
            int i15 = i13;
            j11 = IntOffsetKt.IntOffset(i12, i13);
        }
        return new LazyStaggeredGridPositionedItem(j11, this.index, i11, this.key, IntSizeKt.IntSize(this.sizeWithSpacings, this.crossAxisSize), this.placeables, this.contentOffset, this.isVertical, (DefaultConstructorMarker) null);
    }
}
