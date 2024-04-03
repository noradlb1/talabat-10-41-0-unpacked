package com.huawei.hms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import com.huawei.hms.common.internal.safeparcel.SafeParcelableSerializer;
import com.huawei.hms.core.aidl.annotation.Packed;

public class LocationSettingsStates extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new yn();
    @Packed
    private boolean blePresent;
    @Packed
    private boolean bleUsable;
    @Packed
    private boolean gnssPresent;
    @Packed
    private boolean gnssUsable;
    @Packed
    @Deprecated
    private boolean gpsPresent;
    @Packed
    @Deprecated
    private boolean gpsUsable;
    @Packed
    private boolean hmsLocationPresent;
    @Packed
    private boolean hmsLocationUsable;
    @Packed
    private boolean locationPresent;
    @Packed
    private boolean locationUsable;
    @Packed
    private boolean networkLocationPresent;
    @Packed
    private boolean networkLocationUsable;

    public static class yn implements Parcelable.Creator<LocationSettingsStates> {
        public Object createFromParcel(Parcel parcel) {
            return new LocationSettingsStates(parcel);
        }

        public Object[] newArray(int i11) {
            return new LocationSettingsStates[i11];
        }
    }

    public LocationSettingsStates() {
        this.hmsLocationUsable = true;
        this.hmsLocationPresent = true;
    }

    public LocationSettingsStates(Parcel parcel) {
        boolean z11 = true;
        this.hmsLocationUsable = true;
        this.hmsLocationPresent = true;
        this.blePresent = parcel.readByte() != 0;
        this.bleUsable = parcel.readByte() != 0;
        this.gpsPresent = parcel.readByte() != 0;
        this.gpsUsable = parcel.readByte() != 0;
        this.locationPresent = parcel.readByte() != 0;
        this.locationUsable = parcel.readByte() != 0;
        this.networkLocationPresent = parcel.readByte() != 0;
        this.networkLocationUsable = parcel.readByte() != 0;
        this.hmsLocationUsable = parcel.readByte() != 0;
        this.hmsLocationPresent = parcel.readByte() != 0;
        this.gnssUsable = parcel.readByte() != 0;
        this.gnssPresent = parcel.readByte() == 0 ? false : z11;
    }

    @Deprecated
    public LocationSettingsStates(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18) {
        this.gpsUsable = z11;
        this.networkLocationUsable = z12;
        this.bleUsable = z13;
        this.gpsPresent = z14;
        this.networkLocationPresent = z15;
        this.blePresent = z16;
        this.hmsLocationUsable = z17;
        this.hmsLocationPresent = z18;
        this.gnssUsable = z11;
        this.gnssPresent = z14;
    }

    public static LocationSettingsStates fromIntent(Intent intent) {
        if (intent == null) {
            return new LocationSettingsStates();
        }
        LocationSettingsStates locationSettingsStates = (LocationSettingsStates) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "com.huawei.hms.location.LOCATION_SETTINGS_STATES", CREATOR);
        if (locationSettingsStates == null) {
            return new LocationSettingsStates();
        }
        locationSettingsStates.setGnssUsable(locationSettingsStates.isGpsUsable());
        locationSettingsStates.setGnssPresent(locationSettingsStates.isGpsPresent());
        return locationSettingsStates;
    }

    public boolean isBlePresent() {
        return this.blePresent;
    }

    public boolean isBleUsable() {
        return this.bleUsable;
    }

    public boolean isGnssPresent() {
        return this.gnssPresent;
    }

    public boolean isGnssUsable() {
        return this.gnssUsable;
    }

    @Deprecated
    public boolean isGpsPresent() {
        return this.gpsPresent;
    }

    @Deprecated
    public boolean isGpsUsable() {
        return this.gpsUsable;
    }

    public boolean isHMSLocationPresent() {
        return this.hmsLocationPresent;
    }

    public boolean isHMSLocationUsable() {
        return this.hmsLocationUsable;
    }

    public boolean isLocationPresent() {
        return this.locationPresent;
    }

    public boolean isLocationUsable() {
        return this.locationUsable;
    }

    public boolean isNetworkLocationPresent() {
        return this.networkLocationPresent;
    }

    public boolean isNetworkLocationUsable() {
        return this.networkLocationUsable;
    }

    public void setBlePresent(boolean z11) {
        this.blePresent = z11;
    }

    public void setBleUsable(boolean z11) {
        this.bleUsable = z11;
    }

    public void setGnssPresent(boolean z11) {
        this.gnssPresent = z11;
    }

    public void setGnssUsable(boolean z11) {
        this.gnssUsable = z11;
    }

    @Deprecated
    public void setGpsPresent(boolean z11) {
        this.gpsPresent = z11;
    }

    @Deprecated
    public void setGpsUsable(boolean z11) {
        this.gpsUsable = z11;
    }

    public void setHMSLocationPresent(boolean z11) {
        this.hmsLocationPresent = z11;
    }

    public void setHmsLocationUsable(boolean z11) {
        this.hmsLocationUsable = z11;
    }

    public void setLocationPresent(boolean z11) {
        this.locationPresent = z11;
    }

    public void setLocationUsable(boolean z11) {
        this.locationUsable = z11;
    }

    public void setNetworkLocationPresent(boolean z11) {
        this.networkLocationPresent = z11;
    }

    public void setNetworkLocationUsable(boolean z11) {
        this.networkLocationUsable = z11;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, isGpsUsable());
        SafeParcelWriter.writeBoolean(parcel, 2, isNetworkLocationUsable());
        SafeParcelWriter.writeBoolean(parcel, 3, isBleUsable());
        SafeParcelWriter.writeBoolean(parcel, 4, isGpsPresent());
        SafeParcelWriter.writeBoolean(parcel, 5, isNetworkLocationPresent());
        SafeParcelWriter.writeBoolean(parcel, 6, isBlePresent());
        SafeParcelWriter.writeBoolean(parcel, 7, isHMSLocationUsable());
        SafeParcelWriter.writeBoolean(parcel, 8, isHMSLocationPresent());
        SafeParcelWriter.writeBoolean(parcel, 9, isGnssUsable());
        SafeParcelWriter.writeBoolean(parcel, 10, isGnssPresent());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
