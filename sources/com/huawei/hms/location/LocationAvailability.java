package com.huawei.hms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.Arrays;

public class LocationAvailability implements Parcelable, IMessageEntity {
    public static final Parcelable.Creator<LocationAvailability> CREATOR = new yn();
    private static final String EXTRA_KEY = "com.huawei.hms.location.EXTRA_LOCATION_AVAILABILITY";
    private static final int LOCATION_STATUS_AVAILABLE = 1000;
    private static final String TAG = "LocationAvailability";
    @Packed
    private int cellStatus;
    @Packed
    private long elapsedRealtimeNs;
    @Packed
    private int locationStatus;
    @Packed
    private int wifiStatus;

    public static class yn implements Parcelable.Creator<LocationAvailability> {
        public Object createFromParcel(Parcel parcel) {
            return new LocationAvailability(parcel);
        }

        public Object[] newArray(int i11) {
            return new LocationAvailability[i11];
        }
    }

    public LocationAvailability() {
    }

    public LocationAvailability(Parcel parcel) {
        this.cellStatus = parcel.readInt();
        this.wifiStatus = parcel.readInt();
        this.elapsedRealtimeNs = parcel.readLong();
        this.locationStatus = parcel.readInt();
    }

    public static LocationAvailability extractLocationAvailability(Intent intent) {
        try {
            if (!(intent.getParcelableExtra(EXTRA_KEY) instanceof LocationAvailability) || !hasLocationAvailability(intent)) {
                return null;
            }
            return (LocationAvailability) intent.getParcelableExtra(EXTRA_KEY);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean hasLocationAvailability(Intent intent) {
        if (intent == null) {
            return false;
        }
        try {
            return intent.hasExtra(EXTRA_KEY);
        } catch (Exception unused) {
            return false;
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocationAvailability)) {
            return false;
        }
        LocationAvailability locationAvailability = (LocationAvailability) obj;
        return this.cellStatus == locationAvailability.cellStatus && this.wifiStatus == locationAvailability.wifiStatus && this.elapsedRealtimeNs == locationAvailability.elapsedRealtimeNs && this.locationStatus == locationAvailability.locationStatus;
    }

    public int getCellStatus() {
        return this.cellStatus;
    }

    public long getElapsedRealtimeNs() {
        return this.elapsedRealtimeNs;
    }

    public int getLocationStatus() {
        return this.locationStatus;
    }

    public int getWifiStatus() {
        return this.wifiStatus;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.locationStatus), Integer.valueOf(this.cellStatus), Integer.valueOf(this.wifiStatus), Long.valueOf(this.elapsedRealtimeNs)});
    }

    public boolean isLocationAvailable() {
        return this.locationStatus < 1000;
    }

    public void setCellStatus(int i11) {
        this.cellStatus = i11;
    }

    public void setElapsedRealtimeNs(long j11) {
        this.elapsedRealtimeNs = j11;
    }

    public void setLocationStatus(int i11) {
        this.locationStatus = i11;
    }

    public void setWifiStatus(int i11) {
        this.wifiStatus = i11;
    }

    public String toString() {
        return "LocationAvailability[isLocationAvailable: " + isLocationAvailable() + "]";
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.cellStatus);
        parcel.writeInt(this.wifiStatus);
        parcel.writeLong(this.elapsedRealtimeNs);
        parcel.writeInt(this.locationStatus);
    }
}
