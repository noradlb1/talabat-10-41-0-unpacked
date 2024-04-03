package com.adyen.checkout.ui.internal.common.model;

import androidx.annotation.NonNull;
import com.adyen.checkout.core.PaymentHandler;
import com.adyen.checkout.core.PaymentReference;

public interface CheckoutSessionProvider {
    @NonNull
    PaymentHandler getPaymentHandler();

    @NonNull
    PaymentReference getPaymentReference();
}
