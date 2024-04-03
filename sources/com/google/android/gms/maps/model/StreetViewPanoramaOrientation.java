package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.huawei.hms.flutter.map.constants.Param;

@SafeParcelable.Class(creator = "StreetViewPanoramaOrientationCreator")
@SafeParcelable.Reserved({1})
public class StreetViewPanoramaOrientation extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<StreetViewPanoramaOrientation> CREATOR = new zzx();
    @SafeParcelable.Field(id = 3)
    public final float bearing;
    @SafeParcelable.Field(id = 2)
    public final float tilt;

    public static final class Builder {
        public float bearing;
        public float tilt;

        public Builder() {
        }

        public Builder(@NonNull StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
            Preconditions.checkNotNull(streetViewPanoramaOrientation, "StreetViewPanoramaOrientation must not be null.");
            this.bearing = streetViewPanoramaOrientation.bearing;
            this.tilt = streetViewPanoramaOrientation.tilt;
        }

        @NonNull
        public Builder bearing(float f11) {
            this.bearing = f11;
            return this;
        }

        @NonNull
        public StreetViewPanoramaOrientation build() {
            return new StreetViewPanoramaOrientation(this.tilt, this.bearing);
        }

        @NonNull
        public Builder tilt(float f11) {
            this.tilt = f11;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public StreetViewPanoramaOrientation(@SafeParcelable.Param(id = 2) float f11, @SafeParcelable.Param(id = 3) float f12) {
        boolean z11 = false;
        if (f11 >= -90.0f && f11 <= 90.0f) {
            z11 = true;
        }
        Preconditions.checkArgument(z11, "Tilt needs to be between -90 and 90 inclusive: " + f11);
        this.tilt = f11 + 0.0f;
        this.bearing = (((double) f12) <= 0.0d ? (f12 % 360.0f) + 360.0f : f12) % 360.0f;
    }

    @NonNull
    public static Builder builder() {
        return new Builder();
    }

    @NonNull
    public static Builder builder(@NonNull StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
        return new Builder(streetViewPanoramaOrientation);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaOrientation)) {
            return false;
        }
        StreetViewPanoramaOrientation streetViewPanoramaOrientation = (StreetViewPanoramaOrientation) obj;
        if (Float.floatToIntBits(this.tilt) == Float.floatToIntBits(streetViewPanoramaOrientation.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(streetViewPanoramaOrientation.bearing)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(Float.valueOf(this.tilt), Float.valueOf(this.bearing));
    }

    @NonNull
    public String toString() {
        return Objects.toStringHelper(this).add(Param.TILT, Float.valueOf(this.tilt)).add(Param.BEARING, Float.valueOf(this.bearing)).toString();
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        float f11 = this.tilt;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeFloat(parcel, 2, f11);
        SafeParcelWriter.writeFloat(parcel, 3, this.bearing);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
