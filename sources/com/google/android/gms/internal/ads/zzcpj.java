package com.google.android.gms.internal.ads;

public final /* synthetic */ class zzcpj implements Runnable {
    public final /* synthetic */ zzcpl zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ int zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ boolean zze;

    public /* synthetic */ zzcpj(zzcpl zzcpl, int i11, int i12, boolean z11, boolean z12) {
        this.zza = zzcpl;
        this.zzb = i11;
        this.zzc = i12;
        this.zzd = z11;
        this.zze = z12;
    }

    public final void run() {
        this.zza.zzd(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
