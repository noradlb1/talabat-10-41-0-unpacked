package com.adyen.checkout.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.core.CheckoutException;
import com.adyen.checkout.core.internal.model.AdditionalPaymentMethodDetails;
import com.adyen.checkout.core.internal.model.PaymentInitiationResponse;
import com.adyen.checkout.core.internal.model.ThreeDSecureRedirectData;
import org.json.JSONException;
import org.json.JSONObject;

public final class CupSecurePlusDetails extends AdditionalPaymentMethodDetails {
    @NonNull
    public static final Parcelable.Creator<CupSecurePlusDetails> CREATOR = new Parcelable.Creator<CupSecurePlusDetails>() {
        public CupSecurePlusDetails createFromParcel(@NonNull Parcel parcel) {
            return new CupSecurePlusDetails(parcel);
        }

        public CupSecurePlusDetails[] newArray(int i11) {
            return new CupSecurePlusDetails[i11];
        }
    };
    @NonNull
    public static final String KEY_SMS_CODE = "cupsecureplus.smscode";
    private String mMd;
    /* access modifiers changed from: private */
    public String mSmsCode;

    public static final class Builder {
        private final CupSecurePlusDetails mCupSecurePlusDetails;

        public Builder(@NonNull String str) {
            CupSecurePlusDetails cupSecurePlusDetails = new CupSecurePlusDetails();
            this.mCupSecurePlusDetails = cupSecurePlusDetails;
            String unused = cupSecurePlusDetails.mSmsCode = str;
        }

        @NonNull
        public CupSecurePlusDetails build() {
            return this.mCupSecurePlusDetails;
        }
    }

    public void a(@NonNull PaymentInitiationResponse.DetailFields detailFields) throws CheckoutException {
        this.mMd = ((ThreeDSecureRedirectData) detailFields.getRedirectData(ThreeDSecureRedirectData.class)).getMd();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CupSecurePlusDetails.class != obj.getClass()) {
            return false;
        }
        CupSecurePlusDetails cupSecurePlusDetails = (CupSecurePlusDetails) obj;
        String str = this.mSmsCode;
        if (str == null ? cupSecurePlusDetails.mSmsCode != null : !str.equals(cupSecurePlusDetails.mSmsCode)) {
            return false;
        }
        String str2 = this.mMd;
        String str3 = cupSecurePlusDetails.mMd;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i11;
        String str = this.mSmsCode;
        int i12 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i13 = i11 * 31;
        String str2 = this.mMd;
        if (str2 != null) {
            i12 = str2.hashCode();
        }
        return i13 + i12;
    }

    @NonNull
    public JSONObject serialize() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(KEY_SMS_CODE, (Object) this.mSmsCode);
        jSONObject.put("MD", (Object) this.mMd);
        return jSONObject;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        parcel.writeString(this.mSmsCode);
        parcel.writeString(this.mMd);
    }

    private CupSecurePlusDetails() {
    }

    private CupSecurePlusDetails(@NonNull Parcel parcel) {
        this.mSmsCode = parcel.readString();
        this.mMd = parcel.readString();
    }
}
