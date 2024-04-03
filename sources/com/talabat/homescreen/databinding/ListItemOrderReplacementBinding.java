package com.talabat.homescreen.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.homescreen.R;
import com.talabat.homescreen.widget.AspectRatioCardView;

public final class ListItemOrderReplacementBinding implements ViewBinding {
    @NonNull
    public final ImageView ivOrderTrackingArrowNext;
    @NonNull
    public final ImageView ivOrderTrackingFoodBowl;
    @NonNull
    private final AspectRatioCardView rootView;
    @NonNull
    public final AspectRatioCardView trackingCardContainer;
    @NonNull
    public final TextView tvOrderTrackingEstimatedDelivery;
    @NonNull
    public final TextView tvOrderTrackingEstimatedDeliveryLabel;
    @NonNull
    public final TextView tvOrderTrackingRestaurantName;
    @NonNull
    public final TextView tvOrderTrackingRestaurantNameLabel;

    private ListItemOrderReplacementBinding(@NonNull AspectRatioCardView aspectRatioCardView, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull AspectRatioCardView aspectRatioCardView2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.rootView = aspectRatioCardView;
        this.ivOrderTrackingArrowNext = imageView;
        this.ivOrderTrackingFoodBowl = imageView2;
        this.trackingCardContainer = aspectRatioCardView2;
        this.tvOrderTrackingEstimatedDelivery = textView;
        this.tvOrderTrackingEstimatedDeliveryLabel = textView2;
        this.tvOrderTrackingRestaurantName = textView3;
        this.tvOrderTrackingRestaurantNameLabel = textView4;
    }

    @NonNull
    public static ListItemOrderReplacementBinding bind(@NonNull View view) {
        int i11 = R.id.ivOrderTrackingArrowNext;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.ivOrderTrackingFoodBowl;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView2 != null) {
                AspectRatioCardView aspectRatioCardView = (AspectRatioCardView) view;
                i11 = R.id.tvOrderTrackingEstimatedDelivery;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView != null) {
                    i11 = R.id.tvOrderTrackingEstimatedDeliveryLabel;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView2 != null) {
                        i11 = R.id.tvOrderTrackingRestaurantName;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView3 != null) {
                            i11 = R.id.tvOrderTrackingRestaurantNameLabel;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i11);
                            if (textView4 != null) {
                                return new ListItemOrderReplacementBinding(aspectRatioCardView, imageView, imageView2, aspectRatioCardView, textView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ListItemOrderReplacementBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ListItemOrderReplacementBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.list_item_order_replacement, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public AspectRatioCardView getRoot() {
        return this.rootView;
    }
}
