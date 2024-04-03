package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzt;
import java.util.concurrent.Callable;

final class zzcdw implements Callable<zzcdv> {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzcdy zzb;

    public zzcdw(zzcdy zzcdy, Context context) {
        this.zzb = zzcdy;
        this.zza = context;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzcdv zzcdv;
        zzcdx zzcdx = (zzcdx) this.zzb.zza.get(this.zza);
        if (zzcdx == null || zzcdx.zza + zzbmo.zza.zze().longValue() < zzt.zzA().currentTimeMillis()) {
            zzcdv = new zzcdu(this.zza).zza();
        } else {
            zzcdv = new zzcdu(this.zza, zzcdx.zzb).zza();
        }
        this.zzb.zza.put(this.zza, new zzcdx(this.zzb, zzcdv));
        return zzcdv;
    }
}
