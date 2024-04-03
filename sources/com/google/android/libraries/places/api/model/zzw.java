package com.google.android.libraries.places.api.model;

import com.google.android.gms.maps.model.LatLng;

abstract class zzw extends RectangularBounds {
    private final LatLng zza;
    private final LatLng zzb;

    public zzw(LatLng latLng, LatLng latLng2) {
        if (latLng != null) {
            this.zza = latLng;
            if (latLng2 != null) {
                this.zzb = latLng2;
                return;
            }
            throw new NullPointerException("Null northeast");
        }
        throw new NullPointerException("Null southwest");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RectangularBounds) {
            RectangularBounds rectangularBounds = (RectangularBounds) obj;
            if (!this.zza.equals(rectangularBounds.getSouthwest()) || !this.zzb.equals(rectangularBounds.getNortheast())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final LatLng getNortheast() {
        return this.zzb;
    }

    public final LatLng getSouthwest() {
        return this.zza;
    }

    public final int hashCode() {
        return ((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 41 + valueOf2.length());
        sb2.append("RectangularBounds{southwest=");
        sb2.append(valueOf);
        sb2.append(", northeast=");
        sb2.append(valueOf2);
        sb2.append("}");
        return sb2.toString();
    }
}
