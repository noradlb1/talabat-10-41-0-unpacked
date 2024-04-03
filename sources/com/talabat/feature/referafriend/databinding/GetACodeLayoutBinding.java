package com.talabat.feature.referafriend.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.referafriend.R;

public final class GetACodeLayoutBinding implements ViewBinding {
    @NonNull
    public final ImageView ivVoucher;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView tvVoucherEntryComponentSubTitle;
    @NonNull
    public final TextView tvVoucherEntryComponentTitle;

    private GetACodeLayoutBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.ivVoucher = imageView;
        this.tvVoucherEntryComponentSubTitle = textView;
        this.tvVoucherEntryComponentTitle = textView2;
    }

    @NonNull
    public static GetACodeLayoutBinding bind(@NonNull View view) {
        int i11 = R.id.ivVoucher;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.tvVoucherEntryComponentSubTitle;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.tvVoucherEntryComponentTitle;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    return new GetACodeLayoutBinding((ConstraintLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static GetACodeLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static GetACodeLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.get_a_code_layout, viewGroup, false);
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
