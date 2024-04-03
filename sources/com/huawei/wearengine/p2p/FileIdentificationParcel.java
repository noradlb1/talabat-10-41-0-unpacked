package com.huawei.wearengine.p2p;

import android.os.Parcel;
import android.os.Parcelable;

public class FileIdentificationParcel implements Parcelable {
    public static final Parcelable.Creator<FileIdentificationParcel> CREATOR = new a();
    private String mDescription;
    private String mExtendJson;
    private String mFileName;

    public static class a implements Parcelable.Creator<FileIdentificationParcel> {
        public Object createFromParcel(Parcel parcel) {
            FileIdentificationParcel fileIdentificationParcel = new FileIdentificationParcel();
            fileIdentificationParcel.setFileName(parcel.readString());
            fileIdentificationParcel.setDescription(parcel.readString());
            fileIdentificationParcel.setExtendJson(parcel.readString());
            return fileIdentificationParcel;
        }

        public Object[] newArray(int i11) {
            if (i11 > 65535 || i11 < 0) {
                return null;
            }
            return new FileIdentificationParcel[i11];
        }
    }

    public int describeContents() {
        return 0;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getExtendJson() {
        return this.mExtendJson;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public void setExtendJson(String str) {
        this.mExtendJson = str;
    }

    public void setFileName(String str) {
        this.mFileName = str;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.mFileName);
        parcel.writeString(this.mDescription);
        parcel.writeString(this.mExtendJson);
    }
}
