package com.google.android.gms.internal.gtm;

import android.os.RemoteException;
import android.support.annotation.WorkerThread;

final class zzdv implements Runnable {
    private final /* synthetic */ zzdq zzanc;
    private final zzee zzand;

    public zzdv(zzdq zzdq, zzee zzee) {
        this.zzanc = zzdq;
        this.zzand = zzee;
    }

    @WorkerThread
    public final void run() {
        String str;
        String str2;
        if (this.zzanc.state == 2) {
            String valueOf = String.valueOf(this.zzand.zzkf());
            if (valueOf.length() != 0) {
                str2 = "Evaluating tags for event ".concat(valueOf);
            } else {
                str2 = new String("Evaluating tags for event ");
            }
            zzev.zzab(str2);
            this.zzanc.zzamz.zzb(this.zzand);
        } else if (this.zzanc.state == 1) {
            this.zzanc.zzana.add(this.zzand);
            String zzkf = this.zzand.zzkf();
            StringBuilder sb2 = new StringBuilder(String.valueOf(zzkf).length() + 30);
            sb2.append("Added event ");
            sb2.append(zzkf);
            sb2.append(" to pending queue.");
            zzev.zzab(sb2.toString());
        } else if (this.zzanc.state == 3) {
            String zzkf2 = this.zzand.zzkf();
            StringBuilder sb3 = new StringBuilder(String.valueOf(zzkf2).length() + 61);
            sb3.append("Failed to evaluate tags for event ");
            sb3.append(zzkf2);
            sb3.append(" (container failed to load)");
            zzev.zzab(sb3.toString());
            if (this.zzand.zzki()) {
                try {
                    this.zzanc.zzamx.logEventInternalNoInterceptor("app", this.zzand.zzkf(), this.zzand.zzkg(), this.zzand.currentTimeMillis());
                    String zzkf3 = this.zzand.zzkf();
                    StringBuilder sb4 = new StringBuilder(String.valueOf(zzkf3).length() + 38);
                    sb4.append("Logged passthrough event ");
                    sb4.append(zzkf3);
                    sb4.append(" to Firebase.");
                    zzev.zzab(sb4.toString());
                } catch (RemoteException e11) {
                    zzea.zza("Error logging event with measurement proxy:", e11, this.zzanc.zzrm);
                }
            } else {
                String valueOf2 = String.valueOf(this.zzand.zzkf());
                if (valueOf2.length() != 0) {
                    str = "Discarded non-passthrough event ".concat(valueOf2);
                } else {
                    str = new String("Discarded non-passthrough event ");
                }
                zzev.zzab(str);
            }
        }
    }
}
