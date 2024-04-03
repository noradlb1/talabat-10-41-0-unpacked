package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;

final class zzbjl implements AdapterStatus {
    public zzbjl(zzbjq zzbjq) {
    }

    public final String getDescription() {
        return "Google Mobile Ads SDK initialization functionality unavailable for this session. Ad requests can be made at any time.";
    }

    public final AdapterStatus.State getInitializationState() {
        return AdapterStatus.State.READY;
    }

    public final int getLatency() {
        return 0;
    }
}
