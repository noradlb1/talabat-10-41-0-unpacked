package com.huawei.wearengine.device;

import android.os.Parcel;
import android.os.Parcelable;

public class TransparentCommandParcel implements Parcelable {
    public static final Parcelable.Creator<TransparentCommandParcel> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private int f35162a;

    /* renamed from: b  reason: collision with root package name */
    private String f35163b;

    /* renamed from: c  reason: collision with root package name */
    private String f35164c;

    /* renamed from: d  reason: collision with root package name */
    private String f35165d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f35166e;

    /* renamed from: f  reason: collision with root package name */
    private int f35167f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f35168g;

    /* renamed from: h  reason: collision with root package name */
    private String f35169h;

    public static class a implements Parcelable.Creator<TransparentCommandParcel> {
        public Object createFromParcel(Parcel parcel) {
            TransparentCommandParcel transparentCommandParcel = new TransparentCommandParcel();
            transparentCommandParcel.setCommandType(parcel.readInt());
            transparentCommandParcel.setServiceUuid(parcel.readString());
            transparentCommandParcel.setCharacteristicUuid(parcel.readString());
            transparentCommandParcel.setDeviceMac(parcel.readString());
            transparentCommandParcel.setCommand(parcel.createByteArray());
            transparentCommandParcel.setPriorityType(parcel.readInt());
            transparentCommandParcel.setNeedEncrypt(parcel.readByte() != 0);
            transparentCommandParcel.setExtendJson(parcel.readString());
            return transparentCommandParcel;
        }

        public Object[] newArray(int i11) {
            if (i11 > 65535 || i11 < 0) {
                return null;
            }
            return new TransparentCommandParcel[i11];
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getCharacteristicUuid() {
        return this.f35164c;
    }

    public byte[] getCommand() {
        byte[] bArr = this.f35166e;
        return bArr != null ? (byte[]) bArr.clone() : new byte[0];
    }

    public int getCommandType() {
        return this.f35162a;
    }

    public String getDeviceMac() {
        return this.f35165d;
    }

    public int getPriorityType() {
        return this.f35167f;
    }

    public String getServiceUuid() {
        return this.f35163b;
    }

    public boolean isNeedEncrypt() {
        return this.f35168g;
    }

    public void readFromParcel(Parcel parcel) {
        this.f35162a = parcel.readInt();
        this.f35163b = parcel.readString();
        this.f35164c = parcel.readString();
        this.f35165d = parcel.readString();
        this.f35166e = parcel.createByteArray();
        this.f35167f = parcel.readInt();
        this.f35168g = parcel.readByte() != 0;
        this.f35169h = parcel.readString();
    }

    public void setCharacteristicUuid(String str) {
        this.f35164c = str;
    }

    public void setCommand(byte[] bArr) {
        if (bArr != null) {
            this.f35166e = (byte[]) bArr.clone();
        } else {
            this.f35166e = null;
        }
    }

    public void setCommandType(int i11) {
        this.f35162a = i11;
    }

    public void setDeviceMac(String str) {
        this.f35165d = str;
    }

    public void setExtendJson(String str) {
        this.f35169h = str;
    }

    public void setNeedEncrypt(boolean z11) {
        this.f35168g = z11;
    }

    public void setPriorityType(int i11) {
        this.f35167f = i11;
    }

    public void setServiceUuid(String str) {
        this.f35163b = str;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.f35162a);
        parcel.writeString(this.f35163b);
        parcel.writeString(this.f35164c);
        parcel.writeString(this.f35165d);
        parcel.writeByteArray(this.f35166e);
        parcel.writeInt(this.f35167f);
        parcel.writeByte(this.f35168g ? (byte) 1 : 0);
        parcel.writeString(this.f35169h);
    }
}
