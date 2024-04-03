package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class ItemInstantSearchRestaurantBinding implements ViewBinding {
    @NonNull
    public final ImageView imageViewRestaurantLogo;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final TextView textViewRestaurantName;
    @NonNull
    public final TalabatTextView textViewRestaurantStatus;

    private ItemInstantSearchRestaurantBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TalabatTextView talabatTextView) {
        this.rootView = relativeLayout;
        this.imageViewRestaurantLogo = imageView;
        this.textViewRestaurantName = textView;
        this.textViewRestaurantStatus = talabatTextView;
    }

    @NonNull
    public static ItemInstantSearchRestaurantBinding bind(@NonNull View view) {
        int i11 = R.id.imageView_restaurantLogo;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView_restaurantLogo);
        if (imageView != null) {
            i11 = R.id.textView_restaurantName;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.textView_restaurantName);
            if (textView != null) {
                i11 = R.id.textView_restaurantStatus;
                TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.textView_restaurantStatus);
                if (talabatTextView != null) {
                    return new ItemInstantSearchRestaurantBinding((RelativeLayout) view, imageView, textView, talabatTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemInstantSearchRestaurantBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemInstantSearchRestaurantBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_instant_search_restaurant, viewGroup, false);
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
