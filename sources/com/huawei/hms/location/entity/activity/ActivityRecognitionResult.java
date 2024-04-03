package com.huawei.hms.location.entity.activity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class ActivityRecognitionResult implements Parcelable {
    public static final Parcelable.Creator<ActivityRecognitionResult> CREATOR = new yn();
    private long elapsedRealtimeMillis;
    private List<DetectedActivity> probableActivities;
    private long time;

    public static class yn implements Parcelable.Creator<ActivityRecognitionResult> {
        public Object createFromParcel(Parcel parcel) {
            return new ActivityRecognitionResult(parcel, (yn) null);
        }

        public Object[] newArray(int i11) {
            return new ActivityRecognitionResult[0];
        }
    }

    private ActivityRecognitionResult(Parcel parcel) {
        this.time = parcel.readLong();
        this.elapsedRealtimeMillis = parcel.readLong();
        this.probableActivities = parcel.createTypedArrayList(DetectedActivity.CREATOR);
    }

    public /* synthetic */ ActivityRecognitionResult(Parcel parcel, yn ynVar) {
        this(parcel);
    }

    public ActivityRecognitionResult(List<DetectedActivity> list, long j11, long j12) {
        this.probableActivities = list;
        this.time = j11;
        this.elapsedRealtimeMillis = j12;
    }

    public int describeContents() {
        return 0;
    }

    public int getActivityConfidence(int i11) {
        List<DetectedActivity> list = this.probableActivities;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        for (DetectedActivity next : this.probableActivities) {
            if (next.getType() == i11) {
                return next.getConfidence();
            }
        }
        return 0;
    }

    public long getElapsedRealtimeMillis() {
        return this.elapsedRealtimeMillis;
    }

    public DetectedActivity getMostProbableActivity() {
        List<DetectedActivity> list = this.probableActivities;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.probableActivities.get(0);
    }

    public List<DetectedActivity> getProbableActivities() {
        return this.probableActivities;
    }

    public long getTime() {
        return this.time;
    }

    public void setElapsedRealtimeMillis(long j11) {
        this.elapsedRealtimeMillis = j11;
    }

    public void setProbableActivities(List<DetectedActivity> list) {
        this.probableActivities = list;
    }

    public void setTime(long j11) {
        this.time = j11;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.time);
        parcel.writeLong(this.elapsedRealtimeMillis);
        parcel.writeTypedList(this.probableActivities);
    }
}
