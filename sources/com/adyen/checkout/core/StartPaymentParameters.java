package com.adyen.checkout.core;

import androidx.annotation.NonNull;
import com.adyen.checkout.core.model.PaymentSession;

public interface StartPaymentParameters {
    @NonNull
    PaymentReference getPaymentReference();

    @NonNull
    PaymentSession getPaymentSession();
}
