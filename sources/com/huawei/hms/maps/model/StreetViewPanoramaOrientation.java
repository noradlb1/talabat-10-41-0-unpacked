package com.huawei.hms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;
import java.util.Arrays;

@Deprecated
public class StreetViewPanoramaOrientation implements Parcelable {
    public static final Parcelable.Creator<StreetViewPanoramaOrientation> CREATOR = new Parcelable.Creator<StreetViewPanoramaOrientation>() {
        public StreetViewPanoramaOrientation createFromParcel(Parcel parcel) {
            return new StreetViewPanoramaOrientation(parcel);
        }

        public StreetViewPanoramaOrientation[] newArray(int i11) {
            return new StreetViewPanoramaOrientation[i11];
        }
    };
    public final float bearing;
    public final float tilt;

    public static class Builder {
        public float bearing;
        public float tilt;

        public Builder() {
        }

        public Builder(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
            this.bearing = streetViewPanoramaOrientation.bearing;
            this.tilt = streetViewPanoramaOrientation.tilt;
        }

        public Builder bearing(float f11) {
            this.bearing = f11;
            return this;
        }

        public StreetViewPanoramaOrientation build() {
            return new StreetViewPanoramaOrientation(this.tilt, this.bearing);
        }

        public Builder tilt(float f11) {
            this.tilt = f11;
            return this;
        }
    }

    public StreetViewPanoramaOrientation(float f11, float f12) {
        this.tilt = f11;
        this.bearing = f12;
    }

    public StreetViewPanoramaOrientation(Parcel parcel) {
        ParcelReader parcelReader = new ParcelReader(parcel);
        this.bearing = parcelReader.readFloat(2, 0.0f);
        this.tilt = parcelReader.readFloat(3, 0.0f);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
        return new Builder(streetViewPanoramaOrientation);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaOrientation)) {
            return false;
        }
        StreetViewPanoramaOrientation streetViewPanoramaOrientation = (StreetViewPanoramaOrientation) obj;
        return Float.floatToIntBits(this.tilt) == Float.floatToIntBits(streetViewPanoramaOrientation.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(streetViewPanoramaOrientation.bearing);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.tilt), Float.valueOf(this.bearing)});
    }

    public String toString() {
        return null;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        ParcelWrite parcelWrite = new ParcelWrite(parcel);
        int beginObjectHeader = parcelWrite.beginObjectHeader();
        parcelWrite.writeFloat(2, this.bearing);
        parcelWrite.writeFloat(3, this.tilt);
        parcelWrite.finishObjectHeader(beginObjectHeader);
    }
}
