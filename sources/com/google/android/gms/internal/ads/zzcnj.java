package com.google.android.gms.internal.ads;

public final class zzcnj extends zzcnf {
    public zzcnj(zzclh zzclh) {
        super(zzclh);
    }

    public final void zzb() {
    }

    public final boolean zzq(String str) {
        String zze = zzcis.zze(str);
        zzclh zzclh = this.zzc.get();
        if (!(zzclh == null || zze == null)) {
            zzclh.zzv(zze, this);
        }
        zzciz.zzj("VideoStreamNoopCache is doing nothing.");
        zzc(str, zze, "noop", "Noop cache is a noop.");
        return false;
    }
}
