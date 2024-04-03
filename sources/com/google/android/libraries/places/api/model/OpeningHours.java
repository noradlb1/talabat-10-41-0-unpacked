package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import com.google.android.libraries.places.internal.zzfm;
import com.google.android.libraries.places.internal.zzge;
import com.google.auto.value.AutoValue;
import java.util.ArrayList;
import java.util.List;

@AutoValue
public abstract class OpeningHours implements Parcelable {

    @AutoValue.Builder
    public static abstract class Builder {
        @RecentlyNonNull
        public OpeningHours build() {
            OpeningHours zza = zza();
            for (String isEmpty : zza.getWeekdayText()) {
                zzfm.zzi(!TextUtils.isEmpty(isEmpty), "WeekdayText must not contain null or empty values.");
            }
            setPeriods(zzge.zzk(zza.getPeriods()));
            setWeekdayText(zzge.zzk(zza.getWeekdayText()));
            return zza();
        }

        @RecentlyNonNull
        public abstract List<Period> getPeriods();

        @RecentlyNonNull
        public abstract List<String> getWeekdayText();

        @RecentlyNonNull
        public abstract Builder setPeriods(@RecentlyNonNull List<Period> list);

        @RecentlyNonNull
        public abstract Builder setWeekdayText(@RecentlyNonNull List<String> list);

        public abstract OpeningHours zza();
    }

    @RecentlyNonNull
    public static Builder builder() {
        zzk zzk = new zzk();
        zzk.setPeriods(new ArrayList());
        zzk.setWeekdayText(new ArrayList());
        return zzk;
    }

    @RecentlyNonNull
    public abstract List<Period> getPeriods();

    @RecentlyNonNull
    public abstract List<String> getWeekdayText();
}
