package com.google.android.gms.internal.ads;

import java.util.Set;
import javax.annotation.CheckForNull;

final class zzfvu extends zzfvr {
    private zzfvu() {
        super((zzfvq) null);
    }

    public /* synthetic */ zzfvu(zzfvt zzfvt) {
        super((zzfvq) null);
    }

    public final int zza(zzfvv<?> zzfvv) {
        int zzB;
        synchronized (zzfvv) {
            zzB = zzfvv.remaining - 1;
            zzfvv.remaining = zzB;
        }
        return zzB;
    }

    public final void zzb(zzfvv<?> zzfvv, @CheckForNull Set<Throwable> set, Set<Throwable> set2) {
        synchronized (zzfvv) {
            if (zzfvv.seenExceptions == null) {
                zzfvv.seenExceptions = set2;
            }
        }
    }
}
