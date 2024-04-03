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

public final class ViewVendorListPromoBinding implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final ImageView vendorOfferViewPromoSeparator;
    @NonNull
    public final TextView vendorOfferViewPromoTextView;

    private ViewVendorListPromoBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.rootView = linearLayout;
        this.vendorOfferViewPromoSeparator = imageView;
        this.vendorOfferViewPromoTextView = textView;
    }

    @NonNull
    public static ViewVendorListPromoBinding bind(@NonNull View view) {
        int i11 = R.id.vendorOfferViewPromoSeparator;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.vendorOfferViewPromoTextView;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                return new ViewVendorListPromoBinding((LinearLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewVendorListPromoBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewVendorListPromoBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_vendor_list_promo, viewGroup, false);
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
