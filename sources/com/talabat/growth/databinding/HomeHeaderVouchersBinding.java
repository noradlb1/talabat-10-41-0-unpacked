package com.talabat.growth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.growth.R;

public final class HomeHeaderVouchersBinding implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final LinearLayout voucherContainer;
    @NonNull
    public final AppCompatImageView voucherHeaderIcon;
    @NonNull
    public final AppCompatTextView vouchersHeaderTitle;

    private HomeHeaderVouchersBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatTextView appCompatTextView) {
        this.rootView = linearLayout;
        this.voucherContainer = linearLayout2;
        this.voucherHeaderIcon = appCompatImageView;
        this.vouchersHeaderTitle = appCompatTextView;
    }

    @NonNull
    public static HomeHeaderVouchersBinding bind(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i11 = R.id.voucher_header_icon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i11);
        if (appCompatImageView != null) {
            i11 = R.id.vouchers_header_title;
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
            if (appCompatTextView != null) {
                return new HomeHeaderVouchersBinding(linearLayout, linearLayout, appCompatImageView, appCompatTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static HomeHeaderVouchersBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static HomeHeaderVouchersBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.home_header_vouchers, viewGroup, false);
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
