package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.tpro.presentation.R;
import com.talabat.feature.tpro.presentation.benefits.view.learnmore.OnBoardingCardLearnMoreView;

public final class ItemTagBenefitCardBinding implements ViewBinding {
    @NonNull
    public final ProOnboardingButtonBinding buttonLayout;
    @NonNull
    public final ConstraintLayout clView;
    @NonNull
    public final Group frontGroup;
    @NonNull
    public final Guideline guidelineEndContent;
    @NonNull
    public final Guideline guidelineStartContent;
    @NonNull
    public final Guideline guidelineTopContent;
    @NonNull
    public final ImageView ivBackgroundImage;
    @NonNull
    public final ImageView ivTop;
    @NonNull
    public final OnBoardingCardLearnMoreView learnMoreView;
    @NonNull
    private final CardView rootView;
    @NonNull
    public final RecyclerView rvRewardsList;
    @NonNull
    public final TextView tvCardTitle;

    private ItemTagBenefitCardBinding(@NonNull CardView cardView, @NonNull ProOnboardingButtonBinding proOnboardingButtonBinding, @NonNull ConstraintLayout constraintLayout, @NonNull Group group, @NonNull Guideline guideline, @NonNull Guideline guideline2, @NonNull Guideline guideline3, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull OnBoardingCardLearnMoreView onBoardingCardLearnMoreView, @NonNull RecyclerView recyclerView, @NonNull TextView textView) {
        this.rootView = cardView;
        this.buttonLayout = proOnboardingButtonBinding;
        this.clView = constraintLayout;
        this.frontGroup = group;
        this.guidelineEndContent = guideline;
        this.guidelineStartContent = guideline2;
        this.guidelineTopContent = guideline3;
        this.ivBackgroundImage = imageView;
        this.ivTop = imageView2;
        this.learnMoreView = onBoardingCardLearnMoreView;
        this.rvRewardsList = recyclerView;
        this.tvCardTitle = textView;
    }

    @NonNull
    public static ItemTagBenefitCardBinding bind(@NonNull View view) {
        int i11 = R.id.button_layout;
        View findChildViewById = ViewBindings.findChildViewById(view, i11);
        if (findChildViewById != null) {
            ProOnboardingButtonBinding bind = ProOnboardingButtonBinding.bind(findChildViewById);
            i11 = R.id.cl_view;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i11);
            if (constraintLayout != null) {
                i11 = R.id.front_group;
                Group group = (Group) ViewBindings.findChildViewById(view, i11);
                if (group != null) {
                    i11 = R.id.guidelineEndContent;
                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i11);
                    if (guideline != null) {
                        i11 = R.id.guidelineStartContent;
                        Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i11);
                        if (guideline2 != null) {
                            i11 = R.id.guidelineTopContent;
                            Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i11);
                            if (guideline3 != null) {
                                i11 = R.id.ivBackgroundImage;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
                                if (imageView != null) {
                                    i11 = R.id.ivTop;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i11);
                                    if (imageView2 != null) {
                                        i11 = R.id.learnMoreView;
                                        OnBoardingCardLearnMoreView onBoardingCardLearnMoreView = (OnBoardingCardLearnMoreView) ViewBindings.findChildViewById(view, i11);
                                        if (onBoardingCardLearnMoreView != null) {
                                            i11 = R.id.rv_rewards_list;
                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i11);
                                            if (recyclerView != null) {
                                                i11 = R.id.tvCardTitle;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                                                if (textView != null) {
                                                    return new ItemTagBenefitCardBinding((CardView) view, bind, constraintLayout, group, guideline, guideline2, guideline3, imageView, imageView2, onBoardingCardLearnMoreView, recyclerView, textView);
                                                }
                                            }
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
    public static ItemTagBenefitCardBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemTagBenefitCardBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_tag_benefit_card, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public CardView getRoot() {
        return this.rootView;
    }
}
