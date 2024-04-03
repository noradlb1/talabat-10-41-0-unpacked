package com.adyen.checkout.core.internal.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.core.model.PaymentMethodDetails;
import org.json.JSONException;
import org.json.JSONObject;

public final class AppResponseDetails extends PaymentMethodDetails {
    @NonNull
    public static final Parcelable.Creator<AppResponseDetails> CREATOR = new Parcelable.Creator<AppResponseDetails>() {
        public AppResponseDetails createFromParcel(Parcel parcel) {
            return new AppResponseDetails(parcel);
        }

        public AppResponseDetails[] newArray(int i11) {
            return new AppResponseDetails[i11];
        }
    };
    @NonNull
    public static final String KEY_RETURN_URL_QUERY_STRING = "returnUrlQueryString";
    /* access modifiers changed from: private */
    public String mReturnUrlQueryString;

    public static final class Builder {
        private final AppResponseDetails mAppResponseDetails;

        public Builder(@NonNull String str) {
            AppResponseDetails appResponseDetails = new AppResponseDetails();
            this.mAppResponseDetails = appResponseDetails;
            String unused = appResponseDetails.mReturnUrlQueryString = str;
        }

        @NonNull
        public AppResponseDetails build() {
            return this.mAppResponseDetails;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AppResponseDetails.class != obj.getClass()) {
            return false;
        }
        String str = this.mReturnUrlQueryString;
        String str2 = ((AppResponseDetails) obj).mReturnUrlQueryString;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.mReturnUrlQueryString;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @NonNull
    public JSONObject serialize() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(KEY_RETURN_URL_QUERY_STRING, (Object) this.mReturnUrlQueryString);
        return jSONObject;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        parcel.writeString(this.mReturnUrlQueryString);
    }

    private AppResponseDetails() {
    }

    private AppResponseDetails(@NonNull Parcel parcel) {
        super(parcel);
        this.mReturnUrlQueryString = parcel.readString();
    }
}
