package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.talabat.R;
import com.talabat.cuisines.navigation.CuisineView;
import com.talabat.filters.navigation.RestaurantsFiltersView;
import com.talabat.gem.adapters.presentation.restaurants.GemFloatingView;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.restaurants.tmart.DarkstoreEntryView;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.LookingGlassView;
import com.talabat.talabatcommon.views.tabBarWithTag.TabBarWithTagView;

public final class ActivityRestaurantsListRefactorBinding implements ViewBinding {
    @NonNull
    public final AppBarLayout appBarLayout;
    @NonNull
    public final AppBarLayout appbarLayout;
    @NonNull
    public final CuisineView cuisineViewLayout;
    @NonNull
    public final DarkstoreEntryView darkStore;
    @NonNull
    public final ImageButton favouriteImageButton;
    @NonNull
    public final FrameLayout frameLayoutCartContainer;
    @NonNull
    public final FrameLayout frameLayoutFragmentContainer;
    @NonNull
    public final GemFloatingView gemFloatingView;
    @NonNull
    public final ImageButton imageButtonCart;
    @NonNull
    public final ImageView imageViewGemFloatingLogo;
    @NonNull
    public final LinearLayout linearLayoutCollections;
    @NonNull
    public final LinearLayout linearLayoutDeliveringAtContainer;
    @NonNull
    public final LinearLayout linearLayoutFiltersContainer;
    @NonNull
    public final LinearLayout linearLayoutGemFloating;
    @NonNull
    public final LinearLayout linearLayoutHeaderContainer;
    @NonNull
    public final LinearLayout linearLayoutSearchButton;
    @NonNull
    public final LookingGlassView lookingGlass;
    @NonNull
    public final TabBarWithTagView orderModeTabBar;
    @NonNull
    public final RecyclerView recyclerViewCollections;
    @NonNull
    public final RestaurantsFiltersView restaurantsFiltersView;
    @NonNull
    public final LinearLayout rootVendorList;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView textViewCartCount;
    @NonNull
    public final TextView textViewCollectionTitle;
    @NonNull
    public final TextView textViewGemFloatingTimer;
    @NonNull
    public final TextView textViewScreenTitle;
    @NonNull
    public final TalabatToolBar toolBarMain;

    private ActivityRestaurantsListRefactorBinding(@NonNull LinearLayout linearLayout, @NonNull AppBarLayout appBarLayout2, @NonNull AppBarLayout appBarLayout3, @NonNull CuisineView cuisineView, @NonNull DarkstoreEntryView darkstoreEntryView, @NonNull ImageButton imageButton, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull GemFloatingView gemFloatingView2, @NonNull ImageButton imageButton2, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull LinearLayout linearLayout5, @NonNull LinearLayout linearLayout6, @NonNull LinearLayout linearLayout7, @NonNull LookingGlassView lookingGlassView, @NonNull TabBarWithTagView tabBarWithTagView, @NonNull RecyclerView recyclerView, @NonNull RestaurantsFiltersView restaurantsFiltersView2, @NonNull LinearLayout linearLayout8, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TalabatToolBar talabatToolBar) {
        this.rootView = linearLayout;
        this.appBarLayout = appBarLayout2;
        this.appbarLayout = appBarLayout3;
        this.cuisineViewLayout = cuisineView;
        this.darkStore = darkstoreEntryView;
        this.favouriteImageButton = imageButton;
        this.frameLayoutCartContainer = frameLayout;
        this.frameLayoutFragmentContainer = frameLayout2;
        this.gemFloatingView = gemFloatingView2;
        this.imageButtonCart = imageButton2;
        this.imageViewGemFloatingLogo = imageView;
        this.linearLayoutCollections = linearLayout2;
        this.linearLayoutDeliveringAtContainer = linearLayout3;
        this.linearLayoutFiltersContainer = linearLayout4;
        this.linearLayoutGemFloating = linearLayout5;
        this.linearLayoutHeaderContainer = linearLayout6;
        this.linearLayoutSearchButton = linearLayout7;
        this.lookingGlass = lookingGlassView;
        this.orderModeTabBar = tabBarWithTagView;
        this.recyclerViewCollections = recyclerView;
        this.restaurantsFiltersView = restaurantsFiltersView2;
        this.rootVendorList = linearLayout8;
        this.textViewCartCount = textView;
        this.textViewCollectionTitle = textView2;
        this.textViewGemFloatingTimer = textView3;
        this.textViewScreenTitle = textView4;
        this.toolBarMain = talabatToolBar;
    }

    @NonNull
    public static ActivityRestaurantsListRefactorBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.appBarLayout;
        AppBarLayout appBarLayout2 = (AppBarLayout) ViewBindings.findChildViewById(view2, R.id.appBarLayout);
        if (appBarLayout2 != null) {
            i11 = R.id.appbarLayout;
            AppBarLayout appBarLayout3 = (AppBarLayout) ViewBindings.findChildViewById(view2, R.id.appbarLayout);
            if (appBarLayout3 != null) {
                i11 = R.id.cuisineViewLayout;
                CuisineView cuisineView = (CuisineView) ViewBindings.findChildViewById(view2, R.id.cuisineViewLayout);
                if (cuisineView != null) {
                    i11 = R.id.darkStore;
                    DarkstoreEntryView darkstoreEntryView = (DarkstoreEntryView) ViewBindings.findChildViewById(view2, R.id.darkStore);
                    if (darkstoreEntryView != null) {
                        i11 = R.id.favouriteImageButton;
                        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view2, R.id.favouriteImageButton);
                        if (imageButton != null) {
                            i11 = R.id.frameLayout_cartContainer;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.frameLayout_cartContainer);
                            if (frameLayout != null) {
                                i11 = R.id.frameLayout_fragmentContainer;
                                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.frameLayout_fragmentContainer);
                                if (frameLayout2 != null) {
                                    i11 = R.id.gemFloatingView;
                                    GemFloatingView gemFloatingView2 = (GemFloatingView) ViewBindings.findChildViewById(view2, R.id.gemFloatingView);
                                    if (gemFloatingView2 != null) {
                                        i11 = R.id.imageButton_cart;
                                        ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view2, R.id.imageButton_cart);
                                        if (imageButton2 != null) {
                                            i11 = R.id.imageView_gemFloatingLogo;
                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.imageView_gemFloatingLogo);
                                            if (imageView != null) {
                                                i11 = R.id.linearLayout_collections;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.linearLayout_collections);
                                                if (linearLayout != null) {
                                                    i11 = R.id.linearLayout_deliveringAtContainer;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.linearLayout_deliveringAtContainer);
                                                    if (linearLayout2 != null) {
                                                        i11 = R.id.linearLayout_filtersContainer;
                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.linearLayout_filtersContainer);
                                                        if (linearLayout3 != null) {
                                                            i11 = R.id.linearLayout_gemFloating;
                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.linearLayout_gemFloating);
                                                            if (linearLayout4 != null) {
                                                                i11 = R.id.linearLayout_headerContainer;
                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.linearLayout_headerContainer);
                                                                if (linearLayout5 != null) {
                                                                    i11 = R.id.linearLayout_searchButton;
                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.linearLayout_searchButton);
                                                                    if (linearLayout6 != null) {
                                                                        i11 = R.id.looking_glass;
                                                                        LookingGlassView lookingGlassView = (LookingGlassView) ViewBindings.findChildViewById(view2, R.id.looking_glass);
                                                                        if (lookingGlassView != null) {
                                                                            i11 = R.id.orderModeTabBar;
                                                                            TabBarWithTagView tabBarWithTagView = (TabBarWithTagView) ViewBindings.findChildViewById(view2, R.id.orderModeTabBar);
                                                                            if (tabBarWithTagView != null) {
                                                                                i11 = R.id.recyclerView_collections;
                                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.recyclerView_collections);
                                                                                if (recyclerView != null) {
                                                                                    i11 = R.id.restaurantsFiltersView;
                                                                                    RestaurantsFiltersView restaurantsFiltersView2 = (RestaurantsFiltersView) ViewBindings.findChildViewById(view2, R.id.restaurantsFiltersView);
                                                                                    if (restaurantsFiltersView2 != null) {
                                                                                        LinearLayout linearLayout7 = (LinearLayout) view2;
                                                                                        i11 = R.id.textView_cartCount;
                                                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.textView_cartCount);
                                                                                        if (textView != null) {
                                                                                            i11 = R.id.textView_collection_title;
                                                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, R.id.textView_collection_title);
                                                                                            if (textView2 != null) {
                                                                                                i11 = R.id.textView_gemFloatingTimer;
                                                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, R.id.textView_gemFloatingTimer);
                                                                                                if (textView3 != null) {
                                                                                                    i11 = R.id.textView_screenTitle;
                                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, R.id.textView_screenTitle);
                                                                                                    if (textView4 != null) {
                                                                                                        i11 = R.id.toolBar_main;
                                                                                                        TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view2, R.id.toolBar_main);
                                                                                                        if (talabatToolBar != null) {
                                                                                                            return new ActivityRestaurantsListRefactorBinding(linearLayout7, appBarLayout2, appBarLayout3, cuisineView, darkstoreEntryView, imageButton, frameLayout, frameLayout2, gemFloatingView2, imageButton2, imageView, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, lookingGlassView, tabBarWithTagView, recyclerView, restaurantsFiltersView2, linearLayout7, textView, textView2, textView3, textView4, talabatToolBar);
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
    public static ActivityRestaurantsListRefactorBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityRestaurantsListRefactorBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_restaurants_list_refactor, viewGroup, false);
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
