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

public final class ItemSeachDishBinding implements ViewBinding {
    @NonNull
    public final ImageView imageViewItemImage;
    @NonNull
    public final LinearLayout linearLayoutSimilarContainer;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView textViewDishName;
    @NonNull
    public final TextView textViewDishSimilar;
    @NonNull
    public final TextView textViewItemPrice;
    @NonNull
    public final TextView textViewRestaurantName;
    @NonNull
    public final TalabatTextView textViewRestaurantStatus;

    private ItemSeachDishBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull ProgressBar progressBar2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TalabatTextView talabatTextView) {
        this.rootView = linearLayout;
        this.imageViewItemImage = imageView;
        this.linearLayoutSimilarContainer = linearLayout2;
        this.progressBar = progressBar2;
        this.textViewDishName = textView;
        this.textViewDishSimilar = textView2;
        this.textViewItemPrice = textView3;
        this.textViewRestaurantName = textView4;
        this.textViewRestaurantStatus = talabatTextView;
    }

    @NonNull
    public static ItemSeachDishBinding bind(@NonNull View view) {
        int i11 = R.id.imageView_itemImage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView_itemImage);
        if (imageView != null) {
            i11 = R.id.linearLayout_similarContainer;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.linearLayout_similarContainer);
            if (linearLayout != null) {
                i11 = R.id.progressBar;
                ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, R.id.progressBar);
                if (progressBar2 != null) {
                    i11 = R.id.textView_dishName;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.textView_dishName);
                    if (textView != null) {
                        i11 = R.id.textView_dishSimilar;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.textView_dishSimilar);
                        if (textView2 != null) {
                            i11 = R.id.textView_itemPrice;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.textView_itemPrice);
                            if (textView3 != null) {
                                i11 = R.id.textView_restaurantName;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.textView_restaurantName);
                                if (textView4 != null) {
                                    i11 = R.id.textView_restaurantStatus;
                                    TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.textView_restaurantStatus);
                                    if (talabatTextView != null) {
                                        return new ItemSeachDishBinding((LinearLayout) view, imageView, linearLayout, progressBar2, textView, textView2, textView3, textView4, talabatTextView);
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
    public static ItemSeachDishBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemSeachDishBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_seach_dish, viewGroup, false);
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
