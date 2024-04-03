package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzba extends zzan {
    private final zzq zzsu = new zzq();

    public zzba(zzap zzap) {
        super(zzap);
    }

    public final void zzaw() {
        zzcq().zzat().zzb(this.zzsu);
        zzda zzcu = zzcu();
        String zzaz = zzcu.zzaz();
        if (zzaz != null) {
            this.zzsu.setAppName(zzaz);
        }
        String zzba = zzcu.zzba();
        if (zzba != null) {
            this.zzsu.setAppVersion(zzba);
        }
    }

    public final zzq zzdv() {
        zzdb();
        return this.zzsu;
    }
}
