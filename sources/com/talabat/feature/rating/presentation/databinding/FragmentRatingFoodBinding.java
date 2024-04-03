package com.talabat.feature.rating.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.rating.presentation.R;
import com.talabat.talabatcommon.views.TalabatStarRating;

public final class FragmentRatingFoodBinding implements ViewBinding {
    @NonNull
    public final ImageView buttonFoodRatingClose;
    @NonNull
    public final ImageView ivVendorIcon;
    @NonNull
    public final TalabatStarRating rbFoodRatings;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView tvVendorExperienceRatingTitle;

    private FragmentRatingFoodBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TalabatStarRating talabatStarRating, @NonNull TextView textView) {
        this.rootView = linearLayout;
        this.buttonFoodRatingClose = imageView;
        this.ivVendorIcon = imageView2;
        this.rbFoodRatings = talabatStarRating;
        this.tvVendorExperienceRatingTitle = textView;
    }

    @NonNull
    public static FragmentRatingFoodBinding bind(@NonNull View view) {
        int i11 = R.id.buttonFoodRatingClose;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.ivVendorIcon;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView2 != null) {
                i11 = R.id.rbFoodRatings;
                TalabatStarRating talabatStarRating = (TalabatStarRating) ViewBindings.findChildViewById(view, i11);
                if (talabatStarRating != null) {
                    i11 = R.id.tvVendorExperienceRatingTitle;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView != null) {
                        return new FragmentRatingFoodBinding((LinearLayout) view, imageView, imageView2, talabatStarRating, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragmentRatingFoodBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentRatingFoodBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_rating_food, viewGroup, false);
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
