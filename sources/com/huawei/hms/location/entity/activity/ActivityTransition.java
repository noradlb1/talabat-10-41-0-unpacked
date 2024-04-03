package com.huawei.hms.location.entity.activity;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.core.aidl.IMessageEntity;

public class ActivityTransition implements Parcelable, IMessageEntity {
    public static final Parcelable.Creator<ActivityTransition> CREATOR = new yn();
    private int activityType;
    private int transitionType;

    public static class yn implements Parcelable.Creator<ActivityTransition> {
        public Object createFromParcel(Parcel parcel) {
            return new ActivityTransition(parcel);
        }

        public Object[] newArray(int i11) {
            return new ActivityTransition[i11];
        }
    }

    public ActivityTransition() {
    }

    public ActivityTransition(Parcel parcel) {
        this.activityType = parcel.readInt();
        this.transitionType = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public int getActivityType() {
        return this.activityType;
    }

    public int getTransitionType() {
        return this.transitionType;
    }

    public void setActivityType(int i11) {
        this.activityType = i11;
    }

    public void setTransitionType(int i11) {
        this.transitionType = i11;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.activityType);
        parcel.writeInt(this.transitionType);
    }
}
