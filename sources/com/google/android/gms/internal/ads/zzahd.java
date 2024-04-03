package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

final class zzahd {
    public static final boolean zza = zzahe.zzb;
    private final List<zzahc> zzb = new ArrayList();
    private boolean zzc = false;

    public final void finalize() throws Throwable {
        if (!this.zzc) {
            zzb("Request on the loose");
            zzahe.zzb("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    public final synchronized void zza(String str, long j11) {
        if (!this.zzc) {
            this.zzb.add(new zzahc(str, j11, SystemClock.elapsedRealtime()));
        } else {
            throw new IllegalStateException("Marker added to finished log");
        }
    }

    public final synchronized void zzb(String str) {
        long j11;
        this.zzc = true;
        if (this.zzb.size() == 0) {
            j11 = 0;
        } else {
            long j12 = this.zzb.get(0).zzc;
            List<zzahc> list = this.zzb;
            j11 = list.get(list.size() - 1).zzc - j12;
        }
        if (j11 > 0) {
            long j13 = this.zzb.get(0).zzc;
            zzahe.zza("(%-4d ms) %s", Long.valueOf(j11), str);
            for (zzahc next : this.zzb) {
                long j14 = next.zzc;
                zzahe.zza("(+%-4d) [%2d] %s", Long.valueOf(j14 - j13), Long.valueOf(next.zzb), next.zza);
                j13 = j14;
            }
        }
    }
}
