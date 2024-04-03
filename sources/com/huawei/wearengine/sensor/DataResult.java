package com.huawei.wearengine.sensor;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class DataResult implements Parcelable {
    public static final Parcelable.Creator<DataResult> CREATOR = new a();
    private int mChannel;
    private String mExtendJson = "";
    private List<DataResult> mListValues;
    private Sensor mSensor;
    private long mTimestamp;
    private float[] mValues;

    public static class a implements Parcelable.Creator<DataResult> {
        public Object createFromParcel(Parcel parcel) {
            DataResult dataResult = new DataResult();
            dataResult.setTimestamp(parcel.readLong());
            dataResult.setValues(parcel.createFloatArray());
            dataResult.setListValues(parcel.readArrayList(DataResult.class.getClassLoader()));
            dataResult.setChannel(parcel.readInt());
            dataResult.setSensor((Sensor) parcel.readParcelable(Sensor.class.getClassLoader()));
            dataResult.setExtendJson(parcel.readString());
            return dataResult;
        }

        public Object[] newArray(int i11) {
            return new DataResult[i11];
        }
    }

    public float[] asFloats() {
        float[] fArr = this.mValues;
        if (fArr == null) {
            return null;
        }
        return (float[]) fArr.clone();
    }

    public List<DataResult> asList() {
        return this.mListValues;
    }

    public int describeContents() {
        return 0;
    }

    public int getChannel() {
        return this.mChannel;
    }

    public Sensor getSensor() {
        return this.mSensor;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public void readFromParcel(Parcel parcel) {
        this.mTimestamp = parcel.readLong();
        this.mValues = parcel.createFloatArray();
        this.mListValues = parcel.readArrayList(DataResult.class.getClassLoader());
        this.mChannel = parcel.readInt();
        this.mSensor = (Sensor) parcel.readParcelable(Sensor.class.getClassLoader());
        this.mExtendJson = parcel.readString();
    }

    public void setChannel(int i11) {
        this.mChannel = i11;
    }

    public void setExtendJson(String str) {
        this.mExtendJson = str;
    }

    public void setListValues(List<DataResult> list) {
        this.mListValues = list;
    }

    public void setSensor(Sensor sensor) {
        this.mSensor = sensor;
    }

    public void setTimestamp(long j11) {
        this.mTimestamp = j11;
    }

    public void setValues(float[] fArr) {
        this.mValues = fArr == null ? null : (float[]) fArr.clone();
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.mTimestamp);
        parcel.writeFloatArray(this.mValues);
        parcel.writeList(this.mListValues);
        parcel.writeInt(this.mChannel);
        parcel.writeParcelable(this.mSensor, i11);
        parcel.writeString(this.mExtendJson);
    }
}
