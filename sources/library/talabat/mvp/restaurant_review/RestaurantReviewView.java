package library.talabat.mvp.restaurant_review;

import com.talabat.helpers.Talabat;

public interface RestaurantReviewView extends Talabat {
    void hideLoadingProgress();

    void onLoadReviewsCompleted();

    void onNoBranchId();

    void onNoMorePagesToLoad();

    void showLoadingProgress();
}
