package com.huawei.wearengine.device;

import android.os.Parcel;
import android.os.Parcelable;

public class DeviceDataFrameParcel implements Parcelable {
    public static final Parcelable.Creator<DeviceDataFrameParcel> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f35156a;

    /* renamed from: b  reason: collision with root package name */
    private String f35157b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f35158c;

    public static class a implements Parcelable.Creator<DeviceDataFrameParcel> {
        public Object createFromParcel(Parcel parcel) {
            DeviceDataFrameParcel deviceDataFrameParcel = new DeviceDataFrameParcel();
            deviceDataFrameParcel.setServiceId(parcel.readString());
            deviceDataFrameParcel.setCharacteristicId(parcel.readString());
            deviceDataFrameParcel.setData(parcel.createByteArray());
            return deviceDataFrameParcel;
        }

        public Object[] newArray(int i11) {
            if (i11 > 65535 || i11 < 0) {
                return null;
            }
            return new DeviceDataFrameParcel[i11];
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getCharacteristicId() {
        return this.f35157b;
    }

    public byte[] getData() {
        byte[] bArr = this.f35158c;
        return bArr != null ? (byte[]) bArr.clone() : new byte[0];
    }

    public String getServiceId() {
        return this.f35156a;
    }

    public void readFromParcel(Parcel parcel) {
        this.f35156a = parcel.readString();
        this.f35157b = parcel.readString();
        this.f35158c = parcel.createByteArray();
    }

    public void setCharacteristicId(String str) {
        this.f35157b = str;
    }

    public void setData(byte[] bArr) {
        if (bArr != null) {
            this.f35158c = (byte[]) bArr.clone();
        } else {
            this.f35158c = null;
        }
    }

    public void setServiceId(String str) {
        this.f35156a = str;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f35156a);
        parcel.writeString(this.f35157b);
        parcel.writeByteArray(this.f35158c);
    }
}
