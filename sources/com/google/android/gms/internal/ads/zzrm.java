package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.io.IOException;

public final class zzrm implements zzxt {
    @Nullable
    private zzab zzA;
    private boolean zzB;
    private boolean zzC;
    @Nullable
    private zznl zzD;
    private final zzrg zza;
    private final zzri zzb = new zzri();
    private final zzrt<zzrk> zzc = new zzrt<>(zzrh.zza);
    @Nullable
    private final zznk zzd;
    @Nullable
    private final zzne zze;
    @Nullable
    private final Looper zzf;
    @Nullable
    private zzrl zzg;
    @Nullable
    private zzab zzh;
    private int zzi = 1000;
    private int[] zzj = new int[1000];
    private long[] zzk = new long[1000];
    private int[] zzl = new int[1000];
    private int[] zzm = new int[1000];
    private long[] zzn = new long[1000];
    private zzxs[] zzo = new zzxs[1000];
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private long zzt = Long.MIN_VALUE;
    private long zzu = Long.MIN_VALUE;
    private long zzv = Long.MIN_VALUE;
    private boolean zzw;
    private boolean zzx = true;
    private boolean zzy = true;
    @Nullable
    private zzab zzz;

    public zzrm(zztk zztk, @Nullable Looper looper, @Nullable zznk zznk, @Nullable zzne zzne, byte[] bArr) {
        this.zzf = looper;
        this.zzd = zznk;
        this.zze = zzne;
        this.zza = new zzrg(zztk, (byte[]) null);
    }

    private final int zzA(int i11) {
        int i12 = this.zzr + i11;
        int i13 = this.zzi;
        return i12 < i13 ? i12 : i12 - i13;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0024, code lost:
        return -3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized int zzB(com.google.android.gms.internal.ads.zzhr r6, com.google.android.gms.internal.ads.zzda r7, boolean r8, boolean r9, com.google.android.gms.internal.ads.zzri r10) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r7.zzc = r0     // Catch:{ all -> 0x0083 }
            boolean r0 = r5.zzJ()     // Catch:{ all -> 0x0083 }
            r1 = -5
            r2 = -3
            r3 = -4
            if (r0 != 0) goto L_0x002b
            if (r9 != 0) goto L_0x0025
            boolean r9 = r5.zzw     // Catch:{ all -> 0x0083 }
            if (r9 == 0) goto L_0x0014
            goto L_0x0025
        L_0x0014:
            com.google.android.gms.internal.ads.zzab r7 = r5.zzA     // Catch:{ all -> 0x0083 }
            if (r7 == 0) goto L_0x0023
            if (r8 != 0) goto L_0x001e
            com.google.android.gms.internal.ads.zzab r8 = r5.zzh     // Catch:{ all -> 0x0083 }
            if (r7 == r8) goto L_0x0023
        L_0x001e:
            r5.zzG(r7, r6)     // Catch:{ all -> 0x0083 }
            monitor-exit(r5)
            return r1
        L_0x0023:
            monitor-exit(r5)
            return r2
        L_0x0025:
            r6 = 4
            r7.zzc(r6)     // Catch:{ all -> 0x0083 }
            monitor-exit(r5)
            return r3
        L_0x002b:
            com.google.android.gms.internal.ads.zzrt<com.google.android.gms.internal.ads.zzrk> r9 = r5.zzc     // Catch:{ all -> 0x0083 }
            int r0 = r5.zzq     // Catch:{ all -> 0x0083 }
            int r4 = r5.zzs     // Catch:{ all -> 0x0083 }
            int r0 = r0 + r4
            java.lang.Object r9 = r9.zza(r0)     // Catch:{ all -> 0x0083 }
            com.google.android.gms.internal.ads.zzrk r9 = (com.google.android.gms.internal.ads.zzrk) r9     // Catch:{ all -> 0x0083 }
            com.google.android.gms.internal.ads.zzab r9 = r9.zza     // Catch:{ all -> 0x0083 }
            if (r8 != 0) goto L_0x007e
            com.google.android.gms.internal.ads.zzab r8 = r5.zzh     // Catch:{ all -> 0x0083 }
            if (r9 == r8) goto L_0x0041
            goto L_0x007e
        L_0x0041:
            int r6 = r5.zzs     // Catch:{ all -> 0x0083 }
            int r6 = r5.zzA(r6)     // Catch:{ all -> 0x0083 }
            boolean r8 = r5.zzK(r6)     // Catch:{ all -> 0x0083 }
            if (r8 != 0) goto L_0x0052
            r6 = 1
            r7.zzc = r6     // Catch:{ all -> 0x0083 }
            monitor-exit(r5)
            return r2
        L_0x0052:
            int[] r8 = r5.zzm     // Catch:{ all -> 0x0083 }
            r8 = r8[r6]     // Catch:{ all -> 0x0083 }
            r7.zzc(r8)     // Catch:{ all -> 0x0083 }
            long[] r8 = r5.zzn     // Catch:{ all -> 0x0083 }
            r0 = r8[r6]     // Catch:{ all -> 0x0083 }
            r7.zzd = r0     // Catch:{ all -> 0x0083 }
            long r8 = r5.zzt     // Catch:{ all -> 0x0083 }
            int r8 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r8 >= 0) goto L_0x006a
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            r7.zza(r8)     // Catch:{ all -> 0x0083 }
        L_0x006a:
            int[] r7 = r5.zzl     // Catch:{ all -> 0x0083 }
            r7 = r7[r6]     // Catch:{ all -> 0x0083 }
            r10.zza = r7     // Catch:{ all -> 0x0083 }
            long[] r7 = r5.zzk     // Catch:{ all -> 0x0083 }
            r8 = r7[r6]     // Catch:{ all -> 0x0083 }
            r10.zzb = r8     // Catch:{ all -> 0x0083 }
            com.google.android.gms.internal.ads.zzxs[] r7 = r5.zzo     // Catch:{ all -> 0x0083 }
            r6 = r7[r6]     // Catch:{ all -> 0x0083 }
            r10.zzc = r6     // Catch:{ all -> 0x0083 }
            monitor-exit(r5)
            return r3
        L_0x007e:
            r5.zzG(r9, r6)     // Catch:{ all -> 0x0083 }
            monitor-exit(r5)
            return r1
        L_0x0083:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrm.zzB(com.google.android.gms.internal.ads.zzhr, com.google.android.gms.internal.ads.zzda, boolean, boolean, com.google.android.gms.internal.ads.zzri):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002e, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized long zzC(long r10, boolean r12, boolean r13) {
        /*
            r9 = this;
            monitor-enter(r9)
            int r12 = r9.zzp     // Catch:{ all -> 0x002f }
            r0 = -1
            if (r12 == 0) goto L_0x002d
            long[] r2 = r9.zzn     // Catch:{ all -> 0x002f }
            int r4 = r9.zzr     // Catch:{ all -> 0x002f }
            r5 = r2[r4]     // Catch:{ all -> 0x002f }
            int r2 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x0012
            goto L_0x002d
        L_0x0012:
            if (r13 == 0) goto L_0x001a
            int r13 = r9.zzs     // Catch:{ all -> 0x002f }
            if (r13 == r12) goto L_0x001a
            int r12 = r13 + 1
        L_0x001a:
            r5 = r12
            r8 = 0
            r3 = r9
            r6 = r10
            int r10 = r3.zzz(r4, r5, r6, r8)     // Catch:{ all -> 0x002f }
            r11 = -1
            if (r10 != r11) goto L_0x0027
            monitor-exit(r9)
            return r0
        L_0x0027:
            long r10 = r9.zzE(r10)     // Catch:{ all -> 0x002f }
            monitor-exit(r9)
            return r10
        L_0x002d:
            monitor-exit(r9)
            return r0
        L_0x002f:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrm.zzC(long, boolean, boolean):long");
    }

    private final synchronized long zzD() {
        int i11 = this.zzp;
        if (i11 == 0) {
            return -1;
        }
        return zzE(i11);
    }

    @GuardedBy("this")
    private final long zzE(int i11) {
        long j11 = this.zzu;
        long j12 = Long.MIN_VALUE;
        if (i11 != 0) {
            int zzA2 = zzA(i11 - 1);
            for (int i12 = 0; i12 < i11; i12++) {
                j12 = Math.max(j12, this.zzn[zzA2]);
                if ((this.zzm[zzA2] & 1) != 0) {
                    break;
                }
                zzA2--;
                if (zzA2 == -1) {
                    zzA2 = this.zzi - 1;
                }
            }
        }
        this.zzu = Math.max(j11, j12);
        this.zzp -= i11;
        int i13 = this.zzq + i11;
        this.zzq = i13;
        int i14 = this.zzr + i11;
        this.zzr = i14;
        int i15 = this.zzi;
        if (i14 >= i15) {
            this.zzr = i14 - i15;
        }
        int i16 = this.zzs - i11;
        this.zzs = i16;
        if (i16 < 0) {
            this.zzs = 0;
        }
        this.zzc.zze(i13);
        if (this.zzp != 0) {
            return this.zzk[this.zzr];
        }
        int i17 = this.zzr;
        if (i17 == 0) {
            i17 = this.zzi;
        }
        int i18 = i17 - 1;
        return this.zzk[i18] + ((long) this.zzl[i18]);
    }

    private final synchronized void zzF(long j11, int i11, long j12, int i12, @Nullable zzxs zzxs) {
        boolean z11;
        boolean z12;
        int i13 = this.zzp;
        if (i13 > 0) {
            int zzA2 = zzA(i13 - 1);
            if (this.zzk[zzA2] + ((long) this.zzl[zzA2]) <= j12) {
                z12 = true;
            } else {
                z12 = false;
            }
            zzdy.zzd(z12);
        }
        if ((536870912 & i11) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.zzw = z11;
        this.zzv = Math.max(this.zzv, j11);
        int zzA3 = zzA(this.zzp);
        this.zzn[zzA3] = j11;
        this.zzk[zzA3] = j12;
        this.zzl[zzA3] = i12;
        this.zzm[zzA3] = i11;
        this.zzo[zzA3] = zzxs;
        this.zzj[zzA3] = 0;
        if (this.zzc.zzf() || !this.zzc.zzb().zza.equals(this.zzA)) {
            zznj zznj = zznj.zzb;
            zzrt<zzrk> zzrt = this.zzc;
            int i14 = this.zzq + this.zzp;
            zzab zzab = this.zzA;
            zzab.getClass();
            zzrt.zzc(i14, new zzrk(zzab, zznj, (zzrj) null));
        }
        int i15 = this.zzp + 1;
        this.zzp = i15;
        int i16 = this.zzi;
        if (i15 == i16) {
            int i17 = i16 + 1000;
            int[] iArr = new int[i17];
            long[] jArr = new long[i17];
            long[] jArr2 = new long[i17];
            int[] iArr2 = new int[i17];
            int[] iArr3 = new int[i17];
            zzxs[] zzxsArr = new zzxs[i17];
            int i18 = this.zzr;
            int i19 = i16 - i18;
            System.arraycopy(this.zzk, i18, jArr, 0, i19);
            System.arraycopy(this.zzn, this.zzr, jArr2, 0, i19);
            System.arraycopy(this.zzm, this.zzr, iArr2, 0, i19);
            System.arraycopy(this.zzl, this.zzr, iArr3, 0, i19);
            System.arraycopy(this.zzo, this.zzr, zzxsArr, 0, i19);
            System.arraycopy(this.zzj, this.zzr, iArr, 0, i19);
            int i21 = this.zzr;
            System.arraycopy(this.zzk, 0, jArr, i19, i21);
            System.arraycopy(this.zzn, 0, jArr2, i19, i21);
            System.arraycopy(this.zzm, 0, iArr2, i19, i21);
            System.arraycopy(this.zzl, 0, iArr3, i19, i21);
            System.arraycopy(this.zzo, 0, zzxsArr, i19, i21);
            System.arraycopy(this.zzj, 0, iArr, i19, i21);
            this.zzk = jArr;
            this.zzn = jArr2;
            this.zzm = iArr2;
            this.zzl = iArr3;
            this.zzo = zzxsArr;
            this.zzj = iArr;
            this.zzr = 0;
            this.zzi = i17;
        }
    }

    private final void zzG(zzab zzab, zzhr zzhr) {
        zzs zzs2;
        zzab zzab2 = this.zzh;
        zznl zznl = null;
        if (zzab2 == null) {
            zzs2 = null;
        } else {
            zzs2 = zzab2.zzp;
        }
        this.zzh = zzab;
        zzs zzs3 = zzab.zzp;
        zzhr.zza = zzab.zzc(this.zzd.zza(zzab));
        zzhr.zzb = this.zzD;
        if (zzab2 == null || !zzfn.zzP(zzs2, zzs3)) {
            if (zzab.zzp != null) {
                zznl = new zznl(new zznc(new zznn(1), 6001));
            }
            this.zzD = zznl;
            zzhr.zzb = zznl;
        }
    }

    private final void zzH() {
        if (this.zzD != null) {
            this.zzD = null;
            this.zzh = null;
        }
    }

    private final synchronized void zzI() {
        this.zzs = 0;
        this.zza.zzg();
    }

    private final boolean zzJ() {
        return this.zzs != this.zzp;
    }

    private final boolean zzK(int i11) {
        if (this.zzD != null) {
            return (this.zzm[i11] & 1073741824) != 0 ? false : false;
        }
        return true;
    }

    private final synchronized boolean zzL(zzab zzab) {
        this.zzy = false;
        if (zzfn.zzP(zzab, this.zzA)) {
            return false;
        }
        if (this.zzc.zzf() || !this.zzc.zzb().zza.equals(zzab)) {
            this.zzA = zzab;
        } else {
            this.zzA = this.zzc.zzb().zza;
        }
        zzab zzab2 = this.zzA;
        this.zzB = zzbi.zzf(zzab2.zzm, zzab2.zzj);
        this.zzC = false;
        return true;
    }

    public static /* synthetic */ void zzl(zzrk zzrk) {
        zznj zznj = zzrk.zzb;
        int i11 = zzni.zza;
    }

    private final int zzz(int i11, int i12, long j11, boolean z11) {
        int i13 = -1;
        for (int i14 = 0; i14 < i12; i14++) {
            int i15 = (this.zzn[i11] > j11 ? 1 : (this.zzn[i11] == j11 ? 0 : -1));
            if (i15 > 0) {
                break;
            }
            if (!z11 || (this.zzm[i11] & 1) != 0) {
                i13 = i14;
                if (i15 == 0) {
                    break;
                }
            }
            i11++;
            if (i11 == this.zzi) {
                i11 = 0;
            }
        }
        return i13;
    }

    public final int zza() {
        return this.zzq + this.zzs;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
        if (r9 != -1) goto L_0x0039;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0038, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0039, code lost:
        return r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003b, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int zzb(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            int r0 = r8.zzs     // Catch:{ all -> 0x003c }
            int r2 = r8.zzA(r0)     // Catch:{ all -> 0x003c }
            boolean r0 = r8.zzJ()     // Catch:{ all -> 0x003c }
            r7 = 0
            if (r0 == 0) goto L_0x003a
            long[] r0 = r8.zzn     // Catch:{ all -> 0x003c }
            r3 = r0[r2]     // Catch:{ all -> 0x003c }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0017
            goto L_0x003a
        L_0x0017:
            long r0 = r8.zzv     // Catch:{ all -> 0x003c }
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0027
            if (r11 != 0) goto L_0x0020
            goto L_0x0027
        L_0x0020:
            int r9 = r8.zzp     // Catch:{ all -> 0x003c }
            int r10 = r8.zzs     // Catch:{ all -> 0x003c }
            int r9 = r9 - r10
            monitor-exit(r8)
            return r9
        L_0x0027:
            int r11 = r8.zzp     // Catch:{ all -> 0x003c }
            int r0 = r8.zzs     // Catch:{ all -> 0x003c }
            int r3 = r11 - r0
            r6 = 1
            r1 = r8
            r4 = r9
            int r9 = r1.zzz(r2, r3, r4, r6)     // Catch:{ all -> 0x003c }
            r10 = -1
            monitor-exit(r8)
            if (r9 != r10) goto L_0x0039
            return r7
        L_0x0039:
            return r9
        L_0x003a:
            monitor-exit(r8)
            return r7
        L_0x003c:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrm.zzb(long, boolean):int");
    }

    public final int zzc() {
        return this.zzq + this.zzp;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        if (r9 != 0) goto L_0x003d;
     */
    @androidx.annotation.CallSuper
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzd(com.google.android.gms.internal.ads.zzhr r9, com.google.android.gms.internal.ads.zzda r10, int r11, boolean r12) {
        /*
            r8 = this;
            r0 = r11 & 2
            r1 = 1
            if (r0 == 0) goto L_0x0007
            r5 = r1
            goto L_0x0009
        L_0x0007:
            r0 = 0
            r5 = r0
        L_0x0009:
            com.google.android.gms.internal.ads.zzri r7 = r8.zzb
            r2 = r8
            r3 = r9
            r4 = r10
            r6 = r12
            int r9 = r2.zzB(r3, r4, r5, r6, r7)
            r12 = -4
            if (r9 != r12) goto L_0x003e
            boolean r9 = r10.zzg()
            if (r9 != 0) goto L_0x003d
            r9 = r11 & 1
            r11 = r11 & 4
            if (r11 != 0) goto L_0x0034
            if (r9 == 0) goto L_0x002c
            com.google.android.gms.internal.ads.zzrg r9 = r8.zza
            com.google.android.gms.internal.ads.zzri r11 = r8.zzb
            r9.zzd(r10, r11)
            goto L_0x003d
        L_0x002c:
            com.google.android.gms.internal.ads.zzrg r9 = r8.zza
            com.google.android.gms.internal.ads.zzri r11 = r8.zzb
            r9.zze(r10, r11)
            goto L_0x0037
        L_0x0034:
            if (r9 == 0) goto L_0x0037
            goto L_0x003d
        L_0x0037:
            int r9 = r8.zzs
            int r9 = r9 + r1
            r8.zzs = r9
            return r12
        L_0x003d:
            r9 = r12
        L_0x003e:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrm.zzd(com.google.android.gms.internal.ads.zzhr, com.google.android.gms.internal.ads.zzda, int, boolean):int");
    }

    public final /* synthetic */ int zze(zzdg zzdg, int i11, boolean z11) {
        return zzxr.zza(this, zzdg, i11, true);
    }

    public final int zzf(zzdg zzdg, int i11, boolean z11, int i12) throws IOException {
        return this.zza.zza(zzdg, i11, z11);
    }

    public final synchronized long zzg() {
        return this.zzv;
    }

    @Nullable
    public final synchronized zzab zzh() {
        if (this.zzy) {
            return null;
        }
        return this.zzA;
    }

    public final void zzi(long j11, boolean z11, boolean z12) {
        this.zza.zzc(zzC(j11, false, z12));
    }

    public final void zzj() {
        this.zza.zzc(zzD());
    }

    public final void zzk(zzab zzab) {
        this.zzz = zzab;
        boolean zzL = zzL(zzab);
        zzrl zzrl = this.zzg;
        if (zzrl != null && zzL) {
            zzrl.zzJ(zzab);
        }
    }

    @CallSuper
    public final void zzm() throws IOException {
        zznl zznl = this.zzD;
        if (zznl != null) {
            throw zznl.zza();
        }
    }

    @CallSuper
    public final void zzn() {
        zzj();
        zzH();
    }

    @CallSuper
    public final void zzo() {
        zzp(true);
        zzH();
    }

    @CallSuper
    public final void zzp(boolean z11) {
        this.zza.zzf();
        this.zzp = 0;
        this.zzq = 0;
        this.zzr = 0;
        this.zzs = 0;
        this.zzx = true;
        this.zzt = Long.MIN_VALUE;
        this.zzu = Long.MIN_VALUE;
        this.zzv = Long.MIN_VALUE;
        this.zzw = false;
        this.zzc.zzd();
        if (z11) {
            this.zzz = null;
            this.zzA = null;
            this.zzy = true;
        }
    }

    public final /* synthetic */ void zzq(zzfd zzfd, int i11) {
        zzxr.zzb(this, zzfd, i11);
    }

    public final void zzr(zzfd zzfd, int i11, int i12) {
        this.zza.zzh(zzfd, i11);
    }

    public final void zzs(long j11, int i11, int i12, int i13, @Nullable zzxs zzxs) {
        int i14 = i11 & 1;
        if (this.zzx) {
            if (i14 != 0) {
                this.zzx = false;
            } else {
                return;
            }
        }
        if (this.zzB) {
            if (j11 >= this.zzt) {
                if (i14 == 0) {
                    if (!this.zzC) {
                        Log.w("SampleQueue", "Overriding unexpected non-sync sample for format: ".concat(String.valueOf(this.zzA)));
                        this.zzC = true;
                    }
                    i11 |= 1;
                }
            } else {
                return;
            }
        }
        zzF(j11, i11, (this.zza.zzb() - ((long) i12)) - ((long) i13), i12, zzxs);
    }

    public final void zzt(long j11) {
        this.zzt = j11;
    }

    public final void zzu(@Nullable zzrl zzrl) {
        this.zzg = zzrl;
    }

    public final synchronized void zzv(int i11) {
        boolean z11 = false;
        if (i11 >= 0) {
            try {
                if (this.zzs + i11 <= this.zzp) {
                    z11 = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        zzdy.zzd(z11);
        this.zzs += i11;
    }

    public final synchronized boolean zzw() {
        return this.zzw;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001c, code lost:
        return r1;
     */
    @androidx.annotation.CallSuper
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzx(boolean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzJ()     // Catch:{ all -> 0x003e }
            r1 = 1
            if (r0 != 0) goto L_0x001d
            if (r4 != 0) goto L_0x001b
            boolean r4 = r3.zzw     // Catch:{ all -> 0x003e }
            if (r4 != 0) goto L_0x001b
            com.google.android.gms.internal.ads.zzab r4 = r3.zzA     // Catch:{ all -> 0x003e }
            r0 = 0
            if (r4 == 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzab r2 = r3.zzh     // Catch:{ all -> 0x003e }
            if (r4 == r2) goto L_0x0018
            goto L_0x001b
        L_0x0018:
            monitor-exit(r3)
            return r0
        L_0x001a:
            r1 = r0
        L_0x001b:
            monitor-exit(r3)
            return r1
        L_0x001d:
            com.google.android.gms.internal.ads.zzrt<com.google.android.gms.internal.ads.zzrk> r4 = r3.zzc     // Catch:{ all -> 0x003e }
            int r0 = r3.zzq     // Catch:{ all -> 0x003e }
            int r2 = r3.zzs     // Catch:{ all -> 0x003e }
            int r0 = r0 + r2
            java.lang.Object r4 = r4.zza(r0)     // Catch:{ all -> 0x003e }
            com.google.android.gms.internal.ads.zzrk r4 = (com.google.android.gms.internal.ads.zzrk) r4     // Catch:{ all -> 0x003e }
            com.google.android.gms.internal.ads.zzab r4 = r4.zza     // Catch:{ all -> 0x003e }
            com.google.android.gms.internal.ads.zzab r0 = r3.zzh     // Catch:{ all -> 0x003e }
            if (r4 == r0) goto L_0x0032
            monitor-exit(r3)
            return r1
        L_0x0032:
            int r4 = r3.zzs     // Catch:{ all -> 0x003e }
            int r4 = r3.zzA(r4)     // Catch:{ all -> 0x003e }
            boolean r4 = r3.zzK(r4)     // Catch:{ all -> 0x003e }
            monitor-exit(r3)
            return r4
        L_0x003e:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrm.zzx(boolean):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzy(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            r8.zzI()     // Catch:{ all -> 0x003f }
            int r0 = r8.zzs     // Catch:{ all -> 0x003f }
            int r2 = r8.zzA(r0)     // Catch:{ all -> 0x003f }
            boolean r0 = r8.zzJ()     // Catch:{ all -> 0x003f }
            r7 = 0
            if (r0 == 0) goto L_0x003d
            long[] r0 = r8.zzn     // Catch:{ all -> 0x003f }
            r3 = r0[r2]     // Catch:{ all -> 0x003f }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x003d
            long r0 = r8.zzv     // Catch:{ all -> 0x003f }
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0021
            if (r11 == 0) goto L_0x003d
        L_0x0021:
            int r11 = r8.zzp     // Catch:{ all -> 0x003f }
            int r0 = r8.zzs     // Catch:{ all -> 0x003f }
            int r3 = r11 - r0
            r6 = 1
            r1 = r8
            r4 = r9
            int r11 = r1.zzz(r2, r3, r4, r6)     // Catch:{ all -> 0x003f }
            r0 = -1
            if (r11 != r0) goto L_0x0033
            monitor-exit(r8)
            return r7
        L_0x0033:
            r8.zzt = r9     // Catch:{ all -> 0x003f }
            int r9 = r8.zzs     // Catch:{ all -> 0x003f }
            int r9 = r9 + r11
            r8.zzs = r9     // Catch:{ all -> 0x003f }
            monitor-exit(r8)
            r9 = 1
            return r9
        L_0x003d:
            monitor-exit(r8)
            return r7
        L_0x003f:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrm.zzy(long, boolean):boolean");
    }
}
