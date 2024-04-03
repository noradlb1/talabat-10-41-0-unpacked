package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;

final class zzbgk extends zzbgn<zzbos> {
    final /* synthetic */ View zza;
    final /* synthetic */ HashMap zzb;
    final /* synthetic */ HashMap zzc;
    final /* synthetic */ zzbgm zzd;

    public zzbgk(zzbgm zzbgm, View view, HashMap hashMap, HashMap hashMap2) {
        this.zzd = zzbgm;
        this.zza = view;
        this.zzb = hashMap;
        this.zzc = hashMap2;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        zzbgm.zzs(this.zza.getContext(), "native_ad_view_holder_delegate");
        return new zzbkf();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzbhu zzbhu) throws RemoteException {
        return zzbhu.zzi(ObjectWrapper.wrap(this.zza), ObjectWrapper.wrap(this.zzb), ObjectWrapper.wrap(this.zzc));
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        zzblj.zzc(this.zza.getContext());
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzhh)).booleanValue()) {
            return this.zzd.zzg.zza(this.zza, this.zzb, this.zzc);
        }
        try {
            return zzbor.zze(((zzbov) zzcjd.zzb(this.zza.getContext(), "com.google.android.gms.ads.ChimeraNativeAdViewHolderDelegateCreatorImpl", zzbgj.zza)).zze(ObjectWrapper.wrap(this.zza), ObjectWrapper.wrap(this.zzb), ObjectWrapper.wrap(this.zzc)));
        } catch (RemoteException | zzcjc | NullPointerException e11) {
            this.zzd.zzh = zzcct.zza(this.zza.getContext());
            this.zzd.zzh.zzd(e11, "ClientApiBroker.createNativeAdViewHolderDelegate");
            return null;
        }
    }
}
