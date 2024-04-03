package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

final class zzade extends zzadc {
    @Nullable
    private zzadd zza;
    private int zzb;
    private boolean zzc;
    @Nullable
    private zzxx zzd;
    @Nullable
    private zzxv zze;

    public final long zza(zzfd zzfd) {
        int i11;
        int i12 = 0;
        if ((zzfd.zzH()[0] & 1) == 1) {
            return -1;
        }
        byte b11 = zzfd.zzH()[0];
        zzadd zzadd = this.zza;
        zzdy.zzb(zzadd);
        if (!zzadd.zzd[(b11 >> 1) & (255 >>> (8 - zzadd.zze))].zza) {
            i11 = zzadd.zza.zze;
        } else {
            i11 = zzadd.zza.zzf;
        }
        if (this.zzc) {
            i12 = (this.zzb + i11) / 4;
        }
        long j11 = (long) i12;
        if (zzfd.zzb() < zzfd.zzd() + 4) {
            byte[] copyOf = Arrays.copyOf(zzfd.zzH(), zzfd.zzd() + 4);
            zzfd.zzD(copyOf, copyOf.length);
        } else {
            zzfd.zzE(zzfd.zzd() + 4);
        }
        byte[] zzH = zzfd.zzH();
        zzH[zzfd.zzd() - 4] = (byte) ((int) (j11 & 255));
        zzH[zzfd.zzd() - 3] = (byte) ((int) ((j11 >>> 8) & 255));
        zzH[zzfd.zzd() - 2] = (byte) ((int) ((j11 >>> 16) & 255));
        zzH[zzfd.zzd() - 1] = (byte) ((int) ((j11 >>> 24) & 255));
        this.zzc = true;
        this.zzb = i11;
        return j11;
    }

    public final void zzb(boolean z11) {
        super.zzb(z11);
        if (z11) {
            this.zza = null;
            this.zzd = null;
            this.zze = null;
        }
        this.zzb = 0;
        this.zzc = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:169:0x0408 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x040a  */
    @org.checkerframework.checker.nullness.qual.EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzc(com.google.android.gms.internal.ads.zzfd r26, long r27, com.google.android.gms.internal.ads.zzacz r29) throws java.io.IOException {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            r2 = r29
            com.google.android.gms.internal.ads.zzadd r3 = r0.zza
            r4 = 0
            if (r3 == 0) goto L_0x0011
            com.google.android.gms.internal.ads.zzab r1 = r2.zza
            r1.getClass()
            return r4
        L_0x0011:
            com.google.android.gms.internal.ads.zzxx r6 = r0.zzd
            r5 = 4
            r11 = 1
            if (r6 != 0) goto L_0x0084
            com.google.android.gms.internal.ads.zzxy.zzc(r11, r1, r4)
            int r13 = r26.zzh()
            int r14 = r26.zzk()
            int r15 = r26.zzh()
            int r6 = r26.zzg()
            if (r6 > 0) goto L_0x002f
            r16 = -1
            goto L_0x0031
        L_0x002f:
            r16 = r6
        L_0x0031:
            int r6 = r26.zzg()
            if (r6 > 0) goto L_0x003a
            r17 = -1
            goto L_0x003c
        L_0x003a:
            r17 = r6
        L_0x003c:
            int r6 = r26.zzg()
            if (r6 > 0) goto L_0x0045
            r18 = -1
            goto L_0x0047
        L_0x0045:
            r18 = r6
        L_0x0047:
            int r3 = r26.zzk()
            r6 = r3 & 15
            double r8 = (double) r6
            r11 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r8 = java.lang.Math.pow(r11, r8)
            int r6 = (int) r8
            r3 = r3 & 240(0xf0, float:3.36E-43)
            int r3 = r3 >> r5
            double r8 = (double) r3
            double r8 = java.lang.Math.pow(r11, r8)
            int r3 = (int) r8
            int r5 = r26.zzk()
            byte[] r8 = r26.zzH()
            int r1 = r26.zzd()
            byte[] r22 = java.util.Arrays.copyOf(r8, r1)
            com.google.android.gms.internal.ads.zzxx r1 = new com.google.android.gms.internal.ads.zzxx
            r8 = 1
            r5 = r5 & r8
            if (r8 == r5) goto L_0x0077
            r21 = r4
            goto L_0x0079
        L_0x0077:
            r21 = 1
        L_0x0079:
            r12 = r1
            r19 = r6
            r20 = r3
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            r0.zzd = r1
            goto L_0x008f
        L_0x0084:
            com.google.android.gms.internal.ads.zzxv r8 = r0.zze
            if (r8 != 0) goto L_0x0092
            r9 = 1
            com.google.android.gms.internal.ads.zzxv r1 = com.google.android.gms.internal.ads.zzxy.zzb(r1, r9, r9)
            r0.zze = r1
        L_0x008f:
            r7 = 0
            goto L_0x0404
        L_0x0092:
            int r9 = r26.zzd()
            byte[] r9 = new byte[r9]
            byte[] r10 = r26.zzH()
            int r11 = r26.zzd()
            java.lang.System.arraycopy(r10, r4, r9, r4, r11)
            int r10 = r6.zza
            r11 = 5
            com.google.android.gms.internal.ads.zzxy.zzc(r11, r1, r4)
            int r12 = r26.zzk()
            r13 = 1
            int r12 = r12 + r13
            com.google.android.gms.internal.ads.zzxu r13 = new com.google.android.gms.internal.ads.zzxu
            byte[] r14 = r26.zzH()
            r13.<init>(r14)
            int r1 = r26.zzc()
            r14 = 8
            int r1 = r1 * r14
            r13.zzc(r1)
            r1 = r4
        L_0x00c3:
            r15 = 24
            r3 = 16
            if (r1 >= r12) goto L_0x01e2
            int r14 = r13.zzb(r15)
            r7 = 5653314(0x564342, float:7.92198E-39)
            if (r14 != r7) goto L_0x01c5
            int r3 = r13.zzb(r3)
            int r7 = r13.zzb(r15)
            long[] r14 = new long[r7]
            boolean r15 = r13.zzd()
            r18 = 0
            if (r15 != 0) goto L_0x0121
            boolean r15 = r13.zzd()
            r4 = 0
        L_0x00e9:
            if (r4 >= r7) goto L_0x011e
            if (r15 == 0) goto L_0x0109
            boolean r21 = r13.zzd()
            if (r21 == 0) goto L_0x0101
            int r21 = r13.zzb(r11)
            r22 = 1
            int r5 = r21 + 1
            r23 = r12
            long r11 = (long) r5
            r14[r4] = r11
            goto L_0x0107
        L_0x0101:
            r23 = r12
            r22 = 1
            r14[r4] = r18
        L_0x0107:
            r5 = 5
            goto L_0x0117
        L_0x0109:
            r5 = r11
            r23 = r12
            r22 = 1
            int r11 = r13.zzb(r5)
            int r11 = r11 + 1
            long r11 = (long) r11
            r14[r4] = r11
        L_0x0117:
            int r4 = r4 + 1
            r11 = r5
            r12 = r23
            r5 = 4
            goto L_0x00e9
        L_0x011e:
            r23 = r12
            goto L_0x0159
        L_0x0121:
            r5 = r11
            r23 = r12
            r22 = 1
            int r4 = r13.zzb(r5)
            int r4 = r4 + 1
            r5 = 0
        L_0x012d:
            if (r5 >= r7) goto L_0x0159
            int r11 = r7 - r5
            int r11 = com.google.android.gms.internal.ads.zzxy.zza(r11)
            int r11 = r13.zzb(r11)
            r12 = 0
        L_0x013a:
            if (r12 >= r11) goto L_0x014e
            if (r5 >= r7) goto L_0x014e
            r22 = r8
            r24 = r9
            long r8 = (long) r4
            r14[r5] = r8
            int r5 = r5 + 1
            int r12 = r12 + 1
            r8 = r22
            r9 = r24
            goto L_0x013a
        L_0x014e:
            r22 = r8
            r24 = r9
            int r4 = r4 + 1
            r8 = r22
            r9 = r24
            goto L_0x012d
        L_0x0159:
            r22 = r8
            r24 = r9
            r4 = 4
            int r5 = r13.zzb(r4)
            r8 = 2
            if (r5 > r8) goto L_0x01ac
            r9 = 1
            if (r5 == r9) goto L_0x016b
            if (r5 != r8) goto L_0x019d
            r5 = 2
        L_0x016b:
            r8 = 32
            r13.zzc(r8)
            r13.zzc(r8)
            int r8 = r13.zzb(r4)
            int r8 = r8 + r9
            r13.zzc(r9)
            if (r5 != r9) goto L_0x0192
            if (r3 == 0) goto L_0x0196
            long r4 = (long) r7
            double r4 = (double) r4
            long r11 = (long) r3
            double r11 = (double) r11
            r14 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r14 = r14 / r11
            double r3 = java.lang.Math.pow(r4, r14)
            double r3 = java.lang.Math.floor(r3)
            long r3 = (long) r3
            r18 = r3
            goto L_0x0196
        L_0x0192:
            long r4 = (long) r7
            long r11 = (long) r3
            long r18 = r4 * r11
        L_0x0196:
            long r3 = (long) r8
            long r3 = r3 * r18
            int r3 = (int) r3
            r13.zzc(r3)
        L_0x019d:
            int r1 = r1 + 1
            r8 = r22
            r12 = r23
            r9 = r24
            r4 = 0
            r5 = 4
            r11 = 5
            r14 = 8
            goto L_0x00c3
        L_0x01ac:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = 53
            r1.<init>(r2)
            java.lang.String r2 = "lookup type greater than 2 not decodable: "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r2 = 0
            com.google.android.gms.internal.ads.zzbj r1 = com.google.android.gms.internal.ads.zzbj.zza(r1, r2)
            throw r1
        L_0x01c5:
            r2 = 0
            int r1 = r13.zza()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r4 = 66
            r3.<init>(r4)
            java.lang.String r4 = "expected code book to start with [0x56, 0x43, 0x42] at "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.google.android.gms.internal.ads.zzbj r1 = com.google.android.gms.internal.ads.zzbj.zza(r1, r2)
            throw r1
        L_0x01e2:
            r22 = r8
            r24 = r9
            r1 = 6
            int r4 = r13.zzb(r1)
            r5 = 1
            int r4 = r4 + r5
            r5 = 0
        L_0x01ee:
            if (r5 >= r4) goto L_0x0201
            int r7 = r13.zzb(r3)
            if (r7 != 0) goto L_0x01f9
            int r5 = r5 + 1
            goto L_0x01ee
        L_0x01f9:
            java.lang.String r1 = "placeholder of time domain transforms not zeroed out"
            r2 = 0
            com.google.android.gms.internal.ads.zzbj r1 = com.google.android.gms.internal.ads.zzbj.zza(r1, r2)
            throw r1
        L_0x0201:
            int r4 = r13.zzb(r1)
            r5 = 1
            int r4 = r4 + r5
            r7 = 0
        L_0x0208:
            r8 = 3
            r9 = 52
            if (r7 >= r4) goto L_0x02c4
            int r11 = r13.zzb(r3)
            if (r11 == 0) goto L_0x0298
            if (r11 != r5) goto L_0x0281
            r5 = 5
            int r9 = r13.zzb(r5)
            int[] r5 = new int[r9]
            r11 = 0
            r12 = -1
        L_0x021e:
            if (r11 >= r9) goto L_0x022f
            r14 = 4
            int r15 = r13.zzb(r14)
            r5[r11] = r15
            if (r15 <= r12) goto L_0x022a
            r12 = r15
        L_0x022a:
            int r11 = r11 + 1
            r15 = 24
            goto L_0x021e
        L_0x022f:
            int r12 = r12 + 1
            int[] r11 = new int[r12]
            r14 = 0
        L_0x0234:
            if (r14 >= r12) goto L_0x0263
            int r15 = r13.zzb(r8)
            r19 = 1
            int r15 = r15 + 1
            r11[r14] = r15
            r15 = 2
            int r23 = r13.zzb(r15)
            if (r23 <= 0) goto L_0x024d
            r15 = 8
            r13.zzc(r15)
            goto L_0x024f
        L_0x024d:
            r15 = 8
        L_0x024f:
            r8 = 0
        L_0x0250:
            int r1 = r19 << r23
            if (r8 >= r1) goto L_0x025e
            r13.zzc(r15)
            int r8 = r8 + 1
            r15 = 8
            r19 = 1
            goto L_0x0250
        L_0x025e:
            int r14 = r14 + 1
            r1 = 6
            r8 = 3
            goto L_0x0234
        L_0x0263:
            r1 = 2
            r13.zzc(r1)
            r1 = 4
            int r8 = r13.zzb(r1)
            r1 = 0
            r12 = 0
            r14 = 0
        L_0x026f:
            if (r1 >= r9) goto L_0x02bc
            r15 = r5[r1]
            r15 = r11[r15]
            int r12 = r12 + r15
        L_0x0276:
            if (r14 >= r12) goto L_0x027e
            r13.zzc(r8)
            int r14 = r14 + 1
            goto L_0x0276
        L_0x027e:
            int r1 = r1 + 1
            goto L_0x026f
        L_0x0281:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r9)
            java.lang.String r2 = "floor type greater than 1 not decodable: "
            r1.append(r2)
            r1.append(r11)
            java.lang.String r1 = r1.toString()
            r2 = 0
            com.google.android.gms.internal.ads.zzbj r1 = com.google.android.gms.internal.ads.zzbj.zza(r1, r2)
            throw r1
        L_0x0298:
            r1 = 8
            r13.zzc(r1)
            r13.zzc(r3)
            r13.zzc(r3)
            r5 = 6
            r13.zzc(r5)
            r13.zzc(r1)
            r5 = 4
            int r8 = r13.zzb(r5)
            r5 = 1
            int r8 = r8 + r5
            r5 = 0
        L_0x02b2:
            if (r5 >= r8) goto L_0x02bc
            r13.zzc(r1)
            int r5 = r5 + 1
            r1 = 8
            goto L_0x02b2
        L_0x02bc:
            int r7 = r7 + 1
            r1 = 6
            r5 = 1
            r15 = 24
            goto L_0x0208
        L_0x02c4:
            int r4 = r13.zzb(r1)
            r5 = 1
            int r4 = r4 + r5
            r7 = 0
        L_0x02cb:
            if (r7 >= r4) goto L_0x0339
            int r8 = r13.zzb(r3)
            r11 = 2
            if (r8 > r11) goto L_0x0331
            r8 = 24
            r13.zzc(r8)
            r13.zzc(r8)
            r13.zzc(r8)
            int r11 = r13.zzb(r1)
            int r11 = r11 + r5
            r1 = 8
            r13.zzc(r1)
            int[] r5 = new int[r11]
            r12 = 0
        L_0x02ec:
            if (r12 >= r11) goto L_0x030d
            r14 = 3
            int r15 = r13.zzb(r14)
            boolean r18 = r13.zzd()
            if (r18 == 0) goto L_0x02ff
            r8 = 5
            int r19 = r13.zzb(r8)
            goto L_0x0302
        L_0x02ff:
            r8 = 5
            r19 = 0
        L_0x0302:
            int r19 = r19 * 8
            int r19 = r19 + r15
            r5[r12] = r19
            int r12 = r12 + 1
            r8 = 24
            goto L_0x02ec
        L_0x030d:
            r8 = 5
            r14 = 3
            r12 = 0
        L_0x0310:
            if (r12 >= r11) goto L_0x032c
            r15 = 0
        L_0x0313:
            if (r15 >= r1) goto L_0x0327
            r19 = r5[r12]
            r21 = 1
            int r23 = r21 << r15
            r19 = r19 & r23
            if (r19 == 0) goto L_0x0322
            r13.zzc(r1)
        L_0x0322:
            int r15 = r15 + 1
            r1 = 8
            goto L_0x0313
        L_0x0327:
            int r12 = r12 + 1
            r1 = 8
            goto L_0x0310
        L_0x032c:
            int r7 = r7 + 1
            r1 = 6
            r5 = 1
            goto L_0x02cb
        L_0x0331:
            java.lang.String r1 = "residueType greater than 2 is not decodable"
            r2 = 0
            com.google.android.gms.internal.ads.zzbj r1 = com.google.android.gms.internal.ads.zzbj.zza(r1, r2)
            throw r1
        L_0x0339:
            int r4 = r13.zzb(r1)
            r1 = 1
            int r4 = r4 + r1
            r1 = 0
        L_0x0340:
            if (r1 >= r4) goto L_0x03c5
            int r5 = r13.zzb(r3)
            if (r5 == 0) goto L_0x0361
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r9)
            java.lang.String r8 = "mapping type other than 0 not supported: "
            r7.append(r8)
            r7.append(r5)
            java.lang.String r5 = "VorbisUtil"
            java.lang.String r7 = r7.toString()
            android.util.Log.e(r5, r7)
            r5 = 2
            r11 = 4
            goto L_0x03ba
        L_0x0361:
            boolean r5 = r13.zzd()
            if (r5 == 0) goto L_0x036f
            r5 = 4
            int r7 = r13.zzb(r5)
            r5 = 1
            int r7 = r7 + r5
            goto L_0x0371
        L_0x036f:
            r5 = 1
            r7 = r5
        L_0x0371:
            boolean r8 = r13.zzd()
            if (r8 == 0) goto L_0x0394
            r8 = 8
            int r11 = r13.zzb(r8)
            int r11 = r11 + r5
            r5 = 0
        L_0x037f:
            if (r5 >= r11) goto L_0x0394
            int r8 = r10 + -1
            int r12 = com.google.android.gms.internal.ads.zzxy.zza(r8)
            r13.zzc(r12)
            int r8 = com.google.android.gms.internal.ads.zzxy.zza(r8)
            r13.zzc(r8)
            int r5 = r5 + 1
            goto L_0x037f
        L_0x0394:
            r5 = 2
            int r8 = r13.zzb(r5)
            if (r8 != 0) goto L_0x03bd
            r8 = 1
            if (r7 <= r8) goto L_0x03a8
            r8 = 0
        L_0x039f:
            if (r8 >= r10) goto L_0x03a8
            r11 = 4
            r13.zzc(r11)
            int r8 = r8 + 1
            goto L_0x039f
        L_0x03a8:
            r11 = 4
            r8 = 0
        L_0x03aa:
            if (r8 >= r7) goto L_0x03ba
            r12 = 8
            r13.zzc(r12)
            r13.zzc(r12)
            r13.zzc(r12)
            int r8 = r8 + 1
            goto L_0x03aa
        L_0x03ba:
            int r1 = r1 + 1
            goto L_0x0340
        L_0x03bd:
            java.lang.String r1 = "to reserved bits must be zero after mapping coupling steps"
            r2 = 0
            com.google.android.gms.internal.ads.zzbj r1 = com.google.android.gms.internal.ads.zzbj.zza(r1, r2)
            throw r1
        L_0x03c5:
            r1 = 6
            int r1 = r13.zzb(r1)
            r4 = 1
            int r1 = r1 + r4
            com.google.android.gms.internal.ads.zzxw[] r9 = new com.google.android.gms.internal.ads.zzxw[r1]
            r4 = 0
        L_0x03cf:
            if (r4 >= r1) goto L_0x03ed
            boolean r5 = r13.zzd()
            int r7 = r13.zzb(r3)
            int r8 = r13.zzb(r3)
            r10 = 8
            int r11 = r13.zzb(r10)
            com.google.android.gms.internal.ads.zzxw r12 = new com.google.android.gms.internal.ads.zzxw
            r12.<init>(r5, r7, r8, r11)
            r9[r4] = r12
            int r4 = r4 + 1
            goto L_0x03cf
        L_0x03ed:
            boolean r3 = r13.zzd()
            if (r3 == 0) goto L_0x0444
            com.google.android.gms.internal.ads.zzadd r3 = new com.google.android.gms.internal.ads.zzadd
            r4 = -1
            int r1 = r1 + r4
            int r10 = com.google.android.gms.internal.ads.zzxy.zza(r1)
            r5 = r3
            r7 = r22
            r8 = r24
            r5.<init>(r6, r7, r8, r9, r10)
            r7 = r3
        L_0x0404:
            r0.zza = r7
            if (r7 != 0) goto L_0x040a
            r1 = 1
            return r1
        L_0x040a:
            com.google.android.gms.internal.ads.zzxx r1 = r7.zza
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            byte[] r4 = r1.zzg
            r3.add(r4)
            byte[] r4 = r7.zzc
            r3.add(r4)
            com.google.android.gms.internal.ads.zzz r4 = new com.google.android.gms.internal.ads.zzz
            r4.<init>()
            java.lang.String r5 = "audio/vorbis"
            r4.zzS(r5)
            int r5 = r1.zzd
            r4.zzv(r5)
            int r5 = r1.zzc
            r4.zzO(r5)
            int r5 = r1.zza
            r4.zzw(r5)
            int r1 = r1.zzb
            r4.zzT(r1)
            r4.zzI(r3)
            com.google.android.gms.internal.ads.zzab r1 = r4.zzY()
            r2.zza = r1
            r1 = 1
            return r1
        L_0x0444:
            java.lang.String r1 = "framing bit after modes not set as expected"
            r2 = 0
            com.google.android.gms.internal.ads.zzbj r1 = com.google.android.gms.internal.ads.zzbj.zza(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzade.zzc(com.google.android.gms.internal.ads.zzfd, long, com.google.android.gms.internal.ads.zzacz):boolean");
    }

    public final void zzi(long j11) {
        super.zzi(j11);
        int i11 = 0;
        this.zzc = j11 != 0;
        zzxx zzxx = this.zzd;
        if (zzxx != null) {
            i11 = zzxx.zze;
        }
        this.zzb = i11;
    }
}
