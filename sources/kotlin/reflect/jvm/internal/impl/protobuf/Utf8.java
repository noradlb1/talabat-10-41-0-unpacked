package kotlin.reflect.jvm.internal.impl.protobuf;

import com.google.common.base.Ascii;

final class Utf8 {
    private static int incompleteStateFor(int i11) {
        if (i11 > -12) {
            return -1;
        }
        return i11;
    }

    private static int incompleteStateFor(int i11, int i12) {
        if (i11 > -12 || i12 > -65) {
            return -1;
        }
        return i11 ^ (i12 << 8);
    }

    private static int incompleteStateFor(int i11, int i12, int i13) {
        if (i11 > -12 || i12 > -65 || i13 > -65) {
            return -1;
        }
        return (i11 ^ (i12 << 8)) ^ (i13 << 16);
    }

    private static int incompleteStateFor(byte[] bArr, int i11, int i12) {
        byte b11 = bArr[i11 - 1];
        int i13 = i12 - i11;
        if (i13 == 0) {
            return incompleteStateFor(b11);
        }
        if (i13 == 1) {
            return incompleteStateFor(b11, bArr[i11]);
        }
        if (i13 == 2) {
            return incompleteStateFor((int) b11, (int) bArr[i11], (int) bArr[i11 + 1]);
        }
        throw new AssertionError();
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return isValidUtf8(bArr, 0, bArr.length);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
        if (r7[r8] > -65) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0083, code lost:
        if (r7[r6] > -65) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r7[r8] > -65) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int partialIsValidUtf8(int r6, byte[] r7, int r8, int r9) {
        /*
            if (r6 == 0) goto L_0x0086
            if (r8 < r9) goto L_0x0005
            return r6
        L_0x0005:
            byte r0 = (byte) r6
            r1 = -32
            r2 = -1
            r3 = -65
            if (r0 >= r1) goto L_0x001c
            r6 = -62
            if (r0 < r6) goto L_0x001b
            int r6 = r8 + 1
            byte r8 = r7[r8]
            if (r8 <= r3) goto L_0x0018
            goto L_0x001b
        L_0x0018:
            r8 = r6
            goto L_0x0086
        L_0x001b:
            return r2
        L_0x001c:
            r4 = -16
            if (r0 >= r4) goto L_0x0049
            int r6 = r6 >> 8
            int r6 = ~r6
            byte r6 = (byte) r6
            if (r6 != 0) goto L_0x0034
            int r6 = r8 + 1
            byte r8 = r7[r8]
            if (r6 < r9) goto L_0x0031
            int r6 = incompleteStateFor(r0, r8)
            return r6
        L_0x0031:
            r5 = r8
            r8 = r6
            r6 = r5
        L_0x0034:
            if (r6 > r3) goto L_0x0048
            r4 = -96
            if (r0 != r1) goto L_0x003c
            if (r6 < r4) goto L_0x0048
        L_0x003c:
            r1 = -19
            if (r0 != r1) goto L_0x0042
            if (r6 >= r4) goto L_0x0048
        L_0x0042:
            int r6 = r8 + 1
            byte r8 = r7[r8]
            if (r8 <= r3) goto L_0x0018
        L_0x0048:
            return r2
        L_0x0049:
            int r1 = r6 >> 8
            int r1 = ~r1
            byte r1 = (byte) r1
            if (r1 != 0) goto L_0x005c
            int r6 = r8 + 1
            byte r1 = r7[r8]
            if (r6 < r9) goto L_0x005a
            int r6 = incompleteStateFor(r0, r1)
            return r6
        L_0x005a:
            r8 = 0
            goto L_0x0062
        L_0x005c:
            int r6 = r6 >> 16
            byte r6 = (byte) r6
            r5 = r8
            r8 = r6
            r6 = r5
        L_0x0062:
            if (r8 != 0) goto L_0x0072
            int r8 = r6 + 1
            byte r6 = r7[r6]
            if (r8 < r9) goto L_0x006f
            int r6 = incompleteStateFor((int) r0, (int) r1, (int) r6)
            return r6
        L_0x006f:
            r5 = r8
            r8 = r6
            r6 = r5
        L_0x0072:
            if (r1 > r3) goto L_0x0085
            int r0 = r0 << 28
            int r1 = r1 + 112
            int r0 = r0 + r1
            int r0 = r0 >> 30
            if (r0 != 0) goto L_0x0085
            if (r8 > r3) goto L_0x0085
            int r8 = r6 + 1
            byte r6 = r7[r6]
            if (r6 <= r3) goto L_0x0086
        L_0x0085:
            return r2
        L_0x0086:
            int r6 = partialIsValidUtf8(r7, r8, r9)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.Utf8.partialIsValidUtf8(int, byte[], int, int):int");
    }

    private static int partialIsValidUtf8NonAscii(byte[] bArr, int i11, int i12) {
        while (i11 < i12) {
            int i13 = i11 + 1;
            byte b11 = bArr[i11];
            if (b11 < 0) {
                if (b11 < -32) {
                    if (i13 >= i12) {
                        return b11;
                    }
                    if (b11 >= -62) {
                        i11 = i13 + 1;
                        if (bArr[i13] > -65) {
                        }
                    }
                    return -1;
                } else if (b11 < -16) {
                    if (i13 >= i12 - 1) {
                        return incompleteStateFor(bArr, i13, i12);
                    }
                    int i14 = i13 + 1;
                    byte b12 = bArr[i13];
                    if (b12 <= -65 && ((b11 != -32 || b12 >= -96) && (b11 != -19 || b12 < -96))) {
                        i11 = i14 + 1;
                        if (bArr[i14] > -65) {
                        }
                    }
                    return -1;
                } else if (i13 >= i12 - 2) {
                    return incompleteStateFor(bArr, i13, i12);
                } else {
                    int i15 = i13 + 1;
                    byte b13 = bArr[i13];
                    if (b13 <= -65 && (((b11 << Ascii.FS) + (b13 + 112)) >> 30) == 0) {
                        int i16 = i15 + 1;
                        if (bArr[i15] <= -65) {
                            i13 = i16 + 1;
                            if (bArr[i16] > -65) {
                            }
                        }
                    }
                    return -1;
                }
            }
            i11 = i13;
        }
        return 0;
    }

    public static boolean isValidUtf8(byte[] bArr, int i11, int i12) {
        return partialIsValidUtf8(bArr, i11, i12) == 0;
    }

    public static int partialIsValidUtf8(byte[] bArr, int i11, int i12) {
        while (i11 < i12 && bArr[i11] >= 0) {
            i11++;
        }
        if (i11 >= i12) {
            return 0;
        }
        return partialIsValidUtf8NonAscii(bArr, i11, i12);
    }
}
