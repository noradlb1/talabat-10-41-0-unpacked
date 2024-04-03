package com.adyen.checkout.ui.internal.paypal;

import android.app.Activity;
import android.app.Application;
import androidx.annotation.NonNull;
import com.adyen.checkout.core.PaymentMethodHandler;
import com.adyen.checkout.core.PaymentReference;
import com.adyen.checkout.core.internal.model.InputDetailImpl;
import com.adyen.checkout.core.model.PayPalDetails;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.core.model.PaymentSession;
import com.adyen.checkout.util.PaymentMethodTypes;

public final class PayPalHandler implements PaymentMethodHandler {
    @NonNull
    public static final PaymentMethodHandler.Factory FACTORY = new PaymentMethodHandler.Factory() {
        public boolean isAvailableToShopper(@NonNull Application application, @NonNull PaymentSession paymentSession, @NonNull PaymentMethod paymentMethod) {
            return true;
        }

        public boolean supports(@NonNull Application application, @NonNull PaymentMethod paymentMethod) {
            return PaymentMethodTypes.PAYPAL.equals(paymentMethod.getType());
        }
    };
    private static final Boolean STORE_DETAILS = null;
    private final PaymentMethod mPaymentMethod;
    private final PaymentReference mPaymentReference;

    public PayPalHandler(@NonNull PaymentReference paymentReference, @NonNull PaymentMethod paymentMethod) {
        this.mPaymentReference = paymentReference;
        this.mPaymentMethod = paymentMethod;
    }

    public void handlePaymentMethodDetails(@NonNull Activity activity, int i11) {
        PayPalDetails payPalDetails;
        if (InputDetailImpl.findByKey(this.mPaymentMethod.getInputDetails(), "storeDetails") != null) {
            payPalDetails = new PayPalDetails.Builder().setStoreDetails(STORE_DETAILS).build();
        } else {
            payPalDetails = null;
        }
        this.mPaymentReference.getPaymentHandler(activity).initiatePayment(this.mPaymentMethod, payPalDetails);
    }
}
