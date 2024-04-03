package com.deliveryhero.fluid.widgets.collections.grid;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003H\u0002J\u001a\u0010!\u001a\u0004\u0018\u00010\u00002\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003H\u0002J\u001a\u0010$\u001a\u0004\u0018\u00010\u00002\u0006\u0010%\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003H\u0002J\u001a\u0010&\u001a\u0004\u0018\u00010\u00002\u0006\u0010'\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003H\u0002J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\u000e\u0010)\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\u0000J\u000e\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u0000J\u000e\u0010-\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u0003J\u000e\u0010.\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0003J\u000e\u0010/\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u0003J\u000e\u00100\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u0003J\u000e\u00101\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0003J\u000e\u00102\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0003J\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020\u0000042\u0006\u0010,\u001a\u00020\u0000J\t\u00105\u001a\u000206HÖ\u0001J'\u00107\u001a\u000208\"\u0004\b\u0000\u00109*\b\u0012\u0004\u0012\u0002H90:2\b\u0010;\u001a\u0004\u0018\u0001H9H\u0002¢\u0006\u0002\u0010<J\u0015\u0010=\u001a\u00020\r*\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0004R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR\u000e\u0010\u0012\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\t¨\u0006>"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/grid/Rectangle;", "", "left", "", "right", "top", "bottom", "(IIII)V", "getBottom", "()I", "height", "getHeight", "horizontalExclusiveRange", "Lkotlin/ranges/IntRange;", "horizontalRange", "getLeft", "getRight", "getTop", "verticalExclusiveRange", "verticalRange", "width", "getWidth", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "getBotReducedByVerticalEdge", "eTop", "x", "getLeftReducedByHorizontalEdge", "eRight", "y", "getRightReducedByHorizontalEdge", "eLeft", "getTopReducedByVerticalEdge", "eBottom", "hashCode", "includes", "r", "intersects", "otherRect", "intersectsHorizontalLine", "intersectsVerticalLine", "isAbove", "isBelow", "isToLeftOf", "isToRightOf", "modifyBy", "", "toString", "", "addIfNotNull", "", "E", "", "element", "(Ljava/util/Set;Ljava/lang/Object;)V", "exclusiveRangeTo", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Rectangle {
    private final int bottom;
    private final int height;
    @NotNull
    private final IntRange horizontalExclusiveRange;
    @NotNull
    private final IntRange horizontalRange;
    private final int left;
    private final int right;
    private final int top;
    @NotNull
    private final IntRange verticalExclusiveRange;
    @NotNull
    private final IntRange verticalRange;
    private final int width;

    public Rectangle(int i11, int i12, int i13, int i14) {
        this.left = i11;
        this.right = i12;
        this.top = i13;
        this.bottom = i14;
        this.width = i12 - i11;
        this.height = i14 - i13;
        this.horizontalRange = new IntRange(i11, i12);
        this.horizontalExclusiveRange = exclusiveRangeTo(i11, i12);
        this.verticalRange = new IntRange(i13, i14);
        this.verticalExclusiveRange = exclusiveRangeTo(i13, i14);
    }

    private final <E> void addIfNotNull(Set<E> set, E e11) {
        if (e11 != null) {
            set.add(e11);
        }
    }

    public static /* synthetic */ Rectangle copy$default(Rectangle rectangle, int i11, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i11 = rectangle.left;
        }
        if ((i15 & 2) != 0) {
            i12 = rectangle.right;
        }
        if ((i15 & 4) != 0) {
            i13 = rectangle.top;
        }
        if ((i15 & 8) != 0) {
            i14 = rectangle.bottom;
        }
        return rectangle.copy(i11, i12, i13, i14);
    }

    private final IntRange exclusiveRangeTo(int i11, int i12) {
        return new IntRange(i11 + 1, i12 - 1);
    }

    private final Rectangle getBotReducedByVerticalEdge(int i11, int i12) {
        boolean z11;
        IntRange intRange = this.verticalExclusiveRange;
        int first = intRange.getFirst();
        boolean z12 = true;
        if (i11 > intRange.getLast() || first > i11) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            IntRange intRange2 = this.horizontalRange;
            int first2 = intRange2.getFirst();
            if (i12 > intRange2.getLast() || first2 > i12) {
                z12 = false;
            }
            if (z12) {
                return new Rectangle(this.left, this.right, this.top, i11);
            }
        }
        return null;
    }

    private final Rectangle getLeftReducedByHorizontalEdge(int i11, int i12) {
        boolean z11;
        IntRange intRange = this.horizontalExclusiveRange;
        int first = intRange.getFirst();
        boolean z12 = true;
        if (i11 > intRange.getLast() || first > i11) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            IntRange intRange2 = this.verticalRange;
            int first2 = intRange2.getFirst();
            if (i12 > intRange2.getLast() || first2 > i12) {
                z12 = false;
            }
            if (z12) {
                return new Rectangle(i11, this.right, this.top, this.bottom);
            }
        }
        return null;
    }

    private final Rectangle getRightReducedByHorizontalEdge(int i11, int i12) {
        boolean z11;
        IntRange intRange = this.horizontalExclusiveRange;
        int first = intRange.getFirst();
        boolean z12 = true;
        if (i11 > intRange.getLast() || first > i11) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            IntRange intRange2 = this.verticalRange;
            int first2 = intRange2.getFirst();
            if (i12 > intRange2.getLast() || first2 > i12) {
                z12 = false;
            }
            if (z12) {
                return new Rectangle(this.left, i11, this.top, this.bottom);
            }
        }
        return null;
    }

    private final Rectangle getTopReducedByVerticalEdge(int i11, int i12) {
        boolean z11;
        IntRange intRange = this.verticalExclusiveRange;
        int first = intRange.getFirst();
        boolean z12 = true;
        if (i11 > intRange.getLast() || first > i11) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            IntRange intRange2 = this.horizontalRange;
            int first2 = intRange2.getFirst();
            if (i12 > intRange2.getLast() || first2 > i12) {
                z12 = false;
            }
            if (z12) {
                return new Rectangle(this.left, this.right, i11, this.bottom);
            }
        }
        return null;
    }

    public final int component1() {
        return this.left;
    }

    public final int component2() {
        return this.right;
    }

    public final int component3() {
        return this.top;
    }

    public final int component4() {
        return this.bottom;
    }

    @NotNull
    public final Rectangle copy(int i11, int i12, int i13, int i14) {
        return new Rectangle(i11, i12, i13, i14);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rectangle)) {
            return false;
        }
        Rectangle rectangle = (Rectangle) obj;
        return this.left == rectangle.left && this.right == rectangle.right && this.top == rectangle.top && this.bottom == rectangle.bottom;
    }

    public final int getBottom() {
        return this.bottom;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getLeft() {
        return this.left;
    }

    public final int getRight() {
        return this.right;
    }

    public final int getTop() {
        return this.top;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((((this.left * 31) + this.right) * 31) + this.top) * 31) + this.bottom;
    }

    public final boolean includes(@NotNull Rectangle rectangle) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        Intrinsics.checkNotNullParameter(rectangle, "r");
        IntRange intRange = new IntRange(this.top, this.bottom);
        IntRange intRange2 = new IntRange(this.left, this.right);
        int first = intRange2.getFirst();
        int last = intRange2.getLast();
        int i11 = rectangle.left;
        if (first > i11 || i11 > last) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            int first2 = intRange2.getFirst();
            int last2 = intRange2.getLast();
            int i12 = rectangle.right;
            if (first2 > i12 || i12 > last2) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (z12) {
                int first3 = intRange.getFirst();
                int last3 = intRange.getLast();
                int i13 = rectangle.top;
                if (first3 > i13 || i13 > last3) {
                    z13 = false;
                } else {
                    z13 = true;
                }
                if (z13) {
                    int first4 = intRange.getFirst();
                    int last4 = intRange.getLast();
                    int i14 = rectangle.bottom;
                    if (first4 > i14 || i14 > last4) {
                        z14 = false;
                    } else {
                        z14 = true;
                    }
                    if (z14) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean intersects(@NotNull Rectangle rectangle) {
        Intrinsics.checkNotNullParameter(rectangle, "otherRect");
        if (rectangle.left >= this.right || this.left >= rectangle.right || rectangle.top >= this.bottom || this.top >= rectangle.bottom) {
            return false;
        }
        return true;
    }

    public final boolean intersectsHorizontalLine(int i11) {
        IntRange intRange = this.verticalRange;
        return i11 <= intRange.getLast() && intRange.getFirst() <= i11;
    }

    public final boolean intersectsVerticalLine(int i11) {
        IntRange intRange = this.horizontalRange;
        return i11 <= intRange.getLast() && intRange.getFirst() <= i11;
    }

    public final boolean isAbove(int i11) {
        return this.bottom <= i11;
    }

    public final boolean isBelow(int i11) {
        return this.top >= i11;
    }

    public final boolean isToLeftOf(int i11) {
        return this.right <= i11;
    }

    public final boolean isToRightOf(int i11) {
        return this.left >= i11;
    }

    @NotNull
    public final Set<Rectangle> modifyBy(@NotNull Rectangle rectangle) {
        Intrinsics.checkNotNullParameter(rectangle, "otherRect");
        if (!intersects(rectangle)) {
            return SetsKt__SetsKt.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        addIfNotNull(linkedHashSet, getLeftReducedByHorizontalEdge(rectangle.right, rectangle.top));
        addIfNotNull(linkedHashSet, getLeftReducedByHorizontalEdge(rectangle.right, rectangle.bottom));
        addIfNotNull(linkedHashSet, getRightReducedByHorizontalEdge(rectangle.left, rectangle.top));
        addIfNotNull(linkedHashSet, getRightReducedByHorizontalEdge(rectangle.left, rectangle.bottom));
        addIfNotNull(linkedHashSet, getTopReducedByVerticalEdge(rectangle.bottom, rectangle.left));
        addIfNotNull(linkedHashSet, getTopReducedByVerticalEdge(rectangle.bottom, rectangle.right));
        addIfNotNull(linkedHashSet, getBotReducedByVerticalEdge(rectangle.top, rectangle.left));
        addIfNotNull(linkedHashSet, getBotReducedByVerticalEdge(rectangle.top, rectangle.right));
        return linkedHashSet;
    }

    @NotNull
    public String toString() {
        return "Rectangle(left=" + this.left + ", right=" + this.right + ", top=" + this.top + ", bottom=" + this.bottom + ')';
    }
}
