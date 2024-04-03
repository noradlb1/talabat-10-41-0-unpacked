package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;

public final /* synthetic */ class zzevo implements Runnable {
    public final /* synthetic */ zzevn zza;
    public final /* synthetic */ long zzb;

    public /* synthetic */ zzevo(zzevn zzevn, long j11) {
        this.zza = zzevn;
        this.zzb = j11;
    }

    public final void run() {
        zzevn zzevn = this.zza;
        long j11 = this.zzb;
        String canonicalName = zzevn.getClass().getCanonicalName();
        long elapsedRealtime = zzt.zzA().elapsedRealtime();
        StringBuilder sb2 = new StringBuilder(String.valueOf(canonicalName).length() + 40);
        sb2.append("Signal runtime : ");
        sb2.append(canonicalName);
        sb2.append(" = ");
        sb2.append(elapsedRealtime - j11);
        zze.zza(sb2.toString());
    }
}
