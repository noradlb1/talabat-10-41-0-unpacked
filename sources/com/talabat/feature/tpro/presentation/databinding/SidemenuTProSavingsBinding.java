package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.tpro.presentation.R;
import com.talabat.talabatcommon.views.ShimmerLayout;

public final class SidemenuTProSavingsBinding implements ViewBinding {
    @NonNull
    public final ConstraintLayout cvTproSavingsContainer;
    @NonNull
    public final ImageView ivSavingsAccountBanner;
    @NonNull
    public final LinearLayout llTproSavingsBannerContainer;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final ShimmerLayout sidemenuTProSavingsShimmer;
    @NonNull
    public final TextView tvExpireTime;
    @NonNull
    public final TextView tvReactivate;
    @NonNull
    public final TextView tvSavingsAmount;
    @NonNull
    public final TextView tvSavingsDescription;

    private SidemenuTProSavingsBinding(@NonNull LinearLayout linearLayout, @NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull ShimmerLayout shimmerLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.rootView = linearLayout;
        this.cvTproSavingsContainer = constraintLayout;
        this.ivSavingsAccountBanner = imageView;
        this.llTproSavingsBannerContainer = linearLayout2;
        this.sidemenuTProSavingsShimmer = shimmerLayout;
        this.tvExpireTime = textView;
        this.tvReactivate = textView2;
        this.tvSavingsAmount = textView3;
        this.tvSavingsDescription = textView4;
    }

    @NonNull
    public static SidemenuTProSavingsBinding bind(@NonNull View view) {
        int i11 = R.id.cv_tpro_savings_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i11);
        if (constraintLayout != null) {
            i11 = R.id.iv_savings_account_banner;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                i11 = R.id.sidemenu_t_pro_savings_shimmer;
                ShimmerLayout shimmerLayout = (ShimmerLayout) ViewBindings.findChildViewById(view, i11);
                if (shimmerLayout != null) {
                    i11 = R.id.tv_expire_time;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView != null) {
                        i11 = R.id.tv_reactivate;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView2 != null) {
                            i11 = R.id.tv_savings_amount;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                            if (textView3 != null) {
                                i11 = R.id.tv_savings_description;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i11);
                                if (textView4 != null) {
                                    return new SidemenuTProSavingsBinding(linearLayout, constraintLayout, imageView, linearLayout, shimmerLayout, textView, textView2, textView3, textView4);
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
    public static SidemenuTProSavingsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static SidemenuTProSavingsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.sidemenu_t_pro_savings, viewGroup, false);
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
