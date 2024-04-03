package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public class zzelu extends zzemv {
    private final zzdmm zza;

    public zzelu(zzdep zzdep, zzdmb zzdmb, zzdfj zzdfj, zzdfy zzdfy, zzdgd zzdgd, zzdfe zzdfe, zzdjo zzdjo, zzdmt zzdmt, zzdgx zzdgx, zzdmm zzdmm, zzdjk zzdjk) {
        super(zzdep, zzdmb, zzdfj, zzdfy, zzdgd, zzdjo, zzdgx, zzdmt, zzdjk, zzdfe);
        this.zza = zzdmm;
    }

    public final void zzs(zzces zzces) {
        this.zza.zza(zzces);
    }

    public final void zzt(zzcew zzcew) throws RemoteException {
        this.zza.zza(new zzces(zzcew.zzf(), zzcew.zze()));
    }

    public final void zzu() throws RemoteException {
        this.zza.zzb();
    }

    public final void zzv() {
        this.zza.zzb();
    }

    public final void zzy() {
        this.zza.zzc();
    }
}
