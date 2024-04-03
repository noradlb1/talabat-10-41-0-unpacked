package library.talabat.mvp.quickfindrestaurants;

import datamodels.City;
import datamodels.DeliveryArea;
import datamodels.QuickRestaurant;
import datamodels.Restaurant;
import java.util.ArrayList;
import library.talabat.mvp.IGlobalListener;

public interface QuickFindRestaruantsListener extends IGlobalListener {
    void onRestaurantDetailsLoaded(Restaurant restaurant, DeliveryArea[] deliveryAreaArr, City[] cityArr);

    void onRestaurantListLoaded(ArrayList<QuickRestaurant> arrayList);
}
