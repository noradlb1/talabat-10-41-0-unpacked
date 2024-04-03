package com.google.android.gms.internal.gtm;

import android.support.annotation.WorkerThread;
import androidx.work.PeriodicWorkRequest;
import java.util.List;

final class zzdx implements Runnable {
    private final /* synthetic */ zzdq zzanc;
    private final zzmx zzane;

    public zzdx(zzdq zzdq, zzmx zzmx) {
        this.zzanc = zzdq;
        this.zzane = zzmx;
    }

    @WorkerThread
    public final void run() {
        boolean z11;
        String str;
        String str2;
        zznm zzlq = this.zzane.zzll().zzlq();
        zznu zzlm = this.zzane.zzlm();
        if (this.zzanc.zzamz == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdq zzdq = this.zzanc;
        zzff unused = zzdq.zzamz = zzdq.zzamt.zza(zzlq, zzlm);
        int unused2 = this.zzanc.state = 2;
        String zzd = this.zzanc.zzaec;
        StringBuilder sb2 = new StringBuilder(String.valueOf(zzd).length() + 48);
        sb2.append("Container ");
        sb2.append(zzd);
        sb2.append(" loaded during runtime initialization.");
        zzev.zzab(sb2.toString());
        if (this.zzanc.zzana != null) {
            for (zzee zzee : this.zzanc.zzana) {
                String valueOf = String.valueOf(zzee.zzkf());
                if (valueOf.length() != 0) {
                    str2 = "Evaluating tags for pending event ".concat(valueOf);
                } else {
                    str2 = new String("Evaluating tags for pending event ");
                }
                zzev.zzab(str2);
                this.zzanc.zzamz.zzb(zzee);
            }
            List unused3 = this.zzanc.zzana = null;
        }
        this.zzanc.zzamz.dispatch();
        String valueOf2 = String.valueOf(this.zzanc.zzaec);
        if (valueOf2.length() != 0) {
            str = "Runtime initialized successfully for container ".concat(valueOf2);
        } else {
            str = new String("Runtime initialized successfully for container ");
        }
        zzev.zzab(str);
        long zzlr = this.zzane.zzll().zzlr() + this.zzanc.zzamy.zzhl();
        if (!z11 || !this.zzanc.zzanb || this.zzane.getSource() != 1 || zzlr >= this.zzanc.zzsd.currentTimeMillis()) {
            zzdq zzdq2 = this.zzanc;
            zzdq2.zzn(Math.max(PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS, zzlr - zzdq2.zzsd.currentTimeMillis()));
            return;
        }
        zzdq zzdq3 = this.zzanc;
        zzdq3.zzn(zzdq3.zzamy.zzkd());
    }
}
