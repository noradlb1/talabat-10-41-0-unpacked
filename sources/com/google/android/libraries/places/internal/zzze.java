package com.google.android.libraries.places.internal;

import java.math.RoundingMode;

public final class zzze {
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        if ((r6 & (r0 & 1)) != 0) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0042, code lost:
        if (r1 > 0) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0045, code lost:
        if (r5 > 0) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0048, code lost:
        if (r5 < 0) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004b, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004c, code lost:
        if (r2 != false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0053, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zza(int r5, int r6, java.math.RoundingMode r7) {
        /*
            r7.getClass()
            if (r6 == 0) goto L_0x0054
            int r0 = r5 / r6
            int r1 = r6 * r0
            int r1 = r5 - r1
            if (r1 != 0) goto L_0x000e
            return r0
        L_0x000e:
            r5 = r5 ^ r6
            int r5 = r5 >> 31
            r2 = 1
            r5 = r5 | r2
            int[] r3 = com.google.android.libraries.places.internal.zzzd.zza
            int r4 = r7.ordinal()
            r3 = r3[r4]
            r4 = 0
            switch(r3) {
                case 1: goto L_0x0050;
                case 2: goto L_0x0053;
                case 3: goto L_0x0048;
                case 4: goto L_0x004e;
                case 5: goto L_0x0045;
                case 6: goto L_0x0025;
                case 7: goto L_0x0025;
                case 8: goto L_0x0025;
                default: goto L_0x001f;
            }
        L_0x001f:
            java.lang.AssertionError r5 = new java.lang.AssertionError
            r5.<init>()
            throw r5
        L_0x0025:
            int r1 = java.lang.Math.abs(r1)
            int r6 = java.lang.Math.abs(r6)
            int r6 = r6 - r1
            int r1 = r1 - r6
            if (r1 != 0) goto L_0x0042
            java.math.RoundingMode r6 = java.math.RoundingMode.HALF_UP
            if (r7 == r6) goto L_0x004c
            java.math.RoundingMode r6 = java.math.RoundingMode.HALF_EVEN
            if (r7 != r6) goto L_0x003b
            r6 = r2
            goto L_0x003c
        L_0x003b:
            r6 = r4
        L_0x003c:
            r7 = r0 & 1
            r6 = r6 & r7
            if (r6 == 0) goto L_0x004b
            goto L_0x004c
        L_0x0042:
            if (r1 <= 0) goto L_0x004b
            goto L_0x004c
        L_0x0045:
            if (r5 <= 0) goto L_0x004b
            goto L_0x004c
        L_0x0048:
            if (r5 >= 0) goto L_0x004b
            goto L_0x004c
        L_0x004b:
            r2 = r4
        L_0x004c:
            if (r2 == 0) goto L_0x0053
        L_0x004e:
            int r0 = r0 + r5
            return r0
        L_0x0050:
            com.google.android.libraries.places.internal.zzzf.zza(r4)
        L_0x0053:
            return r0
        L_0x0054:
            java.lang.ArithmeticException r5 = new java.lang.ArithmeticException
            java.lang.String r6 = "/ by zero"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzze.zza(int, int, java.math.RoundingMode):int");
    }

    public static int zzb(int i11, RoundingMode roundingMode) {
        boolean z11;
        if (i11 > 0) {
            switch (zzzd.zza[roundingMode.ordinal()]) {
                case 1:
                    if (((i11 - 1) & i11) == 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    zzzf.zza(z11);
                    break;
                case 2:
                case 3:
                    break;
                case 4:
                case 5:
                    return 32 - Integer.numberOfLeadingZeros(i11 - 1);
                case 6:
                case 7:
                case 8:
                    int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i11);
                    return (31 - numberOfLeadingZeros) + (((-1257966797 >>> numberOfLeadingZeros) - i11) >>> 31);
                default:
                    throw new AssertionError();
            }
            return 31 - Integer.numberOfLeadingZeros(i11);
        }
        throw new IllegalArgumentException("x (0) must be > 0");
    }
}
