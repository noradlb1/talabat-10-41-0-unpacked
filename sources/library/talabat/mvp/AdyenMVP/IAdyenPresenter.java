package library.talabat.mvp.AdyenMVP;

import JsonModels.PlaceOrderRequestModel;
import JsonModels.Request.AdyenRequestModels.AdyenPurchaseRequest;
import JsonModels.Request.BIN.BinRequest;
import JsonModels.Response.BIN.BinResponse;
import datamodels.InvalidItem;
import library.talabat.mvp.IGlobalPresenter;

public interface IAdyenPresenter extends IGlobalPresenter {
    void applyAvailableBinResponse();

    void checkForBinVoucher(BinRequest binRequest);

    BinResponse getBinResponse();

    void placeOrder(PlaceOrderRequestModel placeOrderRequestModel);

    void proceedPayment(AdyenPurchaseRequest adyenPurchaseRequest);

    void removeInvalidCoupon(boolean z11);

    void removeInvalidItems(boolean z11, InvalidItem[] invalidItemArr);

    void removeInvalidPromotion(boolean z11);

    void removeInvalidVoucher(boolean z11);

    void setUpViews();

    void showOrderDetails(String str);

    void tryMoreRestaurantsClicked();
}
