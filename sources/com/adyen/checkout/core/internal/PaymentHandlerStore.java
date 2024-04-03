package com.adyen.checkout.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.core.PaymentReference;
import java.util.HashMap;
import java.util.Map;

public final class PaymentHandlerStore {
    private static PaymentHandlerStore sInstance = new PaymentHandlerStore();
    private final Map<String, PaymentHandlerImpl> mPaymentHandlers = new HashMap();

    private PaymentHandlerStore() {
    }

    @NonNull
    public static PaymentHandlerStore getInstance() {
        return sInstance;
    }

    @Nullable
    public PaymentHandlerImpl getPaymentHandler(@NonNull PaymentReference paymentReference) {
        return this.mPaymentHandlers.get(paymentReference.getUuid());
    }

    public void storePaymentHandler(@NonNull PaymentReference paymentReference, @NonNull PaymentHandlerImpl paymentHandlerImpl) {
        this.mPaymentHandlers.put(paymentReference.getUuid(), paymentHandlerImpl);
    }
}
