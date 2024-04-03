package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

public final class zzepf extends zzbhj {
    private final zzbfi zza;
    private final Context zzb;
    private final zzfbq zzc;
    private final String zzd;
    private final zzeox zze;
    private final zzfcq zzf;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable
    public zzdmw zzg;
    @GuardedBy("this")
    private boolean zzh = ((Boolean) zzbgq.zzc().zzb(zzblj.zzaw)).booleanValue();

    public zzepf(Context context, zzbfi zzbfi, String str, zzfbq zzfbq, zzeox zzeox, zzfcq zzfcq) {
        this.zza = zzbfi;
        this.zzd = str;
        this.zzb = context;
        this.zzc = zzfbq;
        this.zze = zzeox;
        this.zzf = zzfcq;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean zze() {
        /*
            r1 = this;
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzdmw r0 = r1.zzg     // Catch:{ all -> 0x0011 }
            if (r0 == 0) goto L_0x000e
            boolean r0 = r0.zza()     // Catch:{ all -> 0x0011 }
            if (r0 != 0) goto L_0x000e
            monitor-exit(r1)
            r0 = 1
            return r0
        L_0x000e:
            monitor-exit(r1)
            r0 = 0
            return r0
        L_0x0011:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzepf.zze():boolean");
    }

    public final void zzA() {
    }

    public final synchronized void zzB() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        zzdmw zzdmw = this.zzg;
        if (zzdmw != null) {
            zzdmw.zzm().zzc((Context) null);
        }
    }

    public final void zzC(zzbgu zzbgu) {
    }

    public final void zzD(zzbgx zzbgx) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zze.zzf(zzbgx);
    }

    public final void zzE(zzbho zzbho) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    public final void zzF(zzbfi zzbfi) {
    }

    public final void zzG(zzbhr zzbhr) {
        Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        this.zze.zzs(zzbhr);
    }

    public final void zzH(zzazw zzazw) {
    }

    public final void zzI(zzbfo zzbfo) {
    }

    public final void zzJ(zzbhy zzbhy) {
        this.zze.zzt(zzbhy);
    }

    public final void zzK(zzbjd zzbjd) {
    }

    public final synchronized void zzL(boolean z11) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzh = z11;
    }

    public final void zzM(zzccb zzccb) {
    }

    public final void zzN(boolean z11) {
    }

    public final synchronized void zzO(zzbme zzbme) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzc.zzi(zzbme);
    }

    public final void zzP(zzbit zzbit) {
        Preconditions.checkMainThread("setPaidEventListener must be called on the main UI thread.");
        this.zze.zzi(zzbit);
    }

    public final void zzQ(zzcce zzcce, String str) {
    }

    public final void zzR(String str) {
    }

    public final void zzS(zzcem zzcem) {
        this.zzf.zzf(zzcem);
    }

    public final void zzT(String str) {
    }

    public final void zzU(zzbkq zzbkq) {
    }

    public final synchronized void zzW(IObjectWrapper iObjectWrapper) {
        if (this.zzg == null) {
            zzciz.zzj("Interstitial can not be shown before loaded.");
            this.zze.zzk(zzfey.zzd(9, (String) null, (zzbew) null));
            return;
        }
        this.zzg.zzc(this.zzh, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final synchronized void zzX() {
        Preconditions.checkMainThread("showInterstitial must be called on the main UI thread.");
        zzdmw zzdmw = this.zzg;
        if (zzdmw == null) {
            zzciz.zzj("Interstitial can not be shown before loaded.");
            this.zze.zzk(zzfey.zzd(9, (String) null, (zzbew) null));
            return;
        }
        zzdmw.zzc(this.zzh, (Activity) null);
    }

    public final synchronized boolean zzY() {
        return this.zzc.zza();
    }

    public final synchronized boolean zzZ() {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zze();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzaa(com.google.android.gms.internal.ads.zzbfd r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x0051 }
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x0051 }
            android.content.Context r0 = r4.zzb     // Catch:{ all -> 0x0051 }
            boolean r0 = com.google.android.gms.ads.internal.util.zzt.zzL(r0)     // Catch:{ all -> 0x0051 }
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x002a
            com.google.android.gms.internal.ads.zzbeu r0 = r5.zzs     // Catch:{ all -> 0x0051 }
            if (r0 != 0) goto L_0x002a
            java.lang.String r5 = "Failed to load the ad because app ID is missing."
            com.google.android.gms.internal.ads.zzciz.zzg(r5)     // Catch:{ all -> 0x0051 }
            com.google.android.gms.internal.ads.zzeox r5 = r4.zze     // Catch:{ all -> 0x0051 }
            if (r5 == 0) goto L_0x0028
            r0 = 4
            com.google.android.gms.internal.ads.zzbew r0 = com.google.android.gms.internal.ads.zzfey.zzd(r0, r2, r2)     // Catch:{ all -> 0x0051 }
            r5.zza(r0)     // Catch:{ all -> 0x0051 }
        L_0x0028:
            monitor-exit(r4)
            return r1
        L_0x002a:
            boolean r0 = r4.zze()     // Catch:{ all -> 0x0051 }
            if (r0 == 0) goto L_0x0032
            monitor-exit(r4)
            return r1
        L_0x0032:
            android.content.Context r0 = r4.zzb     // Catch:{ all -> 0x0051 }
            boolean r1 = r5.zzf     // Catch:{ all -> 0x0051 }
            com.google.android.gms.internal.ads.zzfeu.zza(r0, r1)     // Catch:{ all -> 0x0051 }
            r4.zzg = r2     // Catch:{ all -> 0x0051 }
            com.google.android.gms.internal.ads.zzfbq r0 = r4.zzc     // Catch:{ all -> 0x0051 }
            java.lang.String r1 = r4.zzd     // Catch:{ all -> 0x0051 }
            com.google.android.gms.internal.ads.zzfbj r2 = new com.google.android.gms.internal.ads.zzfbj     // Catch:{ all -> 0x0051 }
            com.google.android.gms.internal.ads.zzbfi r3 = r4.zza     // Catch:{ all -> 0x0051 }
            r2.<init>(r3)     // Catch:{ all -> 0x0051 }
            com.google.android.gms.internal.ads.zzepe r3 = new com.google.android.gms.internal.ads.zzepe     // Catch:{ all -> 0x0051 }
            r3.<init>(r4)     // Catch:{ all -> 0x0051 }
            boolean r5 = r0.zzb(r5, r1, r2, r3)     // Catch:{ all -> 0x0051 }
            monitor-exit(r4)
            return r5
        L_0x0051:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzepf.zzaa(com.google.android.gms.internal.ads.zzbfd):boolean");
    }

    public final void zzab(zzbhv zzbhv) {
    }

    public final Bundle zzd() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    public final zzbfi zzg() {
        return null;
    }

    public final zzbgx zzi() {
        return this.zze.zzb();
    }

    public final zzbhr zzj() {
        return this.zze.zzc();
    }

    public final synchronized zzbiw zzk() {
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzfi)).booleanValue()) {
            return null;
        }
        zzdmw zzdmw = this.zzg;
        if (zzdmw == null) {
            return null;
        }
        return zzdmw.zzl();
    }

    public final zzbiz zzl() {
        return null;
    }

    public final IObjectWrapper zzn() {
        return null;
    }

    public final synchronized String zzr() {
        return this.zzd;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String zzs() {
        /*
            r1 = this;
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzdmw r0 = r1.zzg     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x0017
            com.google.android.gms.internal.ads.zzdek r0 = r0.zzl()     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x0017
            com.google.android.gms.internal.ads.zzdmw r0 = r1.zzg     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.ads.zzdek r0 = r0.zzl()     // Catch:{ all -> 0x001a }
            java.lang.String r0 = r0.zze()     // Catch:{ all -> 0x001a }
            monitor-exit(r1)
            return r0
        L_0x0017:
            monitor-exit(r1)
            r0 = 0
            return r0
        L_0x001a:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzepf.zzs():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String zzt() {
        /*
            r1 = this;
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzdmw r0 = r1.zzg     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x0017
            com.google.android.gms.internal.ads.zzdek r0 = r0.zzl()     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x0017
            com.google.android.gms.internal.ads.zzdmw r0 = r1.zzg     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.ads.zzdek r0 = r0.zzl()     // Catch:{ all -> 0x001a }
            java.lang.String r0 = r0.zze()     // Catch:{ all -> 0x001a }
            monitor-exit(r1)
            return r0
        L_0x0017:
            monitor-exit(r1)
            r0 = 0
            return r0
        L_0x001a:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzepf.zzt():java.lang.String");
    }

    public final synchronized void zzx() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzdmw zzdmw = this.zzg;
        if (zzdmw != null) {
            zzdmw.zzm().zza((Context) null);
        }
    }

    public final void zzy(zzbfd zzbfd, zzbha zzbha) {
        this.zze.zzh(zzbha);
        zzaa(zzbfd);
    }

    public final synchronized void zzz() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        zzdmw zzdmw = this.zzg;
        if (zzdmw != null) {
            zzdmw.zzm().zzb((Context) null);
        }
    }
}
