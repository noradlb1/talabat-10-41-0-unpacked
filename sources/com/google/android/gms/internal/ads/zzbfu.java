package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzbfu extends zzbgn<zzcht> {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbxh zzb;

    public zzbfu(zzbgm zzbgm, Context context, zzbxh zzbxh) {
        this.zza = context;
        this.zzb = zzbxh;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        return null;
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzbhu zzbhu) throws RemoteException {
        return zzbhu.zzo(ObjectWrapper.wrap(this.zza), this.zzb, 214106000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        try {
            return ((zzchw) zzcjd.zzb(this.zza, "com.google.android.gms.ads.DynamiteSignalGeneratorCreatorImpl", zzbft.zza)).zze(ObjectWrapper.wrap(this.zza), this.zzb, 214106000);
        } catch (RemoteException | zzcjc | NullPointerException unused) {
            return null;
        }
    }
}
