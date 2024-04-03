package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzbgg extends zzbgn<zzbib> {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbgm zzb;

    public zzbgg(zzbgm zzbgm, Context context) {
        this.zzb = zzbgm;
        this.zza = context;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        zzbgm.zzs(this.zza, "mobile_ads_settings");
        return new zzbkd();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzbhu zzbhu) throws RemoteException {
        return zzbhu.zzg(ObjectWrapper.wrap(this.zza), 214106000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        Object zzbhz;
        zzblj.zzc(this.zza);
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzhh)).booleanValue()) {
            return this.zzb.zzc.zza(this.zza);
        }
        try {
            IBinder zze = ((zzbic) zzcjd.zzb(this.zza, "com.google.android.gms.ads.ChimeraMobileAdsSettingManagerCreatorImpl", zzbgf.zza)).zze(ObjectWrapper.wrap(this.zza), 214106000);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzbib) {
                zzbhz = (zzbib) queryLocalInterface;
            } else {
                zzbhz = new zzbhz(zze);
            }
            return zzbhz;
        } catch (RemoteException | zzcjc | NullPointerException e11) {
            this.zzb.zzh = zzcct.zza(this.zza);
            this.zzb.zzh.zzd(e11, "ClientApiBroker.getMobileAdsSettingsManager");
            return null;
        }
    }
}
