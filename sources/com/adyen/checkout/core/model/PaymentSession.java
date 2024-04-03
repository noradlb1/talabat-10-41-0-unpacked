package com.adyen.checkout.core.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Date;
import java.util.List;

public interface PaymentSession {
    @NonNull
    Date getGenerationTime();

    @Nullable
    List<PaymentMethod> getOneClickPaymentMethods();

    @NonNull
    Payment getPayment();

    @NonNull
    List<PaymentMethod> getPaymentMethods();

    @Nullable
    String getPublicKey();
}
