package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;

public final class zzeoc extends zzbhc {
    private final zzepi zza;

    public zzeoc(Context context, zzcqm zzcqm, zzfed zzfed, zzdqn zzdqn, zzbgx zzbgx) {
        zzepk zzepk = new zzepk(zzdqn, zzcqm.zzz());
        zzepk.zze(zzbgx);
        this.zza = new zzepi(new zzepu(zzcqm, context, zzepk, zzfed), zzfed.zzH());
    }

    public final synchronized String zze() {
        return this.zza.zza();
    }

    public final synchronized String zzf() {
        return this.zza.zzb();
    }

    public final void zzg(zzbfd zzbfd) throws RemoteException {
        this.zza.zzd(zzbfd, 1);
    }

    public final synchronized void zzh(zzbfd zzbfd, int i11) throws RemoteException {
        this.zza.zzd(zzbfd, i11);
    }

    public final synchronized boolean zzi() throws RemoteException {
        return this.zza.zze();
    }
}
