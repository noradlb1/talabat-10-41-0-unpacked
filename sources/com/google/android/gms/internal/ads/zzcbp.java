package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

public final class zzcbp extends RemoteCreator<zzcbv> {
    public zzcbp() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        if (queryLocalInterface instanceof zzcbv) {
            return (zzcbv) queryLocalInterface;
        }
        return new zzcbt(iBinder);
    }

    public final zzcbs zza(Activity activity) {
        zzcbs zzcbq;
        try {
            IBinder zze = ((zzcbv) getRemoteCreatorInstance(activity)).zze(ObjectWrapper.wrap(activity));
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            if (queryLocalInterface instanceof zzcbs) {
                zzcbq = (zzcbs) queryLocalInterface;
            } else {
                zzcbq = new zzcbq(zze);
            }
            return zzcbq;
        } catch (RemoteException e11) {
            zzciz.zzk("Could not create remote AdOverlay.", e11);
            return null;
        } catch (RemoteCreator.RemoteCreatorException e12) {
            zzciz.zzk("Could not create remote AdOverlay.", e12);
            return null;
        }
    }
}
