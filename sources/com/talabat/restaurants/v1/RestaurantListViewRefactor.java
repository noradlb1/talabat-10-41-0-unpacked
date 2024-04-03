package com.talabat.restaurants.v1;

import JsonModels.PolygonEvents;
import android.content.Context;
import com.talabat.domain.address.Address;
import com.talabat.helpers.Talabat;
import java.util.Map;

public interface RestaurantListViewRefactor extends Talabat {
    Context getContext();

    void logNetworkError(String str);

    void onRequestError();

    void onServerError();

    void redirectoChooseSavedAddressScreen(Address address);

    void redirectoHomeMapScreen(boolean z11, String str);

    void sendEvent(String str, Map<String, String> map);

    void setAreaName(String str, boolean z11);

    void showAreaSplitAlert();

    void showCoordinationsError();

    void showLoadingFragment();

    void showRestaurantsFragment(PolygonEvents polygonEvents, boolean z11);

    void stopLodingPopup();
}
