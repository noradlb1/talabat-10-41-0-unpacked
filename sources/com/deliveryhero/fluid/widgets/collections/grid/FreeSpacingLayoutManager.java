package com.deliveryhero.fluid.widgets.collections.grid;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.deliveryhero.fluid.widgets.collections.Cell;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001:\u0002STB\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010&\u001a\u00020\u0003H\u0016J\b\u0010'\u001a\u00020\u0003H\u0016J-\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010.J\u0014\u0010/\u001a\u00020)2\n\u00100\u001a\u000601R\u00020\u0005H\u0002J\u0014\u00102\u001a\u00020)2\n\u00100\u001a\u000601R\u00020\u0005H\u0002J\r\u00103\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u00104J\r\u00105\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u00104J\u0006\u00106\u001a\u00020\nJ\b\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u00020\nH\u0002J\u0016\u0010<\u001a\b\u0012\u0004\u0012\u00020\n0#2\u0006\u0010=\u001a\u00020\nH\u0002J\b\u0010>\u001a\u00020\nH\u0002J\u001c\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020A0@2\u0006\u0010=\u001a\u00020\nH\u0002J \u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020\n2\u0006\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020\nH\u0002J\b\u0010F\u001a\u00020\u0003H\u0016J\u001c\u0010G\u001a\u00020)2\n\u00100\u001a\u000601R\u00020\u00052\u0006\u0010*\u001a\u00020+H\u0016J,\u0010H\u001a\u00020)2\n\u00100\u001a\u000601R\u00020\u00052\u0006\u0010*\u001a\u00020+2\u0006\u0010I\u001a\u00020\n2\u0006\u0010J\u001a\u00020\nH\u0016J\u001c\u0010K\u001a\u00020)2\n\u00100\u001a\u000601R\u00020\u00052\u0006\u0010L\u001a\u00020\nH\u0002J\u0010\u0010M\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\u001c\u0010N\u001a\u00020\n2\u0006\u0010=\u001a\u00020\n2\n\u00100\u001a\u000601R\u00020\u0005H\u0002J$\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020\n2\n\u00100\u001a\u000601R\u00020\u00052\u0006\u0010*\u001a\u00020+H\u0016J$\u0010Q\u001a\u00020\n2\u0006\u0010R\u001a\u00020\n2\n\u00100\u001a\u000601R\u00020\u00052\u0006\u0010*\u001a\u00020+H\u0016R\u0014\u0010\t\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\fR\u0014\u0010\u001e\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0012R\u000e\u0010 \u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0#X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\f¨\u0006U"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/grid/FreeSpacingLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "isHorizontal", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "itemSizeLookup", "Lcom/deliveryhero/fluid/widgets/collections/grid/FreeSpacingLayoutManager$ItemSizeLookup;", "(ZLandroidx/recyclerview/widget/RecyclerView;Lcom/deliveryhero/fluid/widgets/collections/grid/FreeSpacingLayoutManager$ItemSizeLookup;)V", "directionSign", "", "getDirectionSign", "()I", "heightWithoutPadding", "getHeightWithoutPadding", "helper", "Lcom/deliveryhero/fluid/widgets/collections/grid/FreeSpacingHelper;", "isEmpty", "()Z", "isVertical", "getItemSizeLookup", "()Lcom/deliveryhero/fluid/widgets/collections/grid/FreeSpacingLayoutManager$ItemSizeLookup;", "setItemSizeLookup", "(Lcom/deliveryhero/fluid/widgets/collections/grid/FreeSpacingLayoutManager$ItemSizeLookup;)V", "itemSpacing", "getItemSpacing", "setItemSpacing", "(I)V", "lastChildIndex", "getLastChildIndex", "ltr", "getLtr", "maxScrollOffset", "scrollOffset", "shownPositions", "", "widthWithoutPadding", "getWidthWithoutPadding", "canScrollHorizontally", "canScrollVertically", "createAndFillHelper", "", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "crossAxisSize", "mainAxisSize", "(Landroidx/recyclerview/widget/RecyclerView$State;Ljava/lang/Integer;Ljava/lang/Integer;)V", "detachAllViews", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "fillGaps", "findFirstCompletelyVisibleItemPosition", "()Ljava/lang/Integer;", "findLastCompletelyVisibleItemPosition", "findLastVisibleItemPosition", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "getCompletelyVisibleIndexes", "", "getCrossAxisSize", "getIndicesForOffset", "offset", "getMainAxisSize", "getRectanglesForOffset", "", "Lcom/deliveryhero/fluid/widgets/collections/grid/Rectangle;", "getSize", "spec", "desired", "min", "isAutoMeasureEnabled", "onLayoutChildren", "onMeasure", "widthSpec", "heightSpec", "placeViewByIndex", "index", "refreshParams", "scrollBy", "scrollHorizontallyBy", "dx", "scrollVerticallyBy", "dy", "ItemSize", "ItemSizeLookup", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FreeSpacingLayoutManager extends RecyclerView.LayoutManager {
    @NotNull
    private FreeSpacingHelper helper;
    private final boolean isHorizontal;
    private final boolean isVertical;
    @NotNull
    private ItemSizeLookup itemSizeLookup;
    private int itemSpacing;
    private int maxScrollOffset;
    @NotNull
    private final RecyclerView recyclerView;
    private int scrollOffset;
    @NotNull
    private Set<Integer> shownPositions;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/grid/FreeSpacingLayoutManager$ItemSize;", "", "width", "Lcom/deliveryhero/fluid/widgets/collections/Cell$Size;", "height", "(Lcom/deliveryhero/fluid/widgets/collections/Cell$Size;Lcom/deliveryhero/fluid/widgets/collections/Cell$Size;)V", "getHeight", "()Lcom/deliveryhero/fluid/widgets/collections/Cell$Size;", "getWidth", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ItemSize {
        @NotNull
        private final Cell.Size height;
        @NotNull
        private final Cell.Size width;

        public ItemSize(@NotNull Cell.Size size, @NotNull Cell.Size size2) {
            Intrinsics.checkNotNullParameter(size, "width");
            Intrinsics.checkNotNullParameter(size2, "height");
            this.width = size;
            this.height = size2;
        }

        public static /* synthetic */ ItemSize copy$default(ItemSize itemSize, Cell.Size size, Cell.Size size2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                size = itemSize.width;
            }
            if ((i11 & 2) != 0) {
                size2 = itemSize.height;
            }
            return itemSize.copy(size, size2);
        }

        @NotNull
        public final Cell.Size component1() {
            return this.width;
        }

        @NotNull
        public final Cell.Size component2() {
            return this.height;
        }

        @NotNull
        public final ItemSize copy(@NotNull Cell.Size size, @NotNull Cell.Size size2) {
            Intrinsics.checkNotNullParameter(size, "width");
            Intrinsics.checkNotNullParameter(size2, "height");
            return new ItemSize(size, size2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ItemSize)) {
                return false;
            }
            ItemSize itemSize = (ItemSize) obj;
            return Intrinsics.areEqual((Object) this.width, (Object) itemSize.width) && Intrinsics.areEqual((Object) this.height, (Object) itemSize.height);
        }

        @NotNull
        public final Cell.Size getHeight() {
            return this.height;
        }

        @NotNull
        public final Cell.Size getWidth() {
            return this.width;
        }

        public int hashCode() {
            return (this.width.hashCode() * 31) + this.height.hashCode();
        }

        @NotNull
        public String toString() {
            return "ItemSize(width=" + this.width + ", height=" + this.height + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/grid/FreeSpacingLayoutManager$ItemSizeLookup;", "", "getSize", "Lcom/deliveryhero/fluid/widgets/collections/grid/FreeSpacingLayoutManager$ItemSize;", "position", "", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ItemSizeLookup {
        @NotNull
        ItemSize getSize(int i11);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FreeSpacingLayoutManager(boolean z11, RecyclerView recyclerView2, ItemSizeLookup itemSizeLookup2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z11, recyclerView2, itemSizeLookup2);
    }

    public static /* synthetic */ void a(FreeSpacingLayoutManager freeSpacingLayoutManager, RecyclerView.State state, Integer num, Integer num2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            num = null;
        }
        if ((i11 & 4) != 0) {
            num2 = null;
        }
        freeSpacingLayoutManager.createAndFillHelper(state, num, num2);
    }

    private final void createAndFillHelper(RecyclerView.State state, Integer num, Integer num2) {
        int i11;
        int i12;
        if (num != null) {
            i11 = num.intValue();
        } else {
            i11 = RangesKt___RangesKt.coerceAtLeast(getCrossAxisSize(), 0);
        }
        if (num2 != null) {
            i12 = num2.intValue();
        } else {
            i12 = RangesKt___RangesKt.coerceAtLeast(getMainAxisSize(), 0);
        }
        this.helper = new FreeSpacingHelper(i11, Integer.valueOf(i12), this.itemSpacing, this.isHorizontal);
        int itemCount = state.getItemCount();
        for (int i13 = 0; i13 < itemCount; i13++) {
            ItemSize size = this.itemSizeLookup.getSize(i13);
            this.helper.placeRect(size.component1(), size.component2());
        }
    }

    private final void detachAllViews(RecyclerView.Recycler recycler) {
        if (!isEmpty()) {
            detachAndScrapAttachedViews(recycler);
            this.shownPositions = SetsKt__SetsKt.emptySet();
        }
    }

    private final void fillGaps(RecyclerView.Recycler recycler) {
        Set<Integer> indicesForOffset = getIndicesForOffset(this.scrollOffset);
        Set<Number> minus = SetsKt___SetsKt.minus(this.shownPositions, indicesForOffset);
        Set<Number> minus2 = SetsKt___SetsKt.minus(indicesForOffset, this.shownPositions);
        for (Number intValue : minus) {
            View findViewByPosition = findViewByPosition(intValue.intValue());
            if (findViewByPosition != null) {
                removeAndRecycleView(findViewByPosition, recycler);
            }
        }
        for (Number intValue2 : minus2) {
            placeViewByIndex(recycler, intValue2.intValue());
        }
        this.shownPositions = indicesForOffset;
    }

    private final int[] getCompletelyVisibleIndexes() {
        if (this.isHorizontal) {
            int paddingStart = this.scrollOffset - getPaddingStart();
            return this.helper.completelyVisibleIndexesBetweenVerticalLines(paddingStart, getWidth() + paddingStart);
        }
        int paddingTop = this.scrollOffset - getPaddingTop();
        return this.helper.completelyVisibleIndexesBetweenHorizontalLines(paddingTop, getHeight() + paddingTop);
    }

    private final int getCrossAxisSize() {
        int i11;
        int i12;
        if (this.isHorizontal) {
            i12 = getHeight() - getPaddingTop();
            i11 = getPaddingBottom();
        } else {
            i12 = getWidth() - getPaddingStart();
            i11 = getPaddingEnd();
        }
        return i12 - i11;
    }

    private final int getDirectionSign() {
        return getLtr() ? 1 : -1;
    }

    private final int getHeightWithoutPadding() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private final Set<Integer> getIndicesForOffset(int i11) {
        return getRectanglesForOffset(i11).keySet();
    }

    private final int getLastChildIndex() {
        return getChildCount() - 1;
    }

    private final boolean getLtr() {
        return getLayoutDirection() == 0;
    }

    private final int getMainAxisSize() {
        int i11;
        int i12;
        if (this.isHorizontal) {
            i12 = getWidth() - getPaddingStart();
            if (this.recyclerView.getClipToPadding()) {
                i11 = 0;
            } else {
                i11 = getPaddingEnd();
            }
        } else {
            i12 = getHeight() - getPaddingTop();
            i11 = getPaddingBottom();
        }
        return i12 - i11;
    }

    private final Map<Integer, Rectangle> getRectanglesForOffset(int i11) {
        if (this.isHorizontal) {
            return this.helper.rectanglesBetweenVerticalLines(i11 - getPaddingStart(), (i11 - getPaddingStart()) + getWidth());
        }
        return this.helper.rectanglesBetweenHorizontalLines(i11 - getPaddingTop(), (i11 - getPaddingTop()) + getHeight());
    }

    private final int getSize(int i11, int i12, int i13) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(size, Math.max(i12, i13));
        }
        if (mode != 1073741824) {
            return Math.max(i12, i13);
        }
        return size;
    }

    private final int getWidthWithoutPadding() {
        return (getWidth() - getPaddingStart()) - getPaddingEnd();
    }

    private final boolean isEmpty() {
        return getChildCount() == 0;
    }

    private final void placeViewByIndex(RecyclerView.Recycler recycler, int i11) {
        int i12;
        View viewForPosition = recycler.getViewForPosition(i11);
        Intrinsics.checkNotNullExpressionValue(viewForPosition, "recycler.getViewForPosition(index)");
        Rectangle rectangle = this.helper.getRectangle(i11);
        addView(viewForPosition, i11);
        ViewGroup.LayoutParams layoutParams = viewForPosition.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = rectangle.getWidth();
            layoutParams.height = rectangle.getHeight();
            viewForPosition.setLayoutParams(layoutParams);
            measureChildWithMargins(viewForPosition, getWidth(), getHeight());
            int i13 = 0;
            if (this.isVertical) {
                i12 = this.scrollOffset;
            } else {
                i12 = 0;
            }
            if (this.isHorizontal) {
                i13 = this.scrollOffset;
            }
            if (getLtr()) {
                layoutDecoratedWithMargins(viewForPosition, (rectangle.getLeft() + getPaddingStart()) - i13, (rectangle.getTop() + getPaddingTop()) - i12, (rectangle.getRight() + getPaddingStart()) - i13, (rectangle.getBottom() + getPaddingTop()) - i12);
                return;
            }
            layoutDecoratedWithMargins(viewForPosition, getWidth() - ((rectangle.getRight() + getPaddingStart()) - i13), (rectangle.getTop() + getPaddingTop()) - i12, getWidth() - ((rectangle.getLeft() + getPaddingStart()) - i13), (rectangle.getBottom() + getPaddingTop()) - i12);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    private final void refreshParams(RecyclerView.State state) {
        int i11;
        int maxY;
        int heightWithoutPadding;
        if (state.getItemCount() != 0) {
            if (this.isHorizontal) {
                maxY = this.helper.getMaxX();
                heightWithoutPadding = getWidthWithoutPadding();
            } else if (this.isVertical) {
                maxY = this.helper.getMaxY();
                heightWithoutPadding = getHeightWithoutPadding();
            }
            i11 = maxY - heightWithoutPadding;
            int coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i11, 0);
            this.maxScrollOffset = coerceAtLeast;
            this.scrollOffset = Math.min(this.scrollOffset, coerceAtLeast);
        }
        i11 = 0;
        int coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(i11, 0);
        this.maxScrollOffset = coerceAtLeast2;
        this.scrollOffset = Math.min(this.scrollOffset, coerceAtLeast2);
    }

    private final int scrollBy(int i11, RecyclerView.Recycler recycler) {
        int i12;
        if (this.maxScrollOffset <= 0 || i11 == 0) {
            return 0;
        }
        int directionSign = i11 * getDirectionSign();
        if (directionSign > 0) {
            i12 = Math.min(this.maxScrollOffset - this.scrollOffset, directionSign);
        } else {
            i12 = Math.max(-this.scrollOffset, directionSign);
        }
        if (this.isHorizontal) {
            offsetChildrenHorizontal(getDirectionSign() * (-i12));
        } else {
            offsetChildrenVertical(-i12);
        }
        this.scrollOffset += i12;
        fillGaps(recycler);
        return getDirectionSign() * i12;
    }

    public boolean canScrollHorizontally() {
        return this.isHorizontal;
    }

    public boolean canScrollVertically() {
        return this.isVertical;
    }

    @Nullable
    public final Integer findFirstCompletelyVisibleItemPosition() {
        return ArraysKt___ArraysKt.minOrNull(getCompletelyVisibleIndexes());
    }

    @Nullable
    public final Integer findLastCompletelyVisibleItemPosition() {
        return ArraysKt___ArraysKt.maxOrNull(getCompletelyVisibleIndexes());
    }

    public final int findLastVisibleItemPosition() {
        View childAt;
        if (!isEmpty() && (childAt = getChildAt(getLastChildIndex())) != null) {
            return getPosition(childAt);
        }
        return -1;
    }

    @NotNull
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-1, -1);
    }

    @NotNull
    public final ItemSizeLookup getItemSizeLookup() {
        return this.itemSizeLookup;
    }

    public final int getItemSpacing() {
        return this.itemSpacing;
    }

    public boolean isAutoMeasureEnabled() {
        return false;
    }

    public void onLayoutChildren(@NotNull RecyclerView.Recycler recycler, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        Integer mainAxisSize = this.helper.getMainAxisSize();
        int mainAxisSize2 = getMainAxisSize();
        if (!(mainAxisSize != null && mainAxisSize.intValue() == mainAxisSize2 && this.helper.getCrossAxisSize() == getCrossAxisSize())) {
            a(this, state, (Integer) null, (Integer) null, 6, (Object) null);
        }
        detachAllViews(recycler);
        refreshParams(state);
        fillGaps(recycler);
    }

    public void onMeasure(@NotNull RecyclerView.Recycler recycler, @NotNull RecyclerView.State state, int i11, int i12) {
        int i13;
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        if (isEmpty() || state.didStructureChange() || state.getItemCount() != this.helper.getRectanglesCount$core_release()) {
            int size = View.MeasureSpec.getSize(i12);
            int size2 = View.MeasureSpec.getSize(i11);
            boolean z11 = this.isHorizontal;
            if (z11) {
                i13 = size;
            } else {
                i13 = size2;
            }
            if (z11) {
                size = size2;
            }
            createAndFillHelper(state, Integer.valueOf(i13), Integer.valueOf(size));
        }
        setMeasuredDimension(getSize(i11, this.helper.getMaxX() + getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth(this.recyclerView)), getSize(i12, this.helper.getMaxY() + getPaddingTop() + getPaddingBottom(), ViewCompat.getMinimumHeight(this.recyclerView)));
    }

    public int scrollHorizontallyBy(int i11, @NotNull RecyclerView.Recycler recycler, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        return scrollBy(i11, recycler);
    }

    public int scrollVerticallyBy(int i11, @NotNull RecyclerView.Recycler recycler, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(recycler, "recycler");
        Intrinsics.checkNotNullParameter(state, "state");
        return scrollBy(i11, recycler);
    }

    public final void setItemSizeLookup(@NotNull ItemSizeLookup itemSizeLookup2) {
        Intrinsics.checkNotNullParameter(itemSizeLookup2, "<set-?>");
        this.itemSizeLookup = itemSizeLookup2;
    }

    public final void setItemSpacing(int i11) {
        this.itemSpacing = i11;
    }

    public FreeSpacingLayoutManager(boolean z11, @NotNull RecyclerView recyclerView2, @NotNull ItemSizeLookup itemSizeLookup2) {
        Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
        Intrinsics.checkNotNullParameter(itemSizeLookup2, "itemSizeLookup");
        this.isHorizontal = z11;
        this.recyclerView = recyclerView2;
        this.itemSizeLookup = itemSizeLookup2;
        this.shownPositions = SetsKt__SetsKt.emptySet();
        this.helper = new FreeSpacingHelper(getCrossAxisSize(), Integer.valueOf(getMainAxisSize()), this.itemSpacing, z11);
        this.isVertical = !z11;
    }
}
