package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzagv {
    private final AtomicInteger zza = new AtomicInteger();
    private final Set<zzags<?>> zzb = new HashSet();
    private final PriorityBlockingQueue<zzags<?>> zzc = new PriorityBlockingQueue<>();
    private final PriorityBlockingQueue<zzags<?>> zzd = new PriorityBlockingQueue<>();
    private final zzagc zze;
    private final zzagl zzf;
    private final zzagm[] zzg;
    private zzage zzh;
    private final List<zzagu> zzi = new ArrayList();
    private final List<zzagt> zzj = new ArrayList();
    private final zzagj zzk;

    public zzagv(zzagc zzagc, zzagl zzagl, int i11) {
        zzagj zzagj = new zzagj(new Handler(Looper.getMainLooper()));
        this.zze = zzagc;
        this.zzf = zzagl;
        this.zzg = new zzagm[4];
        this.zzk = zzagj;
    }

    public final <T> zzags<T> zza(zzags<T> zzags) {
        zzags.zzf(this);
        synchronized (this.zzb) {
            this.zzb.add(zzags);
        }
        zzags.zzg(this.zza.incrementAndGet());
        zzags.zzm("add-to-queue");
        zzc(zzags, 0);
        this.zzc.add(zzags);
        return zzags;
    }

    public final <T> void zzb(zzags<T> zzags) {
        synchronized (this.zzb) {
            this.zzb.remove(zzags);
        }
        synchronized (this.zzi) {
            for (zzagu zza2 : this.zzi) {
                zza2.zza();
            }
        }
        zzc(zzags, 5);
    }

    public final void zzc(zzags<?> zzags, int i11) {
        synchronized (this.zzj) {
            for (zzagt zza2 : this.zzj) {
                zza2.zza();
            }
        }
    }

    public final void zzd() {
        zzage zzage = this.zzh;
        if (zzage != null) {
            zzage.zzb();
        }
        zzagm[] zzagmArr = this.zzg;
        for (int i11 = 0; i11 < 4; i11++) {
            zzagm zzagm = zzagmArr[i11];
            if (zzagm != null) {
                zzagm.zza();
            }
        }
        zzage zzage2 = new zzage(this.zzc, this.zzd, this.zze, this.zzk, (zzagj) null);
        this.zzh = zzage2;
        zzage2.start();
        for (int i12 = 0; i12 < 4; i12++) {
            zzagm zzagm2 = new zzagm(this.zzd, this.zzf, this.zze, this.zzk, (zzagj) null);
            this.zzg[i12] = zzagm2;
            zzagm2.start();
        }
    }
}
