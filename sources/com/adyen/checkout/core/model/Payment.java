package com.adyen.checkout.core.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;

public interface Payment extends Parcelable {
    @NonNull
    Amount getAmount();

    @NonNull
    String getCountryCode();
}
