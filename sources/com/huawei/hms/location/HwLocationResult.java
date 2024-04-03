package com.huawei.hms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

public class HwLocationResult implements Parcelable {
    public static final Parcelable.Creator<HwLocationResult> CREATOR = new yn();
    private int code;
    private Location location;
    private String message;

    public static class yn implements Parcelable.Creator<HwLocationResult> {
        public Object createFromParcel(Parcel parcel) {
            return new HwLocationResult(parcel);
        }

        public Object[] newArray(int i11) {
            return new HwLocationResult[i11];
        }
    }

    public HwLocationResult() {
    }

    public HwLocationResult(int i11, String str) {
        this.code = i11;
        this.message = str;
    }

    public HwLocationResult(int i11, String str, Location location2) {
        this.code = i11;
        this.message = str;
        this.location = location2;
    }

    public HwLocationResult(Parcel parcel) {
        this.code = parcel.readInt();
        this.message = parcel.readString();
        this.location = (Location) parcel.readParcelable(Location.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public int getCode() {
        return this.code;
    }

    public Location getLocation() {
        return this.location;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(int i11) {
        this.code = i11;
    }

    public void setLocation(Location location2) {
        this.location = location2;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.code);
        parcel.writeString(this.message);
        parcel.writeParcelable(this.location, i11);
    }
}
