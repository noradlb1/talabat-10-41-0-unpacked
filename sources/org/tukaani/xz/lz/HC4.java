package org.tukaani.xz.lz;

import org.tukaani.xz.ArrayCache;

final class HC4 extends LZEncoder {
    private final int[] chain;
    private int cyclicPos = -1;
    private final int cyclicSize;
    private final int depthLimit;
    private final Hash234 hash;
    private int lzPos;
    private final Matches matches;

    public HC4(int i11, int i12, int i13, int i14, int i15, int i16, ArrayCache arrayCache) {
        super(i11, i12, i13, i14, i15, arrayCache);
        this.hash = new Hash234(i11, arrayCache);
        int i17 = i11 + 1;
        this.cyclicSize = i17;
        this.chain = arrayCache.getIntArray(i17, false);
        this.lzPos = i17;
        this.matches = new Matches(i14 - 1);
        this.depthLimit = i16 <= 0 ? (i14 / 4) + 4 : i16;
    }

    public static int c(int i11) {
        return Hash234.f(i11) + (i11 / 256) + 10;
    }

    private int movePos() {
        int a11 = a(4, 4);
        if (a11 != 0) {
            int i11 = this.lzPos + 1;
            this.lzPos = i11;
            if (i11 == Integer.MAX_VALUE) {
                int i12 = Integer.MAX_VALUE - this.cyclicSize;
                this.hash.g(i12);
                LZEncoder.b(this.chain, this.cyclicSize, i12);
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

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008f A[LOOP:0: B:22:0x008f->B:25:0x009f, LOOP_START, PHI: r10 
      PHI: (r10v14 int) = (r10v1 int), (r10v15 int) binds: [B:21:0x008d, B:25:0x009f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0111 A[EDGE_INSN: B:59:0x0111->B:54:0x0111 ?: BREAK  
    EDGE_INSN: B:60:0x0111->B:54:0x0111 ?: BREAK  ] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.tukaani.xz.lz.Matches getMatches() {
        /*
            r13 = this;
            org.tukaani.xz.lz.Matches r0 = r13.matches
            r1 = 0
            r0.count = r1
            int r0 = r13.f63432a
            int r2 = r13.f63433b
            int r3 = r13.movePos()
            if (r3 >= r0) goto L_0x0018
            if (r3 != 0) goto L_0x0014
            org.tukaani.xz.lz.Matches r0 = r13.matches
            return r0
        L_0x0014:
            r0 = r3
            if (r2 <= r3) goto L_0x0018
            r2 = r0
        L_0x0018:
            org.tukaani.xz.lz.Hash234 r3 = r13.hash
            byte[] r4 = r13.f63434c
            int r5 = r13.f63436e
            r3.a(r4, r5)
            int r3 = r13.lzPos
            org.tukaani.xz.lz.Hash234 r4 = r13.hash
            int r4 = r4.b()
            int r3 = r3 - r4
            int r4 = r13.lzPos
            org.tukaani.xz.lz.Hash234 r5 = r13.hash
            int r5 = r5.c()
            int r4 = r4 - r5
            org.tukaani.xz.lz.Hash234 r5 = r13.hash
            int r5 = r5.d()
            org.tukaani.xz.lz.Hash234 r6 = r13.hash
            int r7 = r13.lzPos
            r6.i(r7)
            int[] r6 = r13.chain
            int r7 = r13.cyclicPos
            r6[r7] = r5
            int r6 = r13.cyclicSize
            r7 = 1
            if (r3 >= r6) goto L_0x0067
            byte[] r8 = r13.f63434c
            int r9 = r13.f63436e
            int r10 = r9 - r3
            byte r10 = r8[r10]
            byte r8 = r8[r9]
            if (r10 != r8) goto L_0x0067
            org.tukaani.xz.lz.Matches r8 = r13.matches
            int[] r9 = r8.len
            r10 = 2
            r9[r1] = r10
            int[] r9 = r8.dist
            int r11 = r3 + -1
            r9[r1] = r11
            r8.count = r7
            goto L_0x0068
        L_0x0067:
            r10 = r1
        L_0x0068:
            r8 = 3
            if (r3 == r4) goto L_0x0089
            if (r4 >= r6) goto L_0x0089
            byte[] r6 = r13.f63434c
            int r9 = r13.f63436e
            int r11 = r9 - r4
            byte r11 = r6[r11]
            byte r6 = r6[r9]
            if (r11 != r6) goto L_0x0089
            org.tukaani.xz.lz.Matches r3 = r13.matches
            int[] r6 = r3.dist
            int r9 = r3.count
            int r10 = r9 + 1
            r3.count = r10
            int r3 = r4 + -1
            r6[r9] = r3
            r3 = r4
            r10 = r8
        L_0x0089:
            org.tukaani.xz.lz.Matches r4 = r13.matches
            int r4 = r4.count
            if (r4 <= 0) goto L_0x00ae
        L_0x008f:
            if (r10 >= r0) goto L_0x00a2
            byte[] r4 = r13.f63434c
            int r6 = r13.f63436e
            int r9 = r6 + r10
            int r9 = r9 - r3
            byte r9 = r4[r9]
            int r6 = r6 + r10
            byte r4 = r4[r6]
            if (r9 != r4) goto L_0x00a2
            int r10 = r10 + 1
            goto L_0x008f
        L_0x00a2:
            org.tukaani.xz.lz.Matches r3 = r13.matches
            int[] r4 = r3.len
            int r6 = r3.count
            int r6 = r6 - r7
            r4[r6] = r10
            if (r10 < r2) goto L_0x00ae
            return r3
        L_0x00ae:
            if (r10 >= r8) goto L_0x00b1
            goto L_0x00b2
        L_0x00b1:
            r8 = r10
        L_0x00b2:
            int r3 = r13.depthLimit
        L_0x00b4:
            int r4 = r13.lzPos
            int r4 = r4 - r5
            int r5 = r3 + -1
            if (r3 == 0) goto L_0x0111
            int r3 = r13.cyclicSize
            if (r4 < r3) goto L_0x00c0
            goto L_0x0111
        L_0x00c0:
            int[] r6 = r13.chain
            int r9 = r13.cyclicPos
            int r10 = r9 - r4
            if (r4 <= r9) goto L_0x00c9
            goto L_0x00ca
        L_0x00c9:
            r3 = r1
        L_0x00ca:
            int r10 = r10 + r3
            r3 = r6[r10]
            byte[] r6 = r13.f63434c
            int r9 = r13.f63436e
            int r10 = r9 + r8
            int r10 = r10 - r4
            byte r10 = r6[r10]
            int r11 = r9 + r8
            byte r11 = r6[r11]
            if (r10 != r11) goto L_0x010d
            int r10 = r9 - r4
            byte r10 = r6[r10]
            byte r6 = r6[r9]
            if (r10 != r6) goto L_0x010d
            r6 = r1
        L_0x00e5:
            int r6 = r6 + r7
            if (r6 >= r0) goto L_0x00f6
            byte[] r9 = r13.f63434c
            int r10 = r13.f63436e
            int r11 = r10 + r6
            int r11 = r11 - r4
            byte r11 = r9[r11]
            int r10 = r10 + r6
            byte r9 = r9[r10]
            if (r11 == r9) goto L_0x00e5
        L_0x00f6:
            if (r6 <= r8) goto L_0x010d
            org.tukaani.xz.lz.Matches r8 = r13.matches
            int[] r9 = r8.len
            int r10 = r8.count
            r9[r10] = r6
            int[] r9 = r8.dist
            int r4 = r4 + -1
            r9[r10] = r4
            int r10 = r10 + r7
            r8.count = r10
            if (r6 < r2) goto L_0x010c
            return r8
        L_0x010c:
            r8 = r6
        L_0x010d:
            r12 = r5
            r5 = r3
            r3 = r12
            goto L_0x00b4
        L_0x0111:
            org.tukaani.xz.lz.Matches r0 = r13.matches
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.tukaani.xz.lz.HC4.getMatches():org.tukaani.xz.lz.Matches");
    }

    public void putArraysToCache(ArrayCache arrayCache) {
        arrayCache.putArray(this.chain);
        this.hash.h(arrayCache);
        super.putArraysToCache(arrayCache);
    }

    public void skip(int i11) {
        while (true) {
            int i12 = i11 - 1;
            if (i11 > 0) {
                if (movePos() != 0) {
                    this.hash.a(this.f63434c, this.f63436e);
                    this.chain[this.cyclicPos] = this.hash.d();
                    this.hash.i(this.lzPos);
                }
                i11 = i12;
            } else {
                return;
            }
        }
    }
}
