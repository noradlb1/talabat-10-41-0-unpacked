package library.talabat.mvp.AdyenMVP;

import JsonModels.Response.AdyenResponse.AdyenPurchaseResponse;
import JsonModels.Response.BIN.BinResponse;
import com.talabat.helpers.Talabat;
import datamodels.OrderDetails;

public interface AdyenView extends Talabat {
    public static final int KNET_ERROR = 58;

    void enablePayButton();

    void fillViews();

    void onAdyenFailed(String str);

    void onBinNotAvailable(String str);

    void onBinVoucherAvailable(BinResponse binResponse);

    void onEmptyMenuReceived(String str);

    void onInvalidConditionHandled();

    void onMinimumOrderConditionForBINFailed(String str, String str2);

    void onNullResponseReceived();

    void onOrderDetailsRecieved(OrderDetails orderDetails);

    void onRedirectToCartPage();

    void onRedirectToPaymentWebViewWithAdyen(AdyenPurchaseResponse adyenPurchaseResponse);

    void onRedirectToRestaurantList();

    void onRequestError();

    void onServerError();

    void onSuccessfulAdyen();

    void stopProgressBar();
}
