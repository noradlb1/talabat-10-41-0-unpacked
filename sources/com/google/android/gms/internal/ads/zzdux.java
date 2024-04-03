package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

final class zzdux<T> implements zzbrt<Object> {
    final /* synthetic */ zzduy zza;
    private final WeakReference<T> zzb;
    private final String zzc;
    private final zzbrt<T> zzd;

    public /* synthetic */ zzdux(zzduy zzduy, WeakReference weakReference, String str, zzbrt zzbrt, zzduw zzduw) {
        this.zza = zzduy;
        this.zzb = weakReference;
        this.zzc = str;
        this.zzd = zzbrt;
    }

    public final void zza(Object obj, Map<String, String> map) {
        T t11 = this.zzb.get();
        if (t11 == null) {
            this.zza.zzk(this.zzc, this);
        } else {
            this.zzd.zza(t11, map);
        }
    }
}
