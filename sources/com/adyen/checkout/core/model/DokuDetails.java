package com.adyen.checkout.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public final class DokuDetails extends PaymentMethodDetails {
    @NonNull
    public static final Parcelable.Creator<DokuDetails> CREATOR = new Parcelable.Creator<DokuDetails>() {
        public DokuDetails createFromParcel(Parcel parcel) {
            return new DokuDetails(parcel);
        }

        public DokuDetails[] newArray(int i11) {
            return new DokuDetails[i11];
        }
    };
    @NonNull
    public static final String KEY_FIRST_NAME = "firstName";
    @NonNull
    public static final String KEY_LAST_NAME = "lastName";
    @NonNull
    public static final String KEY_SHOPPER_EMAIL = "shopperEmail";
    /* access modifiers changed from: private */
    public String mFirstName;
    /* access modifiers changed from: private */
    public String mLastName;
    /* access modifiers changed from: private */
    public String mShopperEmail;

    public static final class Builder {
        private final DokuDetails mDokuDetails;

        public Builder(@NonNull String str, @NonNull String str2, @NonNull String str3) {
            DokuDetails dokuDetails = new DokuDetails();
            this.mDokuDetails = dokuDetails;
            String unused = dokuDetails.mShopperEmail = str;
            String unused2 = dokuDetails.mFirstName = str2;
            String unused3 = dokuDetails.mLastName = str3;
        }

        @NonNull
        public DokuDetails build() {
            return this.mDokuDetails;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DokuDetails.class != obj.getClass()) {
            return false;
        }
        DokuDetails dokuDetails = (DokuDetails) obj;
        String str = this.mShopperEmail;
        if (str == null ? dokuDetails.mShopperEmail != null : !str.equals(dokuDetails.mShopperEmail)) {
            return false;
        }
        String str2 = this.mFirstName;
        if (str2 == null ? dokuDetails.mFirstName != null : !str2.equals(dokuDetails.mFirstName)) {
            return false;
        }
        String str3 = this.mLastName;
        String str4 = dokuDetails.mLastName;
        if (str3 != null) {
            return str3.equals(str4);
        }
        if (str4 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i11;
        int i12;
        String str = this.mShopperEmail;
        int i13 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i14 = i11 * 31;
        String str2 = this.mFirstName;
        if (str2 != null) {
            i12 = str2.hashCode();
        } else {
            i12 = 0;
        }
        int i15 = (i14 + i12) * 31;
        String str3 = this.mLastName;
        if (str3 != null) {
            i13 = str3.hashCode();
        }
        return i15 + i13;
    }

    @NonNull
    public JSONObject serialize() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("shopperEmail", (Object) this.mShopperEmail);
        jSONObject.put("firstName", (Object) this.mFirstName);
        jSONObject.put("lastName", (Object) this.mLastName);
        return jSONObject;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        parcel.writeString(this.mShopperEmail);
        parcel.writeString(this.mFirstName);
        parcel.writeString(this.mLastName);
    }

    private DokuDetails() {
    }

    private DokuDetails(@NonNull Parcel parcel) {
        super(parcel);
        this.mShopperEmail = parcel.readString();
        this.mFirstName = parcel.readString();
        this.mLastName = parcel.readString();
    }
}
