package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.volley.toolbox.NetworkImageView;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class OffersListScreenItemBinding implements ViewBinding {
    @NonNull
    public final CardView convertView;
    @NonNull
    public final TalabatTextView offerScreenOfferName;
    @NonNull
    public final NetworkImageView offerScreenRestImage;
    @NonNull
    public final RelativeLayout offerScreenRestImageView;
    @NonNull
    public final TalabatTextView offerScreenRestaurantName;
    @NonNull
    public final TalabatTextView offersScreenDescription;
    @NonNull
    public final TalabatTextView offersScreenPrice;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    private final CardView rootView;

    private OffersListScreenItemBinding(@NonNull CardView cardView, @NonNull CardView cardView2, @NonNull TalabatTextView talabatTextView, @NonNull NetworkImageView networkImageView, @NonNull RelativeLayout relativeLayout, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatTextView talabatTextView4, @NonNull ProgressBar progressBar2) {
        this.rootView = cardView;
        this.convertView = cardView2;
        this.offerScreenOfferName = talabatTextView;
        this.offerScreenRestImage = networkImageView;
        this.offerScreenRestImageView = relativeLayout;
        this.offerScreenRestaurantName = talabatTextView2;
        this.offersScreenDescription = talabatTextView3;
        this.offersScreenPrice = talabatTextView4;
        this.progressBar = progressBar2;
    }

    @NonNull
    public static OffersListScreenItemBinding bind(@NonNull View view) {
        CardView cardView = (CardView) view;
        int i11 = R.id.offer_screen_offer_name;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.offer_screen_offer_name);
        if (talabatTextView != null) {
            i11 = R.id.offer_screen_rest_image;
            NetworkImageView networkImageView = (NetworkImageView) ViewBindings.findChildViewById(view, R.id.offer_screen_rest_image);
            if (networkImageView != null) {
                i11 = R.id.offer_screen_rest_image_view;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.offer_screen_rest_image_view);
                if (relativeLayout != null) {
                    i11 = R.id.offer_screen_restaurant_name;
                    TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.offer_screen_restaurant_name);
                    if (talabatTextView2 != null) {
                        i11 = R.id.offers_screen_description;
                        TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.offers_screen_description);
                        if (talabatTextView3 != null) {
                            i11 = R.id.offers_screen_price;
                            TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.offers_screen_price);
                            if (talabatTextView4 != null) {
                                i11 = R.id.progressBar;
                                ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, R.id.progressBar);
                                if (progressBar2 != null) {
                                    return new OffersListScreenItemBinding(cardView, cardView, talabatTextView, networkImageView, relativeLayout, talabatTextView2, talabatTextView3, talabatTextView4, progressBar2);
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
    public static OffersListScreenItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static OffersListScreenItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.offers_list_screen_item, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public CardView getRoot() {
        return this.rootView;
    }
}
