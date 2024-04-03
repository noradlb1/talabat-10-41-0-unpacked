package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzcfl {
    public static final zzcez zza(Context context, String str, zzbxh zzbxh) {
        zzcez zzcex;
        try {
            IBinder zze = ((zzcfd) zzcjd.zzb(context, "com.google.android.gms.ads.rewarded.ChimeraRewardedAdCreatorImpl", zzcfk.zza)).zze(ObjectWrapper.wrap(context), str, zzbxh, 214106000);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
            if (queryLocalInterface instanceof zzcez) {
                zzcex = (zzcez) queryLocalInterface;
            } else {
                zzcex = new zzcex(zze);
            }
            return zzcex;
        } catch (RemoteException | zzcjc e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
            return null;
        }
    }
}
