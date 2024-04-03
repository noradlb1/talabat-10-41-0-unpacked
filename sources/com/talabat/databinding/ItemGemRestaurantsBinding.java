package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class ItemGemRestaurantsBinding implements ViewBinding {
    @NonNull
    public final TextView imageViewNewTag;
    @NonNull
    public final ImageView imageViewRestaurantLogo;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView textViewAverageDeliveryTime;
    @NonNull
    public final TextView textViewCuisines;
    @NonNull
    public final TalabatTextView textViewDeliveryCost;
    @NonNull
    public final TextView vendorName;
    @NonNull
    public final ImageView vendorRateAvatar;
    @NonNull
    public final TextView vendorRateStatus;

    private ItemGemRestaurantsBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull ProgressBar progressBar2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TalabatTextView talabatTextView, @NonNull TextView textView4, @NonNull ImageView imageView2, @NonNull TextView textView5) {
        this.rootView = linearLayout;
        this.imageViewNewTag = textView;
        this.imageViewRestaurantLogo = imageView;
        this.progressBar = progressBar2;
        this.textViewAverageDeliveryTime = textView2;
        this.textViewCuisines = textView3;
        this.textViewDeliveryCost = talabatTextView;
        this.vendorName = textView4;
        this.vendorRateAvatar = imageView2;
        this.vendorRateStatus = textView5;
    }

    @NonNull
    public static ItemGemRestaurantsBinding bind(@NonNull View view) {
        int i11 = R.id.imageView_newTag;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.imageView_newTag);
        if (textView != null) {
            i11 = R.id.imageView_restaurantLogo;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView_restaurantLogo);
            if (imageView != null) {
                i11 = R.id.progressBar;
                ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, R.id.progressBar);
                if (progressBar2 != null) {
                    i11 = R.id.textView_averageDeliveryTime;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.textView_averageDeliveryTime);
                    if (textView2 != null) {
                        i11 = R.id.textView_cuisines;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.textView_cuisines);
                        if (textView3 != null) {
                            i11 = R.id.textView_deliveryCost;
                            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.textView_deliveryCost);
                            if (talabatTextView != null) {
                                i11 = R.id.vendorName;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.vendorName);
                                if (textView4 != null) {
                                    i11 = R.id.vendorRateAvatar;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.vendorRateAvatar);
                                    if (imageView2 != null) {
                                        i11 = R.id.vendorRateStatus;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.vendorRateStatus);
                                        if (textView5 != null) {
                                            return new ItemGemRestaurantsBinding((LinearLayout) view, textView, imageView, progressBar2, textView2, textView3, talabatTextView, textView4, imageView2, textView5);
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
    public static ItemGemRestaurantsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemGemRestaurantsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_gem_restaurants, viewGroup, false);
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
