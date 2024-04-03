package library.talabat.mvp.checkout;

import JsonModels.MenuItemsResponseModel;
import JsonModels.Response.BIN.BinResponse;
import JsonModels.Response.BinTokenRM;
import JsonModels.Response.Cashback.CashbackRM;
import JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherRM;
import JsonModels.Response.VisaCheckoutResponse.DecryptionResponse;
import JsonModels.Response.VisaCheckoutResponse.PurchaseResponse;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPaymentStatus;
import datamodels.OrderDetails;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import library.talabat.mvp.IGlobalListener;

public interface CheckoutListener extends IGlobalListener {
    public static final int CHOOSE_AN_ADDRESS = 0;
    public static final int CHOOSE_DEL_TIME = 1;
    public static final int CHOOSE_PAYMENT_METHOD = 2;
    public static final int EMPTY_CALLID = 302;
    public static final int KNET_ERROR = 58;

    void hideBinAvailableNotification();

    void onBinNotAvailable(String str);

    void onBinResponseReceived(BinTokenRM binTokenRM);

    void onBinVoucherAvailable(BinResponse binResponse);

    void onCashbackResponseError();

    void onCashbackResponseReceived(CashbackRM cashbackRM);

    void onDecryptionDataReceived(DecryptionResponse decryptionResponse);

    void onDecryptionErrorOccurred(String str);

    void onDeliveryTimesLoaded(ArrayList<String> arrayList);

    void onDeliveryTimesNotavailable();

    void onEmptyMenuReceived(String str);

    void onGroceryMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel);

    void onHideLoader();

    void onLoyaltyVoucherError();

    void onLoyaltyVoucherInfoReceived(LoyaltyVoucherRM loyaltyVoucherRM);

    void onMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel);

    void onMinimumOrderConditionFailed(String str);

    void onNullResponseReceived();

    void onOrderDetailsRecieved(OrderDetails orderDetails);

    void onParallelBinAvailable(boolean z11);

    void onRedirectToPaymentWebViewWithVisaCheckout(PurchaseResponse purchaseResponse);

    void onRequestError();

    void onRestaurantListLoaded();

    void onServerError();

    void onSubscriptionPlansLoaded(Function1<Boolean, Unit> function1);

    void onVisaCheckoutPaymentErrorWebview(String str);

    void redirectToThankyouPage();

    void showBinAvailableNotification(String str);

    void showSubscriptionErrorDialog();

    void usePaymentResult(SubscriptionPaymentStatus subscriptionPaymentStatus);
}
