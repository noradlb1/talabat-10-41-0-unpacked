package com.talabat.restaurants;

import io.reactivex.functions.Consumer;

public class OnAllRestaurantsLoadedAnalytics implements Consumer<RestaurantsListScreenRefactor> {
    public void accept(RestaurantsListScreenRefactor restaurantsListScreenRefactor) {
        if (restaurantsListScreenRefactor.F) {
            restaurantsListScreenRefactor.GaOnRestaurantListUpdated("address_change");
            restaurantsListScreenRefactor.F = false;
            return;
        }
        restaurantsListScreenRefactor.GaOnRestaurantLisLoaded();
    }
}
