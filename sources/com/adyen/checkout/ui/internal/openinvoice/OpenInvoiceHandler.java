package com.adyen.checkout.ui.internal.openinvoice;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.adyen.checkout.core.PaymentMethodHandler;
import com.adyen.checkout.core.PaymentReference;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.core.model.PaymentSession;
import com.adyen.checkout.util.PaymentMethodTypes;

public class OpenInvoiceHandler implements PaymentMethodHandler {
    @NonNull
    public static final PaymentMethodHandler.Factory FACTORY = new PaymentMethodHandler.Factory() {
        public boolean isAvailableToShopper(@NonNull Application application, @NonNull PaymentSession paymentSession, @NonNull PaymentMethod paymentMethod) {
            return true;
        }

        public boolean supports(@NonNull Application application, @NonNull PaymentMethod paymentMethod) {
            boolean equals = PaymentMethodTypes.KLARNA.equals(paymentMethod.getType());
            if ((PaymentMethodTypes.AFTERPAY.equals(paymentMethod.getType()) || equals) && paymentMethod.getInputDetails() != null) {
                return true;
            }
            return false;
        }
    };
    private final PaymentMethod mPaymentMethod;
    private final PaymentReference mPaymentReference;

    public OpenInvoiceHandler(@NonNull PaymentReference paymentReference, @NonNull PaymentMethod paymentMethod) {
        this.mPaymentReference = paymentReference;
        this.mPaymentMethod = paymentMethod;
    }

    public void handlePaymentMethodDetails(@NonNull Activity activity, int i11) {
        Intent newIntent = OpenInvoiceDetailsActivity.newIntent(activity, this.mPaymentReference, this.mPaymentMethod);
        activity.finishActivity(i11);
        activity.startActivity(newIntent);
    }
}
