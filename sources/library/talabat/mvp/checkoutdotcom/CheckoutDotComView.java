package library.talabat.mvp.checkoutdotcom;

import JsonModels.Response.BIN.BinResponse;
import JsonModels.Response.CheckoutDotComResponse.PurchaseResponse;
import android.content.Context;
import com.talabat.helpers.Talabat;
import datamodels.OrderDetails;

public interface CheckoutDotComView extends Talabat {
    public static final int KNET_ERROR = 58;

    void enablePayButton();

    void fillViews();

    Context getContext();

    String getSelectedCardName();

    boolean isBinApplied();

    void onBinVoucherAvailable(BinResponse binResponse);

    void onCheckoutDotComFailed(String str);

    void onEmptyMenuReceived(String str);

    void onInvalidConditionHandled();

    void onMinimumOrderConditionForBINFailed(String str, String str2);

    void onNullResponseReceived();

    void onOrderDetailsRecieved(OrderDetails orderDetails);

    void onRedirectToCartPage();

    void onRedirectToPaymentWebViewWithCheckoutDotCom(PurchaseResponse purchaseResponse);

    void onRedirectToRestaurantList();

    void onServerError();

    void onSuccessfulCheckoutDotCom();
}
