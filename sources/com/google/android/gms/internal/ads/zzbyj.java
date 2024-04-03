package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzbyj extends zzbxm {
    private final Adapter zza;
    private final zzcer zzb;

    public zzbyj(Adapter adapter, zzcer zzcer) {
        this.zza = adapter;
        this.zzb = zzcer;
    }

    public final void zze() throws RemoteException {
        zzcer zzcer = this.zzb;
        if (zzcer != null) {
            zzcer.zze(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzf() throws RemoteException {
        zzcer zzcer = this.zzb;
        if (zzcer != null) {
            zzcer.zzf(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzg(int i11) throws RemoteException {
        zzcer zzcer = this.zzb;
        if (zzcer != null) {
            zzcer.zzg(ObjectWrapper.wrap(this.zza), i11);
        }
    }

    public final void zzh(zzbew zzbew) throws RemoteException {
    }

    public final void zzi(int i11, String str) throws RemoteException {
    }

    public final void zzj(int i11) throws RemoteException {
    }

    public final void zzk(zzbew zzbew) {
    }

    public final void zzl(String str) {
    }

    public final void zzm() throws RemoteException {
    }

    public final void zzn() throws RemoteException {
    }

    public final void zzo() throws RemoteException {
        zzcer zzcer = this.zzb;
        if (zzcer != null) {
            zzcer.zzi(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzp() throws RemoteException {
        zzcer zzcer = this.zzb;
        if (zzcer != null) {
            zzcer.zzj(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzq(String str, String str2) throws RemoteException {
    }

    public final void zzr(zzbpc zzbpc, String str) throws RemoteException {
    }

    public final void zzs(zzces zzces) throws RemoteException {
    }

    public final void zzt(zzcew zzcew) throws RemoteException {
        zzcer zzcer = this.zzb;
        if (zzcer != null) {
            zzcer.zzm(ObjectWrapper.wrap(this.zza), new zzces(zzcew.zzf(), zzcew.zze()));
        }
    }

    public final void zzu() throws RemoteException {
        zzcer zzcer = this.zzb;
        if (zzcer != null) {
            zzcer.zzn(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzv() throws RemoteException {
    }

    public final void zzw() throws RemoteException {
    }

    public final void zzx() throws RemoteException {
    }

    public final void zzy() throws RemoteException {
        zzcer zzcer = this.zzb;
        if (zzcer != null) {
            zzcer.zzo(ObjectWrapper.wrap(this.zza));
        }
    }
}
