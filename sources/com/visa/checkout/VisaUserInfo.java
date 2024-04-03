package com.visa.checkout;

import android.os.Parcel;
import android.os.Parcelable;

public final class VisaUserInfo implements Parcelable {
    public static final Parcelable.Creator<VisaUserInfo> CREATOR = new Parcelable.Creator<VisaUserInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new VisaUserInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
            return new VisaUserInfo[0];
        }
    };
    private VisaUserAddress billingAddress;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private VisaUserAddress shippingAddress;

    public final int describeContents() {
        return 0;
    }

    public final VisaUserAddress getBillingAddress() {
        return this.billingAddress;
    }

    public final String getEmailAddress() {
        return this.emailAddress;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final VisaUserAddress getShippingAddress() {
        return this.shippingAddress;
    }

    public final void setBillingAddress(VisaUserAddress visaUserAddress) {
        this.billingAddress = visaUserAddress;
    }

    public final void setEmailAddress(String str) {
        this.emailAddress = str;
    }

    public final void setFirstName(String str) {
        this.firstName = str;
    }

    public final void setLastName(String str) {
        this.lastName = str;
    }

    public final void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public final void setShippingAddress(VisaUserAddress visaUserAddress) {
        this.shippingAddress = visaUserAddress;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.firstName);
        parcel.writeString(this.lastName);
        parcel.writeString(this.emailAddress);
        parcel.writeString(this.phoneNumber);
        parcel.writeParcelable(this.billingAddress, i11);
        parcel.writeParcelable(this.shippingAddress, i11);
    }

    private VisaUserInfo(Parcel parcel) {
        this.firstName = parcel.readString();
        this.lastName = parcel.readString();
        this.emailAddress = parcel.readString();
        this.phoneNumber = parcel.readString();
        this.billingAddress = (VisaUserAddress) parcel.readParcelable((ClassLoader) null);
        this.shippingAddress = (VisaUserAddress) parcel.readParcelable((ClassLoader) null);
    }

    public VisaUserInfo() {
    }
}
