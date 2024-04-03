package com.adyen.checkout.core.handler;

import androidx.annotation.NonNull;
import com.adyen.checkout.core.StartPaymentParameters;

public interface StartPaymentParametersHandler extends ErrorHandler {
    void onPaymentInitialized(@NonNull StartPaymentParameters startPaymentParameters);
}
