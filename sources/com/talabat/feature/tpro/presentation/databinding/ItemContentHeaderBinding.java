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

public final class ItemContentHeaderBinding implements ViewBinding {
    @NonNull
    public final ConstraintLayout headerContainer;
    @NonNull
    public final ImageView ivBenefitsTproLogo;
    @NonNull
    public final ImageView ivClose;
    @NonNull
    public final ImageView ivPoster;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView tvOnBoardingHeader;
    @NonNull
    public final TextView tvOnBoardingSubheader;

    private ItemContentHeaderBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.headerContainer = constraintLayout2;
        this.ivBenefitsTproLogo = imageView;
        this.ivClose = imageView2;
        this.ivPoster = imageView3;
        this.tvOnBoardingHeader = textView;
        this.tvOnBoardingSubheader = textView2;
    }

    @NonNull
    public static ItemContentHeaderBinding bind(@NonNull View view) {
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
                        i11 = R.id.tv_on_boarding_header;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView != null) {
                            i11 = R.id.tv_on_boarding_subheader;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                            if (textView2 != null) {
                                return new ItemContentHeaderBinding((ConstraintLayout) view, constraintLayout, imageView, imageView2, imageView3, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemContentHeaderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemContentHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_content_header, viewGroup, false);
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
