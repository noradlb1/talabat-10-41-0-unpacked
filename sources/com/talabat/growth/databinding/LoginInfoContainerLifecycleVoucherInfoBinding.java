package com.talabat.growth.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.marshmallow.TalabatTag;
import com.talabat.growth.R;

public final class LoginInfoContainerLifecycleVoucherInfoBinding implements ViewBinding {
    @NonNull
    public final ImageView ivCoverLogo;
    @NonNull
    public final TextView lifecycleLoginInfo;
    @NonNull
    public final TextView lifecycleLoginTitle;
    @NonNull
    public final TextView lifecycleVoucherDescription;
    @NonNull
    public final TextView lifecycleVoucherHint;
    @NonNull
    public final TextView lifecycleVoucherTermsAndConditions;
    @NonNull
    public final TextView lifecycleVoucherTitle;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final Guideline verticalGuideLine;
    @NonNull
    public final TalabatTag voucherTag;

    private LoginInfoContainerLifecycleVoucherInfoBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6, @NonNull Guideline guideline, @NonNull TalabatTag talabatTag) {
        this.rootView = linearLayout;
        this.ivCoverLogo = imageView;
        this.lifecycleLoginInfo = textView;
        this.lifecycleLoginTitle = textView2;
        this.lifecycleVoucherDescription = textView3;
        this.lifecycleVoucherHint = textView4;
        this.lifecycleVoucherTermsAndConditions = textView5;
        this.lifecycleVoucherTitle = textView6;
        this.verticalGuideLine = guideline;
        this.voucherTag = talabatTag;
    }

    @NonNull
    public static LoginInfoContainerLifecycleVoucherInfoBinding bind(@NonNull View view) {
        int i11 = R.id.iv_cover_logo;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.lifecycleLoginInfo;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.lifecycleLoginTitle;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    i11 = R.id.lifecycleVoucherDescription;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView3 != null) {
                        i11 = R.id.lifecycleVoucherHint;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView4 != null) {
                            i11 = R.id.lifecycleVoucherTermsAndConditions;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i11);
                            if (textView5 != null) {
                                i11 = R.id.lifecycleVoucherTitle;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i11);
                                if (textView6 != null) {
                                    i11 = R.id.verticalGuideLine;
                                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i11);
                                    if (guideline != null) {
                                        i11 = R.id.voucherTag;
                                        TalabatTag talabatTag = (TalabatTag) ViewBindings.findChildViewById(view, i11);
                                        if (talabatTag != null) {
                                            return new LoginInfoContainerLifecycleVoucherInfoBinding((LinearLayout) view, imageView, textView, textView2, textView3, textView4, textView5, textView6, guideline, talabatTag);
                                        }
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
    public static LoginInfoContainerLifecycleVoucherInfoBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LoginInfoContainerLifecycleVoucherInfoBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.login_info_container_lifecycle_voucher_info, viewGroup, false);
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
