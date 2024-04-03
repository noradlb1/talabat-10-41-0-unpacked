package com.adyen.checkout.ui;

import androidx.annotation.NonNull;
import com.adyen.checkout.core.PaymentSetupParameters;

public interface CheckoutSetupParameters extends PaymentSetupParameters {
    @NonNull
    String getReturnUrl();
}
