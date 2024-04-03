package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class zzud {
    public static final zztx zza = new zztx(0, C.TIME_UNSET, (zztw) null);
    public static final zztx zzb = new zztx(1, C.TIME_UNSET, (zztw) null);
    public static final zztx zzc = new zztx(2, C.TIME_UNSET, (zztw) null);
    public static final zztx zzd = new zztx(3, C.TIME_UNSET, (zztw) null);
    /* access modifiers changed from: private */
    public final ExecutorService zze = zzfn.zzL("ExoPlayer:Loader:ProgressiveMediaPeriod");
    /* access modifiers changed from: private */
    @Nullable
    public zzty<? extends zztz> zzf;
    /* access modifiers changed from: private */
    @Nullable
    public IOException zzg;

    public zzud(String str) {
    }

    public static zztx zzb(boolean z11, long j11) {
        return new zztx(z11 ? 1 : 0, j11, (zztw) null);
    }

    public final <T extends zztz> long zza(T t11, zztv<T> zztv, int i11) {
        Looper myLooper = Looper.myLooper();
        zzdy.zzb(myLooper);
        this.zzg = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new zzty(this, myLooper, t11, zztv, i11, elapsedRealtime).zzc(0);
        return elapsedRealtime;
    }

    public final void zzg() {
        zzty<? extends zztz> zzty = this.zzf;
        zzdy.zzb(zzty);
        zzty.zza(false);
    }

    public final void zzh() {
        this.zzg = null;
    }

    public final void zzi(int i11) throws IOException {
        IOException iOException = this.zzg;
        if (iOException == null) {
            zzty<? extends zztz> zzty = this.zzf;
            if (zzty != null) {
                zzty.zzb(i11);
                return;
            }
            return;
        }
        throw iOException;
    }

    public final void zzj(@Nullable zzua zzua) {
        zzty<? extends zztz> zzty = this.zzf;
        if (zzty != null) {
            zzty.zza(true);
        }
        this.zze.execute(new zzub(zzua));
        this.zze.shutdown();
    }

    public final boolean zzk() {
        return this.zzg != null;
    }

    public final boolean zzl() {
        return this.zzf != null;
    }
}
