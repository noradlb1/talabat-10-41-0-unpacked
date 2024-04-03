package com.google.android.libraries.places.api.model;

import androidx.annotation.Nullable;

abstract class zzn extends Period {
    private final TimeOfWeek zza;
    private final TimeOfWeek zzb;

    public zzn(@Nullable TimeOfWeek timeOfWeek, @Nullable TimeOfWeek timeOfWeek2) {
        this.zza = timeOfWeek;
        this.zzb = timeOfWeek2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Period) {
            Period period = (Period) obj;
            TimeOfWeek timeOfWeek = this.zza;
            if (timeOfWeek != null ? timeOfWeek.equals(period.getOpen()) : period.getOpen() == null) {
                TimeOfWeek timeOfWeek2 = this.zzb;
                if (timeOfWeek2 != null ? timeOfWeek2.equals(period.getClose()) : period.getClose() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Nullable
    public final TimeOfWeek getClose() {
        return this.zzb;
    }

    @Nullable
    public final TimeOfWeek getOpen() {
        return this.zza;
    }

    public final int hashCode() {
        int i11;
        TimeOfWeek timeOfWeek = this.zza;
        int i12 = 0;
        if (timeOfWeek == null) {
            i11 = 0;
        } else {
            i11 = timeOfWeek.hashCode();
        }
        int i13 = (i11 ^ 1000003) * 1000003;
        TimeOfWeek timeOfWeek2 = this.zzb;
        if (timeOfWeek2 != null) {
            i12 = timeOfWeek2.hashCode();
        }
        return i13 ^ i12;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 21 + valueOf2.length());
        sb2.append("Period{open=");
        sb2.append(valueOf);
        sb2.append(", close=");
        sb2.append(valueOf2);
        sb2.append("}");
        return sb2.toString();
    }
}
