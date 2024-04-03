package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzbgl extends zzbgn<zzcez> {
    final /* synthetic */ Context zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzbxh zzc;
    final /* synthetic */ zzbgm zzd;

    public zzbgl(zzbgm zzbgm, Context context, String str, zzbxh zzbxh) {
        this.zzd = zzbgm;
        this.zza = context;
        this.zzb = str;
        this.zzc = zzbxh;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        zzbgm.zzs(this.zza, "rewarded");
        return new zzbkh();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzbhu zzbhu) throws RemoteException {
        return zzbhu.zzn(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, 214106000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        return zzcfl.zza(this.zza, this.zzb, this.zzc);
    }
}
