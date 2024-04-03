package com.deliveryhero.fluid.widgets.collections.grid.horizontal;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/grid/horizontal/NativeHorizontalGridSpacingDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "verticalSpacing", "", "horizontalSpacing", "(II)V", "getHorizontalSpacing", "()I", "setHorizontalSpacing", "(I)V", "getVerticalSpacing", "setVerticalSpacing", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NativeHorizontalGridSpacingDecoration extends RecyclerView.ItemDecoration {
    private int horizontalSpacing;
    private int verticalSpacing;

    public NativeHorizontalGridSpacingDecoration() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NativeHorizontalGridSpacingDecoration(int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 0 : i11, (i13 & 2) != 0 ? 0 : i12);
    }

    public final int getHorizontalSpacing() {
        return this.horizontalSpacing;
    }

    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager != null) {
            int spanCount = ((StaggeredGridLayoutManager) layoutManager).getSpanCount();
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                int spanIndex = ((StaggeredGridLayoutManager.LayoutParams) layoutParams).getSpanIndex();
                int i11 = this.verticalSpacing;
                rect.top = (spanIndex * i11) / spanCount;
                rect.bottom = i11 - (((spanIndex + 1) * i11) / spanCount);
                if (childAdapterPosition < spanCount) {
                    return;
                }
                if (recyclerView.getLayoutDirection() == 0) {
                    rect.left = this.horizontalSpacing;
                } else {
                    rect.right = this.horizontalSpacing;
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager");
        }
    }

    public final int getVerticalSpacing() {
        return this.verticalSpacing;
    }

    public final void setHorizontalSpacing(int i11) {
        this.horizontalSpacing = i11;
    }

    public final void setVerticalSpacing(int i11) {
        this.verticalSpacing = i11;
    }

    public NativeHorizontalGridSpacingDecoration(int i11, int i12) {
        this.verticalSpacing = i11;
        this.horizontalSpacing = i12;
    }
}
