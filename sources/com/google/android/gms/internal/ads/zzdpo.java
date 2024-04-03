package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzdpo extends zzboe {
    private final zzdqc zza;
    private IObjectWrapper zzb;

    public zzdpo(zzdqc zzdqc) {
        this.zza = zzdqc;
    }

    private static float zzb(IObjectWrapper iObjectWrapper) {
        Drawable drawable;
        if (iObjectWrapper == null || (drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapper)) == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) {
            return 0.0f;
        }
        return ((float) drawable.getIntrinsicWidth()) / ((float) drawable.getIntrinsicHeight());
    }

    public final float zze() throws RemoteException {
        float f11;
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzeH)).booleanValue()) {
            return 0.0f;
        }
        if (this.zza.zzb() != 0.0f) {
            return this.zza.zzb();
        }
        if (this.zza.zzj() != null) {
            try {
                return this.zza.zzj().zze();
            } catch (RemoteException e11) {
                zzciz.zzh("Remote exception getting video controller aspect ratio.", e11);
                return 0.0f;
            }
        } else {
            IObjectWrapper iObjectWrapper = this.zzb;
            if (iObjectWrapper != null) {
                return zzb(iObjectWrapper);
            }
            zzboi zzm = this.zza.zzm();
            if (zzm == null) {
                return 0.0f;
            }
            if (zzm.zzd() == -1 || zzm.zzc() == -1) {
                f11 = 0.0f;
            } else {
                f11 = ((float) zzm.zzd()) / ((float) zzm.zzc());
            }
            if (f11 == 0.0f) {
                return zzb(zzm.zzf());
            }
            return f11;
        }
    }

    public final float zzf() throws RemoteException {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzeI)).booleanValue() && this.zza.zzj() != null) {
            return this.zza.zzj().zzf();
        }
        return 0.0f;
    }

    public final float zzg() throws RemoteException {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzeI)).booleanValue() && this.zza.zzj() != null) {
            return this.zza.zzj().zzg();
        }
        return 0.0f;
    }

    public final zzbiz zzh() throws RemoteException {
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzeI)).booleanValue()) {
            return null;
        }
        return this.zza.zzj();
    }

    public final IObjectWrapper zzi() throws RemoteException {
        IObjectWrapper iObjectWrapper = this.zzb;
        if (iObjectWrapper != null) {
            return iObjectWrapper;
        }
        zzboi zzm = this.zza.zzm();
        if (zzm == null) {
            return null;
        }
        return zzm.zzf();
    }

    public final void zzj(IObjectWrapper iObjectWrapper) {
        this.zzb = iObjectWrapper;
    }

    public final boolean zzk() throws RemoteException {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzeI)).booleanValue() && this.zza.zzj() != null) {
            return true;
        }
        return false;
    }

    public final void zzl(zzbpq zzbpq) {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzeI)).booleanValue() && (this.zza.zzj() instanceof zzcpl)) {
            ((zzcpl) this.zza.zzj()).zzv(zzbpq);
        }
    }
}
