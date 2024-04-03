package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MuteThisAdListener;

public final class zzbig extends zzbie {
    private final MuteThisAdListener zza;

    public zzbig(MuteThisAdListener muteThisAdListener) {
        this.zza = muteThisAdListener;
    }

    public final void zze() {
        this.zza.onAdMuted();
    }
}
