package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public final class zzcnl extends zzcnf implements zzawl<zzavw> {
    private String zzd;
    private final zzclg zze;
    private boolean zzf;
    private final zzcnk zzg = new zzcnk();
    private final zzcmq zzh = new zzcmq();
    private ByteBuffer zzi;
    private boolean zzj;
    private final Object zzk = new Object();
    private final String zzl;
    private final int zzm;
    private boolean zzn;

    public zzcnl(zzclh zzclh, zzclg zzclg) {
        super(zzclh);
        String str;
        int i11;
        this.zze = zzclg;
        if (zzclh != null) {
            str = zzclh.zzt();
        } else {
            str = "";
        }
        this.zzl = str;
        if (zzclh != null) {
            i11 = zzclh.zzh();
        } else {
            i11 = 0;
        }
        this.zzm = i11;
    }

    public static final String zzt(String str) {
        String valueOf = String.valueOf(zzcis.zze(str));
        if (valueOf.length() != 0) {
            return "cache:".concat(valueOf);
        }
        return new String("cache:");
    }

    private final void zzu() {
        boolean z11;
        int zza = (int) this.zzg.zza();
        int zza2 = (int) this.zzh.zza(this.zzi);
        int position = this.zzi.position();
        int round = Math.round(((float) zza2) * (((float) position) / ((float) zza)));
        if (round > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        boolean z12 = z11;
        int zzq = zzcky.zzq();
        int zzs = zzcky.zzs();
        String str = this.zzd;
        zzf(str, zzt(str), position, zza, (long) round, (long) zza2, z12, zzq, zzs);
    }

    public final void zzb() {
        this.zzf = true;
    }

    public final String zzi() {
        return this.zzd;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj, int i11) {
    }

    public final /* bridge */ /* synthetic */ void zzk(Object obj, zzavy zzavy) {
        this.zzg.zzb((zzawa) obj);
    }

    public final ByteBuffer zzl() {
        synchronized (this.zzk) {
            ByteBuffer byteBuffer = this.zzi;
            if (byteBuffer != null && !this.zzj) {
                byteBuffer.flip();
                this.zzj = true;
            }
            this.zzf = true;
        }
        return this.zzi;
    }

    public final boolean zzm() {
        return this.zzn;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: com.google.android.gms.internal.ads.zzawa} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.google.android.gms.internal.ads.zzawa} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v30, resolved type: com.google.android.gms.internal.ads.zzcmc} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: com.google.android.gms.internal.ads.zzawa} */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00d1, code lost:
        if (r9.zzi.remaining() > 0) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00d3, code lost:
        zzu();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00da, code lost:
        if (r9.zzf != false) goto L_0x011c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00dc, code lost:
        r12 = r1.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00e4, code lost:
        if ((r12 - r16) < r4) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00e6, code lost:
        zzu();
        r16 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00f2, code lost:
        if ((r12 - r2) > (1000 * r6)) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r0 = new java.lang.StringBuilder(49);
        r0.append("Timeout exceeded. Limit: ");
        r0.append(r6);
        r0.append(" sec");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0119, code lost:
        throw new java.io.IOException(r0.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x011a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x011c, code lost:
        r12 = "externalAbort";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r1 = r9.zzi.limit();
        r2 = new java.lang.StringBuilder(35);
        r2.append("Precache abort at ");
        r2.append(r1);
        r2.append(" bytes");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0141, code lost:
        throw new java.io.IOException(r2.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0142, code lost:
        r0 = e;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzq(java.lang.String r27) {
        /*
            r26 = this;
            r9 = r26
            r10 = r27
            r9.zzd = r10
            java.lang.String r11 = zzt(r27)
            java.lang.String r12 = "error"
            r13 = 0
            com.google.android.gms.internal.ads.zzawa r0 = new com.google.android.gms.internal.ads.zzawa     // Catch:{ Exception -> 0x014b }
            java.lang.String r2 = r9.zzb     // Catch:{ Exception -> 0x014b }
            com.google.android.gms.internal.ads.zzclg r1 = r9.zze     // Catch:{ Exception -> 0x014b }
            int r5 = r1.zzd     // Catch:{ Exception -> 0x014b }
            r3 = 0
            int r6 = r1.zzf     // Catch:{ Exception -> 0x014b }
            r7 = 1
            r8 = 0
            r1 = r0
            r4 = r26
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x014b }
            com.google.android.gms.internal.ads.zzclg r1 = r9.zze     // Catch:{ Exception -> 0x014b }
            boolean r1 = r1.zzj     // Catch:{ Exception -> 0x014b }
            if (r1 == 0) goto L_0x0037
            com.google.android.gms.internal.ads.zzcmc r15 = new com.google.android.gms.internal.ads.zzcmc     // Catch:{ Exception -> 0x014b }
            android.content.Context r2 = r9.zza     // Catch:{ Exception -> 0x014b }
            java.lang.String r4 = r9.zzl     // Catch:{ Exception -> 0x014b }
            int r5 = r9.zzm     // Catch:{ Exception -> 0x014b }
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r15
            r3 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x014b }
            r0 = r15
        L_0x0037:
            android.net.Uri r16 = android.net.Uri.parse(r27)     // Catch:{ Exception -> 0x014b }
            com.google.android.gms.internal.ads.zzavy r1 = new com.google.android.gms.internal.ads.zzavy     // Catch:{ Exception -> 0x014b }
            r17 = 0
            r18 = 0
            r20 = 0
            r22 = -1
            r24 = 0
            r25 = 0
            r15 = r1
            r15.<init>(r16, r17, r18, r20, r22, r24, r25)     // Catch:{ Exception -> 0x014b }
            r0.zzb(r1)     // Catch:{ Exception -> 0x014b }
            java.lang.ref.WeakReference<com.google.android.gms.internal.ads.zzclh> r1 = r9.zzc     // Catch:{ Exception -> 0x014b }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x014b }
            com.google.android.gms.internal.ads.zzclh r1 = (com.google.android.gms.internal.ads.zzclh) r1     // Catch:{ Exception -> 0x014b }
            if (r1 == 0) goto L_0x005d
            r1.zzv(r11, r9)     // Catch:{ Exception -> 0x014b }
        L_0x005d:
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzt.zzA()     // Catch:{ Exception -> 0x014b }
            long r2 = r1.currentTimeMillis()     // Catch:{ Exception -> 0x014b }
            com.google.android.gms.internal.ads.zzblb<java.lang.Long> r4 = com.google.android.gms.internal.ads.zzblj.zzt     // Catch:{ Exception -> 0x014b }
            com.google.android.gms.internal.ads.zzblh r5 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ Exception -> 0x014b }
            java.lang.Object r4 = r5.zzb(r4)     // Catch:{ Exception -> 0x014b }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ Exception -> 0x014b }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x014b }
            com.google.android.gms.internal.ads.zzblb<java.lang.Long> r6 = com.google.android.gms.internal.ads.zzblj.zzs     // Catch:{ Exception -> 0x014b }
            com.google.android.gms.internal.ads.zzblh r7 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ Exception -> 0x014b }
            java.lang.Object r6 = r7.zzb(r6)     // Catch:{ Exception -> 0x014b }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ Exception -> 0x014b }
            long r6 = r6.longValue()     // Catch:{ Exception -> 0x014b }
            com.google.android.gms.internal.ads.zzclg r8 = r9.zze     // Catch:{ Exception -> 0x014b }
            int r8 = r8.zzc     // Catch:{ Exception -> 0x014b }
            java.nio.ByteBuffer r8 = java.nio.ByteBuffer.allocate(r8)     // Catch:{ Exception -> 0x014b }
            r9.zzi = r8     // Catch:{ Exception -> 0x014b }
            r8 = 8192(0x2000, float:1.14794E-41)
            byte[] r15 = new byte[r8]     // Catch:{ Exception -> 0x014b }
            r16 = r2
        L_0x0095:
            java.nio.ByteBuffer r14 = r9.zzi     // Catch:{ Exception -> 0x014b }
            int r14 = r14.remaining()     // Catch:{ Exception -> 0x014b }
            int r14 = java.lang.Math.min(r14, r8)     // Catch:{ Exception -> 0x014b }
            int r14 = r0.zza(r15, r13, r14)     // Catch:{ Exception -> 0x014b }
            r8 = -1
            if (r14 != r8) goto L_0x00b8
            r8 = 1
            r9.zzn = r8     // Catch:{ Exception -> 0x014b }
            com.google.android.gms.internal.ads.zzcmq r0 = r9.zzh     // Catch:{ Exception -> 0x014b }
            java.nio.ByteBuffer r1 = r9.zzi     // Catch:{ Exception -> 0x014b }
            long r0 = r0.zza(r1)     // Catch:{ Exception -> 0x014b }
            int r0 = (int) r0     // Catch:{ Exception -> 0x014b }
            long r0 = (long) r0     // Catch:{ Exception -> 0x014b }
            r9.zze(r10, r11, r0)     // Catch:{ Exception -> 0x014b }
        L_0x00b6:
            r1 = 1
            goto L_0x00d7
        L_0x00b8:
            java.lang.Object r8 = r9.zzk     // Catch:{ Exception -> 0x014b }
            monitor-enter(r8)     // Catch:{ Exception -> 0x014b }
            boolean r13 = r9.zzf     // Catch:{ all -> 0x0146 }
            if (r13 != 0) goto L_0x00c8
            java.nio.ByteBuffer r13 = r9.zzi     // Catch:{ all -> 0x0146 }
            r21 = r12
            r12 = 0
            r13.put(r15, r12, r14)     // Catch:{ all -> 0x0144 }
            goto L_0x00ca
        L_0x00c8:
            r21 = r12
        L_0x00ca:
            monitor-exit(r8)     // Catch:{ all -> 0x0144 }
            java.nio.ByteBuffer r8 = r9.zzi     // Catch:{ Exception -> 0x0142 }
            int r8 = r8.remaining()     // Catch:{ Exception -> 0x0142 }
            if (r8 > 0) goto L_0x00d8
            r26.zzu()     // Catch:{ Exception -> 0x0142 }
            goto L_0x00b6
        L_0x00d7:
            return r1
        L_0x00d8:
            boolean r8 = r9.zzf     // Catch:{ Exception -> 0x0142 }
            if (r8 != 0) goto L_0x011c
            long r12 = r1.currentTimeMillis()     // Catch:{ Exception -> 0x0142 }
            long r22 = r12 - r16
            int r8 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r8 < 0) goto L_0x00eb
            r26.zzu()     // Catch:{ Exception -> 0x0142 }
            r16 = r12
        L_0x00eb:
            long r12 = r12 - r2
            r22 = 1000(0x3e8, double:4.94E-321)
            long r22 = r22 * r6
            int r8 = (r12 > r22 ? 1 : (r12 == r22 ? 0 : -1))
            if (r8 > 0) goto L_0x00fa
            r12 = r21
            r8 = 8192(0x2000, float:1.14794E-41)
            r13 = 0
            goto L_0x0095
        L_0x00fa:
            java.lang.String r12 = "downloadTimeout"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011a }
            r1 = 49
            r0.<init>(r1)     // Catch:{ Exception -> 0x011a }
            java.lang.String r1 = "Timeout exceeded. Limit: "
            r0.append(r1)     // Catch:{ Exception -> 0x011a }
            r0.append(r6)     // Catch:{ Exception -> 0x011a }
            java.lang.String r1 = " sec"
            r0.append(r1)     // Catch:{ Exception -> 0x011a }
            java.io.IOException r1 = new java.io.IOException     // Catch:{ Exception -> 0x011a }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x011a }
            r1.<init>(r0)     // Catch:{ Exception -> 0x011a }
            throw r1     // Catch:{ Exception -> 0x011a }
        L_0x011a:
            r0 = move-exception
            goto L_0x0150
        L_0x011c:
            java.lang.String r12 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x011a }
            java.nio.ByteBuffer r1 = r9.zzi     // Catch:{ Exception -> 0x011a }
            int r1 = r1.limit()     // Catch:{ Exception -> 0x011a }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011a }
            r3 = 35
            r2.<init>(r3)     // Catch:{ Exception -> 0x011a }
            java.lang.String r3 = "Precache abort at "
            r2.append(r3)     // Catch:{ Exception -> 0x011a }
            r2.append(r1)     // Catch:{ Exception -> 0x011a }
            java.lang.String r1 = " bytes"
            r2.append(r1)     // Catch:{ Exception -> 0x011a }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x011a }
            r0.<init>(r1)     // Catch:{ Exception -> 0x011a }
            throw r0     // Catch:{ Exception -> 0x011a }
        L_0x0142:
            r0 = move-exception
            goto L_0x014e
        L_0x0144:
            r0 = move-exception
            goto L_0x0149
        L_0x0146:
            r0 = move-exception
            r21 = r12
        L_0x0149:
            monitor-exit(r8)     // Catch:{ all -> 0x0144 }
            throw r0     // Catch:{ Exception -> 0x0142 }
        L_0x014b:
            r0 = move-exception
            r21 = r12
        L_0x014e:
            r12 = r21
        L_0x0150:
            java.lang.Class r1 = r0.getClass()
            java.lang.String r1 = r1.getCanonicalName()
            java.lang.String r0 = r0.getMessage()
            java.lang.String r2 = java.lang.String.valueOf(r1)
            int r2 = r2.length()
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r5 = 1
            int r2 = r2 + r5
            int r2 = r2 + r3
            r4.<init>(r2)
            r4.append(r1)
            java.lang.String r1 = ":"
            r4.append(r1)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.lang.String r1 = java.lang.String.valueOf(r27)
            int r1 = r1.length()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r1 = r1 + 34
            int r3 = r0.length()
            int r1 = r1 + r3
            r2.<init>(r1)
            java.lang.String r1 = "Failed to preload url "
            r2.append(r1)
            r2.append(r10)
            java.lang.String r1 = " Exception: "
            r2.append(r1)
            r2.append(r0)
            java.lang.String r1 = r2.toString()
            com.google.android.gms.internal.ads.zzciz.zzj(r1)
            r9.zzc(r10, r11, r12, r0)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcnl.zzq(java.lang.String):boolean");
    }
}
