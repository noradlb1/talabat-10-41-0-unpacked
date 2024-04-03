package com.adyen.checkout.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.Parcelables;
import org.json.JSONException;
import org.json.JSONObject;

public final class CardDetails extends PaymentMethodDetails {
    @NonNull
    public static final Parcelable.Creator<CardDetails> CREATOR = new Parcelable.Creator<CardDetails>() {
        public CardDetails createFromParcel(Parcel parcel) {
            return new CardDetails(parcel);
        }

        public CardDetails[] newArray(int i11) {
            return new CardDetails[i11];
        }
    };
    @NonNull
    public static final String KEY_BILLING_ADDRESS = "billingAddress";
    @NonNull
    public static final String KEY_ENCRYPTED_CARD_NUMBER = "encryptedCardNumber";
    @NonNull
    public static final String KEY_ENCRYPTED_EXPIRY_MONTH = "encryptedExpiryMonth";
    @NonNull
    public static final String KEY_ENCRYPTED_EXPIRY_YEAR = "encryptedExpiryYear";
    @NonNull
    public static final String KEY_ENCRYPTED_SECURITY_CODE = "encryptedSecurityCode";
    @NonNull
    public static final String KEY_HOLDER_NAME = "holderName";
    @NonNull
    public static final String KEY_INSTALLMENTS = "installments";
    @NonNull
    public static final String KEY_PHONE_NUMBER = "telephoneNumber";
    @NonNull
    public static final String KEY_STORE_DETAILS = "storeDetails";
    /* access modifiers changed from: private */
    public Address mBillingAddress;
    /* access modifiers changed from: private */
    public String mEncryptedCardNumber;
    /* access modifiers changed from: private */
    public String mEncryptedExpiryMonth;
    /* access modifiers changed from: private */
    public String mEncryptedExpiryYear;
    /* access modifiers changed from: private */
    public String mEncryptedSecurityCode;
    /* access modifiers changed from: private */
    public String mHolderName;
    /* access modifiers changed from: private */
    public Integer mInstallments;
    /* access modifiers changed from: private */
    public String mPhoneNumber;
    /* access modifiers changed from: private */
    public Boolean mStoreDetails;

    public static final class Builder {
        private final CardDetails mCardDetails = new CardDetails();

        @Nullable
        public CardDetails build() {
            try {
                if (this.mCardDetails.serialize().names().length() == 0) {
                    return null;
                }
                return this.mCardDetails;
            } catch (JSONException unused) {
                throw new RuntimeException("Invalid JSON.");
            }
        }

        @NonNull
        public Builder setBillingAddress(@Nullable Address address) {
            Address unused = this.mCardDetails.mBillingAddress = address;
            return this;
        }

        @NonNull
        public Builder setEncryptedCardNumber(@Nullable String str) {
            String unused = this.mCardDetails.mEncryptedCardNumber = str;
            return this;
        }

        @NonNull
        public Builder setEncryptedExpiryMonth(@Nullable String str) {
            String unused = this.mCardDetails.mEncryptedExpiryMonth = str;
            return this;
        }

        @NonNull
        public Builder setEncryptedExpiryYear(@Nullable String str) {
            String unused = this.mCardDetails.mEncryptedExpiryYear = str;
            return this;
        }

        @NonNull
        public Builder setEncryptedSecurityCode(@Nullable String str) {
            String unused = this.mCardDetails.mEncryptedSecurityCode = str;
            return this;
        }

        @NonNull
        public Builder setHolderName(@Nullable String str) {
            String unused = this.mCardDetails.mHolderName = str;
            return this;
        }

        @NonNull
        public Builder setInstallments(@Nullable Integer num) {
            Integer unused = this.mCardDetails.mInstallments = num;
            return this;
        }

        @NonNull
        public Builder setPhoneNumber(@Nullable String str) {
            String unused = this.mCardDetails.mPhoneNumber = str;
            return this;
        }

        @NonNull
        public Builder setStoreDetails(@Nullable Boolean bool) {
            Boolean unused = this.mCardDetails.mStoreDetails = bool;
            return this;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CardDetails.class != obj.getClass()) {
            return false;
        }
        CardDetails cardDetails = (CardDetails) obj;
        String str = this.mHolderName;
        if (str == null ? cardDetails.mHolderName != null : !str.equals(cardDetails.mHolderName)) {
            return false;
        }
        String str2 = this.mEncryptedCardNumber;
        if (str2 == null ? cardDetails.mEncryptedCardNumber != null : !str2.equals(cardDetails.mEncryptedCardNumber)) {
            return false;
        }
        String str3 = this.mEncryptedExpiryMonth;
        if (str3 == null ? cardDetails.mEncryptedExpiryMonth != null : !str3.equals(cardDetails.mEncryptedExpiryMonth)) {
            return false;
        }
        String str4 = this.mEncryptedExpiryYear;
        if (str4 == null ? cardDetails.mEncryptedExpiryYear != null : !str4.equals(cardDetails.mEncryptedExpiryYear)) {
            return false;
        }
        String str5 = this.mEncryptedSecurityCode;
        if (str5 == null ? cardDetails.mEncryptedSecurityCode != null : !str5.equals(cardDetails.mEncryptedSecurityCode)) {
            return false;
        }
        String str6 = this.mPhoneNumber;
        if (str6 == null ? cardDetails.mPhoneNumber != null : !str6.equals(cardDetails.mPhoneNumber)) {
            return false;
        }
        Boolean bool = this.mStoreDetails;
        if (bool == null ? cardDetails.mStoreDetails != null : !bool.equals(cardDetails.mStoreDetails)) {
            return false;
        }
        Integer num = this.mInstallments;
        if (num == null ? cardDetails.mInstallments != null : !num.equals(cardDetails.mInstallments)) {
            return false;
        }
        Address address = this.mBillingAddress;
        Address address2 = cardDetails.mBillingAddress;
        if (address != null) {
            return address.equals(address2);
        }
        if (address2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        String str = this.mHolderName;
        int i19 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i21 = i11 * 31;
        String str2 = this.mEncryptedCardNumber;
        if (str2 != null) {
            i12 = str2.hashCode();
        } else {
            i12 = 0;
        }
        int i22 = (i21 + i12) * 31;
        String str3 = this.mEncryptedExpiryMonth;
        if (str3 != null) {
            i13 = str3.hashCode();
        } else {
            i13 = 0;
        }
        int i23 = (i22 + i13) * 31;
        String str4 = this.mEncryptedExpiryYear;
        if (str4 != null) {
            i14 = str4.hashCode();
        } else {
            i14 = 0;
        }
        int i24 = (i23 + i14) * 31;
        String str5 = this.mEncryptedSecurityCode;
        if (str5 != null) {
            i15 = str5.hashCode();
        } else {
            i15 = 0;
        }
        int i25 = (i24 + i15) * 31;
        String str6 = this.mPhoneNumber;
        if (str6 != null) {
            i16 = str6.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i25 + i16) * 31;
        Boolean bool = this.mStoreDetails;
        if (bool != null) {
            i17 = bool.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        Integer num = this.mInstallments;
        if (num != null) {
            i18 = num.hashCode();
        } else {
            i18 = 0;
        }
        int i28 = (i27 + i18) * 31;
        Address address = this.mBillingAddress;
        if (address != null) {
            i19 = address.hashCode();
        }
        return i28 + i19;
    }

    @NonNull
    public JSONObject serialize() throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("holderName", (Object) this.mHolderName);
        jSONObject2.put(KEY_ENCRYPTED_CARD_NUMBER, (Object) this.mEncryptedCardNumber);
        jSONObject2.put(KEY_ENCRYPTED_EXPIRY_MONTH, (Object) this.mEncryptedExpiryMonth);
        jSONObject2.put(KEY_ENCRYPTED_EXPIRY_YEAR, (Object) this.mEncryptedExpiryYear);
        jSONObject2.put(KEY_ENCRYPTED_SECURITY_CODE, (Object) this.mEncryptedSecurityCode);
        jSONObject2.put("telephoneNumber", (Object) this.mPhoneNumber);
        jSONObject2.put("storeDetails", (Object) this.mStoreDetails);
        jSONObject2.put(KEY_INSTALLMENTS, (Object) this.mInstallments);
        Address address = this.mBillingAddress;
        if (address != null) {
            jSONObject = address.serialize();
        } else {
            jSONObject = null;
        }
        jSONObject2.put("billingAddress", (Object) jSONObject);
        return jSONObject2;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        parcel.writeString(this.mHolderName);
        parcel.writeString(this.mEncryptedCardNumber);
        parcel.writeString(this.mEncryptedExpiryMonth);
        parcel.writeString(this.mEncryptedExpiryYear);
        parcel.writeString(this.mEncryptedSecurityCode);
        parcel.writeString(this.mPhoneNumber);
        Parcelables.writeSerializable(parcel, this.mStoreDetails);
        Parcelables.writeSerializable(parcel, this.mInstallments);
        Parcelables.write(parcel, this.mBillingAddress);
    }

    private CardDetails() {
    }

    private CardDetails(@NonNull Parcel parcel) {
        super(parcel);
        this.mHolderName = parcel.readString();
        this.mEncryptedCardNumber = parcel.readString();
        this.mEncryptedExpiryMonth = parcel.readString();
        this.mEncryptedExpiryYear = parcel.readString();
        this.mEncryptedSecurityCode = parcel.readString();
        this.mPhoneNumber = parcel.readString();
        this.mStoreDetails = (Boolean) Parcelables.readSerializable(parcel);
        this.mInstallments = (Integer) Parcelables.readSerializable(parcel);
        this.mBillingAddress = (Address) Parcelables.read(parcel, Address.class);
    }
}
