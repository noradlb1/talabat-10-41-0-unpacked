package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.views.ShimmerLayout;

public final class BottomSheetLoadingPlaceholderBinding implements ViewBinding {
    @NonNull
    public final ShimmerLayout bottomSheetLoadingPlaceholder;
    @NonNull
    public final FrameLayout cardPaymentContainer;
    @NonNull
    public final AppCompatImageView closeTipRider;
    @NonNull
    public final FrameLayout ctaButton;
    @NonNull
    public final FrameLayout riderBottomSheetTipsRadioGroup;
    @NonNull
    public final TextView riderTipInfoContent;
    @NonNull
    private final ShimmerLayout rootView;
    @NonNull
    public final TextView supportYourRider;

    private BottomSheetLoadingPlaceholderBinding(@NonNull ShimmerLayout shimmerLayout, @NonNull ShimmerLayout shimmerLayout2, @NonNull FrameLayout frameLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull FrameLayout frameLayout2, @NonNull FrameLayout frameLayout3, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = shimmerLayout;
        this.bottomSheetLoadingPlaceholder = shimmerLayout2;
        this.cardPaymentContainer = frameLayout;
        this.closeTipRider = appCompatImageView;
        this.ctaButton = frameLayout2;
        this.riderBottomSheetTipsRadioGroup = frameLayout3;
        this.riderTipInfoContent = textView;
        this.supportYourRider = textView2;
    }

    @NonNull
    public static BottomSheetLoadingPlaceholderBinding bind(@NonNull View view) {
        ShimmerLayout shimmerLayout = (ShimmerLayout) view;
        int i11 = R.id.card_payment_container;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i11);
        if (frameLayout != null) {
            i11 = R.id.close_tip_rider;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i11);
            if (appCompatImageView != null) {
                i11 = R.id.cta_button;
                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i11);
                if (frameLayout2 != null) {
                    i11 = R.id.riderBottomSheetTipsRadioGroup;
                    FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, i11);
                    if (frameLayout3 != null) {
                        i11 = R.id.rider_tip_info_content;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView != null) {
                            i11 = R.id.support_your_rider;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                            if (textView2 != null) {
                                return new BottomSheetLoadingPlaceholderBinding(shimmerLayout, shimmerLayout, frameLayout, appCompatImageView, frameLayout2, frameLayout3, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static BottomSheetLoadingPlaceholderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static BottomSheetLoadingPlaceholderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_loading_placeholder, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ShimmerLayout getRoot() {
        return this.rootView;
    }
}
