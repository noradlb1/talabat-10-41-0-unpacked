package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
final class zzez implements zzfw {
    private final /* synthetic */ zzey zzaom;

    public zzez(zzey zzey) {
        this.zzaom = zzey;
    }

    public final void zza(zzeh zzeh) {
        this.zzaom.zze(zzeh.zzih());
    }

    public final void zzb(zzeh zzeh) {
        this.zzaom.zze(zzeh.zzih());
        long zzih = zzeh.zzih();
        StringBuilder sb2 = new StringBuilder(57);
        sb2.append("Permanent failure dispatching hitId: ");
        sb2.append(zzih);
        zzev.zzab(sb2.toString());
    }

    public final void zzc(zzeh zzeh) {
        long zzii = zzeh.zzii();
        if (zzii == 0) {
            this.zzaom.zzb(zzeh.zzih(), this.zzaom.zzsd.currentTimeMillis());
        } else if (zzii + 14400000 < this.zzaom.zzsd.currentTimeMillis()) {
            this.zzaom.zze(zzeh.zzih());
            long zzih = zzeh.zzih();
            StringBuilder sb2 = new StringBuilder(47);
            sb2.append("Giving up on failed hitId: ");
            sb2.append(zzih);
            zzev.zzab(sb2.toString());
        }
    }
}
