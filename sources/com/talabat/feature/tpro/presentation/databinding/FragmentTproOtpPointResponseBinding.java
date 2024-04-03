package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.tpro.presentation.R;

public final class FragmentTproOtpPointResponseBinding implements ViewBinding {
    @NonNull
    public final TextView actionButtonDismiss;
    @NonNull
    public final LinearLayout actionButtonView;
    @NonNull
    public final Barrier barrier;
    @NonNull
    public final ImageView cancelButton;
    @NonNull
    public final ConstraintLayout container;
    @NonNull
    public final ImageView ivBannerImage;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView tvBannerHeader;
    @NonNull
    public final TextView tvUpgradeSuccessDescription;

    private FragmentTproOtpPointResponseBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull Barrier barrier2, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout2, @NonNull ImageView imageView2, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = constraintLayout;
        this.actionButtonDismiss = textView;
        this.actionButtonView = linearLayout;
        this.barrier = barrier2;
        this.cancelButton = imageView;
        this.container = constraintLayout2;
        this.ivBannerImage = imageView2;
        this.tvBannerHeader = textView2;
        this.tvUpgradeSuccessDescription = textView3;
    }

    @NonNull
    public static FragmentTproOtpPointResponseBinding bind(@NonNull View view) {
        int i11 = R.id.action_button_dismiss;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.action_button_view;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
            if (linearLayout != null) {
                i11 = R.id.barrier;
                Barrier barrier2 = (Barrier) ViewBindings.findChildViewById(view, i11);
                if (barrier2 != null) {
                    i11 = R.id.cancel_button;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
                    if (imageView != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i11 = R.id.iv_banner_image;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i11);
                        if (imageView2 != null) {
                            i11 = R.id.tv_banner_header;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                            if (textView2 != null) {
                                i11 = R.id.tv_upgrade_success_description;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                                if (textView3 != null) {
                                    return new FragmentTproOtpPointResponseBinding(constraintLayout, textView, linearLayout, barrier2, imageView, constraintLayout, imageView2, textView2, textView3);
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
    public static FragmentTproOtpPointResponseBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentTproOtpPointResponseBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_tpro_otp_point_response, viewGroup, false);
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
