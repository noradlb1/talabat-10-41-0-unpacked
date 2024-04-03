package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import javax.annotation.concurrent.GuardedBy;

public final class zzeoe extends zzbhj implements zzdhh {
    private final Context zza;
    private final zzezx zzb;
    private final String zzc;
    private final zzeox zzd;
    private zzbfi zze;
    @GuardedBy("this")
    private final zzfed zzf;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable
    public zzcyw zzg;

    public zzeoe(Context context, zzbfi zzbfi, String str, zzezx zzezx, zzeox zzeox) {
        this.zza = context;
        this.zzb = zzezx;
        this.zze = zzbfi;
        this.zzc = str;
        this.zzd = zzeox;
        this.zzf = zzezx.zzh();
        zzezx.zzo(this);
    }

    private final synchronized void zze(zzbfi zzbfi) {
        this.zzf.zzr(zzbfi);
        this.zzf.zzw(this.zze.zzn);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean zzf(com.google.android.gms.internal.ads.zzbfd r5) throws android.os.RemoteException {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x0040 }
            com.google.android.gms.ads.internal.zzt.zzp()     // Catch:{ all -> 0x0040 }
            android.content.Context r0 = r4.zza     // Catch:{ all -> 0x0040 }
            boolean r0 = com.google.android.gms.ads.internal.util.zzt.zzL(r0)     // Catch:{ all -> 0x0040 }
            r1 = 0
            if (r0 == 0) goto L_0x002a
            com.google.android.gms.internal.ads.zzbeu r0 = r5.zzs     // Catch:{ all -> 0x0040 }
            if (r0 != 0) goto L_0x002a
            java.lang.String r5 = "Failed to load the ad because app ID is missing."
            com.google.android.gms.internal.ads.zzciz.zzg(r5)     // Catch:{ all -> 0x0040 }
            com.google.android.gms.internal.ads.zzeox r5 = r4.zzd     // Catch:{ all -> 0x0040 }
            if (r5 == 0) goto L_0x0027
            r0 = 4
            com.google.android.gms.internal.ads.zzbew r0 = com.google.android.gms.internal.ads.zzfey.zzd(r0, r1, r1)     // Catch:{ all -> 0x0040 }
            r5.zza(r0)     // Catch:{ all -> 0x0040 }
        L_0x0027:
            monitor-exit(r4)
            r5 = 0
            return r5
        L_0x002a:
            android.content.Context r0 = r4.zza     // Catch:{ all -> 0x0040 }
            boolean r2 = r5.zzf     // Catch:{ all -> 0x0040 }
            com.google.android.gms.internal.ads.zzfeu.zza(r0, r2)     // Catch:{ all -> 0x0040 }
            com.google.android.gms.internal.ads.zzezx r0 = r4.zzb     // Catch:{ all -> 0x0040 }
            java.lang.String r2 = r4.zzc     // Catch:{ all -> 0x0040 }
            com.google.android.gms.internal.ads.zzeod r3 = new com.google.android.gms.internal.ads.zzeod     // Catch:{ all -> 0x0040 }
            r3.<init>(r4)     // Catch:{ all -> 0x0040 }
            boolean r5 = r0.zzb(r5, r2, r1, r3)     // Catch:{ all -> 0x0040 }
            monitor-exit(r4)
            return r5
        L_0x0040:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeoe.zzf(com.google.android.gms.internal.ads.zzbfd):boolean");
    }

    public final synchronized void zzA() {
        Preconditions.checkMainThread("recordManualImpression must be called on the main UI thread.");
        zzcyw zzcyw = this.zzg;
        if (zzcyw != null) {
            zzcyw.zzg();
        }
    }

    public final synchronized void zzB() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        zzcyw zzcyw = this.zzg;
        if (zzcyw != null) {
            zzcyw.zzm().zzc((Context) null);
        }
    }

    public final void zzC(zzbgu zzbgu) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzb.zzn(zzbgu);
    }

    public final void zzD(zzbgx zzbgx) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzd.zzf(zzbgx);
    }

    public final void zzE(zzbho zzbho) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    public final synchronized void zzF(zzbfi zzbfi) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        this.zzf.zzr(zzbfi);
        this.zze = zzbfi;
        zzcyw zzcyw = this.zzg;
        if (zzcyw != null) {
            zzcyw.zzh(this.zzb.zzd(), zzbfi);
        }
    }

    public final void zzG(zzbhr zzbhr) {
        Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        this.zzd.zzs(zzbhr);
    }

    public final void zzH(zzazw zzazw) {
    }

    public final void zzI(zzbfo zzbfo) {
    }

    public final void zzJ(zzbhy zzbhy) {
    }

    public final void zzK(zzbjd zzbjd) {
    }

    public final void zzL(boolean z11) {
    }

    public final void zzM(zzccb zzccb) {
    }

    public final synchronized void zzN(boolean z11) {
        Preconditions.checkMainThread("setManualImpressionsEnabled must be called from the main thread.");
        this.zzf.zzx(z11);
    }

    public final synchronized void zzO(zzbme zzbme) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzb.zzp(zzbme);
    }

    public final void zzP(zzbit zzbit) {
        Preconditions.checkMainThread("setPaidEventListener must be called on the main UI thread.");
        this.zzd.zzi(zzbit);
    }

    public final void zzQ(zzcce zzcce, String str) {
    }

    public final void zzR(String str) {
    }

    public final void zzS(zzcem zzcem) {
    }

    public final void zzT(String str) {
    }

    public final synchronized void zzU(zzbkq zzbkq) {
        Preconditions.checkMainThread("setVideoOptions must be called on the main UI thread.");
        this.zzf.zzE(zzbkq);
    }

    public final void zzW(IObjectWrapper iObjectWrapper) {
    }

    public final void zzX() {
    }

    public final synchronized boolean zzY() {
        return this.zzb.zza();
    }

    public final boolean zzZ() {
        return false;
    }

    public final synchronized void zza() {
        if (this.zzb.zzq()) {
            zzbfi zzg2 = this.zzf.zzg();
            zzcyw zzcyw = this.zzg;
            if (!(zzcyw == null || zzcyw.zzf() == null || !this.zzf.zzM())) {
                zzg2 = zzfej.zza(this.zza, Collections.singletonList(this.zzg.zzf()));
            }
            zze(zzg2);
            try {
                zzf(this.zzf.zze());
            } catch (RemoteException unused) {
                zzciz.zzj("Failed to refresh the banner ad.");
            }
        } else {
            this.zzb.zzm();
        }
    }

    public final synchronized boolean zzaa(zzbfd zzbfd) throws RemoteException {
        zze(this.zze);
        return zzf(zzbfd);
    }

    public final synchronized void zzab(zzbhv zzbhv) {
        Preconditions.checkMainThread("setCorrelationIdProvider must be called on the main UI thread");
        this.zzf.zzO(zzbhv);
    }

    public final Bundle zzd() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    public final synchronized zzbfi zzg() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        zzcyw zzcyw = this.zzg;
        if (zzcyw != null) {
            return zzfej.zza(this.zza, Collections.singletonList(zzcyw.zze()));
        }
        return this.zzf.zzg();
    }

    public final zzbgx zzi() {
        return this.zzd.zzb();
    }

    public final zzbhr zzj() {
        return this.zzd.zzc();
    }

    public final synchronized zzbiw zzk() {
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzfi)).booleanValue()) {
            return null;
        }
        zzcyw zzcyw = this.zzg;
        if (zzcyw == null) {
            return null;
        }
        return zzcyw.zzl();
    }

    public final synchronized zzbiz zzl() {
        Preconditions.checkMainThread("getVideoController must be called from the main thread.");
        zzcyw zzcyw = this.zzg;
        if (zzcyw == null) {
            return null;
        }
        return zzcyw.zzd();
    }

    public final IObjectWrapper zzn() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzb.zzd());
    }

    public final synchronized String zzr() {
        return this.zzc;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String zzs() {
        /*
            r1 = this;
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzcyw r0 = r1.zzg     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x0017
            com.google.android.gms.internal.ads.zzdek r0 = r0.zzl()     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x0017
            com.google.android.gms.internal.ads.zzcyw r0 = r1.zzg     // Catch:{ all -> 0x001a }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeoe.zzs():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String zzt() {
        /*
            r1 = this;
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzcyw r0 = r1.zzg     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x0017
            com.google.android.gms.internal.ads.zzdek r0 = r0.zzl()     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x0017
            com.google.android.gms.internal.ads.zzcyw r0 = r1.zzg     // Catch:{ all -> 0x001a }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeoe.zzt():java.lang.String");
    }

    public final synchronized void zzx() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzcyw zzcyw = this.zzg;
        if (zzcyw != null) {
            zzcyw.zzT();
        }
    }

    public final void zzy(zzbfd zzbfd, zzbha zzbha) {
    }

    public final synchronized void zzz() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        zzcyw zzcyw = this.zzg;
        if (zzcyw != null) {
            zzcyw.zzm().zzb((Context) null);
        }
    }
}
