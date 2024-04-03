package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Map;

public final class zzdax<AdT> implements zzday<AdT> {
    private final Map<String, zzeht<AdT>> zza;

    public zzdax(Map<String, zzeht<AdT>> map) {
        this.zza = map;
    }

    @Nullable
    public final zzeht<AdT> zza(int i11, String str) {
        return this.zza.get(str);
    }
}
