package com.talabat;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.GEMEngine;
import com.talabat.adapters.UserReviewsAdapter;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.di.restaurant.DaggerRestaurantReviewActivityComponent;
import com.talabat.geminterfaces.OnGemAlertDialogClickListener;
import com.talabat.helpers.BaseRatingBar;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.restaurants.RestaurantsListScreenRefactor;
import com.talabat.talabatcommon.helpers.RatingDataMapperV2;
import datamodels.RatingSection;
import datamodels.Restaurant;
import datamodels.RestaurantReview;
import datamodels.RestaurantReviewPaging;
import java.util.ArrayList;
import javax.inject.Inject;
import library.talabat.gemengine.GemView;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.restaurant_review.IRestaurantReviewPresenter;
import library.talabat.mvp.restaurant_review.RestaurantReviewPresenter;
import library.talabat.mvp.restaurant_review.RestaurantReviewView;
import tracking.ScreenNames;
import yq.a;

public class RestaurantReviewActivity extends TalabatBase implements RestaurantReviewView, GemView, OnGemAlertDialogClickListener {
    private ImageButton back;

    /* renamed from: i  reason: collision with root package name */
    public GemFooterCartView f55027i;
    @Inject

    /* renamed from: j  reason: collision with root package name */
    public AppVersionProvider f55028j;
    private UserReviewsAdapter mAdapterReviews;
    private GemDialogSwitcher mGemDialogSwitcher;
    private ProgressBar mProgressBar;
    private BaseRatingBar mRatingBarDeliveryTime;
    private BaseRatingBar mRatingBarFoodQuality;
    private BaseRatingBar mRatingBarMoneyValue;
    private BaseRatingBar mRatingBarPackaging;
    private BaseRatingBar mRatingBarTotal;
    private RecyclerView mRecyclerViewReview;
    private LinearLayout mReviewLayoutMainScreen;
    private TextView mTextViewDeliveryTimeRate;
    private TextView mTextViewFoodQualityRate;
    private TextView mTextViewMoneyValueRate;
    private TextView mTextViewPackagingRate;
    private TextView mTextViewTotalRate;
    private TextView mTextViewTotalRateCount;
    private Toolbar mToolbar;
    private ImageView mVendorRateAvatar;
    private View mViewLoadMore;
    private View mViewNoReviews;
    private View mViewReviews;
    private TextView mvendorTextView;
    private View ratingView;
    /* access modifiers changed from: private */
    public IRestaurantReviewPresenter reviewPresenter;

    public void destroyPresenter() {
    }

    public Context getGemContext() {
        return this;
    }

    public String getGemScreenType() {
        return ScreenNames.getScreenType(getScreenName());
    }

    public IGlobalPresenter getPresenter() {
        return null;
    }

    public String getScreenName() {
        return ScreenNames.RESTAURANTREVIEW;
    }

    public void hideLoadingProgress() {
        this.mProgressBar.setVisibility(8);
        this.mViewLoadMore.setVisibility(0);
    }

    public void inflateGemFooter() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            this.f55027i = new GemFooterCartView();
            if (GEMEngine.getInstance() != null) {
                GEMEngine.getInstance().startListening(this, false);
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up);
            beginTransaction.add((int) R.id.gem_footer_view, (Fragment) this.f55027i, getScreenName());
            beginTransaction.commit();
        }
    }

    public void initializeControls() {
        this.mToolbar = (Toolbar) findViewById(R.id.toolbar);
        this.mReviewLayoutMainScreen = (LinearLayout) findViewById(R.id.review_layout_main);
        this.mRatingBarTotal = (BaseRatingBar) findViewById(R.id.rate_total);
        this.mRatingBarPackaging = (BaseRatingBar) findViewById(R.id.rate_packaging);
        this.mRatingBarMoneyValue = (BaseRatingBar) findViewById(R.id.rate_money_value);
        this.mRatingBarDeliveryTime = (BaseRatingBar) findViewById(R.id.rate_delivery_time);
        this.mRatingBarFoodQuality = (BaseRatingBar) findViewById(R.id.rate_food_quality);
        this.mTextViewTotalRate = (TextView) findViewById(R.id.tv_total_rate);
        this.mTextViewTotalRateCount = (TextView) findViewById(R.id.tv_total_rate_count);
        this.mTextViewPackagingRate = (TextView) findViewById(R.id.tv_packaging_rate);
        this.mTextViewMoneyValueRate = (TextView) findViewById(R.id.tv_money_value_rate);
        this.mTextViewDeliveryTimeRate = (TextView) findViewById(R.id.tv_delivery_time_rate);
        this.mTextViewFoodQualityRate = (TextView) findViewById(R.id.tv_food_quality_rate);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcv_reviews);
        this.mRecyclerViewReview = recyclerView;
        recyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.mRecyclerViewReview.setLayoutManager(linearLayoutManager);
        this.mViewNoReviews = findViewById(R.id.view_no_items);
        this.mViewLoadMore = findViewById(R.id.ll_load_more);
        this.mVendorRateAvatar = (ImageView) findViewById(R.id.vendorRateAvatar);
        this.mvendorTextView = (TextView) findViewById(R.id.vendorRateStatus);
        this.ratingView = findViewById(R.id.rating_view);
        this.mViewLoadMore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RestaurantReviewActivity.this.reviewPresenter.loadMore();
            }
        });
        this.mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        this.mViewReviews = findViewById(R.id.scrollView1);
        if (this.mGemDialogSwitcher == null) {
            this.mGemDialogSwitcher = new GemDialogSwitcher(this, this, getScreenName());
        }
        inflateGemFooter();
    }

    public /* synthetic */ void onAddMoreItemClicked() {
        a.a(this);
    }

    public void onAuthError() {
    }

    public /* synthetic */ void onBackToCheckoutPage(Dialog dialog) {
        a.b(this, dialog);
    }

    public /* synthetic */ void onBackToRestaurantMenuPage(Dialog dialog) {
        a.c(this, dialog);
    }

    public void onBackToRestaurantPage(Dialog dialog) {
        dialog.dismiss();
        finish();
        Intent intent = new Intent(this, RestaurantsListScreenRefactor.class);
        intent.setFlags(67108864);
        startActivity(intent);
    }

    public void onCloseButtonClicked(Dialog dialog) {
        dialog.dismiss();
    }

    public /* synthetic */ void onContinueToCheckout() {
        a.f(this);
    }

    public void onCreate(Bundle bundle) {
        DaggerRestaurantReviewActivityComponent.factory().create((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_restaurant_reviews);
        this.reviewPresenter = new RestaurantReviewPresenter(this.f55028j, this);
        RestaurantReview restaurantReview = GlobalDataModel.REVIEWS.mRestaurantReviews;
        initializeControls();
        if (restaurantReview != null) {
            this.reviewPresenter.setRestaurantReview(restaurantReview);
        } else {
            this.mProgressBar.setVisibility(0);
            this.mViewLoadMore.setVisibility(8);
            this.reviewPresenter.loadRestaurantReview();
        }
        ImageButton imageButton = (ImageButton) findViewById(R.id.back);
        this.back = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RestaurantReviewActivity.this.exitAnimation();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public void onError() {
    }

    public /* synthetic */ void onInterestClicked(Restaurant restaurant) {
        a.g(this, restaurant);
    }

    public void onLeaveOfferClicked(boolean z11) {
        showHideGemFooter(this.f55027i, this, false);
        if (!GlobalDataModel.GEMCONSTANTS.isGemFlow && GlobalDataModel.GEMCONSTANTS.reloadRequired) {
            GlobalDataModel.GEMCONSTANTS.reloadRequired = false;
        }
    }

    public void onLoadReviewsCompleted() {
        hideLoadingProgress();
        showReviewsList();
        showRatingSection();
    }

    public void onNetworkError() {
        this.mProgressBar.setVisibility(8);
        this.mViewLoadMore.setVisibility(0);
        super.onNetworkError();
    }

    public void onNoBranchId() {
        finish();
    }

    public void onNoMorePagesToLoad() {
        this.mViewLoadMore.setVisibility(8);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        menuItem.getItemId();
        return super.onOptionsItemSelected(menuItem);
    }

    public void onPause() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            GEMEngine.getInstance();
            GEMEngine.stopListening();
        }
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        showHideGemFooter(this.f55027i, this, false);
        if (!GlobalDataModel.GEMCONSTANTS.isGemFlow && GlobalDataModel.GEMCONSTANTS.reloadRequired) {
            GlobalDataModel.GEMCONSTANTS.reloadRequired = false;
        }
    }

    public /* synthetic */ void showGemDialog() {
        v00.a.a(this);
    }

    public void showInAppReminder(int i11) {
        Context context = getContext();
        String string = getResources().getString(R.string.gem_order_notification);
        Toast.makeText(context, string.replace("#", "" + i11), 0).show();
    }

    public void showLoadingProgress() {
        this.mProgressBar.setVisibility(0);
        this.mViewLoadMore.setVisibility(8);
    }

    public void showRatingSection() {
        RatingSection ratingSection = this.reviewPresenter.getRatingSection();
        if (ratingSection == null || this.reviewPresenter.getTotalRate() <= 0.0f) {
            this.ratingView.setVisibility(8);
            return;
        }
        this.ratingView.setVisibility(0);
        this.mViewReviews.setVisibility(0);
        this.mViewNoReviews.setVisibility(8);
        this.mRatingBarTotal.setRating(this.reviewPresenter.getTotalRate());
        this.mTextViewTotalRate.setText(String.valueOf(this.reviewPresenter.getTotalRate()));
        this.mTextViewTotalRateCount.setText(getString(R.string.based_on_reviews, new Object[]{String.valueOf(this.reviewPresenter.getTotalRateNumber())}));
        this.mTextViewDeliveryTimeRate.setText(String.valueOf(ratingSection.deliveryRating));
        this.mRatingBarDeliveryTime.setRating(ratingSection.deliveryRating);
        this.mTextViewFoodQualityRate.setText(String.valueOf(ratingSection.qualityRating));
        this.mRatingBarFoodQuality.setRating(ratingSection.qualityRating);
        this.mTextViewPackagingRate.setText(String.valueOf(ratingSection.packageRating));
        this.mRatingBarPackaging.setRating(ratingSection.packageRating);
        this.mTextViewMoneyValueRate.setText(String.valueOf(ratingSection.valueRating));
        this.mRatingBarMoneyValue.setRating(ratingSection.valueRating);
        float totalRate = this.reviewPresenter.getTotalRate();
        ImageView imageView = this.mVendorRateAvatar;
        RatingDataMapperV2 ratingDataMapperV2 = RatingDataMapperV2.INSTANCE;
        imageView.setImageResource(ratingDataMapperV2.drawableResourceFromRating(totalRate));
        this.mvendorTextView.setText(getResources().getString(ratingDataMapperV2.textFromRating(totalRate)));
        if (TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.CAN_SHOW_STAR_RATING, false, TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
            this.mvendorTextView.setVisibility(8);
            this.mVendorRateAvatar.setVisibility(8);
            this.mRatingBarTotal.setVisibility(0);
            this.mTextViewTotalRate.setVisibility(0);
        }
    }

    public void showReviewsList() {
        ArrayList<RestaurantReviewPaging> restaurantReviewsPages = this.reviewPresenter.getRestaurantReviewsPages();
        if (restaurantReviewsPages == null || restaurantReviewsPages.size() <= 0) {
            this.mViewNoReviews.setVisibility(0);
            this.mViewReviews.setVisibility(8);
            this.mReviewLayoutMainScreen.setVisibility(8);
            return;
        }
        this.mViewReviews.setVisibility(0);
        this.mViewNoReviews.setVisibility(8);
        this.mRecyclerViewReview.setVisibility(0);
        this.mReviewLayoutMainScreen.setVisibility(0);
        UserReviewsAdapter userReviewsAdapter = this.mAdapterReviews;
        if (userReviewsAdapter == null) {
            UserReviewsAdapter userReviewsAdapter2 = new UserReviewsAdapter(this, restaurantReviewsPages, this.reviewPresenter.getRestaurantName());
            this.mAdapterReviews = userReviewsAdapter2;
            this.mRecyclerViewReview.setAdapter(userReviewsAdapter2);
            return;
        }
        userReviewsAdapter.notifyDataSetChanged();
    }

    public void showTimeOutDialog() {
        if (this.mGemDialogSwitcher.isDialogShowing()) {
            onCloseButtonClicked(this.mGemDialogSwitcher.dialog);
        }
        showGemTimeOutDialog(this.mGemDialogSwitcher, this.f55027i, this, this);
    }

    public void showTimerView(boolean z11, String str) {
        this.f55027i.setTimerText(str);
    }

    public /* synthetic */ void stopLoading() {
        v00.a.e(this);
    }
}
