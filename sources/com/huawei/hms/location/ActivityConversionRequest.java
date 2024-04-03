package com.huawei.hms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class ActivityConversionRequest implements Parcelable, IMessageEntity {
    public static final Parcelable.Creator<ActivityConversionRequest> CREATOR = new yn();
    public static final Comparator<ActivityConversionInfo> IS_EQUAL_CONVERSION = new Vw();
    @Packed
    private List<ActivityConversionInfo> activityConversions;

    public static class Vw implements Comparator<ActivityConversionInfo> {
        /* JADX WARNING: Removed duplicated region for block: B:6:0x001f A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x0021 A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int compare(java.lang.Object r3, java.lang.Object r4) {
            /*
                r2 = this;
                com.huawei.hms.location.ActivityConversionInfo r3 = (com.huawei.hms.location.ActivityConversionInfo) r3
                com.huawei.hms.location.ActivityConversionInfo r4 = (com.huawei.hms.location.ActivityConversionInfo) r4
                int r0 = r3.getActivityType()
                int r1 = r4.getActivityType()
                int r0 = r0 - r1
                if (r0 == 0) goto L_0x0012
                if (r0 <= 0) goto L_0x0021
                goto L_0x001f
            L_0x0012:
                int r3 = r3.getConversionType()
                int r4 = r4.getConversionType()
                int r3 = r3 - r4
                if (r3 == 0) goto L_0x0023
                if (r3 <= 0) goto L_0x0021
            L_0x001f:
                r3 = 1
                goto L_0x0024
            L_0x0021:
                r3 = -1
                goto L_0x0024
            L_0x0023:
                r3 = 0
            L_0x0024:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.location.ActivityConversionRequest.Vw.compare(java.lang.Object, java.lang.Object):int");
        }
    }

    public static class yn implements Parcelable.Creator<ActivityConversionRequest> {
        public Object createFromParcel(Parcel parcel) {
            return new ActivityConversionRequest(parcel);
        }

        public Object[] newArray(int i11) {
            return new ActivityConversionRequest[i11];
        }
    }

    public ActivityConversionRequest() {
    }

    public ActivityConversionRequest(Parcel parcel) {
        this.activityConversions = parcel.createTypedArrayList(ActivityConversionInfo.CREATOR);
    }

    public ActivityConversionRequest(List<ActivityConversionInfo> list) {
        this.activityConversions = list;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !(obj instanceof ActivityConversionRequest)) {
            return false;
        }
        return Objects.equals(this.activityConversions, ((ActivityConversionRequest) obj).getActivityConversions());
    }

    public List<ActivityConversionInfo> getActivityConversions() {
        return this.activityConversions;
    }

    public int hashCode() {
        return this.activityConversions.hashCode();
    }

    public void setActivityConversions(List<ActivityConversionInfo> list) {
        this.activityConversions = list;
    }

    public void setDataToIntent(Intent intent) {
        if (intent != null) {
            intent.putExtra("com.huawei.hms.location.internal.EXTRA_ACTIVITY_CONVERSION_REQUEST", this);
            return;
        }
        throw new IllegalArgumentException("ActivityConversionRequest:The parameter is null");
    }

    public String toString() {
        return "ActivityConversionRequest{activityConversions=" + this.activityConversions + AbstractJsonLexerKt.END_OBJ;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeTypedList(this.activityConversions);
    }
}
