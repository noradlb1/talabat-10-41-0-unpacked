package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzc;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzbaj extends zzc<zzbam> {
    public zzbaj(Context context, Looper looper, BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        super(zzcee.zza(context), looper, 123, baseConnectionCallbacks, baseOnConnectionFailedListener, (String) null);
    }

    @VisibleForTesting
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.cache.ICacheService");
        if (queryLocalInterface instanceof zzbam) {
            return (zzbam) queryLocalInterface;
        }
        return new zzbam(iBinder);
    }

    public final Feature[] getApiFeatures() {
        return zzb.zzb;
    }

    @VisibleForTesting
    public final String getServiceDescriptor() {
        return "com.google.android.gms.ads.internal.cache.ICacheService";
    }

    @VisibleForTesting
    public final String getStartServiceAction() {
        return "com.google.android.gms.ads.service.CACHE";
    }

    public final boolean zzp() {
        Feature[] availableFeatures = getAvailableFeatures();
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzbr)).booleanValue() || !ArrayUtils.contains((T[]) availableFeatures, zzb.zza)) {
            return false;
        }
        return true;
    }

    public final zzbam zzq() throws DeadObjectException {
        return (zzbam) super.getService();
    }
}
