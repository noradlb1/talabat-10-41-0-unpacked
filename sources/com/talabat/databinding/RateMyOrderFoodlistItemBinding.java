package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.helpers.BaseRatingBar;

public final class RateMyOrderFoodlistItemBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView foodItem;
    @NonNull
    public final BaseRatingBar foodItemRating;
    @NonNull
    private final LinearLayout rootView;

    private RateMyOrderFoodlistItemBinding(@NonNull LinearLayout linearLayout, @NonNull TalabatTextView talabatTextView, @NonNull BaseRatingBar baseRatingBar) {
        this.rootView = linearLayout;
        this.foodItem = talabatTextView;
        this.foodItemRating = baseRatingBar;
    }

    @NonNull
    public static RateMyOrderFoodlistItemBinding bind(@NonNull View view) {
        int i11 = R.id.food_item;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.food_item);
        if (talabatTextView != null) {
            i11 = R.id.food_item_rating;
            BaseRatingBar baseRatingBar = (BaseRatingBar) ViewBindings.findChildViewById(view, R.id.food_item_rating);
            if (baseRatingBar != null) {
                return new RateMyOrderFoodlistItemBinding((LinearLayout) view, talabatTextView, baseRatingBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static RateMyOrderFoodlistItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static RateMyOrderFoodlistItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.rate_my_order_foodlist_item, viewGroup, false);
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
