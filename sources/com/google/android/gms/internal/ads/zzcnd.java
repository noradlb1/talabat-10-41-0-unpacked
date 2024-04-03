package com.google.android.gms.internal.ads;

import java.util.HashMap;

final class zzcnd implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzcnf zzd;

    public zzcnd(zzcnf zzcnf, String str, String str2, long j11) {
        this.zzd = zzcnf;
        this.zza = str;
        this.zzb = str2;
        this.zzc = j11;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheComplete");
        hashMap.put("src", this.zza);
        hashMap.put("cachedSrc", this.zzb);
        hashMap.put("totalDuration", Long.toString(this.zzc));
        zzcnf.zza(this.zzd, "onPrecacheEvent", hashMap);
    }
}
