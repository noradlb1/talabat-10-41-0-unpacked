package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzc;
import com.google.android.gms.common.internal.BaseGmsClient;

public final class zzfno extends zzc<zzfnt> {
    private final int zze;

    public zzfno(Context context, Looper looper, BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener, int i11) {
        super(context, looper, 116, baseConnectionCallbacks, baseOnConnectionFailedListener, (String) null);
        this.zze = i11;
    }

    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.gass.internal.IGassService");
        if (queryLocalInterface instanceof zzfnt) {
            return (zzfnt) queryLocalInterface;
        }
        return new zzfnt(iBinder);
    }

    public final int getMinApkVersion() {
        return this.zze;
    }

    public final String getServiceDescriptor() {
        return "com.google.android.gms.gass.internal.IGassService";
    }

    public final String getStartServiceAction() {
        return "com.google.android.gms.gass.START";
    }

    public final zzfnt zzp() throws DeadObjectException {
        return (zzfnt) super.getService();
    }
}
