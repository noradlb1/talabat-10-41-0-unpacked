package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.PlaybackException;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class zzalm implements zzalp {
    @Nullable
    private static zzalm zzb;
    @VisibleForTesting
    volatile long zza = 0;
    private final Context zzc;
    private final zzfnw zzd;
    private final zzfod zze;
    private final zzfof zzf;
    private final zzamm zzg;
    /* access modifiers changed from: private */
    public final zzfmh zzh;
    private final Executor zzi;
    private final zzfoc zzj;
    private final CountDownLatch zzk;
    /* access modifiers changed from: private */
    public final Object zzl = new Object();
    /* access modifiers changed from: private */
    public volatile boolean zzm;
    private volatile boolean zzn = false;
    private final int zzo;

    @VisibleForTesting
    public zzalm(@NonNull Context context, @NonNull zzfmh zzfmh, @NonNull zzfnw zzfnw, @NonNull zzfod zzfod, @NonNull zzfof zzfof, @NonNull zzamm zzamm, @NonNull Executor executor, @NonNull zzfmc zzfmc, int i11) {
        this.zzc = context;
        this.zzh = zzfmh;
        this.zzd = zzfnw;
        this.zze = zzfod;
        this.zzf = zzfof;
        this.zzg = zzamm;
        this.zzi = executor;
        this.zzo = i11;
        this.zzk = new CountDownLatch(1);
        this.zzj = new zzalk(this, zzfmc);
    }

    public static synchronized zzalm zza(@NonNull String str, @NonNull Context context, boolean z11, boolean z12) {
        zzalm zzb2;
        synchronized (zzalm.class) {
            zzb2 = zzb(str, context, Executors.newCachedThreadPool(), z11, z12);
        }
        return zzb2;
    }

    @Deprecated
    public static synchronized zzalm zzb(@NonNull String str, @NonNull Context context, @NonNull Executor executor, boolean z11, boolean z12) {
        zzalm zzalm;
        zzalw zzalw;
        Context context2 = context;
        Executor executor2 = executor;
        synchronized (zzalm.class) {
            if (zzb == null) {
                zzfmi zza2 = zzfmj.zza();
                String str2 = str;
                zza2.zza(str);
                zza2.zzc(z11);
                zzfmj zzd2 = zza2.zzd();
                zzfmh zza3 = zzfmh.zza(context2, executor2, z12);
                if (((Boolean) zzbgq.zzc().zzb(zzblj.zzcc)).booleanValue()) {
                    zzalw = zzalw.zzc(context);
                } else {
                    zzalw = null;
                }
                zzfna zze2 = zzfna.zze(context2, executor2, zza3, zzd2);
                zzaml zzaml = new zzaml(context2);
                zzamm zzamm = new zzamm(zzd2, zze2, new zzamz(context2, zzaml), zzaml, zzalw);
                int zzb2 = zzfnj.zzb(context2, zza3);
                zzfmc zzfmc = new zzfmc();
                zzalm zzalm2 = new zzalm(context, zza3, new zzfnw(context2, zzb2), new zzfod(context2, zzb2, new zzalj(zza3), ((Boolean) zzbgq.zzc().zzb(zzblj.zzbB)).booleanValue()), new zzfof(context2, zzamm, zza3, zzfmc), zzamm, executor, zzfmc, zzb2);
                zzb = zzalm2;
                zzalm2.zzm();
                zzb.zzo();
            }
            zzalm = zzb;
        }
        return zzalm;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0099, code lost:
        if (r4.zzd().zzj().equals(r5.zzj()) != false) goto L_0x00fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r12.zzh.zzd(com.instabug.library.internal.video.RequestPermissionActivity.REQUEST_MEDIA_PROJECTION_PERMISSION, java.lang.System.currentTimeMillis() - r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0116, code lost:
        r12 = r12.zzk;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x010a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* bridge */ /* synthetic */ void zzj(com.google.android.gms.internal.ads.zzalm r12) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 1
            com.google.android.gms.internal.ads.zzfnv r3 = r12.zzr(r2)
            if (r3 == 0) goto L_0x001e
            com.google.android.gms.internal.ads.zzaoi r4 = r3.zza()
            java.lang.String r4 = r4.zzk()
            com.google.android.gms.internal.ads.zzaoi r3 = r3.zza()
            java.lang.String r3 = r3.zzj()
            r9 = r3
            r8 = r4
            goto L_0x0021
        L_0x001e:
            r4 = 0
            r8 = r4
            r9 = r8
        L_0x0021:
            android.content.Context r5 = r12.zzc     // Catch:{ zzgkx -> 0x012a }
            r6 = 1
            int r7 = r12.zzo     // Catch:{ zzgkx -> 0x012a }
            java.lang.String r10 = "1"
            com.google.android.gms.internal.ads.zzfmh r11 = r12.zzh     // Catch:{ zzgkx -> 0x012a }
            com.google.android.gms.internal.ads.zzfoa r3 = com.google.android.gms.internal.ads.zzfmr.zza(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ zzgkx -> 0x012a }
            byte[] r4 = r3.zzb     // Catch:{ zzgkx -> 0x012a }
            if (r4 == 0) goto L_0x0119
            int r5 = r4.length     // Catch:{ zzgkx -> 0x012a }
            if (r5 != 0) goto L_0x0037
            goto L_0x0119
        L_0x0037:
            com.google.android.gms.internal.ads.zzgjf r4 = com.google.android.gms.internal.ads.zzgjf.zzv(r4)     // Catch:{ NullPointerException -> 0x010a }
            com.google.android.gms.internal.ads.zzgjx r5 = com.google.android.gms.internal.ads.zzgjx.zza()     // Catch:{ NullPointerException -> 0x010a }
            com.google.android.gms.internal.ads.zzaof r4 = com.google.android.gms.internal.ads.zzaof.zzc(r4, r5)     // Catch:{ NullPointerException -> 0x010a }
            com.google.android.gms.internal.ads.zzaoi r5 = r4.zzd()     // Catch:{ zzgkx -> 0x012a }
            java.lang.String r5 = r5.zzk()     // Catch:{ zzgkx -> 0x012a }
            boolean r5 = r5.isEmpty()     // Catch:{ zzgkx -> 0x012a }
            if (r5 != 0) goto L_0x00fb
            com.google.android.gms.internal.ads.zzaoi r5 = r4.zzd()     // Catch:{ zzgkx -> 0x012a }
            java.lang.String r5 = r5.zzj()     // Catch:{ zzgkx -> 0x012a }
            boolean r5 = r5.isEmpty()     // Catch:{ zzgkx -> 0x012a }
            if (r5 != 0) goto L_0x00fb
            com.google.android.gms.internal.ads.zzgjf r5 = r4.zze()     // Catch:{ zzgkx -> 0x012a }
            byte[] r5 = r5.zzE()     // Catch:{ zzgkx -> 0x012a }
            int r5 = r5.length     // Catch:{ zzgkx -> 0x012a }
            if (r5 != 0) goto L_0x006c
            goto L_0x00fb
        L_0x006c:
            com.google.android.gms.internal.ads.zzfnv r5 = r12.zzr(r2)     // Catch:{ zzgkx -> 0x012a }
            if (r5 != 0) goto L_0x0073
            goto L_0x009b
        L_0x0073:
            com.google.android.gms.internal.ads.zzaoi r5 = r5.zza()     // Catch:{ zzgkx -> 0x012a }
            com.google.android.gms.internal.ads.zzaoi r6 = r4.zzd()     // Catch:{ zzgkx -> 0x012a }
            java.lang.String r6 = r6.zzk()     // Catch:{ zzgkx -> 0x012a }
            java.lang.String r7 = r5.zzk()     // Catch:{ zzgkx -> 0x012a }
            boolean r6 = r6.equals(r7)     // Catch:{ zzgkx -> 0x012a }
            if (r6 == 0) goto L_0x009b
            com.google.android.gms.internal.ads.zzaoi r6 = r4.zzd()     // Catch:{ zzgkx -> 0x012a }
            java.lang.String r6 = r6.zzj()     // Catch:{ zzgkx -> 0x012a }
            java.lang.String r5 = r5.zzj()     // Catch:{ zzgkx -> 0x012a }
            boolean r5 = r6.equals(r5)     // Catch:{ zzgkx -> 0x012a }
            if (r5 != 0) goto L_0x00fb
        L_0x009b:
            com.google.android.gms.internal.ads.zzfoc r5 = r12.zzj     // Catch:{ zzgkx -> 0x012a }
            int r3 = r3.zzc     // Catch:{ zzgkx -> 0x012a }
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r6 = com.google.android.gms.internal.ads.zzblj.zzbz     // Catch:{ zzgkx -> 0x012a }
            com.google.android.gms.internal.ads.zzblh r7 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ zzgkx -> 0x012a }
            java.lang.Object r6 = r7.zzb(r6)     // Catch:{ zzgkx -> 0x012a }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ zzgkx -> 0x012a }
            boolean r6 = r6.booleanValue()     // Catch:{ zzgkx -> 0x012a }
            if (r6 == 0) goto L_0x00c5
            r6 = 3
            if (r3 != r6) goto L_0x00bb
            com.google.android.gms.internal.ads.zzfod r3 = r12.zze     // Catch:{ zzgkx -> 0x012a }
            boolean r3 = r3.zza(r4)     // Catch:{ zzgkx -> 0x012a }
            goto L_0x00cb
        L_0x00bb:
            r6 = 4
            if (r3 != r6) goto L_0x00cd
            com.google.android.gms.internal.ads.zzfod r3 = r12.zze     // Catch:{ zzgkx -> 0x012a }
            boolean r3 = r3.zzb(r4, r5)     // Catch:{ zzgkx -> 0x012a }
            goto L_0x00cb
        L_0x00c5:
            com.google.android.gms.internal.ads.zzfnw r3 = r12.zzd     // Catch:{ zzgkx -> 0x012a }
            boolean r3 = r3.zzb(r4, r5)     // Catch:{ zzgkx -> 0x012a }
        L_0x00cb:
            if (r3 != 0) goto L_0x00df
        L_0x00cd:
            com.google.android.gms.internal.ads.zzfmh r2 = r12.zzh     // Catch:{ zzgkx -> 0x012a }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ zzgkx -> 0x012a }
            long r3 = r3 - r0
            r5 = 4009(0xfa9, float:5.618E-42)
            r2.zzd(r5, r3)     // Catch:{ zzgkx -> 0x012a }
            java.util.concurrent.CountDownLatch r12 = r12.zzk
        L_0x00db:
            r12.countDown()
            return
        L_0x00df:
            com.google.android.gms.internal.ads.zzfnv r3 = r12.zzr(r2)     // Catch:{ zzgkx -> 0x012a }
            if (r3 == 0) goto L_0x00f8
            com.google.android.gms.internal.ads.zzfof r4 = r12.zzf     // Catch:{ zzgkx -> 0x012a }
            boolean r3 = r4.zzc(r3)     // Catch:{ zzgkx -> 0x012a }
            if (r3 == 0) goto L_0x00ef
            r12.zzn = r2     // Catch:{ zzgkx -> 0x012a }
        L_0x00ef:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ zzgkx -> 0x012a }
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r4
            r12.zza = r2     // Catch:{ zzgkx -> 0x012a }
        L_0x00f8:
            java.util.concurrent.CountDownLatch r12 = r12.zzk
            goto L_0x00db
        L_0x00fb:
            com.google.android.gms.internal.ads.zzfmh r2 = r12.zzh     // Catch:{ zzgkx -> 0x012a }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ zzgkx -> 0x012a }
            long r3 = r3 - r0
            r5 = 5010(0x1392, float:7.02E-42)
            r2.zzd(r5, r3)     // Catch:{ zzgkx -> 0x012a }
            java.util.concurrent.CountDownLatch r12 = r12.zzk
            goto L_0x00db
        L_0x010a:
            com.google.android.gms.internal.ads.zzfmh r2 = r12.zzh     // Catch:{ zzgkx -> 0x012a }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ zzgkx -> 0x012a }
            long r3 = r3 - r0
            r5 = 2030(0x7ee, float:2.845E-42)
            r2.zzd(r5, r3)     // Catch:{ zzgkx -> 0x012a }
            java.util.concurrent.CountDownLatch r12 = r12.zzk
            goto L_0x00db
        L_0x0119:
            com.google.android.gms.internal.ads.zzfmh r2 = r12.zzh     // Catch:{ zzgkx -> 0x012a }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ zzgkx -> 0x012a }
            long r3 = r3 - r0
            r5 = 5009(0x1391, float:7.019E-42)
            r2.zzd(r5, r3)     // Catch:{ zzgkx -> 0x012a }
            java.util.concurrent.CountDownLatch r12 = r12.zzk
            goto L_0x00db
        L_0x0128:
            r0 = move-exception
            goto L_0x013a
        L_0x012a:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzfmh r3 = r12.zzh     // Catch:{ all -> 0x0128 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0128 }
            long r4 = r4 - r0
            r0 = 4002(0xfa2, float:5.608E-42)
            r3.zzc(r0, r4, r2)     // Catch:{ all -> 0x0128 }
            java.util.concurrent.CountDownLatch r12 = r12.zzk
            goto L_0x00db
        L_0x013a:
            java.util.concurrent.CountDownLatch r12 = r12.zzk
            r12.countDown()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalm.zzj(com.google.android.gms.internal.ads.zzalm):void");
    }

    private final zzfnv zzr(int i11) {
        if (!zzfnj.zza(this.zzo)) {
            return null;
        }
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzbz)).booleanValue()) {
            return this.zze.zzc(1);
        }
        return this.zzd.zzd(1);
    }

    public final String zze(Context context, String str, View view) {
        return zzf(context, str, view, (Activity) null);
    }

    public final String zzf(Context context, String str, View view, Activity activity) {
        zzo();
        zzfmk zza2 = this.zzf.zza();
        if (zza2 == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zza3 = zza2.zza(context, (String) null, str, view, activity);
        this.zzh.zzf(5000, System.currentTimeMillis() - currentTimeMillis, zza3, (Map<String, String>) null);
        return zza3;
    }

    public final String zzg(Context context) {
        zzo();
        zzfmk zza2 = this.zzf.zza();
        if (zza2 == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzc2 = zza2.zzc(context, (String) null);
        this.zzh.zzf(PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED, System.currentTimeMillis() - currentTimeMillis, zzc2, (Map<String, String>) null);
        return zzc2;
    }

    public final String zzh(Context context, View view, Activity activity) {
        zzo();
        zzfmk zza2 = this.zzf.zza();
        if (zza2 == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzb2 = zza2.zzb(context, (String) null, view, (Activity) null);
        this.zzh.zzf(PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED, System.currentTimeMillis() - currentTimeMillis, zzb2, (Map<String, String>) null);
        return zzb2;
    }

    public final void zzk(MotionEvent motionEvent) {
        zzfmk zza2 = this.zzf.zza();
        if (zza2 != null) {
            try {
                zza2.zzd((String) null, motionEvent);
            } catch (zzfoe e11) {
                this.zzh.zzc(e11.zza(), -1, e11);
            }
        }
    }

    public final void zzl(int i11, int i12, int i13) {
    }

    public final synchronized void zzm() {
        long currentTimeMillis = System.currentTimeMillis();
        zzfnv zzr = zzr(1);
        if (zzr == null) {
            this.zzh.zzd(4013, System.currentTimeMillis() - currentTimeMillis);
        } else if (this.zzf.zzc(zzr)) {
            this.zzn = true;
            this.zzk.countDown();
        }
    }

    public final void zzn(View view) {
        this.zzg.zzd(view);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzo() {
        /*
            r5 = this;
            boolean r0 = r5.zzm
            if (r0 != 0) goto L_0x0042
            java.lang.Object r0 = r5.zzl
            monitor-enter(r0)
            boolean r1 = r5.zzm     // Catch:{ all -> 0x003f }
            if (r1 != 0) goto L_0x003d
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x003f }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r3
            long r3 = r5.zza     // Catch:{ all -> 0x003f }
            long r1 = r1 - r3
            r3 = 3600(0xe10, double:1.7786E-320)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x001d
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x001d:
            com.google.android.gms.internal.ads.zzfof r1 = r5.zzf     // Catch:{ all -> 0x003f }
            com.google.android.gms.internal.ads.zzfnv r1 = r1.zzb()     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x002b
            boolean r1 = r1.zzd(r3)     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x003d
        L_0x002b:
            int r1 = r5.zzo     // Catch:{ all -> 0x003f }
            boolean r1 = com.google.android.gms.internal.ads.zzfnj.zza(r1)     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x003d
            java.util.concurrent.Executor r1 = r5.zzi     // Catch:{ all -> 0x003f }
            com.google.android.gms.internal.ads.zzall r2 = new com.google.android.gms.internal.ads.zzall     // Catch:{ all -> 0x003f }
            r2.<init>(r5)     // Catch:{ all -> 0x003f }
            r1.execute(r2)     // Catch:{ all -> 0x003f }
        L_0x003d:
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x003f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            throw r1
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalm.zzo():void");
    }

    public final synchronized boolean zzq() {
        return this.zzn;
    }
}
