package com.talabat.talabatlife.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.talabat.talabatlife.R;

public final class LayoutOnBoardingRestaurantsBinding implements ViewBinding {
    @NonNull
    public final ProgressBar onBoardingRestaurantsProgressBar;
    @NonNull
    public final ViewPager onBoardingRestaurantsViewPager;
    @NonNull
    private final LinearLayout rootView;

    private LayoutOnBoardingRestaurantsBinding(@NonNull LinearLayout linearLayout, @NonNull ProgressBar progressBar, @NonNull ViewPager viewPager) {
        this.rootView = linearLayout;
        this.onBoardingRestaurantsProgressBar = progressBar;
        this.onBoardingRestaurantsViewPager = viewPager;
    }

    @NonNull
    public static LayoutOnBoardingRestaurantsBinding bind(@NonNull View view) {
        int i11 = R.id.onBoardingRestaurantsProgressBar;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i11);
        if (progressBar != null) {
            i11 = R.id.onBoardingRestaurantsViewPager;
            ViewPager viewPager = (ViewPager) ViewBindings.findChildViewById(view, i11);
            if (viewPager != null) {
                return new LayoutOnBoardingRestaurantsBinding((LinearLayout) view, progressBar, viewPager);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static LayoutOnBoardingRestaurantsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LayoutOnBoardingRestaurantsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.layout_on_boarding_restaurants, viewGroup, false);
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
