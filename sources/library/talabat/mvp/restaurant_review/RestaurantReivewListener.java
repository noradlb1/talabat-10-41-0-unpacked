package library.talabat.mvp.restaurant_review;

import JsonModels.RestaurantReviewResponse;
import library.talabat.mvp.IGlobalListener;

public interface RestaurantReivewListener extends IGlobalListener {
    void onReviewLoadingCompleted(RestaurantReviewResponse restaurantReviewResponse);
}
