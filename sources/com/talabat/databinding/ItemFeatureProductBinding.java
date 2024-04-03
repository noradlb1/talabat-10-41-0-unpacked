package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;

public final class ItemFeatureProductBinding implements ViewBinding {
    @NonNull
    public final ImageView deliveryBike;
    @NonNull
    public final TextView deliveryTime;
    @NonNull
    public final ImageView itemImage;
    @NonNull
    public final TextView itemName;
    @NonNull
    public final TextView itemOldPrice;
    @NonNull
    public final TextView itemPrice;
    @NonNull
    public final LinearLayout priceContainer;
    @NonNull
    public final TextView priceOnSelection;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView vendorName;

    private ItemFeatureProductBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull LinearLayout linearLayout, @NonNull TextView textView5, @NonNull TextView textView6) {
        this.rootView = constraintLayout;
        this.deliveryBike = imageView;
        this.deliveryTime = textView;
        this.itemImage = imageView2;
        this.itemName = textView2;
        this.itemOldPrice = textView3;
        this.itemPrice = textView4;
        this.priceContainer = linearLayout;
        this.priceOnSelection = textView5;
        this.vendorName = textView6;
    }

    @NonNull
    public static ItemFeatureProductBinding bind(@NonNull View view) {
        int i11 = R.id.deliveryBike;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.deliveryBike);
        if (imageView != null) {
            i11 = R.id.deliveryTime;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.deliveryTime);
            if (textView != null) {
                i11 = R.id.itemImage;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.itemImage);
                if (imageView2 != null) {
                    i11 = R.id.itemName;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.itemName);
                    if (textView2 != null) {
                        i11 = R.id.itemOldPrice;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.itemOldPrice);
                        if (textView3 != null) {
                            i11 = R.id.itemPrice;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.itemPrice);
                            if (textView4 != null) {
                                i11 = R.id.priceContainer;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.priceContainer);
                                if (linearLayout != null) {
                                    i11 = R.id.priceOnSelection;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.priceOnSelection);
                                    if (textView5 != null) {
                                        i11 = R.id.vendorName;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.vendorName);
                                        if (textView6 != null) {
                                            return new ItemFeatureProductBinding((ConstraintLayout) view, imageView, textView, imageView2, textView2, textView3, textView4, linearLayout, textView5, textView6);
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
    public static ItemFeatureProductBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ItemFeatureProductBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.item_feature_product, viewGroup, false);
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
