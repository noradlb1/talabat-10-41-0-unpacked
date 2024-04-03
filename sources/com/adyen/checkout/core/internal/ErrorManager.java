package com.adyen.checkout.core.internal;

import androidx.annotation.NonNull;
import com.adyen.checkout.core.CheckoutException;
import com.adyen.checkout.core.handler.ErrorHandler;
import com.adyen.checkout.core.internal.BaseManager;

final class ErrorManager extends BaseManager<ErrorHandler, CheckoutException> {
    public ErrorManager(@NonNull BaseManager.Listener listener) {
        super(listener);
    }

    /* renamed from: f */
    public void d(@NonNull ErrorHandler errorHandler, @NonNull CheckoutException checkoutException) {
        errorHandler.onError(checkoutException);
    }
}
