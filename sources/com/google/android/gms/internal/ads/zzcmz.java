package com.google.android.gms.internal.ads;

import java.util.HashMap;

final class zzcmz implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ int zzd;
    final /* synthetic */ zzcnf zze;

    public zzcmz(zzcnf zzcnf, String str, String str2, int i11, int i12, boolean z11) {
        this.zze = zzcnf;
        this.zza = str;
        this.zzb = str2;
        this.zzc = i11;
        this.zzd = i12;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.zza);
        hashMap.put("cachedSrc", this.zzb);
        hashMap.put("bytesLoaded", Integer.toString(this.zzc));
        hashMap.put("totalBytes", Integer.toString(this.zzd));
        hashMap.put("cacheReady", "0");
        zzcnf.zza(this.zze, "onPrecacheEvent", hashMap);
    }
}
