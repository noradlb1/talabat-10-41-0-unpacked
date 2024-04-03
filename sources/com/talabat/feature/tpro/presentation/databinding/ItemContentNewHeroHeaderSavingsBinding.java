package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.tpro.presentation.R;
import com.talabat.feature.tpro.presentation.benefits.view.AverageInfoOnboardingCard;
import com.talabat.feature.tpro.presentation.benefits.view.ExpandableOnboardingCard;

public final class ItemContentNewHeroHeaderSavingsBinding implements ViewBinding {
    @NonNull
    public final AverageInfoOnboardingCard averageCard;
    @NonNull
    public final ConstraintLayout clView;
    @NonNull
    public final ExpandableOnboardingCard expandableCard;
    @NonNull
    public final Guideline guidelineEnd;
    @NonNull
    public final Guideline guidelineStart;
    @NonNull
    public final ImageView ivBackground;
    @NonNull
    public final ImageView ivBenefitsTproLogo;
    @NonNull
    public final ImageView ivClose;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView tvOnBoardingHeader;

    private ItemContentNewHeroHeaderSavingsBinding(@NonNull ConstraintLayout constraintLayout, @NonNull AverageInfoOnboardingCard averageInfoOnboardingCard, @NonNull ConstraintLayout constraintLayout2, @NonNull ExpandableOnboardingCard expandableOnboardingCard, @NonNull Guideline guideline, @NonNull Guideline guideline2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull TextView textView) {
        this.rootView = constraintLayout;
        this.averageCard = averageInfoOnboardingCard;
        this.clView = constraintLayout2;
        this.expandableCard = expandableOnboardingCard;
        this.guidelineEnd = guideline;
        this.guidelineStart = guideline2;
        this.ivBackground = imageView;
        this.ivBenefitsTproLogo = imageView2;
        this.ivClose = imageView3;
        this.tvOnBoardingHeader = textView;
    }

    @NonNull
    public static ItemContentNewHeroHeaderSavingsBinding bind(@NonNull View view) {
        int i11 = R.id.average_card;
        AverageInfoOnboardingCard averageInfoOnboardingCard = (AverageInfoOnboardingCard) ViewBindings.findChildViewById(view, i11);
        if (averageInfoOnboardingCard != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i11 = R.id.expandable_card;
            ExpandableOnboardingCard expandableOnboardingCard = (ExpandableOnboardingCard) ViewBindings.findChildViewById(view, i11);
            if (expandableOnboardingCard != null) {
                i11 = R.id.guideline_end;
                Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i11);
                if (guideline != null) {
                    i11 = R.id.guideline_start;
                    Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i11);
                    if (guideline2 != null) {
                        i11 = R.id.iv_background;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
                        if (imageView != null) {
                            i11 = R.id.iv_benefits_tpro_logo;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i11);
                            if (imageView2 != null) {
                                i11 = R.id.iv_close;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i11);
                                if (imageView3 != null) {
                                    i11 = R.id.tv_on_boarding_header;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                                    if (textView != null) {
                                        return new ItemContentNewHeroHeaderSavingsBinding(constraintLayout, averageInfoOnboardingCard, constraintLayout, expandableOnboardingCard, guideline, guideline2, imageView, imageView2, imageView3, textView);
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
    public static ItemContentNewHeroHeaderSavingsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemContentNewHeroHeaderSavingsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_content_new_hero_header_savings, viewGroup, false);
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
