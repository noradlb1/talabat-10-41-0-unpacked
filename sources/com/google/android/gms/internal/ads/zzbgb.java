package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzbgb extends zzbgn<zzbhk> {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbfi zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzbgm zzd;

    public zzbgb(zzbgm zzbgm, Context context, zzbfi zzbfi, String str) {
        this.zzd = zzbgm;
        this.zza = context;
        this.zzb = zzbfi;
        this.zzc = str;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        zzbgm.zzs(this.zza, "search");
        return new zzbkb();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzbhu zzbhu) throws RemoteException {
        return zzbhu.zzf(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, 214106000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        return this.zzd.zza.zza(this.zza, this.zzb, this.zzc, (zzbxh) null, 3);
    }
}
