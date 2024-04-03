package com.talabat.feature.swimlanevoucherslist.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.swimlanevoucherslist.presentation.R;

public final class DarkstoresViewCustomerVouchersSwimlaneBinding implements ViewBinding {
    @NonNull
    private final FrameLayout rootView;
    @NonNull
    public final RecyclerView vouchersList;

    private DarkstoresViewCustomerVouchersSwimlaneBinding(@NonNull FrameLayout frameLayout, @NonNull RecyclerView recyclerView) {
        this.rootView = frameLayout;
        this.vouchersList = recyclerView;
    }

    @NonNull
    public static DarkstoresViewCustomerVouchersSwimlaneBinding bind(@NonNull View view) {
        int i11 = R.id.vouchers_list;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i11);
        if (recyclerView != null) {
            return new DarkstoresViewCustomerVouchersSwimlaneBinding((FrameLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresViewCustomerVouchersSwimlaneBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresViewCustomerVouchersSwimlaneBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_view_customer_vouchers_swimlane, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
