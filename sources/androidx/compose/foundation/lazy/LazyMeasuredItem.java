package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B|\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u001e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003R\u000e\u0010\u0011\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0011\u0010!\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u000e\u0010\u0014\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0015\u001a\u00020\u0016X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010#\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006)"}, d2 = {"Landroidx/compose/foundation/lazy/LazyMeasuredItem;", "", "index", "", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "reverseLayout", "beforeContentPadding", "afterContentPadding", "placementAnimator", "Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;", "spacing", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "key", "(ILjava/util/List;ZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZIILandroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;IJLjava/lang/Object;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "crossAxisSize", "getCrossAxisSize", "()I", "getIndex", "getKey", "()Ljava/lang/Object;", "size", "getSize", "sizeWithSpacings", "getSizeWithSpacings", "J", "position", "Landroidx/compose/foundation/lazy/LazyListPositionedItem;", "offset", "layoutWidth", "layoutHeight", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LazyMeasuredItem {
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private final int crossAxisSize;
    @Nullable
    private final Alignment.Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;
    @NotNull
    private final Object key;
    @NotNull
    private final LayoutDirection layoutDirection;
    @NotNull
    private final List<Placeable> placeables;
    @NotNull
    private final LazyListItemPlacementAnimator placementAnimator;
    private final boolean reverseLayout;
    private final int size;
    private final int sizeWithSpacings;
    private final int spacing;
    @Nullable
    private final Alignment.Vertical verticalAlignment;
    private final long visualOffset;

    private LazyMeasuredItem(int i11, List<? extends Placeable> list, boolean z11, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection2, boolean z12, int i12, int i13, LazyListItemPlacementAnimator lazyListItemPlacementAnimator, int i14, long j11, Object obj) {
        int i15;
        int i16;
        this.index = i11;
        this.placeables = list;
        this.isVertical = z11;
        this.horizontalAlignment = horizontal;
        this.verticalAlignment = vertical;
        this.layoutDirection = layoutDirection2;
        this.reverseLayout = z12;
        this.beforeContentPadding = i12;
        this.afterContentPadding = i13;
        this.placementAnimator = lazyListItemPlacementAnimator;
        this.spacing = i14;
        this.visualOffset = j11;
        this.key = obj;
        int size2 = list.size();
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < size2; i19++) {
            Placeable placeable = (Placeable) list.get(i19);
            if (this.isVertical) {
                i15 = placeable.getHeight();
            } else {
                i15 = placeable.getWidth();
            }
            i17 += i15;
            if (!this.isVertical) {
                i16 = placeable.getHeight();
            } else {
                i16 = placeable.getWidth();
            }
            i18 = Math.max(i18, i16);
        }
        this.size = i17;
        this.sizeWithSpacings = i17 + this.spacing;
        this.crossAxisSize = i18;
    }

    @ExperimentalFoundationApi
    public /* synthetic */ LazyMeasuredItem(int i11, List list, boolean z11, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection2, boolean z12, int i12, int i13, LazyListItemPlacementAnimator lazyListItemPlacementAnimator, int i14, long j11, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, list, z11, horizontal, vertical, layoutDirection2, z12, i12, i13, lazyListItemPlacementAnimator, i14, j11, obj);
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

    public final int getSize() {
        return this.size;
    }

    public final int getSizeWithSpacings() {
        return this.sizeWithSpacings;
    }

    @NotNull
    public final LazyListPositionedItem position(int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        long j11;
        int i21;
        int i22;
        ArrayList arrayList = new ArrayList();
        if (this.isVertical) {
            i14 = i13;
        } else {
            i14 = i12;
        }
        boolean z11 = this.reverseLayout;
        if (z11) {
            i15 = (i14 - i11) - this.size;
        } else {
            i15 = i11;
        }
        if (z11) {
            i16 = CollectionsKt__CollectionsKt.getLastIndex(this.placeables);
        } else {
            i16 = 0;
        }
        while (true) {
            boolean z12 = true;
            if (!this.reverseLayout ? i16 >= this.placeables.size() : i16 < 0) {
                z12 = false;
            }
            if (z12) {
                Placeable placeable = this.placeables.get(i16);
                if (this.reverseLayout) {
                    i19 = 0;
                } else {
                    i19 = arrayList.size();
                }
                if (this.isVertical) {
                    Alignment.Horizontal horizontal = this.horizontalAlignment;
                    if (horizontal != null) {
                        j11 = IntOffsetKt.IntOffset(horizontal.align(placeable.getWidth(), i12, this.layoutDirection), i15);
                        int i23 = i13;
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                } else {
                    int i24 = i12;
                    Alignment.Vertical vertical = this.verticalAlignment;
                    if (vertical != null) {
                        j11 = IntOffsetKt.IntOffset(i15, vertical.align(placeable.getHeight(), i13));
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                }
                long j12 = j11;
                if (this.isVertical) {
                    i21 = placeable.getHeight();
                } else {
                    i21 = placeable.getWidth();
                }
                i15 += i21;
                arrayList.add(i19, new LazyListPlaceableWrapper(j12, placeable, this.placeables.get(i16).getParentData(), (DefaultConstructorMarker) null));
                if (this.reverseLayout) {
                    i22 = i16 - 1;
                } else {
                    i22 = i16 + 1;
                }
            } else {
                int i25 = this.index;
                Object obj = this.key;
                int i26 = this.size;
                int i27 = this.sizeWithSpacings;
                boolean z13 = this.reverseLayout;
                if (!z13) {
                    i17 = this.beforeContentPadding;
                } else {
                    i17 = this.afterContentPadding;
                }
                int i28 = -i17;
                if (!z13) {
                    i18 = this.afterContentPadding;
                } else {
                    i18 = this.beforeContentPadding;
                }
                return new LazyListPositionedItem(i11, i25, obj, i26, i27, i28, i14 + i18, this.isVertical, arrayList, this.placementAnimator, this.visualOffset, (DefaultConstructorMarker) null);
            }
        }
    }
}
