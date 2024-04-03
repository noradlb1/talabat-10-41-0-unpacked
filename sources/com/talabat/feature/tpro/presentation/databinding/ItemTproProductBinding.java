package com.talabat.feature.tpro.presentation.databinding;

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
import com.talabat.feature.tpro.presentation.R;

public final class ItemTproProductBinding implements ViewBinding {
    @NonNull
    public final ConstraintLayout headerContainer;
    @NonNull
    public final ImageView ivBenefitIcon;
    @NonNull
    public final TextView learnMoreText;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView tvBenefitContent;
    @NonNull
    public final TextView tvBenefitHeader;
    @NonNull
    public final TextView tvOnBoardingContentHeader;

    private ItemTproProductBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.rootView = constraintLayout;
        this.headerContainer = constraintLayout2;
        this.ivBenefitIcon = imageView;
        this.learnMoreText = textView;
        this.tvBenefitContent = textView2;
        this.tvBenefitHeader = textView3;
        this.tvOnBoardingContentHeader = textView4;
    }

    @NonNull
    public static ItemTproProductBinding bind(@NonNull View view) {
        int i11 = R.id.header_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i11);
        if (constraintLayout != null) {
            i11 = R.id.iv_benefit_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView != null) {
                i11 = R.id.learn_more_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView != null) {
                    i11 = R.id.tv_benefit_content;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView2 != null) {
                        i11 = R.id.tv_benefit_header;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView3 != null) {
                            i11 = R.id.tv_on_boarding_content_header;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i11);
                            if (textView4 != null) {
                                return new ItemTproProductBinding((ConstraintLayout) view, constraintLayout, imageView, textView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemTproProductBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemTproProductBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_tpro_product, viewGroup, false);
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
