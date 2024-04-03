package com.adyen.checkout.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public final class FingerprintDetails extends PaymentMethodDetails {
    public static final Parcelable.Creator<FingerprintDetails> CREATOR = new Parcelable.Creator<FingerprintDetails>() {
        public FingerprintDetails createFromParcel(Parcel parcel) {
            return new FingerprintDetails(parcel);
        }

        public FingerprintDetails[] newArray(int i11) {
            return new FingerprintDetails[i11];
        }
    };
    public static final String KEY_THREE_DS_FINGERPRINT = "threeds2.fingerprint";
    private final String mFingerprint;

    public FingerprintDetails(@NonNull String str) {
        this.mFingerprint = str;
    }

    @NonNull
    public JSONObject serialize() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(KEY_THREE_DS_FINGERPRINT, (Object) this.mFingerprint);
        return jSONObject;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        parcel.writeString(this.mFingerprint);
    }

    public FingerprintDetails(@NonNull Parcel parcel) {
        super(parcel);
        this.mFingerprint = parcel.readString();
    }
}
