package com.adyen.checkout.core.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;

public interface Amount extends Parcelable {
    @NonNull
    String getCurrency();

    long getValue();
}
