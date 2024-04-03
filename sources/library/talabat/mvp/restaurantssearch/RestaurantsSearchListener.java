package library.talabat.mvp.restaurantssearch;

import JsonModels.Response.RestaurantSearchResponse;
import java.util.ArrayList;
import library.talabat.mvp.IGlobalListener;

public interface RestaurantsSearchListener extends IGlobalListener {
    void resultReceived(ArrayList<RestaurantSearchResponse> arrayList, String str, boolean z11);
}
