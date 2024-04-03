package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzbgi extends zzbgn<zzbom> {
    final /* synthetic */ FrameLayout zza;
    final /* synthetic */ FrameLayout zzb;
    final /* synthetic */ Context zzc;
    final /* synthetic */ zzbgm zzd;

    public zzbgi(zzbgm zzbgm, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        this.zzd = zzbgm;
        this.zza = frameLayout;
        this.zzb = frameLayout2;
        this.zzc = context;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        zzbgm.zzs(this.zzc, "native_ad_view_delegate");
        return new zzbke();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzbhu zzbhu) throws RemoteException {
        return zzbhu.zzh(ObjectWrapper.wrap(this.zza), ObjectWrapper.wrap(this.zzb));
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        zzblj.zzc(this.zzc);
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzhh)).booleanValue()) {
            return this.zzd.zzd.zza(this.zzc, this.zza, this.zzb);
        }
        try {
            return zzbol.zzbJ(((zzbop) zzcjd.zzb(this.zzc, "com.google.android.gms.ads.ChimeraNativeAdViewDelegateCreatorImpl", zzbgh.zza)).zze(ObjectWrapper.wrap(this.zzc), ObjectWrapper.wrap(this.zza), ObjectWrapper.wrap(this.zzb), 214106000));
        } catch (RemoteException | zzcjc | NullPointerException e11) {
            this.zzd.zzh = zzcct.zza(this.zzc);
            this.zzd.zzh.zzd(e11, "ClientApiBroker.createNativeAdViewDelegate");
            return null;
        }
    }
}
