package library.talabat.mvp.quickfindrestaurants;

import datamodels.Restaurant;
import java.util.ArrayList;
import library.talabat.mvp.IGlobalInteractor;

public interface IQuickFindRestaurantsInteractor extends IGlobalInteractor {
    ArrayList<Restaurant> getAllRestaurantsForCountry(int i11);

    void getRestaurantDetails(int i11);
}
