package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.huawei.hms.flutter.map.constants.Param;

@SafeParcelable.Class(creator = "StreetViewPanoramaCameraCreator")
@SafeParcelable.Reserved({1})
public class StreetViewPanoramaCamera extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<StreetViewPanoramaCamera> CREATOR = new zzu();
    @SafeParcelable.Field(id = 4)
    public final float bearing;
    @SafeParcelable.Field(id = 3)
    public final float tilt;
    @SafeParcelable.Field(id = 2)
    public final float zoom;
    private final StreetViewPanoramaOrientation zza;

    public static final class Builder {
        public float bearing;
        public float tilt;
        public float zoom;

        public Builder() {
        }

        public Builder(@NonNull StreetViewPanoramaCamera streetViewPanoramaCamera) {
            Preconditions.checkNotNull(streetViewPanoramaCamera, "StreetViewPanoramaCamera must not be null.");
            this.zoom = streetViewPanoramaCamera.zoom;
            this.bearing = streetViewPanoramaCamera.bearing;
            this.tilt = streetViewPanoramaCamera.tilt;
        }

        @NonNull
        public Builder bearing(float f11) {
            this.bearing = f11;
            return this;
        }

        @NonNull
        public StreetViewPanoramaCamera build() {
            return new StreetViewPanoramaCamera(this.zoom, this.tilt, this.bearing);
        }

        @NonNull
        public Builder orientation(@NonNull StreetViewPanoramaOrientation streetViewPanoramaOrientation) {
            Preconditions.checkNotNull(streetViewPanoramaOrientation, "orientation must not be null.");
            this.tilt = streetViewPanoramaOrientation.tilt;
            this.bearing = streetViewPanoramaOrientation.bearing;
            return this;
        }

        @NonNull
        public Builder tilt(float f11) {
            this.tilt = f11;
            return this;
        }

        @NonNull
        public Builder zoom(float f11) {
            this.zoom = f11;
            return this;
        }
    }

    @SafeParcelable.Constructor
    public StreetViewPanoramaCamera(@SafeParcelable.Param(id = 2) float f11, @SafeParcelable.Param(id = 3) float f12, @SafeParcelable.Param(id = 4) float f13) {
        float f14;
        boolean z11 = false;
        if (f12 >= -90.0f && f12 <= 90.0f) {
            z11 = true;
        }
        Preconditions.checkArgument(z11, "Tilt needs to be between -90 and 90 inclusive: " + f12);
        this.zoom = ((double) f11) <= 0.0d ? 0.0f : f11;
        this.tilt = 0.0f + f12;
        if (((double) f13) <= 0.0d) {
            f14 = (f13 % 360.0f) + 360.0f;
        } else {
            f14 = f13;
        }
        this.bearing = f14 % 360.0f;
        StreetViewPanoramaOrientation.Builder builder = new StreetViewPanoramaOrientation.Builder();
        builder.tilt(f12);
        builder.bearing(f13);
        this.zza = builder.build();
    }

    @NonNull
    public static Builder builder() {
        return new Builder();
    }

    @NonNull
    public static Builder builder(@NonNull StreetViewPanoramaCamera streetViewPanoramaCamera) {
        return new Builder(streetViewPanoramaCamera);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaCamera)) {
            return false;
        }
        StreetViewPanoramaCamera streetViewPanoramaCamera = (StreetViewPanoramaCamera) obj;
        if (Float.floatToIntBits(this.zoom) == Float.floatToIntBits(streetViewPanoramaCamera.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(streetViewPanoramaCamera.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(streetViewPanoramaCamera.bearing)) {
            return true;
        }
        return false;
    }

    @NonNull
    public StreetViewPanoramaOrientation getOrientation() {
        return this.zza;
    }

    public int hashCode() {
        return Objects.hashCode(Float.valueOf(this.zoom), Float.valueOf(this.tilt), Float.valueOf(this.bearing));
    }

    @NonNull
    public String toString() {
        return Objects.toStringHelper(this).add(Param.ZOOM, Float.valueOf(this.zoom)).add(Param.TILT, Float.valueOf(this.tilt)).add(Param.BEARING, Float.valueOf(this.bearing)).toString();
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        float f11 = this.zoom;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeFloat(parcel, 2, f11);
        SafeParcelWriter.writeFloat(parcel, 3, this.tilt);
        SafeParcelWriter.writeFloat(parcel, 4, this.bearing);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
