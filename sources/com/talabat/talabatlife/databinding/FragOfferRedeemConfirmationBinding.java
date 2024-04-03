package com.talabat.talabatlife.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.talabat.talabatlife.R;

public final class FragOfferRedeemConfirmationBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout redeemConformationAnimationRelativeLayout;
    @NonNull
    public final TextView redeemConformationCongrats;
    @NonNull
    public final TextView redeemConformationCongratsMessage;
    @NonNull
    public final Button redeemConformationDiscoverMoreButton;
    @NonNull
    public final LottieAnimationView redeemConformationDone;
    @NonNull
    public final LottieAnimationView redeemConformationParty;
    @NonNull
    public final TextView redeemConformationTitle;
    @NonNull
    private final ConstraintLayout rootView;

    private FragOfferRedeemConfirmationBinding(@NonNull ConstraintLayout constraintLayout, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull Button button, @NonNull LottieAnimationView lottieAnimationView, @NonNull LottieAnimationView lottieAnimationView2, @NonNull TextView textView3) {
        this.rootView = constraintLayout;
        this.redeemConformationAnimationRelativeLayout = relativeLayout;
        this.redeemConformationCongrats = textView;
        this.redeemConformationCongratsMessage = textView2;
        this.redeemConformationDiscoverMoreButton = button;
        this.redeemConformationDone = lottieAnimationView;
        this.redeemConformationParty = lottieAnimationView2;
        this.redeemConformationTitle = textView3;
    }

    @NonNull
    public static FragOfferRedeemConfirmationBinding bind(@NonNull View view) {
        int i11 = R.id.redeemConformationAnimationRelativeLayout;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i11);
        if (relativeLayout != null) {
            i11 = R.id.redeemConformationCongrats;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.redeemConformationCongratsMessage;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    i11 = R.id.redeemConformationDiscoverMoreButton;
                    Button button = (Button) ViewBindings.findChildViewById(view, i11);
                    if (button != null) {
                        i11 = R.id.redeemConformationDone;
                        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i11);
                        if (lottieAnimationView != null) {
                            i11 = R.id.redeemConformationParty;
                            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) ViewBindings.findChildViewById(view, i11);
                            if (lottieAnimationView2 != null) {
                                i11 = R.id.redeemConformationTitle;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                                if (textView3 != null) {
                                    return new FragOfferRedeemConfirmationBinding((ConstraintLayout) view, relativeLayout, textView, textView2, button, lottieAnimationView, lottieAnimationView2, textView3);
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
    public static FragOfferRedeemConfirmationBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragOfferRedeemConfirmationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.frag_offer_redeem_confirmation, viewGroup, false);
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
