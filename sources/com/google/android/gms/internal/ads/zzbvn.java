package com.google.android.gms.internal.ads;

public final class zzbvn extends zzcjy<zzbvu> {
    private final Object zza = new Object();
    /* access modifiers changed from: private */
    public final zzbvs zzb;
    private boolean zzc;

    public zzbvn(zzbvs zzbvs) {
        this.zzb = zzbvs;
    }

    public final void zzb() {
        synchronized (this.zza) {
            if (!this.zzc) {
                this.zzc = true;
                zzi(new zzbvk(this), new zzcju());
                zzi(new zzbvl(this), new zzbvm(this));
            }
        }
    }
}
