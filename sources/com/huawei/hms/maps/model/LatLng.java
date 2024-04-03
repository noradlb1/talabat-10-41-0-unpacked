package com.huawei.hms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;
import com.huawei.hms.maps.utils.LogM;
import java.util.Objects;

public class LatLng implements Parcelable {
    public static final Parcelable.Creator<LatLng> CREATOR = new Parcelable.Creator<LatLng>() {
        /* renamed from: a */
        public LatLng createFromParcel(Parcel parcel) {
            return new LatLng(parcel);
        }

        /* renamed from: a */
        public LatLng[] newArray(int i11) {
            return new LatLng[i11];
        }
    };
    public double latitude;
    public double longitude;

    public LatLng(double d11, double d12) {
        if ((-180.0d >= d12 || d12 >= 180.0d) && Math.abs(d12 + 180.0d) >= 1.0E-6d) {
            this.longitude = ((((d12 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d;
            LogM.e("LatLng", "longitude is out of valid range, ,using modulo operation.");
        } else {
            this.longitude = d12;
        }
        this.latitude = Math.max(-90.0d, Math.min(90.0d, d11));
    }

    public LatLng(Parcel parcel) {
        ParcelReader parcelReader = new ParcelReader(parcel);
        this.latitude = parcelReader.readDouble(2, 0.0d);
        this.longitude = parcelReader.readDouble(3, 0.0d);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLng)) {
            return false;
        }
        LatLng latLng = (LatLng) obj;
        return Double.compare(latLng.latitude, this.latitude) == 0 && Double.compare(latLng.longitude, this.longitude) == 0;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Double.valueOf(this.latitude), Double.valueOf(this.longitude)});
    }

    public final String toString() {
        return "latitude: " + this.latitude + " longitude: " + this.longitude;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        ParcelWrite parcelWrite = new ParcelWrite(parcel);
        int beginObjectHeader = parcelWrite.beginObjectHeader();
        parcelWrite.writeDouble(2, this.latitude);
        parcelWrite.writeDouble(3, this.longitude);
        parcelWrite.finishObjectHeader(beginObjectHeader);
    }
}
