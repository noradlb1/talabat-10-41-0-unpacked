package com.talabat.feature.pickup.presentation;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.designsystem.marshmallow.R;
import com.talabat.feature.pickup.presentation.adapters.BannerViewHolder;
import com.talabat.feature.pickup.presentation.adapters.SwimlanesHeaderAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/talabat/feature/pickup/presentation/PickupRvItemDecorator;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "com_talabat_feature_pickup_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PickupRvItemDecorator extends RecyclerView.ItemDecoration {
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int dimensionPixelOffset = recyclerView.getResources().getDimensionPixelOffset(R.dimen.ds_s);
        if (!(recyclerView.getChildViewHolder(view) instanceof BannerViewHolder) && !(recyclerView.getChildViewHolder(view) instanceof VendorsHeaderViewHolder) && !(recyclerView.getChildViewHolder(view) instanceof SwimlanesHeaderAdapter.ViewHolder)) {
            rect.top = dimensionPixelOffset;
        }
    }
}
