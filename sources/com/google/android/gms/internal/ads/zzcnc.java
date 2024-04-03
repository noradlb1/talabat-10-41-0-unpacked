package com.google.android.gms.internal.ads;

import java.util.HashMap;

final class zzcnc implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ zzcnf zzd;

    public zzcnc(zzcnf zzcnf, String str, String str2, int i11) {
        this.zzd = zzcnf;
        this.zza = str;
        this.zzb = str2;
        this.zzc = i11;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheComplete");
        hashMap.put("src", this.zza);
        hashMap.put("cachedSrc", this.zzb);
        hashMap.put("totalBytes", Integer.toString(this.zzc));
        zzcnf.zza(this.zzd, "onPrecacheEvent", hashMap);
    }
}
