package com.google.android.gms.internal.ads;

final class zzauu {
    private int zza = 1000;
    private int[] zzb = new int[1000];
    private long[] zzc = new long[1000];
    private int[] zzd = new int[1000];
    private int[] zze = new int[1000];
    private long[] zzf = new long[1000];
    private zzarr[] zzg = new zzarr[1000];
    private zzapg[] zzh = new zzapg[1000];
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private long zzm = Long.MIN_VALUE;
    private long zzn = Long.MIN_VALUE;
    private boolean zzo = true;
    private boolean zzp = true;
    private zzapg zzq;

    public final int zza() {
        return this.zzj + this.zzi;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001f, code lost:
        return -3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int zzb(com.google.android.gms.internal.ads.zzaph r5, com.google.android.gms.internal.ads.zzarb r6, boolean r7, boolean r8, com.google.android.gms.internal.ads.zzapg r9, com.google.android.gms.internal.ads.zzaut r10) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.zzl()     // Catch:{ all -> 0x0091 }
            r1 = -5
            r2 = -3
            r3 = -4
            if (r0 != 0) goto L_0x0020
            if (r8 == 0) goto L_0x0012
            r5 = 4
            r6.zzc(r5)     // Catch:{ all -> 0x0091 }
            monitor-exit(r4)
            return r3
        L_0x0012:
            com.google.android.gms.internal.ads.zzapg r6 = r4.zzq     // Catch:{ all -> 0x0091 }
            if (r6 == 0) goto L_0x001e
            if (r7 != 0) goto L_0x001a
            if (r6 == r9) goto L_0x001e
        L_0x001a:
            r5.zza = r6     // Catch:{ all -> 0x0091 }
            monitor-exit(r4)
            return r1
        L_0x001e:
            monitor-exit(r4)
            return r2
        L_0x0020:
            if (r7 != 0) goto L_0x0087
            com.google.android.gms.internal.ads.zzapg[] r7 = r4.zzh     // Catch:{ all -> 0x0091 }
            int r8 = r4.zzk     // Catch:{ all -> 0x0091 }
            r7 = r7[r8]     // Catch:{ all -> 0x0091 }
            if (r7 == r9) goto L_0x002b
            goto L_0x0087
        L_0x002b:
            java.nio.ByteBuffer r5 = r6.zzb     // Catch:{ all -> 0x0091 }
            if (r5 == 0) goto L_0x0085
            long[] r5 = r4.zzf     // Catch:{ all -> 0x0091 }
            r0 = r5[r8]     // Catch:{ all -> 0x0091 }
            r6.zzc = r0     // Catch:{ all -> 0x0091 }
            int[] r5 = r4.zze     // Catch:{ all -> 0x0091 }
            r5 = r5[r8]     // Catch:{ all -> 0x0091 }
            r6.zzc(r5)     // Catch:{ all -> 0x0091 }
            int[] r5 = r4.zzd     // Catch:{ all -> 0x0091 }
            int r7 = r4.zzk     // Catch:{ all -> 0x0091 }
            r5 = r5[r7]     // Catch:{ all -> 0x0091 }
            r10.zza = r5     // Catch:{ all -> 0x0091 }
            long[] r5 = r4.zzc     // Catch:{ all -> 0x0091 }
            r8 = r5[r7]     // Catch:{ all -> 0x0091 }
            r10.zzb = r8     // Catch:{ all -> 0x0091 }
            com.google.android.gms.internal.ads.zzarr[] r5 = r4.zzg     // Catch:{ all -> 0x0091 }
            r5 = r5[r7]     // Catch:{ all -> 0x0091 }
            r10.zzd = r5     // Catch:{ all -> 0x0091 }
            long r7 = r4.zzm     // Catch:{ all -> 0x0091 }
            long r5 = r6.zzc     // Catch:{ all -> 0x0091 }
            long r5 = java.lang.Math.max(r7, r5)     // Catch:{ all -> 0x0091 }
            r4.zzm = r5     // Catch:{ all -> 0x0091 }
            int r5 = r4.zzi     // Catch:{ all -> 0x0091 }
            int r5 = r5 + -1
            r4.zzi = r5     // Catch:{ all -> 0x0091 }
            int r6 = r4.zzk     // Catch:{ all -> 0x0091 }
            int r6 = r6 + 1
            r4.zzk = r6     // Catch:{ all -> 0x0091 }
            int r7 = r4.zzj     // Catch:{ all -> 0x0091 }
            int r7 = r7 + 1
            r4.zzj = r7     // Catch:{ all -> 0x0091 }
            int r7 = r4.zza     // Catch:{ all -> 0x0091 }
            if (r6 != r7) goto L_0x0073
            r6 = 0
            r4.zzk = r6     // Catch:{ all -> 0x0091 }
        L_0x0073:
            if (r5 <= 0) goto L_0x007a
            long[] r5 = r4.zzc     // Catch:{ all -> 0x0091 }
            r6 = r5[r6]     // Catch:{ all -> 0x0091 }
            goto L_0x0081
        L_0x007a:
            long r5 = r10.zzb     // Catch:{ all -> 0x0091 }
            int r7 = r10.zza     // Catch:{ all -> 0x0091 }
            long r7 = (long) r7     // Catch:{ all -> 0x0091 }
            long r6 = r5 + r7
        L_0x0081:
            r10.zzc = r6     // Catch:{ all -> 0x0091 }
            monitor-exit(r4)
            return r3
        L_0x0085:
            monitor-exit(r4)
            return r2
        L_0x0087:
            com.google.android.gms.internal.ads.zzapg[] r6 = r4.zzh     // Catch:{ all -> 0x0091 }
            int r7 = r4.zzk     // Catch:{ all -> 0x0091 }
            r6 = r6[r7]     // Catch:{ all -> 0x0091 }
            r5.zza = r6     // Catch:{ all -> 0x0091 }
            monitor-exit(r4)
            return r1
        L_0x0091:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzauu.zzb(com.google.android.gms.internal.ads.zzaph, com.google.android.gms.internal.ads.zzarb, boolean, boolean, com.google.android.gms.internal.ads.zzapg, com.google.android.gms.internal.ads.zzaut):int");
    }

    public final synchronized long zzc() {
        return Math.max(this.zzm, this.zzn);
    }

    public final synchronized long zzd() {
        if (!zzl()) {
            return -1;
        }
        int i11 = this.zzk;
        int i12 = this.zzi;
        int i13 = i11 + i12;
        int i14 = this.zza;
        int i15 = (i13 - 1) % i14;
        this.zzk = i13 % i14;
        this.zzj += i12;
        this.zzi = 0;
        return this.zzc[i15] + ((long) this.zzd[i15]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005d, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized long zze(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.zzl()     // Catch:{ all -> 0x005e }
            r1 = -1
            if (r0 == 0) goto L_0x005c
            long[] r0 = r8.zzf     // Catch:{ all -> 0x005e }
            int r3 = r8.zzk     // Catch:{ all -> 0x005e }
            r4 = r0[r3]     // Catch:{ all -> 0x005e }
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x0014
            goto L_0x005c
        L_0x0014:
            long r4 = r8.zzn     // Catch:{ all -> 0x005e }
            int r0 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            r4 = 0
            r5 = -1
            if (r0 <= 0) goto L_0x0021
            if (r11 == 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            monitor-exit(r8)
            return r1
        L_0x0021:
            r11 = r5
        L_0x0022:
            int r0 = r8.zzl     // Catch:{ all -> 0x005e }
            if (r3 == r0) goto L_0x0040
            long[] r0 = r8.zzf     // Catch:{ all -> 0x005e }
            r6 = r0[r3]     // Catch:{ all -> 0x005e }
            int r0 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r0 <= 0) goto L_0x002f
            goto L_0x0040
        L_0x002f:
            int[] r0 = r8.zze     // Catch:{ all -> 0x005e }
            r0 = r0[r3]     // Catch:{ all -> 0x005e }
            r6 = 1
            r0 = r0 & r6
            if (r6 != r0) goto L_0x0038
            r11 = r4
        L_0x0038:
            int r3 = r3 + 1
            int r0 = r8.zza     // Catch:{ all -> 0x005e }
            int r3 = r3 % r0
            int r4 = r4 + 1
            goto L_0x0022
        L_0x0040:
            if (r11 != r5) goto L_0x0044
            monitor-exit(r8)
            return r1
        L_0x0044:
            int r9 = r8.zzk     // Catch:{ all -> 0x005e }
            int r9 = r9 + r11
            int r10 = r8.zza     // Catch:{ all -> 0x005e }
            int r9 = r9 % r10
            r8.zzk = r9     // Catch:{ all -> 0x005e }
            int r10 = r8.zzj     // Catch:{ all -> 0x005e }
            int r10 = r10 + r11
            r8.zzj = r10     // Catch:{ all -> 0x005e }
            int r10 = r8.zzi     // Catch:{ all -> 0x005e }
            int r10 = r10 - r11
            r8.zzi = r10     // Catch:{ all -> 0x005e }
            long[] r10 = r8.zzc     // Catch:{ all -> 0x005e }
            r9 = r10[r9]     // Catch:{ all -> 0x005e }
            monitor-exit(r8)
            return r9
        L_0x005c:
            monitor-exit(r8)
            return r1
        L_0x005e:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzauu.zze(long, boolean):long");
    }

    public final synchronized zzapg zzf() {
        if (this.zzp) {
            return null;
        }
        return this.zzq;
    }

    public final void zzg() {
        this.zzj = 0;
        this.zzk = 0;
        this.zzl = 0;
        this.zzi = 0;
        this.zzo = true;
    }

    public final synchronized void zzh(long j11, int i11, long j12, int i12, zzarr zzarr) {
        if (this.zzo) {
            if ((i11 & 1) != 0) {
                this.zzo = false;
            } else {
                return;
            }
        }
        zzawm.zze(!this.zzp);
        zzi(j11);
        long[] jArr = this.zzf;
        int i13 = this.zzl;
        jArr[i13] = j11;
        long[] jArr2 = this.zzc;
        jArr2[i13] = j12;
        this.zzd[i13] = i12;
        this.zze[i13] = i11;
        this.zzg[i13] = zzarr;
        this.zzh[i13] = this.zzq;
        this.zzb[i13] = 0;
        int i14 = this.zzi + 1;
        this.zzi = i14;
        int i15 = this.zza;
        if (i14 == i15) {
            int i16 = i15 + 1000;
            int[] iArr = new int[i16];
            long[] jArr3 = new long[i16];
            long[] jArr4 = new long[i16];
            int[] iArr2 = new int[i16];
            int[] iArr3 = new int[i16];
            zzarr[] zzarrArr = new zzarr[i16];
            zzapg[] zzapgArr = new zzapg[i16];
            int i17 = this.zzk;
            int i18 = i15 - i17;
            System.arraycopy(jArr2, i17, jArr3, 0, i18);
            System.arraycopy(this.zzf, this.zzk, jArr4, 0, i18);
            System.arraycopy(this.zze, this.zzk, iArr2, 0, i18);
            System.arraycopy(this.zzd, this.zzk, iArr3, 0, i18);
            System.arraycopy(this.zzg, this.zzk, zzarrArr, 0, i18);
            System.arraycopy(this.zzh, this.zzk, zzapgArr, 0, i18);
            System.arraycopy(this.zzb, this.zzk, iArr, 0, i18);
            int i19 = this.zzk;
            System.arraycopy(this.zzc, 0, jArr3, i18, i19);
            System.arraycopy(this.zzf, 0, jArr4, i18, i19);
            System.arraycopy(this.zze, 0, iArr2, i18, i19);
            System.arraycopy(this.zzd, 0, iArr3, i18, i19);
            System.arraycopy(this.zzg, 0, zzarrArr, i18, i19);
            System.arraycopy(this.zzh, 0, zzapgArr, i18, i19);
            System.arraycopy(this.zzb, 0, iArr, i18, i19);
            this.zzc = jArr3;
            this.zzf = jArr4;
            this.zze = iArr2;
            this.zzd = iArr3;
            this.zzg = zzarrArr;
            this.zzh = zzapgArr;
            this.zzb = iArr;
            this.zzk = 0;
            int i21 = this.zza;
            this.zzl = i21;
            this.zzi = i21;
            this.zza = i16;
            return;
        }
        int i22 = i13 + 1;
        this.zzl = i22;
        if (i22 == i15) {
            this.zzl = 0;
        }
    }

    public final synchronized void zzi(long j11) {
        this.zzn = Math.max(this.zzn, j11);
    }

    public final void zzj() {
        this.zzm = Long.MIN_VALUE;
        this.zzn = Long.MIN_VALUE;
    }

    public final synchronized boolean zzk(zzapg zzapg) {
        if (zzapg == null) {
            this.zzp = true;
            return false;
        }
        this.zzp = false;
        if (zzaxb.zzo(zzapg, this.zzq)) {
            return false;
        }
        this.zzq = zzapg;
        return true;
    }

    public final synchronized boolean zzl() {
        return this.zzi != 0;
    }
}
