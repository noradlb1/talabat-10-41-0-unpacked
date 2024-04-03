package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;

public final class zzduh extends zzbqe {
    @Nullable
    private final String zza;
    private final zzdpx zzb;
    private final zzdqc zzc;

    public zzduh(@Nullable String str, zzdpx zzdpx, zzdqc zzdqc) {
        this.zza = str;
        this.zzb = zzdpx;
        this.zzc = zzdqc;
    }

    public final void zzA() {
        this.zzb.zzA();
    }

    public final void zzB(Bundle bundle) throws RemoteException {
        this.zzb.zzE(bundle);
    }

    public final void zzC() {
        this.zzb.zzG();
    }

    public final void zzD(zzbif zzbif) throws RemoteException {
        this.zzb.zzH(zzbif);
    }

    public final void zzE(zzbit zzbit) throws RemoteException {
        this.zzb.zzI(zzbit);
    }

    public final void zzF(zzbqc zzbqc) throws RemoteException {
        this.zzb.zzJ(zzbqc);
    }

    public final boolean zzG() {
        return this.zzb.zzN();
    }

    public final boolean zzH() throws RemoteException {
        if (this.zzc.zzF().isEmpty() || this.zzc.zzk() == null) {
            return false;
        }
        return true;
    }

    public final boolean zzI(Bundle bundle) throws RemoteException {
        return this.zzb.zzQ(bundle);
    }

    public final double zze() throws RemoteException {
        return this.zzc.zza();
    }

    public final Bundle zzf() throws RemoteException {
        return this.zzc.zzd();
    }

    public final zzbiw zzg() throws RemoteException {
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzfi)).booleanValue()) {
            return null;
        }
        return this.zzb.zzl();
    }

    public final zzbiz zzh() throws RemoteException {
        return this.zzc.zzj();
    }

    public final zzboa zzi() throws RemoteException {
        return this.zzc.zzl();
    }

    public final zzbof zzj() throws RemoteException {
        return this.zzb.zza().zza();
    }

    public final zzboi zzk() throws RemoteException {
        return this.zzc.zzn();
    }

    public final IObjectWrapper zzl() throws RemoteException {
        return this.zzc.zzt();
    }

    public final IObjectWrapper zzm() throws RemoteException {
        return ObjectWrapper.wrap(this.zzb);
    }

    public final String zzn() throws RemoteException {
        return this.zzc.zzv();
    }

    public final String zzo() throws RemoteException {
        return this.zzc.zzw();
    }

    public final String zzp() throws RemoteException {
        return this.zzc.zzx();
    }

    public final String zzq() throws RemoteException {
        return this.zzc.zzz();
    }

    public final String zzr() throws RemoteException {
        return this.zza;
    }

    public final String zzs() throws RemoteException {
        return this.zzc.zzB();
    }

    public final String zzt() throws RemoteException {
        return this.zzc.zzC();
    }

    public final List<?> zzu() throws RemoteException {
        return this.zzc.zzE();
    }

    public final List<?> zzv() throws RemoteException {
        if (zzH()) {
            return this.zzc.zzF();
        }
        return Collections.emptyList();
    }

    public final void zzw() throws RemoteException {
        this.zzb.zzk();
    }

    public final void zzx() throws RemoteException {
        this.zzb.zzT();
    }

    public final void zzy(@Nullable zzbij zzbij) throws RemoteException {
        this.zzb.zzw(zzbij);
    }

    public final void zzz(Bundle bundle) throws RemoteException {
        this.zzb.zzz(bundle);
    }
}
