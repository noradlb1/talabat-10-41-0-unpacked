package com.talabat.talabatcommon.databinding;

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
import com.talabat.talabatcommon.R;

public final class BasketLifecycleVoucherViewBinding implements ViewBinding {
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final ImageView welcomeVoucherIconImageView;
    @NonNull
    public final TextView welcomeVoucherLoginButton;
    @NonNull
    public final TextView welcomeVoucherTitleTextView;

    private BasketLifecycleVoucherViewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.welcomeVoucherIconImageView = imageView;
        this.welcomeVoucherLoginButton = textView;
        this.welcomeVoucherTitleTextView = textView2;
    }

    @NonNull
    public static BasketLifecycleVoucherViewBinding bind(@NonNull View view) {
        int i11 = R.id.welcomeVoucherIconImageView;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.welcomeVoucherLoginButton;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.welcomeVoucherTitleTextView;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    return new BasketLifecycleVoucherViewBinding((ConstraintLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static BasketLifecycleVoucherViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static BasketLifecycleVoucherViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.basket_lifecycle_voucher_view, viewGroup, false);
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
