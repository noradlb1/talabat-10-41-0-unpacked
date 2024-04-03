package com.talabat.talabatlife.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatlife.R;

public final class ViewHolderVendorsBinding implements ViewBinding {
    @NonNull
    public final TextView newTag;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView vendorOfferViewListCousinTextView;
    @NonNull
    public final CardView vendorOfferViewListImageRelativeLayout;
    @NonNull
    public final ImageView vendorOfferViewListImageView;
    @NonNull
    public final TextView vendorOfferViewListTitleTextView;
    @NonNull
    public final ImageView vendorOfferViewOutletImageView;
    @NonNull
    public final LinearLayout vendorOfferViewPromoLinerLayout;
    @NonNull
    public final LinearLayout vendorViewDistanceLinearLayout;
    @NonNull
    public final TextView vendorViewDistanceTextView;

    private ViewHolderVendorsBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull CardView cardView, @NonNull ImageView imageView, @NonNull TextView textView3, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull TextView textView4) {
        this.rootView = linearLayout;
        this.newTag = textView;
        this.vendorOfferViewListCousinTextView = textView2;
        this.vendorOfferViewListImageRelativeLayout = cardView;
        this.vendorOfferViewListImageView = imageView;
        this.vendorOfferViewListTitleTextView = textView3;
        this.vendorOfferViewOutletImageView = imageView2;
        this.vendorOfferViewPromoLinerLayout = linearLayout2;
        this.vendorViewDistanceLinearLayout = linearLayout3;
        this.vendorViewDistanceTextView = textView4;
    }

    @NonNull
    public static ViewHolderVendorsBinding bind(@NonNull View view) {
        int i11 = R.id.newTag;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.vendorOfferViewListCousinTextView;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView2 != null) {
                i11 = R.id.vendorOfferViewListImageRelativeLayout;
                CardView cardView = (CardView) ViewBindings.findChildViewById(view, i11);
                if (cardView != null) {
                    i11 = R.id.vendorOfferViewListImageView;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
                    if (imageView != null) {
                        i11 = R.id.vendorOfferViewListTitleTextView;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView3 != null) {
                            i11 = R.id.vendorOfferViewOutletImageView;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i11);
                            if (imageView2 != null) {
                                i11 = R.id.vendorOfferViewPromoLinerLayout;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                                if (linearLayout != null) {
                                    i11 = R.id.vendorViewDistanceLinearLayout;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                                    if (linearLayout2 != null) {
                                        i11 = R.id.vendorViewDistanceTextView;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i11);
                                        if (textView4 != null) {
                                            return new ViewHolderVendorsBinding((LinearLayout) view, textView, textView2, cardView, imageView, textView3, imageView2, linearLayout, linearLayout2, textView4);
                                        }
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
    public static ViewHolderVendorsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewHolderVendorsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_holder_vendors, viewGroup, false);
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
