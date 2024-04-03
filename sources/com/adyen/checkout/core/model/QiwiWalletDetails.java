package com.adyen.checkout.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public final class QiwiWalletDetails extends PaymentMethodDetails {
    @NonNull
    public static final Parcelable.Creator<QiwiWalletDetails> CREATOR = new Parcelable.Creator<QiwiWalletDetails>() {
        public QiwiWalletDetails createFromParcel(Parcel parcel) {
            return new QiwiWalletDetails(parcel);
        }

        public QiwiWalletDetails[] newArray(int i11) {
            return new QiwiWalletDetails[i11];
        }
    };
    @NonNull
    public static final String KEY_TELEPHONE_NUMBER = "qiwiwallet.telephoneNumber";
    @NonNull
    public static final String KEY_TELEPHONE_NUMBER_PREFIX = "qiwiwallet.telephoneNumberPrefix";
    /* access modifiers changed from: private */
    public String mTelephoneNumber;
    /* access modifiers changed from: private */
    public String mTelephoneNumberPrefix;

    public static final class Builder {
        private final QiwiWalletDetails mQiwiWalletDetails;

        public Builder(@NonNull String str, @NonNull String str2) {
            QiwiWalletDetails qiwiWalletDetails = new QiwiWalletDetails();
            this.mQiwiWalletDetails = qiwiWalletDetails;
            String unused = qiwiWalletDetails.mTelephoneNumberPrefix = str;
            String unused2 = qiwiWalletDetails.mTelephoneNumber = str2;
        }

        @NonNull
        public QiwiWalletDetails build() {
            return this.mQiwiWalletDetails;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || QiwiWalletDetails.class != obj.getClass()) {
            return false;
        }
        QiwiWalletDetails qiwiWalletDetails = (QiwiWalletDetails) obj;
        String str = this.mTelephoneNumberPrefix;
        if (str == null ? qiwiWalletDetails.mTelephoneNumberPrefix != null : !str.equals(qiwiWalletDetails.mTelephoneNumberPrefix)) {
            return false;
        }
        String str2 = this.mTelephoneNumber;
        String str3 = qiwiWalletDetails.mTelephoneNumber;
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
        String str = this.mTelephoneNumberPrefix;
        int i12 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i13 = i11 * 31;
        String str2 = this.mTelephoneNumber;
        if (str2 != null) {
            i12 = str2.hashCode();
        }
        return i13 + i12;
    }

    @NonNull
    public JSONObject serialize() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(KEY_TELEPHONE_NUMBER_PREFIX, (Object) this.mTelephoneNumberPrefix);
        jSONObject.put(KEY_TELEPHONE_NUMBER, (Object) this.mTelephoneNumber);
        return jSONObject;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        parcel.writeString(this.mTelephoneNumberPrefix);
        parcel.writeString(this.mTelephoneNumber);
    }

    private QiwiWalletDetails() {
    }

    private QiwiWalletDetails(@NonNull Parcel parcel) {
        super(parcel);
        this.mTelephoneNumberPrefix = parcel.readString();
        this.mTelephoneNumber = parcel.readString();
    }
}
