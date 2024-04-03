package library.talabat.mvp.placeorder;

import JsonModels.PlaceOrderRequestModel;
import JsonModels.Request.CheckoutDotComRequest.RecurringPurchaseRequest;
import library.talabat.mvp.IGlobalPresenter;
import org.json.JSONException;

public interface IPlaceOrderPresenter extends IGlobalPresenter {
    void continueWithAdyenPaymentAfterCVVSentToProxy(RecurringPurchaseRequest recurringPurchaseRequest);

    void continueWithCheckoutPaymentAfterCVVSentToProxy(RecurringPurchaseRequest recurringPurchaseRequest);

    String getCVV();

    RecurringPurchaseRequest getPaymentRequestModel(String str, String str2, String str3, String str4);

    void payRemainingWithCreditCard();

    void placeOrder(PlaceOrderRequestModel placeOrderRequestModel) throws JSONException;

    void setCvv(String str);

    void setDefaultPaymentMethodForGA(String str);

    void setFromVisaCheckout(boolean z11);

    void setIsQuickOrder(boolean z11);

    void setPayBytalabatCredit(float f11);

    void setPaymentRequirements(boolean z11, RecurringPurchaseRequest recurringPurchaseRequest, int i11, String str);

    void setSelectedPaymentMethod(int i11);

    void setSelectedPaymentMethodForGA(int i11);
}
