package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;

final class zzqu implements zztz, zzpp {
    final /* synthetic */ zzqz zza;
    /* access modifiers changed from: private */
    public final long zzb = zzpr.zza();
    private final Uri zzc;
    /* access modifiers changed from: private */
    public final zzul zzd;
    private final zzqq zze;
    private final zzws zzf;
    private final zzeb zzg;
    private final zzxm zzh = new zzxm();
    private volatile boolean zzi;
    private boolean zzj = true;
    /* access modifiers changed from: private */
    public long zzk;
    /* access modifiers changed from: private */
    public zzdm zzl = zzj(0);
    /* access modifiers changed from: private */
    public long zzm = -1;
    @Nullable
    private zzxt zzn;
    private boolean zzo;

    public zzqu(zzqz zzqz, Uri uri, zzdi zzdi, zzqq zzqq, zzws zzws, zzeb zzeb) {
        this.zza = zzqz;
        this.zzc = uri;
        this.zzd = new zzul(zzdi);
        this.zze = zzqq;
        this.zzf = zzws;
        this.zzg = zzeb;
    }

    public static /* bridge */ /* synthetic */ void zzg(zzqu zzqu, long j11, long j12) {
        zzqu.zzh.zza = j11;
        zzqu.zzk = j12;
        zzqu.zzj = true;
        zzqu.zzo = false;
    }

    private final zzdm zzj(long j11) {
        zzdk zzdk = new zzdk();
        zzdk.zzd(this.zzc);
        zzdk.zzc(j11);
        zzdk.zza(6);
        zzdk.zzb(zzqz.zzb);
        return zzdk.zze();
    }

    public final void zza(zzfd zzfd) {
        long j11;
        if (!this.zzo) {
            j11 = this.zzk;
        } else {
            j11 = Math.max(this.zza.zzO(), this.zzk);
        }
        int zza2 = zzfd.zza();
        zzxt zzxt = this.zzn;
        zzxt.getClass();
        zzxr.zzb(zzxt, zzfd, zza2);
        zzxt.zzs(j11, 1, zza2, 0, (zzxs) null);
        this.zzo = true;
    }

    public final void zzh() {
        this.zzi = true;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:71|72|(1:74)(1:75)|76) */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        r7 = java.lang.String.valueOf(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0123, code lost:
        if (r7.length() != 0) goto L_0x0125;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0125, code lost:
        r7 = "Invalid metadata interval: ".concat(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x012a, code lost:
        r7 = new java.lang.String("Invalid metadata interval: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x012f, code lost:
        android.util.Log.w("IcyHeaders", r7);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x011b */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x022c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x01eb A[EDGE_INSN: B:125:0x01eb->B:108:0x01eb ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0076 A[Catch:{ all -> 0x020d }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007b A[Catch:{ all -> 0x020d }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0093 A[Catch:{ all -> 0x020d }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009d A[Catch:{ all -> 0x020d }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a9 A[Catch:{ all -> 0x020d }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b3 A[Catch:{ all -> 0x020d }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00bf A[Catch:{ all -> 0x020d }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c9 A[Catch:{ all -> 0x020d }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d5 A[Catch:{ all -> 0x020d }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e5 A[Catch:{ all -> 0x020d }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f1 A[Catch:{ all -> 0x020d }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0133 A[Catch:{ all -> 0x020d }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0137 A[Catch:{ all -> 0x020d }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0192 A[Catch:{ all -> 0x020d }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x019b A[Catch:{ all -> 0x020d }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01a8 A[SYNTHETIC, Splitter:B:93:0x01a8] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzi() throws java.io.IOException {
        /*
            r22 = this;
            r1 = r22
            java.lang.String r0 = "Invalid metadata interval: "
        L_0x0004:
            boolean r2 = r1.zzi
            if (r2 != 0) goto L_0x022c
            r2 = -1
            r4 = 1
            r5 = 0
            com.google.android.gms.internal.ads.zzxm r6 = r1.zzh     // Catch:{ all -> 0x020d }
            long r13 = r6.zza     // Catch:{ all -> 0x020d }
            com.google.android.gms.internal.ads.zzdm r6 = r1.zzj(r13)     // Catch:{ all -> 0x020d }
            r1.zzl = r6     // Catch:{ all -> 0x020d }
            com.google.android.gms.internal.ads.zzul r7 = r1.zzd     // Catch:{ all -> 0x020d }
            long r6 = r7.zzh(r6)     // Catch:{ all -> 0x020d }
            r1.zzm = r6     // Catch:{ all -> 0x020d }
            int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r8 == 0) goto L_0x0025
            long r6 = r6 + r13
            r1.zzm = r6     // Catch:{ all -> 0x020d }
        L_0x0025:
            com.google.android.gms.internal.ads.zzqz r6 = r1.zza     // Catch:{ all -> 0x020d }
            com.google.android.gms.internal.ads.zzul r7 = r1.zzd     // Catch:{ all -> 0x020d }
            java.util.Map r7 = r7.zza()     // Catch:{ all -> 0x020d }
            java.lang.String r8 = "icy-br"
            java.lang.Object r8 = r7.get(r8)     // Catch:{ all -> 0x020d }
            java.util.List r8 = (java.util.List) r8     // Catch:{ all -> 0x020d }
            java.lang.String r9 = "IcyHeaders"
            r10 = -1
            if (r8 == 0) goto L_0x0085
            java.lang.Object r8 = r8.get(r5)     // Catch:{ all -> 0x020d }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x020d }
            int r11 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x0069 }
            int r11 = r11 * 1000
            if (r11 <= 0) goto L_0x004a
            r8 = r4
            goto L_0x0066
        L_0x004a:
            java.lang.String r12 = "Invalid bitrate: "
            java.lang.String r15 = java.lang.String.valueOf(r8)     // Catch:{ NumberFormatException -> 0x006a }
            int r16 = r15.length()     // Catch:{ NumberFormatException -> 0x006a }
            if (r16 == 0) goto L_0x005b
            java.lang.String r12 = r12.concat(r15)     // Catch:{ NumberFormatException -> 0x006a }
            goto L_0x0061
        L_0x005b:
            java.lang.String r15 = new java.lang.String     // Catch:{ NumberFormatException -> 0x006a }
            r15.<init>(r12)     // Catch:{ NumberFormatException -> 0x006a }
            r12 = r15
        L_0x0061:
            android.util.Log.w(r9, r12)     // Catch:{ NumberFormatException -> 0x006a }
            r8 = r5
            r11 = r10
        L_0x0066:
            r16 = r11
            goto L_0x0088
        L_0x0069:
            r11 = r10
        L_0x006a:
            java.lang.String r12 = "Invalid bitrate header: "
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x020d }
            int r15 = r8.length()     // Catch:{ all -> 0x020d }
            if (r15 == 0) goto L_0x007b
            java.lang.String r8 = r12.concat(r8)     // Catch:{ all -> 0x020d }
            goto L_0x0080
        L_0x007b:
            java.lang.String r8 = new java.lang.String     // Catch:{ all -> 0x020d }
            r8.<init>(r12)     // Catch:{ all -> 0x020d }
        L_0x0080:
            android.util.Log.w(r9, r8)     // Catch:{ all -> 0x020d }
            r8 = r5
            goto L_0x0066
        L_0x0085:
            r8 = r5
            r16 = r10
        L_0x0088:
            java.lang.String r11 = "icy-genre"
            java.lang.Object r11 = r7.get(r11)     // Catch:{ all -> 0x020d }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x020d }
            r12 = 0
            if (r11 == 0) goto L_0x009d
            java.lang.Object r8 = r11.get(r5)     // Catch:{ all -> 0x020d }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x020d }
            r17 = r8
            r8 = r4
            goto L_0x009f
        L_0x009d:
            r17 = r12
        L_0x009f:
            java.lang.String r11 = "icy-name"
            java.lang.Object r11 = r7.get(r11)     // Catch:{ all -> 0x020d }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x020d }
            if (r11 == 0) goto L_0x00b3
            java.lang.Object r8 = r11.get(r5)     // Catch:{ all -> 0x020d }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x020d }
            r18 = r8
            r8 = r4
            goto L_0x00b5
        L_0x00b3:
            r18 = r12
        L_0x00b5:
            java.lang.String r11 = "icy-url"
            java.lang.Object r11 = r7.get(r11)     // Catch:{ all -> 0x020d }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x020d }
            if (r11 == 0) goto L_0x00c9
            java.lang.Object r8 = r11.get(r5)     // Catch:{ all -> 0x020d }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x020d }
            r19 = r8
            r8 = r4
            goto L_0x00cb
        L_0x00c9:
            r19 = r12
        L_0x00cb:
            java.lang.String r11 = "icy-pub"
            java.lang.Object r11 = r7.get(r11)     // Catch:{ all -> 0x020d }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x020d }
            if (r11 == 0) goto L_0x00e5
            java.lang.Object r8 = r11.get(r5)     // Catch:{ all -> 0x020d }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x020d }
            java.lang.String r11 = "1"
            boolean r8 = r8.equals(r11)     // Catch:{ all -> 0x020d }
            r20 = r8
            r8 = r4
            goto L_0x00e7
        L_0x00e5:
            r20 = r5
        L_0x00e7:
            java.lang.String r11 = "icy-metaint"
            java.lang.Object r7 = r7.get(r11)     // Catch:{ all -> 0x020d }
            java.util.List r7 = (java.util.List) r7     // Catch:{ all -> 0x020d }
            if (r7 == 0) goto L_0x0133
            java.lang.Object r7 = r7.get(r5)     // Catch:{ all -> 0x020d }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x020d }
            int r11 = java.lang.Integer.parseInt(r7)     // Catch:{ NumberFormatException -> 0x011a }
            if (r11 <= 0) goto L_0x00ff
            r8 = r4
            goto L_0x0117
        L_0x00ff:
            java.lang.String r15 = java.lang.String.valueOf(r7)     // Catch:{ NumberFormatException -> 0x011b }
            int r21 = r15.length()     // Catch:{ NumberFormatException -> 0x011b }
            if (r21 == 0) goto L_0x010e
            java.lang.String r15 = r0.concat(r15)     // Catch:{ NumberFormatException -> 0x011b }
            goto L_0x0113
        L_0x010e:
            java.lang.String r15 = new java.lang.String     // Catch:{ NumberFormatException -> 0x011b }
            r15.<init>(r0)     // Catch:{ NumberFormatException -> 0x011b }
        L_0x0113:
            android.util.Log.w(r9, r15)     // Catch:{ NumberFormatException -> 0x011b }
            r11 = r10
        L_0x0117:
            r21 = r11
            goto L_0x0135
        L_0x011a:
            r11 = r10
        L_0x011b:
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x020d }
            int r15 = r7.length()     // Catch:{ all -> 0x020d }
            if (r15 == 0) goto L_0x012a
            java.lang.String r7 = r0.concat(r7)     // Catch:{ all -> 0x020d }
            goto L_0x012f
        L_0x012a:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x020d }
            r7.<init>(r0)     // Catch:{ all -> 0x020d }
        L_0x012f:
            android.util.Log.w(r9, r7)     // Catch:{ all -> 0x020d }
            goto L_0x0117
        L_0x0133:
            r21 = r10
        L_0x0135:
            if (r8 == 0) goto L_0x013d
            com.google.android.gms.internal.ads.zzzd r12 = new com.google.android.gms.internal.ads.zzzd     // Catch:{ all -> 0x020d }
            r15 = r12
            r15.<init>(r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x020d }
        L_0x013d:
            r6.zzr = r12     // Catch:{ all -> 0x020d }
            com.google.android.gms.internal.ads.zzul r6 = r1.zzd     // Catch:{ all -> 0x020d }
            com.google.android.gms.internal.ads.zzqz r7 = r1.zza     // Catch:{ all -> 0x020d }
            com.google.android.gms.internal.ads.zzzd r7 = r7.zzr     // Catch:{ all -> 0x020d }
            if (r7 == 0) goto L_0x0172
            com.google.android.gms.internal.ads.zzqz r7 = r1.zza     // Catch:{ all -> 0x020d }
            com.google.android.gms.internal.ads.zzzd r7 = r7.zzr     // Catch:{ all -> 0x020d }
            int r7 = r7.zzf     // Catch:{ all -> 0x020d }
            if (r7 == r10) goto L_0x0172
            com.google.android.gms.internal.ads.zzpq r6 = new com.google.android.gms.internal.ads.zzpq     // Catch:{ all -> 0x020d }
            com.google.android.gms.internal.ads.zzul r7 = r1.zzd     // Catch:{ all -> 0x020d }
            com.google.android.gms.internal.ads.zzqz r8 = r1.zza     // Catch:{ all -> 0x020d }
            com.google.android.gms.internal.ads.zzzd r8 = r8.zzr     // Catch:{ all -> 0x020d }
            int r8 = r8.zzf     // Catch:{ all -> 0x020d }
            r6.<init>(r7, r8, r1)     // Catch:{ all -> 0x020d }
            com.google.android.gms.internal.ads.zzqz r7 = r1.zza     // Catch:{ all -> 0x020d }
            com.google.android.gms.internal.ads.zzxt r7 = r7.zzu()     // Catch:{ all -> 0x020d }
            r1.zzn = r7     // Catch:{ all -> 0x020d }
            com.google.android.gms.internal.ads.zzab r8 = com.google.android.gms.internal.ads.zzqz.zzc     // Catch:{ all -> 0x020d }
            r7.zzk(r8)     // Catch:{ all -> 0x020d }
        L_0x0172:
            r8 = r6
            com.google.android.gms.internal.ads.zzqq r7 = r1.zze     // Catch:{ all -> 0x020d }
            android.net.Uri r9 = r1.zzc     // Catch:{ all -> 0x020d }
            com.google.android.gms.internal.ads.zzul r6 = r1.zzd     // Catch:{ all -> 0x020d }
            java.util.Map r10 = r6.zza()     // Catch:{ all -> 0x020d }
            long r11 = r1.zzm     // Catch:{ all -> 0x020d }
            com.google.android.gms.internal.ads.zzws r15 = r1.zzf     // Catch:{ all -> 0x020d }
            r16 = r11
            r11 = r13
            r2 = r13
            r13 = r16
            r7.zzd(r8, r9, r10, r11, r13, r15)     // Catch:{ all -> 0x020d }
            com.google.android.gms.internal.ads.zzqz r6 = r1.zza     // Catch:{ all -> 0x020d }
            com.google.android.gms.internal.ads.zzzd r6 = r6.zzr     // Catch:{ all -> 0x020d }
            if (r6 == 0) goto L_0x0197
            com.google.android.gms.internal.ads.zzqq r6 = r1.zze     // Catch:{ all -> 0x020d }
            r6.zzc()     // Catch:{ all -> 0x020d }
        L_0x0197:
            boolean r6 = r1.zzj     // Catch:{ all -> 0x020d }
            if (r6 == 0) goto L_0x01a4
            com.google.android.gms.internal.ads.zzqq r6 = r1.zze     // Catch:{ all -> 0x020d }
            long r7 = r1.zzk     // Catch:{ all -> 0x020d }
            r6.zzf(r2, r7)     // Catch:{ all -> 0x020d }
            r1.zzj = r5     // Catch:{ all -> 0x020d }
        L_0x01a4:
            r13 = r2
            r2 = r5
        L_0x01a6:
            if (r2 != 0) goto L_0x01eb
            boolean r3 = r1.zzi     // Catch:{ all -> 0x01e8 }
            if (r3 != 0) goto L_0x01e6
            com.google.android.gms.internal.ads.zzeb r3 = r1.zzg     // Catch:{ InterruptedException -> 0x01e0 }
            r3.zza()     // Catch:{ InterruptedException -> 0x01e0 }
            com.google.android.gms.internal.ads.zzqq r3 = r1.zze     // Catch:{ all -> 0x01e8 }
            com.google.android.gms.internal.ads.zzxm r6 = r1.zzh     // Catch:{ all -> 0x01e8 }
            int r2 = r3.zza(r6)     // Catch:{ all -> 0x01e8 }
            com.google.android.gms.internal.ads.zzqq r3 = r1.zze     // Catch:{ all -> 0x01e8 }
            long r6 = r3.zzb()     // Catch:{ all -> 0x01e8 }
            com.google.android.gms.internal.ads.zzqz r3 = r1.zza     // Catch:{ all -> 0x01e8 }
            long r8 = r3.zzj     // Catch:{ all -> 0x01e8 }
            long r8 = r8 + r13
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 <= 0) goto L_0x01a6
            com.google.android.gms.internal.ads.zzeb r3 = r1.zzg     // Catch:{ all -> 0x01e8 }
            r3.zzc()     // Catch:{ all -> 0x01e8 }
            com.google.android.gms.internal.ads.zzqz r3 = r1.zza     // Catch:{ all -> 0x01e8 }
            android.os.Handler r3 = r3.zzp     // Catch:{ all -> 0x01e8 }
            com.google.android.gms.internal.ads.zzqz r8 = r1.zza     // Catch:{ all -> 0x01e8 }
            java.lang.Runnable r8 = r8.zzo     // Catch:{ all -> 0x01e8 }
            r3.post(r8)     // Catch:{ all -> 0x01e8 }
            r13 = r6
            goto L_0x01a6
        L_0x01e0:
            java.io.InterruptedIOException r0 = new java.io.InterruptedIOException     // Catch:{ all -> 0x01e8 }
            r0.<init>()     // Catch:{ all -> 0x01e8 }
            throw r0     // Catch:{ all -> 0x01e8 }
        L_0x01e6:
            r2 = r5
            goto L_0x01eb
        L_0x01e8:
            r0 = move-exception
            r5 = r2
            goto L_0x020e
        L_0x01eb:
            if (r2 != r4) goto L_0x01ee
            goto L_0x0205
        L_0x01ee:
            com.google.android.gms.internal.ads.zzqq r3 = r1.zze
            long r3 = r3.zzb()
            r5 = -1
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x0204
            com.google.android.gms.internal.ads.zzxm r3 = r1.zzh
            com.google.android.gms.internal.ads.zzqq r4 = r1.zze
            long r4 = r4.zzb()
            r3.zza = r4
        L_0x0204:
            r5 = r2
        L_0x0205:
            com.google.android.gms.internal.ads.zzul r2 = r1.zzd
            com.google.android.gms.internal.ads.zzfn.zzM(r2)
            if (r5 == 0) goto L_0x0004
            goto L_0x022c
        L_0x020d:
            r0 = move-exception
        L_0x020e:
            if (r5 == r4) goto L_0x0226
            com.google.android.gms.internal.ads.zzqq r2 = r1.zze
            long r2 = r2.zzb()
            r4 = -1
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0226
            com.google.android.gms.internal.ads.zzxm r2 = r1.zzh
            com.google.android.gms.internal.ads.zzqq r3 = r1.zze
            long r3 = r3.zzb()
            r2.zza = r3
        L_0x0226:
            com.google.android.gms.internal.ads.zzul r2 = r1.zzd
            com.google.android.gms.internal.ads.zzfn.zzM(r2)
            throw r0
        L_0x022c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqu.zzi():void");
    }
}
