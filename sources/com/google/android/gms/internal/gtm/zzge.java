package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzfy;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;

final class zzge implements Runnable {
    private final /* synthetic */ zzfy zzaqb;
    private final /* synthetic */ String zzaqk;
    private final /* synthetic */ String zzaql;
    private final /* synthetic */ String zzaqm = null;

    public zzge(zzfy zzfy, String str, String str2, String str3) {
        this.zzaqb = zzfy;
        this.zzaqk = str;
        this.zzaql = str2;
    }

    public final void run() {
        String str = this.zzaqk;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 28);
        sb2.append("Starting to load container ");
        sb2.append(str);
        sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
        zzev.zzab(sb2.toString());
        if (this.zzaqb.zzapx != 1) {
            zzea.zzb("Unexpected state - container loading already initiated.", this.zzaqb.zzrm);
            return;
        }
        int unused = this.zzaqb.zzapx = 2;
        this.zzaqb.zzaps.zzb(this.zzaqk, this.zzaql, this.zzaqm, new zzfy.zzb(this.zzaqb, (zzfz) null));
    }
}
