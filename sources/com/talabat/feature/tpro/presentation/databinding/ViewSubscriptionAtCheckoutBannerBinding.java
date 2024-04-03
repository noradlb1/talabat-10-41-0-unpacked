package com.talabat.feature.tpro.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.tpro.presentation.R;

public final class ViewSubscriptionAtCheckoutBannerBinding implements ViewBinding {
    @NonNull
    public final ImageView proIcon;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final RelativeLayout subscriptionAtCheckoutBannerLayout;
    @NonNull
    public final TextView subscriptionDetailText;
    @NonNull
    public final AppCompatCheckBox subscriptionOnCheckoutSelector;
    @NonNull
    public final TextView subscriptionPaymentText;
    @NonNull
    public final TextView termsAndConditionsLinkClickable;

    private ViewSubscriptionAtCheckoutBannerBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView, @NonNull AppCompatCheckBox appCompatCheckBox, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = relativeLayout;
        this.proIcon = imageView;
        this.subscriptionAtCheckoutBannerLayout = relativeLayout2;
        this.subscriptionDetailText = textView;
        this.subscriptionOnCheckoutSelector = appCompatCheckBox;
        this.subscriptionPaymentText = textView2;
        this.termsAndConditionsLinkClickable = textView3;
    }

    @NonNull
    public static ViewSubscriptionAtCheckoutBannerBinding bind(@NonNull View view) {
        int i11 = R.id.pro_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            i11 = R.id.subscription_detail_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.subscription_on_checkout_selector;
                AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) ViewBindings.findChildViewById(view, i11);
                if (appCompatCheckBox != null) {
                    i11 = R.id.subscription_payment_text;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView2 != null) {
                        i11 = R.id.terms_and_conditions_link_clickable;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView3 != null) {
                            return new ViewSubscriptionAtCheckoutBannerBinding(relativeLayout, imageView, relativeLayout, textView, appCompatCheckBox, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewSubscriptionAtCheckoutBannerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewSubscriptionAtCheckoutBannerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_subscription_at_checkout_banner, viewGroup, false);
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
