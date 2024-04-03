package library.talabat.mvp.restaurantlist;

import JsonModels.Request.InforMapRequest;
import JsonModels.Request.McdBranchRequest;
import datamodels.Restaurant;
import library.talabat.mvp.IGlobalInteractor;

public interface IRestaurantListInteractor extends IGlobalInteractor {
    void getBranchIdFromBlockorLatLang(McdBranchRequest mcdBranchRequest);

    void getBranchIdFromGrl(InforMapRequest inforMapRequest);

    void getGroceryMenu(Restaurant restaurant);

    void getRestaurantInfoOnly(Restaurant restaurant);

    void getRestaurantMenuOnly(Restaurant restaurant);
}
