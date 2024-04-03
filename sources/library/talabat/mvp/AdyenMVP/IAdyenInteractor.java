package library.talabat.mvp.AdyenMVP;

import JsonModels.Request.AdyenRequestModels.AdyenPurchaseRequest;
import JsonModels.Request.BIN.BinRequest;
import datamodels.Restaurant;
import library.talabat.mvp.IGlobalInteractor;

public interface IAdyenInteractor extends IGlobalInteractor {
    void checkForBinVoucher(BinRequest binRequest);

    void getGroceryMenu(Restaurant restaurant);

    void getOrderDetails(String str);

    void getRestaurantInfoOnly(Restaurant restaurant);

    void getRestaurantMenuOnly(Restaurant restaurant);

    void getRestaurants(int i11, int i12, int i13);

    void proceedPayment(AdyenPurchaseRequest adyenPurchaseRequest);
}
