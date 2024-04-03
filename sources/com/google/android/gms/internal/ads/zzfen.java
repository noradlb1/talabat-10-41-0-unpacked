package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;

final class zzfen implements zzfwm<String> {
    final /* synthetic */ zzcop zza;
    final /* synthetic */ zzfjs zzb;
    final /* synthetic */ zzehh zzc;

    public zzfen(zzcop zzcop, zzfjs zzfjs, zzehh zzehh) {
        this.zza = zzcop;
        this.zzb = zzfjs;
        this.zzc = zzehh;
    }

    public final void zza(Throwable th2) {
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        String str = (String) obj;
        if (!this.zza.zzF().zzag) {
            this.zzb.zzb(str);
            return;
        }
        long currentTimeMillis = zzt.zzA().currentTimeMillis();
        String str2 = this.zza.zzR().zzb;
        zzt.zzp();
        int i11 = 2;
        if (!com.google.android.gms.ads.internal.util.zzt.zzJ(this.zza.getContext())) {
            if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzeJ)).booleanValue() || !this.zza.zzF().zzP) {
                i11 = 1;
            }
        }
        this.zzc.zzd(new zzehj(currentTimeMillis, str2, str, i11));
    }
}
