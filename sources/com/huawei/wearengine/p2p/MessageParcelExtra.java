package com.huawei.wearengine.p2p;

import android.os.Parcel;
import android.os.Parcelable;

public class MessageParcelExtra extends MessageParcel {
    public static final Parcelable.Creator<MessageParcelExtra> CREATOR = new a();
    public static final int MESSAGE_TYPE_DATA = 1;
    public static final int MESSAGE_TYPE_FILE = 2;
    private String mExtendJson;

    public static class a implements Parcelable.Creator<MessageParcelExtra> {
        public Object createFromParcel(Parcel parcel) {
            MessageParcelExtra messageParcelExtra = new MessageParcelExtra();
            int readInt = parcel.readInt();
            messageParcelExtra.setType(readInt);
            if (MessageParcelExtra.isData(readInt)) {
                messageParcelExtra.setData(parcel.createByteArray());
            } else {
                messageParcelExtra.setParcelFileDescriptor(parcel.readFileDescriptor());
            }
            messageParcelExtra.setFileName(parcel.readString());
            messageParcelExtra.setDescription(parcel.readString());
            messageParcelExtra.setFileSha256(parcel.readString());
            messageParcelExtra.setExtendJson(parcel.readString());
            return messageParcelExtra;
        }

        public Object[] newArray(int i11) {
            if (i11 > 65535 || i11 < 0) {
                return null;
            }
            return new MessageParcelExtra[i11];
        }
    }

    /* access modifiers changed from: private */
    public static boolean isData(int i11) {
        return i11 == 1;
    }

    public String getExtendJson() {
        return this.mExtendJson;
    }

    public void readFromParcel(Parcel parcel) {
        b(parcel);
        this.mExtendJson = parcel.readString();
    }

    public void setExtendJson(String str) {
        this.mExtendJson = str;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        c(parcel);
        parcel.writeString(this.mExtendJson);
    }
}
