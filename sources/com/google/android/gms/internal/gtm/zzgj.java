package com.google.android.gms.internal.gtm;

import android.net.Uri;

final class zzgj implements Runnable {
    private final /* synthetic */ zzfy zzaqb;
    private final /* synthetic */ Uri zzaqp;

    public zzgj(zzfy zzfy, Uri uri) {
        this.zzaqb = zzfy;
        this.zzaqp = uri;
    }

    public final void run() {
        String valueOf = String.valueOf(this.zzaqp);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 25);
        sb2.append("Preview requested to uri ");
        sb2.append(valueOf);
        zzev.zzab(sb2.toString());
        synchronized (this.zzaqb.zzapv) {
            if (this.zzaqb.zzapx == 2) {
                zzev.zzab("Still initializing. Defer preview container loading.");
                this.zzaqb.zzapy.add(this);
                return;
            }
            String str = (String) this.zzaqb.zzc((String[]) null).first;
            if (str == null) {
                zzev.zzac("Preview failed (no container found)");
            } else if (!this.zzaqb.zzapt.zza(str, this.zzaqp)) {
                String valueOf2 = String.valueOf(this.zzaqp);
                StringBuilder sb3 = new StringBuilder(valueOf2.length() + 73);
                sb3.append("Cannot preview the app with the uri: ");
                sb3.append(valueOf2);
                sb3.append(". Launching current version instead.");
                zzev.zzac(sb3.toString());
            } else if (!this.zzaqb.zzrq) {
                String valueOf3 = String.valueOf(this.zzaqp);
                StringBuilder sb4 = new StringBuilder(valueOf3.length() + 84);
                sb4.append("Deferring container loading for preview uri: ");
                sb4.append(valueOf3);
                sb4.append("(Tag Manager has not been initialized).");
                zzev.zzab(sb4.toString());
            } else {
                String valueOf4 = String.valueOf(this.zzaqp);
                StringBuilder sb5 = new StringBuilder(valueOf4.length() + 36);
                sb5.append("Starting to load preview container: ");
                sb5.append(valueOf4);
                zzev.zzaw(sb5.toString());
                if (!this.zzaqb.zzaps.zzla()) {
                    zzev.zzac("Failed to reset TagManager service for preview");
                    return;
                }
                boolean unused = this.zzaqb.zzrq = false;
                int unused2 = this.zzaqb.zzapx = 1;
                this.zzaqb.zzag();
            }
        }
    }
}
