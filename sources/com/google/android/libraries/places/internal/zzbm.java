package com.google.android.libraries.places.internal;

import android.location.Location;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

final class zzbm extends zzbr<Object, FindCurrentPlaceRequest> {
    private final Location zza;
    private final zzge<zzs> zzb;

    public zzbm(FindCurrentPlaceRequest findCurrentPlaceRequest, Location location, zzge<zzs> zzge, Locale locale, String str, boolean z11, zzdl zzdl) {
        super(findCurrentPlaceRequest, locale, str, false, zzdl);
        this.zza = location;
        this.zzb = zzge;
    }

    public final String zze() {
        return "findplacefromuserlocation/json";
    }

    public final Map<String, String> zzf() {
        HashMap hashMap = new HashMap();
        zzbr.zzg(hashMap, "location", zzcj.zzc(this.zza), (Object) null);
        zzbr.zzg(hashMap, "wifiaccesspoints", zzcj.zzg(this.zzb, 4000), (Object) null);
        zzbr.zzg(hashMap, "precision", zzcj.zza(this.zza), (Object) null);
        zzbr.zzg(hashMap, "timestamp", Long.valueOf(this.zza.getTime()), (Object) null);
        zzbr.zzg(hashMap, "fields", zzck.zza(((FindCurrentPlaceRequest) zzb()).getPlaceFields()), (Object) null);
        return hashMap;
    }
}
