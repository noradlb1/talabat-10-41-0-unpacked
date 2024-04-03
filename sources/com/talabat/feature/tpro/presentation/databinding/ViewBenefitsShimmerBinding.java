package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.tpro.presentation.R;
import com.talabat.talabatcommon.views.ShimmerLayout;

public final class ViewBenefitsShimmerBinding implements ViewBinding {
    @NonNull
    public final ShimmerLayout action;
    @NonNull
    public final ShimmerLayout header;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final ShimmerLayout subText1;
    @NonNull
    public final ShimmerLayout subText2;
    @NonNull
    public final ShimmerLayout text1;
    @NonNull
    public final ShimmerLayout text2;
    @NonNull
    public final ShimmerLayout text3;

    private ViewBenefitsShimmerBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ShimmerLayout shimmerLayout, @NonNull ShimmerLayout shimmerLayout2, @NonNull ShimmerLayout shimmerLayout3, @NonNull ShimmerLayout shimmerLayout4, @NonNull ShimmerLayout shimmerLayout5, @NonNull ShimmerLayout shimmerLayout6, @NonNull ShimmerLayout shimmerLayout7) {
        this.rootView = constraintLayout;
        this.action = shimmerLayout;
        this.header = shimmerLayout2;
        this.subText1 = shimmerLayout3;
        this.subText2 = shimmerLayout4;
        this.text1 = shimmerLayout5;
        this.text2 = shimmerLayout6;
        this.text3 = shimmerLayout7;
    }

    @NonNull
    public static ViewBenefitsShimmerBinding bind(@NonNull View view) {
        int i11 = R.id.action;
        ShimmerLayout shimmerLayout = (ShimmerLayout) ViewBindings.findChildViewById(view, i11);
        if (shimmerLayout != null) {
            i11 = R.id.header;
            ShimmerLayout shimmerLayout2 = (ShimmerLayout) ViewBindings.findChildViewById(view, i11);
            if (shimmerLayout2 != null) {
                i11 = R.id.subText1;
                ShimmerLayout shimmerLayout3 = (ShimmerLayout) ViewBindings.findChildViewById(view, i11);
                if (shimmerLayout3 != null) {
                    i11 = R.id.subText2;
                    ShimmerLayout shimmerLayout4 = (ShimmerLayout) ViewBindings.findChildViewById(view, i11);
                    if (shimmerLayout4 != null) {
                        i11 = R.id.text1;
                        ShimmerLayout shimmerLayout5 = (ShimmerLayout) ViewBindings.findChildViewById(view, i11);
                        if (shimmerLayout5 != null) {
                            i11 = R.id.text2;
                            ShimmerLayout shimmerLayout6 = (ShimmerLayout) ViewBindings.findChildViewById(view, i11);
                            if (shimmerLayout6 != null) {
                                i11 = R.id.text3;
                                ShimmerLayout shimmerLayout7 = (ShimmerLayout) ViewBindings.findChildViewById(view, i11);
                                if (shimmerLayout7 != null) {
                                    return new ViewBenefitsShimmerBinding((ConstraintLayout) view, shimmerLayout, shimmerLayout2, shimmerLayout3, shimmerLayout4, shimmerLayout5, shimmerLayout6, shimmerLayout7);
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
    public static ViewBenefitsShimmerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewBenefitsShimmerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_benefits_shimmer, viewGroup, false);
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
