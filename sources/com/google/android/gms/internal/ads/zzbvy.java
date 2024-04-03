package com.google.android.gms.internal.ads;

import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
public final class zzbvy {
    private final Object zza = new Object();
    private final Object zzb = new Object();
    @GuardedBy("lockClient")
    private zzbwh zzc;
    @GuardedBy("lockService")
    private zzbwh zzd;

    private static final Context zzc(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public final zzbwh zza(Context context, zzcjf zzcjf) {
        zzbwh zzbwh;
        synchronized (this.zza) {
            if (this.zzc == null) {
                this.zzc = new zzbwh(zzc(context), zzcjf, (String) zzbgq.zzc().zzb(zzblj.zza));
            }
            zzbwh = this.zzc;
        }
        return zzbwh;
    }

    public final zzbwh zzb(Context context, zzcjf zzcjf) {
        zzbwh zzbwh;
        synchronized (this.zzb) {
            if (this.zzd == null) {
                this.zzd = new zzbwh(zzc(context), zzcjf, zzbnf.zzb.zze());
            }
            zzbwh = this.zzd;
        }
        return zzbwh;
    }
}
