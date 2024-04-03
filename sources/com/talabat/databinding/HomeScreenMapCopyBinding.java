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
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.materialedittext.MaterialEditText;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.helpers.TalabatToolBarSearchRelativeLayout;

public final class HomeScreenMapCopyBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout autoFillAddress;
    @NonNull
    public final ImageView backMap;
    @NonNull
    public final RelativeLayout bottomDetailsContainer;
    @NonNull
    public final TalabatTextView currentLocationAwareTxt;
    @NonNull
    public final ImageView dargClose;
    @NonNull
    public final RelativeLayout defaultSearchContainer;
    @NonNull
    public final TalabatTextView deliverBtnHereTxt;
    @NonNull
    public final RelativeLayout deliverHere;
    @NonNull
    public final CardView deliverHereCardView;
    @NonNull
    public final RelativeLayout detailCardContainer;
    @NonNull
    public final LinearLayout dragTutContainer;
    @NonNull
    public final MaterialEditText edSearchLocation;
    @NonNull
    public final TalabatToolBarSearchRelativeLayout editTextContainer;
    @NonNull
    public final ProgressBar enableLocationProgress;
    @NonNull
    public final CardView filterView;
    @NonNull
    public final CardView googleAutoCompleteCardview;
    @NonNull
    public final LinearLayout googleAutoWidgetContainer;
    @NonNull
    public final FrameLayout googlePlaceSearchFragment;
    @NonNull
    public final ImageView imageView10;
    @NonNull
    public final ImageView imageView8;
    @NonNull
    public final ImageView imageView9;
    @NonNull
    public final ProgressBar linearProgressBar;
    @NonNull
    public final ProgressBar loadingProgress;
    @NonNull
    public final LinearLayout locationAwareBtn;
    @NonNull
    public final ImageView locationBtn;
    @NonNull
    public final LinearLayout locationBtnContainer;
    @NonNull
    public final FrameLayout locationBtnSubContainer;
    @NonNull
    public final RelativeLayout mainContainer;
    @NonNull
    public final ImageView mapPin;
    @NonNull
    public final ImageView mapViewSwitchBtn;
    @NonNull
    public final LinearLayout placeSearchContainer;
    @NonNull
    public final ProgressBar placesLoadingIndicator;
    @NonNull
    public final RelativeLayout preGeoAddressContainer;
    @NonNull
    public final LinearLayout preGeoLocationContainer;
    @NonNull
    public final TalabatTextView preGeoLocationHint;
    @NonNull
    public final TalabatTextView preGeoLocationTxt;
    @NonNull
    public final ImageView preGeoPin;
    @NonNull
    public final TalabatTextView resetToCl;
    @NonNull
    private final FrameLayout rootView;
    @NonNull
    public final FrameLayout satelliteBtnSubContainer;
    @NonNull
    public final RelativeLayout searchClear;
    @NonNull
    public final LinearLayout toolBarContainer;
    @NonNull
    public final Toolbar toolbarMap;
    @NonNull
    public final TalabatTextView tutTxt;
    @NonNull
    public final TalabatTextView yesDeliverHere;

    private HomeScreenMapCopyBinding(@NonNull FrameLayout frameLayout, @NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull RelativeLayout relativeLayout2, @NonNull TalabatTextView talabatTextView, @NonNull ImageView imageView2, @NonNull RelativeLayout relativeLayout3, @NonNull TalabatTextView talabatTextView2, @NonNull RelativeLayout relativeLayout4, @NonNull CardView cardView, @NonNull RelativeLayout relativeLayout5, @NonNull LinearLayout linearLayout, @NonNull MaterialEditText materialEditText, @NonNull TalabatToolBarSearchRelativeLayout talabatToolBarSearchRelativeLayout, @NonNull ProgressBar progressBar, @NonNull CardView cardView2, @NonNull CardView cardView3, @NonNull LinearLayout linearLayout2, @NonNull FrameLayout frameLayout2, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull ImageView imageView5, @NonNull ProgressBar progressBar2, @NonNull ProgressBar progressBar3, @NonNull LinearLayout linearLayout3, @NonNull ImageView imageView6, @NonNull LinearLayout linearLayout4, @NonNull FrameLayout frameLayout3, @NonNull RelativeLayout relativeLayout6, @NonNull ImageView imageView7, @NonNull ImageView imageView11, @NonNull LinearLayout linearLayout5, @NonNull ProgressBar progressBar4, @NonNull RelativeLayout relativeLayout7, @NonNull LinearLayout linearLayout6, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatTextView talabatTextView4, @NonNull ImageView imageView12, @NonNull TalabatTextView talabatTextView5, @NonNull FrameLayout frameLayout4, @NonNull RelativeLayout relativeLayout8, @NonNull LinearLayout linearLayout7, @NonNull Toolbar toolbar, @NonNull TalabatTextView talabatTextView6, @NonNull TalabatTextView talabatTextView7) {
        this.rootView = frameLayout;
        this.autoFillAddress = relativeLayout;
        this.backMap = imageView;
        this.bottomDetailsContainer = relativeLayout2;
        this.currentLocationAwareTxt = talabatTextView;
        this.dargClose = imageView2;
        this.defaultSearchContainer = relativeLayout3;
        this.deliverBtnHereTxt = talabatTextView2;
        this.deliverHere = relativeLayout4;
        this.deliverHereCardView = cardView;
        this.detailCardContainer = relativeLayout5;
        this.dragTutContainer = linearLayout;
        this.edSearchLocation = materialEditText;
        this.editTextContainer = talabatToolBarSearchRelativeLayout;
        this.enableLocationProgress = progressBar;
        this.filterView = cardView2;
        this.googleAutoCompleteCardview = cardView3;
        this.googleAutoWidgetContainer = linearLayout2;
        this.googlePlaceSearchFragment = frameLayout2;
        this.imageView10 = imageView3;
        this.imageView8 = imageView4;
        this.imageView9 = imageView5;
        this.linearProgressBar = progressBar2;
        this.loadingProgress = progressBar3;
        this.locationAwareBtn = linearLayout3;
        this.locationBtn = imageView6;
        this.locationBtnContainer = linearLayout4;
        this.locationBtnSubContainer = frameLayout3;
        this.mainContainer = relativeLayout6;
        this.mapPin = imageView7;
        this.mapViewSwitchBtn = imageView11;
        this.placeSearchContainer = linearLayout5;
        this.placesLoadingIndicator = progressBar4;
        this.preGeoAddressContainer = relativeLayout7;
        this.preGeoLocationContainer = linearLayout6;
        this.preGeoLocationHint = talabatTextView3;
        this.preGeoLocationTxt = talabatTextView4;
        this.preGeoPin = imageView12;
        this.resetToCl = talabatTextView5;
        this.satelliteBtnSubContainer = frameLayout4;
        this.searchClear = relativeLayout8;
        this.toolBarContainer = linearLayout7;
        this.toolbarMap = toolbar;
        this.tutTxt = talabatTextView6;
        this.yesDeliverHere = talabatTextView7;
    }

    @NonNull
    public static HomeScreenMapCopyBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.auto_fill_address;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.auto_fill_address);
        if (relativeLayout != null) {
            i11 = R.id.back_map;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.back_map);
            if (imageView != null) {
                i11 = R.id.bottom_details_container;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.bottom_details_container);
                if (relativeLayout2 != null) {
                    i11 = R.id.current_location_aware_txt;
                    TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.current_location_aware_txt);
                    if (talabatTextView != null) {
                        i11 = R.id.darg_close;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.darg_close);
                        if (imageView2 != null) {
                            i11 = R.id.default_search_container;
                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.default_search_container);
                            if (relativeLayout3 != null) {
                                i11 = R.id.deliver_btn_here_txt;
                                TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.deliver_btn_here_txt);
                                if (talabatTextView2 != null) {
                                    i11 = R.id.deliver_here;
                                    RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.deliver_here);
                                    if (relativeLayout4 != null) {
                                        i11 = R.id.deliver_here_card_view;
                                        CardView cardView = (CardView) ViewBindings.findChildViewById(view2, R.id.deliver_here_card_view);
                                        if (cardView != null) {
                                            i11 = R.id.detail_card_container;
                                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.detail_card_container);
                                            if (relativeLayout5 != null) {
                                                i11 = R.id.drag_tut_container;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.drag_tut_container);
                                                if (linearLayout != null) {
                                                    i11 = R.id.ed_search_location;
                                                    MaterialEditText materialEditText = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.ed_search_location);
                                                    if (materialEditText != null) {
                                                        i11 = R.id.edit_text_container;
                                                        TalabatToolBarSearchRelativeLayout talabatToolBarSearchRelativeLayout = (TalabatToolBarSearchRelativeLayout) ViewBindings.findChildViewById(view2, R.id.edit_text_container);
                                                        if (talabatToolBarSearchRelativeLayout != null) {
                                                            i11 = R.id.enable_location_progress;
                                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.enable_location_progress);
                                                            if (progressBar != null) {
                                                                i11 = R.id.filter_view;
                                                                CardView cardView2 = (CardView) ViewBindings.findChildViewById(view2, R.id.filter_view);
                                                                if (cardView2 != null) {
                                                                    i11 = R.id.google_auto_complete_cardview;
                                                                    CardView cardView3 = (CardView) ViewBindings.findChildViewById(view2, R.id.google_auto_complete_cardview);
                                                                    if (cardView3 != null) {
                                                                        i11 = R.id.google_auto_widget_container;
                                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.google_auto_widget_container);
                                                                        if (linearLayout2 != null) {
                                                                            i11 = R.id.google_place_search_fragment;
                                                                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.google_place_search_fragment);
                                                                            if (frameLayout != null) {
                                                                                i11 = R.id.imageView10;
                                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.imageView10);
                                                                                if (imageView3 != null) {
                                                                                    i11 = R.id.imageView8;
                                                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.imageView8);
                                                                                    if (imageView4 != null) {
                                                                                        i11 = R.id.imageView9;
                                                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, R.id.imageView9);
                                                                                        if (imageView5 != null) {
                                                                                            i11 = R.id.linear_progressBar;
                                                                                            ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.linear_progressBar);
                                                                                            if (progressBar2 != null) {
                                                                                                i11 = R.id.loading_progress;
                                                                                                ProgressBar progressBar3 = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.loading_progress);
                                                                                                if (progressBar3 != null) {
                                                                                                    i11 = R.id.location_aware_btn;
                                                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.location_aware_btn);
                                                                                                    if (linearLayout3 != null) {
                                                                                                        i11 = R.id.location_btn;
                                                                                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view2, R.id.location_btn);
                                                                                                        if (imageView6 != null) {
                                                                                                            i11 = R.id.location_btn_container;
                                                                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.location_btn_container);
                                                                                                            if (linearLayout4 != null) {
                                                                                                                i11 = R.id.location_btn_sub_container;
                                                                                                                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.location_btn_sub_container);
                                                                                                                if (frameLayout2 != null) {
                                                                                                                    i11 = R.id.main_container;
                                                                                                                    RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.main_container);
                                                                                                                    if (relativeLayout6 != null) {
                                                                                                                        i11 = R.id.map_pin;
                                                                                                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view2, R.id.map_pin);
                                                                                                                        if (imageView7 != null) {
                                                                                                                            i11 = R.id.map_view_switch_btn;
                                                                                                                            ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(view2, R.id.map_view_switch_btn);
                                                                                                                            if (imageView11 != null) {
                                                                                                                                i11 = R.id.place_search_container;
                                                                                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.place_search_container);
                                                                                                                                if (linearLayout5 != null) {
                                                                                                                                    i11 = R.id.places_loading_indicator;
                                                                                                                                    ProgressBar progressBar4 = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.places_loading_indicator);
                                                                                                                                    if (progressBar4 != null) {
                                                                                                                                        i11 = R.id.pre_geo_address_container;
                                                                                                                                        RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.pre_geo_address_container);
                                                                                                                                        if (relativeLayout7 != null) {
                                                                                                                                            i11 = R.id.pre_geo_location_container;
                                                                                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.pre_geo_location_container);
                                                                                                                                            if (linearLayout6 != null) {
                                                                                                                                                i11 = R.id.pre_geo_location_hint;
                                                                                                                                                TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.pre_geo_location_hint);
                                                                                                                                                if (talabatTextView3 != null) {
                                                                                                                                                    i11 = R.id.pre_geo_location_txt;
                                                                                                                                                    TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.pre_geo_location_txt);
                                                                                                                                                    if (talabatTextView4 != null) {
                                                                                                                                                        i11 = R.id.pre_geo_pin;
                                                                                                                                                        ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(view2, R.id.pre_geo_pin);
                                                                                                                                                        if (imageView12 != null) {
                                                                                                                                                            i11 = R.id.reset_to_cl;
                                                                                                                                                            TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.reset_to_cl);
                                                                                                                                                            if (talabatTextView5 != null) {
                                                                                                                                                                i11 = R.id.satellite_btn_sub_container;
                                                                                                                                                                FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.satellite_btn_sub_container);
                                                                                                                                                                if (frameLayout3 != null) {
                                                                                                                                                                    i11 = R.id.search_clear;
                                                                                                                                                                    RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.search_clear);
                                                                                                                                                                    if (relativeLayout8 != null) {
                                                                                                                                                                        i11 = R.id.tool_bar_container;
                                                                                                                                                                        LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.tool_bar_container);
                                                                                                                                                                        if (linearLayout7 != null) {
                                                                                                                                                                            i11 = R.id.toolbar_map;
                                                                                                                                                                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view2, R.id.toolbar_map);
                                                                                                                                                                            if (toolbar != null) {
                                                                                                                                                                                i11 = R.id.tut_txt;
                                                                                                                                                                                TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tut_txt);
                                                                                                                                                                                if (talabatTextView6 != null) {
                                                                                                                                                                                    i11 = R.id.yes_deliver_here;
                                                                                                                                                                                    TalabatTextView talabatTextView7 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.yes_deliver_here);
                                                                                                                                                                                    if (talabatTextView7 != null) {
                                                                                                                                                                                        return new HomeScreenMapCopyBinding((FrameLayout) view2, relativeLayout, imageView, relativeLayout2, talabatTextView, imageView2, relativeLayout3, talabatTextView2, relativeLayout4, cardView, relativeLayout5, linearLayout, materialEditText, talabatToolBarSearchRelativeLayout, progressBar, cardView2, cardView3, linearLayout2, frameLayout, imageView3, imageView4, imageView5, progressBar2, progressBar3, linearLayout3, imageView6, linearLayout4, frameLayout2, relativeLayout6, imageView7, imageView11, linearLayout5, progressBar4, relativeLayout7, linearLayout6, talabatTextView3, talabatTextView4, imageView12, talabatTextView5, frameLayout3, relativeLayout8, linearLayout7, toolbar, talabatTextView6, talabatTextView7);
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
    public static HomeScreenMapCopyBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static HomeScreenMapCopyBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.home_screen_map_copy, viewGroup, false);
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
