package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzbfy extends zzbgn<zzbsr> {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbxh zzb;
    final /* synthetic */ OnH5AdsEventListener zzc;

    public zzbfy(zzbgm zzbgm, Context context, zzbxh zzbxh, OnH5AdsEventListener onH5AdsEventListener) {
        this.zza = context;
        this.zzb = zzbxh;
        this.zzc = onH5AdsEventListener;
    }

    @NonNull
    public final /* synthetic */ Object zza() {
        return new zzbsy();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzbhu zzbhu) throws RemoteException {
        return zzbhu.zzj(ObjectWrapper.wrap(this.zza), this.zzb, 214106000, new zzbsl(this.zzc));
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        try {
            return ((zzbsu) zzcjd.zzb(this.zza, "com.google.android.gms.ads.DynamiteH5AdsManagerCreatorImpl", zzbfx.zza)).zze(ObjectWrapper.wrap(this.zza), this.zzb, 214106000, new zzbsl(this.zzc));
        } catch (RemoteException | zzcjc | NullPointerException unused) {
            return null;
        }
    }
}
