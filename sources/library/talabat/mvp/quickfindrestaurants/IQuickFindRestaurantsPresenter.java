package library.talabat.mvp.quickfindrestaurants;

import datamodels.QuickRestaurant;
import library.talabat.mvp.IGlobalPresenter;

public interface IQuickFindRestaurantsPresenter extends IGlobalPresenter {
    void loadAllRestaurants();

    void setRestaurantSelected(QuickRestaurant quickRestaurant);

    void typingCancelled();

    void typingStarted();
}
