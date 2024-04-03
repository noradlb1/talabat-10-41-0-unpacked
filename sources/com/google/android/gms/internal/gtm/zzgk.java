package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzfy;

final class zzgk implements Runnable {
    private final /* synthetic */ String zzaqk;
    private final /* synthetic */ boolean zzaqq;
    private final /* synthetic */ zzfy.zzb zzaqr;

    public zzgk(zzfy.zzb zzb, boolean z11, String str) {
        this.zzaqr = zzb;
        this.zzaqq = z11;
        this.zzaqk = str;
    }

    public final void run() {
        String str;
        if (zzfy.this.zzapx == 2) {
            if (this.zzaqq) {
                int unused = zzfy.this.zzapx = 3;
                String str2 = this.zzaqk;
                StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 18);
                sb2.append("Container ");
                sb2.append(str2);
                sb2.append(" loaded.");
                zzev.zzab(sb2.toString());
            } else {
                int unused2 = zzfy.this.zzapx = 4;
                String valueOf = String.valueOf(this.zzaqk);
                if (valueOf.length() != 0) {
                    str = "Error loading container:".concat(valueOf);
                } else {
                    str = new String("Error loading container:");
                }
                zzev.zzav(str);
            }
            while (!zzfy.this.zzapy.isEmpty()) {
                zzfy.this.zzamv.execute((Runnable) zzfy.this.zzapy.remove());
            }
            return;
        }
        zzev.zzac("Container load callback completed after timeout");
    }
}
