package com.adyen.checkout.core;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.adyen.checkout.core.model.PaymentResultCode;

public interface PaymentResult extends Parcelable {
    @NonNull
    String getPayload();

    @NonNull
    PaymentResultCode getResultCode();
}
