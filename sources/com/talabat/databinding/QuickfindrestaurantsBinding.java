package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.materialedittext.MaterialEditText;
import com.talabat.R;
import com.talabat.TalabatButton;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarButton;

public final class QuickfindrestaurantsBinding implements ViewBinding {
    @NonNull
    public final TalabatButton cancel;
    @NonNull
    public final TalabatToolBarButton cancelButton;
    @NonNull
    public final ImageButton clearSearch;
    @NonNull
    public final ImageView noRestFound;
    @NonNull
    public final LinearLayout noRestaurantsView;
    @NonNull
    public final RecyclerView quickfindrestaurantView;
    @NonNull
    public final ProgressBar quickfindrestaurantprogress;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final ImageView searchClear;
    @NonNull
    public final RelativeLayout searchContainer;
    @NonNull
    public final MaterialEditText searchEdittext;
    @NonNull
    public final ImageView searchIcon;
    @NonNull
    public final TalabatToolBar toolbar;

    private QuickfindrestaurantsBinding(@NonNull RelativeLayout relativeLayout, @NonNull TalabatButton talabatButton, @NonNull TalabatToolBarButton talabatToolBarButton, @NonNull ImageButton imageButton, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView, @NonNull ProgressBar progressBar, @NonNull ImageView imageView2, @NonNull RelativeLayout relativeLayout2, @NonNull MaterialEditText materialEditText, @NonNull ImageView imageView3, @NonNull TalabatToolBar talabatToolBar) {
        this.rootView = relativeLayout;
        this.cancel = talabatButton;
        this.cancelButton = talabatToolBarButton;
        this.clearSearch = imageButton;
        this.noRestFound = imageView;
        this.noRestaurantsView = linearLayout;
        this.quickfindrestaurantView = recyclerView;
        this.quickfindrestaurantprogress = progressBar;
        this.searchClear = imageView2;
        this.searchContainer = relativeLayout2;
        this.searchEdittext = materialEditText;
        this.searchIcon = imageView3;
        this.toolbar = talabatToolBar;
    }

    @NonNull
    public static QuickfindrestaurantsBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.cancel;
        TalabatButton talabatButton = (TalabatButton) ViewBindings.findChildViewById(view2, R.id.cancel);
        if (talabatButton != null) {
            i11 = R.id.cancel_button;
            TalabatToolBarButton talabatToolBarButton = (TalabatToolBarButton) ViewBindings.findChildViewById(view2, R.id.cancel_button);
            if (talabatToolBarButton != null) {
                i11 = R.id.clear_search;
                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view2, R.id.clear_search);
                if (imageButton != null) {
                    i11 = R.id.no_rest_found;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.no_rest_found);
                    if (imageView != null) {
                        i11 = R.id.no_restaurants_view;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.no_restaurants_view);
                        if (linearLayout != null) {
                            i11 = R.id.quickfindrestaurantView;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.quickfindrestaurantView);
                            if (recyclerView != null) {
                                i11 = R.id.quickfindrestaurantprogress;
                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.quickfindrestaurantprogress);
                                if (progressBar != null) {
                                    i11 = R.id.search_clear;
                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.search_clear);
                                    if (imageView2 != null) {
                                        i11 = R.id.search_container;
                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.search_container);
                                        if (relativeLayout != null) {
                                            i11 = R.id.search_edittext;
                                            MaterialEditText materialEditText = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.search_edittext);
                                            if (materialEditText != null) {
                                                i11 = R.id.search_icon;
                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.search_icon);
                                                if (imageView3 != null) {
                                                    i11 = R.id.toolbar;
                                                    TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                    if (talabatToolBar != null) {
                                                        return new QuickfindrestaurantsBinding((RelativeLayout) view2, talabatButton, talabatToolBarButton, imageButton, imageView, linearLayout, recyclerView, progressBar, imageView2, relativeLayout, materialEditText, imageView3, talabatToolBar);
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
    public static QuickfindrestaurantsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static QuickfindrestaurantsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.quickfindrestaurants, viewGroup, false);
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
