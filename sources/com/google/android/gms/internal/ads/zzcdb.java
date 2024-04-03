package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzc;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzcdb extends zzc<zzcdi> {
    public zzcdb(Context context, Looper looper, BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        super(zzcee.zza(context), looper, 8, baseConnectionCallbacks, baseOnConnectionFailedListener, (String) null);
    }

    @VisibleForTesting
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
        if (queryLocalInterface instanceof zzcdi) {
            return (zzcdi) queryLocalInterface;
        }
        return new zzcdg(iBinder);
    }

    @VisibleForTesting
    public final String getServiceDescriptor() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    @VisibleForTesting
    public final String getStartServiceAction() {
        return "com.google.android.gms.ads.service.START";
    }

    public final zzcdi zzp() throws DeadObjectException {
        return (zzcdi) super.getService();
    }
}
