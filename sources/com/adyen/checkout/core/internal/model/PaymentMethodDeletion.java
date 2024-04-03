package com.adyen.checkout.core.internal.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.JsonSerializable;
import org.json.JSONException;
import org.json.JSONObject;

public final class PaymentMethodDeletion implements Parcelable, JsonSerializable {
    @NonNull
    public static final Parcelable.Creator<PaymentMethodDeletion> CREATOR = new Parcelable.Creator<PaymentMethodDeletion>() {
        public PaymentMethodDeletion createFromParcel(Parcel parcel) {
            return new PaymentMethodDeletion(parcel);
        }

        public PaymentMethodDeletion[] newArray(int i11) {
            return new PaymentMethodDeletion[i11];
        }
    };
    /* access modifiers changed from: private */
    public String mPaymentData;
    /* access modifiers changed from: private */
    public String mPaymentMethodData;

    public static final class Builder {
        private PaymentMethodDeletion mPaymentMethodDeletion;

        public Builder(@NonNull String str, @NonNull String str2) {
            PaymentMethodDeletion paymentMethodDeletion = new PaymentMethodDeletion();
            this.mPaymentMethodDeletion = paymentMethodDeletion;
            String unused = paymentMethodDeletion.mPaymentData = str;
            String unused2 = this.mPaymentMethodDeletion.mPaymentMethodData = str2;
        }

        @NonNull
        public PaymentMethodDeletion build() {
            return this.mPaymentMethodDeletion;
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PaymentMethodDeletion.class != obj.getClass()) {
            return false;
        }
        PaymentMethodDeletion paymentMethodDeletion = (PaymentMethodDeletion) obj;
        String str = this.mPaymentData;
        if (str == null ? paymentMethodDeletion.mPaymentData != null : !str.equals(paymentMethodDeletion.mPaymentData)) {
            return false;
        }
        String str2 = this.mPaymentMethodData;
        String str3 = paymentMethodDeletion.mPaymentMethodData;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    @NonNull
    public String getPaymentData() {
        return this.mPaymentData;
    }

    @NonNull
    public String getPaymentMethodData() {
        return this.mPaymentMethodData;
    }

    public int hashCode() {
        int i11;
        String str = this.mPaymentData;
        int i12 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i13 = i11 * 31;
        String str2 = this.mPaymentMethodData;
        if (str2 != null) {
            i12 = str2.hashCode();
        }
        return i13 + i12;
    }

    @NonNull
    public JSONObject serialize() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("paymentData", (Object) this.mPaymentData);
        jSONObject.put("paymentMethodData", (Object) this.mPaymentMethodData);
        return jSONObject;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        parcel.writeString(this.mPaymentData);
        parcel.writeString(this.mPaymentMethodData);
    }

    private PaymentMethodDeletion() {
    }

    private PaymentMethodDeletion(@NonNull Parcel parcel) {
        this.mPaymentData = parcel.readString();
        this.mPaymentMethodData = parcel.readString();
    }
}
