package com.talabat.talabatlife.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatlife.R;

public final class ViewHolderVendorOfferBinding implements ViewBinding {
    @NonNull
    private final FrameLayout rootView;
    @NonNull
    public final ImageView vendorOfferIconImageView;
    @NonNull
    public final TextView vendorOfferRedemptionCountTextView;
    @NonNull
    public final FrameLayout vendorOfferRootLinearLayout;
    @NonNull
    public final LinearLayout vendorOfferSubTitle;
    @NonNull
    public final TextView vendorOfferTitleTextView;

    private ViewHolderVendorOfferBinding(@NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull FrameLayout frameLayout2, @NonNull LinearLayout linearLayout, @NonNull TextView textView2) {
        this.rootView = frameLayout;
        this.vendorOfferIconImageView = imageView;
        this.vendorOfferRedemptionCountTextView = textView;
        this.vendorOfferRootLinearLayout = frameLayout2;
        this.vendorOfferSubTitle = linearLayout;
        this.vendorOfferTitleTextView = textView2;
    }

    @NonNull
    public static ViewHolderVendorOfferBinding bind(@NonNull View view) {
        int i11 = R.id.vendorOfferIconImageView;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.vendorOfferRedemptionCountTextView;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                FrameLayout frameLayout = (FrameLayout) view;
                i11 = R.id.vendorOfferSubTitle;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                if (linearLayout != null) {
                    i11 = R.id.vendorOfferTitleTextView;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView2 != null) {
                        return new ViewHolderVendorOfferBinding(frameLayout, imageView, textView, frameLayout, linearLayout, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewHolderVendorOfferBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewHolderVendorOfferBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_holder_vendor_offer, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
