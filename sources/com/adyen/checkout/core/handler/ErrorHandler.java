package com.adyen.checkout.core.handler;

import androidx.annotation.NonNull;
import com.adyen.checkout.core.CheckoutException;

public interface ErrorHandler {
    void onError(@NonNull CheckoutException checkoutException);
}
