package tracking.deeplink;

import android.content.Context;
import datamodels.Restaurant;
import java.util.ArrayList;

public interface IDeepLinkInteractor {
    ArrayList<Restaurant> getAllRestaurantsForCountry(int i11);

    void getAreas();

    void getDarkstoresAvailability();

    void getMigratedVendorInfo(int i11);

    void getOrderDetails(String str);

    void getRequiredData(Context context);

    void getRestaurantDetails(int i11);

    void getRestaurantIdFromSlug(String str, String str2);

    void getRestaurantInfoOnly(String str);

    void getRestaurantMenuOnly(String str);

    void getRestaurants(int i11, int i12, int i13);

    void getUserInfo();

    void loadAppinitCountrySpecficData(int i11);

    void loadCuisines();

    void rateOrder(String str);
}
