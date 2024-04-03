package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import java.util.HashMap;

public final class zzbqi extends RemoteCreator<zzbov> {
    @VisibleForTesting
    public zzbqi() {
        super("com.google.android.gms.ads.NativeAdViewHolderDelegateCreatorImpl");
    }

    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegateCreator");
        if (queryLocalInterface instanceof zzbov) {
            return (zzbov) queryLocalInterface;
        }
        return new zzbot(iBinder);
    }

    public final zzbos zza(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        zzbos zzboq;
        try {
            IBinder zze = ((zzbov) getRemoteCreatorInstance(view.getContext())).zze(ObjectWrapper.wrap(view), ObjectWrapper.wrap(hashMap), ObjectWrapper.wrap(hashMap2));
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
            if (queryLocalInterface instanceof zzbos) {
                zzboq = (zzbos) queryLocalInterface;
            } else {
                zzboq = new zzboq(zze);
            }
            return zzboq;
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e11) {
            zzciz.zzk("Could not create remote NativeAdViewHolderDelegate.", e11);
            return null;
        }
    }
}
