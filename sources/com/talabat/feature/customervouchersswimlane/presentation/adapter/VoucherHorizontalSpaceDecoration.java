package com.talabat.feature.customervouchersswimlane.presentation.adapter;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.feature.swimlanevoucherslist.presentation.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/talabat/feature/customervouchersswimlane/presentation/adapter/VoucherHorizontalSpaceDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "com_talabat_feature_customer-vouchers-swimlane_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherHorizontalSpaceDecoration extends RecyclerView.ItemDecoration {
    public void getItemOffsets(@NotNull Rect rect, @NotNull View view, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        int i11;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int dimension = (int) view.getContext().getResources().getDimension(R.dimen.vouchers_swinlane_12dp);
        int dimension2 = (int) view.getContext().getResources().getDimension(com.designsystem.marshmallow.R.dimen.ds_s);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        boolean z11 = false;
        if (adapter != null) {
            i11 = adapter.getItemCount();
        } else {
            i11 = 0;
        }
        int i12 = i11 - 1;
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null && i11 != 1) {
            if (1 <= childAdapterPosition && childAdapterPosition < i12) {
                z11 = true;
            }
            if (z11) {
                int i13 = dimension / 2;
                marginLayoutParams.setMarginEnd(i13);
                marginLayoutParams.setMarginStart(i13);
            } else if (childAdapterPosition == i12) {
                marginLayoutParams.setMarginEnd(dimension2);
                marginLayoutParams.setMarginStart(dimension / 2);
            } else {
                marginLayoutParams.setMarginEnd(dimension / 2);
                marginLayoutParams.setMarginStart(dimension2);
            }
        }
    }
}
