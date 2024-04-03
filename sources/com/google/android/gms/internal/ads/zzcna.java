package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import java.util.HashMap;

final class zzcna implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ long zze;
    final /* synthetic */ long zzf;
    final /* synthetic */ long zzg;
    final /* synthetic */ boolean zzh;
    final /* synthetic */ int zzi;
    final /* synthetic */ int zzj;
    final /* synthetic */ zzcnf zzk;

    public zzcna(zzcnf zzcnf, String str, String str2, long j11, long j12, long j13, long j14, long j15, boolean z11, int i11, int i12) {
        this.zzk = zzcnf;
        this.zza = str;
        this.zzb = str2;
        this.zzc = j11;
        this.zzd = j12;
        this.zze = j13;
        this.zzf = j14;
        this.zzg = j15;
        this.zzh = z11;
        this.zzi = i11;
        this.zzj = i12;
    }

    public final void run() {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.zza);
        hashMap.put("cachedSrc", this.zzb);
        hashMap.put("bufferedDuration", Long.toString(this.zzc));
        hashMap.put("totalDuration", Long.toString(this.zzd));
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzbr)).booleanValue()) {
            hashMap.put("qoeLoadedBytes", Long.toString(this.zze));
            hashMap.put("qoeCachedBytes", Long.toString(this.zzf));
            hashMap.put("totalBytes", Long.toString(this.zzg));
            hashMap.put("reportTime", Long.toString(zzt.zzA().currentTimeMillis()));
        }
        if (true != this.zzh) {
            str = "0";
        } else {
            str = "1";
        }
        hashMap.put("cacheReady", str);
        hashMap.put("playerCount", Integer.toString(this.zzi));
        hashMap.put("playerPreparedCount", Integer.toString(this.zzj));
        zzcnf.zza(this.zzk, "onPrecacheEvent", hashMap);
    }
}
