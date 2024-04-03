package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

final class zzemj extends zzceq {
    final /* synthetic */ zzdgx zza;
    final /* synthetic */ zzdep zzb;
    final /* synthetic */ zzdfy zzc;
    final /* synthetic */ zzdmm zzd;

    public zzemj(zzemk zzemk, zzdgx zzdgx, zzdep zzdep, zzdfy zzdfy, zzdmm zzdmm) {
        this.zza = zzdgx;
        this.zzb = zzdep;
        this.zzc = zzdfy;
        this.zzd = zzdmm;
    }

    public final void zze(IObjectWrapper iObjectWrapper) {
        this.zzb.onAdClicked();
    }

    public final void zzf(IObjectWrapper iObjectWrapper) {
        this.zza.zzf(4);
    }

    public final void zzg(IObjectWrapper iObjectWrapper, int i11) {
    }

    public final void zzh(IObjectWrapper iObjectWrapper) {
        this.zzc.zzb();
    }

    public final void zzi(IObjectWrapper iObjectWrapper) {
    }

    public final void zzj(IObjectWrapper iObjectWrapper) {
        this.zza.zzb();
    }

    public final void zzk(IObjectWrapper iObjectWrapper, int i11) {
    }

    public final void zzl(IObjectWrapper iObjectWrapper) {
    }

    public final void zzm(IObjectWrapper iObjectWrapper, zzces zzces) {
        this.zzd.zza(zzces);
    }

    public final void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zzc.zze();
    }

    public final void zzo(IObjectWrapper iObjectWrapper) {
        this.zzd.zzc();
    }
}
