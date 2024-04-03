package com.google.android.gms.internal.gtm;

import android.os.RemoteException;
import android.support.annotation.WorkerThread;
import java.util.List;

final class zzdt implements Runnable {
    private final /* synthetic */ zzdq zzanc;

    private zzdt(zzdq zzdq) {
        this.zzanc = zzdq;
    }

    @WorkerThread
    public final void run() {
        int unused = this.zzanc.state = 3;
        String zzd = this.zzanc.zzaec;
        StringBuilder sb2 = new StringBuilder(String.valueOf(zzd).length() + 26);
        sb2.append("Container ");
        sb2.append(zzd);
        sb2.append(" loading failed.");
        zzev.zzac(sb2.toString());
        if (this.zzanc.zzana != null) {
            for (zzee zzee : this.zzanc.zzana) {
                if (zzee.zzki()) {
                    try {
                        this.zzanc.zzamx.logEventInternalNoInterceptor("app", zzee.zzkf(), zzee.zzkg(), zzee.currentTimeMillis());
                        String zzkf = zzee.zzkf();
                        StringBuilder sb3 = new StringBuilder(String.valueOf(zzkf).length() + 50);
                        sb3.append("Logged event ");
                        sb3.append(zzkf);
                        sb3.append(" to Firebase (marked as passthrough).");
                        zzev.zzab(sb3.toString());
                    } catch (RemoteException e11) {
                        zzea.zza("Error logging event with measurement proxy:", e11, this.zzanc.zzrm);
                    }
                } else {
                    String zzkf2 = zzee.zzkf();
                    StringBuilder sb4 = new StringBuilder(String.valueOf(zzkf2).length() + 45);
                    sb4.append("Discarded event ");
                    sb4.append(zzkf2);
                    sb4.append(" (marked as non-passthrough).");
                    zzev.zzab(sb4.toString());
                }
            }
            List unused2 = this.zzanc.zzana = null;
        }
    }

    public /* synthetic */ zzdt(zzdq zzdq, zzdr zzdr) {
        this(zzdq);
    }
}
