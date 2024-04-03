package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class RestaurantlistItemBinding implements ViewBinding {
    @NonNull
    public final CardView convertView;
    @NonNull
    public final TalabatTextView delFees;
    @NonNull
    public final TalabatTextView delFeesProperty;
    @NonNull
    public final TalabatTextView delTime;
    @NonNull
    public final TalabatTextView isNewRestaurant;
    @NonNull
    public final TalabatTextView minOrderamt;
    @NonNull
    public final ImageView offers;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    public final TalabatTextView ratingCount;
    @NonNull
    public final RatingBar ratingbar;
    @NonNull
    public final RelativeLayout restListBgLayout;
    @NonNull
    public final ImageView restLogo;
    @NonNull
    public final LinearLayout restLogoView;
    @NonNull
    public final TalabatTextView restName;
    @NonNull
    public final TalabatTextView restaurantSponsered;
    @NonNull
    private final CardView rootView;
    @NonNull
    public final TalabatTextView statusText;

    private RestaurantlistItemBinding(@NonNull CardView cardView, @NonNull CardView cardView2, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatTextView talabatTextView4, @NonNull TalabatTextView talabatTextView5, @NonNull ImageView imageView, @NonNull ProgressBar progressBar2, @NonNull TalabatTextView talabatTextView6, @NonNull RatingBar ratingBar, @NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout, @NonNull TalabatTextView talabatTextView7, @NonNull TalabatTextView talabatTextView8, @NonNull TalabatTextView talabatTextView9) {
        this.rootView = cardView;
        this.convertView = cardView2;
        this.delFees = talabatTextView;
        this.delFeesProperty = talabatTextView2;
        this.delTime = talabatTextView3;
        this.isNewRestaurant = talabatTextView4;
        this.minOrderamt = talabatTextView5;
        this.offers = imageView;
        this.progressBar = progressBar2;
        this.ratingCount = talabatTextView6;
        this.ratingbar = ratingBar;
        this.restListBgLayout = relativeLayout;
        this.restLogo = imageView2;
        this.restLogoView = linearLayout;
        this.restName = talabatTextView7;
        this.restaurantSponsered = talabatTextView8;
        this.statusText = talabatTextView9;
    }

    @NonNull
    public static RestaurantlistItemBinding bind(@NonNull View view) {
        View view2 = view;
        CardView cardView = (CardView) view2;
        int i11 = R.id.del_fees;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.del_fees);
        if (talabatTextView != null) {
            i11 = R.id.del_fees_property;
            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.del_fees_property);
            if (talabatTextView2 != null) {
                i11 = R.id.del_time;
                TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.del_time);
                if (talabatTextView3 != null) {
                    i11 = R.id.is_new_restaurant;
                    TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.is_new_restaurant);
                    if (talabatTextView4 != null) {
                        i11 = R.id.min_orderamt;
                        TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.min_orderamt);
                        if (talabatTextView5 != null) {
                            i11 = R.id.offers;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.offers);
                            if (imageView != null) {
                                i11 = R.id.progressBar;
                                ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.progressBar);
                                if (progressBar2 != null) {
                                    i11 = R.id.rating_count;
                                    TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.rating_count);
                                    if (talabatTextView6 != null) {
                                        i11 = R.id.ratingbar;
                                        RatingBar ratingBar = (RatingBar) ViewBindings.findChildViewById(view2, R.id.ratingbar);
                                        if (ratingBar != null) {
                                            i11 = R.id.rest_list_bg_layout;
                                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rest_list_bg_layout);
                                            if (relativeLayout != null) {
                                                i11 = R.id.rest_logo;
                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.rest_logo);
                                                if (imageView2 != null) {
                                                    i11 = R.id.rest_logo_view;
                                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.rest_logo_view);
                                                    if (linearLayout != null) {
                                                        i11 = R.id.rest_name;
                                                        TalabatTextView talabatTextView7 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.rest_name);
                                                        if (talabatTextView7 != null) {
                                                            i11 = R.id.restaurant_sponsered;
                                                            TalabatTextView talabatTextView8 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.restaurant_sponsered);
                                                            if (talabatTextView8 != null) {
                                                                i11 = R.id.status_text;
                                                                TalabatTextView talabatTextView9 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.status_text);
                                                                if (talabatTextView9 != null) {
                                                                    return new RestaurantlistItemBinding(cardView, cardView, talabatTextView, talabatTextView2, talabatTextView3, talabatTextView4, talabatTextView5, imageView, progressBar2, talabatTextView6, ratingBar, relativeLayout, imageView2, linearLayout, talabatTextView7, talabatTextView8, talabatTextView9);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static RestaurantlistItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static RestaurantlistItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.restaurantlist_item, viewGroup, false);
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
