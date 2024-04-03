package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

public final class zzbqh extends RemoteCreator<zzbop> {
    @VisibleForTesting
    public zzbqh() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
        if (queryLocalInterface instanceof zzbop) {
            return (zzbop) queryLocalInterface;
        }
        return new zzbon(iBinder);
    }

    public final zzbom zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        zzbom zzbok;
        try {
            IBinder zze = ((zzbop) getRemoteCreatorInstance(context)).zze(ObjectWrapper.wrap(context), ObjectWrapper.wrap(frameLayout), ObjectWrapper.wrap(frameLayout2), 214106000);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
            if (queryLocalInterface instanceof zzbom) {
                zzbok = (zzbom) queryLocalInterface;
            } else {
                zzbok = new zzbok(zze);
            }
            return zzbok;
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e11) {
            zzciz.zzk("Could not create remote NativeAdViewDelegate.", e11);
            return null;
        }
    }
}
