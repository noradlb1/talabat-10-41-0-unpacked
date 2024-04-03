package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class ViewFreeDeliveryTypeVoucherBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView freeDeliveryVoucherAmount;
    @NonNull
    public final RelativeLayout freeDeliveryVoucherLayout;
    @NonNull
    public final TalabatTextView freeDeliveryVoucherName;
    @NonNull
    private final RelativeLayout rootView;

    private ViewFreeDeliveryTypeVoucherBinding(@NonNull RelativeLayout relativeLayout, @NonNull TalabatTextView talabatTextView, @NonNull RelativeLayout relativeLayout2, @NonNull TalabatTextView talabatTextView2) {
        this.rootView = relativeLayout;
        this.freeDeliveryVoucherAmount = talabatTextView;
        this.freeDeliveryVoucherLayout = relativeLayout2;
        this.freeDeliveryVoucherName = talabatTextView2;
    }

    @NonNull
    public static ViewFreeDeliveryTypeVoucherBinding bind(@NonNull View view) {
        int i11 = R.id.free_delivery_voucher_amount;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.free_delivery_voucher_amount);
        if (talabatTextView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.free_delivery_voucher_name);
            if (talabatTextView2 != null) {
                return new ViewFreeDeliveryTypeVoucherBinding(relativeLayout, talabatTextView, relativeLayout, talabatTextView2);
            }
            i11 = R.id.free_delivery_voucher_name;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewFreeDeliveryTypeVoucherBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewFreeDeliveryTypeVoucherBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_free_delivery_type_voucher, viewGroup, false);
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
