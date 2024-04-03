package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class zzduv implements Callable<zzduy> {
    /* access modifiers changed from: private */
    public final zza zza;
    /* access modifiers changed from: private */
    public final zzcpb zzb;
    /* access modifiers changed from: private */
    public final Context zzc;
    /* access modifiers changed from: private */
    public final zzdyz zzd;
    /* access modifiers changed from: private */
    public final zzfio zze;
    /* access modifiers changed from: private */
    public final zzehh zzf;
    /* access modifiers changed from: private */
    public final Executor zzg;
    /* access modifiers changed from: private */
    public final zzalt zzh;
    /* access modifiers changed from: private */
    public final zzcjf zzi;
    /* access modifiers changed from: private */
    public final zzfjs zzj;

    public zzduv(Context context, Executor executor, zzalt zzalt, zzcjf zzcjf, zza zza2, zzcpb zzcpb, zzehh zzehh, zzfjs zzfjs, zzdyz zzdyz, zzfio zzfio) {
        this.zzc = context;
        this.zzg = executor;
        this.zzh = zzalt;
        this.zzi = zzcjf;
        this.zza = zza2;
        this.zzb = zzcpb;
        this.zzf = zzehh;
        this.zzj = zzfjs;
        this.zzd = zzdyz;
        this.zze = zzfio;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzduy zzduy = new zzduy(this);
        zzduy.zzh();
        return zzduy;
    }
}
