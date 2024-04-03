package com.huawei.hms.location.entity.activity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ActivityTransitionRequest implements Parcelable {
    public static final Parcelable.Creator<ActivityTransitionRequest> CREATOR = new yn();
    private List<ActivityTransition> transitions = new CopyOnWriteArrayList();

    public static class yn implements Parcelable.Creator<ActivityTransitionRequest> {
        public Object createFromParcel(Parcel parcel) {
            return new ActivityTransitionRequest(parcel);
        }

        public Object[] newArray(int i11) {
            return new ActivityTransitionRequest[i11];
        }
    }

    public ActivityTransitionRequest() {
    }

    public ActivityTransitionRequest(Parcel parcel) {
        this.transitions = parcel.createTypedArrayList(ActivityTransition.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public List<ActivityTransition> getTransitions() {
        return this.transitions;
    }

    public void setTransitions(List<ActivityTransition> list) {
        this.transitions = list;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeTypedList(this.transitions);
    }
}
