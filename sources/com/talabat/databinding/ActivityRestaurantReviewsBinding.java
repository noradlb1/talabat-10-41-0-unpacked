package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.helpers.BaseRatingBar;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarTextView;

public final class ActivityRestaurantReviewsBinding implements ViewBinding {
    @NonNull
    public final TalabatToolBarImageButton back;
    @NonNull
    public final RelativeLayout gemFooterView;
    @NonNull
    public final ImageView ivNoItems;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    public final BaseRatingBar rateDeliveryTime;
    @NonNull
    public final BaseRatingBar rateFoodQuality;
    @NonNull
    public final BaseRatingBar rateMoneyValue;
    @NonNull
    public final BaseRatingBar ratePackaging;
    @NonNull
    public final BaseRatingBar rateTotal;
    @NonNull
    public final LinearLayout ratingView;
    @NonNull
    public final RecyclerView rcvReviews;
    @NonNull
    public final LinearLayout reviewLayoutMain;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final NestedScrollView scrollView1;
    @NonNull
    public final RelativeLayout talabatToolbar;
    @NonNull
    public final TalabatToolBar toolbar;
    @NonNull
    public final TalabatTextView tvDeliveryTimeRate;
    @NonNull
    public final TalabatTextView tvFoodQualityRate;
    @NonNull
    public final TalabatTextView tvMoneyValueRate;
    @NonNull
    public final TalabatTextView tvPackagingRate;
    @NonNull
    public final TalabatToolBarTextView tvTitle;
    @NonNull
    public final TalabatTextView tvTotalRate;
    @NonNull
    public final TalabatTextView tvTotalRateCount;
    @NonNull
    public final ImageView vendorRateAvatar;
    @NonNull
    public final TextView vendorRateStatus;
    @NonNull
    public final LinearLayout viewNoItems;

    private ActivityRestaurantReviewsBinding(@NonNull RelativeLayout relativeLayout, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView, @NonNull ProgressBar progressBar2, @NonNull BaseRatingBar baseRatingBar, @NonNull BaseRatingBar baseRatingBar2, @NonNull BaseRatingBar baseRatingBar3, @NonNull BaseRatingBar baseRatingBar4, @NonNull BaseRatingBar baseRatingBar5, @NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView, @NonNull LinearLayout linearLayout2, @NonNull NestedScrollView nestedScrollView, @NonNull RelativeLayout relativeLayout3, @NonNull TalabatToolBar talabatToolBar, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatTextView talabatTextView4, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull TalabatTextView talabatTextView5, @NonNull TalabatTextView talabatTextView6, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull LinearLayout linearLayout3) {
        this.rootView = relativeLayout;
        this.back = talabatToolBarImageButton;
        this.gemFooterView = relativeLayout2;
        this.ivNoItems = imageView;
        this.progressBar = progressBar2;
        this.rateDeliveryTime = baseRatingBar;
        this.rateFoodQuality = baseRatingBar2;
        this.rateMoneyValue = baseRatingBar3;
        this.ratePackaging = baseRatingBar4;
        this.rateTotal = baseRatingBar5;
        this.ratingView = linearLayout;
        this.rcvReviews = recyclerView;
        this.reviewLayoutMain = linearLayout2;
        this.scrollView1 = nestedScrollView;
        this.talabatToolbar = relativeLayout3;
        this.toolbar = talabatToolBar;
        this.tvDeliveryTimeRate = talabatTextView;
        this.tvFoodQualityRate = talabatTextView2;
        this.tvMoneyValueRate = talabatTextView3;
        this.tvPackagingRate = talabatTextView4;
        this.tvTitle = talabatToolBarTextView;
        this.tvTotalRate = talabatTextView5;
        this.tvTotalRateCount = talabatTextView6;
        this.vendorRateAvatar = imageView2;
        this.vendorRateStatus = textView;
        this.viewNoItems = linearLayout3;
    }

    @NonNull
    public static ActivityRestaurantReviewsBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.back;
        TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view2, R.id.back);
        if (talabatToolBarImageButton != null) {
            i11 = R.id.gem_footer_view;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.gem_footer_view);
            if (relativeLayout != null) {
                i11 = R.id.iv_no_items;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.iv_no_items);
                if (imageView != null) {
                    i11 = R.id.progress_bar;
                    ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.progress_bar);
                    if (progressBar2 != null) {
                        i11 = R.id.rate_delivery_time;
                        BaseRatingBar baseRatingBar = (BaseRatingBar) ViewBindings.findChildViewById(view2, R.id.rate_delivery_time);
                        if (baseRatingBar != null) {
                            i11 = R.id.rate_food_quality;
                            BaseRatingBar baseRatingBar2 = (BaseRatingBar) ViewBindings.findChildViewById(view2, R.id.rate_food_quality);
                            if (baseRatingBar2 != null) {
                                i11 = R.id.rate_money_value;
                                BaseRatingBar baseRatingBar3 = (BaseRatingBar) ViewBindings.findChildViewById(view2, R.id.rate_money_value);
                                if (baseRatingBar3 != null) {
                                    i11 = R.id.rate_packaging;
                                    BaseRatingBar baseRatingBar4 = (BaseRatingBar) ViewBindings.findChildViewById(view2, R.id.rate_packaging);
                                    if (baseRatingBar4 != null) {
                                        i11 = R.id.rate_total;
                                        BaseRatingBar baseRatingBar5 = (BaseRatingBar) ViewBindings.findChildViewById(view2, R.id.rate_total);
                                        if (baseRatingBar5 != null) {
                                            i11 = R.id.rating_view;
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.rating_view);
                                            if (linearLayout != null) {
                                                i11 = R.id.rcv_reviews;
                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, R.id.rcv_reviews);
                                                if (recyclerView != null) {
                                                    i11 = R.id.review_layout_main;
                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.review_layout_main);
                                                    if (linearLayout2 != null) {
                                                        i11 = R.id.scrollView1;
                                                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view2, R.id.scrollView1);
                                                        if (nestedScrollView != null) {
                                                            i11 = R.id.talabat_toolbar;
                                                            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.talabat_toolbar);
                                                            if (relativeLayout2 != null) {
                                                                i11 = R.id.toolbar;
                                                                TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                                if (talabatToolBar != null) {
                                                                    i11 = R.id.tv_delivery_time_rate;
                                                                    TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tv_delivery_time_rate);
                                                                    if (talabatTextView != null) {
                                                                        i11 = R.id.tv_food_quality_rate;
                                                                        TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tv_food_quality_rate);
                                                                        if (talabatTextView2 != null) {
                                                                            i11 = R.id.tv_money_value_rate;
                                                                            TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tv_money_value_rate);
                                                                            if (talabatTextView3 != null) {
                                                                                i11 = R.id.tv_packaging_rate;
                                                                                TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tv_packaging_rate);
                                                                                if (talabatTextView4 != null) {
                                                                                    i11 = R.id.tv_title;
                                                                                    TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view2, R.id.tv_title);
                                                                                    if (talabatToolBarTextView != null) {
                                                                                        i11 = R.id.tv_total_rate;
                                                                                        TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tv_total_rate);
                                                                                        if (talabatTextView5 != null) {
                                                                                            i11 = R.id.tv_total_rate_count;
                                                                                            TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.tv_total_rate_count);
                                                                                            if (talabatTextView6 != null) {
                                                                                                i11 = R.id.vendorRateAvatar;
                                                                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, R.id.vendorRateAvatar);
                                                                                                if (imageView2 != null) {
                                                                                                    i11 = R.id.vendorRateStatus;
                                                                                                    TextView textView = (TextView) ViewBindings.findChildViewById(view2, R.id.vendorRateStatus);
                                                                                                    if (textView != null) {
                                                                                                        i11 = R.id.view_no_items;
                                                                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, R.id.view_no_items);
                                                                                                        if (linearLayout3 != null) {
                                                                                                            return new ActivityRestaurantReviewsBinding((RelativeLayout) view2, talabatToolBarImageButton, relativeLayout, imageView, progressBar2, baseRatingBar, baseRatingBar2, baseRatingBar3, baseRatingBar4, baseRatingBar5, linearLayout, recyclerView, linearLayout2, nestedScrollView, relativeLayout2, talabatToolBar, talabatTextView, talabatTextView2, talabatTextView3, talabatTextView4, talabatToolBarTextView, talabatTextView5, talabatTextView6, imageView2, textView, linearLayout3);
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
    public static ActivityRestaurantReviewsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityRestaurantReviewsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_restaurant_reviews, viewGroup, false);
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
