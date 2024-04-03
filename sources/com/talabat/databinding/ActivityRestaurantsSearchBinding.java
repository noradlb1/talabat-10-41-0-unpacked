package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.tabs.TabLayout;
import com.materialedittext.MaterialEditText;
import com.talabat.R;
import com.talabat.TalabatButton;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarRelativeLayoutContainer;

public final class ActivityRestaurantsSearchBinding implements ViewBinding {
    @NonNull
    public final Button buttonCancelSearch;
    @NonNull
    public final TalabatButton buttonClear;
    @NonNull
    public final Button buttonDishesSeeMore;
    @NonNull
    public final Button buttonRestaurantsSeeMore;
    @NonNull
    public final Button buttonSearchTerm;
    @NonNull
    public final MaterialEditText editTextSearch;
    @NonNull
    public final ImageView imageViewClearSearch;
    @NonNull
    public final LinearLayout instanceContainer;
    @NonNull
    public final RecyclerView instanceSearchRecyclerView;
    @NonNull
    public final LinearLayout itemsSuggestionContainer;
    @NonNull
    public final LinearLayout linearLayoutNoRestaurantContainer;
    @NonNull
    public final LinearLayout linearLayoutRecentContainer;
    @NonNull
    public final LinearLayout linearLayoutSearchResultContainer;
    @NonNull
    public final LinearLayout linearLayoutTrendingContainer;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    public final RecyclerView recyclerViewDishesSuggestions;
    @NonNull
    public final RecyclerView recyclerViewRecent;
    @NonNull
    public final RecyclerView recyclerViewRestaurantsList;
    @NonNull
    public final RecyclerView recyclerViewRestaurantsSuggestions;
    @NonNull
    public final RecyclerView recyclerViewTrending;
    @NonNull
    public final RelativeLayout relativeLayoutSearchContainer;
    @NonNull
    public final LinearLayout restaurantsSuggestionContainer;
    @NonNull
    private final TalabatToolBarRelativeLayoutContainer rootView;
    @NonNull
    public final NestedScrollView suggestionsContainer;
    @NonNull
    public final TabLayout tabLayout;
    @NonNull
    public final TalabatToolBar toolbar;

    private ActivityRestaurantsSearchBinding(@NonNull TalabatToolBarRelativeLayoutContainer talabatToolBarRelativeLayoutContainer, @NonNull Button button, @NonNull TalabatButton talabatButton, @NonNull Button button2, @NonNull Button button3, @NonNull Button button4, @NonNull MaterialEditText materialEditText, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull LinearLayout linearLayout5, @NonNull LinearLayout linearLayout6, @NonNull ProgressBar progressBar2, @NonNull RecyclerView recyclerView2, @NonNull RecyclerView recyclerView3, @NonNull RecyclerView recyclerView4, @NonNull RecyclerView recyclerView5, @NonNull RecyclerView recyclerView6, @NonNull RelativeLayout relativeLayout, @NonNull LinearLayout linearLayout7, @NonNull NestedScrollView nestedScrollView, @NonNull TabLayout tabLayout2, @NonNull TalabatToolBar talabatToolBar) {
        this.rootView = talabatToolBarRelativeLayoutContainer;
        this.buttonCancelSearch = button;
        this.buttonClear = talabatButton;
        this.buttonDishesSeeMore = button2;
        this.buttonRestaurantsSeeMore = button3;
        this.buttonSearchTerm = button4;
        this.editTextSearch = materialEditText;
        this.imageViewClearSearch = imageView;
        this.instanceContainer = linearLayout;
        this.instanceSearchRecyclerView = recyclerView;
        this.itemsSuggestionContainer = linearLayout2;
        this.linearLayoutNoRestaurantContainer = linearLayout3;
        this.linearLayoutRecentContainer = linearLayout4;
        this.linearLayoutSearchResultContainer = linearLayout5;
        this.linearLayoutTrendingContainer = linearLayout6;
        this.progressBar = progressBar2;
        this.recyclerViewDishesSuggestions = recyclerView2;
        this.recyclerViewRecent = recyclerView3;
        this.recyclerViewRestaurantsList = recyclerView4;
        this.recyclerViewRestaurantsSuggestions = recyclerView5;
        this.recyclerViewTrending = recyclerView6;
        this.relativeLayoutSearchContainer = relativeLayout;
        this.restaurantsSuggestionContainer = linearLayout7;
        this.suggestionsContainer = nestedScrollView;
        this.tabLayout = tabLayout2;
        this.toolbar = talabatToolBar;
    }

    @NonNull
    public static ActivityRestaurantsSearchBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.button_cancel_search;
        Button button = (Button) ViewBindings.findChildViewById(view2, R.id.button_cancel_search);
        if (button != null) {
            i11 = R.id.button_clear;
            TalabatButton talabatButton = (TalabatButton) ViewBindings.findChildViewById(view2, R.id.button_clear);
            if (talabatButton != null) {
                i11 = R.id.button_dishesSeeMore;
                Button button2 = (Button) ViewBindings.findChildViewById(view2, R.id.button_dishesSeeMore);
                if (button2 != null) {
                    i11 = R.id.button_restaurantsSeeMore;
                    Button button3 = (Button) ViewBindings.findChildViewById(view2, R.id.button_restaurantsSeeMore);
                    if (button3 != null) {
                        i11 = R.id.button_searchTerm;
                        Button button4 = (Button) ViewBindings.findChildViewById(view2, R.id.button_searchTerm);
                        if (button4 != null) {
                            i11 = R.id.editText_search;
                            MaterialEditText materialEditText = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.editText_search);
                            if (materialEditText != null) {
                                i11 = R.id.imageView_clearSearch;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.imageView_clearSearch);
                                if (imageView != null) {
                                    i11 = R.id.instanceContainer;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.instanceContainer);
                                    if (linearLayout != null) {
                                        i11 = R.id.instanceSearchRecyclerView;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.instanceSearchRecyclerView);
                                        if (recyclerView != null) {
                                            i11 = R.id.itemsSuggestionContainer;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.itemsSuggestionContainer);
                                            if (linearLayout2 != null) {
                                                i11 = R.id.linearLayout_noRestaurantContainer;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.linearLayout_noRestaurantContainer);
                                                if (linearLayout3 != null) {
                                                    i11 = R.id.linearLayout_recentContainer;
                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.linearLayout_recentContainer);
                                                    if (linearLayout4 != null) {
                                                        i11 = R.id.linearLayout_searchResultContainer;
                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.linearLayout_searchResultContainer);
                                                        if (linearLayout5 != null) {
                                                            i11 = R.id.linearLayout_trendingContainer;
                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.linearLayout_trendingContainer);
                                                            if (linearLayout6 != null) {
                                                                i11 = R.id.progressBar;
                                                                ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.progressBar);
                                                                if (progressBar2 != null) {
                                                                    i11 = R.id.recyclerView_dishesSuggestions;
                                                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.recyclerView_dishesSuggestions);
                                                                    if (recyclerView2 != null) {
                                                                        i11 = R.id.recyclerView_recent;
                                                                        RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.recyclerView_recent);
                                                                        if (recyclerView3 != null) {
                                                                            i11 = R.id.recyclerView_restaurantsList;
                                                                            RecyclerView recyclerView4 = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.recyclerView_restaurantsList);
                                                                            if (recyclerView4 != null) {
                                                                                i11 = R.id.recyclerView_RestaurantsSuggestions;
                                                                                RecyclerView recyclerView5 = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.recyclerView_RestaurantsSuggestions);
                                                                                if (recyclerView5 != null) {
                                                                                    i11 = R.id.recyclerView_trending;
                                                                                    RecyclerView recyclerView6 = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.recyclerView_trending);
                                                                                    if (recyclerView6 != null) {
                                                                                        i11 = R.id.relativeLayout_searchContainer;
                                                                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.relativeLayout_searchContainer);
                                                                                        if (relativeLayout != null) {
                                                                                            i11 = R.id.restaurantsSuggestionContainer;
                                                                                            LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.restaurantsSuggestionContainer);
                                                                                            if (linearLayout7 != null) {
                                                                                                i11 = R.id.suggestionsContainer;
                                                                                                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view2, R.id.suggestionsContainer);
                                                                                                if (nestedScrollView != null) {
                                                                                                    i11 = R.id.tabLayout;
                                                                                                    TabLayout tabLayout2 = (TabLayout) ViewBindings.findChildViewById(view2, R.id.tabLayout);
                                                                                                    if (tabLayout2 != null) {
                                                                                                        i11 = R.id.toolbar;
                                                                                                        TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                                                                        if (talabatToolBar != null) {
                                                                                                            return new ActivityRestaurantsSearchBinding((TalabatToolBarRelativeLayoutContainer) view2, button, talabatButton, button2, button3, button4, materialEditText, imageView, linearLayout, recyclerView, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, progressBar2, recyclerView2, recyclerView3, recyclerView4, recyclerView5, recyclerView6, relativeLayout, linearLayout7, nestedScrollView, tabLayout2, talabatToolBar);
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
    public static ActivityRestaurantsSearchBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityRestaurantsSearchBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_restaurants_search, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public TalabatToolBarRelativeLayoutContainer getRoot() {
        return this.rootView;
    }
}
