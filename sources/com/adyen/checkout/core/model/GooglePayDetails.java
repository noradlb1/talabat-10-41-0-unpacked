package com.adyen.checkout.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public final class GooglePayDetails extends PaymentMethodDetails {
    @NonNull
    public static final Parcelable.Creator<GooglePayDetails> CREATOR = new Parcelable.Creator<GooglePayDetails>() {
        public GooglePayDetails createFromParcel(Parcel parcel) {
            return new GooglePayDetails(parcel);
        }

        public GooglePayDetails[] newArray(int i11) {
            return new GooglePayDetails[i11];
        }
    };
    @NonNull
    public static final String KEY_ADDITIONAL_DATA_TOKEN = "additionalData.paywithgoogle.token";
    /* access modifiers changed from: private */
    public String mToken;

    public static final class Builder {
        private final GooglePayDetails mGooglePayDetails;

        public Builder(@NonNull String str) {
            GooglePayDetails googlePayDetails = new GooglePayDetails();
            this.mGooglePayDetails = googlePayDetails;
            String unused = googlePayDetails.mToken = str;
        }

        @NonNull
        public GooglePayDetails build() {
            return this.mGooglePayDetails;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GooglePayDetails.class != obj.getClass()) {
            return false;
        }
        String str = this.mToken;
        String str2 = ((GooglePayDetails) obj).mToken;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.mToken;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @NonNull
    public JSONObject serialize() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(KEY_ADDITIONAL_DATA_TOKEN, (Object) this.mToken);
        return jSONObject;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        parcel.writeString(this.mToken);
    }

    private GooglePayDetails() {
    }

    private GooglePayDetails(@NonNull Parcel parcel) {
        super(parcel);
        this.mToken = parcel.readString();
    }
}
