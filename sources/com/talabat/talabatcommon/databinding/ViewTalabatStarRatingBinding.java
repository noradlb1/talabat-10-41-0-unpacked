package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.R;

public final class ViewTalabatStarRatingBinding implements ViewBinding {
    @NonNull
    private final View rootView;
    @NonNull
    public final ImageView star1;
    @NonNull
    public final ImageView star2;
    @NonNull
    public final ImageView star3;
    @NonNull
    public final ImageView star4;
    @NonNull
    public final ImageView star5;

    private ViewTalabatStarRatingBinding(@NonNull View view, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ImageView imageView5) {
        this.rootView = view;
        this.star1 = imageView;
        this.star2 = imageView2;
        this.star3 = imageView3;
        this.star4 = imageView4;
        this.star5 = imageView5;
    }

    @NonNull
    public static ViewTalabatStarRatingBinding bind(@NonNull View view) {
        int i11 = R.id.star_1;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.star_2;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView2 != null) {
                i11 = R.id.star_3;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i11);
                if (imageView3 != null) {
                    i11 = R.id.star_4;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i11);
                    if (imageView4 != null) {
                        i11 = R.id.star_5;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i11);
                        if (imageView5 != null) {
                            return new ViewTalabatStarRatingBinding(view, imageView, imageView2, imageView3, imageView4, imageView5);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewTalabatStarRatingBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.view_talabat_star_rating, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
