package com.huawei.hms.support.api.entity.location.geocoder;

import android.location.Location;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.support.api.entity.location.common.LocationBaseResponse;
import java.util.HashMap;

public class HwLocation extends LocationBaseResponse implements Parcelable {
    public static final Parcelable.Creator<HwLocation> CREATOR = new yn();
    private Address address;
    private Location location;

    public static class yn implements Parcelable.Creator<HwLocation> {
        public Object createFromParcel(Parcel parcel) {
            return new HwLocation(parcel);
        }

        public Object[] newArray(int i11) {
            return new HwLocation[i11];
        }
    }

    public HwLocation() {
    }

    public HwLocation(Location location2) {
        this.location = location2;
    }

    public HwLocation(Location location2, Address address2) {
        this.location = location2;
        this.address = address2;
    }

    public HwLocation(Parcel parcel) {
        if (this.location == null) {
            this.location = new Location(parcel.readString());
        }
        this.location.setTime(parcel.readLong());
        int i11 = Build.VERSION.SDK_INT;
        this.location.setElapsedRealtimeNanos(parcel.readLong());
        parcel.readByte();
        this.location.setLatitude(parcel.readDouble());
        this.location.setLongitude(parcel.readDouble());
        this.location.setAltitude(parcel.readDouble());
        this.location.setSpeed(parcel.readFloat());
        this.location.setBearing(parcel.readFloat());
        this.location.setAccuracy(parcel.readFloat());
        if (i11 >= 26) {
            this.location.setVerticalAccuracyMeters(parcel.readFloat());
            this.location.setSpeedAccuracyMetersPerSecond(parcel.readFloat());
            this.location.setBearingAccuracyDegrees(parcel.readFloat());
        }
        Class<HwLocation> cls = HwLocation.class;
        this.location.setExtras(parcel.readBundle(cls.getClassLoader()));
        if (this.address == null) {
            this.address = new Address();
        }
        this.address.setCountryCode(parcel.readString());
        this.address.setCountryName(parcel.readString());
        this.address.setState(parcel.readString());
        this.address.setCity(parcel.readString());
        this.address.setCounty(parcel.readString());
        this.address.setStreet(parcel.readString());
        this.address.setFeatureName(parcel.readString());
        this.address.setPostalCode(parcel.readString());
        this.address.setPhone(parcel.readString());
        this.address.setUrl(parcel.readString());
        HashMap hashMap = new HashMap();
        parcel.readMap(hashMap, cls.getClassLoader());
        this.address.setExtraInfo(hashMap);
    }

    private String getDefaultVal(String str) {
        return str == null ? "" : str;
    }

    public int describeContents() {
        return 0;
    }

    public Address getAddress() {
        return this.address;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setAddress(Address address2) {
        this.address = address2;
    }

    public void setLocation(Location location2) {
        this.location = location2;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        Location location2 = this.location;
        if (location2 != null) {
            parcel.writeString(getDefaultVal(location2.getProvider()));
            parcel.writeLong(this.location.getTime());
            int i12 = Build.VERSION.SDK_INT;
            parcel.writeLong(this.location.getElapsedRealtimeNanos());
            parcel.writeByte((byte) 0);
            parcel.writeDouble(this.location.getLatitude());
            parcel.writeDouble(this.location.getLongitude());
            parcel.writeDouble(this.location.getAltitude());
            parcel.writeFloat(this.location.getSpeed());
            parcel.writeFloat(this.location.getBearing());
            parcel.writeFloat(this.location.getAccuracy());
            if (i12 >= 26) {
                parcel.writeFloat(this.location.getVerticalAccuracyMeters());
                parcel.writeFloat(this.location.getSpeedAccuracyMetersPerSecond());
                parcel.writeFloat(this.location.getBearingAccuracyDegrees());
            }
            parcel.writeBundle(this.location.getExtras());
        }
        Address address2 = this.address;
        if (address2 != null) {
            parcel.writeString(getDefaultVal(address2.getCountryCode()));
            parcel.writeString(getDefaultVal(this.address.getCountryName()));
            parcel.writeString(getDefaultVal(this.address.getState()));
            parcel.writeString(getDefaultVal(this.address.getCity()));
            parcel.writeString(getDefaultVal(this.address.getCounty()));
            parcel.writeString(getDefaultVal(this.address.getStreet()));
            parcel.writeString(getDefaultVal(this.address.getFeatureName()));
            parcel.writeString(getDefaultVal(this.address.getPostalCode()));
            parcel.writeString(getDefaultVal(this.address.getPhone()));
            parcel.writeString(getDefaultVal(this.address.getUrl()));
            parcel.writeMap(this.address.getExtraInfo());
        }
    }
}
