package com.huawei.hms.location.entity.activity;

import android.os.Parcel;
import android.os.Parcelable;

public class DetectedActivity implements Parcelable {
    public static final Parcelable.Creator<DetectedActivity> CREATOR = new yn();
    private int confidence;
    private int type;

    public static class yn implements Parcelable.Creator<DetectedActivity> {
        public Object createFromParcel(Parcel parcel) {
            return new DetectedActivity(parcel, (yn) null);
        }

        public Object[] newArray(int i11) {
            return new DetectedActivity[i11];
        }
    }

    public DetectedActivity() {
    }

    public DetectedActivity(int i11, int i12) {
        this.confidence = i12;
        this.type = i11;
    }

    private DetectedActivity(Parcel parcel) {
        this.type = parcel.readInt();
        this.confidence = parcel.readInt();
    }

    public /* synthetic */ DetectedActivity(Parcel parcel, yn ynVar) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public int getConfidence() {
        return this.confidence;
    }

    public int getType() {
        return this.type;
    }

    public void setConfidence(int i11) {
        this.confidence = i11;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.type);
        parcel.writeInt(this.confidence);
    }
}
