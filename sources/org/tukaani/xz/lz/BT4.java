package org.tukaani.xz.lz;

import org.tukaani.xz.ArrayCache;

final class BT4 extends LZEncoder {
    private int cyclicPos = -1;
    private final int cyclicSize;
    private final int depthLimit;
    private final Hash234 hash;
    private int lzPos;
    private final Matches matches;
    private final int[] tree;

    public BT4(int i11, int i12, int i13, int i14, int i15, int i16, ArrayCache arrayCache) {
        super(i11, i12, i13, i14, i15, arrayCache);
        int i17 = i11 + 1;
        this.cyclicSize = i17;
        this.lzPos = i17;
        this.hash = new Hash234(i11, arrayCache);
        this.tree = arrayCache.getIntArray(i17 * 2, false);
        this.matches = new Matches(i14 - 1);
        this.depthLimit = i16 <= 0 ? (i14 / 2) + 16 : i16;
    }

    public static int c(int i11) {
        return Hash234.f(i11) + (i11 / 128) + 10;
    }

    private int movePos() {
        int a11 = a(this.f63433b, 4);
        if (a11 != 0) {
            int i11 = this.lzPos + 1;
            this.lzPos = i11;
            if (i11 == Integer.MAX_VALUE) {
                int i12 = Integer.MAX_VALUE - this.cyclicSize;
                this.hash.g(i12);
                LZEncoder.b(this.tree, this.cyclicSize * 2, i12);
                this.lzPos -= i12;
            }
            int i13 = this.cyclicPos + 1;
            this.cyclicPos = i13;
            if (i13 == this.cyclicSize) {
                this.cyclicPos = 0;
            }
        }
        return a11;
    }

    private void skip(int i11, int i12) {
        int i13;
        byte[] bArr;
        int i14;
        int i15 = this.depthLimit;
        int i16 = this.cyclicPos;
        int i17 = (i16 << 1) + 1;
        int i18 = i16 << 1;
        int i19 = 0;
        int i21 = 0;
        while (true) {
            int i22 = this.lzPos - i12;
            int i23 = i15 - 1;
            if (i15 == 0 || i22 >= (i13 = this.cyclicSize)) {
                int[] iArr = this.tree;
                iArr[i17] = 0;
                iArr[i18] = 0;
            } else {
                int i24 = this.cyclicPos;
                int i25 = i24 - i22;
                if (i22 <= i24) {
                    i13 = 0;
                }
                int i26 = (i25 + i13) << 1;
                int min = Math.min(i19, i21);
                byte[] bArr2 = this.f63434c;
                int i27 = this.f63436e;
                if (bArr2[(i27 + min) - i22] == bArr2[i27 + min]) {
                    do {
                        min++;
                        if (min == i11) {
                            int[] iArr2 = this.tree;
                            iArr2[i18] = iArr2[i26];
                            iArr2[i17] = iArr2[i26 + 1];
                            return;
                        }
                        bArr = this.f63434c;
                        i14 = this.f63436e;
                    } while (bArr[(i14 + min) - i22] == bArr[i14 + min]);
                }
                byte[] bArr3 = this.f63434c;
                int i28 = this.f63436e;
                if ((bArr3[(i28 + min) - i22] & 255) < (bArr3[i28 + min] & 255)) {
                    int[] iArr3 = this.tree;
                    iArr3[i18] = i12;
                    int i29 = i26 + 1;
                    i12 = iArr3[i29];
                    i18 = i29;
                    i21 = min;
                } else {
                    int[] iArr4 = this.tree;
                    iArr4[i17] = i12;
                    i12 = iArr4[i26];
                    i17 = i26;
                    i19 = min;
                }
                i15 = i23;
            }
        }
        int[] iArr5 = this.tree;
        iArr5[i17] = 0;
        iArr5[i18] = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008b A[LOOP:0: B:22:0x008b->B:25:0x009b, LOOP_START, PHI: r11 
      PHI: (r11v7 int) = (r11v1 int), (r11v8 int) binds: [B:21:0x0089, B:25:0x009b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0132  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x014b A[EDGE_INSN: B:62:0x014b->B:59:0x014b ?: BREAK  
    EDGE_INSN: B:63:0x014b->B:59:0x014b ?: BREAK  ] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.tukaani.xz.lz.Matches getMatches() {
        /*
            r17 = this;
            r0 = r17
            org.tukaani.xz.lz.Matches r1 = r0.matches
            r2 = 0
            r1.count = r2
            int r1 = r0.f63432a
            int r3 = r0.f63433b
            int r4 = r17.movePos()
            if (r4 >= r1) goto L_0x001a
            if (r4 != 0) goto L_0x0016
            org.tukaani.xz.lz.Matches r1 = r0.matches
            return r1
        L_0x0016:
            r1 = r4
            if (r3 <= r4) goto L_0x001a
            r3 = r1
        L_0x001a:
            org.tukaani.xz.lz.Hash234 r4 = r0.hash
            byte[] r5 = r0.f63434c
            int r6 = r0.f63436e
            r4.a(r5, r6)
            int r4 = r0.lzPos
            org.tukaani.xz.lz.Hash234 r5 = r0.hash
            int r5 = r5.b()
            int r4 = r4 - r5
            int r5 = r0.lzPos
            org.tukaani.xz.lz.Hash234 r6 = r0.hash
            int r6 = r6.c()
            int r5 = r5 - r6
            org.tukaani.xz.lz.Hash234 r6 = r0.hash
            int r6 = r6.d()
            org.tukaani.xz.lz.Hash234 r7 = r0.hash
            int r8 = r0.lzPos
            r7.i(r8)
            int r7 = r0.cyclicSize
            r8 = 1
            if (r4 >= r7) goto L_0x0063
            byte[] r9 = r0.f63434c
            int r10 = r0.f63436e
            int r11 = r10 - r4
            byte r11 = r9[r11]
            byte r9 = r9[r10]
            if (r11 != r9) goto L_0x0063
            org.tukaani.xz.lz.Matches r9 = r0.matches
            int[] r10 = r9.len
            r11 = 2
            r10[r2] = r11
            int[] r10 = r9.dist
            int r12 = r4 + -1
            r10[r2] = r12
            r9.count = r8
            goto L_0x0064
        L_0x0063:
            r11 = r2
        L_0x0064:
            r9 = 3
            if (r4 == r5) goto L_0x0085
            if (r5 >= r7) goto L_0x0085
            byte[] r7 = r0.f63434c
            int r10 = r0.f63436e
            int r12 = r10 - r5
            byte r12 = r7[r12]
            byte r7 = r7[r10]
            if (r12 != r7) goto L_0x0085
            org.tukaani.xz.lz.Matches r4 = r0.matches
            int[] r7 = r4.dist
            int r10 = r4.count
            int r11 = r10 + 1
            r4.count = r11
            int r4 = r5 + -1
            r7[r10] = r4
            r4 = r5
            r11 = r9
        L_0x0085:
            org.tukaani.xz.lz.Matches r5 = r0.matches
            int r5 = r5.count
            if (r5 <= 0) goto L_0x00af
        L_0x008b:
            if (r11 >= r1) goto L_0x009e
            byte[] r5 = r0.f63434c
            int r7 = r0.f63436e
            int r10 = r7 + r11
            int r10 = r10 - r4
            byte r10 = r5[r10]
            int r7 = r7 + r11
            byte r5 = r5[r7]
            if (r10 != r5) goto L_0x009e
            int r11 = r11 + 1
            goto L_0x008b
        L_0x009e:
            org.tukaani.xz.lz.Matches r4 = r0.matches
            int[] r5 = r4.len
            int r4 = r4.count
            int r4 = r4 - r8
            r5[r4] = r11
            if (r11 < r3) goto L_0x00af
            r0.skip(r3, r6)
        L_0x00ac:
            org.tukaani.xz.lz.Matches r1 = r0.matches
            return r1
        L_0x00af:
            if (r11 >= r9) goto L_0x00b2
            goto L_0x00b3
        L_0x00b2:
            r9 = r11
        L_0x00b3:
            int r4 = r0.depthLimit
            int r5 = r0.cyclicPos
            int r7 = r5 << 1
            int r7 = r7 + r8
            int r5 = r5 << r8
            r10 = r2
            r11 = r10
        L_0x00bd:
            int r12 = r0.lzPos
            int r12 = r12 - r6
            int r13 = r4 + -1
            if (r4 == 0) goto L_0x014b
            int r4 = r0.cyclicSize
            if (r12 < r4) goto L_0x00ca
            goto L_0x014b
        L_0x00ca:
            int r14 = r0.cyclicPos
            int r15 = r14 - r12
            if (r12 <= r14) goto L_0x00d1
            goto L_0x00d2
        L_0x00d1:
            r4 = r2
        L_0x00d2:
            int r15 = r15 + r4
            int r4 = r15 << 1
            int r14 = java.lang.Math.min(r10, r11)
            byte[] r15 = r0.f63434c
            int r2 = r0.f63436e
            int r16 = r2 + r14
            int r16 = r16 - r12
            byte r8 = r15[r16]
            int r2 = r2 + r14
            byte r2 = r15[r2]
            if (r8 != r2) goto L_0x011e
        L_0x00e8:
            r2 = 1
            int r14 = r14 + r2
            if (r14 >= r1) goto L_0x00fa
            byte[] r2 = r0.f63434c
            int r8 = r0.f63436e
            int r15 = r8 + r14
            int r15 = r15 - r12
            byte r15 = r2[r15]
            int r8 = r8 + r14
            byte r2 = r2[r8]
            if (r15 == r2) goto L_0x00e8
        L_0x00fa:
            if (r14 <= r9) goto L_0x011e
            org.tukaani.xz.lz.Matches r2 = r0.matches
            int[] r8 = r2.len
            int r9 = r2.count
            r8[r9] = r14
            int[] r8 = r2.dist
            int r15 = r12 + -1
            r8[r9] = r15
            r8 = 1
            int r9 = r9 + r8
            r2.count = r9
            if (r14 < r3) goto L_0x011c
            int[] r1 = r0.tree
            r3 = r1[r4]
            r1[r5] = r3
            int r4 = r4 + r8
            r3 = r1[r4]
            r1[r7] = r3
            return r2
        L_0x011c:
            r9 = r14
            goto L_0x011f
        L_0x011e:
            r8 = 1
        L_0x011f:
            byte[] r2 = r0.f63434c
            int r15 = r0.f63436e
            int r16 = r15 + r14
            int r16 = r16 - r12
            byte r12 = r2[r16]
            r12 = r12 & 255(0xff, float:3.57E-43)
            int r15 = r15 + r14
            byte r2 = r2[r15]
            r2 = r2 & 255(0xff, float:3.57E-43)
            if (r12 >= r2) goto L_0x013e
            int[] r2 = r0.tree
            r2[r5] = r6
            int r4 = r4 + 1
            r2 = r2[r4]
            r6 = r2
            r5 = r4
            r11 = r14
            goto L_0x0147
        L_0x013e:
            int[] r2 = r0.tree
            r2[r7] = r6
            r2 = r2[r4]
            r6 = r2
            r7 = r4
            r10 = r14
        L_0x0147:
            r4 = r13
            r2 = 0
            goto L_0x00bd
        L_0x014b:
            int[] r1 = r0.tree
            r2 = 0
            r1[r7] = r2
            r1[r5] = r2
            goto L_0x00ac
        */
        throw new UnsupportedOperationException("Method not decompiled: org.tukaani.xz.lz.BT4.getMatches():org.tukaani.xz.lz.Matches");
    }

    public void putArraysToCache(ArrayCache arrayCache) {
        arrayCache.putArray(this.tree);
        this.hash.h(arrayCache);
        super.putArraysToCache(arrayCache);
    }

    public void skip(int i11) {
        while (true) {
            int i12 = i11 - 1;
            if (i11 > 0) {
                int i13 = this.f63433b;
                int movePos = movePos();
                if (movePos < i13) {
                    if (movePos == 0) {
                        i11 = i12;
                    } else {
                        i13 = movePos;
                    }
                }
                this.hash.a(this.f63434c, this.f63436e);
                int d11 = this.hash.d();
                this.hash.i(this.lzPos);
                skip(i13, d11);
                i11 = i12;
            } else {
                return;
            }
        }
    }
}
