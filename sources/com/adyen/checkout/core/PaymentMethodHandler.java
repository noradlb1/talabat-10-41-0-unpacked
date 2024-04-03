package com.adyen.checkout.core;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.core.model.PaymentSession;

public interface PaymentMethodHandler {
    @NonNull
    public static final String RESULT_CHECKOUT_EXCEPTION = "RESULT_CHECKOUT_EXCEPTION";
    public static final int RESULT_CODE_CANCELED = 0;
    public static final int RESULT_CODE_ERROR = 1;
    public static final int RESULT_CODE_OK = -1;
    @NonNull
    public static final String RESULT_PAYMENT_RESULT = "RESULT_PAYMENT_RESULT";

    public interface Factory {
        boolean isAvailableToShopper(@NonNull Application application, @NonNull PaymentSession paymentSession, @NonNull PaymentMethod paymentMethod);

        boolean supports(@NonNull Application application, @NonNull PaymentMethod paymentMethod);
    }

    public static final class Util {
        private Util() {
            throw new IllegalStateException("No instances.");
        }

        @Nullable
        public static CheckoutException getCheckoutException(@Nullable Intent intent) {
            if (intent != null) {
                return (CheckoutException) intent.getSerializableExtra(PaymentMethodHandler.RESULT_CHECKOUT_EXCEPTION);
            }
            return null;
        }

        @Nullable
        public static PaymentResult getPaymentResult(@Nullable Intent intent) {
            if (intent != null) {
                return (PaymentResult) intent.getParcelableExtra(PaymentMethodHandler.RESULT_PAYMENT_RESULT);
            }
            return null;
        }
    }

    void handlePaymentMethodDetails(@NonNull Activity activity, int i11);
}
