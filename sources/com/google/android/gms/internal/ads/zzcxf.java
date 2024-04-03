package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

public final class zzcxf implements zzaya, zzdfm, zzo, zzdfl {
    private final zzcxa zza;
    private final zzcxb zzb;
    private final Set<zzcop> zzc = new HashSet();
    private final zzbwt<JSONObject, JSONObject> zzd;
    private final Executor zze;
    private final Clock zzf;
    private final AtomicBoolean zzg = new AtomicBoolean(false);
    @GuardedBy("this")
    private final zzcxe zzh = new zzcxe();
    private boolean zzi = false;
    private WeakReference<?> zzj = new WeakReference<>(this);

    public zzcxf(zzbwq zzbwq, zzcxb zzcxb, Executor executor, zzcxa zzcxa, Clock clock) {
        this.zza = zzcxa;
        zzbwb<JSONObject> zzbwb = zzbwe.zza;
        this.zzd = zzbwq.zza("google.afma.activeView.handleUpdate", zzbwb, zzbwb);
        this.zzb = zzcxb;
        this.zze = executor;
        this.zzf = clock;
    }

    private final void zzk() {
        for (zzcop zzf2 : this.zzc) {
            this.zza.zzf(zzf2);
        }
        this.zza.zze();
    }

    public final void zzb() {
    }

    public final synchronized void zzbA(@Nullable Context context) {
        this.zzh.zzb = true;
        zzg();
    }

    public final synchronized void zzbB(@Nullable Context context) {
        this.zzh.zzb = false;
        zzg();
    }

    public final void zzbK() {
    }

    public final synchronized void zzbS() {
        this.zzh.zzb = false;
        zzg();
    }

    public final synchronized void zzby(@Nullable Context context) {
        this.zzh.zze = "u";
        zzg();
        zzk();
        this.zzi = true;
    }

    public final synchronized void zzbz() {
        this.zzh.zzb = true;
        zzg();
    }

    public final synchronized void zzc(zzaxz zzaxz) {
        zzcxe zzcxe = this.zzh;
        zzcxe.zza = zzaxz.zzj;
        zzcxe.zzf = zzaxz;
        zzg();
    }

    public final void zze() {
    }

    public final void zzf(int i11) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzg() {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.ref.WeakReference<?> r0 = r5.zzj     // Catch:{ all -> 0x0060 }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0060 }
            if (r0 == 0) goto L_0x005b
            boolean r0 = r5.zzi     // Catch:{ all -> 0x0060 }
            if (r0 != 0) goto L_0x0059
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.zzg     // Catch:{ all -> 0x0060 }
            boolean r0 = r0.get()     // Catch:{ all -> 0x0060 }
            if (r0 == 0) goto L_0x0059
            com.google.android.gms.internal.ads.zzcxe r0 = r5.zzh     // Catch:{ Exception -> 0x0051 }
            com.google.android.gms.common.util.Clock r1 = r5.zzf     // Catch:{ Exception -> 0x0051 }
            long r1 = r1.elapsedRealtime()     // Catch:{ Exception -> 0x0051 }
            r0.zzd = r1     // Catch:{ Exception -> 0x0051 }
            com.google.android.gms.internal.ads.zzcxb r0 = r5.zzb     // Catch:{ Exception -> 0x0051 }
            com.google.android.gms.internal.ads.zzcxe r1 = r5.zzh     // Catch:{ Exception -> 0x0051 }
            org.json.JSONObject r0 = r0.zzb(r1)     // Catch:{ Exception -> 0x0051 }
            java.util.Set<com.google.android.gms.internal.ads.zzcop> r1 = r5.zzc     // Catch:{ Exception -> 0x0051 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0051 }
        L_0x002d:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x0051 }
            if (r2 == 0) goto L_0x0044
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x0051 }
            com.google.android.gms.internal.ads.zzcop r2 = (com.google.android.gms.internal.ads.zzcop) r2     // Catch:{ Exception -> 0x0051 }
            java.util.concurrent.Executor r3 = r5.zze     // Catch:{ Exception -> 0x0051 }
            com.google.android.gms.internal.ads.zzcxd r4 = new com.google.android.gms.internal.ads.zzcxd     // Catch:{ Exception -> 0x0051 }
            r4.<init>(r2, r0)     // Catch:{ Exception -> 0x0051 }
            r3.execute(r4)     // Catch:{ Exception -> 0x0051 }
            goto L_0x002d
        L_0x0044:
            com.google.android.gms.internal.ads.zzbwt<org.json.JSONObject, org.json.JSONObject> r1 = r5.zzd     // Catch:{ Exception -> 0x0051 }
            com.google.android.gms.internal.ads.zzfxa r0 = r1.zzb(r0)     // Catch:{ Exception -> 0x0051 }
            java.lang.String r1 = "ActiveViewListener.callActiveViewJs"
            com.google.android.gms.internal.ads.zzcjp.zzb(r0, r1)     // Catch:{ Exception -> 0x0051 }
            monitor-exit(r5)
            return
        L_0x0051:
            r0 = move-exception
            java.lang.String r1 = "Failed to call ActiveViewJS"
            com.google.android.gms.ads.internal.util.zze.zzb(r1, r0)     // Catch:{ all -> 0x0060 }
            monitor-exit(r5)
            return
        L_0x0059:
            monitor-exit(r5)
            return
        L_0x005b:
            r5.zzj()     // Catch:{ all -> 0x0060 }
            monitor-exit(r5)
            return
        L_0x0060:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcxf.zzg():void");
    }

    public final synchronized void zzh(zzcop zzcop) {
        this.zzc.add(zzcop);
        this.zza.zzd(zzcop);
    }

    public final void zzi(Object obj) {
        this.zzj = new WeakReference<>(obj);
    }

    public final synchronized void zzj() {
        zzk();
        this.zzi = true;
    }

    public final synchronized void zzl() {
        if (this.zzg.compareAndSet(false, true)) {
            this.zza.zzc(this);
            zzg();
        }
    }
}
