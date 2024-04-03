package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationCallback;

final class zzcv implements ListenerHolder.Notifier {
    final /* synthetic */ zzcw zza;

    public zzcv(zzcw zzcw) {
        this.zza = zzcw;
    }

    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        LocationCallback locationCallback = (LocationCallback) obj;
        this.zza.zza.zzb();
    }

    public final void onNotifyListenerFailed() {
    }
}
