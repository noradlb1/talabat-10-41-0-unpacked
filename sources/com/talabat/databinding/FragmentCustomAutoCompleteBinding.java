package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.materialedittext.MaterialEditText;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.helpers.TalabatToolBarSearchRelativeLayout;

public final class FragmentCustomAutoCompleteBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout container;
    @NonNull
    public final ImageView customBackMap;
    @NonNull
    public final LinearLayout customPlaceSearchContainer;
    @NonNull
    public final MaterialEditText edSearchLocation;
    @NonNull
    public final TalabatToolBarSearchRelativeLayout editTextContainer;
    @NonNull
    public final ImageView imageView10;
    @NonNull
    public final CardView listView;
    @NonNull
    public final TalabatTextView noResult;
    @NonNull
    public final RelativeLayout noSearchResultFound;
    @NonNull
    public final ProgressBar placesLoadingIndicator;
    @NonNull
    public final RecyclerView placesRecyclerView;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final RelativeLayout searchClear;

    private FragmentCustomAutoCompleteBinding(@NonNull LinearLayout linearLayout, @NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull MaterialEditText materialEditText, @NonNull TalabatToolBarSearchRelativeLayout talabatToolBarSearchRelativeLayout, @NonNull ImageView imageView2, @NonNull CardView cardView, @NonNull TalabatTextView talabatTextView, @NonNull RelativeLayout relativeLayout2, @NonNull ProgressBar progressBar, @NonNull RecyclerView recyclerView, @NonNull RelativeLayout relativeLayout3) {
        this.rootView = linearLayout;
        this.container = relativeLayout;
        this.customBackMap = imageView;
        this.customPlaceSearchContainer = linearLayout2;
        this.edSearchLocation = materialEditText;
        this.editTextContainer = talabatToolBarSearchRelativeLayout;
        this.imageView10 = imageView2;
        this.listView = cardView;
        this.noResult = talabatTextView;
        this.noSearchResultFound = relativeLayout2;
        this.placesLoadingIndicator = progressBar;
        this.placesRecyclerView = recyclerView;
        this.searchClear = relativeLayout3;
    }

    @NonNull
    public static FragmentCustomAutoCompleteBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.container;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.container);
        if (relativeLayout != null) {
            i11 = R.id.custom_back_map;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.custom_back_map);
            if (imageView != null) {
                i11 = R.id.custom_place_search_container;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.custom_place_search_container);
                if (linearLayout != null) {
                    i11 = R.id.ed_search_location;
                    MaterialEditText materialEditText = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.ed_search_location);
                    if (materialEditText != null) {
                        i11 = R.id.edit_text_container;
                        TalabatToolBarSearchRelativeLayout talabatToolBarSearchRelativeLayout = (TalabatToolBarSearchRelativeLayout) ViewBindings.findChildViewById(view2, R.id.edit_text_container);
                        if (talabatToolBarSearchRelativeLayout != null) {
                            i11 = R.id.imageView10;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.imageView10);
                            if (imageView2 != null) {
                                i11 = R.id.list_view;
                                CardView cardView = (CardView) ViewBindings.findChildViewById(view2, R.id.list_view);
                                if (cardView != null) {
                                    i11 = R.id.no_result;
                                    TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.no_result);
                                    if (talabatTextView != null) {
                                        i11 = R.id.no_search_result_found;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.no_search_result_found);
                                        if (relativeLayout2 != null) {
                                            i11 = R.id.places_loading_indicator;
                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.places_loading_indicator);
                                            if (progressBar != null) {
                                                i11 = R.id.places_recycler_view;
                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.places_recycler_view);
                                                if (recyclerView != null) {
                                                    i11 = R.id.search_clear;
                                                    RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.search_clear);
                                                    if (relativeLayout3 != null) {
                                                        return new FragmentCustomAutoCompleteBinding((LinearLayout) view2, relativeLayout, imageView, linearLayout, materialEditText, talabatToolBarSearchRelativeLayout, imageView2, cardView, talabatTextView, relativeLayout2, progressBar, recyclerView, relativeLayout3);
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
    public static FragmentCustomAutoCompleteBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentCustomAutoCompleteBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_custom_auto_complete, viewGroup, false);
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
