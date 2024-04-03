package com.google.android.gms.internal.ads;

import java.util.HashMap;

final class zzcnb implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ int zzd;
    final /* synthetic */ long zze;
    final /* synthetic */ long zzf;
    final /* synthetic */ boolean zzg;
    final /* synthetic */ int zzh;
    final /* synthetic */ int zzi;
    final /* synthetic */ zzcnf zzj;

    public zzcnb(zzcnf zzcnf, String str, String str2, int i11, int i12, long j11, long j12, boolean z11, int i13, int i14) {
        this.zzj = zzcnf;
        this.zza = str;
        this.zzb = str2;
        this.zzc = i11;
        this.zzd = i12;
        this.zze = j11;
        this.zzf = j12;
        this.zzg = z11;
        this.zzh = i13;
        this.zzi = i14;
    }

    public final void run() {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.zza);
        hashMap.put("cachedSrc", this.zzb);
        hashMap.put("bytesLoaded", Integer.toString(this.zzc));
        hashMap.put("totalBytes", Integer.toString(this.zzd));
        hashMap.put("bufferedDuration", Long.toString(this.zze));
        hashMap.put("totalDuration", Long.toString(this.zzf));
        if (true != this.zzg) {
            str = "0";
        } else {
            str = "1";
        }
        hashMap.put("cacheReady", str);
        hashMap.put("playerCount", Integer.toString(this.zzh));
        hashMap.put("playerPreparedCount", Integer.toString(this.zzi));
        zzcnf.zza(this.zzj, "onPrecacheEvent", hashMap);
    }
}
