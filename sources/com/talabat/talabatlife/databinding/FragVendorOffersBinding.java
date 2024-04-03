package com.talabat.talabatlife.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.talabat.talabatlife.R;

public final class FragVendorOffersBinding implements ViewBinding {
    @NonNull
    public final Toolbar animToolbar;
    @NonNull
    public final AppBarLayout appBarLayout;
    @NonNull
    public final CollapsingToolbarLayout collapsingToolbar;
    @NonNull
    public final TextView infoDineInOffer;
    @NonNull
    private final CoordinatorLayout rootView;
    @NonNull
    public final ImageView tLifeVendorOfferQRCodeImageView;
    @NonNull
    public final TextView tLifeVendorOfferQRCodeText;
    @NonNull
    public final LinearLayout tLifeVendorOfferRedeemButton;
    @NonNull
    public final LinearLayout tLifeVendorOfferRedeemLayout;
    @NonNull
    public final NestedScrollView tLifeVendorOffersScrollView;
    @NonNull
    public final ImageButton vendorOffersBackButton;
    @NonNull
    public final ImageView vendorOffersImageView;

    private FragVendorOffersBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Toolbar toolbar, @NonNull AppBarLayout appBarLayout2, @NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull NestedScrollView nestedScrollView, @NonNull ImageButton imageButton, @NonNull ImageView imageView2) {
        this.rootView = coordinatorLayout;
        this.animToolbar = toolbar;
        this.appBarLayout = appBarLayout2;
        this.collapsingToolbar = collapsingToolbarLayout;
        this.infoDineInOffer = textView;
        this.tLifeVendorOfferQRCodeImageView = imageView;
        this.tLifeVendorOfferQRCodeText = textView2;
        this.tLifeVendorOfferRedeemButton = linearLayout;
        this.tLifeVendorOfferRedeemLayout = linearLayout2;
        this.tLifeVendorOffersScrollView = nestedScrollView;
        this.vendorOffersBackButton = imageButton;
        this.vendorOffersImageView = imageView2;
    }

    @NonNull
    public static FragVendorOffersBinding bind(@NonNull View view) {
        int i11 = R.id.anim_toolbar;
        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, i11);
        if (toolbar != null) {
            i11 = R.id.app_bar_layout;
            AppBarLayout appBarLayout2 = (AppBarLayout) ViewBindings.findChildViewById(view, i11);
            if (appBarLayout2 != null) {
                i11 = R.id.collapsing_toolbar;
                CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) ViewBindings.findChildViewById(view, i11);
                if (collapsingToolbarLayout != null) {
                    i11 = R.id.infoDineInOffer;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView != null) {
                        i11 = R.id.tLifeVendorOfferQRCodeImageView;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
                        if (imageView != null) {
                            i11 = R.id.tLifeVendorOfferQRCodeText;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                            if (textView2 != null) {
                                i11 = R.id.tLifeVendorOfferRedeemButton;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                                if (linearLayout != null) {
                                    i11 = R.id.tLifeVendorOfferRedeemLayout;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                                    if (linearLayout2 != null) {
                                        i11 = R.id.tLifeVendorOffersScrollView;
                                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i11);
                                        if (nestedScrollView != null) {
                                            i11 = R.id.vendorOffersBackButton;
                                            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i11);
                                            if (imageButton != null) {
                                                i11 = R.id.vendorOffersImageView;
                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i11);
                                                if (imageView2 != null) {
                                                    return new FragVendorOffersBinding((CoordinatorLayout) view, toolbar, appBarLayout2, collapsingToolbarLayout, textView, imageView, textView2, linearLayout, linearLayout2, nestedScrollView, imageButton, imageView2);
                                                }
                                            }
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
    public static FragVendorOffersBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragVendorOffersBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.frag_vendor_offers, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }
}
