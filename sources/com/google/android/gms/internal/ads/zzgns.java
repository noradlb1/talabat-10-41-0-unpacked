package com.google.android.gms.internal.ads;

final class zzgns extends zzgnr {
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0047, code lost:
        if (r13[r14] <= -65) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0083, code lost:
        if (r13[r14] <= -65) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        if (r13[r14] <= -65) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(int r12, byte[] r13, int r14, int r15) {
        /*
            r11 = this;
            r0 = -19
            r1 = -62
            r2 = -16
            r3 = 0
            r4 = -96
            r5 = -32
            r6 = -65
            r7 = -1
            if (r12 == 0) goto L_0x0087
            if (r14 < r15) goto L_0x0013
            return r12
        L_0x0013:
            byte r8 = (byte) r12
            if (r8 >= r5) goto L_0x0022
            if (r8 < r1) goto L_0x0021
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r14 > r6) goto L_0x0021
        L_0x001e:
            r14 = r12
            goto L_0x0087
        L_0x0021:
            return r7
        L_0x0022:
            if (r8 >= r2) goto L_0x004b
            int r12 = r12 >> 8
            int r12 = ~r12
            byte r12 = (byte) r12
            if (r12 != 0) goto L_0x0039
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r12 >= r15) goto L_0x0034
            r10 = r14
            r14 = r12
            r12 = r10
            goto L_0x0039
        L_0x0034:
            int r12 = com.google.android.gms.internal.ads.zzgnu.zzk(r8, r14)
            return r12
        L_0x0039:
            if (r12 > r6) goto L_0x004a
            if (r8 != r5) goto L_0x003f
            if (r12 < r4) goto L_0x004a
        L_0x003f:
            if (r8 != r0) goto L_0x0043
            if (r12 >= r4) goto L_0x004a
        L_0x0043:
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r14 > r6) goto L_0x004a
            goto L_0x001e
        L_0x004a:
            return r7
        L_0x004b:
            int r9 = r12 >> 8
            int r9 = ~r9
            byte r9 = (byte) r9
            if (r9 != 0) goto L_0x005f
            int r12 = r14 + 1
            byte r9 = r13[r14]
            if (r12 >= r15) goto L_0x005a
            r14 = r12
            r12 = r3
            goto L_0x0061
        L_0x005a:
            int r12 = com.google.android.gms.internal.ads.zzgnu.zzk(r8, r9)
            return r12
        L_0x005f:
            int r12 = r12 >> 16
        L_0x0061:
            if (r12 != 0) goto L_0x0072
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r12 >= r15) goto L_0x006d
            r10 = r14
            r14 = r12
            r12 = r10
            goto L_0x0072
        L_0x006d:
            int r12 = com.google.android.gms.internal.ads.zzgnu.zzl(r8, r9, r14)
            return r12
        L_0x0072:
            if (r9 > r6) goto L_0x0086
            int r8 = r8 << 28
            int r9 = r9 + 112
            int r8 = r8 + r9
            int r8 = r8 >> 30
            if (r8 != 0) goto L_0x0086
            if (r12 > r6) goto L_0x0086
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r14 > r6) goto L_0x0086
            goto L_0x001e
        L_0x0086:
            return r7
        L_0x0087:
            if (r14 >= r15) goto L_0x0090
            byte r12 = r13[r14]
            if (r12 < 0) goto L_0x0090
            int r14 = r14 + 1
            goto L_0x0087
        L_0x0090:
            if (r14 < r15) goto L_0x0094
            goto L_0x00f3
        L_0x0094:
            if (r14 < r15) goto L_0x0098
            goto L_0x00f3
        L_0x0098:
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r14 >= 0) goto L_0x00f4
            if (r14 >= r5) goto L_0x00ae
            if (r12 >= r15) goto L_0x00ac
            if (r14 < r1) goto L_0x00aa
            int r14 = r12 + 1
            byte r12 = r13[r12]
            if (r12 <= r6) goto L_0x0094
        L_0x00aa:
            r3 = r7
            goto L_0x00f3
        L_0x00ac:
            r3 = r14
            goto L_0x00f3
        L_0x00ae:
            if (r14 >= r2) goto L_0x00ce
            int r8 = r15 + -1
            if (r12 < r8) goto L_0x00b9
            int r3 = com.google.android.gms.internal.ads.zzgnu.zzc(r13, r12, r15)
            goto L_0x00f3
        L_0x00b9:
            int r8 = r12 + 1
            byte r12 = r13[r12]
            if (r12 > r6) goto L_0x00aa
            if (r14 != r5) goto L_0x00c3
            if (r12 < r4) goto L_0x00aa
        L_0x00c3:
            if (r14 != r0) goto L_0x00c7
            if (r12 >= r4) goto L_0x00aa
        L_0x00c7:
            int r14 = r8 + 1
            byte r12 = r13[r8]
            if (r12 <= r6) goto L_0x0094
            goto L_0x00aa
        L_0x00ce:
            int r8 = r15 + -2
            if (r12 < r8) goto L_0x00d7
            int r3 = com.google.android.gms.internal.ads.zzgnu.zzc(r13, r12, r15)
            goto L_0x00f3
        L_0x00d7:
            int r8 = r12 + 1
            byte r12 = r13[r12]
            if (r12 > r6) goto L_0x00aa
            int r14 = r14 << 28
            int r12 = r12 + 112
            int r14 = r14 + r12
            int r12 = r14 >> 30
            if (r12 != 0) goto L_0x00aa
            int r12 = r8 + 1
            byte r14 = r13[r8]
            if (r14 > r6) goto L_0x00aa
            int r14 = r12 + 1
            byte r12 = r13[r12]
            if (r12 <= r6) goto L_0x0094
            goto L_0x00aa
        L_0x00f3:
            return r3
        L_0x00f4:
            r14 = r12
            goto L_0x0094
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgns.zza(int, byte[], int, int):int");
    }

    public final String zzb(byte[] bArr, int i11, int i12) throws zzgkx {
        int i13;
        int length = bArr.length;
        if ((i11 | i12 | ((length - i11) - i12)) >= 0) {
            int i14 = i11 + i12;
            char[] cArr = new char[i12];
            int i15 = 0;
            while (r12 < i14) {
                byte b11 = bArr[r12];
                if (!zzgnq.zzd(b11)) {
                    break;
                }
                i11 = r12 + 1;
                cArr[i13] = (char) b11;
                i15 = i13 + 1;
            }
            while (r12 < i14) {
                int i16 = r12 + 1;
                byte b12 = bArr[r12];
                if (zzgnq.zzd(b12)) {
                    int i17 = i13 + 1;
                    cArr[i13] = (char) b12;
                    r12 = i16;
                    while (true) {
                        i13 = i17;
                        if (r12 >= i14) {
                            break;
                        }
                        byte b13 = bArr[r12];
                        if (!zzgnq.zzd(b13)) {
                            break;
                        }
                        r12++;
                        i17 = i13 + 1;
                        cArr[i13] = (char) b13;
                    }
                } else if (zzgnq.zzf(b12)) {
                    if (i16 < i14) {
                        zzgnq.zzc(b12, bArr[i16], cArr, i13);
                        r12 = i16 + 1;
                        i13++;
                    } else {
                        throw zzgkx.zzd();
                    }
                } else if (zzgnq.zze(b12)) {
                    if (i16 < i14 - 1) {
                        int i18 = i16 + 1;
                        zzgnq.zzb(b12, bArr[i16], bArr[i18], cArr, i13);
                        r12 = i18 + 1;
                        i13++;
                    } else {
                        throw zzgkx.zzd();
                    }
                } else if (i16 < i14 - 2) {
                    int i19 = i16 + 1;
                    int i21 = i19 + 1;
                    zzgnq.zza(b12, bArr[i16], bArr[i19], bArr[i21], cArr, i13);
                    i13 += 2;
                    r12 = i21 + 1;
                } else {
                    throw zzgkx.zzd();
                }
            }
            return new String(cArr, 0, i13);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(length), Integer.valueOf(i11), Integer.valueOf(i12)}));
    }
}
