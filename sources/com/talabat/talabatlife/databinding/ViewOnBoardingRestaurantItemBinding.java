package com.talabat.talabatlife.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.views.TalabatImageView;
import com.talabat.talabatlife.R;

public final class ViewOnBoardingRestaurantItemBinding implements ViewBinding {
    @NonNull
    public final TalabatImageView onBoardingImageView;
    @NonNull
    private final LinearLayout rootView;

    private ViewOnBoardingRestaurantItemBinding(@NonNull LinearLayout linearLayout, @NonNull TalabatImageView talabatImageView) {
        this.rootView = linearLayout;
        this.onBoardingImageView = talabatImageView;
    }

    @NonNull
    public static ViewOnBoardingRestaurantItemBinding bind(@NonNull View view) {
        int i11 = R.id.onBoardingImageView;
        TalabatImageView talabatImageView = (TalabatImageView) ViewBindings.findChildViewById(view, i11);
        if (talabatImageView != null) {
            return new ViewOnBoardingRestaurantItemBinding((LinearLayout) view, talabatImageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewOnBoardingRestaurantItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewOnBoardingRestaurantItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_on_boarding_restaurant_item, viewGroup, false);
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
