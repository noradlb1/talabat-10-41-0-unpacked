package com.adyen.checkout.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public final class IssuerDetails extends PaymentMethodDetails {
    @NonNull
    public static final Parcelable.Creator<IssuerDetails> CREATOR = new Parcelable.Creator<IssuerDetails>() {
        public IssuerDetails createFromParcel(@NonNull Parcel parcel) {
            return new IssuerDetails(parcel);
        }

        public IssuerDetails[] newArray(int i11) {
            return new IssuerDetails[i11];
        }
    };
    @NonNull
    public static final String KEY_ISSUER = "issuer";
    /* access modifiers changed from: private */
    public String mIssuer;

    public static final class Builder {
        private final IssuerDetails mIssuerDetails;

        public Builder(@NonNull String str) {
            IssuerDetails issuerDetails = new IssuerDetails();
            this.mIssuerDetails = issuerDetails;
            String unused = issuerDetails.mIssuer = str;
        }

        @NonNull
        public IssuerDetails build() {
            return this.mIssuerDetails;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || IssuerDetails.class != obj.getClass()) {
            return false;
        }
        String str = this.mIssuer;
        String str2 = ((IssuerDetails) obj).mIssuer;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.mIssuer;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @NonNull
    public JSONObject serialize() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(KEY_ISSUER, (Object) this.mIssuer);
        return jSONObject;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        parcel.writeString(this.mIssuer);
    }

    private IssuerDetails() {
    }

    private IssuerDetails(@NonNull Parcel parcel) {
        super(parcel);
        this.mIssuer = parcel.readString();
    }
}
