package library.talabat.mvp.restaurantreview;

import JsonModels.RestaurantReviewResponse;
import JsonModels.ReviewWithRatingModel;
import com.android.volley.VolleyError;
import com.talabat.configuration.discovery.AppVersionProvider;
import datamodels.RatingSection;
import datamodels.RestaurantReview;
import datamodels.RestaurantReviewPaging;

public class RestaurantReviewPresenter implements IRestaurantReviewPresenter, RestaurantReivewListener {
    private int branchId = 0;
    private int pageNumber;
    private RatingSection ratingSection;
    private String reply;
    private IRestaurantReviewInteractor restaurantReviewInteractor;
    private RestaurantReviewView restaurantReviewView;
    private RestaurantReviewPaging[] restaurantReviews;
    private ReviewWithRatingModel reviewWithRatingModel;
    private int totalPages = 0;
    private int totalReviews = 0;

    public RestaurantReviewPresenter(AppVersionProvider appVersionProvider, RestaurantReviewView restaurantReviewView2) {
        this.restaurantReviewView = restaurantReviewView2;
        this.restaurantReviewInteractor = new RestaurantReviewInteractor(appVersionProvider, this);
    }

    public void loadRestaurantReview(int i11, int i12) {
        this.restaurantReviewInteractor.loadRestaurantReview(i11, i12);
        this.branchId = i11;
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
        this.restaurantReviewView.onNetworkError();
    }

    public void onReviewLoadingCompleted(RestaurantReviewResponse restaurantReviewResponse) {
        RestaurantReview restaurantReview = restaurantReviewResponse.result;
        RestaurantReviewPaging[] restaurantReviewPagingArr = restaurantReview.rev;
        this.restaurantReviews = restaurantReviewPagingArr;
        int i11 = restaurantReview.totalPages;
        this.totalPages = i11;
        int i12 = restaurantReview.totalReviews;
        this.totalReviews = i12;
        RatingSection ratingSection2 = restaurantReview.ratingSection;
        this.ratingSection = ratingSection2;
        this.restaurantReviewView.onReviewLoadingCompleted(restaurantReviewPagingArr, i11, i12, ratingSection2, this.reviewWithRatingModel);
    }

    public void onServerError(VolleyError volleyError) {
        this.restaurantReviewView.onServerError(volleyError);
    }
}
