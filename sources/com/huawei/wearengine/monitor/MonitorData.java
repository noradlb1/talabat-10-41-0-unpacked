package com.huawei.wearengine.monitor;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;

public class MonitorData implements Parcelable {
    public static final Parcelable.Creator<MonitorData> CREATOR = new a();
    private boolean mBooleanData;
    private int mIntData;
    private HashMap<String, MonitorData> mMapData;
    private String mStringData;

    public static class a implements Parcelable.Creator<MonitorData> {
        public Object createFromParcel(Parcel parcel) {
            return new MonitorData(parcel.readInt() != 0, parcel.readInt(), parcel.readString(), parcel.readHashMap(HashMap.class.getClassLoader()));
        }

        public Object[] newArray(int i11) {
            if (i11 > 65535 || i11 < 0) {
                return null;
            }
            return new MonitorData[i11];
        }
    }

    public MonitorData(boolean z11, int i11, String str, HashMap<String, MonitorData> hashMap) {
        this.mBooleanData = z11;
        this.mIntData = i11;
        this.mStringData = str;
        this.mMapData = hashMap;
    }

    public boolean asBool() {
        return this.mBooleanData;
    }

    public int asInt() {
        return this.mIntData;
    }

    public HashMap<String, MonitorData> asMap() {
        return this.mMapData;
    }

    public String asString() {
        return this.mStringData;
    }

    public int describeContents() {
        return 0;
    }

    public final void readFromParcel(Parcel parcel) {
        this.mBooleanData = parcel.readInt() != 0;
        this.mIntData = parcel.readInt();
        this.mStringData = parcel.readString();
        this.mMapData = parcel.readHashMap(HashMap.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.mBooleanData ? 1 : 0);
        parcel.writeInt(this.mIntData);
        parcel.writeString(this.mStringData);
        parcel.writeMap(this.mMapData);
    }
}
