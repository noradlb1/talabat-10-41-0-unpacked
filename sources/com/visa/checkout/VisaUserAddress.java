package com.visa.checkout;

import android.os.Parcel;
import android.os.Parcelable;

public final class VisaUserAddress implements Parcelable {
    public static final Parcelable.Creator<VisaUserAddress> CREATOR = new Parcelable.Creator<VisaUserAddress>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new VisaUserAddress(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
            return new VisaUserAddress[0];
        }
    };
    private String city;
    private String line1;
    private String line2;
    private String line3;
    private String personName;
    private String phone;
    private String postalCode;
    private String stateProvinceCode;
    private String twoCharacterCountryCode;

    public final int describeContents() {
        return 0;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getLine1() {
        return this.line1;
    }

    public final String getLine2() {
        return this.line2;
    }

    public final String getLine3() {
        return this.line3;
    }

    public final String getPersonName() {
        return this.personName;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getPostalCode() {
        return this.postalCode;
    }

    public final String getStateProvinceCode() {
        return this.stateProvinceCode;
    }

    public final String getTwoCharacterCountryCode() {
        return this.twoCharacterCountryCode;
    }

    public final void setCity(String str) {
        this.city = str;
    }

    public final void setLine1(String str) {
        this.line1 = str;
    }

    public final void setLine2(String str) {
        this.line2 = str;
    }

    public final void setLine3(String str) {
        this.line3 = str;
    }

    public final void setPersonName(String str) {
        this.personName = str;
    }

    public final void setPhone(String str) {
        this.phone = str;
    }

    public final void setPostalCode(String str) {
        this.postalCode = str;
    }

    public final void setStateProvinceCode(String str) {
        this.stateProvinceCode = str;
    }

    public final void setTwoCharacterCountryCode(String str) {
        this.twoCharacterCountryCode = str;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.personName);
        parcel.writeString(this.line1);
        parcel.writeString(this.line2);
        parcel.writeString(this.line3);
        parcel.writeString(this.city);
        parcel.writeString(this.stateProvinceCode);
        parcel.writeString(this.postalCode);
        parcel.writeString(this.twoCharacterCountryCode);
        parcel.writeString(this.phone);
    }

    private VisaUserAddress(Parcel parcel) {
        this.personName = parcel.readString();
        this.line1 = parcel.readString();
        this.line2 = parcel.readString();
        this.line3 = parcel.readString();
        this.city = parcel.readString();
        this.stateProvinceCode = parcel.readString();
        this.postalCode = parcel.readString();
        this.twoCharacterCountryCode = parcel.readString();
        this.phone = parcel.readString();
    }
}
