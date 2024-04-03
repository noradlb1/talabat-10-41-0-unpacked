package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.lang.Exception;

final class zzml<T extends Exception> {
    @Nullable
    private T zza;
    private long zzb;

    public zzml(long j11) {
    }

    public final void zza() {
        this.zza = null;
    }

    public final void zzb(T t11) throws Exception {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zza == null) {
            this.zza = t11;
            this.zzb = 100 + elapsedRealtime;
        }
        if (elapsedRealtime >= this.zzb) {
            T t12 = this.zza;
            this.zza = null;
            throw t12;
        }
    }
}
