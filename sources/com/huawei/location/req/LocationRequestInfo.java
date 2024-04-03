package com.huawei.location.req;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class LocationRequestInfo implements IMessageEntity, Parcelable {
    public static final Parcelable.Creator<LocationRequestInfo> CREATOR = new yn();
    @Packed
    private String countryCode;
    @Packed
    private long expirationTime;
    @Packed
    private Map<String, String> extras;
    @Packed
    private long fastestInterval;
    @Packed
    private long interval;
    @Packed
    private boolean isFastestIntervalExplicitlySet;
    @Packed
    private String language;
    @Packed
    private long maxWaitTime;
    @Packed
    private boolean needAddress;
    @Packed
    private int numUpdates;
    @Packed
    private int priority;
    @Packed
    private float smallestDisplacement;

    public static class yn implements Parcelable.Creator<LocationRequestInfo> {
        public Object createFromParcel(Parcel parcel) {
            return new LocationRequestInfo(parcel);
        }

        public Object[] newArray(int i11) {
            return new LocationRequestInfo[i11];
        }
    }

    public LocationRequestInfo() {
    }

    public LocationRequestInfo(Parcel parcel) {
        this.expirationTime = parcel.readLong();
        this.fastestInterval = parcel.readLong();
        this.interval = parcel.readLong();
        this.maxWaitTime = parcel.readLong();
        this.numUpdates = parcel.readInt();
        this.priority = parcel.readInt();
        this.smallestDisplacement = parcel.readFloat();
        boolean z11 = true;
        this.isFastestIntervalExplicitlySet = parcel.readByte() != 0;
        this.needAddress = parcel.readByte() == 0 ? false : z11;
        this.language = parcel.readString();
        this.countryCode = parcel.readString();
    }

    public int deductNumUpdates() {
        int i11 = this.numUpdates - 1;
        this.numUpdates = i11;
        return i11;
    }

    public int describeContents() {
        return 0;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public long getExpirationTime() {
        return this.expirationTime;
    }

    public Map<String, String> getExtras() {
        return this.extras;
    }

    public long getFastestInterval() {
        return this.fastestInterval;
    }

    public long getInterval() {
        return this.interval;
    }

    public String getLanguage() {
        return this.language;
    }

    public long getMaxWaitTime() {
        return this.maxWaitTime;
    }

    public boolean getNeedAddress() {
        return this.needAddress;
    }

    public int getNumUpdates() {
        return this.numUpdates;
    }

    public int getPriority() {
        return this.priority;
    }

    public float getSmallestDisplacement() {
        return this.smallestDisplacement;
    }

    public boolean isFastestIntervalExplicitlySet() {
        return this.isFastestIntervalExplicitlySet;
    }

    public boolean isValid() {
        int i11 = this.priority;
        return i11 == 200 || i11 == 100 || i11 == 102 || i11 == 104 || i11 == 300 || i11 == 105;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setExpirationTime(long j11) {
        this.expirationTime = j11;
    }

    public void setExtras(Map<String, String> map) {
        this.extras = map;
    }

    public void setFastestInterval(long j11) {
        this.fastestInterval = j11;
    }

    public void setFastestIntervalExplicitlySet(boolean z11) {
        this.isFastestIntervalExplicitlySet = z11;
    }

    public void setInterval(long j11) {
        this.interval = j11;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setMaxWaitTime(long j11) {
        this.maxWaitTime = j11;
    }

    public void setNeedAddress(boolean z11) {
        this.needAddress = z11;
    }

    public void setNumUpdates(int i11) {
        this.numUpdates = i11;
    }

    public void setPriority(int i11) {
        this.priority = i11;
    }

    public void setSmallestDisplacement(float f11) {
        this.smallestDisplacement = f11;
    }

    public String toString() {
        return "{expirationTime=" + this.expirationTime + ", fastestInterval=" + this.fastestInterval + ", interval=" + this.interval + ", maxWaitTime=" + this.maxWaitTime + ", numUpdates=" + this.numUpdates + ", priority=" + this.priority + ", smallestDisplacement=" + this.smallestDisplacement + ", isFastestIntervalExplicitlySet=" + this.isFastestIntervalExplicitlySet + ", needAddress=" + this.needAddress + ", language='" + this.language + '\'' + ", countryCode='" + this.countryCode + '\'' + ", extras=" + this.extras + AbstractJsonLexerKt.END_OBJ;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.expirationTime);
        parcel.writeLong(this.fastestInterval);
        parcel.writeLong(this.interval);
        parcel.writeLong(this.maxWaitTime);
        parcel.writeInt(this.numUpdates);
        parcel.writeInt(this.priority);
        parcel.writeFloat(this.smallestDisplacement);
        parcel.writeByte(this.isFastestIntervalExplicitlySet ? (byte) 1 : 0);
        parcel.writeByte(this.needAddress ? (byte) 1 : 0);
        parcel.writeString(this.language);
        parcel.writeString(this.countryCode);
    }
}
