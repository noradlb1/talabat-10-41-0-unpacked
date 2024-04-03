package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzev implements Runnable {
    public final /* synthetic */ zzfb zza;
    public final /* synthetic */ zztl zzb;

    public /* synthetic */ zzev(zzfb zzfb, zztl zztl, byte[] bArr) {
        this.zza = zzfb;
        this.zzb = zztl;
    }

    public final void run() {
        zzfb zzfb = this.zza;
        zztl zztl = this.zzb;
        zztl.zza.zzk(zzfb.zza());
    }
}
