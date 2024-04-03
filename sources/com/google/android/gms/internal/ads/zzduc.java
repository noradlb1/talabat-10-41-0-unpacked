package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

public final class zzduc extends zzboy {
    @Nullable
    private final String zza;
    private final zzdpx zzb;
    private final zzdqc zzc;

    public zzduc(@Nullable String str, zzdpx zzdpx, zzdqc zzdqc) {
        this.zza = str;
        this.zzb = zzdpx;
        this.zzc = zzdqc;
    }

    public final Bundle zzb() throws RemoteException {
        return this.zzc.zzd();
    }

    public final zzbiz zzc() throws RemoteException {
        return this.zzc.zzj();
    }

    public final zzboa zzd() throws RemoteException {
        return this.zzc.zzl();
    }

    public final zzboi zze() throws RemoteException {
        return this.zzc.zzo();
    }

    public final IObjectWrapper zzf() throws RemoteException {
        return this.zzc.zzt();
    }

    public final IObjectWrapper zzg() throws RemoteException {
        return ObjectWrapper.wrap(this.zzb);
    }

    public final String zzh() throws RemoteException {
        return this.zzc.zzv();
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

    public final List<?> zzm() throws RemoteException {
        return this.zzc.zzE();
    }

    public final void zzn() throws RemoteException {
        this.zzb.zzT();
    }

    public final void zzo(Bundle bundle) throws RemoteException {
        this.zzb.zzz(bundle);
    }

    public final void zzp(Bundle bundle) throws RemoteException {
        this.zzb.zzE(bundle);
    }

    public final boolean zzq(Bundle bundle) throws RemoteException {
        return this.zzb.zzQ(bundle);
    }
}
