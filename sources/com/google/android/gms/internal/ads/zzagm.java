package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public final class zzagm extends Thread {
    private final BlockingQueue<zzags<?>> zza;
    private final zzagl zzb;
    private final zzagc zzc;
    private volatile boolean zzd = false;
    private final zzagj zze;

    /* JADX WARNING: type inference failed for: r2v0, types: [java.util.concurrent.BlockingQueue<com.google.android.gms.internal.ads.zzags<?>>, com.google.android.gms.internal.ads.zzagl] */
    /* JADX WARNING: type inference failed for: r3v0, types: [com.google.android.gms.internal.ads.zzagl, com.google.android.gms.internal.ads.zzagc] */
    /* JADX WARNING: type inference failed for: r4v0, types: [com.google.android.gms.internal.ads.zzagj, com.google.android.gms.internal.ads.zzagc] */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzagm(java.util.concurrent.BlockingQueue r1, java.util.concurrent.BlockingQueue<com.google.android.gms.internal.ads.zzags<?>> r2, com.google.android.gms.internal.ads.zzagl r3, com.google.android.gms.internal.ads.zzagc r4, com.google.android.gms.internal.ads.zzagj r5) {
        /*
            r0 = this;
            r0.<init>()
            r5 = 0
            r0.zzd = r5
            r0.zza = r1
            r0.zzb = r2
            r0.zzc = r3
            r0.zze = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagm.<init>(java.util.concurrent.BlockingQueue, com.google.android.gms.internal.ads.zzagl, com.google.android.gms.internal.ads.zzagc, com.google.android.gms.internal.ads.zzagj, byte[]):void");
    }

    private void zzb() throws InterruptedException {
        zzags take = this.zza.take();
        SystemClock.elapsedRealtime();
        take.zzt(3);
        try {
            take.zzm("network-queue-take");
            take.zzw();
            TrafficStats.setThreadStatsTag(take.zzc());
            zzago zza2 = this.zzb.zza(take);
            take.zzm("network-http-complete");
            if (!zza2.zze || !take.zzv()) {
                zzagy zzh = take.zzh(zza2);
                take.zzm("network-parse-complete");
                if (zzh.zzb != null) {
                    this.zzc.zzd(take.zzj(), zzh.zzb);
                    take.zzm("network-cache-written");
                }
                take.zzq();
                this.zze.zzb(take, zzh, (Runnable) null);
                take.zzs(zzh);
                take.zzt(4);
                return;
            }
            take.zzp("not-modified");
            take.zzr();
        } catch (zzahb e11) {
            SystemClock.elapsedRealtime();
            this.zze.zza(take, e11);
            take.zzr();
        } catch (Exception e12) {
            zzahe.zzc(e12, "Unhandled exception %s", e12.toString());
            zzahb zzahb = new zzahb((Throwable) e12);
            SystemClock.elapsedRealtime();
            this.zze.zza(take, zzahb);
            take.zzr();
        } finally {
            take.zzt(4);
        }
    }

    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                zzb();
            } catch (InterruptedException unused) {
                if (this.zzd) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzahe.zzb("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zza() {
        this.zzd = true;
        interrupt();
    }
}
