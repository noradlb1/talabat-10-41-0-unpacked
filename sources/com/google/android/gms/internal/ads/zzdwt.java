package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public final class zzdwt {
    @GuardedBy("this")
    private final Map<String, zzdws> zza = new HashMap();

    @Nullable
    public final synchronized zzdws zza(String str) {
        return this.zza.get(str);
    }

    @Nullable
    public final zzdws zzb(List<String> list) {
        for (String zza2 : list) {
            zzdws zza3 = zza(zza2);
            if (zza3 != null) {
                return zza3;
            }
        }
        return null;
    }

    public final synchronized void zzc(String str, zzfev zzfev) {
        if (!this.zza.containsKey(str)) {
            try {
                this.zza.put(str, new zzdws(str, zzfev.zze(), zzfev.zzf()));
            } catch (zzfek unused) {
            }
        }
    }

    public final synchronized void zzd(String str, zzbzo zzbzo) {
        if (!this.zza.containsKey(str)) {
            try {
                this.zza.put(str, new zzdws(str, zzbzo.zzf(), zzbzo.zzg()));
            } catch (Throwable unused) {
            }
        }
    }
}
