package com.adyen.checkout.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public final class GiroPayDetails extends PaymentMethodDetails {
    @NonNull
    public static final Parcelable.Creator<GiroPayDetails> CREATOR = new Parcelable.Creator<GiroPayDetails>() {
        public GiroPayDetails createFromParcel(Parcel parcel) {
            return new GiroPayDetails(parcel);
        }

        public GiroPayDetails[] newArray(int i11) {
            return new GiroPayDetails[i11];
        }
    };
    @NonNull
    public static final String KEY_GIROPAY_BIC = "bic";
    /* access modifiers changed from: private */
    public String mBic;

    public static final class Builder {
        private GiroPayDetails mGiroPayDetails;

        @Nullable
        public GiroPayDetails build() {
            return this.mGiroPayDetails;
        }

        @NonNull
        public Builder setBic(@Nullable String str) {
            if (str != null) {
                if (this.mGiroPayDetails == null) {
                    this.mGiroPayDetails = new GiroPayDetails();
                }
                String unused = this.mGiroPayDetails.mBic = str;
            } else {
                this.mGiroPayDetails = null;
            }
            return this;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GiroPayDetails.class != obj.getClass()) {
            return false;
        }
        String str = this.mBic;
        String str2 = ((GiroPayDetails) obj).mBic;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.mBic;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @NonNull
    public JSONObject serialize() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(KEY_GIROPAY_BIC, (Object) this.mBic);
        return jSONObject;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        parcel.writeString(this.mBic);
    }

    private GiroPayDetails() {
    }

    private GiroPayDetails(@NonNull Parcel parcel) {
        super(parcel);
        this.mBic = parcel.readString();
    }
}
