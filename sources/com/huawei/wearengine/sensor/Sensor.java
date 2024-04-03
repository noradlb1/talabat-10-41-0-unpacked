package com.huawei.wearengine.sensor;

import android.os.Parcel;
import android.os.Parcelable;

public class Sensor implements Parcelable {
    public static final Parcelable.Creator<Sensor> CREATOR = new a();
    public static final String NAME_ACC = "ACC";
    public static final String NAME_ECG = "ECG";
    public static final String NAME_GYRO = "GYRO";
    public static final String NAME_HR = "HR";
    public static final String NAME_MAG = "MAG";
    public static final String NAME_PPG = "PPG";
    public static final String NAME_PRESSURE = "PRESSURE";
    public static final int PPG_CHANNEL_AMB = 9;
    public static final int PPG_CHANNEL_AMBDUMMY = 2;
    public static final int PPG_CHANNEL_AMBGREEN = 4;
    public static final int PPG_CHANNEL_AMBIR = 6;
    public static final int PPG_CHANNEL_AMBR = 8;
    public static final int PPG_CHANNEL_DUMMY = 1;
    public static final int PPG_CHANNEL_GREEN = 3;
    public static final int PPG_CHANNEL_IR = 5;
    public static final int PPG_CHANNEL_RED = 7;
    public static final int PPG_CHANNEL_UNKNOWN = 0;
    public static final int TYPE_ACC = 2;
    public static final int TYPE_ECG = 0;
    public static final int TYPE_GYRO = 3;
    public static final int TYPE_HR = 6;
    public static final int TYPE_MAG = 4;
    public static final int TYPE_PPG = 1;
    public static final int TYPE_PRESSURE = 5;
    private int mAccuracy;
    private String mExtendJson;
    private int mId;
    private String mName;
    private float mResolution;
    private int mType;

    public static class a implements Parcelable.Creator<Sensor> {
        public Object createFromParcel(Parcel parcel) {
            return new Sensor(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readFloat(), parcel.readString());
        }

        public Object[] newArray(int i11) {
            return new Sensor[i11];
        }
    }

    public Sensor(int i11, int i12, int i13, float f11, String str) {
        this.mId = i11;
        this.mType = i12;
        this.mAccuracy = i13;
        this.mResolution = f11;
        this.mName = getNameByType(i12);
        this.mExtendJson = str;
    }

    private String getNameByType(int i11) {
        switch (i11) {
            case 0:
                return NAME_ECG;
            case 1:
                return NAME_PPG;
            case 2:
                return NAME_ACC;
            case 3:
                return NAME_GYRO;
            case 4:
                return NAME_MAG;
            case 5:
                return NAME_PRESSURE;
            case 6:
                return NAME_HR;
            default:
                return "";
        }
    }

    public int describeContents() {
        return 0;
    }

    public int getAccuracy() {
        return this.mAccuracy;
    }

    public int getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public float getResolution() {
        return this.mResolution;
    }

    public int getType() {
        return this.mType;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.mId);
        parcel.writeInt(this.mType);
        parcel.writeInt(this.mAccuracy);
        parcel.writeFloat(this.mResolution);
        parcel.writeString(this.mExtendJson);
    }
}
