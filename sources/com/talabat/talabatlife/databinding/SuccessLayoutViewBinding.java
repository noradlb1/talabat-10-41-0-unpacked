package com.talabat.talabatlife.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.talabat.talabatlife.R;

public final class SuccessLayoutViewBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout redeemConformationAnimationRelativeLayout;
    @NonNull
    public final LottieAnimationView redeemConformationDone;
    @NonNull
    public final LottieAnimationView redeemConformationParty;
    @NonNull
    private final RelativeLayout rootView;

    private SuccessLayoutViewBinding(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull LottieAnimationView lottieAnimationView, @NonNull LottieAnimationView lottieAnimationView2) {
        this.rootView = relativeLayout;
        this.redeemConformationAnimationRelativeLayout = relativeLayout2;
        this.redeemConformationDone = lottieAnimationView;
        this.redeemConformationParty = lottieAnimationView2;
    }

    @NonNull
    public static SuccessLayoutViewBinding bind(@NonNull View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i11 = R.id.redeemConformationDone;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i11);
        if (lottieAnimationView != null) {
            i11 = R.id.redeemConformationParty;
            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) ViewBindings.findChildViewById(view, i11);
            if (lottieAnimationView2 != null) {
                return new SuccessLayoutViewBinding(relativeLayout, relativeLayout, lottieAnimationView, lottieAnimationView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static SuccessLayoutViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static SuccessLayoutViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.success_layout_view, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
