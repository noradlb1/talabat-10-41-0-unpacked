package library.talabat.mvp.placeorder;

import JsonModels.PlaceOrderResponse;
import datamodels.InvalidItem;
import library.talabat.mvp.IGlobalListener;

public interface PlaceOrderListener extends IGlobalListener {
    public static final int COUPONNOTAVAILABLE = 60;
    public static final int DOESNTALLOWMIX = 63;
    public static final int ERROR_VERIFY_NUMBER = 301;
    public static final int GEM_EXPIRED = 707;
    public static final int INVALID_GEM_DISCOUNT = 801;
    public static final int ITEMNOTAVAILECODE1 = 1;
    public static final int ITEMNOTAVAILECODE2 = 2;
    public static final int ITEMNOTAVAILECODE3 = 3;
    public static final int ORDER_ERROR_DUPLICATE = 55;
    public static final int POERR_REST_BUSY = 54;
    public static final int POERR_REST_CLOSED1 = 52;
    public static final int POERR_REST_CLOSED2 = 70;
    public static final int PROMOTIONNOTAVAILABLE = 61;
    public static final int VOCHERNOTAVAILABLE = 62;
    public static final int VOUCHERNOTAVAILABLEFORCASH = 64;

    void onBNPLOrderError();

    void onCheckoutDotComRecurringFailed(String str);

    void onDuplicateOrder(String str, int i11, String str2, String str3, String str4, int i12, String str5);

    void onOrderError(int i11, String str, String str2, String str3, InvalidItem[] invalidItemArr);

    void onOrderSucess(PlaceOrderResponse placeOrderResponse);

    void onRedirectToPaymentWebViewWithCheckoutDotCom(String str);

    void onRequestException(boolean z11);

    void onResponseRecieved();

    void onSuccessfulRecurringCheckoutDotCom();

    void showBusyPopup(String str, int i11, String str2, String str3, boolean z11);

    void verifyMobileNumber(String str, String str2, String str3, String str4);
}
