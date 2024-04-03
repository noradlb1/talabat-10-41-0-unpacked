package library.talabat.mvp.restaurant_review;

import datamodels.RatingSection;
import datamodels.RestaurantReview;
import datamodels.RestaurantReviewPaging;
import java.util.ArrayList;
import library.talabat.mvp.IGlobalPresenter;

public interface IRestaurantReviewPresenter extends IGlobalPresenter {
    RatingSection getRatingSection();

    String getRestaurantName();

    ArrayList<RestaurantReviewPaging> getRestaurantReviewsPages();

    float getTotalRate();

    String getTotalRateNumber();

    void loadMore();

    void loadRestaurantReview();

    void setRestaurantReview(RestaurantReview restaurantReview);
}
