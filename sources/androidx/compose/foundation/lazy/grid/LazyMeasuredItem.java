package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001Bn\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000¢\u0006\u0002\u0010\u0016J>\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020\bR\u000e\u0010\u000e\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0019\u0010\u0018R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R\u0011\u0010\u001f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0014\u001a\u00020\u0015X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010$\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006."}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyMeasuredItem;", "", "index", "Landroidx/compose/foundation/lazy/grid/ItemIndex;", "key", "isVertical", "", "crossAxisSize", "", "mainAxisSpacing", "reverseLayout", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "beforeContentPadding", "afterContentPadding", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "placementAnimator", "Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "(ILjava/lang/Object;ZIIZLandroidx/compose/ui/unit/LayoutDirection;IILjava/util/List;Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCrossAxisSize", "()I", "getIndex-VZbfaAc", "I", "getKey", "()Ljava/lang/Object;", "mainAxisSize", "getMainAxisSize", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "getMainAxisSpacing", "getPlaceables", "()Ljava/util/List;", "J", "position", "Landroidx/compose/foundation/lazy/grid/LazyGridPositionedItem;", "rawMainAxisOffset", "rawCrossAxisOffset", "layoutWidth", "layoutHeight", "row", "column", "lineMainAxisSize", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LazyMeasuredItem {
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    @NotNull
    private final Object key;
    @NotNull
    private final LayoutDirection layoutDirection;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private final int mainAxisSpacing;
    @NotNull
    private final List<Placeable> placeables;
    @NotNull
    private final LazyGridItemPlacementAnimator placementAnimator;
    private final boolean reverseLayout;
    private final long visualOffset;

    private LazyMeasuredItem(int i11, Object obj, boolean z11, int i12, int i13, boolean z12, LayoutDirection layoutDirection2, int i14, int i15, List<? extends Placeable> list, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, long j11) {
        int i16;
        this.index = i11;
        this.key = obj;
        this.isVertical = z11;
        this.crossAxisSize = i12;
        this.mainAxisSpacing = i13;
        this.reverseLayout = z12;
        this.layoutDirection = layoutDirection2;
        this.beforeContentPadding = i14;
        this.afterContentPadding = i15;
        this.placeables = list;
        this.placementAnimator = lazyGridItemPlacementAnimator;
        this.visualOffset = j11;
        int size = list.size();
        int i17 = 0;
        for (int i18 = 0; i18 < size; i18++) {
            Placeable placeable = (Placeable) list.get(i18);
            if (this.isVertical) {
                i16 = placeable.getHeight();
            } else {
                i16 = placeable.getWidth();
            }
            i17 = Math.max(i17, i16);
        }
        this.mainAxisSize = i17;
        this.mainAxisSizeWithSpacings = i17 + this.mainAxisSpacing;
    }

    public /* synthetic */ LazyMeasuredItem(int i11, Object obj, boolean z11, int i12, int i13, boolean z12, LayoutDirection layoutDirection2, int i14, int i15, List list, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, obj, z11, i12, i13, z12, layoutDirection2, i14, i15, list, lazyGridItemPlacementAnimator, j11);
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    /* renamed from: getIndex-VZbfaAc  reason: not valid java name */
    public final int m714getIndexVZbfaAc() {
        return this.index;
    }

    @NotNull
    public final Object getKey() {
        return this.key;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    public final int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    public final int getMainAxisSpacing() {
        return this.mainAxisSpacing;
    }

    @NotNull
    public final List<Placeable> getPlaceables() {
        return this.placeables;
    }

    @NotNull
    public final LazyGridPositionedItem position(int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        int i18;
        int i19;
        int i21;
        int i22;
        long j11;
        int i23;
        long j12;
        long j13;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28 = i11;
        int i29 = i12;
        ArrayList arrayList = new ArrayList();
        boolean z11 = this.isVertical;
        if (z11) {
            i18 = i14;
        } else {
            i18 = i13;
        }
        if (this.reverseLayout) {
            i19 = (i18 - i28) - this.mainAxisSize;
        } else {
            i19 = i28;
        }
        if (z11) {
            i21 = i13;
        } else {
            i21 = i14;
        }
        if (!z11 || this.layoutDirection != LayoutDirection.Rtl) {
            i22 = i29;
        } else {
            i22 = (i21 - i29) - this.crossAxisSize;
        }
        if (z11) {
            j11 = IntOffsetKt.IntOffset(i22, i19);
        } else {
            j11 = IntOffsetKt.IntOffset(i19, i22);
        }
        if (this.reverseLayout) {
            i23 = CollectionsKt__CollectionsKt.getLastIndex(this.placeables);
        } else {
            i23 = 0;
        }
        while (true) {
            boolean z12 = true;
            if (!this.reverseLayout ? i23 >= this.placeables.size() : i23 < 0) {
                z12 = false;
            }
            if (!z12) {
                break;
            }
            Placeable placeable = this.placeables.get(i23);
            if (this.reverseLayout) {
                i26 = 0;
            } else {
                i26 = arrayList.size();
            }
            LazyGridPlaceableWrapper lazyGridPlaceableWrapper = r7;
            LazyGridPlaceableWrapper lazyGridPlaceableWrapper2 = new LazyGridPlaceableWrapper(j11, placeable, this.placeables.get(i23).getParentData(), (DefaultConstructorMarker) null);
            arrayList.add(i26, lazyGridPlaceableWrapper);
            if (this.reverseLayout) {
                i27 = i23 - 1;
            } else {
                i27 = i23 + 1;
            }
        }
        if (this.isVertical) {
            j12 = IntOffsetKt.IntOffset(i29, i28);
        } else {
            j12 = IntOffsetKt.IntOffset(i11, i12);
        }
        long j14 = j12;
        int i31 = this.index;
        Object obj = this.key;
        if (this.isVertical) {
            j13 = IntSizeKt.IntSize(this.crossAxisSize, this.mainAxisSize);
        } else {
            j13 = IntSizeKt.IntSize(this.mainAxisSize, this.crossAxisSize);
        }
        long j15 = j13;
        int i32 = this.mainAxisSpacing;
        boolean z13 = this.reverseLayout;
        if (!z13) {
            i24 = this.beforeContentPadding;
        } else {
            i24 = this.afterContentPadding;
        }
        int i33 = -i24;
        if (!z13) {
            i25 = this.afterContentPadding;
        } else {
            i25 = this.beforeContentPadding;
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = arrayList2;
        return new LazyGridPositionedItem(j14, j11, i31, obj, i15, i16, j15, i17, i32, i33, i18 + i25, this.isVertical, arrayList2, this.placementAnimator, this.visualOffset, (DefaultConstructorMarker) null);
    }
}
