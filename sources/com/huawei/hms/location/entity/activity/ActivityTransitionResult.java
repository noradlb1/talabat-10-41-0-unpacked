package com.huawei.hms.location.entity.activity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class ActivityTransitionResult implements Parcelable {
    public static final Parcelable.Creator<ActivityTransitionResult> CREATOR = new yn();
    private List<ActivityTransitionEvent> transitionEvents;

    public static class yn implements Parcelable.Creator<ActivityTransitionResult> {
        public Object createFromParcel(Parcel parcel) {
            return new ActivityTransitionResult(parcel, (yn) null);
        }

        public Object[] newArray(int i11) {
            return new ActivityTransitionResult[0];
        }
    }

    private ActivityTransitionResult(Parcel parcel) {
        this.transitionEvents = parcel.createTypedArrayList(ActivityTransitionEvent.CREATOR);
    }

    public /* synthetic */ ActivityTransitionResult(Parcel parcel, yn ynVar) {
        this(parcel);
    }

    public ActivityTransitionResult(List<ActivityTransitionEvent> list) {
        this.transitionEvents = list;
    }

    public int describeContents() {
        return 0;
    }

    public List<ActivityTransitionEvent> getTransitionEvents() {
        return this.transitionEvents;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeTypedList(this.transitionEvents);
    }
}
