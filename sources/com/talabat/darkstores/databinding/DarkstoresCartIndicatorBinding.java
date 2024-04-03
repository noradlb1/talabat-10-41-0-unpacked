package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;

public final class DarkstoresCartIndicatorBinding implements ViewBinding {
    @NonNull
    public final TextView cartIndicatorCount;
    @NonNull
    public final FrameLayout cartIndicatorCountLayout;
    @NonNull
    public final ImageView cartIndicatorImage;
    @NonNull
    private final View rootView;

    private DarkstoresCartIndicatorBinding(@NonNull View view, @NonNull TextView textView, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView) {
        this.rootView = view;
        this.cartIndicatorCount = textView;
        this.cartIndicatorCountLayout = frameLayout;
        this.cartIndicatorImage = imageView;
    }

    @NonNull
    public static DarkstoresCartIndicatorBinding bind(@NonNull View view) {
        int i11 = R.id.cart_indicator_count;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.cart_indicator_count_layout;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i11);
            if (frameLayout != null) {
                i11 = R.id.cart_indicator_image;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
                if (imageView != null) {
                    return new DarkstoresCartIndicatorBinding(view, textView, frameLayout, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresCartIndicatorBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.darkstores_cart_indicator, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
