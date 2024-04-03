package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzbfw extends zzbgn<zzcbg> {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbxh zzb;

    public zzbfw(zzbgm zzbgm, Context context, zzbxh zzbxh) {
        this.zza = context;
        this.zzb = zzbxh;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        return null;
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzbhu zzbhu) throws RemoteException {
        return zzbhu.zzk(ObjectWrapper.wrap(this.zza), this.zzb, 214106000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        try {
            return ((zzcbj) zzcjd.zzb(this.zza, "com.google.android.gms.ads.DynamiteOfflineUtilsCreatorImpl", zzbfv.zza)).zze(ObjectWrapper.wrap(this.zza), this.zzb, 214106000);
        } catch (RemoteException | zzcjc | NullPointerException unused) {
            return null;
        }
    }
}
