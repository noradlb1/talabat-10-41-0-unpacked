package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.volley.toolbox.NetworkImageView;
import com.google.android.flexbox.FlexboxLayout;
import com.materialedittext.MaterialEditText;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.helpers.BaseRatingBar;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class RateMyOrderScreenBinding implements ViewBinding {
    @NonNull
    public final TalabatToolBarImageButton back;
    @NonNull
    public final CardView cardViewRateDriverContainer;
    @NonNull
    public final BaseRatingBar deliveryRating;
    @NonNull
    public final TalabatTextView deliveryTimeTag;
    @NonNull
    public final TalabatTextView driverRateingHeader;
    @NonNull
    public final MaterialEditText editTextRateDriver;
    @NonNull
    public final FlexboxLayout flexBoxRateDriverTags;
    @NonNull
    public final LinearLayout linearLayoutRateDriverContainer;
    @NonNull
    public final LinearLayout linearLayoutRateDriverImproveContainer;
    @NonNull
    public final LinearLayout linearLayoutSuggestionContainer;
    @NonNull
    public final NestedScrollView nestedScrollview;
    @NonNull
    public final BaseRatingBar packagingRating;
    @NonNull
    public final TalabatTextView packingTag;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    public final TalabatTextView qualityFoodTag;
    @NonNull
    public final RecyclerView rateMyOrderFoodList;
    @NonNull
    public final RelativeLayout rateMyOrderLogoView;
    @NonNull
    public final TalabatTextView rateMyOrderOrderId;
    @NonNull
    public final TalabatTextView rateMyOrderOrderTime;
    @NonNull
    public final NetworkImageView rateMyOrderRestLogo;
    @NonNull
    public final TalabatTextView rateMyOrderRestaurantName;
    @NonNull
    public final TalabatTextView rateMyOrderStatus;
    @NonNull
    public final TalabatFillButton rateMyOrderSubmit;
    @NonNull
    public final CardView ratedView;
    @NonNull
    public final BaseRatingBar ratingBarDriverPerformance;
    @NonNull
    public final MaterialEditText reviewEditText;
    @NonNull
    public final LinearLayout reviewEditView;
    @NonNull
    public final TalabatTextView reviewHeader;
    @NonNull
    public final FlexboxLayout reviewSuggestion;
    @NonNull
    public final TalabatTextView reviewText;
    @NonNull
    public final CardView reviewTextView;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TalabatTextView talabatTextView3;
    @NonNull
    public final TalabatTextView textViewDriverReview;
    @NonNull
    public final TalabatTextView textViewRateDriverOptional;
    @NonNull
    public final TalabatTextView textViewStarStatus;
    @NonNull
    public final TalabatToolBarTextView title;
    @NonNull
    public final TalabatToolBar toolbar;
    @NonNull
    public final FrameLayout underline;
    @NonNull
    public final BaseRatingBar valueForMoneyRating;
    @NonNull
    public final TalabatTextView valueOfMoneyTag;

    private RateMyOrderScreenBinding(@NonNull LinearLayout linearLayout, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull CardView cardView, @NonNull BaseRatingBar baseRatingBar, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull MaterialEditText materialEditText, @NonNull FlexboxLayout flexboxLayout, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull NestedScrollView nestedScrollView, @NonNull BaseRatingBar baseRatingBar2, @NonNull TalabatTextView talabatTextView4, @NonNull ProgressBar progressBar2, @NonNull TalabatTextView talabatTextView5, @NonNull RecyclerView recyclerView, @NonNull RelativeLayout relativeLayout, @NonNull TalabatTextView talabatTextView6, @NonNull TalabatTextView talabatTextView7, @NonNull NetworkImageView networkImageView, @NonNull TalabatTextView talabatTextView8, @NonNull TalabatTextView talabatTextView9, @NonNull TalabatFillButton talabatFillButton, @NonNull CardView cardView2, @NonNull BaseRatingBar baseRatingBar3, @NonNull MaterialEditText materialEditText2, @NonNull LinearLayout linearLayout5, @NonNull TalabatTextView talabatTextView10, @NonNull FlexboxLayout flexboxLayout2, @NonNull TalabatTextView talabatTextView11, @NonNull CardView cardView3, @NonNull TalabatTextView talabatTextView12, @NonNull TalabatTextView talabatTextView13, @NonNull TalabatTextView talabatTextView14, @NonNull TalabatTextView talabatTextView15, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull TalabatToolBar talabatToolBar, @NonNull FrameLayout frameLayout, @NonNull BaseRatingBar baseRatingBar4, @NonNull TalabatTextView talabatTextView16) {
        this.rootView = linearLayout;
        this.back = talabatToolBarImageButton;
        this.cardViewRateDriverContainer = cardView;
        this.deliveryRating = baseRatingBar;
        this.deliveryTimeTag = talabatTextView;
        this.driverRateingHeader = talabatTextView2;
        this.editTextRateDriver = materialEditText;
        this.flexBoxRateDriverTags = flexboxLayout;
        this.linearLayoutRateDriverContainer = linearLayout2;
        this.linearLayoutRateDriverImproveContainer = linearLayout3;
        this.linearLayoutSuggestionContainer = linearLayout4;
        this.nestedScrollview = nestedScrollView;
        this.packagingRating = baseRatingBar2;
        this.packingTag = talabatTextView4;
        this.progressBar = progressBar2;
        this.qualityFoodTag = talabatTextView5;
        this.rateMyOrderFoodList = recyclerView;
        this.rateMyOrderLogoView = relativeLayout;
        this.rateMyOrderOrderId = talabatTextView6;
        this.rateMyOrderOrderTime = talabatTextView7;
        this.rateMyOrderRestLogo = networkImageView;
        this.rateMyOrderRestaurantName = talabatTextView8;
        this.rateMyOrderStatus = talabatTextView9;
        this.rateMyOrderSubmit = talabatFillButton;
        this.ratedView = cardView2;
        this.ratingBarDriverPerformance = baseRatingBar3;
        this.reviewEditText = materialEditText2;
        this.reviewEditView = linearLayout5;
        this.reviewHeader = talabatTextView10;
        this.reviewSuggestion = flexboxLayout2;
        this.reviewText = talabatTextView11;
        this.reviewTextView = cardView3;
        this.talabatTextView3 = talabatTextView12;
        this.textViewDriverReview = talabatTextView13;
        this.textViewRateDriverOptional = talabatTextView14;
        this.textViewStarStatus = talabatTextView15;
        this.title = talabatToolBarTextView;
        this.toolbar = talabatToolBar;
        this.underline = frameLayout;
        this.valueForMoneyRating = baseRatingBar4;
        this.valueOfMoneyTag = talabatTextView16;
    }

    @NonNull
    public static RateMyOrderScreenBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.back;
        TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view2, R.id.back);
        if (talabatToolBarImageButton != null) {
            i11 = R.id.cardView_rateDriverContainer;
            CardView cardView = (CardView) ViewBindings.findChildViewById(view2, R.id.cardView_rateDriverContainer);
            if (cardView != null) {
                i11 = R.id.delivery_rating;
                BaseRatingBar baseRatingBar = (BaseRatingBar) ViewBindings.findChildViewById(view2, R.id.delivery_rating);
                if (baseRatingBar != null) {
                    i11 = R.id.deliveryTimeTag;
                    TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.deliveryTimeTag);
                    if (talabatTextView != null) {
                        i11 = R.id.driver_rateing_header;
                        TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.driver_rateing_header);
                        if (talabatTextView2 != null) {
                            i11 = R.id.editText_rateDriver;
                            MaterialEditText materialEditText = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.editText_rateDriver);
                            if (materialEditText != null) {
                                i11 = R.id.flexBox_rateDriverTags;
                                FlexboxLayout flexboxLayout = (FlexboxLayout) ViewBindings.findChildViewById(view2, R.id.flexBox_rateDriverTags);
                                if (flexboxLayout != null) {
                                    i11 = R.id.linearLayout_rateDriverContainer;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.linearLayout_rateDriverContainer);
                                    if (linearLayout != null) {
                                        i11 = R.id.linearLayout_rateDriverImproveContainer;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.linearLayout_rateDriverImproveContainer);
                                        if (linearLayout2 != null) {
                                            i11 = R.id.linearLayout_suggestionContainer;
                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.linearLayout_suggestionContainer);
                                            if (linearLayout3 != null) {
                                                i11 = R.id.nested_scrollview;
                                                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view2, R.id.nested_scrollview);
                                                if (nestedScrollView != null) {
                                                    i11 = R.id.packaging_rating;
                                                    BaseRatingBar baseRatingBar2 = (BaseRatingBar) ViewBindings.findChildViewById(view2, R.id.packaging_rating);
                                                    if (baseRatingBar2 != null) {
                                                        i11 = R.id.packingTag;
                                                        TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.packingTag);
                                                        if (talabatTextView4 != null) {
                                                            i11 = R.id.progressBar;
                                                            ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.progressBar);
                                                            if (progressBar2 != null) {
                                                                i11 = R.id.qualityFoodTag;
                                                                TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.qualityFoodTag);
                                                                if (talabatTextView5 != null) {
                                                                    i11 = R.id.rate_my_order_food_list;
                                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.rate_my_order_food_list);
                                                                    if (recyclerView != null) {
                                                                        i11 = R.id.rate_my_order_logo_view;
                                                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.rate_my_order_logo_view);
                                                                        if (relativeLayout != null) {
                                                                            i11 = R.id.rate_my_order_orderId;
                                                                            TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.rate_my_order_orderId);
                                                                            if (talabatTextView6 != null) {
                                                                                i11 = R.id.rate_my_order_order_time;
                                                                                TalabatTextView talabatTextView7 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.rate_my_order_order_time);
                                                                                if (talabatTextView7 != null) {
                                                                                    i11 = R.id.rate_my_order_rest_logo;
                                                                                    NetworkImageView networkImageView = (NetworkImageView) ViewBindings.findChildViewById(view2, R.id.rate_my_order_rest_logo);
                                                                                    if (networkImageView != null) {
                                                                                        i11 = R.id.rate_my_order_restaurant_name;
                                                                                        TalabatTextView talabatTextView8 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.rate_my_order_restaurant_name);
                                                                                        if (talabatTextView8 != null) {
                                                                                            i11 = R.id.rate_my_order_status;
                                                                                            TalabatTextView talabatTextView9 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.rate_my_order_status);
                                                                                            if (talabatTextView9 != null) {
                                                                                                i11 = R.id.rate_my_order_submit;
                                                                                                TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view2, R.id.rate_my_order_submit);
                                                                                                if (talabatFillButton != null) {
                                                                                                    i11 = R.id.rated_view;
                                                                                                    CardView cardView2 = (CardView) ViewBindings.findChildViewById(view2, R.id.rated_view);
                                                                                                    if (cardView2 != null) {
                                                                                                        i11 = R.id.ratingBar_driverPerformance;
                                                                                                        BaseRatingBar baseRatingBar3 = (BaseRatingBar) ViewBindings.findChildViewById(view2, R.id.ratingBar_driverPerformance);
                                                                                                        if (baseRatingBar3 != null) {
                                                                                                            i11 = R.id.review_editText;
                                                                                                            MaterialEditText materialEditText2 = (MaterialEditText) ViewBindings.findChildViewById(view2, R.id.review_editText);
                                                                                                            if (materialEditText2 != null) {
                                                                                                                i11 = R.id.review_edit_view;
                                                                                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.review_edit_view);
                                                                                                                if (linearLayout4 != null) {
                                                                                                                    i11 = R.id.review_header;
                                                                                                                    TalabatTextView talabatTextView10 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.review_header);
                                                                                                                    if (talabatTextView10 != null) {
                                                                                                                        i11 = R.id.reviewSuggestion;
                                                                                                                        FlexboxLayout flexboxLayout2 = (FlexboxLayout) ViewBindings.findChildViewById(view2, R.id.reviewSuggestion);
                                                                                                                        if (flexboxLayout2 != null) {
                                                                                                                            i11 = R.id.review_text;
                                                                                                                            TalabatTextView talabatTextView11 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.review_text);
                                                                                                                            if (talabatTextView11 != null) {
                                                                                                                                i11 = R.id.review_text_view;
                                                                                                                                CardView cardView3 = (CardView) ViewBindings.findChildViewById(view2, R.id.review_text_view);
                                                                                                                                if (cardView3 != null) {
                                                                                                                                    i11 = R.id.talabatTextView3;
                                                                                                                                    TalabatTextView talabatTextView12 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.talabatTextView3);
                                                                                                                                    if (talabatTextView12 != null) {
                                                                                                                                        i11 = R.id.textView_driverReview;
                                                                                                                                        TalabatTextView talabatTextView13 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.textView_driverReview);
                                                                                                                                        if (talabatTextView13 != null) {
                                                                                                                                            i11 = R.id.textView_rateDriverOptional;
                                                                                                                                            TalabatTextView talabatTextView14 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.textView_rateDriverOptional);
                                                                                                                                            if (talabatTextView14 != null) {
                                                                                                                                                i11 = R.id.textView_starStatus;
                                                                                                                                                TalabatTextView talabatTextView15 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.textView_starStatus);
                                                                                                                                                if (talabatTextView15 != null) {
                                                                                                                                                    i11 = R.id.title;
                                                                                                                                                    TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view2, R.id.title);
                                                                                                                                                    if (talabatToolBarTextView != null) {
                                                                                                                                                        i11 = R.id.toolbar;
                                                                                                                                                        TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                                                                                                                        if (talabatToolBar != null) {
                                                                                                                                                            i11 = R.id.underline;
                                                                                                                                                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, R.id.underline);
                                                                                                                                                            if (frameLayout != null) {
                                                                                                                                                                i11 = R.id.value_for_money_rating;
                                                                                                                                                                BaseRatingBar baseRatingBar4 = (BaseRatingBar) ViewBindings.findChildViewById(view2, R.id.value_for_money_rating);
                                                                                                                                                                if (baseRatingBar4 != null) {
                                                                                                                                                                    i11 = R.id.valueOfMoneyTag;
                                                                                                                                                                    TalabatTextView talabatTextView16 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.valueOfMoneyTag);
                                                                                                                                                                    if (talabatTextView16 != null) {
                                                                                                                                                                        return new RateMyOrderScreenBinding((LinearLayout) view2, talabatToolBarImageButton, cardView, baseRatingBar, talabatTextView, talabatTextView2, materialEditText, flexboxLayout, linearLayout, linearLayout2, linearLayout3, nestedScrollView, baseRatingBar2, talabatTextView4, progressBar2, talabatTextView5, recyclerView, relativeLayout, talabatTextView6, talabatTextView7, networkImageView, talabatTextView8, talabatTextView9, talabatFillButton, cardView2, baseRatingBar3, materialEditText2, linearLayout4, talabatTextView10, flexboxLayout2, talabatTextView11, cardView3, talabatTextView12, talabatTextView13, talabatTextView14, talabatTextView15, talabatToolBarTextView, talabatToolBar, frameLayout, baseRatingBar4, talabatTextView16);
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
    public static RateMyOrderScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static RateMyOrderScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.rate_my_order_screen, viewGroup, false);
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
