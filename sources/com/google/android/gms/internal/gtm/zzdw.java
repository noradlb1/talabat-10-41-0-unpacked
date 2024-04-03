package com.google.android.gms.internal.gtm;

import android.support.annotation.WorkerThread;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

final class zzdw implements zzmp, Runnable {
    private final /* synthetic */ zzdq zzanc;

    private zzdw(zzdq zzdq) {
        this.zzanc = zzdq;
    }

    @WorkerThread
    public final void run() {
        boolean z11;
        if (this.zzanc.state == 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11);
        if (!zzfd.zzkr().zzbw(this.zzanc.zzaec)) {
            String zzd = this.zzanc.zzaec;
            StringBuilder sb2 = new StringBuilder(String.valueOf(zzd).length() + 24);
            sb2.append("Refreshing container ");
            sb2.append(zzd);
            sb2.append("...");
            zzev.zzab(sb2.toString());
            ArrayList arrayList = new ArrayList();
            arrayList.add(0);
            this.zzanc.zzamu.zza(this.zzanc.zzaec, this.zzanc.zzams, this.zzanc.zzamr, arrayList, this, this.zzanc.zzamy);
        }
    }

    public final void zza(zzmx zzmx) {
        if (zzmx.getStatus() == Status.RESULT_SUCCESS) {
            String zzd = this.zzanc.zzaec;
            StringBuilder sb2 = new StringBuilder(String.valueOf(zzd).length() + 47);
            sb2.append("Refreshed container ");
            sb2.append(zzd);
            sb2.append(". Reinitializing runtime...");
            zzev.zzab(sb2.toString());
            this.zzanc.zzamv.execute(new zzdx(this.zzanc, zzmx));
            return;
        }
        zzdq zzdq = this.zzanc;
        zzdq.zzn(zzdq.zzamy.zzhm());
    }

    public /* synthetic */ zzdw(zzdq zzdq, zzdr zzdr) {
        this(zzdq);
    }
}
