package com.huawei.hms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;
import java.util.Arrays;

@Deprecated
public class StreetViewPanoramaCamera implements Parcelable {
    public static final Parcelable.Creator<StreetViewPanoramaCamera> CREATOR = new Parcelable.Creator<StreetViewPanoramaCamera>() {
        public StreetViewPanoramaCamera createFromParcel(Parcel parcel) {
            return new StreetViewPanoramaCamera(parcel);
        }

        public StreetViewPanoramaCamera[] newArray(int i11) {
            return new StreetViewPanoramaCamera[i11];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final StreetViewPanoramaOrientation f49558a;
    public final float bearing;
    public final float tilt;
    public final float zoom;

    public static class Builder {
        public float bearing;
        public float tilt;
        public float zoom;

        public Builder() {
        }

        public Builder(StreetViewPanoramaCamera streetViewPanoramaCamera) {
            this.bearing = streetViewPanoramaCamera.bearing;
            this.tilt = streetViewPanoramaCamera.tilt;
            this.zoom = streetViewPanoramaCamera.zoom;
        }

        public Builder bearing(float f11) {
            this.bearing = f11;
            return this;
        }

        public StreetViewPanoramaCamera build() {
            return new StreetViewPanoramaCamera(this.bearing, this.tilt, this.zoom);
        }

        public Builder orientation(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
            this.bearing = streetViewPanoramaOrientation.bearing;
            this.tilt = streetViewPanoramaOrientation.tilt;
            return this;
        }

        public Builder tilt(float f11) {
            this.tilt = f11;
            return this;
        }

        public Builder zoom(float f11) {
            this.zoom = f11;
            return this;
        }
    }

    public StreetViewPanoramaCamera(float f11, float f12, float f13) {
        this.zoom = f11;
        this.tilt = f12;
        this.bearing = f13;
        this.f49558a = new StreetViewPanoramaOrientation(f12, f13);
    }

    public StreetViewPanoramaCamera(Parcel parcel) {
        ParcelReader parcelReader = new ParcelReader(parcel);
        float readFloat = parcelReader.readFloat(2, 0.0f);
        this.bearing = readFloat;
        float readFloat2 = parcelReader.readFloat(3, 0.0f);
        this.tilt = readFloat2;
        this.zoom = parcelReader.readFloat(4, 0.0f);
        this.f49558a = new StreetViewPanoramaOrientation(readFloat2, readFloat);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(StreetViewPanoramaCamera streetViewPanoramaCamera) {
        return new Builder(streetViewPanoramaCamera);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaCamera)) {
            return false;
        }
        StreetViewPanoramaCamera streetViewPanoramaCamera = (StreetViewPanoramaCamera) obj;
        return Float.floatToIntBits(this.zoom) == Float.floatToIntBits(streetViewPanoramaCamera.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(streetViewPanoramaCamera.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(streetViewPanoramaCamera.bearing);
    }

    public StreetViewPanoramaOrientation getOrientation() {
        return this.f49558a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing)});
    }

    public String toString() {
        Float valueOf = Float.valueOf(this.zoom);
        Float valueOf2 = Float.valueOf(this.tilt);
        Float valueOf3 = Float.valueOf(this.bearing);
        StringBuilder sb2 = new StringBuilder(100);
        sb2.append("zoom/tilt/bearing: (");
        sb2.append(valueOf);
        sb2.append(",");
        sb2.append(valueOf2);
        sb2.append(",");
        sb2.append(valueOf3);
        sb2.append(")");
        return sb2.toString();
    }

    public void writeToParcel(Parcel parcel, int i11) {
        ParcelWrite parcelWrite = new ParcelWrite(parcel);
        int beginObjectHeader = parcelWrite.beginObjectHeader();
        parcelWrite.writeFloat(2, this.bearing);
        parcelWrite.writeFloat(3, this.tilt);
        parcelWrite.writeFloat(4, this.bearing);
        parcelWrite.finishObjectHeader(beginObjectHeader);
    }
}
