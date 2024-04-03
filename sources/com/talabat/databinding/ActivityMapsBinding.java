package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatSpinner;
import com.talabat.TalabatTextView;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarButton;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarRelativeLayoutContainer;
import com.talabat.helpers.TalabatToolBarTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.talabatcommon.views.TalabatStrokeButton;

public final class ActivityMapsBinding implements ViewBinding {
    @NonNull
    public final TalabatToolBarRelativeLayoutContainer autoFillAddress;
    @NonNull
    public final LinearLayout autocompleteLayout;
    @NonNull
    public final TalabatTextView autofillDescription;
    @NonNull
    public final TalabatToolBarImageButton back;
    @NonNull
    public final TalabatTextView blockNoTxt;
    @NonNull
    public final RelativeLayout blockSection;
    @NonNull
    public final ImageView blockSectionArrow;
    @NonNull
    public final TalabatSpinner blockSpinner;
    @NonNull
    public final RelativeLayout blockSpinnerContainer;
    @NonNull
    public final TalabatTextView blockTxt;
    @NonNull
    public final TalabatToolBarButton cancelButton;
    @NonNull
    public final CardView cardGradient;
    @NonNull
    public final ImageView clearText;
    @NonNull
    public final TalabatFillButton confim;
    @NonNull
    public final TalabatFillButton confimMcd;
    @NonNull
    public final LinearLayout confirmContainer;
    @NonNull
    public final RelativeLayout confirmView;
    @NonNull
    public final RelativeLayout confirmViewContainer;
    @NonNull
    public final LinearLayout confirmsView;
    @NonNull
    public final TalabatTextView currentLocationAwareTxt;
    @NonNull
    public final LinearLayout customButtonGroup;
    @NonNull
    public final ImageView dargClose;
    @NonNull
    public final ImageView deliveringImg;
    @NonNull
    public final LinearLayout dragTutContainer;
    @NonNull
    public final CardView filterView;
    @NonNull
    public final RelativeLayout gemFooterView;
    @NonNull
    public final FrameLayout googlePlaceSearchFragment;
    @NonNull
    public final TalabatTextView guideTitle;
    @NonNull
    public final ImageView imageView5;
    @NonNull
    public final ImageView imageView8;
    @NonNull
    public final ImageView imageView9;
    @NonNull
    public final LinearLayout linearLayout3;
    @NonNull
    public final RelativeLayout locAwarContainer;
    @NonNull
    public final CardView locationAwaranessHereCardView;
    @NonNull
    public final LinearLayout locationAwareBtn;
    @NonNull
    public final ImageView locationBtn;
    @NonNull
    public final LinearLayout locationBtnContainer;
    @NonNull
    public final FrameLayout locationBtnSubContainer;
    @NonNull
    public final RelativeLayout mapOnboardingContentview;
    @NonNull
    public final ImageView mapPin;
    @NonNull
    public final ImageView mapToolbarSearch;
    @NonNull
    public final ImageView mapViewSwitchBtn;
    @NonNull
    public final RelativeLayout mcdBlockContainerTitle;
    @NonNull
    public final TalabatTextView mcdBlockTitle;
    @NonNull
    public final RelativeLayout mcdConfirmContainer;
    @NonNull
    public final RelativeLayout mcdContainer;
    @NonNull
    public final RelativeLayout mcdDisableContainer;
    @NonNull
    public final Button mcdEditLocationBtn;
    @NonNull
    public final TalabatTextView mcdInfoTxt;
    @NonNull
    public final RelativeLayout mcdKsaSubContainer;
    @NonNull
    public final TalabatFillButton mcdProceedOrder;
    @NonNull
    public final RelativeLayout mcdSubContainer;
    @NonNull
    public final RelativeLayout menuMapTypeContainer;
    @NonNull
    public final ProgressBar placesLoadingIndicator;
    @NonNull
    public final TalabatTextView pleaseChooseTxt;
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
    private final RelativeLayout rootView;
    @NonNull
    public final FrameLayout satelliteBtnSubContainer;
    @NonNull
    public final CardView searchContainerCard;
    @NonNull
    public final View searchViewAnchor;
    @NonNull
    public final LinearLayout searchViewParent;
    @NonNull
    public final RelativeLayout showCaseView;
    @NonNull
    public final TalabatStrokeButton skipMapBtn;
    @NonNull
    public final TalabatTextView textUserGuideSubTxt;
    @NonNull
    public final TalabatToolBarTextView title;
    @NonNull
    public final TalabatToolBar toolbar;
    @NonNull
    public final TalabatTextView tutTxt;
    @NonNull
    public final TalabatFillButton userGuideGotIt;
    @NonNull
    public final TalabatTextView yesDeliverHere;

    private ActivityMapsBinding(@NonNull RelativeLayout relativeLayout, @NonNull TalabatToolBarRelativeLayoutContainer talabatToolBarRelativeLayoutContainer, @NonNull LinearLayout linearLayout, @NonNull TalabatTextView talabatTextView, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull TalabatTextView talabatTextView2, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView, @NonNull TalabatSpinner talabatSpinner, @NonNull RelativeLayout relativeLayout3, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatToolBarButton talabatToolBarButton, @NonNull CardView cardView, @NonNull ImageView imageView2, @NonNull TalabatFillButton talabatFillButton, @NonNull TalabatFillButton talabatFillButton2, @NonNull LinearLayout linearLayout2, @NonNull RelativeLayout relativeLayout4, @NonNull RelativeLayout relativeLayout5, @NonNull LinearLayout linearLayout4, @NonNull TalabatTextView talabatTextView4, @NonNull LinearLayout linearLayout5, @NonNull ImageView imageView3, @NonNull ImageView imageView4, @NonNull LinearLayout linearLayout6, @NonNull CardView cardView2, @NonNull RelativeLayout relativeLayout6, @NonNull FrameLayout frameLayout, @NonNull TalabatTextView talabatTextView5, @NonNull ImageView imageView6, @NonNull ImageView imageView7, @NonNull ImageView imageView10, @NonNull LinearLayout linearLayout7, @NonNull RelativeLayout relativeLayout7, @NonNull CardView cardView3, @NonNull LinearLayout linearLayout8, @NonNull ImageView imageView11, @NonNull LinearLayout linearLayout9, @NonNull FrameLayout frameLayout2, @NonNull RelativeLayout relativeLayout8, @NonNull ImageView imageView12, @NonNull ImageView imageView13, @NonNull ImageView imageView14, @NonNull RelativeLayout relativeLayout9, @NonNull TalabatTextView talabatTextView6, @NonNull RelativeLayout relativeLayout10, @NonNull RelativeLayout relativeLayout11, @NonNull RelativeLayout relativeLayout12, @NonNull Button button, @NonNull TalabatTextView talabatTextView7, @NonNull RelativeLayout relativeLayout13, @NonNull TalabatFillButton talabatFillButton3, @NonNull RelativeLayout relativeLayout14, @NonNull RelativeLayout relativeLayout15, @NonNull ProgressBar progressBar, @NonNull TalabatTextView talabatTextView8, @NonNull RelativeLayout relativeLayout16, @NonNull LinearLayout linearLayout10, @NonNull TalabatTextView talabatTextView9, @NonNull TalabatTextView talabatTextView10, @NonNull ImageView imageView15, @NonNull TalabatTextView talabatTextView11, @NonNull FrameLayout frameLayout3, @NonNull CardView cardView4, @NonNull View view, @NonNull LinearLayout linearLayout11, @NonNull RelativeLayout relativeLayout17, @NonNull TalabatStrokeButton talabatStrokeButton, @NonNull TalabatTextView talabatTextView12, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull TalabatToolBar talabatToolBar, @NonNull TalabatTextView talabatTextView13, @NonNull TalabatFillButton talabatFillButton4, @NonNull TalabatTextView talabatTextView14) {
        this.rootView = relativeLayout;
        this.autoFillAddress = talabatToolBarRelativeLayoutContainer;
        this.autocompleteLayout = linearLayout;
        this.autofillDescription = talabatTextView;
        this.back = talabatToolBarImageButton;
        this.blockNoTxt = talabatTextView2;
        this.blockSection = relativeLayout2;
        this.blockSectionArrow = imageView;
        this.blockSpinner = talabatSpinner;
        this.blockSpinnerContainer = relativeLayout3;
        this.blockTxt = talabatTextView3;
        this.cancelButton = talabatToolBarButton;
        this.cardGradient = cardView;
        this.clearText = imageView2;
        this.confim = talabatFillButton;
        this.confimMcd = talabatFillButton2;
        this.confirmContainer = linearLayout2;
        this.confirmView = relativeLayout4;
        this.confirmViewContainer = relativeLayout5;
        this.confirmsView = linearLayout4;
        this.currentLocationAwareTxt = talabatTextView4;
        this.customButtonGroup = linearLayout5;
        this.dargClose = imageView3;
        this.deliveringImg = imageView4;
        this.dragTutContainer = linearLayout6;
        this.filterView = cardView2;
        this.gemFooterView = relativeLayout6;
        this.googlePlaceSearchFragment = frameLayout;
        this.guideTitle = talabatTextView5;
        this.imageView5 = imageView6;
        this.imageView8 = imageView7;
        this.imageView9 = imageView10;
        this.linearLayout3 = linearLayout7;
        this.locAwarContainer = relativeLayout7;
        this.locationAwaranessHereCardView = cardView3;
        this.locationAwareBtn = linearLayout8;
        this.locationBtn = imageView11;
        this.locationBtnContainer = linearLayout9;
        this.locationBtnSubContainer = frameLayout2;
        this.mapOnboardingContentview = relativeLayout8;
        this.mapPin = imageView12;
        this.mapToolbarSearch = imageView13;
        this.mapViewSwitchBtn = imageView14;
        this.mcdBlockContainerTitle = relativeLayout9;
        this.mcdBlockTitle = talabatTextView6;
        this.mcdConfirmContainer = relativeLayout10;
        this.mcdContainer = relativeLayout11;
        this.mcdDisableContainer = relativeLayout12;
        this.mcdEditLocationBtn = button;
        this.mcdInfoTxt = talabatTextView7;
        this.mcdKsaSubContainer = relativeLayout13;
        this.mcdProceedOrder = talabatFillButton3;
        this.mcdSubContainer = relativeLayout14;
        this.menuMapTypeContainer = relativeLayout15;
        this.placesLoadingIndicator = progressBar;
        this.pleaseChooseTxt = talabatTextView8;
        this.preGeoAddressContainer = relativeLayout16;
        this.preGeoLocationContainer = linearLayout10;
        this.preGeoLocationHint = talabatTextView9;
        this.preGeoLocationTxt = talabatTextView10;
        this.preGeoPin = imageView15;
        this.resetToCl = talabatTextView11;
        this.satelliteBtnSubContainer = frameLayout3;
        this.searchContainerCard = cardView4;
        this.searchViewAnchor = view;
        this.searchViewParent = linearLayout11;
        this.showCaseView = relativeLayout17;
        this.skipMapBtn = talabatStrokeButton;
        this.textUserGuideSubTxt = talabatTextView12;
        this.title = talabatToolBarTextView;
        this.toolbar = talabatToolBar;
        this.tutTxt = talabatTextView13;
        this.userGuideGotIt = talabatFillButton4;
        this.yesDeliverHere = talabatTextView14;
    }

    @NonNull
    public static ActivityMapsBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.auto_fill_address;
        TalabatToolBarRelativeLayoutContainer talabatToolBarRelativeLayoutContainer = (TalabatToolBarRelativeLayoutContainer) ViewBindings.findChildViewById(view2, R.id.auto_fill_address);
        if (talabatToolBarRelativeLayoutContainer != null) {
            i11 = R.id.autocomplete_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.autocomplete_layout);
            if (linearLayout != null) {
                i11 = R.id.autofill_description;
                TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.autofill_description);
                if (talabatTextView != null) {
                    i11 = R.id.back;
                    TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view2, R.id.back);
                    if (talabatToolBarImageButton != null) {
                        i11 = R.id.block_no_txt;
                        TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.block_no_txt);
                        if (talabatTextView2 != null) {
                            i11 = R.id.block_section;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.block_section);
                            if (relativeLayout != null) {
                                i11 = R.id.block_section_arrow;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.block_section_arrow);
                                if (imageView != null) {
                                    i11 = R.id.block_spinner;
                                    TalabatSpinner talabatSpinner = (TalabatSpinner) ViewBindings.findChildViewById(view2, R.id.block_spinner);
                                    if (talabatSpinner != null) {
                                        i11 = R.id.block_spinner_container;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.block_spinner_container);
                                        if (relativeLayout2 != null) {
                                            i11 = R.id.block_txt;
                                            TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.block_txt);
                                            if (talabatTextView3 != null) {
                                                i11 = R.id.cancel_button;
                                                TalabatToolBarButton talabatToolBarButton = (TalabatToolBarButton) ViewBindings.findChildViewById(view2, R.id.cancel_button);
                                                if (talabatToolBarButton != null) {
                                                    i11 = R.id.card_gradient;
                                                    CardView cardView = (CardView) ViewBindings.findChildViewById(view2, R.id.card_gradient);
                                                    if (cardView != null) {
                                                        i11 = R.id.clear_text;
                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.clear_text);
                                                        if (imageView2 != null) {
                                                            i11 = R.id.confim;
                                                            TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view2, R.id.confim);
                                                            if (talabatFillButton != null) {
                                                                i11 = R.id.confim_mcd;
                                                                TalabatFillButton talabatFillButton2 = (TalabatFillButton) ViewBindings.findChildViewById(view2, R.id.confim_mcd);
                                                                if (talabatFillButton2 != null) {
                                                                    i11 = R.id.confirm_container;
                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.confirm_container);
                                                                    if (linearLayout2 != null) {
                                                                        i11 = R.id.confirm_view;
                                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.confirm_view);
                                                                        if (relativeLayout3 != null) {
                                                                            i11 = R.id.confirm_view_container;
                                                                            RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.confirm_view_container);
                                                                            if (relativeLayout4 != null) {
                                                                                i11 = R.id.confirms_view;
                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.confirms_view);
                                                                                if (linearLayout4 != null) {
                                                                                    i11 = R.id.current_location_aware_txt;
                                                                                    TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.current_location_aware_txt);
                                                                                    if (talabatTextView4 != null) {
                                                                                        i11 = R.id.custom_button_group;
                                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.custom_button_group);
                                                                                        if (linearLayout5 != null) {
                                                                                            i11 = R.id.darg_close;
                                                                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, R.id.darg_close);
                                                                                            if (imageView3 != null) {
                                                                                                i11 = R.id.delivering_img;
                                                                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, R.id.delivering_img);
                                                                                                if (imageView4 != null) {
                                                                                                    i11 = R.id.drag_tut_container;
                                                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.drag_tut_container);
                                                                                                    if (linearLayout6 != null) {
                                                                                                        i11 = R.id.filter_view;
                                                                                                        CardView cardView2 = (CardView) ViewBindings.findChildViewById(view2, R.id.filter_view);
                                                                                                        if (cardView2 != null) {
                                                                                                            i11 = R.id.gem_footer_view;
                                                                                                            RelativeLayout relativeLayout5 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.gem_footer_view);
                                                                                                            if (relativeLayout5 != null) {
                                                                                                                i11 = R.id.google_place_search_fragment;
                                                                                                                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.google_place_search_fragment);
                                                                                                                if (frameLayout != null) {
                                                                                                                    i11 = R.id.guide_title;
                                                                                                                    TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.guide_title);
                                                                                                                    if (talabatTextView5 != null) {
                                                                                                                        i11 = R.id.imageView5;
                                                                                                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view2, R.id.imageView5);
                                                                                                                        if (imageView6 != null) {
                                                                                                                            i11 = R.id.imageView8;
                                                                                                                            ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view2, R.id.imageView8);
                                                                                                                            if (imageView7 != null) {
                                                                                                                                i11 = R.id.imageView9;
                                                                                                                                ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view2, R.id.imageView9);
                                                                                                                                if (imageView10 != null) {
                                                                                                                                    i11 = R.id.linearLayout3;
                                                                                                                                    LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.linearLayout3);
                                                                                                                                    if (linearLayout7 != null) {
                                                                                                                                        i11 = R.id.loc_awar_container;
                                                                                                                                        RelativeLayout relativeLayout6 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.loc_awar_container);
                                                                                                                                        if (relativeLayout6 != null) {
                                                                                                                                            i11 = R.id.location_awaraness_here_card_view;
                                                                                                                                            CardView cardView3 = (CardView) ViewBindings.findChildViewById(view2, R.id.location_awaraness_here_card_view);
                                                                                                                                            if (cardView3 != null) {
                                                                                                                                                i11 = R.id.location_aware_btn;
                                                                                                                                                LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.location_aware_btn);
                                                                                                                                                if (linearLayout8 != null) {
                                                                                                                                                    i11 = R.id.location_btn;
                                                                                                                                                    ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(view2, R.id.location_btn);
                                                                                                                                                    if (imageView11 != null) {
                                                                                                                                                        i11 = R.id.location_btn_container;
                                                                                                                                                        LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.location_btn_container);
                                                                                                                                                        if (linearLayout9 != null) {
                                                                                                                                                            i11 = R.id.location_btn_sub_container;
                                                                                                                                                            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.location_btn_sub_container);
                                                                                                                                                            if (frameLayout2 != null) {
                                                                                                                                                                i11 = R.id.map_onboarding_contentview;
                                                                                                                                                                RelativeLayout relativeLayout7 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.map_onboarding_contentview);
                                                                                                                                                                if (relativeLayout7 != null) {
                                                                                                                                                                    i11 = R.id.map_pin;
                                                                                                                                                                    ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(view2, R.id.map_pin);
                                                                                                                                                                    if (imageView12 != null) {
                                                                                                                                                                        i11 = R.id.map_toolbar_search;
                                                                                                                                                                        ImageView imageView13 = (ImageView) ViewBindings.findChildViewById(view2, R.id.map_toolbar_search);
                                                                                                                                                                        if (imageView13 != null) {
                                                                                                                                                                            i11 = R.id.map_view_switch_btn;
                                                                                                                                                                            ImageView imageView14 = (ImageView) ViewBindings.findChildViewById(view2, R.id.map_view_switch_btn);
                                                                                                                                                                            if (imageView14 != null) {
                                                                                                                                                                                i11 = R.id.mcd_block_container_title;
                                                                                                                                                                                RelativeLayout relativeLayout8 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.mcd_block_container_title);
                                                                                                                                                                                if (relativeLayout8 != null) {
                                                                                                                                                                                    i11 = R.id.mcd_block_title;
                                                                                                                                                                                    TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.mcd_block_title);
                                                                                                                                                                                    if (talabatTextView6 != null) {
                                                                                                                                                                                        i11 = R.id.mcd_confirm_container;
                                                                                                                                                                                        RelativeLayout relativeLayout9 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.mcd_confirm_container);
                                                                                                                                                                                        if (relativeLayout9 != null) {
                                                                                                                                                                                            i11 = R.id.mcd_container;
                                                                                                                                                                                            RelativeLayout relativeLayout10 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.mcd_container);
                                                                                                                                                                                            if (relativeLayout10 != null) {
                                                                                                                                                                                                i11 = R.id.mcd_disable_container;
                                                                                                                                                                                                RelativeLayout relativeLayout11 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.mcd_disable_container);
                                                                                                                                                                                                if (relativeLayout11 != null) {
                                                                                                                                                                                                    i11 = R.id.mcd_edit_location_btn;
                                                                                                                                                                                                    Button button = (Button) ViewBindings.findChildViewById(view2, R.id.mcd_edit_location_btn);
                                                                                                                                                                                                    if (button != null) {
                                                                                                                                                                                                        i11 = R.id.mcd_info_txt;
                                                                                                                                                                                                        TalabatTextView talabatTextView7 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.mcd_info_txt);
                                                                                                                                                                                                        if (talabatTextView7 != null) {
                                                                                                                                                                                                            i11 = R.id.mcd_ksa_sub_container;
                                                                                                                                                                                                            RelativeLayout relativeLayout12 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.mcd_ksa_sub_container);
                                                                                                                                                                                                            if (relativeLayout12 != null) {
                                                                                                                                                                                                                i11 = R.id.mcd_proceed_order;
                                                                                                                                                                                                                TalabatFillButton talabatFillButton3 = (TalabatFillButton) ViewBindings.findChildViewById(view2, R.id.mcd_proceed_order);
                                                                                                                                                                                                                if (talabatFillButton3 != null) {
                                                                                                                                                                                                                    i11 = R.id.mcd_sub_container;
                                                                                                                                                                                                                    RelativeLayout relativeLayout13 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.mcd_sub_container);
                                                                                                                                                                                                                    if (relativeLayout13 != null) {
                                                                                                                                                                                                                        i11 = R.id.menu_map_type_container;
                                                                                                                                                                                                                        RelativeLayout relativeLayout14 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.menu_map_type_container);
                                                                                                                                                                                                                        if (relativeLayout14 != null) {
                                                                                                                                                                                                                            i11 = R.id.places_loading_indicator;
                                                                                                                                                                                                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.places_loading_indicator);
                                                                                                                                                                                                                            if (progressBar != null) {
                                                                                                                                                                                                                                i11 = R.id.please_choose_txt;
                                                                                                                                                                                                                                TalabatTextView talabatTextView8 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.please_choose_txt);
                                                                                                                                                                                                                                if (talabatTextView8 != null) {
                                                                                                                                                                                                                                    i11 = R.id.pre_geo_address_container;
                                                                                                                                                                                                                                    RelativeLayout relativeLayout15 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.pre_geo_address_container);
                                                                                                                                                                                                                                    if (relativeLayout15 != null) {
                                                                                                                                                                                                                                        i11 = R.id.pre_geo_location_container;
                                                                                                                                                                                                                                        LinearLayout linearLayout10 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.pre_geo_location_container);
                                                                                                                                                                                                                                        if (linearLayout10 != null) {
                                                                                                                                                                                                                                            i11 = R.id.pre_geo_location_hint;
                                                                                                                                                                                                                                            TalabatTextView talabatTextView9 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.pre_geo_location_hint);
                                                                                                                                                                                                                                            if (talabatTextView9 != null) {
                                                                                                                                                                                                                                                i11 = R.id.pre_geo_location_txt;
                                                                                                                                                                                                                                                TalabatTextView talabatTextView10 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.pre_geo_location_txt);
                                                                                                                                                                                                                                                if (talabatTextView10 != null) {
                                                                                                                                                                                                                                                    i11 = R.id.pre_geo_pin;
                                                                                                                                                                                                                                                    ImageView imageView15 = (ImageView) ViewBindings.findChildViewById(view2, R.id.pre_geo_pin);
                                                                                                                                                                                                                                                    if (imageView15 != null) {
                                                                                                                                                                                                                                                        i11 = R.id.reset_to_cl;
                                                                                                                                                                                                                                                        TalabatTextView talabatTextView11 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.reset_to_cl);
                                                                                                                                                                                                                                                        if (talabatTextView11 != null) {
                                                                                                                                                                                                                                                            i11 = R.id.satellite_btn_sub_container;
                                                                                                                                                                                                                                                            FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.satellite_btn_sub_container);
                                                                                                                                                                                                                                                            if (frameLayout3 != null) {
                                                                                                                                                                                                                                                                i11 = R.id.search_container_card;
                                                                                                                                                                                                                                                                CardView cardView4 = (CardView) ViewBindings.findChildViewById(view2, R.id.search_container_card);
                                                                                                                                                                                                                                                                if (cardView4 != null) {
                                                                                                                                                                                                                                                                    i11 = R.id.search_view_anchor;
                                                                                                                                                                                                                                                                    View findChildViewById = ViewBindings.findChildViewById(view2, R.id.search_view_anchor);
                                                                                                                                                                                                                                                                    if (findChildViewById != null) {
                                                                                                                                                                                                                                                                        i11 = R.id.search_view_parent;
                                                                                                                                                                                                                                                                        LinearLayout linearLayout11 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.search_view_parent);
                                                                                                                                                                                                                                                                        if (linearLayout11 != null) {
                                                                                                                                                                                                                                                                            i11 = R.id.show_case_view;
                                                                                                                                                                                                                                                                            RelativeLayout relativeLayout16 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.show_case_view);
                                                                                                                                                                                                                                                                            if (relativeLayout16 != null) {
                                                                                                                                                                                                                                                                                i11 = R.id.skip_map_btn;
                                                                                                                                                                                                                                                                                TalabatStrokeButton talabatStrokeButton = (TalabatStrokeButton) ViewBindings.findChildViewById(view2, R.id.skip_map_btn);
                                                                                                                                                                                                                                                                                if (talabatStrokeButton != null) {
                                                                                                                                                                                                                                                                                    i11 = R.id.text_user_guide_sub_txt;
                                                                                                                                                                                                                                                                                    TalabatTextView talabatTextView12 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.text_user_guide_sub_txt);
                                                                                                                                                                                                                                                                                    if (talabatTextView12 != null) {
                                                                                                                                                                                                                                                                                        i11 = R.id.title;
                                                                                                                                                                                                                                                                                        TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view2, R.id.title);
                                                                                                                                                                                                                                                                                        if (talabatToolBarTextView != null) {
                                                                                                                                                                                                                                                                                            i11 = R.id.toolbar;
                                                                                                                                                                                                                                                                                            TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                                                                                                                                                                                                                                                            if (talabatToolBar != null) {
                                                                                                                                                                                                                                                                                                i11 = R.id.tut_txt;
                                                                                                                                                                                                                                                                                                TalabatTextView talabatTextView13 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tut_txt);
                                                                                                                                                                                                                                                                                                if (talabatTextView13 != null) {
                                                                                                                                                                                                                                                                                                    i11 = R.id.user_guide_got_it;
                                                                                                                                                                                                                                                                                                    TalabatFillButton talabatFillButton4 = (TalabatFillButton) ViewBindings.findChildViewById(view2, R.id.user_guide_got_it);
                                                                                                                                                                                                                                                                                                    if (talabatFillButton4 != null) {
                                                                                                                                                                                                                                                                                                        i11 = R.id.yes_deliver_here;
                                                                                                                                                                                                                                                                                                        TalabatTextView talabatTextView14 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.yes_deliver_here);
                                                                                                                                                                                                                                                                                                        if (talabatTextView14 != null) {
                                                                                                                                                                                                                                                                                                            return new ActivityMapsBinding((RelativeLayout) view2, talabatToolBarRelativeLayoutContainer, linearLayout, talabatTextView, talabatToolBarImageButton, talabatTextView2, relativeLayout, imageView, talabatSpinner, relativeLayout2, talabatTextView3, talabatToolBarButton, cardView, imageView2, talabatFillButton, talabatFillButton2, linearLayout2, relativeLayout3, relativeLayout4, linearLayout4, talabatTextView4, linearLayout5, imageView3, imageView4, linearLayout6, cardView2, relativeLayout5, frameLayout, talabatTextView5, imageView6, imageView7, imageView10, linearLayout7, relativeLayout6, cardView3, linearLayout8, imageView11, linearLayout9, frameLayout2, relativeLayout7, imageView12, imageView13, imageView14, relativeLayout8, talabatTextView6, relativeLayout9, relativeLayout10, relativeLayout11, button, talabatTextView7, relativeLayout12, talabatFillButton3, relativeLayout13, relativeLayout14, progressBar, talabatTextView8, relativeLayout15, linearLayout10, talabatTextView9, talabatTextView10, imageView15, talabatTextView11, frameLayout3, cardView4, findChildViewById, linearLayout11, relativeLayout16, talabatStrokeButton, talabatTextView12, talabatToolBarTextView, talabatToolBar, talabatTextView13, talabatFillButton4, talabatTextView14);
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
    public static ActivityMapsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityMapsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_maps, viewGroup, false);
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
