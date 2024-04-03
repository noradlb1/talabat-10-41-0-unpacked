package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzeu {
    public static final byte[] zza = {0, 0, 0, 1};
    public static final float[] zzb = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object zzc = new Object();
    private static int[] zzd = new int[10];

    public static int zza(byte[] bArr, int i11, int i12, boolean[] zArr) {
        boolean z11;
        boolean z12;
        boolean z13;
        int i13 = i12 - i11;
        boolean z14 = false;
        if (i13 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdy.zzf(z11);
        if (i13 == 0) {
            return i12;
        }
        if (zArr[0]) {
            zze(zArr);
            return i11 - 3;
        } else if (i13 > 1 && zArr[1] && bArr[i11] == 1) {
            zze(zArr);
            return i11 - 2;
        } else if (i13 <= 2 || !zArr[2] || bArr[i11] != 0 || bArr[i11 + 1] != 1) {
            int i14 = i12 - 1;
            int i15 = i11 + 2;
            while (i15 < i14) {
                byte b11 = bArr[i15];
                if ((b11 & 254) == 0) {
                    int i16 = i15 - 2;
                    if (bArr[i16] == 0 && bArr[i15 - 1] == 0 && b11 == 1) {
                        zze(zArr);
                        return i16;
                    }
                    i15 = i16;
                }
                i15 += 3;
            }
            if (i13 <= 2 ? i13 != 2 ? !zArr[1] || bArr[i14] != 1 : !(zArr[2] && bArr[i12 - 2] == 0 && bArr[i14] == 1) : !(bArr[i12 - 3] == 0 && bArr[i12 - 2] == 0 && bArr[i14] == 1)) {
                z12 = false;
            } else {
                z12 = true;
            }
            zArr[0] = z12;
            if (i13 <= 1 ? !zArr[2] || bArr[i14] != 0 : !(bArr[i12 - 2] == 0 && bArr[i14] == 0)) {
                z13 = false;
            } else {
                z13 = true;
            }
            zArr[1] = z13;
            if (bArr[i14] == 0) {
                z14 = true;
            }
            zArr[2] = z14;
            return i12;
        } else {
            zze(zArr);
            return i11 - 1;
        }
    }

    public static int zzb(byte[] bArr, int i11) {
        int i12;
        synchronized (zzc) {
            int i13 = 0;
            int i14 = 0;
            while (i13 < i11) {
                while (true) {
                    if (i13 >= i11 - 2) {
                        i13 = i11;
                        break;
                    }
                    try {
                        if (bArr[i13] == 0 && bArr[i13 + 1] == 0 && bArr[i13 + 2] == 3) {
                            break;
                        }
                        i13++;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (i13 < i11) {
                    int[] iArr = zzd;
                    if (iArr.length <= i14) {
                        int length = iArr.length;
                        zzd = Arrays.copyOf(iArr, length + length);
                    }
                    zzd[i14] = i13;
                    i13 += 3;
                    i14++;
                }
            }
            i12 = i11 - i14;
            int i15 = 0;
            int i16 = 0;
            for (int i17 = 0; i17 < i14; i17++) {
                int i18 = zzd[i17] - i15;
                System.arraycopy(bArr, i15, bArr, i16, i18);
                int i19 = i16 + i18;
                int i21 = i19 + 1;
                bArr[i19] = 0;
                i16 = i21 + 1;
                bArr[i21] = 0;
                i15 += i18 + 3;
            }
            System.arraycopy(bArr, i15, bArr, i16, i12 - i16);
        }
        return i12;
    }

    public static zzes zzc(byte[] bArr, int i11, int i12) {
        zzfe zzfe = new zzfe(bArr, 4, i12);
        int zzc2 = zzfe.zzc();
        int zzc3 = zzfe.zzc();
        zzfe.zzd();
        return new zzes(zzc2, zzc3, zzfe.zzf());
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0160  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzet zzd(byte[] r22, int r23, int r24) {
        /*
            com.google.android.gms.internal.ads.zzfe r0 = new com.google.android.gms.internal.ads.zzfe
            r1 = r22
            r2 = r23
            r3 = r24
            r0.<init>(r1, r2, r3)
            r1 = 8
            int r2 = r0.zza(r1)
            int r5 = r0.zza(r1)
            int r6 = r0.zza(r1)
            int r7 = r0.zzc()
            r3 = 100
            r4 = 3
            r8 = 16
            r10 = 1
            if (r2 == r3) goto L_0x004e
            r3 = 110(0x6e, float:1.54E-43)
            if (r2 == r3) goto L_0x004e
            r3 = 122(0x7a, float:1.71E-43)
            if (r2 == r3) goto L_0x004e
            r3 = 244(0xf4, float:3.42E-43)
            if (r2 == r3) goto L_0x004e
            r3 = 44
            if (r2 == r3) goto L_0x004e
            r3 = 83
            if (r2 == r3) goto L_0x004e
            r3 = 86
            if (r2 == r3) goto L_0x004e
            r3 = 118(0x76, float:1.65E-43)
            if (r2 == r3) goto L_0x004e
            r3 = 128(0x80, float:1.794E-43)
            if (r2 == r3) goto L_0x004e
            r3 = 138(0x8a, float:1.93E-43)
            if (r2 != r3) goto L_0x004b
            r2 = r3
            goto L_0x004e
        L_0x004b:
            r3 = r10
            r11 = 0
            goto L_0x00a0
        L_0x004e:
            int r3 = r0.zzc()
            if (r3 != r4) goto L_0x005a
            boolean r11 = r0.zzf()
            r12 = r4
            goto L_0x005c
        L_0x005a:
            r12 = r3
            r11 = 0
        L_0x005c:
            r0.zzc()
            r0.zzc()
            r0.zzd()
            boolean r13 = r0.zzf()
            if (r13 == 0) goto L_0x00a0
            if (r12 == r4) goto L_0x006f
            r12 = r1
            goto L_0x0071
        L_0x006f:
            r12 = 12
        L_0x0071:
            r13 = 0
        L_0x0072:
            if (r13 >= r12) goto L_0x00a0
            boolean r14 = r0.zzf()
            if (r14 == 0) goto L_0x009d
            r14 = 6
            if (r13 >= r14) goto L_0x007f
            r14 = r8
            goto L_0x0081
        L_0x007f:
            r14 = 64
        L_0x0081:
            r16 = r1
            r17 = r16
            r15 = 0
        L_0x0086:
            if (r15 >= r14) goto L_0x009d
            if (r16 == 0) goto L_0x0096
            int r16 = r0.zzb()
            int r9 = r17 + r16
            int r9 = r9 + 256
            int r9 = r9 % 256
            r16 = r9
        L_0x0096:
            if (r16 == 0) goto L_0x009a
            r17 = r16
        L_0x009a:
            int r15 = r15 + 1
            goto L_0x0086
        L_0x009d:
            int r13 = r13 + 1
            goto L_0x0072
        L_0x00a0:
            int r9 = r0.zzc()
            int r13 = r9 + 4
            int r9 = r0.zzc()
            if (r9 != 0) goto L_0x00b9
            int r12 = r0.zzc()
            int r12 = r12 + 4
            r24 = r2
            r14 = r9
            r15 = r12
        L_0x00b6:
            r16 = 0
            goto L_0x00e2
        L_0x00b9:
            if (r9 != r10) goto L_0x00dd
            boolean r9 = r0.zzf()
            r0.zzb()
            r0.zzb()
            int r12 = r0.zzc()
            long r14 = (long) r12
            r24 = r2
            r12 = 0
        L_0x00cd:
            long r1 = (long) r12
            int r1 = (r1 > r14 ? 1 : (r1 == r14 ? 0 : -1))
            if (r1 >= 0) goto L_0x00d8
            r0.zzc()
            int r12 = r12 + 1
            goto L_0x00cd
        L_0x00d8:
            r16 = r9
            r14 = r10
            r15 = 0
            goto L_0x00e2
        L_0x00dd:
            r24 = r2
            r14 = r9
            r15 = 0
            goto L_0x00b6
        L_0x00e2:
            r0.zzc()
            r0.zzd()
            int r1 = r0.zzc()
            int r1 = r1 + r10
            int r2 = r0.zzc()
            boolean r12 = r0.zzf()
            int r9 = 2 - r12
            int r2 = r2 + r10
            int r2 = r2 * r9
            if (r12 != 0) goto L_0x00fe
            r0.zzd()
        L_0x00fe:
            r0.zzd()
            int r1 = r1 * r8
            int r2 = r2 * r8
            boolean r17 = r0.zzf()
            if (r17 == 0) goto L_0x0136
            int r17 = r0.zzc()
            int r18 = r0.zzc()
            int r19 = r0.zzc()
            int r20 = r0.zzc()
            if (r3 != 0) goto L_0x011c
            goto L_0x012a
        L_0x011c:
            r21 = 2
            if (r3 != r4) goto L_0x0122
            r4 = r10
            goto L_0x0124
        L_0x0122:
            r4 = r21
        L_0x0124:
            if (r3 != r10) goto L_0x0128
            r10 = r21
        L_0x0128:
            int r9 = r9 * r10
            r10 = r4
        L_0x012a:
            int r17 = r17 + r18
            int r17 = r17 * r10
            int r1 = r1 - r17
            int r19 = r19 + r20
            int r19 = r19 * r9
            int r2 = r2 - r19
        L_0x0136:
            r9 = r2
            boolean r2 = r0.zzf()
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r2 == 0) goto L_0x0182
            boolean r2 = r0.zzf()
            if (r2 == 0) goto L_0x0182
            r2 = 8
            int r2 = r0.zza(r2)
            r4 = 255(0xff, float:3.57E-43)
            if (r2 != r4) goto L_0x0160
            int r2 = r0.zza(r8)
            int r0 = r0.zza(r8)
            if (r2 == 0) goto L_0x0182
            if (r0 == 0) goto L_0x0182
            float r2 = (float) r2
            float r0 = (float) r0
            float r2 = r2 / r0
            r10 = r2
            goto L_0x0183
        L_0x0160:
            r0 = 17
            if (r2 >= r0) goto L_0x016a
            float[] r0 = zzb
            r0 = r0[r2]
            r10 = r0
            goto L_0x0183
        L_0x016a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r4 = 46
            r0.<init>(r4)
            java.lang.String r4 = "Unexpected aspect_ratio_idc value: "
            r0.append(r4)
            r0.append(r2)
            java.lang.String r2 = "NalUnitUtil"
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r2, r0)
        L_0x0182:
            r10 = r3
        L_0x0183:
            com.google.android.gms.internal.ads.zzet r0 = new com.google.android.gms.internal.ads.zzet
            r3 = r0
            r4 = r24
            r8 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeu.zzd(byte[], int, int):com.google.android.gms.internal.ads.zzet");
    }

    public static void zze(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }
}
