package com.huawei.hms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class ActivityConversionInfo implements Parcelable, IMessageEntity {
    public static final Parcelable.Creator<ActivityConversionInfo> CREATOR = new yn();
    public static final int ENTER_ACTIVITY_CONVERSION = 0;
    public static final int EXIT_ACTIVITY_CONVERSION = 1;
    @Packed
    private int activityType;
    @Packed
    private int conversionType;

    public static class Builder {
        private int mActivityType = -1;
        private int mConversionType = -1;

        public ActivityConversionInfo build() {
            boolean z11 = true;
            Preconditions.checkState(this.mActivityType != -1, "ActivityType not set.");
            if (this.mConversionType == -1) {
                z11 = false;
            }
            Preconditions.checkState(z11, "ConversionType not set.");
            return new ActivityConversionInfo(this.mActivityType, this.mConversionType);
        }

        public Builder setActivityType(int i11) {
            if (ActivityIdentificationData.isValidType(i11)) {
                this.mActivityType = i11;
                return this;
            }
            throw new IllegalArgumentException("ActivityConversionInfo:The parameter is out of range");
        }

        public Builder setConversionType(int i11) {
            if (i11 == 0 || i11 == 1) {
                this.mConversionType = i11;
                return this;
            }
            throw new IllegalArgumentException("ActivityConversionInfo:The parameter is out of range");
        }
    }

    public static class yn implements Parcelable.Creator<ActivityConversionInfo> {
        public Object createFromParcel(Parcel parcel) {
            return new ActivityConversionInfo(parcel);
        }

        public Object[] newArray(int i11) {
            return new ActivityConversionInfo[i11];
        }
    }

    public ActivityConversionInfo() {
    }

    public ActivityConversionInfo(int i11, int i12) {
        if (!ActivityIdentificationData.isValidType(i11) || !(i12 == 0 || i12 == 1)) {
            throw new IllegalArgumentException("ActivityConversionInfo:The parameter is out of range");
        }
        this.activityType = i11;
        this.conversionType = i12;
    }

    public ActivityConversionInfo(Parcel parcel) {
        this.activityType = parcel.readInt();
        this.conversionType = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return true;
        }
        if (!(obj instanceof ActivityConversionInfo)) {
            return false;
        }
        ActivityConversionInfo activityConversionInfo = (ActivityConversionInfo) obj;
        return this.activityType == activityConversionInfo.getActivityType() && this.conversionType == activityConversionInfo.getConversionType();
    }

    public int getActivityType() {
        return this.activityType;
    }

    public int getConversionType() {
        return this.conversionType;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.activityType), Integer.valueOf(this.conversionType));
    }

    public void setActivityType(int i11) {
        if (ActivityIdentificationData.isValidType(i11)) {
            this.activityType = i11;
            return;
        }
        throw new IllegalArgumentException("ActivityConversionInfo:The parameter is out of range");
    }

    public void setConversionType(int i11) {
        if (i11 == 0 || i11 == 1) {
            this.conversionType = i11;
            return;
        }
        throw new IllegalArgumentException("ActivityConversionInfo:The parameter is out of range");
    }

    public String toString() {
        return "ActivityConversionInfo{activityType=" + this.activityType + ", conversionType=" + this.conversionType + AbstractJsonLexerKt.END_OBJ;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.activityType);
        parcel.writeInt(this.conversionType);
    }
}
