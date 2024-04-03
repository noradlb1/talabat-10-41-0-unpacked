package library.talabat.mvp.quickfindrestaurants;

import com.talabat.helpers.Talabat;
import datamodels.City;
import datamodels.DeliveryArea;
import datamodels.QuickRestaurant;
import datamodels.Restaurant;
import java.util.ArrayList;

public interface QuickFindRestaurantsView extends Talabat {
    void onRestaurantDetailsLoaded(Restaurant restaurant, DeliveryArea[] deliveryAreaArr, City[] cityArr);

    void onTypingStarted();

    void setLoadingView();

    void setNoRestaurantsView();

    void setQuickFindView(ArrayList<QuickRestaurant> arrayList);
}
