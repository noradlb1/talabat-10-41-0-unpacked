package com.google.android.libraries.places.api.model;

import com.google.android.gms.maps.model.LatLng;

final class zzv extends zzbi {
    private LatLng zza;
    private LatLng zzb;

    public final zzbi zza(LatLng latLng) {
        if (latLng != null) {
            this.zzb = latLng;
            return this;
        }
        throw new NullPointerException("Null northeast");
    }

    public final zzbi zzb(LatLng latLng) {
        if (latLng != null) {
            this.zza = latLng;
            return this;
        }
        throw new NullPointerException("Null southwest");
    }

    public final RectangularBounds zzc() {
        LatLng latLng;
        LatLng latLng2 = this.zza;
        if (latLng2 != null && (latLng = this.zzb) != null) {
            return new zzax(latLng2, latLng);
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.zza == null) {
            sb2.append(" southwest");
        }
        if (this.zzb == null) {
            sb2.append(" northeast");
        }
        String valueOf = String.valueOf(sb2);
        StringBuilder sb3 = new StringBuilder(valueOf.length() + 28);
        sb3.append("Missing required properties:");
        sb3.append(valueOf);
        throw new IllegalStateException(sb3.toString());
    }
}
