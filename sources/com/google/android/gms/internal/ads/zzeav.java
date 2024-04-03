package com.google.android.gms.internal.ads;

import java.util.List;

public final /* synthetic */ class zzeav implements Runnable {
    public final /* synthetic */ zzebb zza;
    public final /* synthetic */ zzfev zzb;
    public final /* synthetic */ zzbtr zzc;
    public final /* synthetic */ List zzd;
    public final /* synthetic */ String zze;

    public /* synthetic */ zzeav(zzebb zzebb, zzfev zzfev, zzbtr zzbtr, List list, String str) {
        this.zza = zzebb;
        this.zzb = zzfev;
        this.zzc = zzbtr;
        this.zzd = list;
        this.zze = str;
    }

    public final void run() {
        this.zza.zzm(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
