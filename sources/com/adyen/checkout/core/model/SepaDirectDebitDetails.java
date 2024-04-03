package com.adyen.checkout.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public final class SepaDirectDebitDetails extends PaymentMethodDetails {
    @NonNull
    public static final Parcelable.Creator<SepaDirectDebitDetails> CREATOR = new Parcelable.Creator<SepaDirectDebitDetails>() {
        public SepaDirectDebitDetails createFromParcel(Parcel parcel) {
            return new SepaDirectDebitDetails(parcel);
        }

        public SepaDirectDebitDetails[] newArray(int i11) {
            return new SepaDirectDebitDetails[i11];
        }
    };
    @NonNull
    public static final String KEY_SEPA_IBAN_NUMBER = "sepa.ibanNumber";
    @NonNull
    public static final String KEY_SEPA_OWNER_NAME = "sepa.ownerName";
    /* access modifiers changed from: private */
    public String mSepaIbanNumber;
    /* access modifiers changed from: private */
    public String mSepaOwnerName;

    public static final class Builder {
        private final SepaDirectDebitDetails mSepaDirectDebitDetails;

        public Builder(@NonNull String str, @NonNull String str2) {
            SepaDirectDebitDetails sepaDirectDebitDetails = new SepaDirectDebitDetails();
            this.mSepaDirectDebitDetails = sepaDirectDebitDetails;
            String unused = sepaDirectDebitDetails.mSepaIbanNumber = str;
            String unused2 = sepaDirectDebitDetails.mSepaOwnerName = str2;
        }

        @NonNull
        public SepaDirectDebitDetails build() {
            return this.mSepaDirectDebitDetails;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SepaDirectDebitDetails.class != obj.getClass()) {
            return false;
        }
        SepaDirectDebitDetails sepaDirectDebitDetails = (SepaDirectDebitDetails) obj;
        String str = this.mSepaIbanNumber;
        if (str == null ? sepaDirectDebitDetails.mSepaIbanNumber != null : !str.equals(sepaDirectDebitDetails.mSepaIbanNumber)) {
            return false;
        }
        String str2 = this.mSepaOwnerName;
        String str3 = sepaDirectDebitDetails.mSepaOwnerName;
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
        String str = this.mSepaIbanNumber;
        int i12 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i13 = i11 * 31;
        String str2 = this.mSepaOwnerName;
        if (str2 != null) {
            i12 = str2.hashCode();
        }
        return i13 + i12;
    }

    @NonNull
    public JSONObject serialize() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(KEY_SEPA_IBAN_NUMBER, (Object) this.mSepaIbanNumber);
        jSONObject.put(KEY_SEPA_OWNER_NAME, (Object) this.mSepaOwnerName);
        return jSONObject;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        parcel.writeString(this.mSepaIbanNumber);
        parcel.writeString(this.mSepaOwnerName);
    }

    private SepaDirectDebitDetails() {
    }

    private SepaDirectDebitDetails(@NonNull Parcel parcel) {
        super(parcel);
        this.mSepaIbanNumber = parcel.readString();
        this.mSepaOwnerName = parcel.readString();
    }
}
