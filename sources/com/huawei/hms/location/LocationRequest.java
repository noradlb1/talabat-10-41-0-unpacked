package com.huawei.hms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.lang3.time.DateUtils;

public class LocationRequest implements IMessageEntity, Parcelable {
    public static final int COORDINATE_TYPE_GCJ02 = 1;
    public static final int COORDINATE_TYPE_WGS84 = 0;
    public static final Parcelable.Creator<LocationRequest> CREATOR = new yn();
    private static final double FASTEST_INTERVAL_FACTOR = 6.0d;
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_HD_ACCURACY = 200;
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_INDOOR = 300;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_NO_POWER = 105;
    @Packed
    private int coordinateType;
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

    public static class yn implements Parcelable.Creator<LocationRequest> {
        public Object createFromParcel(Parcel parcel) {
            return new LocationRequest(parcel);
        }

        public Object[] newArray(int i11) {
            return new LocationRequest[i11];
        }
    }

    public LocationRequest() {
        this.priority = 102;
        this.interval = DateUtils.MILLIS_PER_HOUR;
        this.fastestInterval = (long) (((double) DateUtils.MILLIS_PER_HOUR) / FASTEST_INTERVAL_FACTOR);
        this.isFastestIntervalExplicitlySet = false;
        this.expirationTime = Long.MAX_VALUE;
        this.numUpdates = Integer.MAX_VALUE;
        this.smallestDisplacement = 0.0f;
        this.maxWaitTime = 0;
        this.needAddress = false;
        this.language = "";
        this.countryCode = "";
        this.coordinateType = 0;
    }

    public LocationRequest(Parcel parcel) {
        this.priority = parcel.readInt();
        this.interval = parcel.readLong();
        this.fastestInterval = parcel.readLong();
        boolean z11 = true;
        this.isFastestIntervalExplicitlySet = parcel.readByte() != 0;
        this.expirationTime = parcel.readLong();
        this.numUpdates = parcel.readInt();
        this.smallestDisplacement = parcel.readFloat();
        this.maxWaitTime = parcel.readLong();
        this.needAddress = parcel.readByte() == 0 ? false : z11;
        this.language = parcel.readString();
        this.countryCode = parcel.readString();
        this.coordinateType = parcel.readInt();
        HashMap hashMap = new HashMap();
        this.extras = hashMap;
        parcel.readMap(hashMap, LocationRequest.class.getClassLoader());
    }

    public static LocationRequest create() {
        return new LocationRequest();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LocationRequest locationRequest = obj instanceof LocationRequest ? (LocationRequest) obj : null;
        if (locationRequest == null) {
            return false;
        }
        boolean z11 = this.expirationTime == locationRequest.expirationTime && this.isFastestIntervalExplicitlySet == locationRequest.isFastestIntervalExplicitlySet && this.fastestInterval == locationRequest.fastestInterval && this.interval == locationRequest.interval && this.maxWaitTime == locationRequest.maxWaitTime && this.numUpdates == locationRequest.numUpdates && this.priority == locationRequest.priority && this.needAddress == locationRequest.needAddress && Float.compare(this.smallestDisplacement, locationRequest.smallestDisplacement) == 0 && this.coordinateType == locationRequest.coordinateType;
        String str3 = this.language;
        boolean z12 = str3 != null && (str2 = locationRequest.language) != null && z11 && str3.equals(str2);
        String str4 = this.countryCode;
        return str4 != null && (str = locationRequest.countryCode) != null && z12 && str4.equals(str);
    }

    public int getCoordinateType() {
        return this.coordinateType;
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
        long j11 = this.maxWaitTime;
        long j12 = this.interval;
        return j11 < j12 ? j12 : j11;
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

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.priority), Long.valueOf(this.interval), Long.valueOf(this.fastestInterval), Boolean.valueOf(this.isFastestIntervalExplicitlySet), Long.valueOf(this.expirationTime), Integer.valueOf(this.numUpdates), Float.valueOf(this.smallestDisplacement), Long.valueOf(this.maxWaitTime), Boolean.valueOf(this.needAddress), this.language, this.countryCode, Integer.valueOf(this.coordinateType)});
    }

    public boolean isFastestIntervalExplicitlySet() {
        return this.isFastestIntervalExplicitlySet;
    }

    public void putExtras(String str, String str2) {
        if (this.extras == null) {
            this.extras = new HashMap();
        }
        this.extras.put(str, str2);
    }

    public LocationRequest setCoordinateType(int i11) {
        this.coordinateType = i11;
        return this;
    }

    public LocationRequest setCountryCode(String str) {
        this.countryCode = str;
        return this;
    }

    public LocationRequest setExpirationDuration(long j11) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j12 = Long.MAX_VALUE;
        if (j11 <= Long.MAX_VALUE - elapsedRealtime) {
            j12 = j11 + elapsedRealtime;
        }
        this.expirationTime = j12;
        if (j12 < 0) {
            j12 = 0;
        }
        this.expirationTime = j12;
        return this;
    }

    public LocationRequest setExpirationTime(long j11) {
        if (j11 < 0) {
            j11 = 0;
        }
        this.expirationTime = j11;
        return this;
    }

    public LocationRequest setFastestInterval(long j11) throws IllegalArgumentException {
        if (j11 >= 0) {
            this.isFastestIntervalExplicitlySet = true;
            this.fastestInterval = j11;
            return this;
        }
        throw new IllegalArgumentException("FastestInterval is invalid");
    }

    public LocationRequest setInterval(long j11) throws IllegalArgumentException {
        if (j11 >= 0) {
            this.interval = j11;
            this.fastestInterval = this.isFastestIntervalExplicitlySet ? this.fastestInterval : (long) (((double) j11) / FASTEST_INTERVAL_FACTOR);
            return this;
        }
        throw new IllegalArgumentException("interval is invalid");
    }

    public LocationRequest setLanguage(String str) {
        this.language = str;
        return this;
    }

    public LocationRequest setMaxWaitTime(long j11) {
        this.maxWaitTime = j11;
        return this;
    }

    public LocationRequest setNeedAddress(boolean z11) {
        this.needAddress = z11;
        return this;
    }

    public LocationRequest setNumUpdates(int i11) throws IllegalArgumentException {
        if (i11 > 0) {
            this.numUpdates = i11;
            return this;
        }
        throw new IllegalArgumentException("numUpdates is invalid");
    }

    public LocationRequest setPriority(int i11) {
        if (i11 == 102 || i11 == 100 || i11 == 104 || i11 == 105 || i11 == 200 || i11 == 300) {
            this.priority = i11;
            return this;
        }
        throw new IllegalArgumentException("priority is not a known constant");
    }

    public LocationRequest setSmallestDisplacement(float f11) {
        if (f11 >= 0.0f) {
            this.smallestDisplacement = f11;
            return this;
        }
        throw new IllegalArgumentException("smallestDisplacement param invalid");
    }

    public String toString() {
        return "LocationRequest{priority=" + this.priority + ", interval=" + this.interval + ", fastestInterval=" + this.fastestInterval + ", isFastestIntervalExplicitlySet=" + this.isFastestIntervalExplicitlySet + ", expirationTime=" + this.expirationTime + ", numUpdates=" + this.numUpdates + ", smallestDisplacement=" + this.smallestDisplacement + ", maxWaitTime=" + this.maxWaitTime + ", needAddress=" + this.needAddress + ", language=" + this.language + ", countryCode=" + this.countryCode + ", coordinateType=" + this.coordinateType + AbstractJsonLexerKt.END_OBJ;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.priority);
        parcel.writeLong(this.interval);
        parcel.writeLong(this.fastestInterval);
        parcel.writeByte(this.isFastestIntervalExplicitlySet ? (byte) 1 : 0);
        parcel.writeLong(this.expirationTime);
        parcel.writeInt(this.numUpdates);
        parcel.writeFloat(this.smallestDisplacement);
        parcel.writeLong(this.maxWaitTime);
        parcel.writeByte(this.needAddress ? (byte) 1 : 0);
        parcel.writeString(this.language);
        parcel.writeString(this.countryCode);
        parcel.writeInt(this.coordinateType);
        parcel.writeMap(this.extras);
    }
}
