package com.adyen.checkout.core.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.JsonSerializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class PersonalDetails implements Parcelable, JsonSerializable {
    @NonNull
    public static final Parcelable.Creator<PersonalDetails> CREATOR = new Parcelable.Creator<PersonalDetails>() {
        public PersonalDetails createFromParcel(@NonNull Parcel parcel) {
            return new PersonalDetails(parcel);
        }

        public PersonalDetails[] newArray(int i11) {
            return new PersonalDetails[i11];
        }
    };
    private static final String DATE_FORMAT = "yyyy-MM-dd";
    @NonNull
    public static final String KEY_DATE_OF_BIRTH = "dateOfBirth";
    @NonNull
    public static final String KEY_FIRST_NAME = "firstName";
    @NonNull
    public static final String KEY_GENDER = "gender";
    @NonNull
    public static final String KEY_LAST_NAME = "lastName";
    @NonNull
    public static final String KEY_SHOPPER_EMAIL = "shopperEmail";
    @NonNull
    public static final String KEY_SOCIAL_SECURITY_NUMBER = "socialSecurityNumber";
    @NonNull
    public static final String KEY_TELEPHONE_NUMBER = "telephoneNumber";
    /* access modifiers changed from: private */
    public String mDateOfBirth;
    /* access modifiers changed from: private */
    public String mFirstName;
    /* access modifiers changed from: private */
    public String mGender;
    /* access modifiers changed from: private */
    public String mLastName;
    /* access modifiers changed from: private */
    public String mShopperEmail;
    /* access modifiers changed from: private */
    public String mSocialSecurityNumber;
    /* access modifiers changed from: private */
    public String mTelephoneNumber;

    public static final class Builder {
        private PersonalDetails mPersonalDetails;

        public Builder(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) {
            PersonalDetails personalDetails = new PersonalDetails();
            this.mPersonalDetails = personalDetails;
            String unused = personalDetails.mFirstName = str;
            String unused2 = this.mPersonalDetails.mLastName = str2;
            String unused3 = this.mPersonalDetails.mTelephoneNumber = str3;
            String unused4 = this.mPersonalDetails.mShopperEmail = str4;
        }

        @NonNull
        public PersonalDetails build() {
            return this.mPersonalDetails;
        }

        @NonNull
        public Builder setDateOfBirth(@Nullable Date date) {
            if (date != null) {
                String unused = this.mPersonalDetails.mDateOfBirth = new SimpleDateFormat(PersonalDetails.DATE_FORMAT, Locale.US).format(date);
            }
            return this;
        }

        @NonNull
        public Builder setGender(@Nullable String str) {
            String unused = this.mPersonalDetails.mGender = str;
            return this;
        }

        @NonNull
        public Builder setSocialSecurityNumber(@Nullable String str) {
            String unused = this.mPersonalDetails.mSocialSecurityNumber = str;
            return this;
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PersonalDetails.class != obj.getClass()) {
            return false;
        }
        PersonalDetails personalDetails = (PersonalDetails) obj;
        String str = this.mFirstName;
        if (str == null ? personalDetails.mFirstName != null : !str.equals(personalDetails.mFirstName)) {
            return false;
        }
        String str2 = this.mGender;
        if (str2 == null ? personalDetails.mGender != null : !str2.equals(personalDetails.mGender)) {
            return false;
        }
        String str3 = this.mLastName;
        if (str3 == null ? personalDetails.mLastName != null : !str3.equals(personalDetails.mLastName)) {
            return false;
        }
        String str4 = this.mDateOfBirth;
        if (str4 == null ? personalDetails.mDateOfBirth != null : !str4.equals(personalDetails.mDateOfBirth)) {
            return false;
        }
        String str5 = this.mTelephoneNumber;
        if (str5 == null ? personalDetails.mTelephoneNumber != null : !str5.equals(personalDetails.mTelephoneNumber)) {
            return false;
        }
        String str6 = this.mSocialSecurityNumber;
        if (str6 == null ? personalDetails.mSocialSecurityNumber != null : !str6.equals(personalDetails.mSocialSecurityNumber)) {
            return false;
        }
        String str7 = this.mShopperEmail;
        String str8 = personalDetails.mShopperEmail;
        if (str7 != null) {
            return str7.equals(str8);
        }
        if (str8 == null) {
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
        String str = this.mFirstName;
        int i17 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i18 = i11 * 31;
        String str2 = this.mGender;
        if (str2 != null) {
            i12 = str2.hashCode();
        } else {
            i12 = 0;
        }
        int i19 = (i18 + i12) * 31;
        String str3 = this.mLastName;
        if (str3 != null) {
            i13 = str3.hashCode();
        } else {
            i13 = 0;
        }
        int i21 = (i19 + i13) * 31;
        String str4 = this.mDateOfBirth;
        if (str4 != null) {
            i14 = str4.hashCode();
        } else {
            i14 = 0;
        }
        int i22 = (i21 + i14) * 31;
        String str5 = this.mTelephoneNumber;
        if (str5 != null) {
            i15 = str5.hashCode();
        } else {
            i15 = 0;
        }
        int i23 = (i22 + i15) * 31;
        String str6 = this.mSocialSecurityNumber;
        if (str6 != null) {
            i16 = str6.hashCode();
        } else {
            i16 = 0;
        }
        int i24 = (i23 + i16) * 31;
        String str7 = this.mShopperEmail;
        if (str7 != null) {
            i17 = str7.hashCode();
        }
        return i24 + i17;
    }

    @NonNull
    public JSONObject serialize() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("firstName", (Object) this.mFirstName);
        jSONObject.put("lastName", (Object) this.mLastName);
        jSONObject.put("gender", (Object) this.mGender);
        jSONObject.put("dateOfBirth", (Object) this.mDateOfBirth);
        jSONObject.put("telephoneNumber", (Object) this.mTelephoneNumber);
        jSONObject.put(KEY_SOCIAL_SECURITY_NUMBER, (Object) this.mSocialSecurityNumber);
        jSONObject.put("shopperEmail", (Object) this.mShopperEmail);
        return jSONObject;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        parcel.writeString(this.mFirstName);
        parcel.writeString(this.mLastName);
        parcel.writeString(this.mGender);
        parcel.writeString(this.mDateOfBirth);
        parcel.writeString(this.mTelephoneNumber);
        parcel.writeString(this.mSocialSecurityNumber);
        parcel.writeString(this.mShopperEmail);
    }

    private PersonalDetails() {
    }

    private PersonalDetails(@NonNull Parcel parcel) {
        this.mFirstName = parcel.readString();
        this.mLastName = parcel.readString();
        this.mGender = parcel.readString();
        this.mDateOfBirth = parcel.readString();
        this.mTelephoneNumber = parcel.readString();
        this.mSocialSecurityNumber = parcel.readString();
        this.mShopperEmail = parcel.readString();
    }
}
