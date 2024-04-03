package com.huawei.wearengine.device;

import android.os.Parcel;
import android.os.Parcelable;

public class ScanFilterParcel implements Parcelable {
    public static final Parcelable.Creator<ScanFilterParcel> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private int f35160a;

    /* renamed from: b  reason: collision with root package name */
    private String f35161b;

    public static class a implements Parcelable.Creator<ScanFilterParcel> {
        public Object createFromParcel(Parcel parcel) {
            ScanFilterParcel scanFilterParcel = new ScanFilterParcel();
            scanFilterParcel.setType(parcel.readInt());
            scanFilterParcel.setMatcher(parcel.readString());
            return scanFilterParcel;
        }

        public Object[] newArray(int i11) {
            if (i11 > 65535 || i11 < 0) {
                return null;
            }
            return new ScanFilterParcel[i11];
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getMatcher() {
        return this.f35161b;
    }

    public int getType() {
        return this.f35160a;
    }

    public void readFromParcel(Parcel parcel) {
        this.f35160a = parcel.readInt();
        this.f35161b = parcel.readString();
    }

    public void setMatcher(String str) {
        this.f35161b = str;
    }

    public void setType(int i11) {
        this.f35160a = i11;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.f35160a);
        parcel.writeString(this.f35161b);
    }
}
