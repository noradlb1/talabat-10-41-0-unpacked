package library.talabat.mvp.checkoutdotcom;

import JsonModels.MenuItemsResponseModel;
import JsonModels.Response.BIN.BinResponse;
import JsonModels.Response.CheckoutDotComResponse.PurchaseResponse;
import datamodels.OrderDetails;
import library.talabat.mvp.IGlobalListener;

public interface CheckoutDotComListener extends IGlobalListener {
    void enableButtonOnError();

    void onBinVoucherAvailable(BinResponse binResponse);

    void onCheckoutDotComFailed(String str);

    void onEmptyMenuReceived(String str);

    void onGroceryMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel);

    void onMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel);

    void onMinimumOrderConditionFailed(String str, String str2);

    void onNullResponseReceived();

    void onOrderDetailsRecieved(OrderDetails orderDetails);

    void onRedirectToPaymentWebViewWithCheckoutDotCom(PurchaseResponse purchaseResponse);

    void onRestaurantListLoaded();

    void onServerError();

    void onSuccessfulCheckoutDotCom();
}
