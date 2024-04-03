package library.talabat.mvp.offerslist;

import datamodels.City;
import datamodels.DeliveryArea;
import datamodels.Offers;
import datamodels.Restaurant;
import library.talabat.mvp.IGlobalListener;

public interface OffersListener extends IGlobalListener {
    void onOffersListLoaded(Offers[] offersArr);

    void onRestaurantDetailsLoaded(Restaurant restaurant, DeliveryArea[] deliveryAreaArr, City[] cityArr);
}
