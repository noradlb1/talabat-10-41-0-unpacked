package com.huawei.location.resp;

import android.location.Location;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

public class yn implements Parcelable {
    public static final Parcelable.Creator<yn> CREATOR = new C0088yn();

    /* renamed from: yn  reason: collision with root package name */
    private Location f50211yn;

    /* renamed from: com.huawei.location.resp.yn$yn  reason: collision with other inner class name */
    public static class C0088yn implements Parcelable.Creator<yn> {
        public Object createFromParcel(Parcel parcel) {
            return new yn(parcel);
        }

        public Object[] newArray(int i11) {
            return new yn[i11];
        }
    }

    public yn() {
    }

    public yn(Location location) {
        this.f50211yn = location;
    }

    public yn(Parcel parcel) {
        if (this.f50211yn == null) {
            this.f50211yn = new Location(parcel.readString());
        }
        this.f50211yn.setTime(parcel.readLong());
        this.f50211yn.setElapsedRealtimeNanos(parcel.readLong());
        parcel.readByte();
        this.f50211yn.setLatitude(parcel.readDouble());
        this.f50211yn.setLongitude(parcel.readDouble());
        this.f50211yn.setAltitude(parcel.readDouble());
        this.f50211yn.setSpeed(parcel.readFloat());
        this.f50211yn.setBearing(parcel.readFloat());
        this.f50211yn.setAccuracy(parcel.readFloat());
        if (Build.VERSION.SDK_INT >= 26) {
            this.f50211yn.setVerticalAccuracyMeters(parcel.readFloat());
            this.f50211yn.setSpeedAccuracyMetersPerSecond(parcel.readFloat());
            this.f50211yn.setBearingAccuracyDegrees(parcel.readFloat());
        }
        this.f50211yn.setExtras(parcel.readBundle(yn.class.getClassLoader()));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        Location location = this.f50211yn;
        if (location != null) {
            String provider = location.getProvider();
            if (provider == null) {
                provider = "";
            }
            parcel.writeString(provider);
            parcel.writeLong(this.f50211yn.getTime());
            parcel.writeLong(this.f50211yn.getElapsedRealtimeNanos());
            parcel.writeByte((byte) 0);
            parcel.writeDouble(this.f50211yn.getLatitude());
            parcel.writeDouble(this.f50211yn.getLongitude());
            parcel.writeDouble(this.f50211yn.getAltitude());
            parcel.writeFloat(this.f50211yn.getSpeed());
            parcel.writeFloat(this.f50211yn.getBearing());
            parcel.writeFloat(this.f50211yn.getAccuracy());
            if (Build.VERSION.SDK_INT >= 26) {
                parcel.writeFloat(this.f50211yn.getVerticalAccuracyMeters());
                parcel.writeFloat(this.f50211yn.getSpeedAccuracyMetersPerSecond());
                parcel.writeFloat(this.f50211yn.getBearingAccuracyDegrees());
            }
            parcel.writeBundle(this.f50211yn.getExtras());
        }
    }

    public Location yn() {
        return this.f50211yn;
    }
}
