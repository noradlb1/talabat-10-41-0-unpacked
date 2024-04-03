package com.google.android.libraries.places.api.model;

import androidx.annotation.IntRange;

abstract class zzj extends LocalTime {
    private final int zza;
    private final int zzb;

    public zzj(int i11, int i12) {
        this.zza = i11;
        this.zzb = i12;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LocalTime) {
            LocalTime localTime = (LocalTime) obj;
            if (this.zza == localTime.getHours() && this.zzb == localTime.getMinutes()) {
                return true;
            }
            return false;
        }
        return false;
    }

    @IntRange(from = 0, to = 23)
    public final int getHours() {
        return this.zza;
    }

    @IntRange(from = 0, to = 59)
    public final int getMinutes() {
        return this.zzb;
    }

    public final int hashCode() {
        return ((this.zza ^ 1000003) * 1000003) ^ this.zzb;
    }

    public final String toString() {
        int i11 = this.zza;
        int i12 = this.zzb;
        StringBuilder sb2 = new StringBuilder(49);
        sb2.append("LocalTime{hours=");
        sb2.append(i11);
        sb2.append(", minutes=");
        sb2.append(i12);
        sb2.append("}");
        return sb2.toString();
    }
}
