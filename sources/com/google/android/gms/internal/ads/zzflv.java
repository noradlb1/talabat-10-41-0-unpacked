package com.google.android.gms.internal.ads;

import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Instrumented
public final class zzflv {
    private final BlockingQueue<Runnable> zza;
    private final ThreadPoolExecutor zzb;
    private final ArrayDeque<zzflu> zzc = new ArrayDeque<>();
    private zzflu zzd = null;

    public zzflv() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.zza = linkedBlockingQueue;
        this.zzb = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private final void zzc() {
        zzflu poll = this.zzc.poll();
        this.zzd = poll;
        if (poll != null) {
            AsyncTaskInstrumentation.executeOnExecutor(poll, this.zzb, new Object[0]);
        }
    }

    public final void zza(zzflu zzflu) {
        this.zzd = null;
        zzc();
    }

    public final void zzb(zzflu zzflu) {
        zzflu.zzb(this);
        this.zzc.add(zzflu);
        if (this.zzd == null) {
            zzc();
        }
    }
}
