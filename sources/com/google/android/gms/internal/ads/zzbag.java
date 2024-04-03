package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

public final class zzbag {
    private final Runnable zza = new zzbac(this);
    /* access modifiers changed from: private */
    public final Object zzb = new Object();
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    @Nullable
    public zzbaj zzc;
    @GuardedBy("lock")
    @Nullable
    private Context zzd;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    @Nullable
    public zzbam zze;

    public static /* bridge */ /* synthetic */ void zzh(zzbag zzbag) {
        synchronized (zzbag.zzb) {
            zzbaj zzbaj = zzbag.zzc;
            if (zzbaj != null) {
                if (zzbaj.isConnected() || zzbag.zzc.isConnecting()) {
                    zzbag.zzc.disconnect();
                }
                zzbag.zzc = null;
                zzbag.zze = null;
                Binder.flushPendingCommands();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzl() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.zzb
            monitor-enter(r0)
            android.content.Context r1 = r3.zzd     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x0021
            com.google.android.gms.internal.ads.zzbaj r1 = r3.zzc     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x000c
            goto L_0x0021
        L_0x000c:
            com.google.android.gms.internal.ads.zzbae r1 = new com.google.android.gms.internal.ads.zzbae     // Catch:{ all -> 0x0023 }
            r1.<init>(r3)     // Catch:{ all -> 0x0023 }
            com.google.android.gms.internal.ads.zzbaf r2 = new com.google.android.gms.internal.ads.zzbaf     // Catch:{ all -> 0x0023 }
            r2.<init>(r3)     // Catch:{ all -> 0x0023 }
            com.google.android.gms.internal.ads.zzbaj r1 = r3.zzd(r1, r2)     // Catch:{ all -> 0x0023 }
            r3.zzc = r1     // Catch:{ all -> 0x0023 }
            r1.checkAvailabilityAndConnect()     // Catch:{ all -> 0x0023 }
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            return
        L_0x0021:
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            return
        L_0x0023:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbag.zzl():void");
    }

    public final long zza(zzbak zzbak) {
        synchronized (this.zzb) {
            if (this.zze == null) {
                return -2;
            }
            if (this.zzc.zzp()) {
                try {
                    long zze2 = this.zze.zze(zzbak);
                    return zze2;
                } catch (RemoteException e11) {
                    zzciz.zzh("Unable to call into cache service.", e11);
                    return -2;
                }
            }
        }
    }

    public final zzbah zzb(zzbak zzbak) {
        synchronized (this.zzb) {
            if (this.zze == null) {
                zzbah zzbah = new zzbah();
                return zzbah;
            }
            try {
                if (this.zzc.zzp()) {
                    zzbah zzg = this.zze.zzg(zzbak);
                    return zzg;
                }
                zzbah zzf = this.zze.zzf(zzbak);
                return zzf;
            } catch (RemoteException e11) {
                zzciz.zzh("Unable to call into cache service.", e11);
                return new zzbah();
            }
        }
    }

    @VisibleForTesting
    public final synchronized zzbaj zzd(BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zzbaj(this.zzd, zzt.zzt().zzb(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzi(android.content.Context r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.Object r0 = r2.zzb
            monitor-enter(r0)
            android.content.Context r1 = r2.zzd     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x000c:
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x0048 }
            r2.zzd = r3     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzblj.zzcL     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzblh r1 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ all -> 0x0048 }
            java.lang.Object r3 = r1.zzb(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0028
            r2.zzl()     // Catch:{ all -> 0x0048 }
            goto L_0x0046
        L_0x0028:
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzblj.zzcK     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzblh r1 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ all -> 0x0048 }
            java.lang.Object r3 = r1.zzb(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0046
            com.google.android.gms.internal.ads.zzbad r3 = new com.google.android.gms.internal.ads.zzbad     // Catch:{ all -> 0x0048 }
            r3.<init>(r2)     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzayu r1 = com.google.android.gms.ads.internal.zzt.zzb()     // Catch:{ all -> 0x0048 }
            r1.zzc(r3)     // Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x0048:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbag.zzi(android.content.Context):void");
    }

    public final void zzj() {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzcM)).booleanValue()) {
            synchronized (this.zzb) {
                zzl();
                zzfpj zzfpj = com.google.android.gms.ads.internal.util.zzt.zza;
                zzfpj.removeCallbacks(this.zza);
                zzfpj.postDelayed(this.zza, ((Long) zzbgq.zzc().zzb(zzblj.zzcN)).longValue());
            }
        }
    }
}
