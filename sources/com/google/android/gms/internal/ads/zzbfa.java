package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

public final class zzbfa extends RemoteCreator<zzbhh> {
    public zzbfa() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
        if (queryLocalInterface instanceof zzbhh) {
            return (zzbhh) queryLocalInterface;
        }
        return new zzbhh(iBinder);
    }

    public final zzbhg zza(Context context, String str, zzbxh zzbxh) {
        zzbhg zzbhe;
        try {
            IBinder zze = ((zzbhh) getRemoteCreatorInstance(context)).zze(ObjectWrapper.wrap(context), str, zzbxh, 214106000);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (queryLocalInterface instanceof zzbhg) {
                zzbhe = (zzbhg) queryLocalInterface;
            } else {
                zzbhe = new zzbhe(zze);
            }
            return zzbhe;
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e11) {
            zzciz.zzk("Could not create remote builder for AdLoader.", e11);
            return null;
        }
    }
}
