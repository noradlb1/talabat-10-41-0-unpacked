package com.talabat.talabatlife.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatlife.R;

public final class LayoutOnBoardingButtonBinding implements ViewBinding {
    @NonNull
    public final LinearLayout onBoardingButtonRootLayout;
    @NonNull
    public final LinearLayout onBoardingDisclaimerLayout;
    @NonNull
    public final TextView onBoardingNextBillingTextTextView;
    @NonNull
    public final TextView onBoardingOldPriceTextView;
    @NonNull
    public final TextView onBoardingPriceTextView;
    @NonNull
    public final LinearLayout onBoardingStartButtonLinearLayout;
    @NonNull
    public final TextView onBoardingStartButtonTextView;
    @NonNull
    public final TextView onBoardingWaitListTextView;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView tLifeTermsAndConditionsLink;

    private LayoutOnBoardingButtonBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout4, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull TextView textView6) {
        this.rootView = linearLayout;
        this.onBoardingButtonRootLayout = linearLayout2;
        this.onBoardingDisclaimerLayout = linearLayout3;
        this.onBoardingNextBillingTextTextView = textView;
        this.onBoardingOldPriceTextView = textView2;
        this.onBoardingPriceTextView = textView3;
        this.onBoardingStartButtonLinearLayout = linearLayout4;
        this.onBoardingStartButtonTextView = textView4;
        this.onBoardingWaitListTextView = textView5;
        this.tLifeTermsAndConditionsLink = textView6;
    }

    @NonNull
    public static LayoutOnBoardingButtonBinding bind(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i11 = R.id.onBoardingDisclaimerLayout;
        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i11);
        if (linearLayout2 != null) {
            i11 = R.id.onBoardingNextBillingTextTextView;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.onBoardingOldPriceTextView;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    i11 = R.id.onBoardingPriceTextView;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView3 != null) {
                        i11 = R.id.onBoardingStartButtonLinearLayout;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                        if (linearLayout3 != null) {
                            i11 = R.id.onBoardingStartButtonTextView;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i11);
                            if (textView4 != null) {
                                i11 = R.id.onBoardingWaitListTextView;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i11);
                                if (textView5 != null) {
                                    i11 = R.id.tLife_terms_and_conditions_link;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i11);
                                    if (textView6 != null) {
                                        return new LayoutOnBoardingButtonBinding(linearLayout, linearLayout, linearLayout2, textView, textView2, textView3, linearLayout3, textView4, textView5, textView6);
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
    public static LayoutOnBoardingButtonBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LayoutOnBoardingButtonBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.layout_on_boarding_button, viewGroup, false);
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
