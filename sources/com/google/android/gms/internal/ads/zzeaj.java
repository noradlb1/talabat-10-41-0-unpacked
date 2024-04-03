package com.google.android.gms.internal.ads;

import android.os.RemoteException;

final class zzeaj extends zzbgw {
    final /* synthetic */ zzead zza;
    final /* synthetic */ zzeak zzb;

    public zzeaj(zzeak zzeak, zzead zzead) {
        this.zzb = zzeak;
        this.zza = zzead;
    }

    public final void zzc() throws RemoteException {
        this.zza.zzb(this.zzb.zza);
    }

    public final void zzd() throws RemoteException {
        this.zza.zzc(this.zzb.zza);
    }

    public final void zze(int i11) throws RemoteException {
        this.zza.zzd(this.zzb.zza, i11);
    }

    public final void zzf(zzbew zzbew) throws RemoteException {
        this.zza.zzd(this.zzb.zza, zzbew.zza);
    }

    public final void zzg() {
    }

    public final void zzh() {
    }

    public final void zzi() throws RemoteException {
        this.zza.zze(this.zzb.zza);
    }

    public final void zzj() throws RemoteException {
        this.zza.zzg(this.zzb.zza);
    }
}
