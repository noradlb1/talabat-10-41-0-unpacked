package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.Nullable;

public final class zzdqb extends zzbiy {
    private final Object zza = new Object();
    @Nullable
    private final zzbiz zzb;
    @Nullable
    private final zzbxw zzc;

    public zzdqb(@Nullable zzbiz zzbiz, @Nullable zzbxw zzbxw) {
        this.zzb = zzbiz;
        this.zzc = zzbxw;
    }

    public final float zze() throws RemoteException {
        throw new RemoteException();
    }

    public final float zzf() throws RemoteException {
        zzbxw zzbxw = this.zzc;
        if (zzbxw != null) {
            return zzbxw.zzg();
        }
        return 0.0f;
    }

    public final float zzg() throws RemoteException {
        zzbxw zzbxw = this.zzc;
        if (zzbxw != null) {
            return zzbxw.zzh();
        }
        return 0.0f;
    }

    public final int zzh() throws RemoteException {
        throw new RemoteException();
    }

    public final zzbjc zzi() throws RemoteException {
        synchronized (this.zza) {
            zzbiz zzbiz = this.zzb;
            if (zzbiz == null) {
                return null;
            }
            zzbjc zzi = zzbiz.zzi();
            return zzi;
        }
    }

    public final void zzj(boolean z11) throws RemoteException {
        throw new RemoteException();
    }

    public final void zzk() throws RemoteException {
        throw new RemoteException();
    }

    public final void zzl() throws RemoteException {
        throw new RemoteException();
    }

    public final void zzm(@Nullable zzbjc zzbjc) throws RemoteException {
        synchronized (this.zza) {
            zzbiz zzbiz = this.zzb;
            if (zzbiz != null) {
                zzbiz.zzm(zzbjc);
            }
        }
    }

    public final void zzn() throws RemoteException {
        throw new RemoteException();
    }

    public final boolean zzo() throws RemoteException {
        throw new RemoteException();
    }

    public final boolean zzp() throws RemoteException {
        throw new RemoteException();
    }

    public final boolean zzq() throws RemoteException {
        throw new RemoteException();
    }
}
