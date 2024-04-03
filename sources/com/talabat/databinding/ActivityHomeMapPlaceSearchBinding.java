package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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
import com.talabat.TalabatTextView;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarRelativeLayoutContainer;

public final class ActivityHomeMapPlaceSearchBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout autoFillAddress;
    @NonNull
    public final ImageView backBtn;
    @NonNull
    public final FrameLayout chooseAreaFragment;
    @NonNull
    public final MaterialEditText edSearchLocation;
    @NonNull
    public final RelativeLayout googlePlaceSearchContainer;
    @NonNull
    public final ImageView imageView10;
    @NonNull
    public final RelativeLayout noSearchResultFound;
    @NonNull
    public final LinearLayout placeSearchContainer;
    @NonNull
    public final TalabatTextView placeSearchHeader;
    @NonNull
    public final RecyclerView placeSearchList;
    @NonNull
    public final ProgressBar placesLoadingIndicator;
    @NonNull
    public final TalabatTextView preGeoLocationHint;
    @NonNull
    private final TalabatToolBarRelativeLayoutContainer rootView;
    @NonNull
    public final RelativeLayout searchClear;
    @NonNull
    public final ImageView searchClearIcon;
    @NonNull
    public final LinearLayout toolBarContainer;
    @NonNull
    public final TalabatToolBar toolbarMap;

    private ActivityHomeMapPlaceSearchBinding(@NonNull TalabatToolBarRelativeLayoutContainer talabatToolBarRelativeLayoutContainer, @NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull MaterialEditText materialEditText, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView2, @NonNull RelativeLayout relativeLayout3, @NonNull LinearLayout linearLayout, @NonNull TalabatTextView talabatTextView, @NonNull RecyclerView recyclerView, @NonNull ProgressBar progressBar, @NonNull TalabatTextView talabatTextView2, @NonNull RelativeLayout relativeLayout4, @NonNull ImageView imageView3, @NonNull LinearLayout linearLayout2, @NonNull TalabatToolBar talabatToolBar) {
        this.rootView = talabatToolBarRelativeLayoutContainer;
        this.autoFillAddress = relativeLayout;
        this.backBtn = imageView;
        this.chooseAreaFragment = frameLayout;
        this.edSearchLocation = materialEditText;
        this.googlePlaceSearchContainer = relativeLayout2;
        this.imageView10 = imageView2;
        this.noSearchResultFound = relativeLayout3;
        this.placeSearchContainer = linearLayout;
        this.placeSearchHeader = talabatTextView;
        this.placeSearchList = recyclerView;
        this.placesLoadingIndicator = progressBar;
        this.preGeoLocationHint = talabatTextView2;
        this.searchClear = relativeLayout4;
        this.searchClearIcon = imageView3;
        this.toolBarContainer = linearLayout2;
        this.toolbarMap = talabatToolBar;
    }

    @NonNull
    public static ActivityHomeMapPlaceSearchBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.auto_fill_address;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.auto_fill_address);
        if (relativeLayout != null) {
            i11 = R.id.back_btn;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.back_btn);
            if (imageView != null) {
                i11 = R.id.choose_area_fragment;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.choose_area_fragment);
                if (frameLayout != null) {
                    i11 = R.id.ed_search_location;
                    MaterialEditText materialEditText = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.ed_search_location);
                    if (materialEditText != null) {
                        i11 = R.id.google_place_search_container;
                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.google_place_search_container);
                        if (relativeLayout2 != null) {
                            i11 = R.id.imageView10;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.imageView10);
                            if (imageView2 != null) {
                                i11 = R.id.no_search_result_found;
                                RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.no_search_result_found);
                                if (relativeLayout3 != null) {
                                    i11 = R.id.place_search_container;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.place_search_container);
                                    if (linearLayout != null) {
                                        i11 = R.id.place_search_header;
                                        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.place_search_header);
                                        if (talabatTextView != null) {
                                            i11 = R.id.place_search_list;
                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.place_search_list);
                                            if (recyclerView != null) {
                                                i11 = R.id.places_loading_indicator;
                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.places_loading_indicator);
                                                if (progressBar != null) {
                                                    i11 = R.id.pre_geo_location_hint;
                                                    TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.pre_geo_location_hint);
                                                    if (talabatTextView2 != null) {
                                                        i11 = R.id.search_clear;
                                                        RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.search_clear);
                                                        if (relativeLayout4 != null) {
                                                            i11 = R.id.search_clear_icon;
                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.search_clear_icon);
                                                            if (imageView3 != null) {
                                                                i11 = R.id.tool_bar_container;
                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.tool_bar_container);
                                                                if (linearLayout2 != null) {
                                                                    i11 = R.id.toolbar_map;
                                                                    TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view2, R.id.toolbar_map);
                                                                    if (talabatToolBar != null) {
                                                                        return new ActivityHomeMapPlaceSearchBinding((TalabatToolBarRelativeLayoutContainer) view2, relativeLayout, imageView, frameLayout, materialEditText, relativeLayout2, imageView2, relativeLayout3, linearLayout, talabatTextView, recyclerView, progressBar, talabatTextView2, relativeLayout4, imageView3, linearLayout2, talabatToolBar);
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
    public static ActivityHomeMapPlaceSearchBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityHomeMapPlaceSearchBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_home_map_place_search, viewGroup, false);
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
