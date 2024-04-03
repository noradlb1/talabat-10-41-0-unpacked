package com.talabat.talabatlife.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatlife.R;

public final class ViewHolderPaymentOfferBinding implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final ImageView vendorOfferIconImageView;
    @NonNull
    public final LinearLayout vendorOfferRootLinearLayout;
    @NonNull
    public final TextView vendorOfferSubTitleTextView;
    @NonNull
    public final TextView vendorOfferTitleTextView;

    private ViewHolderPaymentOfferBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = linearLayout;
        this.vendorOfferIconImageView = imageView;
        this.vendorOfferRootLinearLayout = linearLayout2;
        this.vendorOfferSubTitleTextView = textView;
        this.vendorOfferTitleTextView = textView2;
    }

    @NonNull
    public static ViewHolderPaymentOfferBinding bind(@NonNull View view) {
        int i11 = R.id.vendorOfferIconImageView;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i11 = R.id.vendorOfferSubTitleTextView;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.vendorOfferTitleTextView;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    return new ViewHolderPaymentOfferBinding(linearLayout, imageView, linearLayout, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewHolderPaymentOfferBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewHolderPaymentOfferBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_holder_payment_offer, viewGroup, false);
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
