package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationListener;

final class zzcx implements ListenerHolder.Notifier {
    final /* synthetic */ Location zza;

    public zzcx(zzcz zzcz, Location location) {
        this.zza = location;
    }

    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        ((LocationListener) obj).onLocationChanged(this.zza);
    }

    public final void onNotifyListenerFailed() {
    }
}
