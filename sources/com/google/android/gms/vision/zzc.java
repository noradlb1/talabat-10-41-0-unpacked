package com.google.android.gms.vision;

import android.util.SparseIntArray;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

@VisibleForTesting
public final class zzc {
    private static final Object lock = new Object();
    @GuardedBy("lock")
    private static int zzat;
    @GuardedBy("lock")
    private final SparseIntArray zzau = new SparseIntArray();
    @GuardedBy("lock")
    private final SparseIntArray zzav = new SparseIntArray();

    public final int zzb(int i11) {
        synchronized (lock) {
            int i12 = this.zzau.get(i11, -1);
            if (i12 != -1) {
                return i12;
            }
            int i13 = zzat;
            zzat = i13 + 1;
            this.zzau.append(i11, i13);
            this.zzav.append(i13, i11);
            return i13;
        }
    }

    public final int zzc(int i11) {
        int i12;
        synchronized (lock) {
            i12 = this.zzav.get(i11);
        }
        return i12;
    }
}
