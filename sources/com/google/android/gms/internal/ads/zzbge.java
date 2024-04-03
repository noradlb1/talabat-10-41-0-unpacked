package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzbge extends zzbgn<zzbhg> {
    final /* synthetic */ Context zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzbxh zzc;
    final /* synthetic */ zzbgm zzd;

    public zzbge(zzbgm zzbgm, Context context, String str, zzbxh zzbxh) {
        this.zzd = zzbgm;
        this.zza = context;
        this.zzb = str;
        this.zzc = zzbxh;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        zzbgm.zzs(this.zza, "native_ad");
        return new zzbjz();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzbhu zzbhu) throws RemoteException {
        return zzbhu.zzb(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, 214106000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        Object zzbhe;
        zzblj.zzc(this.zza);
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzhh)).booleanValue()) {
            return this.zzd.zzb.zza(this.zza, this.zzb, this.zzc);
        }
        try {
            IBinder zze = ((zzbhh) zzcjd.zzb(this.zza, "com.google.android.gms.ads.ChimeraAdLoaderBuilderCreatorImpl", zzbgd.zza)).zze(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, 214106000);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (queryLocalInterface instanceof zzbhg) {
                zzbhe = (zzbhg) queryLocalInterface;
            } else {
                zzbhe = new zzbhe(zze);
            }
            return zzbhe;
        } catch (RemoteException | zzcjc | NullPointerException e11) {
            this.zzd.zzh = zzcct.zza(this.zza);
            this.zzd.zzh.zzd(e11, "ClientApiBroker.createAdLoaderBuilder");
            return null;
        }
    }
}
