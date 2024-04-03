package com.adyen.checkout.core.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;

public interface Card extends Parcelable {
    int getExpiryMonth();

    int getExpiryYear();

    @NonNull
    String getHolderName();

    @NonNull
    String getLastFourDigits();
}
