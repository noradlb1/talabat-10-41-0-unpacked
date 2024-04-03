package com.deliveryhero.fluid.widgets.collections.grid;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/grid/RectangleComparator;", "Ljava/util/Comparator;", "Lcom/deliveryhero/fluid/widgets/collections/grid/Rectangle;", "Lkotlin/Comparator;", "isHorizontal", "", "(Z)V", "compare", "", "first", "second", "horizontalCompare", "verticalCompare", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RectangleComparator implements Comparator<Rectangle> {
    private final boolean isHorizontal;

    public RectangleComparator(boolean z11) {
        this.isHorizontal = z11;
    }

    private final int horizontalCompare(Rectangle rectangle, Rectangle rectangle2) {
        if (rectangle.getLeft() < rectangle2.getLeft()) {
            return -1;
        }
        if (rectangle.getLeft() <= rectangle2.getLeft() && rectangle.getTop() < rectangle2.getTop()) {
            return -1;
        }
        return 1;
    }

    private final int verticalCompare(Rectangle rectangle, Rectangle rectangle2) {
        if (rectangle.getTop() < rectangle2.getTop()) {
            return -1;
        }
        if (rectangle.getTop() <= rectangle2.getTop() && rectangle.getLeft() < rectangle2.getLeft()) {
            return -1;
        }
        return 1;
    }

    public int compare(@NotNull Rectangle rectangle, @NotNull Rectangle rectangle2) {
        Intrinsics.checkNotNullParameter(rectangle, "first");
        Intrinsics.checkNotNullParameter(rectangle2, "second");
        if (this.isHorizontal) {
            return horizontalCompare(rectangle, rectangle2);
        }
        return verticalCompare(rectangle, rectangle2);
    }
}
