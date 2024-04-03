package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzbgc extends zzbgn<zzbhk> {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbfi zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzbxh zzd;
    final /* synthetic */ zzbgm zze;

    public zzbgc(zzbgm zzbgm, Context context, zzbfi zzbfi, String str, zzbxh zzbxh) {
        this.zze = zzbgm;
        this.zza = context;
        this.zzb = zzbfi;
        this.zzc = str;
        this.zzd = zzbxh;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        zzbgm.zzs(this.zza, "interstitial");
        return new zzbkb();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzbhu zzbhu) throws RemoteException {
        return zzbhu.zze(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, this.zzd, 214106000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        return this.zze.zza.zza(this.zza, this.zzb, this.zzc, this.zzd, 2);
    }
}
