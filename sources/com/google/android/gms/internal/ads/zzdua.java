package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

public final class zzdua extends zzbow {
    @Nullable
    private final String zza;
    private final zzdpx zzb;
    private final zzdqc zzc;

    public zzdua(@Nullable String str, zzdpx zzdpx, zzdqc zzdqc) {
        this.zza = str;
        this.zzb = zzdpx;
        this.zzc = zzdqc;
    }

    public final double zzb() throws RemoteException {
        return this.zzc.zza();
    }

    public final Bundle zzc() throws RemoteException {
        return this.zzc.zzd();
    }

    public final zzbiz zzd() throws RemoteException {
        return this.zzc.zzj();
    }

    public final zzboa zze() throws RemoteException {
        return this.zzc.zzl();
    }

    public final zzboi zzf() throws RemoteException {
        return this.zzc.zzn();
    }

    public final IObjectWrapper zzg() throws RemoteException {
        return this.zzc.zzt();
    }

    public final IObjectWrapper zzh() throws RemoteException {
        return ObjectWrapper.wrap(this.zzb);
    }

    public final String zzi() throws RemoteException {
        return this.zzc.zzw();
    }

    public final String zzj() throws RemoteException {
        return this.zzc.zzx();
    }

    public final String zzk() throws RemoteException {
        return this.zzc.zzz();
    }

    public final String zzl() throws RemoteException {
        return this.zza;
    }

    public final String zzm() throws RemoteException {
        return this.zzc.zzB();
    }

    public final String zzn() throws RemoteException {
        return this.zzc.zzC();
    }

    public final List<?> zzo() throws RemoteException {
        return this.zzc.zzE();
    }

    public final void zzp() throws RemoteException {
        this.zzb.zzT();
    }

    public final void zzq(Bundle bundle) throws RemoteException {
        this.zzb.zzz(bundle);
    }

    public final void zzr(Bundle bundle) throws RemoteException {
        this.zzb.zzE(bundle);
    }

    public final boolean zzs(Bundle bundle) throws RemoteException {
        return this.zzb.zzQ(bundle);
    }
}
