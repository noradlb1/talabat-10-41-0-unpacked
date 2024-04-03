package com.talabat.growth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_list_item_v2.DSListItem;
import com.talabat.growth.R;

public final class ViewHolderVoucherItemBinding implements ViewBinding {
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final DSListItem voucherListItem;

    private ViewHolderVoucherItemBinding(@NonNull RelativeLayout relativeLayout, @NonNull DSListItem dSListItem) {
        this.rootView = relativeLayout;
        this.voucherListItem = dSListItem;
    }

    @NonNull
    public static ViewHolderVoucherItemBinding bind(@NonNull View view) {
        int i11 = R.id.voucherListItem;
        DSListItem dSListItem = (DSListItem) ViewBindings.findChildViewById(view, i11);
        if (dSListItem != null) {
            return new ViewHolderVoucherItemBinding((RelativeLayout) view, dSListItem);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewHolderVoucherItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewHolderVoucherItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_holder_voucher_item, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
