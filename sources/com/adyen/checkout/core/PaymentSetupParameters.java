package com.adyen.checkout.core;

import androidx.annotation.NonNull;

public interface PaymentSetupParameters {
    @NonNull
    String getSdkToken();
}
