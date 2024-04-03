package com.talabat.talabatcommon.views.titleViewMoreGridView;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/talabatcommon/views/titleViewMoreGridView/GridSpacingItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "spanCount", "", "spacing", "spacingExternal", "includeEdge", "", "(IIIZ)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    private final boolean includeEdge;
    private final int spacing;
    private final int spacingExternal;
    private final int spanCount;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GridSpacingItemDecoration(int i11, int i12, int i13, boolean z11, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, i12, (i14 & 4) != 0 ? i12 : i13, z11);
    }

    @SuppressLint({"NewApi"})
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i16 = childAdapterPosition % this.spanCount;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            i11 = adapter.getItemCount();
        } else {
            i11 = 0;
        }
        Configuration configuration = recyclerView.getResources().getConfiguration();
        if (this.includeEdge) {
            if (configuration.getLayoutDirection() == 1) {
                if (childAdapterPosition == i11 - 1) {
                    i14 = this.spacingExternal;
                } else {
                    i14 = ((i16 + 1) * this.spacing) / this.spanCount;
                }
                rect.left = i14;
                if (childAdapterPosition == 0) {
                    i15 = this.spacingExternal;
                } else {
                    int i17 = this.spacing;
                    i15 = i17 - ((i16 * i17) / this.spanCount);
                }
                rect.right = i15;
            } else {
                if (childAdapterPosition == i11 - 1) {
                    i12 = this.spacingExternal;
                } else {
                    i12 = ((i16 + 1) * this.spacing) / this.spanCount;
                }
                rect.right = i12;
                if (childAdapterPosition == 0) {
                    i13 = this.spacingExternal;
                } else {
                    int i18 = this.spacing;
                    i13 = i18 - ((i16 * i18) / this.spanCount);
                }
                rect.left = i13;
            }
            if (childAdapterPosition < this.spanCount) {
                rect.top = this.spacing;
            }
            rect.bottom = this.spacing;
            return;
        }
        if (configuration.getLayoutDirection() == 1) {
            int i19 = this.spacing;
            int i21 = this.spanCount;
            rect.left = i19 - (((i16 + 1) * i19) / i21);
            rect.right = (i16 * i19) / i21;
        } else {
            int i22 = this.spacing;
            int i23 = this.spanCount;
            rect.left = (i16 * i22) / i23;
            rect.right = i22 - (((i16 + 1) * i22) / i23);
        }
        if (childAdapterPosition >= this.spanCount) {
            rect.top = this.spacing;
        }
    }

    public GridSpacingItemDecoration(int i11, int i12, int i13, boolean z11) {
        this.spanCount = i11;
        this.spacing = i12;
        this.spacingExternal = i13;
        this.includeEdge = z11;
    }
}
