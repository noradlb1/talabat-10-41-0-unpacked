package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;

@Deprecated
public final class zzip {
    /* access modifiers changed from: private */
    public final Context zza;
    /* access modifiers changed from: private */
    public final zzdz zzb;
    /* access modifiers changed from: private */
    public zzsv zzc;
    /* access modifiers changed from: private */
    public final zzqk zzd;
    /* access modifiers changed from: private */
    public zzhs zze;
    /* access modifiers changed from: private */
    public final zzte zzf;
    /* access modifiers changed from: private */
    public final zzlb zzg;
    /* access modifiers changed from: private */
    public final Looper zzh = zzfn.zzA();
    /* access modifiers changed from: private */
    public final zzg zzi = zzg.zza;
    /* access modifiers changed from: private */
    public final zzio zzj = zzio.zze;
    private boolean zzk;
    /* access modifiers changed from: private */
    public final zzcoa zzl;
    /* access modifiers changed from: private */
    public final zzgb zzm = new zzgb(0.97f, 1.03f, 1000, 1.0E-7f, zzk.zzc(20), zzk.zzc(500), 0.999f, (zzga) null);

    @Deprecated
    public zzip(Context context, zzcoa zzcoa, byte[] bArr) {
        Context context2 = context;
        zzwl zzwl = new zzwl();
        zzsp zzsp = new zzsp(context2);
        zzpn zzpn = new zzpn(context2, zzwl);
        zzgc zzgc = new zzgc();
        zztn zzg2 = zztn.zzg(context);
        zzdz zzdz = zzdz.zza;
        zzlb zzlb = new zzlb(zzdz);
        this.zza = context2;
        this.zzl = zzcoa;
        this.zzc = zzsp;
        this.zzd = zzpn;
        this.zze = zzgc;
        this.zzf = zzg2;
        this.zzg = zzlb;
        this.zzb = zzdz;
    }

    @Deprecated
    public final zzip zzg(zzhs zzhs) {
        zzdy.zzf(!this.zzk);
        this.zze = zzhs;
        return this;
    }

    @Deprecated
    public final zzip zzh(zzsv zzsv) {
        zzdy.zzf(!this.zzk);
        this.zzc = zzsv;
        return this;
    }

    @Deprecated
    public final zziu zzi() {
        zzdy.zzf(!this.zzk);
        this.zzk = true;
        return new zziu(this);
    }
}
