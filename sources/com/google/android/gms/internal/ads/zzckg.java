package com.google.android.gms.internal.ads;

final class zzckg implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzckm zzc;

    public zzckg(zzckm zzckm, String str, String str2) {
        this.zzc = zzckm;
        this.zza = str;
        this.zzb = str2;
    }

    public final void run() {
        if (this.zzc.zzs != null) {
            this.zzc.zzs.zzb(this.zza, this.zzb);
        }
    }
}
