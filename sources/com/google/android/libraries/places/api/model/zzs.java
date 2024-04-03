package com.google.android.libraries.places.api.model;

import androidx.annotation.FloatRange;

abstract class zzs extends PlaceLikelihood {
    private final Place zza;
    private final double zzb;

    public zzs(Place place, double d11) {
        if (place != null) {
            this.zza = place;
            this.zzb = d11;
            return;
        }
        throw new NullPointerException("Null place");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PlaceLikelihood) {
            PlaceLikelihood placeLikelihood = (PlaceLikelihood) obj;
            if (!this.zza.equals(placeLikelihood.getPlace()) || Double.doubleToLongBits(this.zzb) != Double.doubleToLongBits(placeLikelihood.getLikelihood())) {
                return false;
            }
            return true;
        }
        return false;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public final double getLikelihood() {
        return this.zzb;
    }

    public final Place getPlace() {
        return this.zza;
    }

    public final int hashCode() {
        return ((this.zza.hashCode() ^ 1000003) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.zzb) >>> 32) ^ Double.doubleToLongBits(this.zzb)));
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        double d11 = this.zzb;
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 60);
        sb2.append("PlaceLikelihood{place=");
        sb2.append(valueOf);
        sb2.append(", likelihood=");
        sb2.append(d11);
        sb2.append("}");
        return sb2.toString();
    }
}
