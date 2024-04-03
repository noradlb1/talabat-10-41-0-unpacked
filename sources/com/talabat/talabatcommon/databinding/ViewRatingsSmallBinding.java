package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.R;

public final class ViewRatingsSmallBinding implements ViewBinding {
    @NonNull
    public final ImageView ratingImage;
    @NonNull
    public final TextView ratingText;
    @NonNull
    public final TextView reviewsAmount;
    @NonNull
    private final View rootView;

    private ViewRatingsSmallBinding(@NonNull View view, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = view;
        this.ratingImage = imageView;
        this.ratingText = textView;
        this.reviewsAmount = textView2;
    }

    @NonNull
    public static ViewRatingsSmallBinding bind(@NonNull View view) {
        int i11 = R.id.ratingImage;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.ratingText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.reviewsAmount;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    return new ViewRatingsSmallBinding(view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewRatingsSmallBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.view_ratings_small, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
