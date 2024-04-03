package com.adyen.checkout.core;

import android.app.Activity;
import android.os.Parcelable;
import androidx.annotation.NonNull;

public interface PaymentReference extends Parcelable {
    @NonNull
    PaymentHandler getPaymentHandler(@NonNull Activity activity);

    @NonNull
    String getUuid();
}
