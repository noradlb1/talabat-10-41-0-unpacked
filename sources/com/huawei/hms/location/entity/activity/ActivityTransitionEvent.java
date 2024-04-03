package com.huawei.hms.location.entity.activity;

import android.os.Parcel;
import android.os.Parcelable;

public class ActivityTransitionEvent implements Parcelable {
    public static final Parcelable.Creator<ActivityTransitionEvent> CREATOR = new yn();
    private int activityType;
    private long elapsedRealTimeNanos;
    private int transitionType;

    public static class yn implements Parcelable.Creator<ActivityTransitionEvent> {
        public Object createFromParcel(Parcel parcel) {
            return new ActivityTransitionEvent(parcel, (yn) null);
        }

        public Object[] newArray(int i11) {
            return new ActivityTransitionEvent[0];
        }
    }

    public ActivityTransitionEvent(int i11, int i12, long j11) {
        this.activityType = i11;
        this.transitionType = i12;
        this.elapsedRealTimeNanos = j11;
    }

    private ActivityTransitionEvent(Parcel parcel) {
        this.activityType = parcel.readInt();
        this.transitionType = parcel.readInt();
        this.elapsedRealTimeNanos = parcel.readLong();
    }

    public /* synthetic */ ActivityTransitionEvent(Parcel parcel, yn ynVar) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public int getActivityType() {
        return this.activityType;
    }

    public long getElapsedRealTimeNanos() {
        return this.elapsedRealTimeNanos;
    }

    public int getTransitionType() {
        return this.transitionType;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.activityType);
        parcel.writeInt(this.transitionType);
        parcel.writeLong(this.elapsedRealTimeNanos);
    }
}
