package com.adyen.checkout.ui.internal.def;

import android.app.Activity;
import android.app.Application;
import androidx.annotation.NonNull;
import com.adyen.checkout.core.PaymentMethodHandler;
import com.adyen.checkout.core.PaymentReference;
import com.adyen.checkout.core.model.InputDetail;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.core.model.PaymentMethodDetails;
import com.adyen.checkout.core.model.PaymentSession;
import java.util.List;

public final class DefaultPaymentMethodHandler implements PaymentMethodHandler {
    @NonNull
    public static final PaymentMethodHandler.Factory FACTORY = new PaymentMethodHandler.Factory() {
        public boolean isAvailableToShopper(@NonNull Application application, @NonNull PaymentSession paymentSession, @NonNull PaymentMethod paymentMethod) {
            return true;
        }

        public boolean supports(@NonNull Application application, @NonNull PaymentMethod paymentMethod) {
            List<InputDetail> inputDetails = paymentMethod.getInputDetails();
            if (inputDetails == null) {
                return true;
            }
            for (InputDetail isOptional : inputDetails) {
                if (!isOptional.isOptional()) {
                    return false;
                }
            }
            return true;
        }
    };
    private final PaymentMethod mPaymentMethod;
    private final PaymentReference mPaymentReference;

    public DefaultPaymentMethodHandler(@NonNull PaymentReference paymentReference, @NonNull PaymentMethod paymentMethod) {
        this.mPaymentReference = paymentReference;
        this.mPaymentMethod = paymentMethod;
    }

    public void handlePaymentMethodDetails(@NonNull Activity activity, int i11) {
        this.mPaymentReference.getPaymentHandler(activity).initiatePayment(this.mPaymentMethod, (PaymentMethodDetails) null);
    }
}
