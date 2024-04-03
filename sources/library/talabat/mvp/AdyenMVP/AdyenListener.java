package library.talabat.mvp.AdyenMVP;

import JsonModels.MenuItemsResponseModel;
import JsonModels.Response.AdyenResponse.AdyenPurchaseResponse;
import JsonModels.Response.BIN.BinResponse;
import datamodels.OrderDetails;
import library.talabat.mvp.IGlobalListener;

public interface AdyenListener extends IGlobalListener {
    void enableButtonOnError();

    void onAdyenFailed(String str);

    void onBinVoucherAvailable(BinResponse binResponse);

    void onEmptyMenuReceived(String str);

    void onGroceryMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel);

    void onMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel);

    void onMinimumOrderConditionFailed(String str, String str2);

    void onNullResponseReceived();

    void onOrderDetailsRecieved(OrderDetails orderDetails);

    void onRedirectToPaymentWebViewWithAdyen(AdyenPurchaseResponse adyenPurchaseResponse);

    void onRequestError();

    void onRestaurantListLoaded();

    void onServerError();

    void onSuccessfulAdyen();
}
