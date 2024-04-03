package tracking.deeplink;

import JsonModels.MenuItemsResponseModel;
import JsonModels.Response.RestaurantSlugRM;
import datamodels.City;
import datamodels.DeliveryArea;
import datamodels.OrderDetails;
import datamodels.QuickRestaurant;
import datamodels.RateOrderReq;
import datamodels.Restaurant;
import java.util.ArrayList;
import library.talabat.mvp.listingmenubridge.DarkstoresTrackingData;

public interface DeeplinkRequestListener {
    void onAreasRecieved();

    void onCountryReceived();

    void onCountryRedirectionCompleted();

    void onCuisinesRecieved();

    void onDarkStoresEntrySuccess(Restaurant restaurant, DarkstoresTrackingData darkstoresTrackingData);

    void onGroceryMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel);

    void onMigratedInfoSuccess(Restaurant restaurant, DarkstoresTrackingData darkstoresTrackingData);

    void onOrderDetailsRecieved(OrderDetails orderDetails);

    void onRateOrderDataRecieved(RateOrderReq rateOrderReq);

    void onRestaurantDetailsLoaded(Restaurant restaurant, DeliveryArea[] deliveryAreaArr, City[] cityArr);

    void onRestaurantListLoaded();

    void onRestaurantListLoaded(ArrayList<QuickRestaurant> arrayList);

    void onRestaurantMenuLoaded();

    void onRestaurantSlugDetailsLoaded(RestaurantSlugRM restaurantSlugRM);

    void onUserInfoRecieved();

    void redirectToHome();

    void showDarkstoresErrorMessage();
}
