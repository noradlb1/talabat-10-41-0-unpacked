package com.google.android.gms.internal.gtm;

import android.support.annotation.WorkerThread;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

final class zzdu implements zzmp, Runnable {
    private final /* synthetic */ zzdq zzanc;

    private zzdu(zzdq zzdq) {
        this.zzanc = zzdq;
    }

    @WorkerThread
    public final void run() {
        boolean z11 = true;
        if (this.zzanc.state != 1) {
            z11 = false;
        }
        Preconditions.checkState(z11);
        ArrayList arrayList = new ArrayList();
        boolean unused = this.zzanc.zzanb = false;
        if (zzfd.zzkr().zzbw(this.zzanc.zzaec)) {
            arrayList.add(0);
        } else {
            zzdq zzdq = this.zzanc;
            boolean unused2 = zzdq.zzanb = zzdq.zzamy.zzke();
            if (!this.zzanc.zzanb) {
                arrayList.add(0);
                arrayList.add(1);
            } else {
                arrayList.add(1);
                arrayList.add(0);
            }
            arrayList.add(2);
        }
        this.zzanc.zzamu.zza(this.zzanc.zzaec, this.zzanc.zzams, this.zzanc.zzamr, arrayList, this, this.zzanc.zzamy);
    }

    public final void zza(zzmx zzmx) {
        if (zzmx.getStatus() == Status.RESULT_SUCCESS) {
            this.zzanc.zzamv.execute(new zzdx(this.zzanc, zzmx));
        } else {
            this.zzanc.zzamv.execute(new zzdt(this.zzanc, (zzdr) null));
        }
    }

    public /* synthetic */ zzdu(zzdq zzdq, zzdr zzdr) {
        this(zzdq);
    }
}
