package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.talabat.darkstores.R;

public final class DarkstoresCartProgressViewBinding implements ViewBinding {
    @NonNull
    public final LinearLayout cartLabelContainer;
    @NonNull
    public final LinearProgressIndicator cartProgress;
    @NonNull
    public final AppCompatImageView cartProgressImage;
    @NonNull
    public final AppCompatTextView cartProgressLabel;
    @NonNull
    public final LinearLayout cartTproLabelContainer;
    @NonNull
    public final AppCompatImageView cartTproProgressImage;
    @NonNull
    public final AppCompatTextView cartTproProgressLabel;
    @NonNull
    public final AppCompatImageView deliveryTierInfo;
    @NonNull
    private final View rootView;

    private DarkstoresCartProgressViewBinding(@NonNull View view, @NonNull LinearLayout linearLayout, @NonNull LinearProgressIndicator linearProgressIndicator, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatTextView appCompatTextView, @NonNull LinearLayout linearLayout2, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatImageView appCompatImageView3) {
        this.rootView = view;
        this.cartLabelContainer = linearLayout;
        this.cartProgress = linearProgressIndicator;
        this.cartProgressImage = appCompatImageView;
        this.cartProgressLabel = appCompatTextView;
        this.cartTproLabelContainer = linearLayout2;
        this.cartTproProgressImage = appCompatImageView2;
        this.cartTproProgressLabel = appCompatTextView2;
        this.deliveryTierInfo = appCompatImageView3;
    }

    @NonNull
    public static DarkstoresCartProgressViewBinding bind(@NonNull View view) {
        int i11 = R.id.cart_label_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
        if (linearLayout != null) {
            i11 = R.id.cart_progress;
            LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) ViewBindings.findChildViewById(view, i11);
            if (linearProgressIndicator != null) {
                i11 = R.id.cart_progress_image;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i11);
                if (appCompatImageView != null) {
                    i11 = R.id.cart_progress_label;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
                    if (appCompatTextView != null) {
                        i11 = R.id.cart_tpro_label_container;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                        if (linearLayout2 != null) {
                            i11 = R.id.cart_tpro_progress_image;
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i11);
                            if (appCompatImageView2 != null) {
                                i11 = R.id.cart_tpro_progress_label;
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
                                if (appCompatTextView2 != null) {
                                    i11 = R.id.delivery_tier_info;
                                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(view, i11);
                                    if (appCompatImageView3 != null) {
                                        return new DarkstoresCartProgressViewBinding(view, linearLayout, linearProgressIndicator, appCompatImageView, appCompatTextView, linearLayout2, appCompatImageView2, appCompatTextView2, appCompatImageView3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresCartProgressViewBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.darkstores_cart_progress_view, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
