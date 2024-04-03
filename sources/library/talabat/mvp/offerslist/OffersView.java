package library.talabat.mvp.offerslist;

import com.talabat.helpers.Talabat;
import datamodels.City;
import datamodels.DeliveryArea;
import datamodels.OffersDisplayModel;
import datamodels.Restaurant;
import java.util.ArrayList;

public interface OffersView extends Talabat {
    void onOffersLoaded(ArrayList<OffersDisplayModel> arrayList);

    void onRestaurantDetailsLoaded(Restaurant restaurant, DeliveryArea[] deliveryAreaArr, City[] cityArr);
}
