package com.talabat.helpers;

import kotlin.Unit;

public interface GARestaurantsListEvents {
    void GaOnChangeArea();

    void GaOnChannelClicked(String str);

    void GaOnCuisineChanged(String str);

    void GaOnRestaurantLisLoaded();

    void GaOnRestaurantListUpdated(String str);

    void GaOnRestaurantListUpdated(String str, String str2);

    Unit GaOnRestaurantsClicked();

    void GaOnSearchClicked();
}
