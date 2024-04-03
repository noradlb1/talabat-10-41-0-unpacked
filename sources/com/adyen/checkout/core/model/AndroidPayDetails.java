package com.adyen.checkout.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public final class AndroidPayDetails extends PaymentMethodDetails {
    @NonNull
    public static final Parcelable.Creator<AndroidPayDetails> CREATOR = new Parcelable.Creator<AndroidPayDetails>() {
        public AndroidPayDetails createFromParcel(Parcel parcel) {
            return new AndroidPayDetails(parcel);
        }

        public AndroidPayDetails[] newArray(int i11) {
            return new AndroidPayDetails[i11];
        }
    };
    @NonNull
    public static final String KEY_ADDITIONAL_DATA_TOKEN = "additionalData.androidpay.token";
    /* access modifiers changed from: private */
    public String mToken;

    public static final class Builder {
        private final AndroidPayDetails mAndroidPayDetails;

        public Builder(@NonNull String str) {
            AndroidPayDetails androidPayDetails = new AndroidPayDetails();
            this.mAndroidPayDetails = androidPayDetails;
            String unused = androidPayDetails.mToken = str;
        }

        @NonNull
        public AndroidPayDetails build() {
            return this.mAndroidPayDetails;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AndroidPayDetails.class != obj.getClass()) {
            return false;
        }
        String str = this.mToken;
        String str2 = ((AndroidPayDetails) obj).mToken;
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

    private AndroidPayDetails() {
    }

    private AndroidPayDetails(@NonNull Parcel parcel) {
        super(parcel);
        this.mToken = parcel.readString();
    }
}
