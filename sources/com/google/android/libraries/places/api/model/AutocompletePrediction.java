package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import android.text.SpannableString;
import android.text.style.CharacterStyle;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.internal.zzge;
import com.google.auto.value.AutoValue;
import java.util.ArrayList;
import java.util.List;

@AutoValue
public abstract class AutocompletePrediction implements Parcelable {

    @AutoValue.Builder
    public static abstract class Builder {
        @RecentlyNonNull
        public AutocompletePrediction build() {
            AutocompletePrediction zze = zze();
            setPlaceTypes(zzge.zzk(zze.getPlaceTypes()));
            List<zzbb> zzd = zze.zzd();
            if (zzd != null) {
                zza(zzge.zzk(zzd));
            }
            List<zzbb> zze2 = zze.zze();
            if (zze2 != null) {
                zzc(zzge.zzk(zze2));
            }
            List<zzbb> zzf = zze.zzf();
            if (zzf != null) {
                zzd(zzge.zzk(zzf));
            }
            return zze();
        }

        @RecentlyNullable
        public abstract Integer getDistanceMeters();

        @RecentlyNonNull
        public abstract String getFullText();

        @RecentlyNonNull
        public abstract List<Place.Type> getPlaceTypes();

        @RecentlyNonNull
        public abstract String getPrimaryText();

        @RecentlyNonNull
        public abstract String getSecondaryText();

        @RecentlyNonNull
        public abstract Builder setDistanceMeters(@Nullable Integer num);

        @RecentlyNonNull
        public abstract Builder setFullText(@RecentlyNonNull String str);

        @RecentlyNonNull
        public abstract Builder setPlaceTypes(@RecentlyNonNull List<Place.Type> list);

        @RecentlyNonNull
        public abstract Builder setPrimaryText(@RecentlyNonNull String str);

        @RecentlyNonNull
        public abstract Builder setSecondaryText(@RecentlyNonNull String str);

        @RecentlyNonNull
        public abstract Builder zza(@Nullable List<zzbb> list);

        @RecentlyNonNull
        public abstract Builder zzc(@Nullable List<zzbb> list);

        @RecentlyNonNull
        public abstract Builder zzd(@Nullable List<zzbb> list);

        public abstract AutocompletePrediction zze();
    }

    @RecentlyNonNull
    public static Builder builder(@RecentlyNonNull String str) {
        zzd zzd = new zzd();
        zzd.zzb(str);
        zzd.setPlaceTypes(new ArrayList());
        zzd.setFullText("");
        zzd.setPrimaryText("");
        zzd.setSecondaryText("");
        return zzd;
    }

    private static final SpannableString zzg(String str, @Nullable List<zzbb> list, @Nullable CharacterStyle characterStyle) {
        SpannableString spannableString = new SpannableString(str);
        if (!(str.length() == 0 || characterStyle == null || list == null)) {
            for (zzbb next : list) {
                spannableString.setSpan(CharacterStyle.wrap(characterStyle), next.zzb(), next.zzb() + next.zza(), 0);
            }
        }
        return spannableString;
    }

    @RecentlyNullable
    public abstract Integer getDistanceMeters();

    @RecentlyNonNull
    public SpannableString getFullText(@Nullable CharacterStyle characterStyle) {
        return zzg(zza(), zzd(), characterStyle);
    }

    @RecentlyNonNull
    public abstract String getPlaceId();

    @RecentlyNonNull
    public abstract List<Place.Type> getPlaceTypes();

    @RecentlyNonNull
    public SpannableString getPrimaryText(@Nullable CharacterStyle characterStyle) {
        return zzg(zzb(), zze(), characterStyle);
    }

    @RecentlyNonNull
    public SpannableString getSecondaryText(@Nullable CharacterStyle characterStyle) {
        return zzg(zzc(), zzf(), characterStyle);
    }

    public abstract String zza();

    public abstract String zzb();

    public abstract String zzc();

    @Nullable
    public abstract List<zzbb> zzd();

    @Nullable
    public abstract List<zzbb> zze();

    @Nullable
    public abstract List<zzbb> zzf();
}
