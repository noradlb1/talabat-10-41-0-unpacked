package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzbbc {
    @VisibleForTesting
    zzaoo zza;
    @VisibleForTesting
    boolean zzb;

    public zzbbc() {
    }

    public zzbbc(Context context) {
        zzblj.zzc(context);
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzdv)).booleanValue()) {
            try {
                this.zza = (zzaoo) zzcjd.zzb(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zzbaz.zza);
                ObjectWrapper.wrap(context);
                this.zza.zze(ObjectWrapper.wrap(context), "GMA_SDK");
                this.zzb = true;
            } catch (RemoteException | zzcjc | NullPointerException unused) {
                zzciz.zze("Cannot dynamite load clearcut");
            }
        }
    }
}
