package com.adyen.checkout.ui.internal.common.model;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.adyen.checkout.core.model.PaymentSession;

public class PaymentSessionLiveData extends LiveData<PaymentSession> {
    /* renamed from: g */
    public void postValue(@NonNull PaymentSession paymentSession) {
        super.postValue(paymentSession);
    }

    /* renamed from: h */
    public void setValue(@NonNull PaymentSession paymentSession) {
        super.setValue(paymentSession);
    }

    @NonNull
    public PaymentSession getValue() {
        return (PaymentSession) super.getValue();
    }
}
