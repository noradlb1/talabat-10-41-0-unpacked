package library.talabat.mvp.restaurantlist;

import android.content.Context;
import datamodels.Restaurant;
import library.talabat.mvp.IGlobalPresenter;

public interface IRestaurantListPresenter extends IGlobalPresenter {
    void setSelectedRestaurant(Context context, Restaurant restaurant);

    void userContinuing();
}
