package com.adyen.checkout.ui;

import androidx.annotation.NonNull;
import com.adyen.checkout.core.handler.ErrorHandler;

public interface CheckoutSetupParametersHandler extends ErrorHandler {
    void onRequestPaymentSession(@NonNull CheckoutSetupParameters checkoutSetupParameters);
}
