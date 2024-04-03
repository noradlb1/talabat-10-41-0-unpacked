package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzc;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import net.bytebuddy.jar.asm.Opcodes;

public final class zzbsz extends zzc<zzbtg> {
    public zzbsz(Context context, Looper looper, BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        super(zzcee.zza(context), looper, Opcodes.IF_ACMPNE, baseConnectionCallbacks, baseOnConnectionFailedListener, (String) null);
    }

    @VisibleForTesting
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
        if (queryLocalInterface instanceof zzbtg) {
            return (zzbtg) queryLocalInterface;
        }
        return new zzbtg(iBinder);
    }

    @VisibleForTesting
    public final String getServiceDescriptor() {
        return "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService";
    }

    @VisibleForTesting
    public final String getStartServiceAction() {
        return "com.google.android.gms.ads.service.HTTP";
    }

    public final zzbtg zzp() throws DeadObjectException {
        return (zzbtg) super.getService();
    }
}
