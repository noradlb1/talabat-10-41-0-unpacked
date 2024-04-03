package com.talabat.feature.pickup.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_small_button.DSSecondarySmallButton;
import com.talabat.feature.pickup.presentation.R;

public final class HeaderValuePropBannerBinding implements ViewBinding {
    @NonNull
    public final TextView bannerTitleTv;
    @NonNull
    public final ConstraintLayout bannerView;
    @NonNull
    public final Guideline bgImageStartGuideline;
    @NonNull
    public final DSSecondarySmallButton learnBtn;
    @NonNull
    private final ConstraintLayout rootView;

    private HeaderValuePropBannerBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout2, @NonNull Guideline guideline, @NonNull DSSecondarySmallButton dSSecondarySmallButton) {
        this.rootView = constraintLayout;
        this.bannerTitleTv = textView;
        this.bannerView = constraintLayout2;
        this.bgImageStartGuideline = guideline;
        this.learnBtn = dSSecondarySmallButton;
    }

    @NonNull
    public static HeaderValuePropBannerBinding bind(@NonNull View view) {
        int i11 = R.id.bannerTitleTv;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i11 = R.id.bgImageStartGuideline;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i11);
            if (guideline != null) {
                i11 = R.id.learnBtn;
                DSSecondarySmallButton dSSecondarySmallButton = (DSSecondarySmallButton) ViewBindings.findChildViewById(view, i11);
                if (dSSecondarySmallButton != null) {
                    return new HeaderValuePropBannerBinding(constraintLayout, textView, constraintLayout, guideline, dSSecondarySmallButton);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static HeaderValuePropBannerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static HeaderValuePropBannerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.header_value_prop_banner, viewGroup, false);
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
