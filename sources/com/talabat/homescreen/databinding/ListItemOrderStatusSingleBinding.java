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
import com.google.android.material.card.MaterialCardView;
import com.talabat.homescreen.R;

public final class ListItemOrderStatusSingleBinding implements ViewBinding {
    @NonNull
    public final ImageView imgRight;
    @NonNull
    public final MaterialCardView itemContainer;
    @NonNull
    private final MaterialCardView rootView;
    @NonNull
    public final TextView txtRestaurantName;
    @NonNull
    public final TextView txtStatus;

    private ListItemOrderStatusSingleBinding(@NonNull MaterialCardView materialCardView, @NonNull ImageView imageView, @NonNull MaterialCardView materialCardView2, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = materialCardView;
        this.imgRight = imageView;
        this.itemContainer = materialCardView2;
        this.txtRestaurantName = textView;
        this.txtStatus = textView2;
    }

    @NonNull
    public static ListItemOrderStatusSingleBinding bind(@NonNull View view) {
        int i11 = R.id.imgRight;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            MaterialCardView materialCardView = (MaterialCardView) view;
            i11 = R.id.txtRestaurantName;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.txtStatus;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    return new ListItemOrderStatusSingleBinding(materialCardView, imageView, materialCardView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ListItemOrderStatusSingleBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ListItemOrderStatusSingleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.list_item_order_status_single, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public MaterialCardView getRoot() {
        return this.rootView;
    }
}
