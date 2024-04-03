package com.adyen.checkout.core.internal;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.adyen.checkout.core.PaymentHandler;
import com.adyen.checkout.core.PaymentReference;

public final class PaymentReferenceImpl implements PaymentReference {
    @NonNull
    public static final Parcelable.Creator<PaymentReferenceImpl> CREATOR = new Parcelable.Creator<PaymentReferenceImpl>() {
        public PaymentReferenceImpl createFromParcel(@NonNull Parcel parcel) {
            return new PaymentReferenceImpl(parcel);
        }

        public PaymentReferenceImpl[] newArray(int i11) {
            return new PaymentReferenceImpl[i11];
        }
    };
    private final String mPaymentSessionUuid;

    public int describeContents() {
        return 0;
    }

    @NonNull
    public PaymentHandler getPaymentHandler(@NonNull Activity activity) {
        return PaymentHandlerImpl.getPaymentHandler(activity, this);
    }

    @NonNull
    public String getUuid() {
        return this.mPaymentSessionUuid;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        parcel.writeString(this.mPaymentSessionUuid);
    }

    public PaymentReferenceImpl(@NonNull String str) {
        this.mPaymentSessionUuid = str;
    }

    private PaymentReferenceImpl(@NonNull Parcel parcel) {
        this.mPaymentSessionUuid = parcel.readString();
    }
}
