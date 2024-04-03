package library.talabat.mvp.restaurant_review;

import JsonModels.RestaurantReviewResponse;
import android.util.Log;
import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.helpers.GlobalDataModel;
import datamodels.RatingSection;
import datamodels.RestaurantReview;
import datamodels.RestaurantReviewPaging;
import java.util.ArrayList;
import java.util.Arrays;

public class RestaurantReviewPresenter implements IRestaurantReviewPresenter, RestaurantReivewListener {
    private ArrayList<RestaurantReviewPaging> loadedRestaurantReviewPages;
    private int mBranchId = 0;
    private boolean mLoading = true;
    private int mPageNumber = 1;
    private int mPreviousTotal;
    private RatingSection mRatingSection;
    private int mTotalPages = 0;
    private IRestaurantReviewInteractor restaurantReviewInteractor;
    private RestaurantReviewView restaurantReviewView;

    public RestaurantReviewPresenter(AppVersionProvider appVersionProvider, RestaurantReviewView restaurantReviewView2) {
        this.restaurantReviewView = restaurantReviewView2;
        this.restaurantReviewInteractor = new RestaurantReviewInteractor(appVersionProvider, this);
        this.loadedRestaurantReviewPages = new ArrayList<>();
    }

    private void updateUi() {
        this.restaurantReviewView.onLoadReviewsCompleted();
        if (this.mPageNumber == this.mTotalPages) {
            this.restaurantReviewView.onNoMorePagesToLoad();
        }
    }

    public int getBranchId() {
        if (GlobalDataModel.SELECTED.getRestaurant() == null) {
            return -1;
        }
        int i11 = GlobalDataModel.SELECTED.restaurant.branchId;
        this.mBranchId = i11;
        if (i11 <= 0) {
            this.restaurantReviewView.onNoBranchId();
        }
        return this.mBranchId;
    }

    public RatingSection getRatingSection() {
        return this.mRatingSection;
    }

    public String getRestaurantName() {
        if (GlobalDataModel.SELECTED.getRestaurant() == null) {
            this.restaurantReviewView.onNoBranchId();
        }
        return GlobalDataModel.SELECTED.restaurant.getName();
    }

    public ArrayList<RestaurantReviewPaging> getRestaurantReviewsPages() {
        return this.loadedRestaurantReviewPages;
    }

    public float getTotalRate() {
        if (GlobalDataModel.SELECTED.getRestaurant() == null) {
            this.restaurantReviewView.onNoBranchId();
        }
        return GlobalDataModel.SELECTED.restaurant.getRating();
    }

    public String getTotalRateNumber() {
        if (GlobalDataModel.SELECTED.getRestaurant() == null) {
            this.restaurantReviewView.onNoBranchId();
        }
        return GlobalDataModel.SELECTED.restaurant.getTotalRating();
    }

    public void loadMore() {
        int size = this.loadedRestaurantReviewPages.size();
        if (this.mLoading && size > this.mPreviousTotal) {
            this.mLoading = false;
            this.mPreviousTotal = size;
            this.mPageNumber++;
        }
        if (this.mPageNumber <= this.mTotalPages) {
            Log.i("a", "here1");
            loadRestaurantReview();
            this.mLoading = true;
        }
    }

    public void loadRestaurantReview() {
        if (this.mBranchId == 0) {
            getBranchId();
        }
        this.restaurantReviewView.showLoadingProgress();
        this.restaurantReviewInteractor.loadRestaurantReview(this.mBranchId, this.mPageNumber);
    }

    public void onDataError() {
        this.restaurantReviewView.onDataError();
    }

    public void onDestroy() {
        this.restaurantReviewView = null;
        IRestaurantReviewInteractor iRestaurantReviewInteractor = this.restaurantReviewInteractor;
        if (iRestaurantReviewInteractor != null) {
            iRestaurantReviewInteractor.unregister();
        }
        this.restaurantReviewInteractor = null;
    }

    public void onNetworkError() {
        this.mLoading = false;
        this.restaurantReviewView.onNetworkError();
    }

    public void onReviewLoadingCompleted(RestaurantReviewResponse restaurantReviewResponse) {
        setRestaurantReview(restaurantReviewResponse.result);
    }

    public void onServerError(VolleyError volleyError) {
        this.restaurantReviewView.onServerError(volleyError);
    }

    public void setRestaurantReview(RestaurantReview restaurantReview) {
        RestaurantReviewPaging[] restaurantReviewPagingArr = restaurantReview.rev;
        if (restaurantReviewPagingArr != null && restaurantReviewPagingArr.length > 0) {
            this.loadedRestaurantReviewPages.addAll(Arrays.asList(restaurantReviewPagingArr));
        }
        this.mTotalPages = restaurantReview.totalPages;
        this.mRatingSection = restaurantReview.ratingSection;
        updateUi();
    }
}
