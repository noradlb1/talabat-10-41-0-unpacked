package com.deliveryhero.fluid.widgets.collections.list;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u001e\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/list/CellSpacingDecorator;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "()V", "spacing", "", "Lcom/deliveryhero/fluid/values/PixelInt;", "getSpacing", "()I", "setSpacing", "(I)V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CellSpacingDecorator extends RecyclerView.ItemDecoration {
    private int spacing;

    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        boolean z11 = false;
        if (adapter != null && recyclerView.getChildAdapterPosition(view) == adapter.getItemCount()) {
            z11 = true;
        }
        if (!z11) {
            rect.bottom = this.spacing;
        }
    }

    public final int getSpacing() {
        return this.spacing;
    }

    public final void setSpacing(int i11) {
        this.spacing = i11;
    }
}
