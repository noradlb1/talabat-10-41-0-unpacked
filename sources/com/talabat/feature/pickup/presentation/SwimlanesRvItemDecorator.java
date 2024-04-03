package com.talabat.feature.pickup.presentation;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.designsystem.marshmallow.R;
import com.talabat.talabatcommon.extentions.IntKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001c\u0010\u0012\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0011H\u0002¨\u0006\u0014"}, d2 = {"Lcom/talabat/feature/pickup/presentation/SwimlanesRvItemDecorator;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "left", "isLtr", "", "start", "", "right", "end", "com_talabat_feature_pickup_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlanesRvItemDecorator extends RecyclerView.ItemDecoration {
    private final void left(Rect rect, boolean z11, int i11) {
        if (z11) {
            rect.left = i11;
        } else {
            rect.right = i11;
        }
    }

    private final void right(Rect rect, boolean z11, int i11) {
        if (z11) {
            rect.right = i11;
        } else {
            rect.left = i11;
        }
    }

    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        boolean z11;
        Integer num;
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        if (recyclerView.getLayoutDirection() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        int dimensionPixelOffset = recyclerView.getResources().getDimensionPixelOffset(R.dimen.ds_s);
        if (recyclerView.getChildAdapterPosition(view) == 0) {
            left(rect, z11, dimensionPixelOffset);
        }
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            num = Integer.valueOf(adapter.getItemCount());
        } else {
            num = null;
        }
        if (childAdapterPosition == IntKt.orZero(num) - 1) {
            right(rect, z11, dimensionPixelOffset);
        } else {
            right(rect, z11, recyclerView.getResources().getDimensionPixelOffset(R.dimen.ds_xs));
        }
    }
}
