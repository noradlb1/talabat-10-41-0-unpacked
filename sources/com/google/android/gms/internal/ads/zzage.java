package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

public final class zzage extends Thread {
    private static final boolean zza = zzahe.zzb;
    private final BlockingQueue<zzags<?>> zzb;
    /* access modifiers changed from: private */
    public final BlockingQueue<zzags<?>> zzc;
    private final zzagc zzd;
    private volatile boolean zze = false;
    private final zzahf zzf;
    private final zzagj zzg;

    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.concurrent.BlockingQueue<com.google.android.gms.internal.ads.zzags<?>>, com.google.android.gms.internal.ads.zzagc] */
    /* JADX WARNING: type inference failed for: r4v0, types: [com.google.android.gms.internal.ads.zzagj, com.google.android.gms.internal.ads.zzagc] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzage(java.util.concurrent.BlockingQueue r1, java.util.concurrent.BlockingQueue<com.google.android.gms.internal.ads.zzags<?>> r2, java.util.concurrent.BlockingQueue<com.google.android.gms.internal.ads.zzags<?>> r3, com.google.android.gms.internal.ads.zzagc r4, com.google.android.gms.internal.ads.zzagj r5) {
        /*
            r0 = this;
            r0.<init>()
            r5 = 0
            r0.zze = r5
            r0.zzb = r1
            r0.zzc = r2
            r0.zzd = r3
            r0.zzg = r4
            com.google.android.gms.internal.ads.zzahf r1 = new com.google.android.gms.internal.ads.zzahf
            r3 = 0
            r1.<init>(r0, r2, r4, r3)
            r0.zzf = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzage.<init>(java.util.concurrent.BlockingQueue, java.util.concurrent.BlockingQueue, com.google.android.gms.internal.ads.zzagc, com.google.android.gms.internal.ads.zzagj, byte[]):void");
    }

    private void zzc() throws InterruptedException {
        zzags take = this.zzb.take();
        take.zzm("cache-queue-take");
        take.zzt(1);
        try {
            take.zzw();
            zzagb zza2 = this.zzd.zza(take.zzj());
            if (zza2 == null) {
                take.zzm("cache-miss");
                if (!this.zzf.zzc(take)) {
                    this.zzc.put(take);
                }
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (zza2.zza(currentTimeMillis)) {
                take.zzm("cache-hit-expired");
                take.zze(zza2);
                if (!this.zzf.zzc(take)) {
                    this.zzc.put(take);
                }
                take.zzt(2);
                return;
            }
            take.zzm("cache-hit");
            zzagy zzh = take.zzh(new zzago(zza2.zza, zza2.zzg));
            take.zzm("cache-hit-parsed");
            if (!zzh.zzc()) {
                take.zzm("cache-parsing-failed");
                this.zzd.zzc(take.zzj(), true);
                take.zze((zzagb) null);
                if (!this.zzf.zzc(take)) {
                    this.zzc.put(take);
                }
                take.zzt(2);
                return;
            }
            if (zza2.zzf < currentTimeMillis) {
                take.zzm("cache-hit-refresh-needed");
                take.zze(zza2);
                zzh.zzd = true;
                if (!this.zzf.zzc(take)) {
                    this.zzg.zzb(take, zzh, new zzagd(this, take));
                } else {
                    this.zzg.zzb(take, zzh, (Runnable) null);
                }
            } else {
                this.zzg.zzb(take, zzh, (Runnable) null);
            }
            take.zzt(2);
        } finally {
            take.zzt(2);
        }
    }

    public final void run() {
        if (zza) {
            zzahe.zzd("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzd.zzb();
        while (true) {
            try {
                zzc();
            } catch (InterruptedException unused) {
                if (this.zze) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzahe.zzb("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zzb() {
        this.zze = true;
        interrupt();
    }
}
