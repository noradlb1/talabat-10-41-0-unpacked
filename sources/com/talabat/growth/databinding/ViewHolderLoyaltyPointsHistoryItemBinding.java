package com.talabat.growth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_list_item_v2.DSListItem;
import com.talabat.growth.R;

public final class ViewHolderLoyaltyPointsHistoryItemBinding implements ViewBinding {
    @NonNull
    public final DSListItem historyPointListItem;
    @NonNull
    private final LinearLayout rootView;

    private ViewHolderLoyaltyPointsHistoryItemBinding(@NonNull LinearLayout linearLayout, @NonNull DSListItem dSListItem) {
        this.rootView = linearLayout;
        this.historyPointListItem = dSListItem;
    }

    @NonNull
    public static ViewHolderLoyaltyPointsHistoryItemBinding bind(@NonNull View view) {
        int i11 = R.id.historyPointListItem;
        DSListItem dSListItem = (DSListItem) ViewBindings.findChildViewById(view, i11);
        if (dSListItem != null) {
            return new ViewHolderLoyaltyPointsHistoryItemBinding((LinearLayout) view, dSListItem);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewHolderLoyaltyPointsHistoryItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewHolderLoyaltyPointsHistoryItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_holder_loyalty_points_history_item, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
