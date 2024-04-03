package com.adyen.checkout.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.core.internal.model.AdditionalPaymentMethodDetails;
import com.adyen.checkout.core.internal.model.PaymentInitiationResponse;
import org.json.JSONException;
import org.json.JSONObject;

public final class WeChatPayDetails extends AdditionalPaymentMethodDetails {
    @NonNull
    public static final Parcelable.Creator<WeChatPayDetails> CREATOR = new Parcelable.Creator<WeChatPayDetails>() {
        public WeChatPayDetails createFromParcel(Parcel parcel) {
            return new WeChatPayDetails(parcel);
        }

        public WeChatPayDetails[] newArray(int i11) {
            return new WeChatPayDetails[i11];
        }
    };
    private static final String KEY_PAYMENT_METHOD_RETURN_DATA = "paymentMethodReturnData";
    @NonNull
    public static final String KEY_RESULT_CODE = "resultCode";
    private String mPaymentMethodReturnData;
    /* access modifiers changed from: private */
    public String mResultCode;

    public static final class Builder {
        private final WeChatPayDetails mWeChatPayDetails;

        public Builder(@NonNull String str) {
            WeChatPayDetails weChatPayDetails = new WeChatPayDetails();
            this.mWeChatPayDetails = weChatPayDetails;
            String unused = weChatPayDetails.mResultCode = str;
        }

        @NonNull
        public WeChatPayDetails build() {
            return this.mWeChatPayDetails;
        }
    }

    public void a(@NonNull PaymentInitiationResponse.DetailFields detailFields) {
        this.mPaymentMethodReturnData = detailFields.getPaymentMethodReturnData();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WeChatPayDetails.class != obj.getClass()) {
            return false;
        }
        WeChatPayDetails weChatPayDetails = (WeChatPayDetails) obj;
        String str = this.mResultCode;
        if (str == null ? weChatPayDetails.mResultCode != null : !str.equals(weChatPayDetails.mResultCode)) {
            return false;
        }
        String str2 = this.mPaymentMethodReturnData;
        if (str2 != null) {
            return str2.equals(weChatPayDetails.mPaymentMethodReturnData);
        }
        if (weChatPayDetails.mPaymentMethodReturnData == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i11;
        String str = this.mResultCode;
        int i12 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i13 = i11 * 31;
        String str2 = this.mPaymentMethodReturnData;
        if (str2 != null) {
            i12 = str2.hashCode();
        }
        return i13 + i12;
    }

    @NonNull
    public JSONObject serialize() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(KEY_RESULT_CODE, (Object) this.mResultCode);
        jSONObject.put(KEY_PAYMENT_METHOD_RETURN_DATA, (Object) this.mPaymentMethodReturnData);
        return jSONObject;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        parcel.writeString(this.mResultCode);
        parcel.writeString(this.mPaymentMethodReturnData);
    }

    private WeChatPayDetails() {
    }

    private WeChatPayDetails(@NonNull Parcel parcel) {
        super(parcel);
        this.mResultCode = parcel.readString();
        this.mPaymentMethodReturnData = parcel.readString();
    }
}
