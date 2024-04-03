package com.google.android.gms.internal.gtm;

import android.os.Bundle;

final class zzgd implements Runnable {
    private boolean zzaqc = false;
    private final /* synthetic */ String zzaqd;
    private final /* synthetic */ Bundle zzaqe;
    private final /* synthetic */ String zzaqf;
    private final /* synthetic */ long zzaqg;
    private final /* synthetic */ String zzaqh;
    private final /* synthetic */ zzgc zzaqj;

    public zzgd(zzgc zzgc, String str, Bundle bundle, String str2, long j11, String str3) {
        this.zzaqj = zzgc;
        this.zzaqd = str;
        this.zzaqe = bundle;
        this.zzaqf = str2;
        this.zzaqg = j11;
        this.zzaqh = str3;
    }

    public final void run() {
        if (this.zzaqj.zzaqb.zzapx == 3) {
            this.zzaqj.zzaqb.zzaps.zza(this.zzaqd, this.zzaqe, this.zzaqf, this.zzaqg, false);
        } else if (this.zzaqj.zzaqb.zzapx == 1 || this.zzaqj.zzaqb.zzapx == 2) {
            if (!this.zzaqc) {
                zzev.zzab(String.format("Container not loaded yet: deferring event listener by enqueuing the event: name = %s, origin = %s, params = %s.", new Object[]{this.zzaqd, this.zzaqh, this.zzaqe}));
                this.zzaqc = true;
                this.zzaqj.zzaqb.zzapy.add(this);
                return;
            }
            zzev.zzac("Invalid state - not expecting to see a deferred event during container loading.");
        } else if (this.zzaqj.zzaqb.zzapx == 4) {
            zzev.zzab(String.format("Container failed to load: skipping event listener by ignoring the event: name = %s, origin = %s, params = %s.", new Object[]{this.zzaqd, this.zzaqh, this.zzaqe}));
        } else {
            int zza = this.zzaqj.zzaqb.zzapx;
            StringBuilder sb2 = new StringBuilder(28);
            sb2.append("Unexpected state:");
            sb2.append(zza);
            zzea.zzb(sb2.toString(), this.zzaqj.zzaqb.zzrm);
        }
    }
}
