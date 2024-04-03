package com.adyen.checkout.core.internal;

import androidx.annotation.NonNull;
import com.adyen.checkout.core.StartPaymentParameters;
import com.adyen.checkout.core.internal.model.PaymentSessionImpl;

public final class StartPaymentParametersImpl implements StartPaymentParameters {
    private final PaymentReferenceImpl mPaymentReference;
    private final PaymentSessionImpl mPaymentSession;

    public StartPaymentParametersImpl(@NonNull PaymentReferenceImpl paymentReferenceImpl, @NonNull PaymentSessionImpl paymentSessionImpl) {
        this.mPaymentReference = paymentReferenceImpl;
        this.mPaymentSession = paymentSessionImpl;
    }

    @NonNull
    public PaymentReferenceImpl getPaymentReference() {
        return this.mPaymentReference;
    }

    @NonNull
    public PaymentSessionImpl getPaymentSession() {
        return this.mPaymentSession;
    }
}
