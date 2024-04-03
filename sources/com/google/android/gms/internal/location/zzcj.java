package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcj extends LocationCallback {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ zzda zzb;

    public zzcj(zzda zzda, TaskCompletionSource taskCompletionSource) {
        this.zzb = zzda;
        this.zza = taskCompletionSource;
    }

    public final void onLocationResult(LocationResult locationResult) {
        this.zza.trySetResult(locationResult.getLastLocation());
        try {
            this.zzb.zzB(ListenerHolders.createListenerKey(this, "GetCurrentLocation"), false, new TaskCompletionSource());
        } catch (RemoteException unused) {
        }
    }
}
