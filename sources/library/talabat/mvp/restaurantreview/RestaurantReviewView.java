package library.talabat.mvp.restaurantreview;

import JsonModels.ReviewWithRatingModel;
import com.talabat.helpers.Talabat;
import datamodels.RatingSection;
import datamodels.RestaurantReviewPaging;

public interface RestaurantReviewView extends Talabat {
    void onReviewLoadingCompleted(RestaurantReviewPaging[] restaurantReviewPagingArr, int i11, int i12, RatingSection ratingSection, ReviewWithRatingModel reviewWithRatingModel);
}
