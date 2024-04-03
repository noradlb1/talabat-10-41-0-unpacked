package com.talabat.feature.swimlanevoucherslist.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.swimlanevoucherslist.presentation.R;

public final class DarkstoresSingleItemCustomerVouchersSwimlaneBinding implements ViewBinding {
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final Guideline separationGuideLine;
    @NonNull
    public final TextView voucherDesc;
    @NonNull
    public final AppCompatImageView voucherImage;
    @NonNull
    public final ConstraintLayout voucherRoot;
    @NonNull
    public final TextView voucherTitle;

    private DarkstoresSingleItemCustomerVouchersSwimlaneBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Guideline guideline, @NonNull TextView textView, @NonNull AppCompatImageView appCompatImageView, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.separationGuideLine = guideline;
        this.voucherDesc = textView;
        this.voucherImage = appCompatImageView;
        this.voucherRoot = constraintLayout2;
        this.voucherTitle = textView2;
    }

    @NonNull
    public static DarkstoresSingleItemCustomerVouchersSwimlaneBinding bind(@NonNull View view) {
        int i11 = R.id.separation_guide_line;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i11);
        if (guideline != null) {
            i11 = R.id.voucher_desc;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.voucher_image;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i11);
                if (appCompatImageView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i11 = R.id.voucher_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView2 != null) {
                        return new DarkstoresSingleItemCustomerVouchersSwimlaneBinding(constraintLayout, guideline, textView, appCompatImageView, constraintLayout, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresSingleItemCustomerVouchersSwimlaneBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresSingleItemCustomerVouchersSwimlaneBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_single_item_customer_vouchers_swimlane, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
