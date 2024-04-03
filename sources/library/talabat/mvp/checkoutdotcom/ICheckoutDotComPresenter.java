package library.talabat.mvp.checkoutdotcom;

import JsonModels.PlaceOrderRequestModel;
import JsonModels.Request.BIN.BinRequest;
import JsonModels.Request.CheckoutDotComRequest.PurchaseRequest;
import JsonModels.Response.BIN.BinResponse;
import datamodels.InvalidItem;
import library.talabat.mvp.IGlobalPresenter;

public interface ICheckoutDotComPresenter extends IGlobalPresenter {
    void applyAvailableBinResponse();

    void checkForBinVoucher(BinRequest binRequest);

    BinResponse getBinResponse();

    void placeOrder(PlaceOrderRequestModel placeOrderRequestModel);

    void proceedPayment(PurchaseRequest purchaseRequest);

    void removeInvalidCoupon(boolean z11);

    void removeInvalidItems(boolean z11, InvalidItem[] invalidItemArr);

    void removeInvalidPromotion(boolean z11);

    void removeInvalidVoucher(boolean z11);

    void setUpViews();

    void showOrderDetails(String str);

    void tryMoreRestaurantsClicked();
}
