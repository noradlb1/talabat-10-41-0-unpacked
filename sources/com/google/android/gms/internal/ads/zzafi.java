package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.util.MimeTypes;
import com.huawei.location.lite.common.http.exception.ErrorCode;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.jar.asm.Opcodes;

final class zzafi implements zzafj {
    private static final int[] zza = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
    private static final int[] zzb = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, Opcodes.D2L, Opcodes.IFGT, Opcodes.LRETURN, 190, 209, 230, 253, 279, 307, 337, 371, ErrorCode.HTTP_CLIENT_TIMEOUT, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, Advice.MethodSizeHandler.UNDEFINED_SIZE};
    private final zzws zzc;
    private final zzxt zzd;
    private final zzafm zze;
    private final int zzf;
    private final byte[] zzg;
    private final zzfd zzh;
    private final int zzi;
    private final zzab zzj;
    private int zzk;
    private long zzl;
    private int zzm;
    private long zzn;

    public zzafi(zzws zzws, zzxt zzxt, zzafm zzafm) throws zzbj {
        this.zzc = zzws;
        this.zzd = zzxt;
        this.zze = zzafm;
        int max = Math.max(1, zzafm.zzc / 10);
        this.zzi = max;
        zzfd zzfd = new zzfd(zzafm.zzf);
        zzfd.zzi();
        int zzi2 = zzfd.zzi();
        this.zzf = zzi2;
        int i11 = zzafm.zzb;
        int i12 = (((zzafm.zzd - (i11 * 4)) * 8) / (zzafm.zze * i11)) + 1;
        if (zzi2 == i12) {
            int zze2 = zzfn.zze(max, zzi2);
            this.zzg = new byte[(zzafm.zzd * zze2)];
            this.zzh = new zzfd(zze2 * (zzi2 + zzi2) * i11);
            int i13 = ((zzafm.zzc * zzafm.zzd) * 8) / zzi2;
            zzz zzz = new zzz();
            zzz.zzS(MimeTypes.AUDIO_RAW);
            zzz.zzv(i13);
            zzz.zzO(i13);
            zzz.zzL((max + max) * i11);
            zzz.zzw(zzafm.zzb);
            zzz.zzT(zzafm.zzc);
            zzz.zzN(2);
            this.zzj = zzz.zzY();
            return;
        }
        StringBuilder sb2 = new StringBuilder(56);
        sb2.append("Expected frames per block: ");
        sb2.append(i12);
        sb2.append("; got: ");
        sb2.append(zzi2);
        throw zzbj.zza(sb2.toString(), (Throwable) null);
    }

    private final int zzd(int i11) {
        int i12 = this.zze.zzb;
        return i11 / (i12 + i12);
    }

    private final int zze(int i11) {
        return (i11 + i11) * this.zze.zzb;
    }

    private final void zzf(int i11) {
        long j11 = this.zzl;
        long zzt = zzfn.zzt(this.zzn, 1000000, (long) this.zze.zzc);
        int zze2 = zze(i11);
        this.zzd.zzs(j11 + zzt, 1, zze2, this.zzm - zze2, (zzxs) null);
        this.zzn += (long) i11;
        this.zzm -= zze2;
    }

    public final void zza(int i11, long j11) {
        this.zzc.zzL(new zzafp(this.zze, this.zzf, (long) i11, j11));
        this.zzd.zzk(this.zzj);
    }

    public final void zzb(long j11) {
        this.zzk = 0;
        this.zzl = j11;
        this.zzm = 0;
        this.zzn = 0;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0043 A[EDGE_INSN: B:38:0x0043->B:10:0x0043 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0023  */
    public final boolean zzc(com.google.android.gms.internal.ads.zzwq r20, long r21) throws java.io.IOException {
        /*
            r19 = this;
            r0 = r19
            r1 = r21
            int r3 = r0.zzi
            int r4 = r0.zzm
            int r4 = r0.zzd(r4)
            int r3 = r3 - r4
            int r4 = r0.zzf
            int r3 = com.google.android.gms.internal.ads.zzfn.zze(r3, r4)
            com.google.android.gms.internal.ads.zzafm r4 = r0.zze
            int r4 = r4.zzd
            int r3 = r3 * r4
            r4 = 0
            int r4 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r4 != 0) goto L_0x0020
        L_0x001e:
            r4 = 1
            goto L_0x0021
        L_0x0020:
            r4 = 0
        L_0x0021:
            if (r4 != 0) goto L_0x0043
            int r7 = r0.zzk
            if (r7 >= r3) goto L_0x0043
            int r7 = r3 - r7
            long r7 = (long) r7
            long r7 = java.lang.Math.min(r7, r1)
            byte[] r9 = r0.zzg
            int r10 = r0.zzk
            int r7 = (int) r7
            r8 = r20
            int r7 = r8.zzg(r9, r10, r7)
            r9 = -1
            if (r7 != r9) goto L_0x003d
            goto L_0x001e
        L_0x003d:
            int r9 = r0.zzk
            int r9 = r9 + r7
            r0.zzk = r9
            goto L_0x0021
        L_0x0043:
            int r1 = r0.zzk
            com.google.android.gms.internal.ads.zzafm r2 = r0.zze
            int r2 = r2.zzd
            int r1 = r1 / r2
            if (r1 <= 0) goto L_0x0148
            byte[] r2 = r0.zzg
            com.google.android.gms.internal.ads.zzfd r3 = r0.zzh
            r7 = 0
        L_0x0051:
            if (r7 >= r1) goto L_0x0113
            r8 = 0
        L_0x0054:
            com.google.android.gms.internal.ads.zzafm r9 = r0.zze
            int r9 = r9.zzb
            if (r8 >= r9) goto L_0x010b
            byte[] r9 = r3.zzH()
            com.google.android.gms.internal.ads.zzafm r10 = r0.zze
            int r11 = r10.zzd
            int r10 = r10.zzb
            int r12 = r7 * r11
            int r13 = r8 * 4
            int r12 = r12 + r13
            int r13 = r10 * 4
            int r13 = r13 + r12
            int r11 = r11 / r10
            int r11 = r11 + -4
            int r14 = r12 + 1
            byte r14 = r2[r14]
            r14 = r14 & 255(0xff, float:3.57E-43)
            int r14 = r14 << 8
            byte r15 = r2[r12]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r14 = r14 | r15
            short r14 = (short) r14
            int r12 = r12 + 2
            byte r12 = r2[r12]
            r12 = r12 & 255(0xff, float:3.57E-43)
            r15 = 88
            int r12 = java.lang.Math.min(r12, r15)
            int[] r16 = zzb
            r16 = r16[r12]
            int r5 = r0.zzf
            int r5 = r5 * r7
            int r5 = r5 * r10
            int r5 = r5 + r8
            int r5 = r5 + r5
            r15 = r14 & 255(0xff, float:3.57E-43)
            byte r15 = (byte) r15
            r9[r5] = r15
            int r15 = r5 + 1
            int r6 = r14 >> 8
            byte r6 = (byte) r6
            r9[r15] = r6
            r6 = 0
        L_0x00a0:
            int r15 = r11 + r11
            if (r6 >= r15) goto L_0x0103
            int r15 = r6 / 8
            int r15 = r15 * r10
            int r15 = r15 * 4
            int r15 = r15 + r13
            int r18 = r6 / 2
            int r18 = r18 % 4
            int r15 = r15 + r18
            byte r15 = r2[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            int r18 = r6 % 2
            if (r18 != 0) goto L_0x00bb
            r15 = r15 & 15
            goto L_0x00bd
        L_0x00bb:
            int r15 = r15 >> 4
        L_0x00bd:
            r18 = r15 & 7
            int r18 = r18 + r18
            r17 = 1
            int r18 = r18 + 1
            int r18 = r18 * r16
            r16 = r2
            int r2 = r18 >> 3
            r18 = r15 & 8
            if (r18 == 0) goto L_0x00d0
            int r2 = -r2
        L_0x00d0:
            int r14 = r14 + r2
            r2 = -32768(0xffffffffffff8000, float:NaN)
            r21 = r11
            r11 = 32767(0x7fff, float:4.5916E-41)
            int r14 = com.google.android.gms.internal.ads.zzfn.zzf(r14, r2, r11)
            int r2 = r10 + r10
            int r5 = r5 + r2
            r2 = r14 & 255(0xff, float:3.57E-43)
            byte r2 = (byte) r2
            r9[r5] = r2
            int r2 = r5 + 1
            int r11 = r14 >> 8
            byte r11 = (byte) r11
            r9[r2] = r11
            int[] r2 = zza
            r2 = r2[r15]
            int r12 = r12 + r2
            r2 = 88
            r11 = 0
            int r12 = com.google.android.gms.internal.ads.zzfn.zzf(r12, r11, r2)
            int[] r11 = zzb
            r11 = r11[r12]
            int r6 = r6 + 1
            r2 = r16
            r16 = r11
            r11 = r21
            goto L_0x00a0
        L_0x0103:
            r16 = r2
            r17 = 1
            int r8 = r8 + 1
            goto L_0x0054
        L_0x010b:
            r16 = r2
            r17 = 1
            int r7 = r7 + 1
            goto L_0x0051
        L_0x0113:
            int r2 = r0.zzf
            int r2 = r2 * r1
            int r2 = r0.zze(r2)
            r5 = 0
            r3.zzF(r5)
            r3.zzE(r2)
            int r2 = r0.zzk
            com.google.android.gms.internal.ads.zzafm r3 = r0.zze
            int r3 = r3.zzd
            int r1 = r1 * r3
            int r2 = r2 - r1
            r0.zzk = r2
            com.google.android.gms.internal.ads.zzfd r1 = r0.zzh
            int r1 = r1.zzd()
            com.google.android.gms.internal.ads.zzxt r2 = r0.zzd
            com.google.android.gms.internal.ads.zzfd r3 = r0.zzh
            com.google.android.gms.internal.ads.zzxr.zzb(r2, r3, r1)
            int r2 = r0.zzm
            int r2 = r2 + r1
            r0.zzm = r2
            int r1 = r0.zzd(r2)
            int r2 = r0.zzi
            if (r1 < r2) goto L_0x0148
            r0.zzf(r2)
        L_0x0148:
            if (r4 == 0) goto L_0x0155
            int r1 = r0.zzm
            int r1 = r0.zzd(r1)
            if (r1 <= 0) goto L_0x0155
            r0.zzf(r1)
        L_0x0155:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafi.zzc(com.google.android.gms.internal.ads.zzwq, long):boolean");
    }
}
