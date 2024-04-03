package library.talabat.mvp.RestaurantFranchise;

import datamodels.Restaurant;
import library.talabat.mvp.IGlobalListener;

public interface FranchiseListener extends IGlobalListener {
    void franchiseRestaurantReceived(Restaurant[] restaurantArr);

    void onResponseError();
}
