package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;

public final class zzffa implements zzgpr<Clock> {
    private final zzfez zza;

    public zzffa(zzfez zzfez) {
        this.zza = zzfez;
    }

    public final /* synthetic */ Object zzb() {
        Clock instance = DefaultClock.getInstance();
        zzgpz.zzb(instance);
        return instance;
    }
}
