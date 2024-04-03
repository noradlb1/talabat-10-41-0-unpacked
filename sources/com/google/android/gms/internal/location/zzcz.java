package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.zzt;

final class zzcz extends zzt {
    /* access modifiers changed from: private */
    public final zzcs zza;

    public zzcz(zzcs zzcs) {
        this.zza = zzcs;
    }

    public final void zzd(Location location) {
        this.zza.zza().notifyListener(new zzcx(this, location));
    }

    public final void zze() {
        this.zza.zza().notifyListener(new zzcy(this));
    }

    public final zzcz zzf(ListenerHolder listenerHolder) {
        this.zza.zzc(listenerHolder);
        return this;
    }

    public final void zzg() {
        this.zza.zza().clear();
    }
}
