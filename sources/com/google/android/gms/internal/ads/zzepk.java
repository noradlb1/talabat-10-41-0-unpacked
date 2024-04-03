package com.google.android.gms.internal.ads;

public final class zzepk {
    private final zzdqn zza;
    private final zzeox zzb;
    private final zzdeu zzc;

    public zzepk(zzdqn zzdqn, zzfio zzfio) {
        this.zza = zzdqn;
        zzeox zzeox = new zzeox(zzfio);
        this.zzb = zzeox;
        this.zzc = new zzepj(zzeox, zzdqn.zzg());
    }

    public final zzdeu zza() {
        return this.zzc;
    }

    public final zzdgf zzb() {
        return this.zzb;
    }

    public final zzdok zzc() {
        return new zzdok(this.zza, this.zzb.zzb());
    }

    public final zzeox zzd() {
        return this.zzb;
    }

    public final void zze(zzbgx zzbgx) {
        this.zzb.zzf(zzbgx);
    }
}
