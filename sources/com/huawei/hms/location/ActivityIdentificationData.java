package com.huawei.hms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import java.util.Arrays;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class ActivityIdentificationData implements Parcelable {
    public static final int BIKE = 101;
    public static final Parcelable.Creator<ActivityIdentificationData> CREATOR = new yn();
    public static final int FOOT = 102;
    public static final int OTHERS = 104;
    private static final int POSSIBILITY_MAX = 100;
    private static final int POSSIBILITY_MIN = 0;
    public static final int RUNNING = 108;
    public static final int STILL = 103;
    private static final int[] VALID_TYPE_ARRAY = {100, 101, 102, 103, 107, 108};
    public static final int VEHICLE = 100;
    public static final int WALKING = 107;
    private int identificationActivity;
    private int possibility;

    public static class yn implements Parcelable.Creator<ActivityIdentificationData> {
        public Object createFromParcel(Parcel parcel) {
            return new ActivityIdentificationData(parcel, (yn) null);
        }

        public Object[] newArray(int i11) {
            return new ActivityIdentificationData[i11];
        }
    }

    public ActivityIdentificationData(int i11, int i12) throws ApiException {
        if (i12 > 100 || i12 < 0) {
            throw new ApiException(new Status(10802, LocationStatusCode.getStatusCodeString(10802)));
        }
        this.identificationActivity = i11;
        this.possibility = i12;
    }

    private ActivityIdentificationData(Parcel parcel) {
        this.identificationActivity = parcel.readInt();
        this.possibility = parcel.readInt();
    }

    public /* synthetic */ ActivityIdentificationData(Parcel parcel, yn ynVar) {
        this(parcel);
    }

    public static boolean isValidType(int i11) {
        return Arrays.binarySearch(VALID_TYPE_ARRAY, i11) >= 0;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return true;
        }
        if (getClass() != obj.getClass() || !(obj instanceof ActivityIdentificationData)) {
            return false;
        }
        ActivityIdentificationData activityIdentificationData = (ActivityIdentificationData) obj;
        return this.identificationActivity == activityIdentificationData.getIdentificationActivity() && this.possibility == activityIdentificationData.getPossibility();
    }

    public int getIdentificationActivity() {
        return this.identificationActivity;
    }

    public int getPossibility() {
        return this.possibility;
    }

    public int hashCode() {
        return new Object[]{Integer.valueOf(this.identificationActivity), Integer.valueOf(this.possibility)}.hashCode();
    }

    public void setIdentificationActivity(int i11) {
        this.identificationActivity = i11;
    }

    public void setPossibility(int i11) throws ApiException {
        if (i11 > 100 || i11 < 0) {
            throw new ApiException(new Status(10802, LocationStatusCode.getStatusCodeString(10802)));
        }
        this.possibility = i11;
    }

    public String toString() {
        String str;
        int i11 = this.identificationActivity;
        switch (i11) {
            case 100:
                str = "VEHICLE";
                break;
            case 101:
                str = "BIKE";
                break;
            case 102:
                str = "FOOT";
                break;
            case 103:
                str = "STILL";
                break;
            case 104:
                str = "OTHERS";
                break;
            case 107:
                str = "WALKING";
                break;
            case 108:
                str = DebugCoroutineInfoImplKt.RUNNING;
                break;
            default:
                str = Integer.toString(i11);
                break;
        }
        return "ActivityIdentificationData{identificationActivity=" + str + ", possibility=" + this.possibility + AbstractJsonLexerKt.END_OBJ;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.identificationActivity);
        parcel.writeInt(this.possibility);
    }
}
