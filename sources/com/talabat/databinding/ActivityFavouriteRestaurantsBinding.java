package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;

public final class ActivityFavouriteRestaurantsBinding implements ViewBinding {
    @NonNull
    public final RecyclerView favouriteRestaurantList;
    @NonNull
    public final View loadingShimmer;
    @NonNull
    public final CoordinatorLayout mainContentContainer;
    @NonNull
    public final Toolbar mainToolbar;
    @NonNull
    public final LinearLayout noRestaurantContainer;
    @NonNull
    private final FrameLayout rootView;

    private ActivityFavouriteRestaurantsBinding(@NonNull FrameLayout frameLayout, @NonNull RecyclerView recyclerView, @NonNull View view, @NonNull CoordinatorLayout coordinatorLayout, @NonNull Toolbar toolbar, @NonNull LinearLayout linearLayout) {
        this.rootView = frameLayout;
        this.favouriteRestaurantList = recyclerView;
        this.loadingShimmer = view;
        this.mainContentContainer = coordinatorLayout;
        this.mainToolbar = toolbar;
        this.noRestaurantContainer = linearLayout;
    }

    @NonNull
    public static ActivityFavouriteRestaurantsBinding bind(@NonNull View view) {
        int i11 = R.id.favouriteRestaurantList;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.favouriteRestaurantList);
        if (recyclerView != null) {
            i11 = R.id.loadingShimmer;
            View findChildViewById = ViewBindings.findChildViewById(view, R.id.loadingShimmer);
            if (findChildViewById != null) {
                i11 = R.id.mainContentContainer;
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) ViewBindings.findChildViewById(view, R.id.mainContentContainer);
                if (coordinatorLayout != null) {
                    i11 = R.id.mainToolbar;
                    Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.mainToolbar);
                    if (toolbar != null) {
                        i11 = R.id.noRestaurantContainer;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.noRestaurantContainer);
                        if (linearLayout != null) {
                            return new ActivityFavouriteRestaurantsBinding((FrameLayout) view, recyclerView, findChildViewById, coordinatorLayout, toolbar, linearLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ActivityFavouriteRestaurantsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityFavouriteRestaurantsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_favourite_restaurants, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
