package com.deliveryhero.fluid.widgets.collections.grid;

import com.deliveryhero.fluid.widgets.collections.Cell;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010!\u001a\u00020\"H\u0002J\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0003J\u0016\u0010'\u001a\u00020$2\u0006\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0003J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0002J\u000e\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u0003J\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001000J\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001002J\u0016\u00103\u001a\u00020$2\u0006\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0003J\u0016\u00104\u001a\u00020\u00102\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000206J\"\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0010002\u0006\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0003J\"\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0010002\u0006\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0003J\u0010\u0010:\u001a\u00020\u00102\u0006\u0010;\u001a\u00020\u0010H\u0002J\u0010\u0010<\u001a\u00020\u00032\u0006\u0010=\u001a\u000206H\u0002J\u0010\u0010>\u001a\u00020\u00032\u0006\u00107\u001a\u000206H\u0002J\u0010\u0010?\u001a\u00020\u00032\u0006\u0010=\u001a\u000206H\u0002J\u0010\u0010@\u001a\u00020\u00032\u0006\u00105\u001a\u000206H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R&\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00038F@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u001aR&\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00038F@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u001aR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020\u00038@X\u0004¢\u0006\u0006\u001a\u0004\b \u0010\f¨\u0006A"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/grid/FreeSpacingHelper;", "", "crossAxisSize", "", "mainAxisSize", "itemSpacing", "isHorizontal", "", "(ILjava/lang/Integer;IZ)V", "comparator", "Lcom/deliveryhero/fluid/widgets/collections/grid/RectangleComparator;", "getCrossAxisSize", "()I", "crossAxisSizeWithDistance", "freeRectangles", "", "Lcom/deliveryhero/fluid/widgets/collections/grid/Rectangle;", "halfSpacing", "isVertical", "getMainAxisSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "value", "maxX", "getMaxX", "setMaxX", "(I)V", "maxY", "getMaxY", "setMaxY", "placedRectangles", "rectanglesCount", "getRectanglesCount$core_release", "cleanup", "", "completelyVisibleIndexesBetweenHorizontalLines", "", "yTop", "yBottom", "completelyVisibleIndexesBetweenVerticalLines", "xLeft", "xRight", "getDebugInfo", "", "info", "getRectangle", "index", "getRectangles", "", "getRectanglesArray", "", "indexesBetweenVerticalLines", "placeRect", "width", "Lcom/deliveryhero/fluid/widgets/collections/Cell$Size;", "height", "rectanglesBetweenHorizontalLines", "rectanglesBetweenVerticalLines", "removeDistance", "rectToPlace", "resolveCrossAxisSize", "spec", "resolveHeight", "resolveMainAxisSize", "resolveWidth", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FreeSpacingHelper {
    @NotNull
    private final RectangleComparator comparator;
    private final int crossAxisSize;
    private final int crossAxisSizeWithDistance;
    @NotNull
    private final List<Rectangle> freeRectangles;
    private final int halfSpacing;
    private final boolean isVertical;
    private final int itemSpacing;
    @Nullable
    private final Integer mainAxisSize;
    private int maxX;
    private int maxY;
    @NotNull
    private final List<Rectangle> placedRectangles;

    public FreeSpacingHelper(int i11, @Nullable Integer num, int i12, boolean z11) {
        Rectangle rectangle;
        this.crossAxisSize = i11;
        this.mainAxisSize = num;
        this.itemSpacing = i12;
        int i13 = i12 / 2;
        this.halfSpacing = i13;
        ArrayList arrayList = new ArrayList();
        this.freeRectangles = arrayList;
        this.placedRectangles = new ArrayList();
        this.comparator = new RectangleComparator(z11);
        this.crossAxisSizeWithDistance = (i13 * 2) + i11;
        if (z11) {
            rectangle = new Rectangle(0, Integer.MAX_VALUE, -i13, i11 + i13);
        } else {
            rectangle = new Rectangle(-i13, i11 + i13, 0, Integer.MAX_VALUE);
        }
        arrayList.add(rectangle);
        this.isVertical = !z11;
    }

    private final void cleanup() {
        boolean z11;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Rectangle rectangle : this.freeRectangles) {
            Iterable iterable = this.freeRectangles;
            boolean z12 = false;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator it = iterable.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Rectangle rectangle2 = (Rectangle) it.next();
                    if (!rectangle2.includes(rectangle) || Intrinsics.areEqual((Object) rectangle2, (Object) rectangle)) {
                        z11 = false;
                        continue;
                    } else {
                        z11 = true;
                        continue;
                    }
                    if (z11) {
                        z12 = true;
                        break;
                    }
                }
            }
            if (z12) {
                linkedHashSet.add(rectangle);
            }
        }
        boolean unused = CollectionsKt__MutableCollectionsKt.removeAll(this.freeRectangles, linkedHashSet);
        CollectionsKt__MutableCollectionsJVMKt.sortWith(this.freeRectangles, this.comparator);
    }

    private final String getDebugInfo(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("crossAxisSize: " + this.crossAxisSize + 10);
        sb2.append("item spacing: " + this.itemSpacing + 10);
        sb2.append("info: " + str + 10);
        sb2.append("placed rectangles:\n");
        for (Rectangle rectangle : this.placedRectangles) {
            sb2.append(rectangle.toString());
            sb2.append(StringUtils.LF);
        }
        sb2.append("free rectangles:\n");
        for (Rectangle rectangle2 : this.freeRectangles) {
            sb2.append(rectangle2.toString());
            sb2.append(StringUtils.LF);
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "StringBuilder().apply {\n…(\"\\n\") }\n    }.toString()");
        return sb3;
    }

    private final Rectangle removeDistance(Rectangle rectangle) {
        int i11;
        boolean z11 = this.isVertical;
        int i12 = 0;
        if (z11) {
            i11 = this.halfSpacing;
        } else {
            i11 = 0;
        }
        if (!z11) {
            i12 = this.halfSpacing;
        }
        return new Rectangle(rectangle.getLeft() + i11, rectangle.getRight() - i11, rectangle.getTop() + i12, rectangle.getBottom() - i12);
    }

    private final int resolveCrossAxisSize(Cell.Size size) {
        if (size instanceof Cell.Size.Relative) {
            return (int) (((Cell.Size.Relative) size).m8202unboximpl() * ((float) this.crossAxisSizeWithDistance));
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final int resolveHeight(Cell.Size size) {
        if (this.isVertical) {
            return resolveMainAxisSize(size);
        }
        return resolveCrossAxisSize(size);
    }

    private final int resolveMainAxisSize(Cell.Size size) {
        float floatValue;
        if (size instanceof Cell.Size.Absolute) {
            floatValue = ((Cell.Size.Absolute) size).m8195unboximpl().getValue();
        } else if (size instanceof Cell.Size.Relative) {
            float r22 = ((Cell.Size.Relative) size).m8202unboximpl();
            Integer num = this.mainAxisSize;
            if (num != null) {
                floatValue = (r22 * num.floatValue()) - ((float) (this.halfSpacing * 2));
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return (int) floatValue;
    }

    private final int resolveWidth(Cell.Size size) {
        if (this.isVertical) {
            return resolveCrossAxisSize(size);
        }
        return resolveMainAxisSize(size);
    }

    private final void setMaxX(int i11) {
        this.maxX = i11;
    }

    private final void setMaxY(int i11) {
        this.maxY = i11;
    }

    @NotNull
    public final int[] completelyVisibleIndexesBetweenHorizontalLines(int i11, int i12) {
        Integer num;
        ArrayList arrayList = new ArrayList();
        int i13 = 0;
        for (Object next : this.placedRectangles) {
            int i14 = i13 + 1;
            if (i13 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Rectangle removeDistance = removeDistance((Rectangle) next);
            if (!removeDistance.isBelow(i11) || !removeDistance.isAbove(i12)) {
                num = null;
            } else {
                num = Integer.valueOf(i13);
            }
            if (num != null) {
                arrayList.add(num);
            }
            i13 = i14;
        }
        return CollectionsKt___CollectionsKt.toIntArray(arrayList);
    }

    @NotNull
    public final int[] completelyVisibleIndexesBetweenVerticalLines(int i11, int i12) {
        Integer num;
        ArrayList arrayList = new ArrayList();
        int i13 = 0;
        for (Object next : this.placedRectangles) {
            int i14 = i13 + 1;
            if (i13 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Rectangle removeDistance = removeDistance((Rectangle) next);
            if (!removeDistance.isToLeftOf(i12) || !removeDistance.isToRightOf(i11)) {
                num = null;
            } else {
                num = Integer.valueOf(i13);
            }
            if (num != null) {
                arrayList.add(num);
            }
            i13 = i14;
        }
        return CollectionsKt___CollectionsKt.toIntArray(arrayList);
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    @Nullable
    public final Integer getMainAxisSize() {
        return this.mainAxisSize;
    }

    public final int getMaxX() {
        return this.maxX;
    }

    public final int getMaxY() {
        return this.maxY;
    }

    @NotNull
    public final Rectangle getRectangle(int i11) {
        return removeDistance(this.placedRectangles.get(i11));
    }

    @NotNull
    public final Map<Integer, Rectangle> getRectangles() {
        Iterable iterable = this.placedRectangles;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        int i11 = 0;
        for (Object next : iterable) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(TuplesKt.to(Integer.valueOf(i11), removeDistance((Rectangle) next)));
            i11 = i12;
        }
        return MapsKt__MapsKt.toMap(arrayList);
    }

    @NotNull
    public final List<Rectangle> getRectanglesArray() {
        Iterable<Rectangle> iterable = this.placedRectangles;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Rectangle removeDistance : iterable) {
            arrayList.add(removeDistance(removeDistance));
        }
        return arrayList;
    }

    public final int getRectanglesCount$core_release() {
        return this.placedRectangles.size();
    }

    @NotNull
    public final int[] indexesBetweenVerticalLines(int i11, int i12) {
        Integer num;
        ArrayList arrayList = new ArrayList();
        int i13 = 0;
        for (Object next : this.placedRectangles) {
            int i14 = i13 + 1;
            if (i13 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Rectangle removeDistance = removeDistance((Rectangle) next);
            if ((!removeDistance.isToLeftOf(i12) || !removeDistance.isToRightOf(i11)) && !removeDistance.intersectsVerticalLine(i11) && !removeDistance.intersectsVerticalLine(i12)) {
                num = null;
            } else {
                num = Integer.valueOf(i13);
            }
            if (num != null) {
                arrayList.add(num);
            }
            i13 = i14;
        }
        return CollectionsKt___CollectionsKt.toIntArray(arrayList);
    }

    @NotNull
    public final Rectangle placeRect(@NotNull Cell.Size size, @NotNull Cell.Size size2) {
        int i11;
        Object obj;
        Cell.Size size3 = size;
        Cell.Size size4 = size2;
        Intrinsics.checkNotNullParameter(size3, "width");
        Intrinsics.checkNotNullParameter(size4, "height");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        int resolveHeight = resolveHeight(size4);
        int resolveWidth = resolveWidth(size);
        boolean z11 = this.isVertical;
        int i12 = 0;
        if (z11) {
            i11 = 0;
        } else {
            i11 = this.halfSpacing * 2;
        }
        if (z11) {
            i12 = this.halfSpacing * 2;
        }
        Iterator it = this.freeRectangles.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Rectangle rectangle = (Rectangle) obj;
            Iterator it2 = it;
            if (rectangle.includes(new Rectangle(rectangle.getLeft(), rectangle.getLeft() + resolveWidth + i11, rectangle.getTop(), rectangle.getTop() + resolveHeight + i12))) {
                break;
            }
            it = it2;
        }
        Rectangle rectangle2 = (Rectangle) obj;
        if (rectangle2 != null) {
            Rectangle rectangle3 = new Rectangle(rectangle2.getLeft(), rectangle2.getLeft() + resolveWidth, rectangle2.getTop(), rectangle2.getTop() + resolveHeight);
            for (Rectangle rectangle4 : this.freeRectangles) {
                Rectangle copy$default = Rectangle.copy$default(rectangle3, 0, rectangle3.getRight() + i11, 0, rectangle3.getBottom() + i12, 5, (Object) null);
                if (rectangle4.intersects(copy$default)) {
                    linkedHashSet.addAll(rectangle4.modifyBy(copy$default));
                    linkedHashSet2.add(rectangle4);
                }
            }
            this.placedRectangles.add(rectangle3);
            setMaxX(Math.max(getMaxX(), rectangle3.getRight()));
            setMaxY(Math.max(getMaxY(), rectangle3.getBottom()));
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(this.freeRectangles, linkedHashSet);
            boolean unused2 = CollectionsKt__MutableCollectionsKt.removeAll(this.freeRectangles, linkedHashSet2);
            cleanup();
            return removeDistance(rectangle3);
        }
        throw new IllegalStateException(getDebugInfo("no space to place width=" + size3 + " height=" + size4).toString());
    }

    @NotNull
    public final Map<Integer, Rectangle> rectanglesBetweenHorizontalLines(int i11, int i12) {
        boolean z11;
        Iterable iterable = this.placedRectangles;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        int i13 = 0;
        for (Object next : iterable) {
            int i14 = i13 + 1;
            if (i13 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(TuplesKt.to(Integer.valueOf(i13), removeDistance((Rectangle) next)));
            i13 = i14;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object next2 : arrayList) {
            Rectangle rectangle = (Rectangle) ((Pair) next2).component2();
            if ((!rectangle.isBelow(i11) || !rectangle.isAbove(i12)) && !rectangle.intersectsHorizontalLine(i11) && !rectangle.intersectsHorizontalLine(i12)) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                arrayList2.add(next2);
            }
        }
        return MapsKt__MapsKt.toMap(arrayList2);
    }

    @NotNull
    public final Map<Integer, Rectangle> rectanglesBetweenVerticalLines(int i11, int i12) {
        boolean z11;
        Iterable iterable = this.placedRectangles;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        int i13 = 0;
        for (Object next : iterable) {
            int i14 = i13 + 1;
            if (i13 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(TuplesKt.to(Integer.valueOf(i13), removeDistance((Rectangle) next)));
            i13 = i14;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object next2 : arrayList) {
            Rectangle rectangle = (Rectangle) ((Pair) next2).component2();
            if ((!rectangle.isToLeftOf(i12) || !rectangle.isToRightOf(i11)) && !rectangle.intersectsVerticalLine(i11) && !rectangle.intersectsVerticalLine(i12)) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                arrayList2.add(next2);
            }
        }
        return MapsKt__MapsKt.toMap(arrayList2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FreeSpacingHelper(int i11, Integer num, int i12, boolean z11, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, (i13 & 2) != 0 ? null : num, i12, (i13 & 8) != 0 ? false : z11);
    }
}
