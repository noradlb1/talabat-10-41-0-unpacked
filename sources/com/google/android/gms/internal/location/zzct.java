package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;

final class zzct implements ListenerHolder.Notifier {
    final /* synthetic */ LocationResult zza;

    public zzct(zzcw zzcw, LocationResult locationResult) {
        this.zza = locationResult;
    }

    public final /* synthetic */ void notifyListener(Object obj) {
        ((LocationCallback) obj).onLocationResult(this.zza);
    }

    public final void onNotifyListenerFailed() {
    }
}
