package com.adyen.checkout.core.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;

public interface GiroPayIssuer extends Parcelable {
    @NonNull
    String getBankName();

    @NonNull
    String getBic();

    @NonNull
    String getBlz();
}
