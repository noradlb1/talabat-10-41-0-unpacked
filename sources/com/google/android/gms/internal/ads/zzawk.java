package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class zzawk {
    /* access modifiers changed from: private */
    public final ExecutorService zza = zzaxb.zzl("Loader:ExtractorMediaPeriod");
    /* access modifiers changed from: private */
    public zzawh<? extends zzawi> zzb;
    /* access modifiers changed from: private */
    public IOException zzc;

    public zzawk(String str) {
    }

    public final <T extends zzawi> long zza(T t11, zzawg<T> zzawg, int i11) {
        boolean z11;
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzawm.zze(z11);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new zzawh(this, myLooper, t11, zzawg, i11, elapsedRealtime).zzc(0);
        return elapsedRealtime;
    }

    public final void zzf() {
        this.zzb.zza(false);
    }

    public final void zzg(int i11) throws IOException {
        IOException iOException = this.zzc;
        if (iOException == null) {
            zzawh<? extends zzawi> zzawh = this.zzb;
            if (zzawh != null) {
                zzawh.zzb(zzawh.zza);
                return;
            }
            return;
        }
        throw iOException;
    }

    public final void zzh(Runnable runnable) {
        zzawh<? extends zzawi> zzawh = this.zzb;
        if (zzawh != null) {
            zzawh.zza(true);
        }
        this.zza.execute(runnable);
        this.zza.shutdown();
    }

    public final boolean zzi() {
        return this.zzb != null;
    }
}
