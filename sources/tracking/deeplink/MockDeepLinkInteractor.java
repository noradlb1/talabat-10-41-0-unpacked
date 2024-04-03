package tracking.deeplink;

import android.content.Context;
import datamodels.City;
import datamodels.DeliveryArea;
import datamodels.Restaurant;
import java.util.ArrayList;
import library.talabat.mvp.listingmenubridge.DarkstoresTrackingData;

class MockDeepLinkInteractor implements IDeepLinkInteractor {
    private DeeplinkRequestListener deeplinkRequestListener;

    public MockDeepLinkInteractor(DeeplinkRequestListener deeplinkRequestListener2) {
        this.deeplinkRequestListener = deeplinkRequestListener2;
    }

    public ArrayList<Restaurant> getAllRestaurantsForCountry(int i11) {
        return new ArrayList<>();
    }

    public void getAreas() {
    }

    public void getDarkstoresAvailability() {
    }

    public void getMigratedVendorInfo(int i11) {
        this.deeplinkRequestListener.onMigratedInfoSuccess(new Restaurant(), (DarkstoresTrackingData) null);
    }

    public void getOrderDetails(String str) {
    }

    public void getRequiredData(Context context) {
    }

    public void getRestaurantDetails(int i11) {
        this.deeplinkRequestListener.onRestaurantDetailsLoaded(new Restaurant(), new DeliveryArea[0], new City[0]);
    }

    public void getRestaurantIdFromSlug(String str, String str2) {
    }

    public void getRestaurantInfoOnly(String str) {
    }

    public void getRestaurantMenuOnly(String str) {
    }

    public void getRestaurants(int i11, int i12, int i13) {
    }

    public void getUserInfo() {
    }

    public void loadAppinitCountrySpecficData(int i11) {
    }

    public void loadCuisines() {
    }

    public void rateOrder(String str) {
    }
}
