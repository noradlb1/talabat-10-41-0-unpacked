package com.huawei.hms.maps.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.facebook.internal.security.CertificateUtil;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;
import com.huawei.hms.common.util.Objects;
import com.huawei.hms.maps.HuaweiMapOptions;

public class CameraPosition implements Parcelable {
    public static final float BEARING_360 = 360.0f;
    public static final Parcelable.Creator<CameraPosition> CREATOR = new Parcelable.Creator<CameraPosition>() {
        public CameraPosition createFromParcel(Parcel parcel) {
            return new CameraPosition(parcel);
        }

        public CameraPosition[] newArray(int i11) {
            return new CameraPosition[i11];
        }
    };
    public static final int TILT_90 = 90;
    public final float bearing;
    public final LatLng target;
    public final float tilt;
    public final float zoom;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private LatLng f49421a;

        /* renamed from: b  reason: collision with root package name */
        private float f49422b;

        /* renamed from: c  reason: collision with root package name */
        private float f49423c;

        /* renamed from: d  reason: collision with root package name */
        private float f49424d;

        public Builder() {
        }

        public Builder(CameraPosition cameraPosition) {
            this.f49421a = cameraPosition.target;
            this.f49422b = cameraPosition.zoom;
            this.f49423c = cameraPosition.tilt;
            this.f49424d = cameraPosition.bearing;
        }

        public Builder bearing(float f11) {
            this.f49424d = f11;
            return this;
        }

        public CameraPosition build() {
            return new CameraPosition(this.f49421a, this.f49422b, this.f49423c, this.f49424d);
        }

        public Builder target(LatLng latLng) {
            this.f49421a = latLng;
            return this;
        }

        public Builder tilt(float f11) {
            this.f49423c = f11;
            return this;
        }

        public Builder zoom(float f11) {
            this.f49422b = f11;
            return this;
        }
    }

    public CameraPosition(Parcel parcel) {
        ParcelReader parcelReader = new ParcelReader(parcel);
        this.target = (LatLng) parcelReader.readParcelable(2, LatLng.CREATOR, null);
        this.zoom = parcelReader.readFloat(3, 0.0f);
        this.tilt = parcelReader.readFloat(4, 0.0f);
        this.bearing = parcelReader.readFloat(5, 0.0f);
    }

    public CameraPosition(LatLng latLng, float f11, float f12, float f13) {
        if (latLng != null) {
            this.target = latLng;
            this.zoom = f11;
            if (f12 < 0.0f || f12 > 90.0f) {
                throw new IllegalArgumentException("Tilt needs to be between 0 and 90 inclusive");
            }
            this.tilt = f12 + 0.0f;
            this.bearing = (((double) f13) <= 0.0d ? (f13 % 360.0f) + 360.0f : f13) % 360.0f;
            return;
        }
        throw new NullPointerException("camera target is null");
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(CameraPosition cameraPosition) {
        return new Builder(cameraPosition);
    }

    public static CameraPosition createFromAttributes(Context context, AttributeSet attributeSet) {
        return HuaweiMapOptions.buildCameraPosition(context, attributeSet);
    }

    public static CameraPosition fromLatLngZoom(LatLng latLng, float f11) {
        return new CameraPosition(latLng, f11, 0.0f, 0.0f);
    }

    public int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return this.target.equals(cameraPosition.target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing);
    }

    public final int hashCode() {
        return Objects.hashCode(this.target, Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing));
    }

    public final String toString() {
        return getClass().getSimpleName() + CertificateUtil.DELIMITER + "{bearing=" + this.bearing + ",zoom=" + this.zoom + ",tilt=" + this.tilt + ",target=" + this.target + "}";
    }

    public void writeToParcel(Parcel parcel, int i11) {
        ParcelWrite parcelWrite = new ParcelWrite(parcel);
        int beginObjectHeader = parcelWrite.beginObjectHeader();
        parcelWrite.writeParcelable(2, this.target, i11, false);
        parcelWrite.writeFloat(3, this.zoom);
        parcelWrite.writeFloat(4, this.tilt);
        parcelWrite.writeFloat(5, this.bearing);
        parcelWrite.finishObjectHeader(beginObjectHeader);
    }
}
