package com.google.android.libraries.places.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.Place;
import com.google.auto.value.AutoValue;
import java.util.List;

@AutoValue
public abstract class zzdz {
    public static zzdz zzg() {
        return zzr(3).zzf();
    }

    public static zzdz zzh(String str) {
        str.getClass();
        zzdy zzr = zzr(6);
        zzr.zzd(str);
        return zzr.zzf();
    }

    public static zzdz zzi(String str, Status status) {
        str.getClass();
        status.getClass();
        zzdy zzr = zzr(7);
        zzr.zzd(str);
        zzr.zze(status);
        return zzr.zzf();
    }

    public static zzdz zzj(List<AutocompletePrediction> list) {
        list.getClass();
        zzdy zzr = zzr(5);
        zzr.zzc(list);
        return zzr.zzf();
    }

    public static zzdz zzk() {
        return zzr(2).zzf();
    }

    public static zzdz zzl() {
        zzdy zzr = zzr(10);
        zzr.zze(new Status(16));
        return zzr.zzf();
    }

    public static zzdz zzm(AutocompletePrediction autocompletePrediction, Status status) {
        autocompletePrediction.getClass();
        status.getClass();
        zzdy zzr = zzr(9);
        zzr.zzb(autocompletePrediction);
        zzr.zze(status);
        return zzr.zzf();
    }

    public static zzdz zzn(Place place) {
        place.getClass();
        zzdy zzr = zzr(8);
        zzr.zza(place);
        return zzr.zzf();
    }

    public static zzdz zzo() {
        return zzr(1).zzf();
    }

    public static zzdz zzp() {
        return zzr(4).zzf();
    }

    public static zzdz zzq(Status status) {
        status.getClass();
        zzdy zzr = zzr(10);
        zzr.zze(status);
        return zzr.zzf();
    }

    private static zzdy zzr(int i11) {
        zzdr zzdr = new zzdr();
        zzdr.zzg(i11);
        return zzdr;
    }

    @Nullable
    public abstract Status zza();

    @Nullable
    public abstract AutocompletePrediction zzb();

    @Nullable
    public abstract Place zzc();

    @Nullable
    public abstract zzge<AutocompletePrediction> zzd();

    @Nullable
    public abstract String zze();

    public abstract int zzf();
}
