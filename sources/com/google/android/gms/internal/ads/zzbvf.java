package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzce;
import java.util.Map;

final class zzbvf implements zzbrt<zzbvu> {
    final /* synthetic */ zzbuo zza;
    final /* synthetic */ zzce zzb;
    final /* synthetic */ zzbvt zzc;

    public zzbvf(zzbvt zzbvt, zzalt zzalt, zzbuo zzbuo, zzce zzce) {
        this.zzc = zzbvt;
        this.zza = zzbuo;
        this.zzb = zzce;
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [com.google.android.gms.internal.ads.zzbrt, java.lang.Object] */
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzbvu zzbvu = (zzbvu) obj;
        synchronized (this.zzc.zza) {
            zzciz.zzi("JS Engine is requesting an update");
            if (this.zzc.zzh == 0) {
                zzciz.zzi("Starting reload.");
                this.zzc.zzh = 2;
                this.zzc.zzd((zzalt) null);
            }
            this.zza.zzr("/requestReload", this.zzb.zza());
        }
    }
}
