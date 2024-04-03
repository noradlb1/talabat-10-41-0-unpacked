package library.talabat.mvp.placeorder;

import JsonModels.PlaceOrderResponse;
import JsonModels.Request.CheckoutDotComRequest.RecurringPurchaseRequest;
import android.content.Context;
import com.talabat.helpers.Talabat;
import datamodels.InvalidItem;
import tracking.Purchase;

public interface PlaceOrderView extends Talabat {

    public interface PLACEORDERERRORCODES {
        public static final int BIN_EXPIRED = 655;
        public static final int COUPONNOTAVAILABLE = 60;
        public static final int DARKSTORES_DJINI_VALIDATION_ERROR = 601;
        public static final int DELIVERY_FEE_MISMATCH = 903;
        public static final int DOESNTALLOWMIX = 63;
        public static final int ERROR_TGODISCOUNT_USERTYPE = 662;
        public static final int GEM_EXPIRED = 707;
        public static final int INVALID_GEM_DISCOUNT = 801;
        public static final int ITEMNOTAVAILECODE1 = 1;
        public static final int ITEMNOTAVAILECODE2 = 2;
        public static final int ITEMNOTAVAILECODE3 = 3;
        public static final int PROMOTIONNOTAVAILABLE = 61;
        public static final int SERVICE_FEE_MISMATCH = 901;
        public static final int SMALL_ORDER_FEE_MISMATCH = 904;
        public static final int VOCHERNOTAVAILABLE = 62;
        public static final int VOUCHERNOTAVAILABLEFORCASH = 64;
    }

    void addNewCard();

    void clearCvv();

    Context getContext();

    void handleWithCreditCard(float f11, String str, String str2);

    void onBNPLOrderError();

    void onBNPLOrderSuccess(PlaceOrderResponse placeOrderResponse);

    void onBinError(String str);

    void onCheckoutDotComRecurringFailed(String str);

    void onDarkstoresDjiniError(String str);

    void onDuplicateOrder(String str, String str2, int i11, String str3);

    void onFeesMismatchError(String str);

    void onGemError(String str);

    void onGeneralError(int i11, String str);

    void onOrderCouponNotAvailable(String str, boolean z11);

    void onOrderError(int i11, String str);

    void onOrderItemNotAvailable(String str, boolean z11, InvalidItem[] invalidItemArr);

    void onOrderPromotionNotAvailable(String str, boolean z11);

    void onOrderSucess(PlaceOrderResponse placeOrderResponse);

    void onOrderVoucherNotAvailable(String str, boolean z11);

    void onRedirectToPaymentPage(PlaceOrderResponse placeOrderResponse, String str, String str2, int i11);

    void onRequestException(boolean z11);

    void onResponseRecieved();

    void onSendCVVToProxyServer(RecurringPurchaseRequest recurringPurchaseRequest, int i11);

    void onSuccessfulRecurringCheckoutDotCom();

    void onUserTypeErrorForDiscount(String str);

    void onVisaCheckoutOrderPlaced(Purchase purchase, String str, String str2);

    void setEncryptedOrderId(String str);

    void setPlaceOrderResponse(PlaceOrderResponse placeOrderResponse);

    void setTransactionId(String str);

    void showBusyPopup(String str, boolean z11);

    void stopNonCancelableLoading();

    void verifyMobileNumber(String str, String str2, String str3, String str4);
}
