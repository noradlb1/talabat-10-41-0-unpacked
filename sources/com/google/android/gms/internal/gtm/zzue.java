package com.google.android.gms.internal.gtm;

final class zzue extends zzub {
    private static int zza(byte[] bArr, int i11, long j11, int i12) {
        if (i12 == 0) {
            return zztz.zzbx(i11);
        }
        if (i12 == 1) {
            return zztz.zzr(i11, zztx.zza(bArr, j11));
        }
        if (i12 == 2) {
            return zztz.zzc(i11, zztx.zza(bArr, j11), zztx.zza(bArr, j11 + 1));
        }
        throw new AssertionError();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0065, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ba, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(int r18, byte[] r19, int r20, int r21) {
        /*
            r17 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r1 | r2
            int r4 = r0.length
            int r4 = r4 - r2
            r3 = r3 | r4
            r4 = 2
            r5 = 3
            r6 = 0
            if (r3 < 0) goto L_0x00bb
            long r7 = (long) r1
            long r1 = (long) r2
            long r1 = r1 - r7
            int r1 = (int) r1
            r2 = 16
            r9 = 1
            if (r1 >= r2) goto L_0x001c
            r2 = r6
            goto L_0x002e
        L_0x001c:
            r2 = r6
            r11 = r7
        L_0x001e:
            if (r2 >= r1) goto L_0x002d
            long r13 = r11 + r9
            byte r3 = com.google.android.gms.internal.gtm.zztx.zza((byte[]) r0, (long) r11)
            if (r3 >= 0) goto L_0x0029
            goto L_0x002e
        L_0x0029:
            int r2 = r2 + 1
            r11 = r13
            goto L_0x001e
        L_0x002d:
            r2 = r1
        L_0x002e:
            int r1 = r1 - r2
            long r2 = (long) r2
            long r7 = r7 + r2
        L_0x0031:
            r2 = r6
        L_0x0032:
            if (r1 <= 0) goto L_0x0045
            long r2 = r7 + r9
            byte r7 = com.google.android.gms.internal.gtm.zztx.zza((byte[]) r0, (long) r7)
            if (r7 < 0) goto L_0x0042
            int r1 = r1 + -1
            r15 = r2
            r2 = r7
            r7 = r15
            goto L_0x0032
        L_0x0042:
            r15 = r2
            r2 = r7
            r7 = r15
        L_0x0045:
            if (r1 != 0) goto L_0x0048
            return r6
        L_0x0048:
            int r1 = r1 + -1
            r3 = -32
            r11 = -65
            r12 = -1
            if (r2 >= r3) goto L_0x0066
            if (r1 != 0) goto L_0x0054
            return r2
        L_0x0054:
            int r1 = r1 + -1
            r3 = -62
            if (r2 < r3) goto L_0x0065
            long r2 = r7 + r9
            byte r7 = com.google.android.gms.internal.gtm.zztx.zza((byte[]) r0, (long) r7)
            if (r7 <= r11) goto L_0x0063
            goto L_0x0065
        L_0x0063:
            r7 = r2
            goto L_0x0031
        L_0x0065:
            return r12
        L_0x0066:
            r13 = -16
            if (r2 >= r13) goto L_0x0090
            if (r1 >= r4) goto L_0x0071
            int r0 = zza(r0, r2, r7, r1)
            return r0
        L_0x0071:
            int r1 = r1 + -2
            long r13 = r7 + r9
            byte r7 = com.google.android.gms.internal.gtm.zztx.zza((byte[]) r0, (long) r7)
            if (r7 > r11) goto L_0x008f
            r8 = -96
            if (r2 != r3) goto L_0x0081
            if (r7 < r8) goto L_0x008f
        L_0x0081:
            r3 = -19
            if (r2 != r3) goto L_0x0087
            if (r7 >= r8) goto L_0x008f
        L_0x0087:
            long r7 = r13 + r9
            byte r2 = com.google.android.gms.internal.gtm.zztx.zza((byte[]) r0, (long) r13)
            if (r2 <= r11) goto L_0x0031
        L_0x008f:
            return r12
        L_0x0090:
            if (r1 >= r5) goto L_0x0097
            int r0 = zza(r0, r2, r7, r1)
            return r0
        L_0x0097:
            int r1 = r1 + -3
            long r13 = r7 + r9
            byte r3 = com.google.android.gms.internal.gtm.zztx.zza((byte[]) r0, (long) r7)
            if (r3 > r11) goto L_0x00ba
            int r2 = r2 << 28
            int r3 = r3 + 112
            int r2 = r2 + r3
            int r2 = r2 >> 30
            if (r2 != 0) goto L_0x00ba
            long r2 = r13 + r9
            byte r7 = com.google.android.gms.internal.gtm.zztx.zza((byte[]) r0, (long) r13)
            if (r7 > r11) goto L_0x00ba
            long r7 = r2 + r9
            byte r2 = com.google.android.gms.internal.gtm.zztx.zza((byte[]) r0, (long) r2)
            if (r2 <= r11) goto L_0x0031
        L_0x00ba:
            return r12
        L_0x00bb:
            java.lang.ArrayIndexOutOfBoundsException r3 = new java.lang.ArrayIndexOutOfBoundsException
            java.lang.Object[] r5 = new java.lang.Object[r5]
            int r0 = r0.length
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r5[r6] = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r20)
            r1 = 1
            r5[r1] = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r21)
            r5[r4] = r0
            java.lang.String r0 = "Array length=%d, index=%d, limit=%d"
            java.lang.String r0 = java.lang.String.format(r0, r5)
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzue.zzb(int, byte[], int, int):int");
    }

    public final String zzh(byte[] bArr, int i11, int i12) throws zzrk {
        if ((i11 | i12 | ((bArr.length - i11) - i12)) >= 0) {
            int i13 = i11 + i12;
            char[] cArr = new char[i12];
            int i14 = 0;
            while (r13 < i13) {
                byte zza = zztx.zza(bArr, (long) r13);
                if (!zzua.zzd(zza)) {
                    break;
                }
                i11 = r13 + 1;
                zzua.zza(zza, cArr, i14);
                i14++;
            }
            int i15 = i14;
            while (r13 < i13) {
                int i16 = r13 + 1;
                byte zza2 = zztx.zza(bArr, (long) r13);
                if (zzua.zzd(zza2)) {
                    int i17 = i15 + 1;
                    zzua.zza(zza2, cArr, i15);
                    while (i16 < i13) {
                        byte zza3 = zztx.zza(bArr, (long) i16);
                        if (!zzua.zzd(zza3)) {
                            break;
                        }
                        i16++;
                        zzua.zza(zza3, cArr, i17);
                        i17++;
                    }
                    r13 = i16;
                    i15 = i17;
                } else if (zzua.zze(zza2)) {
                    if (i16 < i13) {
                        zzua.zza(zza2, zztx.zza(bArr, (long) i16), cArr, i15);
                        r13 = i16 + 1;
                        i15++;
                    } else {
                        throw zzrk.zzpw();
                    }
                } else if (zzua.zzf(zza2)) {
                    if (i16 < i13 - 1) {
                        int i18 = i16 + 1;
                        zzua.zza(zza2, zztx.zza(bArr, (long) i16), zztx.zza(bArr, (long) i18), cArr, i15);
                        r13 = i18 + 1;
                        i15++;
                    } else {
                        throw zzrk.zzpw();
                    }
                } else if (i16 < i13 - 2) {
                    int i19 = i16 + 1;
                    byte zza4 = zztx.zza(bArr, (long) i16);
                    int i21 = i19 + 1;
                    zzua.zza(zza2, zza4, zztx.zza(bArr, (long) i19), zztx.zza(bArr, (long) i21), cArr, i15);
                    r13 = i21 + 1;
                    i15 = i15 + 1 + 1;
                } else {
                    throw zzrk.zzpw();
                }
            }
            return new String(cArr, 0, i15);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i11), Integer.valueOf(i12)}));
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A[LOOP:1: B:13:0x0033->B:37:0x00fc, LOOP_START, PHI: r2 r3 r4 r11 
      PHI: (r2v4 int) = (r2v3 int), (r2v6 int) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r3v3 char) = (r3v2 char), (r3v4 char) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r4v3 long) = (r4v2 long), (r4v5 long) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r11v3 long) = (r11v2 long), (r11v5 long) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(java.lang.CharSequence r22, byte[] r23, int r24, int r25) {
        /*
            r21 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r25
            long r4 = (long) r2
            long r6 = (long) r3
            long r6 = r6 + r4
            int r8 = r22.length()
            java.lang.String r9 = " at index "
            java.lang.String r10 = "Failed writing "
            if (r8 > r3) goto L_0x0146
            int r11 = r1.length
            int r11 = r11 - r3
            if (r11 < r2) goto L_0x0146
            r2 = 0
        L_0x001a:
            r3 = 128(0x80, float:1.794E-43)
            r11 = 1
            if (r2 >= r8) goto L_0x002f
            char r13 = r0.charAt(r2)
            if (r13 >= r3) goto L_0x002f
            long r11 = r11 + r4
            byte r3 = (byte) r13
            com.google.android.gms.internal.gtm.zztx.zza((byte[]) r1, (long) r4, (byte) r3)
            int r2 = r2 + 1
            r4 = r11
            goto L_0x001a
        L_0x002f:
            if (r2 != r8) goto L_0x0033
            int r0 = (int) r4
            return r0
        L_0x0033:
            if (r2 >= r8) goto L_0x0144
            char r13 = r0.charAt(r2)
            if (r13 >= r3) goto L_0x004a
            int r14 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r14 >= 0) goto L_0x004a
            long r14 = r4 + r11
            byte r13 = (byte) r13
            com.google.android.gms.internal.gtm.zztx.zza((byte[]) r1, (long) r4, (byte) r13)
            r4 = r11
            r12 = r14
            r11 = r3
            goto L_0x00fc
        L_0x004a:
            r14 = 2048(0x800, float:2.87E-42)
            if (r13 >= r14) goto L_0x0074
            r14 = 2
            long r14 = r6 - r14
            int r14 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r14 > 0) goto L_0x0074
            long r14 = r4 + r11
            int r3 = r13 >>> 6
            r3 = r3 | 960(0x3c0, float:1.345E-42)
            byte r3 = (byte) r3
            com.google.android.gms.internal.gtm.zztx.zza((byte[]) r1, (long) r4, (byte) r3)
            long r3 = r14 + r11
            r5 = r13 & 63
            r13 = 128(0x80, float:1.794E-43)
            r5 = r5 | r13
            byte r5 = (byte) r5
            com.google.android.gms.internal.gtm.zztx.zza((byte[]) r1, (long) r14, (byte) r5)
            r19 = r11
            r11 = 128(0x80, float:1.794E-43)
            r12 = r3
            r4 = r19
            goto L_0x00fc
        L_0x0074:
            r3 = 57343(0xdfff, float:8.0355E-41)
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r13 < r14) goto L_0x007e
            if (r3 >= r13) goto L_0x00af
        L_0x007e:
            r15 = 3
            long r15 = r6 - r15
            int r15 = (r4 > r15 ? 1 : (r4 == r15 ? 0 : -1))
            if (r15 > 0) goto L_0x00af
            long r14 = r4 + r11
            int r3 = r13 >>> 12
            r3 = r3 | 480(0x1e0, float:6.73E-43)
            byte r3 = (byte) r3
            com.google.android.gms.internal.gtm.zztx.zza((byte[]) r1, (long) r4, (byte) r3)
            long r3 = r14 + r11
            int r5 = r13 >>> 6
            r5 = r5 & 63
            r11 = 128(0x80, float:1.794E-43)
            r5 = r5 | r11
            byte r5 = (byte) r5
            com.google.android.gms.internal.gtm.zztx.zza((byte[]) r1, (long) r14, (byte) r5)
            r14 = 1
            long r17 = r3 + r14
            r5 = r13 & 63
            r5 = r5 | r11
            byte r5 = (byte) r5
            com.google.android.gms.internal.gtm.zztx.zza((byte[]) r1, (long) r3, (byte) r5)
            r12 = r17
            r4 = 1
            r11 = 128(0x80, float:1.794E-43)
            goto L_0x00fc
        L_0x00af:
            r11 = 4
            long r11 = r6 - r11
            int r11 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r11 > 0) goto L_0x010f
            int r3 = r2 + 1
            if (r3 == r8) goto L_0x0107
            char r2 = r0.charAt(r3)
            boolean r11 = java.lang.Character.isSurrogatePair(r13, r2)
            if (r11 == 0) goto L_0x0106
            int r2 = java.lang.Character.toCodePoint(r13, r2)
            r11 = 1
            long r13 = r4 + r11
            int r15 = r2 >>> 18
            r15 = r15 | 240(0xf0, float:3.36E-43)
            byte r15 = (byte) r15
            com.google.android.gms.internal.gtm.zztx.zza((byte[]) r1, (long) r4, (byte) r15)
            long r4 = r13 + r11
            int r15 = r2 >>> 12
            r15 = r15 & 63
            r11 = 128(0x80, float:1.794E-43)
            r12 = r15 | 128(0x80, float:1.794E-43)
            byte r12 = (byte) r12
            com.google.android.gms.internal.gtm.zztx.zza((byte[]) r1, (long) r13, (byte) r12)
            r12 = 1
            long r14 = r4 + r12
            int r16 = r2 >>> 6
            r12 = r16 & 63
            r12 = r12 | r11
            byte r12 = (byte) r12
            com.google.android.gms.internal.gtm.zztx.zza((byte[]) r1, (long) r4, (byte) r12)
            r4 = 1
            long r12 = r14 + r4
            r2 = r2 & 63
            r2 = r2 | r11
            byte r2 = (byte) r2
            com.google.android.gms.internal.gtm.zztx.zza((byte[]) r1, (long) r14, (byte) r2)
            r2 = r3
        L_0x00fc:
            int r2 = r2 + 1
            r3 = r11
            r19 = r4
            r4 = r12
            r11 = r19
            goto L_0x0033
        L_0x0106:
            r2 = r3
        L_0x0107:
            com.google.android.gms.internal.gtm.zzud r0 = new com.google.android.gms.internal.gtm.zzud
            int r2 = r2 + -1
            r0.<init>(r2, r8)
            throw r0
        L_0x010f:
            if (r14 > r13) goto L_0x0127
            if (r13 > r3) goto L_0x0127
            int r1 = r2 + 1
            if (r1 == r8) goto L_0x0121
            char r0 = r0.charAt(r1)
            boolean r0 = java.lang.Character.isSurrogatePair(r13, r0)
            if (r0 != 0) goto L_0x0127
        L_0x0121:
            com.google.android.gms.internal.gtm.zzud r0 = new com.google.android.gms.internal.gtm.zzud
            r0.<init>(r2, r8)
            throw r0
        L_0x0127:
            java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = 46
            r1.<init>(r2)
            r1.append(r10)
            r1.append(r13)
            r1.append(r9)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0144:
            int r0 = (int) r4
            return r0
        L_0x0146:
            java.lang.ArrayIndexOutOfBoundsException r1 = new java.lang.ArrayIndexOutOfBoundsException
            int r8 = r8 + -1
            char r0 = r0.charAt(r8)
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r4 = 37
            r3.<init>(r4)
            r3.append(r10)
            r3.append(r0)
            r3.append(r9)
            r3.append(r2)
            java.lang.String r0 = r3.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzue.zzb(java.lang.CharSequence, byte[], int, int):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0042 A[LOOP:1: B:11:0x0042->B:36:0x0107, LOOP_START, PHI: r2 r4 r6 r9 r12 
      PHI: (r2v2 long) = (r2v0 long), (r2v3 long) binds: [B:8:0x003a, B:36:0x0107] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r4v5 long) = (r4v4 long), (r4v7 long) binds: [B:8:0x003a, B:36:0x0107] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r6v3 long) = (r6v2 long), (r6v4 long) binds: [B:8:0x003a, B:36:0x0107] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r9v4 int) = (r9v3 int), (r9v6 int) binds: [B:8:0x003a, B:36:0x0107] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r12v1 char) = (r12v0 char), (r12v2 char) binds: [B:8:0x003a, B:36:0x0107] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(java.lang.CharSequence r22, java.nio.ByteBuffer r23) {
        /*
            r21 = this;
            r0 = r22
            r1 = r23
            long r2 = com.google.android.gms.internal.gtm.zztx.zzb(r23)
            int r4 = r23.position()
            long r4 = (long) r4
            long r4 = r4 + r2
            int r6 = r23.limit()
            long r6 = (long) r6
            long r6 = r6 + r2
            int r8 = r22.length()
            long r9 = (long) r8
            long r11 = r6 - r4
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            java.lang.String r10 = " at index "
            java.lang.String r11 = "Failed writing "
            if (r9 > 0) goto L_0x015c
            r9 = 0
        L_0x0024:
            r12 = 128(0x80, float:1.794E-43)
            r13 = 1
            if (r9 >= r8) goto L_0x003a
            char r15 = r0.charAt(r9)
            if (r15 >= r12) goto L_0x003a
            long r12 = r4 + r13
            byte r14 = (byte) r15
            com.google.android.gms.internal.gtm.zztx.zza((long) r4, (byte) r14)
            int r9 = r9 + 1
            r4 = r12
            goto L_0x0024
        L_0x003a:
            if (r9 != r8) goto L_0x0042
            long r4 = r4 - r2
            int r0 = (int) r4
            r1.position(r0)
            return
        L_0x0042:
            if (r9 >= r8) goto L_0x0151
            char r15 = r0.charAt(r9)
            if (r15 >= r12) goto L_0x005e
            int r16 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r16 >= 0) goto L_0x005e
            long r16 = r4 + r13
            byte r15 = (byte) r15
            com.google.android.gms.internal.gtm.zztx.zza((long) r4, (byte) r15)
            r19 = r6
            r1 = r9
            r9 = r12
            r4 = r16
            r17 = r2
            goto L_0x0107
        L_0x005e:
            r12 = 2048(0x800, float:2.87E-42)
            if (r15 >= r12) goto L_0x0089
            r17 = 2
            long r17 = r6 - r17
            int r12 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r12 > 0) goto L_0x0089
            r17 = r2
            long r1 = r4 + r13
            int r3 = r15 >>> 6
            r3 = r3 | 960(0x3c0, float:1.345E-42)
            byte r3 = (byte) r3
            com.google.android.gms.internal.gtm.zztx.zza((long) r4, (byte) r3)
            long r3 = r1 + r13
            r5 = r15 & 63
            r12 = 128(0x80, float:1.794E-43)
            r5 = r5 | r12
            byte r5 = (byte) r5
            com.google.android.gms.internal.gtm.zztx.zza((long) r1, (byte) r5)
            r4 = r3
        L_0x0082:
            r19 = r6
            r1 = r9
            r9 = 128(0x80, float:1.794E-43)
            goto L_0x0107
        L_0x0089:
            r17 = r2
            r1 = 57343(0xdfff, float:8.0355E-41)
            r2 = 55296(0xd800, float:7.7486E-41)
            if (r15 < r2) goto L_0x0095
            if (r1 >= r15) goto L_0x00bf
        L_0x0095:
            r19 = 3
            long r19 = r6 - r19
            int r3 = (r4 > r19 ? 1 : (r4 == r19 ? 0 : -1))
            if (r3 > 0) goto L_0x00bf
            long r1 = r4 + r13
            int r3 = r15 >>> 12
            r3 = r3 | 480(0x1e0, float:6.73E-43)
            byte r3 = (byte) r3
            com.google.android.gms.internal.gtm.zztx.zza((long) r4, (byte) r3)
            long r3 = r1 + r13
            int r5 = r15 >>> 6
            r5 = r5 & 63
            r12 = 128(0x80, float:1.794E-43)
            r5 = r5 | r12
            byte r5 = (byte) r5
            com.google.android.gms.internal.gtm.zztx.zza((long) r1, (byte) r5)
            long r1 = r3 + r13
            r5 = r15 & 63
            r5 = r5 | r12
            byte r5 = (byte) r5
            com.google.android.gms.internal.gtm.zztx.zza((long) r3, (byte) r5)
            r4 = r1
            goto L_0x0082
        L_0x00bf:
            r19 = 4
            long r19 = r6 - r19
            int r3 = (r4 > r19 ? 1 : (r4 == r19 ? 0 : -1))
            if (r3 > 0) goto L_0x011c
            int r1 = r9 + 1
            if (r1 == r8) goto L_0x0114
            char r2 = r0.charAt(r1)
            boolean r3 = java.lang.Character.isSurrogatePair(r15, r2)
            if (r3 == 0) goto L_0x0113
            int r2 = java.lang.Character.toCodePoint(r15, r2)
            r19 = r6
            long r6 = r4 + r13
            int r3 = r2 >>> 18
            r3 = r3 | 240(0xf0, float:3.36E-43)
            byte r3 = (byte) r3
            com.google.android.gms.internal.gtm.zztx.zza((long) r4, (byte) r3)
            long r3 = r6 + r13
            int r5 = r2 >>> 12
            r5 = r5 & 63
            r9 = 128(0x80, float:1.794E-43)
            r5 = r5 | r9
            byte r5 = (byte) r5
            com.google.android.gms.internal.gtm.zztx.zza((long) r6, (byte) r5)
            long r5 = r3 + r13
            int r7 = r2 >>> 6
            r7 = r7 & 63
            r7 = r7 | r9
            byte r7 = (byte) r7
            com.google.android.gms.internal.gtm.zztx.zza((long) r3, (byte) r7)
            long r3 = r5 + r13
            r2 = r2 & 63
            r2 = r2 | r9
            byte r2 = (byte) r2
            com.google.android.gms.internal.gtm.zztx.zza((long) r5, (byte) r2)
            r4 = r3
        L_0x0107:
            int r1 = r1 + 1
            r12 = r9
            r2 = r17
            r6 = r19
            r9 = r1
            r1 = r23
            goto L_0x0042
        L_0x0113:
            r9 = r1
        L_0x0114:
            com.google.android.gms.internal.gtm.zzud r0 = new com.google.android.gms.internal.gtm.zzud
            int r9 = r9 + -1
            r0.<init>(r9, r8)
            throw r0
        L_0x011c:
            if (r2 > r15) goto L_0x0134
            if (r15 > r1) goto L_0x0134
            int r1 = r9 + 1
            if (r1 == r8) goto L_0x012e
            char r0 = r0.charAt(r1)
            boolean r0 = java.lang.Character.isSurrogatePair(r15, r0)
            if (r0 != 0) goto L_0x0134
        L_0x012e:
            com.google.android.gms.internal.gtm.zzud r0 = new com.google.android.gms.internal.gtm.zzud
            r0.<init>(r9, r8)
            throw r0
        L_0x0134:
            java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = 46
            r1.<init>(r2)
            r1.append(r11)
            r1.append(r15)
            r1.append(r10)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0151:
            r17 = r2
            long r4 = r4 - r17
            int r0 = (int) r4
            r1 = r23
            r1.position(r0)
            return
        L_0x015c:
            java.lang.ArrayIndexOutOfBoundsException r2 = new java.lang.ArrayIndexOutOfBoundsException
            int r8 = r8 + -1
            char r0 = r0.charAt(r8)
            int r1 = r23.limit()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r4 = 37
            r3.<init>(r4)
            r3.append(r11)
            r3.append(r0)
            r3.append(r10)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzue.zzb(java.lang.CharSequence, java.nio.ByteBuffer):void");
    }
}
