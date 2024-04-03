package com.talabat.talabatcommon.views.titleViewMoreHorizontalListView;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.talabatcommon.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/talabatcommon/views/titleViewMoreHorizontalListView/HorizontalSpacingItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "externalMargin", "", "(Z)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HorizontalSpacingItemDecoration extends RecyclerView.ItemDecoration {
    private final boolean externalMargin;

    public HorizontalSpacingItemDecoration() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HorizontalSpacingItemDecoration(boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? true : z11);
    }

    @SuppressLint({"NewApi"})
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        int i11;
        int i12;
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        int i13 = 0;
        if (adapter != null) {
            i11 = adapter.getItemCount();
        } else {
            i11 = 0;
        }
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int dimensionPixelSize = recyclerView.getContext().getResources().getDimensionPixelSize(R.dimen.horizontal_view_internal_margin);
        if (this.externalMargin) {
            i12 = recyclerView.getContext().getResources().getDimensionPixelSize(R.dimen.horizontal_view_external_margin);
        } else {
            i12 = 0;
        }
        if (recyclerView.getResources().getConfiguration().getLayoutDirection() == 1) {
            if (childAdapterPosition == 0) {
                dimensionPixelSize = i12;
            }
            rect.right = dimensionPixelSize;
            if (childAdapterPosition == i11 - 1) {
                i13 = i12;
            }
            rect.left = i13;
            return;
        }
        if (childAdapterPosition == 0) {
            dimensionPixelSize = i12;
        }
        rect.left = dimensionPixelSize;
        if (childAdapterPosition == i11 - 1) {
            i13 = i12;
        }
        rect.right = i13;
    }

    public HorizontalSpacingItemDecoration(boolean z11) {
        this.externalMargin = z11;
    }
}
