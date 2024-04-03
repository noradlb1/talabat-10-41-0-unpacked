package com.adyen.checkout.core.handler;

import androidx.annotation.NonNull;
import com.adyen.checkout.core.PaymentSetupParameters;

public interface PaymentSetupParametersHandler extends ErrorHandler {
    void onRequestPaymentSession(@NonNull PaymentSetupParameters paymentSetupParameters);
}
