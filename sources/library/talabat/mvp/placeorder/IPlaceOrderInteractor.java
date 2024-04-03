package library.talabat.mvp.placeorder;

import JsonModels.PlaceOrderRequestModel;
import JsonModels.Request.CheckoutDotComRequest.RecurringPurchaseRequest;
import android.content.Context;
import library.talabat.mvp.IGlobalInteractor;
import org.json.JSONException;

public interface IPlaceOrderInteractor extends IGlobalInteractor {
    void continueWithAdyenSavedToken(RecurringPurchaseRequest recurringPurchaseRequest);

    void continueWithCheckoutDotComSavedToken(RecurringPurchaseRequest recurringPurchaseRequest);

    void placeOrder(PlaceOrderRequestModel placeOrderRequestModel, Context context) throws JSONException;

    void register(PlaceOrderListener placeOrderListener);
}
