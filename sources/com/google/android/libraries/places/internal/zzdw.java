package com.google.android.libraries.places.internal;

import androidx.annotation.Nullable;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.google.auto.value.AutoValue;
import java.util.List;

@AutoValue.Builder
public abstract class zzdw {
    public abstract zzdw zza(List<String> list);

    public abstract zzdw zzb(@Nullable String str);

    public abstract zzdw zzc(@Nullable String str);

    public abstract zzdw zzd(@Nullable LocationBias locationBias);

    public abstract zzdw zze(@Nullable LocationRestriction locationRestriction);

    public abstract zzdw zzf(AutocompleteActivityMode autocompleteActivityMode);

    public abstract zzdw zzg(zzdv zzdv);

    public abstract zzdw zzh(List<Place.Field> list);

    public abstract zzdw zzi(int i11);

    public abstract zzdw zzj(int i11);

    public abstract zzdw zzk(@Nullable TypeFilter typeFilter);

    public abstract zzdx zzl();

    public final zzdw zzm(@Nullable String str) {
        return zza(str == null ? zzge.zzm() : zzge.zzn(str));
    }
}
