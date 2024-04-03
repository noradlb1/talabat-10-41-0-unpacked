package com.huawei.wearengine.p2p;

import android.os.Parcel;
import android.os.Parcelable;

public class IdentityInfo implements Parcelable {
    public static final Parcelable.Creator<IdentityInfo> CREATOR = new a();
    private String mFingerPrint;
    private String mPackageName;

    public static class a implements Parcelable.Creator<IdentityInfo> {
        public Object createFromParcel(Parcel parcel) {
            IdentityInfo identityInfo = new IdentityInfo();
            identityInfo.setPackageName(parcel.readString());
            identityInfo.setFingerPrint(parcel.readString());
            return identityInfo;
        }

        public Object[] newArray(int i11) {
            return new IdentityInfo[i11];
        }
    }

    public IdentityInfo() {
    }

    public IdentityInfo(String str, String str2) {
        this.mPackageName = str;
        this.mFingerPrint = str2;
    }

    public int describeContents() {
        return 0;
    }

    public String getFingerPrint() {
        return this.mFingerPrint;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public void readFromParcel(Parcel parcel) {
        this.mPackageName = parcel.readString();
        this.mFingerPrint = parcel.readString();
    }

    public void setFingerPrint(String str) {
        this.mFingerPrint = str;
    }

    public void setPackageName(String str) {
        this.mPackageName = str;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.mPackageName);
        parcel.writeString(this.mFingerPrint);
    }
}
