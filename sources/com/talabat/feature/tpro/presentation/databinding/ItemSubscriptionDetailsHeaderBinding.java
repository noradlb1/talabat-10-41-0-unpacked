package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.tpro.presentation.R;

public final class ItemSubscriptionDetailsHeaderBinding implements ViewBinding {
    @NonNull
    public final ConstraintLayout headerContainer;
    @NonNull
    public final ImageView ivBenefitsTproLogo;
    @NonNull
    public final ImageView ivClose;
    @NonNull
    public final ImageView ivPoster;
    @NonNull
    public final AppCompatImageView ivShahidBenefitsTproLogo;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final AppCompatTextView textGiftFromShahid;
    @NonNull
    public final AppCompatTextView textLimitedBenefits;

    private ItemSubscriptionDetailsHeaderBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2) {
        this.rootView = constraintLayout;
        this.headerContainer = constraintLayout2;
        this.ivBenefitsTproLogo = imageView;
        this.ivClose = imageView2;
        this.ivPoster = imageView3;
        this.ivShahidBenefitsTproLogo = appCompatImageView;
        this.textGiftFromShahid = appCompatTextView;
        this.textLimitedBenefits = appCompatTextView2;
    }

    @NonNull
    public static ItemSubscriptionDetailsHeaderBinding bind(@NonNull View view) {
        int i11 = R.id.header_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i11);
        if (constraintLayout != null) {
            i11 = R.id.iv_benefits_tpro_logo;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView != null) {
                i11 = R.id.iv_close;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i11);
                if (imageView2 != null) {
                    i11 = R.id.iv_poster;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i11);
                    if (imageView3 != null) {
                        i11 = R.id.iv_shahid_benefits_tpro_logo;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i11);
                        if (appCompatImageView != null) {
                            i11 = R.id.text_gift_from_shahid;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
                            if (appCompatTextView != null) {
                                i11 = R.id.text_limited_benefits;
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
                                if (appCompatTextView2 != null) {
                                    return new ItemSubscriptionDetailsHeaderBinding((ConstraintLayout) view, constraintLayout, imageView, imageView2, imageView3, appCompatImageView, appCompatTextView, appCompatTextView2);
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
    public static ItemSubscriptionDetailsHeaderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemSubscriptionDetailsHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_subscription_details_header, viewGroup, false);
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
