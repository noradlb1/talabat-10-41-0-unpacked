package com.google.android.libraries.places.api.model;

import com.google.android.libraries.places.api.model.OpeningHours;
import java.util.List;

final class zzk extends OpeningHours.Builder {
    private List<Period> zza;
    private List<String> zzb;

    public final List<Period> getPeriods() {
        List<Period> list = this.zza;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("Property \"periods\" has not been set");
    }

    public final List<String> getWeekdayText() {
        List<String> list = this.zzb;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("Property \"weekdayText\" has not been set");
    }

    public final OpeningHours.Builder setPeriods(List<Period> list) {
        if (list != null) {
            this.zza = list;
            return this;
        }
        throw new NullPointerException("Null periods");
    }

    public final OpeningHours.Builder setWeekdayText(List<String> list) {
        if (list != null) {
            this.zzb = list;
            return this;
        }
        throw new NullPointerException("Null weekdayText");
    }

    public final OpeningHours zza() {
        List<String> list;
        List<Period> list2 = this.zza;
        if (list2 != null && (list = this.zzb) != null) {
            return new zzal(list2, list);
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.zza == null) {
            sb2.append(" periods");
        }
        if (this.zzb == null) {
            sb2.append(" weekdayText");
        }
        String valueOf = String.valueOf(sb2);
        StringBuilder sb3 = new StringBuilder(valueOf.length() + 28);
        sb3.append("Missing required properties:");
        sb3.append(valueOf);
        throw new IllegalStateException(sb3.toString());
    }
}
