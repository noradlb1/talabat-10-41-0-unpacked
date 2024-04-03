package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;

public final class zzejp extends zzbxm implements zzdgb {
    @GuardedBy("this")
    private zzbxn zza;
    @GuardedBy("this")
    private zzdga zzb;

    public final synchronized void zza(zzdga zzdga) {
        this.zzb = zzdga;
    }

    public final synchronized void zzc(zzbxn zzbxn) {
        this.zza = zzbxn;
    }

    public final synchronized void zze() throws RemoteException {
        zzbxn zzbxn = this.zza;
        if (zzbxn != null) {
            zzbxn.zze();
        }
    }

    public final synchronized void zzf() throws RemoteException {
        zzbxn zzbxn = this.zza;
        if (zzbxn != null) {
            zzbxn.zzf();
        }
    }

    public final synchronized void zzg(int i11) throws RemoteException {
        zzdga zzdga = this.zzb;
        if (zzdga != null) {
            zzdga.zza(i11);
        }
    }

    public final synchronized void zzh(zzbew zzbew) throws RemoteException {
        zzdga zzdga = this.zzb;
        if (zzdga != null) {
            zzdga.zzb(zzbew);
        }
    }

    public final synchronized void zzi(int i11, String str) throws RemoteException {
        zzdga zzdga = this.zzb;
        if (zzdga != null) {
            zzdga.zzc(i11, str);
        }
    }

    public final synchronized void zzj(int i11) throws RemoteException {
        zzbxn zzbxn = this.zza;
        if (zzbxn != null) {
            zzbxn.zzj(i11);
        }
    }

    public final synchronized void zzk(zzbew zzbew) throws RemoteException {
        zzbxn zzbxn = this.zza;
        if (zzbxn != null) {
            zzbxn.zzk(zzbew);
        }
    }

    public final synchronized void zzl(String str) throws RemoteException {
        zzbxn zzbxn = this.zza;
        if (zzbxn != null) {
            zzbxn.zzl(str);
        }
    }

    public final synchronized void zzm() throws RemoteException {
        zzbxn zzbxn = this.zza;
        if (zzbxn != null) {
            zzbxn.zzm();
        }
    }

    public final synchronized void zzn() throws RemoteException {
        zzbxn zzbxn = this.zza;
        if (zzbxn != null) {
            zzbxn.zzn();
        }
    }

    public final synchronized void zzo() throws RemoteException {
        zzbxn zzbxn = this.zza;
        if (zzbxn != null) {
            zzbxn.zzo();
        }
        zzdga zzdga = this.zzb;
        if (zzdga != null) {
            zzdga.zzd();
        }
    }

    public final synchronized void zzp() throws RemoteException {
        zzbxn zzbxn = this.zza;
        if (zzbxn != null) {
            zzbxn.zzp();
        }
    }

    public final synchronized void zzq(String str, String str2) throws RemoteException {
        zzbxn zzbxn = this.zza;
        if (zzbxn != null) {
            zzbxn.zzq(str, str2);
        }
    }

    public final synchronized void zzr(zzbpc zzbpc, String str) throws RemoteException {
    }

    public final synchronized void zzs(zzces zzces) throws RemoteException {
        zzbxn zzbxn = this.zza;
        if (zzbxn != null) {
            zzbxn.zzs(zzces);
        }
    }

    public final synchronized void zzt(zzcew zzcew) throws RemoteException {
        zzbxn zzbxn = this.zza;
        if (zzbxn != null) {
            zzbxn.zzt(zzcew);
        }
    }

    public final synchronized void zzu() throws RemoteException {
        zzbxn zzbxn = this.zza;
        if (zzbxn != null) {
            zzbxn.zzu();
        }
    }

    public final synchronized void zzv() throws RemoteException {
        zzbxn zzbxn = this.zza;
        if (zzbxn != null) {
            zzbxn.zzv();
        }
    }

    public final synchronized void zzw() throws RemoteException {
        zzbxn zzbxn = this.zza;
        if (zzbxn != null) {
            zzbxn.zzw();
        }
    }

    public final synchronized void zzx() throws RemoteException {
        zzbxn zzbxn = this.zza;
        if (zzbxn != null) {
            zzbxn.zzx();
        }
    }

    public final synchronized void zzy() throws RemoteException {
        zzbxn zzbxn = this.zza;
        if (zzbxn != null) {
            zzbxn.zzy();
        }
    }
}
