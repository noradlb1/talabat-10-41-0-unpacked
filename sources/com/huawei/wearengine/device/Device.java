package com.huawei.wearengine.device;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.wearengine.utils.json.DeviceJsonUtil;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class Device implements Parcelable {
    public static final Parcelable.Creator<Device> CREATOR = new a();
    private static final int DEFAULT_PRODUCT_TYPE = -1;
    public static final int DEVICE_CONNECTED = 2;
    private int mConnectState;
    private String mModel;
    private String mName;
    private int mProductType = -1;
    private String mReservedness;
    private String mUuid;

    public static class a implements Parcelable.Creator<Device> {
        public Object createFromParcel(Parcel parcel) {
            Device device = new Device();
            device.setName(parcel.readString());
            device.setUuid(parcel.readString());
            device.setModel(parcel.readString());
            device.setProductType(parcel.readInt());
            device.setConnectState(parcel.readInt());
            device.setReservedness(parcel.readString());
            return device;
        }

        public Object[] newArray(int i11) {
            if (i11 > 65535 || i11 < 0) {
                return null;
            }
            return new Device[i11];
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Device) {
            return this.mUuid.equals(((Device) obj).getUuid());
        }
        return false;
    }

    public String getBasicInfo() {
        return DeviceJsonUtil.getBasicInfo(this.mReservedness);
    }

    public String getCapability() {
        return DeviceJsonUtil.getCapability(this.mReservedness);
    }

    public String getIdentify() {
        return DeviceJsonUtil.getIdentify(this.mReservedness);
    }

    public String getModel() {
        return this.mModel;
    }

    public String getName() {
        return this.mName;
    }

    public int getProductType() {
        return this.mProductType;
    }

    public String getReservedness() {
        String reservedness = DeviceJsonUtil.getReservedness(this.mReservedness);
        return TextUtils.isEmpty(reservedness) ? this.mReservedness : reservedness;
    }

    public String getUuid() {
        return this.mUuid;
    }

    public int hashCode() {
        return this.mUuid.hashCode();
    }

    public boolean isConnected() {
        return this.mConnectState == 2;
    }

    public void readFromParcel(Parcel parcel) {
        this.mName = parcel.readString();
        this.mUuid = parcel.readString();
        this.mModel = parcel.readString();
        this.mProductType = parcel.readInt();
        this.mConnectState = parcel.readInt();
        this.mReservedness = parcel.readString();
    }

    public void setConnectState(int i11) {
        this.mConnectState = i11;
    }

    public void setModel(String str) {
        this.mModel = str;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setProductType(int i11) {
        this.mProductType = i11;
    }

    public void setReservedness(String str) {
        this.mReservedness = str;
    }

    public void setUuid(String str) {
        this.mUuid = str;
    }

    public String toString() {
        return "Device{mName='" + this.mName + "', mUuid='" + this.mUuid + "', mModel='" + this.mModel + "', mProductType='" + this.mProductType + "', mConnectState='" + this.mConnectState + ", mReservedness='" + getReservedness() + ", mCapability='" + getCapability() + ", mBasicInfo='" + getBasicInfo() + ", mIdentify='" + getIdentify() + AbstractJsonLexerKt.END_OBJ;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.mName);
        parcel.writeString(this.mUuid);
        parcel.writeString(this.mModel);
        parcel.writeInt(this.mProductType);
        parcel.writeInt(this.mConnectState);
        parcel.writeString(this.mReservedness);
    }
}
