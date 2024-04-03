package com.huawei.hms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class ActivityConversionResponse implements Parcelable {
    public static final Parcelable.Creator<ActivityConversionResponse> CREATOR = new yn();
    private static final String EXTRA_CONSTANT = "com.huawei.hms.location.internal.EXTRA_ACTIVITY_CONVERSION_RESULT";
    private static final String TAG = "ActivityConversionResp";
    private List<ActivityConversionData> activityConversionDatas;

    public static class yn implements Parcelable.Creator<ActivityConversionResponse> {
        public Object createFromParcel(Parcel parcel) {
            return new ActivityConversionResponse(parcel, (yn) null);
        }

        public Object[] newArray(int i11) {
            return new ActivityConversionResponse[i11];
        }
    }

    public ActivityConversionResponse() {
        this.activityConversionDatas = new ArrayList();
    }

    private ActivityConversionResponse(Parcel parcel) {
        this.activityConversionDatas = new ArrayList();
        this.activityConversionDatas = parcel.createTypedArrayList(ActivityConversionData.CREATOR);
    }

    public /* synthetic */ ActivityConversionResponse(Parcel parcel, yn ynVar) {
        this(parcel);
    }

    public ActivityConversionResponse(List<ActivityConversionData> list) {
        new ArrayList();
        this.activityConversionDatas = list;
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

    public static ActivityConversionResponse getDataFromIntent(Intent intent) {
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
            if (parcelableExtra instanceof ActivityConversionResponse) {
                return (ActivityConversionResponse) parcelableExtra;
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
        if (obj instanceof ActivityConversionResponse) {
            return getClass() == obj.getClass() && this.activityConversionDatas.equals(((ActivityConversionResponse) obj).activityConversionDatas);
        }
        return false;
    }

    public List<ActivityConversionData> getActivityConversionDatas() {
        return this.activityConversionDatas;
    }

    public int hashCode() {
        return this.activityConversionDatas.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeTypedList(this.activityConversionDatas);
    }
}
