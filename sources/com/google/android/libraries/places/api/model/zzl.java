package com.google.android.libraries.places.api.model;

import java.util.List;

abstract class zzl extends OpeningHours {
    private final List<Period> zza;
    private final List<String> zzb;

    public zzl(List<Period> list, List<String> list2) {
        if (list != null) {
            this.zza = list;
            if (list2 != null) {
                this.zzb = list2;
                return;
            }
            throw new NullPointerException("Null weekdayText");
        }
        throw new NullPointerException("Null periods");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof OpeningHours) {
            OpeningHours openingHours = (OpeningHours) obj;
            if (!this.zza.equals(openingHours.getPeriods()) || !this.zzb.equals(openingHours.getWeekdayText())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final List<Period> getPeriods() {
        return this.zza;
    }

    public final List<String> getWeekdayText() {
        return this.zzb;
    }

    public final int hashCode() {
        return ((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 36 + valueOf2.length());
        sb2.append("OpeningHours{periods=");
        sb2.append(valueOf);
        sb2.append(", weekdayText=");
        sb2.append(valueOf2);
        sb2.append("}");
        return sb2.toString();
    }
}
