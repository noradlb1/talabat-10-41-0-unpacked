package com.google.android.gms.measurement.internal;

import android.os.Bundle;

final class zziu implements Runnable {
    final /* synthetic */ zzir zza;
    final /* synthetic */ zzir zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zziz zze;

    public zziu(zziz zziz, zzir zzir, zzir zzir2, long j11, boolean z11) {
        this.zze = zziz;
        this.zza = zzir;
        this.zzb = zzir2;
        this.zzc = j11;
        this.zzd = z11;
    }

    public final void run() {
        this.zze.zzA(this.zza, this.zzb, this.zzc, this.zzd, (Bundle) null);
    }
}
