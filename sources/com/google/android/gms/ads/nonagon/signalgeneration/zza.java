package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import java.util.LinkedHashMap;
import java.util.Map;

final class zza extends LinkedHashMap<String, Pair<Long, String>> {
    final /* synthetic */ zzb zza;

    public zza(zzb zzb) {
        this.zza = zzb;
    }

    public final boolean removeEldestEntry(Map.Entry<String, Pair<Long, String>> entry) {
        return size() > this.zza.zza;
    }
}
