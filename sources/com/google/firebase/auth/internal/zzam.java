package com.google.firebase.auth.internal;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.p002firebaseauthapi.zzc;
import com.google.firebase.FirebaseApp;

public final class zzam {
    /* access modifiers changed from: private */
    public static final Logger zzg = new Logger("TokenRefresher", "FirebaseAuth:");
    @VisibleForTesting
    volatile long zza;
    @VisibleForTesting
    volatile long zzb;
    @VisibleForTesting
    final long zzc = 300000;
    @VisibleForTesting
    final HandlerThread zzd;
    @VisibleForTesting
    final Handler zze;
    @VisibleForTesting
    final Runnable zzf;
    private final FirebaseApp zzh;

    public zzam(FirebaseApp firebaseApp) {
        zzg.v("Initializing TokenRefresher", new Object[0]);
        FirebaseApp firebaseApp2 = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
        this.zzh = firebaseApp2;
        HandlerThread handlerThread = new HandlerThread("TokenRefresher", 10);
        this.zzd = handlerThread;
        handlerThread.start();
        this.zze = new zzc(handlerThread.getLooper());
        this.zzf = new zzal(this, firebaseApp2.getName());
    }

    public final void zzb() {
        this.zze.removeCallbacks(this.zzf);
    }

    public final void zzc() {
        Logger logger = zzg;
        long j11 = this.zza - this.zzc;
        logger.v("Scheduling refresh for " + j11, new Object[0]);
        zzb();
        this.zzb = Math.max((this.zza - DefaultClock.getInstance().currentTimeMillis()) - this.zzc, 0) / 1000;
        this.zze.postDelayed(this.zzf, this.zzb * 1000);
    }

    public final void zzd() {
        long j11;
        int i11 = (int) this.zzb;
        if (i11 == 30 || i11 == 60 || i11 == 120 || i11 == 240 || i11 == 480) {
            long j12 = this.zzb;
            j11 = j12 + j12;
        } else if (i11 != 960) {
            j11 = 30;
        } else {
            j11 = 960;
        }
        this.zzb = j11;
        this.zza = DefaultClock.getInstance().currentTimeMillis() + (this.zzb * 1000);
        Logger logger = zzg;
        long j13 = this.zza;
        logger.v("Scheduling refresh for " + j13, new Object[0]);
        this.zze.postDelayed(this.zzf, this.zzb * 1000);
    }
}
