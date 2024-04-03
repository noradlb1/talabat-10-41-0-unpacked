package com.google.android.gms.internal.ads;

final class zzezq implements zzepm<zzcyp> {
    final /* synthetic */ zzezr zza;

    public zzezq(zzezr zzezr) {
        this.zza = zzezr;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zza = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcyp zzcyp = (zzcyp) obj;
        synchronized (this.zza) {
            zzcyp zzcyp2 = this.zza.zza;
            if (zzcyp2 != null) {
                zzcyp2.zzT();
            }
            zzezr zzezr = this.zza;
            zzezr.zza = zzcyp;
            zzcyp.zzc(zzezr);
            zzezj zzh = this.zza.zzg;
            zzezr zzezr2 = this.zza;
            zzh.zzl(new zzcyq(zzcyp, zzezr2, zzezr2.zzg));
            zzcyp.zzU();
        }
    }
}
