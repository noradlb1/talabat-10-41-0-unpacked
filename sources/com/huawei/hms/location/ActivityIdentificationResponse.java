package com.huawei.hms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class ActivityIdentificationResponse implements Parcelable, IMessageEntity {
    public static final Parcelable.Creator<ActivityIdentificationResponse> CREATOR = new yn();
    private static final String EXTRA_CONSTANT = "com.huawei.hms.location.internal.EXTRA_ACTIVITY_RESULT";
    private static final String TAG = "ActivityIdentificationResponse";
    @Packed
    private List<ActivityIdentificationData> activityIdentificationDatas;
    @Packed
    private long elapsedTimeFromReboot;
    @Packed
    private long time;

    public static class yn implements Parcelable.Creator<ActivityIdentificationResponse> {
        public Object createFromParcel(Parcel parcel) {
            return new ActivityIdentificationResponse(parcel, (yn) null);
        }

        public Object[] newArray(int i11) {
            return new ActivityIdentificationResponse[0];
        }
    }

    public ActivityIdentificationResponse() {
    }

    private ActivityIdentificationResponse(Parcel parcel) {
        this.time = parcel.readLong();
        this.elapsedTimeFromReboot = parcel.readLong();
        this.activityIdentificationDatas = parcel.createTypedArrayList(ActivityIdentificationData.CREATOR);
    }

    public /* synthetic */ ActivityIdentificationResponse(Parcel parcel, yn ynVar) {
        this(parcel);
    }

    public ActivityIdentificationResponse(ActivityIdentificationData activityIdentificationData, long j11, long j12) {
        this.activityIdentificationDatas = Collections.singletonList(activityIdentificationData);
        this.time = j11;
        this.elapsedTimeFromReboot = j12;
    }

    public ActivityIdentificationResponse(List<ActivityIdentificationData> list, long j11, long j12) {
        this.activityIdentificationDatas = list;
        this.time = j11;
        this.elapsedTimeFromReboot = j12;
    }

    public static boolean containDataFromIntent(Intent intent) {
        if (intent != null) {
            try {
                if (intent.hasExtra(EXTRA_CONSTANT)) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static ActivityIdentificationResponse getDataFromIntent(Intent intent) {
        try {
            if (!containDataFromIntent(intent)) {
                return null;
            }
            Parcelable parcelableExtra = intent.getParcelableExtra(EXTRA_CONSTANT);
            if (parcelableExtra == null) {
                parcelableExtra = null;
            } else if (parcelableExtra instanceof Bundle) {
                parcelableExtra = ((Bundle) parcelableExtra).getParcelable("KEY_RESPONSE");
            }
            if (parcelableExtra instanceof ActivityIdentificationResponse) {
                return (ActivityIdentificationResponse) parcelableExtra;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !(obj instanceof ActivityIdentificationResponse)) {
            return false;
        }
        ActivityIdentificationResponse activityIdentificationResponse = (ActivityIdentificationResponse) obj;
        return this.time == activityIdentificationResponse.getTime() && this.elapsedTimeFromReboot == activityIdentificationResponse.getElapsedTimeFromReboot() && Objects.equals(this.activityIdentificationDatas, activityIdentificationResponse.getActivityIdentificationDatas());
    }

    public List<ActivityIdentificationData> getActivityIdentificationDatas() {
        return this.activityIdentificationDatas;
    }

    public int getActivityPossibility(int i11) {
        List<ActivityIdentificationData> list = this.activityIdentificationDatas;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        for (ActivityIdentificationData next : this.activityIdentificationDatas) {
            if (next.getIdentificationActivity() == i11) {
                return next.getPossibility();
            }
        }
        return 0;
    }

    public long getElapsedTimeFromReboot() {
        return this.elapsedTimeFromReboot;
    }

    public ActivityIdentificationData getMostActivityIdentification() {
        List<ActivityIdentificationData> list = this.activityIdentificationDatas;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.activityIdentificationDatas.get(0);
    }

    public long getTime() {
        return this.time;
    }

    public int hashCode() {
        return new Object[]{Long.valueOf(this.time), Long.valueOf(this.elapsedTimeFromReboot), this.activityIdentificationDatas}.hashCode();
    }

    public void setActivityIdentificationDatas(List<ActivityIdentificationData> list) {
        this.activityIdentificationDatas = list;
    }

    public void setElapsedTimeFromReboot(long j11) {
        this.elapsedTimeFromReboot = j11;
    }

    public void setTime(long j11) {
        this.time = j11;
    }

    public String toString() {
        return "ActivityIdentificationResponse{time=" + this.time + ", elapsedTimeFromReboot=" + this.elapsedTimeFromReboot + ", activityIdentificationDatas=" + this.activityIdentificationDatas + AbstractJsonLexerKt.END_OBJ;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.time);
        parcel.writeLong(this.elapsedTimeFromReboot);
        parcel.writeTypedList(this.activityIdentificationDatas);
    }
}
