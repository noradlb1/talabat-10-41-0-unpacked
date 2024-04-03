package com.google.android.gms.internal.ads;

final class zzcki implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzckm zzc;

    public zzcki(zzckm zzckm, int i11, int i12) {
        this.zzc = zzckm;
        this.zza = i11;
        this.zzb = i12;
    }

    public final void run() {
        if (this.zzc.zzs != null) {
            this.zzc.zzs.zzj(this.zza, this.zzb);
        }
    }
}
