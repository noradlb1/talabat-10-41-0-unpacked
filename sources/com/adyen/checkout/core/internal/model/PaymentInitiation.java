package com.adyen.checkout.core.internal.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.JsonSerializable;
import com.adyen.checkout.base.internal.Parcelables;
import com.adyen.checkout.core.model.PaymentMethodDetails;
import org.json.JSONException;
import org.json.JSONObject;

public final class PaymentInitiation implements Parcelable, JsonSerializable {
    @NonNull
    public static final Parcelable.Creator<PaymentInitiation> CREATOR = new Parcelable.Creator<PaymentInitiation>() {
        public PaymentInitiation createFromParcel(Parcel parcel) {
            return new PaymentInitiation(parcel);
        }

        public PaymentInitiation[] newArray(int i11) {
            return new PaymentInitiation[i11];
        }
    };
    /* access modifiers changed from: private */
    public String mPaymentData;
    /* access modifiers changed from: private */
    public String mPaymentMethodData;
    /* access modifiers changed from: private */
    public PaymentMethodDetails mPaymentMethodDetails;

    public static final class Builder {
        private PaymentInitiation mPaymentInitiation;

        public Builder(@NonNull String str, @NonNull String str2) {
            PaymentInitiation paymentInitiation = new PaymentInitiation();
            this.mPaymentInitiation = paymentInitiation;
            String unused = paymentInitiation.mPaymentData = str;
            String unused2 = this.mPaymentInitiation.mPaymentMethodData = str2;
        }

        @NonNull
        public PaymentInitiation build() {
            return this.mPaymentInitiation;
        }

        @NonNull
        public Builder setPaymentMethodDetails(@Nullable PaymentMethodDetails paymentMethodDetails) {
            PaymentMethodDetails unused = this.mPaymentInitiation.mPaymentMethodDetails = paymentMethodDetails;
            return this;
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PaymentInitiation.class != obj.getClass()) {
            return false;
        }
        PaymentInitiation paymentInitiation = (PaymentInitiation) obj;
        String str = this.mPaymentData;
        if (str == null ? paymentInitiation.mPaymentData != null : !str.equals(paymentInitiation.mPaymentData)) {
            return false;
        }
        String str2 = this.mPaymentMethodData;
        if (str2 == null ? paymentInitiation.mPaymentMethodData != null : !str2.equals(paymentInitiation.mPaymentMethodData)) {
            return false;
        }
        PaymentMethodDetails paymentMethodDetails = this.mPaymentMethodDetails;
        PaymentMethodDetails paymentMethodDetails2 = paymentInitiation.mPaymentMethodDetails;
        if (paymentMethodDetails != null) {
            return paymentMethodDetails.equals(paymentMethodDetails2);
        }
        if (paymentMethodDetails2 == null) {
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
        int i12;
        String str = this.mPaymentData;
        int i13 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i14 = i11 * 31;
        String str2 = this.mPaymentMethodData;
        if (str2 != null) {
            i12 = str2.hashCode();
        } else {
            i12 = 0;
        }
        int i15 = (i14 + i12) * 31;
        PaymentMethodDetails paymentMethodDetails = this.mPaymentMethodDetails;
        if (paymentMethodDetails != null) {
            i13 = paymentMethodDetails.hashCode();
        }
        return i15 + i13;
    }

    @NonNull
    public JSONObject serialize() throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("paymentData", (Object) this.mPaymentData);
        jSONObject2.put("paymentMethodData", (Object) this.mPaymentMethodData);
        PaymentMethodDetails paymentMethodDetails = this.mPaymentMethodDetails;
        if (paymentMethodDetails != null) {
            jSONObject = paymentMethodDetails.serialize();
        } else {
            jSONObject = null;
        }
        jSONObject2.putOpt("paymentDetails", jSONObject);
        return jSONObject2;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        parcel.writeString(this.mPaymentData);
        parcel.writeString(this.mPaymentMethodData);
        Parcelables.write(parcel, this.mPaymentMethodDetails);
    }

    private PaymentInitiation() {
    }

    private PaymentInitiation(@NonNull Parcel parcel) {
        this.mPaymentData = parcel.readString();
        this.mPaymentMethodData = parcel.readString();
        this.mPaymentMethodDetails = (PaymentMethodDetails) Parcelables.read(parcel, PaymentMethodDetails.class);
    }
}
