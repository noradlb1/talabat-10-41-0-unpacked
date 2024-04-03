package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.talabat.R;
import com.talabat.homescreen.databinding.FluidHomeLoadingBinding;
import com.talabat.homescreen.widget.HomeScreenHeaderView;

public final class ActivityHomeScreenBinding implements ViewBinding {
    @NonNull
    public final LinearLayout bottomNavContainer;
    @NonNull
    public final HomeScreenHeaderView headerView;
    @NonNull
    public final BottomNavigationView homeNav;
    @NonNull
    public final FrameLayout homeScreenContainer;
    @NonNull
    public final CardView homeToolbar;
    @NonNull
    public final FluidHomeLoadingBinding loadingLayout;
    @NonNull
    public final FragmentContainerView navHostFragment;
    @NonNull
    private final RelativeLayout rootView;

    private ActivityHomeScreenBinding(@NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout, @NonNull HomeScreenHeaderView homeScreenHeaderView, @NonNull BottomNavigationView bottomNavigationView, @NonNull FrameLayout frameLayout, @NonNull CardView cardView, @NonNull FluidHomeLoadingBinding fluidHomeLoadingBinding, @NonNull FragmentContainerView fragmentContainerView) {
        this.rootView = relativeLayout;
        this.bottomNavContainer = linearLayout;
        this.headerView = homeScreenHeaderView;
        this.homeNav = bottomNavigationView;
        this.homeScreenContainer = frameLayout;
        this.homeToolbar = cardView;
        this.loadingLayout = fluidHomeLoadingBinding;
        this.navHostFragment = fragmentContainerView;
    }

    @NonNull
    public static ActivityHomeScreenBinding bind(@NonNull View view) {
        int i11 = R.id.bottomNavContainer;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.bottomNavContainer);
        if (linearLayout != null) {
            i11 = R.id.header_view;
            HomeScreenHeaderView homeScreenHeaderView = (HomeScreenHeaderView) ViewBindings.findChildViewById(view, R.id.header_view);
            if (homeScreenHeaderView != null) {
                i11 = R.id.home_nav;
                BottomNavigationView bottomNavigationView = (BottomNavigationView) ViewBindings.findChildViewById(view, R.id.home_nav);
                if (bottomNavigationView != null) {
                    i11 = R.id.homeScreenContainer;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.homeScreenContainer);
                    if (frameLayout != null) {
                        i11 = R.id.homeToolbar;
                        CardView cardView = (CardView) ViewBindings.findChildViewById(view, R.id.homeToolbar);
                        if (cardView != null) {
                            i11 = R.id.loadingLayout;
                            View findChildViewById = ViewBindings.findChildViewById(view, R.id.loadingLayout);
                            if (findChildViewById != null) {
                                FluidHomeLoadingBinding bind = FluidHomeLoadingBinding.bind(findChildViewById);
                                i11 = R.id.navHostFragment;
                                FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.findChildViewById(view, R.id.navHostFragment);
                                if (fragmentContainerView != null) {
                                    return new ActivityHomeScreenBinding((RelativeLayout) view, linearLayout, homeScreenHeaderView, bottomNavigationView, frameLayout, cardView, bind, fragmentContainerView);
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
    public static ActivityHomeScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityHomeScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_home_screen, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
