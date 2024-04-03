package com.huawei.wearengine.p2p;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;

public class MessageParcel implements Parcelable {
    public static final Parcelable.Creator<MessageParcel> CREATOR = new a();
    public static final int MESSAGE_TYPE_DATA = 1;
    public static final int MESSAGE_TYPE_FILE = 2;
    private byte[] mData;
    private String mDescription;
    private String mFileName;
    private String mFileSha256;
    private ParcelFileDescriptor mParcelFileDescriptor;
    private int mType;

    public static class a implements Parcelable.Creator<MessageParcel> {
        public Object createFromParcel(Parcel parcel) {
            MessageParcel messageParcel = new MessageParcel();
            int readInt = parcel.readInt();
            messageParcel.setType(readInt);
            if (MessageParcel.isData(readInt)) {
                messageParcel.setData(parcel.createByteArray());
            } else {
                messageParcel.setParcelFileDescriptor(parcel.readFileDescriptor());
            }
            messageParcel.setFileName(parcel.readString());
            messageParcel.setDescription(parcel.readString());
            messageParcel.setFileSha256(parcel.readString());
            return messageParcel;
        }

        public Object[] newArray(int i11) {
            if (i11 > 65535 || i11 < 0) {
                return null;
            }
            return new MessageParcel[i11];
        }
    }

    /* access modifiers changed from: private */
    public static boolean isData(int i11) {
        return i11 == 1;
    }

    public void b(Parcel parcel) {
        int readInt = parcel.readInt();
        this.mType = readInt;
        if (readInt == 1) {
            this.mData = parcel.createByteArray();
        } else {
            this.mParcelFileDescriptor = parcel.readFileDescriptor();
        }
        this.mFileName = parcel.readString();
        this.mDescription = parcel.readString();
        this.mFileSha256 = parcel.readString();
    }

    public void c(Parcel parcel) {
        parcel.writeInt(this.mType);
        if (this.mType == 1) {
            parcel.writeByteArray(this.mData);
        } else {
            ParcelFileDescriptor parcelFileDescriptor = this.mParcelFileDescriptor;
            if (parcelFileDescriptor != null) {
                parcel.writeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
            }
        }
        parcel.writeString(this.mFileName);
        parcel.writeString(this.mDescription);
        parcel.writeString(this.mFileSha256);
    }

    public int describeContents() {
        return 0;
    }

    public byte[] getData() {
        byte[] bArr = this.mData;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public String getFileSha256() {
        return this.mFileSha256;
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        return this.mParcelFileDescriptor;
    }

    public int getType() {
        return this.mType;
    }

    public void readFromParcel(Parcel parcel) {
        b(parcel);
    }

    public void setData(byte[] bArr) {
        this.mData = bArr == null ? null : (byte[]) bArr.clone();
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public void setFileName(String str) {
        this.mFileName = str;
    }

    public void setFileSha256(String str) {
        this.mFileSha256 = str;
    }

    public void setParcelFileDescriptor(ParcelFileDescriptor parcelFileDescriptor) {
        this.mParcelFileDescriptor = parcelFileDescriptor;
    }

    public void setType(int i11) {
        this.mType = i11;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        c(parcel);
    }
}
