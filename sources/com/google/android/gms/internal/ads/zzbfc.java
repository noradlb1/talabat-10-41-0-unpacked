package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

public final class zzbfc extends RemoteCreator<zzbhl> {
    private zzccv zza;

    @VisibleForTesting
    public zzbfc() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        if (queryLocalInterface instanceof zzbhl) {
            return (zzbhl) queryLocalInterface;
        }
        return new zzbhl(iBinder);
    }

    public final zzbhk zza(Context context, zzbfi zzbfi, String str, zzbxh zzbxh, int i11) {
        zzbhk zzbhi;
        zzbhk zzbhi2;
        zzblj.zzc(context);
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzhh)).booleanValue()) {
            try {
                IBinder zze = ((zzbhl) zzcjd.zzb(context, "com.google.android.gms.ads.ChimeraAdManagerCreatorImpl", zzbfb.zza)).zze(ObjectWrapper.wrap(context), zzbfi, str, zzbxh, 214106000, i11);
                if (zze == null) {
                    return null;
                }
                IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
                if (queryLocalInterface instanceof zzbhk) {
                    zzbhi2 = (zzbhk) queryLocalInterface;
                } else {
                    zzbhi2 = new zzbhi(zze);
                }
                return zzbhi2;
            } catch (RemoteException | zzcjc | NullPointerException e11) {
                zzccv zza2 = zzcct.zza(context);
                this.zza = zza2;
                zza2.zzd(e11, "AdManagerCreator.newAdManagerByDynamiteLoader");
                zzciz.zzl("#007 Could not call remote method.", e11);
                return null;
            }
        } else {
            try {
                IBinder zze2 = ((zzbhl) getRemoteCreatorInstance(context)).zze(ObjectWrapper.wrap(context), zzbfi, str, zzbxh, 214106000, i11);
                if (zze2 == null) {
                    return null;
                }
                IInterface queryLocalInterface2 = zze2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
                if (queryLocalInterface2 instanceof zzbhk) {
                    zzbhi = (zzbhk) queryLocalInterface2;
                } else {
                    zzbhi = new zzbhi(zze2);
                }
                return zzbhi;
            } catch (RemoteException | RemoteCreator.RemoteCreatorException e12) {
                zzciz.zzf("Could not create remote AdManager.", e12);
                return null;
            }
        }
    }
}
