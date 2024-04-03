package com.talabat.restaurants.v1;

import JsonModels.PolygonEvents;
import library.talabat.mvp.IGlobalListener;

public interface RestaurantListListenerRefactor extends IGlobalListener {
    void logNetworkError(String str);

    void onRequestError();

    void onRestaurantListLoaded(boolean z11, PolygonEvents polygonEvents, boolean z12);

    void onServerError();
}
