package com.huawei.hms.location;

import android.os.Parcel;
import android.os.Parcelable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class ActivityConversionData implements Parcelable {
    public static final Parcelable.Creator<ActivityConversionData> CREATOR = new yn();
    private int activityType;
    private int conversionType;
    private long elapsedTimeFromReboot;

    public static class yn implements Parcelable.Creator<ActivityConversionData> {
        public Object createFromParcel(Parcel parcel) {
            return new ActivityConversionData(parcel, (yn) null);
        }

        public Object[] newArray(int i11) {
            return new ActivityConversionData[0];
        }
    }

    public ActivityConversionData() {
    }

    public ActivityConversionData(int i11, int i12, long j11) {
        if (!ActivityIdentificationData.isValidType(i11) || !(i12 == 0 || i12 == 1)) {
            throw new IllegalArgumentException("ActivityConversionData:The parameter is out of range");
        }
        this.activityType = i11;
        this.conversionType = i12;
        this.elapsedTimeFromReboot = j11;
    }

    private ActivityConversionData(Parcel parcel) {
        this.activityType = parcel.readInt();
        this.conversionType = parcel.readInt();
        this.elapsedTimeFromReboot = parcel.readLong();
    }

    public /* synthetic */ ActivityConversionData(Parcel parcel, yn ynVar) {
        this(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityConversionData)) {
            return false;
        }
        ActivityConversionData activityConversionData = (ActivityConversionData) obj;
        return this.activityType == activityConversionData.getActivityType() && this.conversionType == activityConversionData.getConversionType() && this.elapsedTimeFromReboot == activityConversionData.getElapsedTimeFromReboot();
    }

    public int getActivityType() {
        return this.activityType;
    }

    public int getConversionType() {
        return this.conversionType;
    }

    public long getElapsedTimeFromReboot() {
        return this.elapsedTimeFromReboot;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return "ActivityConversionData{activityType=" + this.activityType + ", conversionType=" + this.conversionType + ", elapsedTimeFromReboot=" + this.elapsedTimeFromReboot + AbstractJsonLexerKt.END_OBJ;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.activityType);
        parcel.writeInt(this.conversionType);
        parcel.writeLong(this.elapsedTimeFromReboot);
    }
}
