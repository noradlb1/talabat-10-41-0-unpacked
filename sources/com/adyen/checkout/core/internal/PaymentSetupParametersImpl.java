package com.adyen.checkout.core.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.adyen.checkout.core.CheckoutException;
import com.adyen.checkout.core.PaymentSetupParameters;
import com.adyen.checkout.core.internal.model.DeviceFingerprint;

public final class PaymentSetupParametersImpl implements PaymentSetupParameters {
    private final String mSdkToken;

    public PaymentSetupParametersImpl(@NonNull Context context) throws CheckoutException {
        this.mSdkToken = DeviceFingerprint.generateSdkToken(context, "custom");
    }

    @NonNull
    public String getSdkToken() {
        return this.mSdkToken;
    }
}
