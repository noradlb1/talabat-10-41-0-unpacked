package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class zzeox implements zzdhm, zzdgf, zzdeu, zzdfl, zzbes, zzder, zzdhc, zzaop, zzdfh, zzdmd {
    @VisibleForTesting
    final BlockingQueue<Pair<String, String>> zza = new ArrayBlockingQueue(((Integer) zzbgq.zzc().zzb(zzblj.zzgx)).intValue());
    private final AtomicReference<zzbgx> zzb = new AtomicReference<>();
    private final AtomicReference<zzbhr> zzc = new AtomicReference<>();
    private final AtomicReference<zzbit> zzd = new AtomicReference<>();
    private final AtomicReference<zzbha> zze = new AtomicReference<>();
    private final AtomicReference<zzbhy> zzf = new AtomicReference<>();
    private final AtomicBoolean zzg = new AtomicBoolean(true);
    private final AtomicBoolean zzh = new AtomicBoolean(false);
    private final AtomicBoolean zzi = new AtomicBoolean(false);
    @Nullable
    private final zzfio zzj;

    public zzeox(@Nullable zzfio zzfio) {
        this.zzj = zzfio;
    }

    @TargetApi(5)
    private final void zzu() {
        if (this.zzh.get() && this.zzi.get()) {
            for (Pair<String, String> zzeof : this.zza) {
                zzfaq.zza(this.zzc, new zzeof(zzeof));
            }
            this.zza.clear();
            this.zzg.set(false);
        }
    }

    public final void onAdClicked() {
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzhm)).booleanValue()) {
            zzfaq.zza(this.zzb, zzeou.zza);
        }
    }

    public final void zza(zzbew zzbew) {
        zzfaq.zza(this.zzb, new zzeoo(zzbew));
        zzfaq.zza(this.zzb, new zzeop(zzbew));
        zzfaq.zza(this.zze, new zzeoq(zzbew));
        this.zzg.set(false);
        this.zza.clear();
    }

    public final synchronized zzbgx zzb() {
        return this.zzb.get();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
        return;
     */
    @android.annotation.TargetApi(5)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzbC(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.zzg     // Catch:{ all -> 0x0042 }
            boolean r0 = r0.get()     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0036
            java.util.concurrent.BlockingQueue<android.util.Pair<java.lang.String, java.lang.String>> r0 = r3.zza     // Catch:{ all -> 0x0042 }
            android.util.Pair r1 = new android.util.Pair     // Catch:{ all -> 0x0042 }
            r1.<init>(r4, r5)     // Catch:{ all -> 0x0042 }
            boolean r0 = r0.offer(r1)     // Catch:{ all -> 0x0042 }
            if (r0 != 0) goto L_0x0034
            java.lang.String r0 = "The queue for app events is full, dropping the new event."
            com.google.android.gms.internal.ads.zzciz.zze(r0)     // Catch:{ all -> 0x0042 }
            com.google.android.gms.internal.ads.zzfio r0 = r3.zzj     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0034
            java.lang.String r1 = "dae_action"
            com.google.android.gms.internal.ads.zzfin r1 = com.google.android.gms.internal.ads.zzfin.zzb(r1)     // Catch:{ all -> 0x0042 }
            java.lang.String r2 = "dae_name"
            r1.zza(r2, r4)     // Catch:{ all -> 0x0042 }
            java.lang.String r4 = "dae_data"
            r1.zza(r4, r5)     // Catch:{ all -> 0x0042 }
            r0.zzb(r1)     // Catch:{ all -> 0x0042 }
            monitor-exit(r3)
            return
        L_0x0034:
            monitor-exit(r3)
            return
        L_0x0036:
            java.util.concurrent.atomic.AtomicReference<com.google.android.gms.internal.ads.zzbhr> r0 = r3.zzc     // Catch:{ all -> 0x0042 }
            com.google.android.gms.internal.ads.zzeot r1 = new com.google.android.gms.internal.ads.zzeot     // Catch:{ all -> 0x0042 }
            r1.<init>(r4, r5)     // Catch:{ all -> 0x0042 }
            com.google.android.gms.internal.ads.zzfaq.zza(r0, r1)     // Catch:{ all -> 0x0042 }
            monitor-exit(r3)
            return
        L_0x0042:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeox.zzbC(java.lang.String, java.lang.String):void");
    }

    public final void zzbD() {
    }

    public final synchronized zzbhr zzc() {
        return this.zzc.get();
    }

    public final void zzd(zzcdq zzcdq) {
    }

    public final void zze(zzfdz zzfdz) {
        this.zzg.set(true);
        this.zzi.set(false);
    }

    public final void zzf(zzbgx zzbgx) {
        this.zzb.set(zzbgx);
    }

    public final void zzg(@NonNull zzbfk zzbfk) {
        zzfaq.zza(this.zzd, new zzeos(zzbfk));
    }

    public final void zzh(zzbha zzbha) {
        this.zze.set(zzbha);
    }

    public final void zzi(zzbit zzbit) {
        this.zzd.set(zzbit);
    }

    public final void zzj() {
        zzfaq.zza(this.zzb, zzeov.zza);
        zzfaq.zza(this.zzf, zzeol.zza);
    }

    public final void zzk(zzbew zzbew) {
        zzfaq.zza(this.zzf, new zzeor(zzbew));
    }

    public final void zzl() {
        zzfaq.zza(this.zzb, zzeow.zza);
    }

    public final void zzm() {
        zzfaq.zza(this.zzb, zzeog.zza);
    }

    public final synchronized void zzn() {
        zzfaq.zza(this.zzb, zzeoh.zza);
        zzfaq.zza(this.zze, zzeoj.zza);
        this.zzi.set(true);
        zzu();
    }

    public final void zzo() {
        zzfaq.zza(this.zzb, zzeoi.zza);
        zzfaq.zza(this.zzf, zzeon.zza);
        zzfaq.zza(this.zzf, zzeom.zza);
    }

    public final void zzp(zzceg zzceg, String str, String str2) {
    }

    public final void zzq() {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzhm)).booleanValue()) {
            zzfaq.zza(this.zzb, zzeou.zza);
        }
        zzfaq.zza(this.zzf, zzeok.zza);
    }

    public final void zzr() {
    }

    public final void zzs(zzbhr zzbhr) {
        this.zzc.set(zzbhr);
        this.zzh.set(true);
        zzu();
    }

    public final void zzt(zzbhy zzbhy) {
        this.zzf.set(zzbhy);
    }
}
