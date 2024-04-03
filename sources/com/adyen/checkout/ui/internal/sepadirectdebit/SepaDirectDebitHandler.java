package com.adyen.checkout.ui.internal.sepadirectdebit;

import android.app.Activity;
import android.app.Application;
import androidx.annotation.NonNull;
import com.adyen.checkout.core.PaymentMethodHandler;
import com.adyen.checkout.core.PaymentReference;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.core.model.PaymentSession;
import com.adyen.checkout.util.PaymentMethodTypes;

public final class SepaDirectDebitHandler implements PaymentMethodHandler {
    @NonNull
    public static final PaymentMethodHandler.Factory FACTORY = new PaymentMethodHandler.Factory() {
        public boolean isAvailableToShopper(@NonNull Application application, @NonNull PaymentSession paymentSession, @NonNull PaymentMethod paymentMethod) {
            return true;
        }

        public boolean supports(@NonNull Application application, @NonNull PaymentMethod paymentMethod) {
            return PaymentMethodTypes.SEPA_DIRECT_DEBIT.equals(paymentMethod.getType());
        }
    };
    private final PaymentMethod mPaymentMethod;
    private final PaymentReference mPaymentReference;

    public SepaDirectDebitHandler(@NonNull PaymentReference paymentReference, @NonNull PaymentMethod paymentMethod) {
        this.mPaymentReference = paymentReference;
        this.mPaymentMethod = paymentMethod;
    }

    public void handlePaymentMethodDetails(@NonNull Activity activity, int i11) {
        activity.finishActivity(i11);
        activity.startActivityForResult(SddDetailsActivity.newIntent(activity, this.mPaymentReference, this.mPaymentMethod), i11);
    }
}
