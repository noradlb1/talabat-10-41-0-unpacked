package com.adyen.checkout.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.Parcelables;
import org.json.JSONException;
import org.json.JSONObject;

public final class PayPalDetails extends PaymentMethodDetails {
    @NonNull
    public static final Parcelable.Creator<PayPalDetails> CREATOR = new Parcelable.Creator<PayPalDetails>() {
        public PayPalDetails createFromParcel(Parcel parcel) {
            return new PayPalDetails(parcel);
        }

        public PayPalDetails[] newArray(int i11) {
            return new PayPalDetails[i11];
        }
    };
    @NonNull
    public static final String KEY_STORE_DETAILS = "storeDetails";
    /* access modifiers changed from: private */
    public Boolean mStoreDetails;

    public static final class Builder {
        private PayPalDetails mPayPalDetails;

        @Nullable
        public PayPalDetails build() {
            return this.mPayPalDetails;
        }

        @NonNull
        public Builder setStoreDetails(@Nullable Boolean bool) {
            if (bool != null) {
                if (this.mPayPalDetails == null) {
                    this.mPayPalDetails = new PayPalDetails();
                }
                Boolean unused = this.mPayPalDetails.mStoreDetails = bool;
            } else {
                this.mPayPalDetails = null;
            }
            return this;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PayPalDetails.class != obj.getClass()) {
            return false;
        }
        Boolean bool = this.mStoreDetails;
        Boolean bool2 = ((PayPalDetails) obj).mStoreDetails;
        if (bool != null) {
            return bool.equals(bool2);
        }
        if (bool2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        Boolean bool = this.mStoreDetails;
        if (bool != null) {
            return bool.hashCode();
        }
        return 0;
    }

    @NonNull
    public JSONObject serialize() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("storeDetails", (Object) this.mStoreDetails);
        return jSONObject;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        Parcelables.writeSerializable(parcel, this.mStoreDetails);
    }

    private PayPalDetails() {
    }

    private PayPalDetails(@NonNull Parcel parcel) {
        super(parcel);
        this.mStoreDetails = (Boolean) Parcelables.readSerializable(parcel);
    }
}
