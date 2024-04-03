package com.adyen.checkout.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.adyen.checkout.base.internal.JsonSerializable;

public abstract class PaymentMethodDetails implements Parcelable, JsonSerializable {
    public PaymentMethodDetails() {
    }

    public int describeContents() {
        return 0;
    }

    public PaymentMethodDetails(@NonNull Parcel parcel) {
    }
}
