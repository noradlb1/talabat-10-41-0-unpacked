package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

final class zzbi extends zzbr<Object, FindAutocompletePredictionsRequest> {
    public zzbi(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest, Locale locale, String str, boolean z11, zzdl zzdl) {
        super(findAutocompletePredictionsRequest, locale, str, false, zzdl);
    }

    public final String zze() {
        return "autocomplete/json";
    }

    public final Map<String, String> zzf() {
        String str;
        FindAutocompletePredictionsRequest findAutocompletePredictionsRequest = (FindAutocompletePredictionsRequest) zzb();
        HashMap hashMap = new HashMap();
        String query = findAutocompletePredictionsRequest.getQuery();
        if (query == null) {
            str = null;
        } else {
            str = query.replaceFirst("^\\s+", "").replaceFirst("\\s+$", " ");
        }
        zzbr.zzg(hashMap, "input", str, (Object) null);
        zzbr.zzg(hashMap, "types", zzcl.zza(findAutocompletePredictionsRequest.getTypeFilter()), (Object) null);
        zzbr.zzg(hashMap, "sessiontoken", findAutocompletePredictionsRequest.getSessionToken(), (Object) null);
        zzbr.zzg(hashMap, "origin", zzcj.zzd(findAutocompletePredictionsRequest.getOrigin()), (Object) null);
        zzbr.zzg(hashMap, "locationbias", zzcj.zze(findAutocompletePredictionsRequest.getLocationBias()), (Object) null);
        zzbr.zzg(hashMap, "locationrestriction", zzcj.zzf(findAutocompletePredictionsRequest.getLocationRestriction()), (Object) null);
        zzbr.zzg(hashMap, "components", zzcj.zzb(findAutocompletePredictionsRequest.getCountries()), (Object) null);
        return hashMap;
    }
}
