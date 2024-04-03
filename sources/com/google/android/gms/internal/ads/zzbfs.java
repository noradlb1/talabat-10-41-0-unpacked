package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzbfs extends zzbgn<zzcbs> {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzbgm zzb;

    public zzbfs(zzbgm zzbgm, Activity activity) {
        this.zzb = zzbgm;
        this.zza = activity;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        zzbgm.zzs(this.zza, "ad_overlay");
        return null;
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzbhu zzbhu) throws RemoteException {
        return zzbhu.zzl(ObjectWrapper.wrap(this.zza));
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        zzblj.zzc(this.zza);
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzhh)).booleanValue()) {
            return this.zzb.zzf.zza(this.zza);
        }
        try {
            return zzcbr.zzF(((zzcbv) zzcjd.zzb(this.zza, "com.google.android.gms.ads.ChimeraAdOverlayCreatorImpl", zzbfr.zza)).zze(ObjectWrapper.wrap(this.zza)));
        } catch (RemoteException | zzcjc | NullPointerException e11) {
            this.zzb.zzh = zzcct.zza(this.zza.getApplicationContext());
            this.zzb.zzh.zzd(e11, "ClientApiBroker.createAdOverlay");
            return null;
        }
    }
}
