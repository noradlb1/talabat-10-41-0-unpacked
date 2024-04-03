package library.talabat.mvp.offerslist;

import library.talabat.mvp.IGlobalInteractor;

public interface IOffersInteractor extends IGlobalInteractor {
    void getRestaurantDetails(int i11);

    void loadOffersforCountry(int i11);
}
