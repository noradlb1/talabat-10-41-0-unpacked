package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.ads.internal.util.zzt;

@TargetApi(16)
public final class zzcno extends zzcnf implements zzckx {
    public static final /* synthetic */ int zzd = 0;
    private zzcky zze;
    private String zzf;
    private boolean zzg;
    private boolean zzh;
    private zzcmx zzi;
    private long zzj;
    private long zzk;

    public zzcno(zzclh zzclh, zzclg zzclg) {
        super(zzclh);
        zzcky zzcky;
        Context context = zzclh.getContext();
        if (zzclg.zzm) {
            zzcky = new zzcof(context, zzclg, this.zzc.get());
        } else {
            zzcky = new zzcmn(context, zzclg, this.zzc.get());
        }
        this.zze = zzcky;
        zzcky.zzG(this);
    }

    public static final String zzu(String str) {
        String valueOf = String.valueOf(zzcis.zze(str));
        if (valueOf.length() != 0) {
            return "cache:".concat(valueOf);
        }
        return new String("cache:");
    }

    private static String zzw(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        int length = String.valueOf(canonicalName).length();
        StringBuilder sb2 = new StringBuilder(str.length() + 2 + length + String.valueOf(message).length());
        sb2.append(str);
        sb2.append("/");
        sb2.append(canonicalName);
        sb2.append(CertificateUtil.DELIMITER);
        sb2.append(message);
        return sb2.toString();
    }

    private final void zzx(long j11) {
        zzt.zza.postDelayed(new zzcnn(this), j11);
    }

    public final void release() {
        zzcky zzcky = this.zze;
        if (zzcky != null) {
            zzcky.zzG((zzckx) null);
            this.zze.zzC();
        }
    }

    public final void zzC(int i11, int i12) {
    }

    public final void zzb() {
        synchronized (this) {
            this.zzg = true;
            notify();
            release();
        }
        String str = this.zzf;
        if (str != null) {
            zzc(this.zzf, zzu(str), "externalAbort", "Programmatic precache abort.");
        }
    }

    public final void zzh(int i11) {
        this.zze.zzE(i11);
    }

    public final void zzi(boolean z11, long j11) {
        zzclh zzclh = this.zzc.get();
        if (zzclh != null) {
            zzcjm.zze.execute(new zzcnm(zzclh, z11, j11));
        }
    }

    public final zzcky zzj() {
        synchronized (this) {
            this.zzh = true;
            notify();
        }
        this.zze.zzG((zzckx) null);
        zzcky zzcky = this.zze;
        this.zze = null;
        return zzcky;
    }

    public final void zzk(String str, Exception exc) {
        zzciz.zzk("Precache error", exc);
        com.google.android.gms.ads.internal.zzt.zzo().zzr(exc, "VideoStreamExoPlayerCache.onError");
    }

    public final void zzl(String str, Exception exc) {
        zzciz.zzk("Precache exception", exc);
        com.google.android.gms.ads.internal.zzt.zzo().zzr(exc, "VideoStreamExoPlayerCache.onException");
    }

    public final void zzm(int i11) {
    }

    public final void zzn(int i11) {
        this.zze.zzF(i11);
    }

    public final void zzo(int i11) {
        this.zze.zzH(i11);
    }

    public final void zzp(int i11) {
        this.zze.zzI(i11);
    }

    public final boolean zzq(String str) {
        return zzr(str, new String[]{str});
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x009e, code lost:
        r5 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x013a, code lost:
        r5 = r45;
        r6 = r46;
        r7 = r44;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r5.zze(r6, r7, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzr(java.lang.String r46, java.lang.String[] r47) {
        /*
            r45 = this;
            r15 = r45
            r13 = r46
            r0 = r47
            r15.zzf = r13
            java.lang.String r14 = zzu(r46)
            java.lang.String r17 = "error"
            r18 = 0
            int r1 = r0.length     // Catch:{ Exception -> 0x01cd }
            android.net.Uri[] r1 = new android.net.Uri[r1]     // Catch:{ Exception -> 0x01cd }
            r2 = r18
        L_0x0015:
            int r3 = r0.length     // Catch:{ Exception -> 0x01cd }
            if (r2 >= r3) goto L_0x0023
            r3 = r0[r2]     // Catch:{ Exception -> 0x01cd }
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x01cd }
            r1[r2] = r3     // Catch:{ Exception -> 0x01cd }
            int r2 = r2 + 1
            goto L_0x0015
        L_0x0023:
            com.google.android.gms.internal.ads.zzcky r0 = r15.zze     // Catch:{ Exception -> 0x01cd }
            java.lang.String r2 = r15.zzb     // Catch:{ Exception -> 0x01cd }
            r0.zzA(r1, r2)     // Catch:{ Exception -> 0x01cd }
            java.lang.ref.WeakReference<com.google.android.gms.internal.ads.zzclh> r0 = r15.zzc     // Catch:{ Exception -> 0x01cd }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01cd }
            com.google.android.gms.internal.ads.zzclh r0 = (com.google.android.gms.internal.ads.zzclh) r0     // Catch:{ Exception -> 0x01cd }
            if (r0 == 0) goto L_0x0037
            r0.zzv(r14, r15)     // Catch:{ Exception -> 0x01cd }
        L_0x0037:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzt.zzA()     // Catch:{ Exception -> 0x01cd }
            long r19 = r0.currentTimeMillis()     // Catch:{ Exception -> 0x01cd }
            com.google.android.gms.internal.ads.zzblb<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzblj.zzt     // Catch:{ Exception -> 0x01cd }
            com.google.android.gms.internal.ads.zzblh r2 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ Exception -> 0x01cd }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ Exception -> 0x01cd }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x01cd }
            long r11 = r1.longValue()     // Catch:{ Exception -> 0x01cd }
            com.google.android.gms.internal.ads.zzblb<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzblj.zzs     // Catch:{ Exception -> 0x01cd }
            com.google.android.gms.internal.ads.zzblh r2 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ Exception -> 0x01cd }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ Exception -> 0x01cd }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x01cd }
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x01cd }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r9 = r1 * r3
            com.google.android.gms.internal.ads.zzblb<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zzblj.zzr     // Catch:{ Exception -> 0x01cd }
            com.google.android.gms.internal.ads.zzblh r2 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ Exception -> 0x01cd }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ Exception -> 0x01cd }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x01cd }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x01cd }
            long r6 = (long) r1     // Catch:{ Exception -> 0x01cd }
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzblj.zzbr     // Catch:{ Exception -> 0x01cd }
            com.google.android.gms.internal.ads.zzblh r2 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ Exception -> 0x01cd }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ Exception -> 0x01cd }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ Exception -> 0x01cd }
            boolean r21 = r1.booleanValue()     // Catch:{ Exception -> 0x01cd }
            r22 = -1
            r1 = r22
        L_0x0088:
            monitor-enter(r45)     // Catch:{ Exception -> 0x01cd }
            long r3 = r0.currentTimeMillis()     // Catch:{ all -> 0x01c5 }
            long r3 = r3 - r19
            int r3 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r3 > 0) goto L_0x0198
            boolean r3 = r15.zzg     // Catch:{ all -> 0x01c5 }
            if (r3 != 0) goto L_0x018b
            boolean r3 = r15.zzh     // Catch:{ all -> 0x01c5 }
            r24 = 1
            if (r3 == 0) goto L_0x00a1
            monitor-exit(r45)     // Catch:{ all -> 0x01c5 }
            r5 = r15
            goto L_0x015a
        L_0x00a1:
            com.google.android.gms.internal.ads.zzcky r3 = r15.zze     // Catch:{ all -> 0x01c5 }
            boolean r3 = r3.zzP()     // Catch:{ all -> 0x01c5 }
            if (r3 == 0) goto L_0x017e
            com.google.android.gms.internal.ads.zzcky r3 = r15.zze     // Catch:{ all -> 0x01c5 }
            long r4 = r3.zzx()     // Catch:{ all -> 0x01c5 }
            r25 = 0
            int r3 = (r4 > r25 ? 1 : (r4 == r25 ? 0 : -1))
            if (r3 <= 0) goto L_0x015e
            com.google.android.gms.internal.ads.zzcky r3 = r15.zze     // Catch:{ all -> 0x01c5 }
            long r27 = r3.zzt()     // Catch:{ all -> 0x01c5 }
            int r3 = (r27 > r1 ? 1 : (r27 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x012d
            int r1 = (r27 > r25 ? 1 : (r27 == r25 ? 0 : -1))
            if (r1 <= 0) goto L_0x00c6
            r8 = r24
            goto L_0x00c8
        L_0x00c6:
            r8 = r18
        L_0x00c8:
            if (r21 == 0) goto L_0x00d3
            com.google.android.gms.internal.ads.zzcky r1 = r15.zze     // Catch:{ all -> 0x01c5 }
            long r1 = r1.zzy()     // Catch:{ all -> 0x01c5 }
            r29 = r1
            goto L_0x00d5
        L_0x00d3:
            r29 = r22
        L_0x00d5:
            if (r21 == 0) goto L_0x00e0
            com.google.android.gms.internal.ads.zzcky r1 = r15.zze     // Catch:{ all -> 0x01c5 }
            long r1 = r1.zzv()     // Catch:{ all -> 0x01c5 }
            r31 = r1
            goto L_0x00e2
        L_0x00e0:
            r31 = r22
        L_0x00e2:
            if (r21 == 0) goto L_0x00ed
            com.google.android.gms.internal.ads.zzcky r1 = r15.zze     // Catch:{ all -> 0x01c5 }
            long r1 = r1.zzz()     // Catch:{ all -> 0x01c5 }
            r33 = r1
            goto L_0x00ef
        L_0x00ed:
            r33 = r22
        L_0x00ef:
            int r16 = com.google.android.gms.internal.ads.zzcky.zzq()     // Catch:{ all -> 0x0125 }
            int r35 = com.google.android.gms.internal.ads.zzcky.zzs()     // Catch:{ all -> 0x0125 }
            r1 = r45
            r2 = r46
            r3 = r14
            r36 = r4
            r4 = r27
            r38 = r6
            r6 = r36
            r40 = r9
            r9 = r29
            r42 = r11
            r11 = r31
            r44 = r14
            r13 = r33
            r15 = r16
            r16 = r35
            r1.zzg(r2, r3, r4, r6, r8, r9, r11, r13, r15, r16)     // Catch:{ all -> 0x011c }
            r1 = r27
            r3 = r36
            goto L_0x0136
        L_0x011c:
            r0 = move-exception
            r5 = r45
            r6 = r46
            r7 = r44
            goto L_0x01c9
        L_0x0125:
            r0 = move-exception
            r5 = r45
            r6 = r46
            r7 = r14
            goto L_0x01c9
        L_0x012d:
            r38 = r6
            r40 = r9
            r42 = r11
            r44 = r14
            r3 = r4
        L_0x0136:
            int r5 = (r27 > r3 ? 1 : (r27 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x0145
            r5 = r45
            r6 = r46
            r7 = r44
            r5.zze(r6, r7, r3)     // Catch:{ all -> 0x01c3 }
            monitor-exit(r45)     // Catch:{ all -> 0x01c3 }
            goto L_0x015a
        L_0x0145:
            r5 = r45
            r6 = r46
            r7 = r44
            com.google.android.gms.internal.ads.zzcky r3 = r5.zze     // Catch:{ all -> 0x01c3 }
            long r3 = r3.zzu()     // Catch:{ all -> 0x01c3 }
            int r3 = (r3 > r38 ? 1 : (r3 == r38 ? 0 : -1))
            if (r3 < 0) goto L_0x015b
            int r3 = (r27 > r25 ? 1 : (r27 == r25 ? 0 : -1))
            if (r3 <= 0) goto L_0x015b
            monitor-exit(r45)     // Catch:{ all -> 0x01c3 }
        L_0x015a:
            return r24
        L_0x015b:
            r3 = r42
            goto L_0x0166
        L_0x015e:
            r38 = r6
            r40 = r9
            r6 = r13
            r7 = r14
            r5 = r15
            r3 = r11
        L_0x0166:
            r5.wait(r3)     // Catch:{ InterruptedException -> 0x0174 }
            monitor-exit(r45)     // Catch:{ all -> 0x01c3 }
            r11 = r3
            r15 = r5
            r13 = r6
            r14 = r7
            r6 = r38
            r9 = r40
            goto L_0x0088
        L_0x0174:
            java.lang.String r1 = "interrupted"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01bf }
            java.lang.String r2 = "Wait interrupted."
            r0.<init>(r2)     // Catch:{ all -> 0x01bf }
            throw r0     // Catch:{ all -> 0x01bf }
        L_0x017e:
            r6 = r13
            r7 = r14
            r5 = r15
            java.lang.String r1 = "exoPlayerReleased"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01bf }
            java.lang.String r2 = "ExoPlayer was released during preloading."
            r0.<init>(r2)     // Catch:{ all -> 0x01bf }
            throw r0     // Catch:{ all -> 0x01bf }
        L_0x018b:
            r6 = r13
            r7 = r14
            r5 = r15
            java.lang.String r1 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01bf }
            java.lang.String r2 = "Abort requested before buffering finished. "
            r0.<init>(r2)     // Catch:{ all -> 0x01bf }
            throw r0     // Catch:{ all -> 0x01bf }
        L_0x0198:
            r40 = r9
            r6 = r13
            r7 = r14
            r5 = r15
            java.lang.String r1 = "downloadTimeout"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01bf }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01bf }
            r3 = 47
            r2.<init>(r3)     // Catch:{ all -> 0x01bf }
            java.lang.String r3 = "Timeout reached. Limit: "
            r2.append(r3)     // Catch:{ all -> 0x01bf }
            r3 = r40
            r2.append(r3)     // Catch:{ all -> 0x01bf }
            java.lang.String r3 = " ms"
            r2.append(r3)     // Catch:{ all -> 0x01bf }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01bf }
            r0.<init>(r2)     // Catch:{ all -> 0x01bf }
            throw r0     // Catch:{ all -> 0x01bf }
        L_0x01bf:
            r0 = move-exception
            r17 = r1
            goto L_0x01c9
        L_0x01c3:
            r0 = move-exception
            goto L_0x01c9
        L_0x01c5:
            r0 = move-exception
            r6 = r13
            r7 = r14
            r5 = r15
        L_0x01c9:
            monitor-exit(r45)     // Catch:{ all -> 0x01c3 }
            throw r0     // Catch:{ Exception -> 0x01cb }
        L_0x01cb:
            r0 = move-exception
            goto L_0x01d1
        L_0x01cd:
            r0 = move-exception
            r6 = r13
            r7 = r14
            r5 = r15
        L_0x01d1:
            r1 = r17
            java.lang.String r2 = r0.getMessage()
            java.lang.String r3 = java.lang.String.valueOf(r46)
            int r3 = r3.length()
            java.lang.String r4 = java.lang.String.valueOf(r2)
            int r4 = r4.length()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            int r3 = r3 + 34
            int r3 = r3 + r4
            r8.<init>(r3)
            java.lang.String r3 = "Failed to preload url "
            r8.append(r3)
            r8.append(r6)
            java.lang.String r3 = " Exception: "
            r8.append(r3)
            r8.append(r2)
            java.lang.String r2 = r8.toString()
            com.google.android.gms.internal.ads.zzciz.zzj(r2)
            com.google.android.gms.internal.ads.zzcik r2 = com.google.android.gms.ads.internal.zzt.zzo()
            java.lang.String r3 = "VideoStreamExoPlayerCache.preload"
            r2.zzr(r0, r3)
            r45.release()
            java.lang.String r0 = zzw(r1, r0)
            r5.zzc(r6, r7, r1, r0)
            return r18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcno.zzr(java.lang.String, java.lang.String[]):boolean");
    }

    public final boolean zzs(String str, String[] strArr, zzcmx zzcmx) {
        this.zzf = str;
        this.zzi = zzcmx;
        String zzu = zzu(str);
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i11 = 0; i11 < strArr.length; i11++) {
                uriArr[i11] = Uri.parse(strArr[i11]);
            }
            this.zze.zzA(uriArr, this.zzb);
            zzclh zzclh = this.zzc.get();
            if (zzclh != null) {
                zzclh.zzv(zzu, this);
            }
            this.zzj = com.google.android.gms.ads.internal.zzt.zzA().currentTimeMillis();
            this.zzk = -1;
            zzx(0);
            return true;
        } catch (Exception e11) {
            String message = e11.getMessage();
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(message).length());
            sb2.append("Failed to preload url ");
            sb2.append(str);
            sb2.append(" Exception: ");
            sb2.append(message);
            zzciz.zzj(sb2.toString());
            com.google.android.gms.ads.internal.zzt.zzo().zzr(e11, "VideoStreamExoPlayerCache.preload");
            release();
            zzc(str, zzu, "error", zzw("error", e11));
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v24, resolved type: com.google.android.gms.internal.ads.zzcno} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v27, resolved type: com.google.android.gms.internal.ads.zzcno} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v30, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v20, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v22, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v32, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v33, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v34, resolved type: com.google.android.gms.internal.ads.zzcno} */
    /* JADX WARNING: type inference failed for: r2v11, types: [boolean] */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0057, code lost:
        r2 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x010e, code lost:
        r2.zzx(((java.lang.Long) com.google.android.gms.internal.ads.zzbgq.zzc().zzb(com.google.android.gms.internal.ads.zzblj.zzt)).longValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0121, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zzt() {
        /*
            r32 = this;
            r15 = r32
            java.lang.String r0 = r15.zzf
            java.lang.String r13 = zzu(r0)
            java.lang.String r17 = "error"
            com.google.android.gms.internal.ads.zzblb<java.lang.Long> r0 = com.google.android.gms.internal.ads.zzblj.zzs     // Catch:{ Exception -> 0x016d }
            com.google.android.gms.internal.ads.zzblh r1 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ Exception -> 0x016d }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ Exception -> 0x016d }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ Exception -> 0x016d }
            long r0 = r0.longValue()     // Catch:{ Exception -> 0x016d }
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r2
            com.google.android.gms.internal.ads.zzblb<java.lang.Integer> r2 = com.google.android.gms.internal.ads.zzblj.zzr     // Catch:{ Exception -> 0x016d }
            com.google.android.gms.internal.ads.zzblh r3 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ Exception -> 0x016d }
            java.lang.Object r2 = r3.zzb(r2)     // Catch:{ Exception -> 0x016d }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Exception -> 0x016d }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x016d }
            long r11 = (long) r2     // Catch:{ Exception -> 0x016d }
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzblj.zzbr     // Catch:{ Exception -> 0x016d }
            com.google.android.gms.internal.ads.zzblh r3 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ Exception -> 0x016d }
            java.lang.Object r2 = r3.zzb(r2)     // Catch:{ Exception -> 0x016d }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x016d }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x016d }
            monitor-enter(r32)     // Catch:{ Exception -> 0x016d }
            com.google.android.gms.common.util.Clock r3 = com.google.android.gms.ads.internal.zzt.zzA()     // Catch:{ all -> 0x0166 }
            long r3 = r3.currentTimeMillis()     // Catch:{ all -> 0x0166 }
            long r5 = r15.zzj     // Catch:{ all -> 0x0166 }
            long r3 = r3 - r5
            int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r3 > 0) goto L_0x013e
            boolean r0 = r15.zzg     // Catch:{ all -> 0x0166 }
            if (r0 != 0) goto L_0x012e
            boolean r0 = r15.zzh     // Catch:{ all -> 0x0166 }
            if (r0 == 0) goto L_0x005a
            monitor-exit(r32)     // Catch:{ all -> 0x0166 }
            r2 = r15
            goto L_0x01bc
        L_0x005a:
            com.google.android.gms.internal.ads.zzcky r0 = r15.zze     // Catch:{ all -> 0x0166 }
            boolean r0 = r0.zzP()     // Catch:{ all -> 0x0166 }
            if (r0 == 0) goto L_0x0122
            com.google.android.gms.internal.ads.zzcky r0 = r15.zze     // Catch:{ all -> 0x0166 }
            long r9 = r0.zzx()     // Catch:{ all -> 0x0166 }
            r18 = 0
            int r0 = (r9 > r18 ? 1 : (r9 == r18 ? 0 : -1))
            if (r0 <= 0) goto L_0x010b
            com.google.android.gms.internal.ads.zzcky r0 = r15.zze     // Catch:{ all -> 0x0166 }
            long r6 = r0.zzt()     // Catch:{ all -> 0x0166 }
            long r0 = r15.zzk     // Catch:{ all -> 0x0166 }
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x00de
            int r0 = (r6 > r18 ? 1 : (r6 == r18 ? 0 : -1))
            if (r0 <= 0) goto L_0x0080
            r0 = 1
            goto L_0x0081
        L_0x0080:
            r0 = 0
        L_0x0081:
            r8 = r0
            java.lang.String r0 = r15.zzf     // Catch:{ all -> 0x00d9 }
            r3 = -1
            if (r2 == 0) goto L_0x008f
            com.google.android.gms.internal.ads.zzcky r1 = r15.zze     // Catch:{ all -> 0x0166 }
            long r20 = r1.zzy()     // Catch:{ all -> 0x0166 }
            goto L_0x0091
        L_0x008f:
            r20 = r3
        L_0x0091:
            if (r2 == 0) goto L_0x009a
            com.google.android.gms.internal.ads.zzcky r1 = r15.zze     // Catch:{ all -> 0x0166 }
            long r22 = r1.zzv()     // Catch:{ all -> 0x0166 }
            goto L_0x009c
        L_0x009a:
            r22 = r3
        L_0x009c:
            if (r2 == 0) goto L_0x00a7
            com.google.android.gms.internal.ads.zzcky r1 = r15.zze     // Catch:{ all -> 0x0166 }
            long r1 = r1.zzz()     // Catch:{ all -> 0x0166 }
            r24 = r1
            goto L_0x00a9
        L_0x00a7:
            r24 = r3
        L_0x00a9:
            int r16 = com.google.android.gms.internal.ads.zzcky.zzq()     // Catch:{ all -> 0x00d9 }
            int r26 = com.google.android.gms.internal.ads.zzcky.zzs()     // Catch:{ all -> 0x00d9 }
            r1 = r32
            r2 = r0
            r3 = r13
            r4 = r6
            r27 = r6
            r6 = r9
            r29 = r9
            r9 = r20
            r20 = r11
            r11 = r22
            r31 = r13
            r13 = r24
            r15 = r16
            r16 = r26
            r1.zzg(r2, r3, r4, r6, r8, r9, r11, r13, r15, r16)     // Catch:{ all -> 0x00d5 }
            r2 = r32
            r0 = r27
            r2.zzk = r0     // Catch:{ all -> 0x00f3 }
            r3 = r29
            goto L_0x00e5
        L_0x00d5:
            r0 = move-exception
            r2 = r32
            goto L_0x00f4
        L_0x00d9:
            r0 = move-exception
            r2 = r15
            r5 = r13
            goto L_0x0169
        L_0x00de:
            r0 = r6
            r20 = r11
            r31 = r13
            r2 = r15
            r3 = r9
        L_0x00e5:
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x00f8
            java.lang.String r0 = r2.zzf     // Catch:{ all -> 0x00f3 }
            r5 = r31
            r2.zze(r0, r5, r3)     // Catch:{ all -> 0x0164 }
            monitor-exit(r32)     // Catch:{ all -> 0x0164 }
            goto L_0x01bc
        L_0x00f3:
            r0 = move-exception
        L_0x00f4:
            r5 = r31
            goto L_0x0169
        L_0x00f8:
            r5 = r31
            com.google.android.gms.internal.ads.zzcky r3 = r2.zze     // Catch:{ all -> 0x0164 }
            long r3 = r3.zzu()     // Catch:{ all -> 0x0164 }
            int r3 = (r3 > r20 ? 1 : (r3 == r20 ? 0 : -1))
            if (r3 < 0) goto L_0x010d
            int r0 = (r0 > r18 ? 1 : (r0 == r18 ? 0 : -1))
            if (r0 <= 0) goto L_0x010d
            monitor-exit(r32)     // Catch:{ all -> 0x0164 }
            goto L_0x01bc
        L_0x010b:
            r5 = r13
            r2 = r15
        L_0x010d:
            monitor-exit(r32)     // Catch:{ all -> 0x0164 }
            com.google.android.gms.internal.ads.zzblb<java.lang.Long> r0 = com.google.android.gms.internal.ads.zzblj.zzt
            com.google.android.gms.internal.ads.zzblh r1 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r0 = r1.zzb(r0)
            java.lang.Long r0 = (java.lang.Long) r0
            long r0 = r0.longValue()
            r2.zzx(r0)
            return
        L_0x0122:
            r5 = r13
            r2 = r15
            java.lang.String r1 = "exoPlayerReleased"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x013a }
            java.lang.String r3 = "ExoPlayer was released during preloading."
            r0.<init>(r3)     // Catch:{ all -> 0x013a }
            throw r0     // Catch:{ all -> 0x013a }
        L_0x012e:
            r5 = r13
            r2 = r15
            java.lang.String r1 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x013a }
            java.lang.String r3 = "Abort requested before buffering finished. "
            r0.<init>(r3)     // Catch:{ all -> 0x013a }
            throw r0     // Catch:{ all -> 0x013a }
        L_0x013a:
            r0 = move-exception
            r17 = r1
            goto L_0x0169
        L_0x013e:
            r5 = r13
            r2 = r15
            java.lang.String r3 = "downloadTimeout"
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x0160 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0160 }
            r7 = 47
            r6.<init>(r7)     // Catch:{ all -> 0x0160 }
            java.lang.String r7 = "Timeout reached. Limit: "
            r6.append(r7)     // Catch:{ all -> 0x0160 }
            r6.append(r0)     // Catch:{ all -> 0x0160 }
            java.lang.String r0 = " ms"
            r6.append(r0)     // Catch:{ all -> 0x0160 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0160 }
            r4.<init>(r0)     // Catch:{ all -> 0x0160 }
            throw r4     // Catch:{ all -> 0x0160 }
        L_0x0160:
            r0 = move-exception
            r17 = r3
            goto L_0x0169
        L_0x0164:
            r0 = move-exception
            goto L_0x0169
        L_0x0166:
            r0 = move-exception
            r5 = r13
            r2 = r15
        L_0x0169:
            monitor-exit(r32)     // Catch:{ all -> 0x0164 }
            throw r0     // Catch:{ Exception -> 0x016b }
        L_0x016b:
            r0 = move-exception
            goto L_0x0170
        L_0x016d:
            r0 = move-exception
            r5 = r13
            r2 = r15
        L_0x0170:
            r1 = r17
            java.lang.String r3 = r2.zzf
            java.lang.String r4 = r0.getMessage()
            java.lang.String r6 = java.lang.String.valueOf(r3)
            int r6 = r6.length()
            java.lang.String r7 = java.lang.String.valueOf(r4)
            int r7 = r7.length()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            int r6 = r6 + 34
            int r6 = r6 + r7
            r8.<init>(r6)
            java.lang.String r6 = "Failed to preload url "
            r8.append(r6)
            r8.append(r3)
            java.lang.String r3 = " Exception: "
            r8.append(r3)
            r8.append(r4)
            java.lang.String r3 = r8.toString()
            com.google.android.gms.internal.ads.zzciz.zzj(r3)
            com.google.android.gms.internal.ads.zzcik r3 = com.google.android.gms.ads.internal.zzt.zzo()
            java.lang.String r4 = "VideoStreamExoPlayerCache.preload"
            r3.zzr(r0, r4)
            r32.release()
            java.lang.String r0 = zzw(r1, r0)
            java.lang.String r3 = r2.zzf
            r2.zzc(r3, r5, r1, r0)
        L_0x01bc:
            com.google.android.gms.internal.ads.zzcmy r0 = com.google.android.gms.ads.internal.zzt.zzy()
            com.google.android.gms.internal.ads.zzcmx r1 = r2.zzi
            r0.zzc(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcno.zzt():void");
    }

    public final void zzv() {
        zzciz.zzj("Precache onRenderedFirstFrame");
    }
}
