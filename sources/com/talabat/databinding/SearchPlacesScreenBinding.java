package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.materialedittext.MaterialEditText;
import com.talabat.R;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarButton;

public final class SearchPlacesScreenBinding implements ViewBinding {
    @NonNull
    public final TalabatToolBarButton cancelButton;
    @NonNull
    public final ImageView clearText;
    @NonNull
    public final FrameLayout contentLayout;
    @NonNull
    public final RelativeLayout gemFooterView;
    @NonNull
    public final ImageView noItemFound;
    @NonNull
    public final LinearLayout noPlacesView;
    @NonNull
    public final ListView placesList;
    @NonNull
    public final ProgressBar placesLoadingIndicator;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final RelativeLayout searchContainer;
    @NonNull
    public final MaterialEditText searchEdittext;
    @NonNull
    public final LinearLayout searchViewParent;
    @NonNull
    public final TalabatToolBar toolbar;

    private SearchPlacesScreenBinding(@NonNull RelativeLayout relativeLayout, @NonNull TalabatToolBarButton talabatToolBarButton, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout, @NonNull ListView listView, @NonNull ProgressBar progressBar, @NonNull RelativeLayout relativeLayout3, @NonNull MaterialEditText materialEditText, @NonNull LinearLayout linearLayout2, @NonNull TalabatToolBar talabatToolBar) {
        this.rootView = relativeLayout;
        this.cancelButton = talabatToolBarButton;
        this.clearText = imageView;
        this.contentLayout = frameLayout;
        this.gemFooterView = relativeLayout2;
        this.noItemFound = imageView2;
        this.noPlacesView = linearLayout;
        this.placesList = listView;
        this.placesLoadingIndicator = progressBar;
        this.searchContainer = relativeLayout3;
        this.searchEdittext = materialEditText;
        this.searchViewParent = linearLayout2;
        this.toolbar = talabatToolBar;
    }

    @NonNull
    public static SearchPlacesScreenBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.cancel_button;
        TalabatToolBarButton talabatToolBarButton = (TalabatToolBarButton) ViewBindings.findChildViewById(view2, R.id.cancel_button);
        if (talabatToolBarButton != null) {
            i11 = R.id.clear_text;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.clear_text);
            if (imageView != null) {
                i11 = R.id.content_layout;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.content_layout);
                if (frameLayout != null) {
                    i11 = R.id.gem_footer_view;
                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.gem_footer_view);
                    if (relativeLayout != null) {
                        i11 = R.id.no_item_found;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.no_item_found);
                        if (imageView2 != null) {
                            i11 = R.id.no_places_view;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.no_places_view);
                            if (linearLayout != null) {
                                i11 = R.id.places_list;
                                ListView listView = (ListView) ViewBindings.findChildViewById(view2, R.id.places_list);
                                if (listView != null) {
                                    i11 = R.id.places_loading_indicator;
                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.places_loading_indicator);
                                    if (progressBar != null) {
                                        i11 = R.id.search_container;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.search_container);
                                        if (relativeLayout2 != null) {
                                            i11 = R.id.search_edittext;
                                            MaterialEditText materialEditText = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.search_edittext);
                                            if (materialEditText != null) {
                                                i11 = R.id.search_view_parent;
                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.search_view_parent);
                                                if (linearLayout2 != null) {
                                                    i11 = R.id.toolbar;
                                                    TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                    if (talabatToolBar != null) {
                                                        return new SearchPlacesScreenBinding((RelativeLayout) view2, talabatToolBarButton, imageView, frameLayout, relativeLayout, imageView2, linearLayout, listView, progressBar, relativeLayout2, materialEditText, linearLayout2, talabatToolBar);
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
    public static SearchPlacesScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static SearchPlacesScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.search_places_screen, viewGroup, false);
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
