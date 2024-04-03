package com.huawei.location.base.activity.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class MovementEvent implements Parcelable {
    public static final Parcelable.Creator<MovementEvent> CREATOR = new yn();
    private int mEventType;
    private String mMovement;

    public static class yn implements Parcelable.Creator<MovementEvent> {
        public Object createFromParcel(Parcel parcel) {
            return new MovementEvent(parcel.readString(), parcel.readInt());
        }

        public Object[] newArray(int i11) {
            return new MovementEvent[i11];
        }
    }

    public MovementEvent(String str, int i11) {
        this.mMovement = str;
        this.mEventType = i11;
    }

    public int describeContents() {
        return 0;
    }

    public int getEventType() {
        return this.mEventType;
    }

    public String getMovement() {
        return this.mMovement;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.mMovement);
        parcel.writeInt(this.mEventType);
    }
}
