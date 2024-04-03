package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

public final class zzejq extends zzceq implements zzdgb {
    @GuardedBy("this")
    private zzcer zza;
    @GuardedBy("this")
    private zzdga zzb;
    @GuardedBy("this")
    private zzdmo zzc;

    public final synchronized void zza(zzdga zzdga) {
        this.zzb = zzdga;
    }

    public final synchronized void zzc(zzcer zzcer) {
        this.zza = zzcer;
    }

    public final synchronized void zzd(zzdmo zzdmo) {
        this.zzc = zzdmo;
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzcer zzcer = this.zza;
        if (zzcer != null) {
            ((zzemj) zzcer).zzb.onAdClicked();
        }
    }

    public final synchronized void zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzcer zzcer = this.zza;
        if (zzcer != null) {
            zzcer.zzf(iObjectWrapper);
        }
    }

    public final synchronized void zzg(IObjectWrapper iObjectWrapper, int i11) throws RemoteException {
        zzdga zzdga = this.zzb;
        if (zzdga != null) {
            zzdga.zza(i11);
        }
    }

    public final synchronized void zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzcer zzcer = this.zza;
        if (zzcer != null) {
            ((zzemj) zzcer).zzc.zzb();
        }
    }

    public final synchronized void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzdga zzdga = this.zzb;
        if (zzdga != null) {
            zzdga.zzd();
        }
    }

    public final synchronized void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzcer zzcer = this.zza;
        if (zzcer != null) {
            ((zzemj) zzcer).zza.zzb();
        }
    }

    public final synchronized void zzk(IObjectWrapper iObjectWrapper, int i11) throws RemoteException {
        String str;
        zzdmo zzdmo = this.zzc;
        if (zzdmo != null) {
            String valueOf = String.valueOf(((zzemi) zzdmo).zzc.zza);
            if (valueOf.length() != 0) {
                str = "Fail to initialize adapter ".concat(valueOf);
            } else {
                str = new String("Fail to initialize adapter ");
            }
            zzciz.zzj(str);
        }
    }

    public final synchronized void zzl(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzdmo zzdmo = this.zzc;
        if (zzdmo != null) {
            ((zzemi) zzdmo).zzd.zzb.execute(new zzemh((zzemi) zzdmo, ((zzemi) zzdmo).zza, ((zzemi) zzdmo).zzb, ((zzemi) zzdmo).zzc));
        }
    }

    public final synchronized void zzm(IObjectWrapper iObjectWrapper, zzces zzces) throws RemoteException {
        zzcer zzcer = this.zza;
        if (zzcer != null) {
            ((zzemj) zzcer).zzd.zza(zzces);
        }
    }

    public final synchronized void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzcer zzcer = this.zza;
        if (zzcer != null) {
            ((zzemj) zzcer).zzc.zze();
        }
    }

    public final synchronized void zzo(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzcer zzcer = this.zza;
        if (zzcer != null) {
            ((zzemj) zzcer).zzd.zzc();
        }
    }
}
