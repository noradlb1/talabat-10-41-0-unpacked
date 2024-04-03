package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;

public final class zzeta implements zzevn<zzetb> {
    private final zzfxb zza;
    private final zzebt zzb;

    public zzeta(zzfxb zzfxb, zzebt zzebt) {
        this.zza = zzfxb;
        this.zzb = zzebt;
    }

    public final /* synthetic */ zzetb zza() throws Exception {
        return new zzetb(this.zzb.zzb(), this.zzb.zzn(), zzt.zzs().zzl());
    }

    public final zzfxa<zzetb> zzb() {
        return this.zza.zzb(new zzesz(this));
    }
}
