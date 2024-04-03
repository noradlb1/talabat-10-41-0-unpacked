package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tagmanager.zzcm;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
public final class zzdq {
    /* access modifiers changed from: private */
    public volatile int state = 1;
    /* access modifiers changed from: private */
    public final String zzaec;
    private ScheduledFuture<?> zzajk = null;
    /* access modifiers changed from: private */
    public final String zzamr;
    /* access modifiers changed from: private */
    public final String zzams;
    /* access modifiers changed from: private */
    public final zzfk zzamt;
    /* access modifiers changed from: private */
    public final zzmo zzamu;
    /* access modifiers changed from: private */
    public final ExecutorService zzamv;
    private final ScheduledExecutorService zzamw;
    /* access modifiers changed from: private */
    public final zzcm zzamx;
    /* access modifiers changed from: private */
    public final zzdz zzamy;
    /* access modifiers changed from: private */
    public zzff zzamz;
    /* access modifiers changed from: private */
    public List<zzee> zzana = new ArrayList();
    /* access modifiers changed from: private */
    public boolean zzanb = false;
    /* access modifiers changed from: private */
    public final Context zzrm;
    /* access modifiers changed from: private */
    public final Clock zzsd;

    public zzdq(Context context, String str, @Nullable String str2, @Nullable String str3, zzfk zzfk, zzmo zzmo, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService, zzcm zzcm, Clock clock, zzdz zzdz) {
        this.zzrm = context;
        String str4 = (String) Preconditions.checkNotNull(str);
        this.zzaec = str4;
        this.zzamt = (zzfk) Preconditions.checkNotNull(zzfk);
        this.zzamu = (zzmo) Preconditions.checkNotNull(zzmo);
        ExecutorService executorService2 = (ExecutorService) Preconditions.checkNotNull(executorService);
        this.zzamv = executorService2;
        this.zzamw = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService);
        zzcm zzcm2 = (zzcm) Preconditions.checkNotNull(zzcm);
        this.zzamx = zzcm2;
        this.zzsd = (Clock) Preconditions.checkNotNull(clock);
        this.zzamy = (zzdz) Preconditions.checkNotNull(zzdz);
        this.zzamr = str3;
        this.zzams = str2;
        this.zzana.add(new zzee("gtm.load", new Bundle(), "gtm", new Date(), false, zzcm2));
        StringBuilder sb2 = new StringBuilder(String.valueOf(str4).length() + 35);
        sb2.append("Container ");
        sb2.append(str4);
        sb2.append("is scheduled for loading.");
        zzev.zzab(sb2.toString());
        executorService2.execute(new zzdu(this, (zzdr) null));
    }

    /* access modifiers changed from: private */
    public final void zzn(long j11) {
        ScheduledFuture<?> scheduledFuture = this.zzajk;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        String str = this.zzaec;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 45);
        sb2.append("Refresh container ");
        sb2.append(str);
        sb2.append(" in ");
        sb2.append(j11);
        sb2.append("ms.");
        zzev.zzab(sb2.toString());
        this.zzajk = this.zzamw.schedule(new zzds(this), j11, TimeUnit.MILLISECONDS);
    }

    public final void dispatch() {
        this.zzamv.execute(new zzdr(this));
    }

    @VisibleForTesting
    public final void zza(zzee zzee) {
        this.zzamv.execute(new zzdv(this, zzee));
    }
}
