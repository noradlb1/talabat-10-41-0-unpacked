package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

public final class zzbjv extends RemoteCreator<zzbic> {
    public zzbjv() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
        if (queryLocalInterface instanceof zzbic) {
            return (zzbic) queryLocalInterface;
        }
        return new zzbic(iBinder);
    }

    public final zzbib zza(Context context) {
        zzbib zzbhz;
        try {
            IBinder zze = ((zzbic) getRemoteCreatorInstance(context)).zze(ObjectWrapper.wrap(context), 214106000);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzbib) {
                zzbhz = (zzbib) queryLocalInterface;
            } else {
                zzbhz = new zzbhz(zze);
            }
            return zzbhz;
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e11) {
            zzciz.zzk("Could not get remote MobileAdsSettingManager.", e11);
            return null;
        }
    }
}
