package com.adyen.checkout.ui.internal.giropay;

import android.app.Activity;
import android.app.Application;
import androidx.annotation.NonNull;
import com.adyen.checkout.core.CheckoutException;
import com.adyen.checkout.core.PaymentMethodHandler;
import com.adyen.checkout.core.PaymentReference;
import com.adyen.checkout.core.internal.model.GiroPayConfiguration;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.core.model.PaymentSession;
import com.adyen.checkout.util.PaymentMethodTypes;

public final class GiroPayHandler implements PaymentMethodHandler {
    @NonNull
    public static final PaymentMethodHandler.Factory FACTORY = new PaymentMethodHandler.Factory() {
        public boolean isAvailableToShopper(@NonNull Application application, @NonNull PaymentSession paymentSession, @NonNull PaymentMethod paymentMethod) {
            try {
                paymentMethod.getConfiguration(GiroPayConfiguration.class);
                return true;
            } catch (CheckoutException unused) {
                return false;
            }
        }

        public boolean supports(@NonNull Application application, @NonNull PaymentMethod paymentMethod) {
            return PaymentMethodTypes.GIROPAY.equals(paymentMethod.getType());
        }
    };
    private final PaymentMethod mPaymentMethod;
    private final PaymentReference mPaymentReference;

    public GiroPayHandler(@NonNull PaymentReference paymentReference, @NonNull PaymentMethod paymentMethod) {
        this.mPaymentReference = paymentReference;
        this.mPaymentMethod = paymentMethod;
    }

    public void handlePaymentMethodDetails(@NonNull Activity activity, int i11) {
        activity.finishActivity(i11);
        activity.startActivityForResult(GiroPayDetailsActivity.newIntent(activity, this.mPaymentReference, this.mPaymentMethod), i11);
    }
}
