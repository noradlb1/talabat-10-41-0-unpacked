package com.huawei.hms.analytics;

import android.os.Parcel;
import android.os.Parcelable;

public class UploadInfo implements Parcelable {
    public static final Parcelable.Creator<UploadInfo> CREATOR = new Parcelable.Creator<UploadInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new UploadInfo(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
            return new UploadInfo[i11];
        }
    };
    private String[] hij;
    public String ijk;
    public String ikl;
    public String klm;
    public String lmn;

    public UploadInfo() {
        this.hij = new String[0];
    }

    private UploadInfo(Parcel parcel) {
        this.hij = new String[0];
        this.lmn = parcel.readString();
        this.klm = parcel.readString();
        this.hij = parcel.createStringArray();
        this.ikl = parcel.readString();
        this.ijk = parcel.readString();
    }

    public /* synthetic */ UploadInfo(Parcel parcel, byte b11) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public final void lmn(String[] strArr) {
        if (strArr != null) {
            this.hij = (String[]) strArr.clone();
        }
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.lmn);
        parcel.writeString(this.klm);
        parcel.writeStringArray(this.hij);
        parcel.writeString(this.ikl);
        parcel.writeString(this.ijk);
    }
}
