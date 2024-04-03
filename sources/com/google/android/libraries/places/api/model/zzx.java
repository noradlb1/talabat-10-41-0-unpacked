package com.google.android.libraries.places.api.model;

abstract class zzx extends TimeOfWeek {
    private final DayOfWeek zza;
    private final LocalTime zzb;

    public zzx(DayOfWeek dayOfWeek, LocalTime localTime) {
        if (dayOfWeek != null) {
            this.zza = dayOfWeek;
            if (localTime != null) {
                this.zzb = localTime;
                return;
            }
            throw new NullPointerException("Null time");
        }
        throw new NullPointerException("Null day");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TimeOfWeek) {
            TimeOfWeek timeOfWeek = (TimeOfWeek) obj;
            if (!this.zza.equals(timeOfWeek.getDay()) || !this.zzb.equals(timeOfWeek.getTime())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final DayOfWeek getDay() {
        return this.zza;
    }

    public final LocalTime getTime() {
        return this.zzb;
    }

    public final int hashCode() {
        return ((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 23 + valueOf2.length());
        sb2.append("TimeOfWeek{day=");
        sb2.append(valueOf);
        sb2.append(", time=");
        sb2.append(valueOf2);
        sb2.append("}");
        return sb2.toString();
    }
}
