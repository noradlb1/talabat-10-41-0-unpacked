package com.adyen.checkout.core;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.adyen.checkout.core.handler.PaymentSetupParametersHandler;
import com.adyen.checkout.core.handler.StartPaymentParametersHandler;
import com.adyen.checkout.core.internal.PaymentHandlerImpl;
import com.adyen.checkout.core.internal.PaymentSetupParametersImpl;
import com.adyen.checkout.core.internal.StartPaymentParametersImpl;
import com.adyen.checkout.core.internal.model.PaymentSessionImpl;

public final class PaymentController {
    private PaymentController() {
        throw new IllegalStateException("No instances.");
    }

    public static void handlePaymentSessionResponse(@NonNull Activity activity, @NonNull String str, @NonNull StartPaymentParametersHandler startPaymentParametersHandler) {
        try {
            PaymentSessionImpl decode = PaymentSessionImpl.decode(str);
            startPaymentParametersHandler.onPaymentInitialized(new StartPaymentParametersImpl(PaymentHandlerImpl.createPaymentReference(activity, decode), decode));
        } catch (CheckoutException e11) {
            startPaymentParametersHandler.onError(e11);
        }
    }

    public static void startPayment(@NonNull Activity activity, @NonNull PaymentSetupParametersHandler paymentSetupParametersHandler) {
        try {
            paymentSetupParametersHandler.onRequestPaymentSession(new PaymentSetupParametersImpl(activity));
        } catch (CheckoutException e11) {
            paymentSetupParametersHandler.onError(e11);
        }
    }
}
