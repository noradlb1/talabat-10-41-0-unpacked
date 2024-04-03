package library.talabat.mvp.restaurantlistrefactor;

import JsonModels.Request.InforMapRequest;
import JsonModels.Request.McdBranchRequest;
import datamodels.Restaurant;
import library.talabat.mvp.IGlobalInteractor;

public interface IMenuApiInteractor extends IGlobalInteractor {
    void getBranchIdFromBlockorLatLang(MenuApiListener menuApiListener, McdBranchRequest mcdBranchRequest);

    void getBranchIdFromGrl(MenuApiListener menuApiListener, InforMapRequest inforMapRequest);

    void getGroceryMenu(MenuApiListener menuApiListener, Restaurant restaurant);

    void getRestaurantMenu(MenuApiListener menuApiListener, Restaurant restaurant);
}
