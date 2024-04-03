package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

final class zzbe extends zzbr<Object, FetchPlaceRequest> {
    public zzbe(FetchPlaceRequest fetchPlaceRequest, Locale locale, String str, boolean z11, zzdl zzdl) {
        super(fetchPlaceRequest, locale, str, false, zzdl);
    }

    public final String zze() {
        return "details/json";
    }

    public final Map<String, String> zzf() {
        FetchPlaceRequest fetchPlaceRequest = (FetchPlaceRequest) zzb();
        HashMap hashMap = new HashMap();
        zzbr.zzg(hashMap, "placeid", fetchPlaceRequest.getPlaceId(), (Object) null);
        zzbr.zzg(hashMap, "sessiontoken", fetchPlaceRequest.getSessionToken(), (Object) null);
        zzbr.zzg(hashMap, "fields", zzck.zza(fetchPlaceRequest.getPlaceFields()), (Object) null);
        return hashMap;
    }
}
