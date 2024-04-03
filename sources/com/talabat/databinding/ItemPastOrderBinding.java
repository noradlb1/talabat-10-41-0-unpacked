package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;

public final class ItemPastOrderBinding implements ViewBinding {
    @NonNull
    public final ImageView deliveryTimeIcon;
    @NonNull
    public final TextView deliveryTimeLabel;
    @NonNull
    public final ImageView restaurantImage;
    @NonNull
    public final CardView restaurantImageContainer;
    @NonNull
    public final TextView restaurantName;
    @NonNull
    private final ConstraintLayout rootView;

    private ItemPastOrderBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull CardView cardView, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.deliveryTimeIcon = imageView;
        this.deliveryTimeLabel = textView;
        this.restaurantImage = imageView2;
        this.restaurantImageContainer = cardView;
        this.restaurantName = textView2;
    }

    @NonNull
    public static ItemPastOrderBinding bind(@NonNull View view) {
        int i11 = R.id.deliveryTimeIcon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.deliveryTimeIcon);
        if (imageView != null) {
            i11 = R.id.deliveryTimeLabel;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.deliveryTimeLabel);
            if (textView != null) {
                i11 = R.id.restaurantImage;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.restaurantImage);
                if (imageView2 != null) {
                    i11 = R.id.restaurantImageContainer;
                    CardView cardView = (CardView) ViewBindings.findChildViewById(view, R.id.restaurantImageContainer);
                    if (cardView != null) {
                        i11 = R.id.restaurantName;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.restaurantName);
                        if (textView2 != null) {
                            return new ItemPastOrderBinding((ConstraintLayout) view, imageView, textView, imageView2, cardView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ItemPastOrderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemPastOrderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_past_order, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
