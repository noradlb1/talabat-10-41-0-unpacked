package org.tukaani.xz.lzma;

import org.tukaani.xz.ArrayCache;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.lz.LZEncoder;
import org.tukaani.xz.lz.Matches;
import org.tukaani.xz.rangecoder.RangeEncoder;

final class LZMAEncoderFast extends LZMAEncoder {
    private static final int EXTRA_SIZE_AFTER = 272;
    private static final int EXTRA_SIZE_BEFORE = 1;
    private Matches matches = null;

    public LZMAEncoderFast(RangeEncoder rangeEncoder, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, ArrayCache arrayCache) {
        super(rangeEncoder, LZEncoder.getInstance(i14, Math.max(i15, 1), EXTRA_SIZE_AFTER, i16, LZMA2Options.NICE_LEN_MAX, i17, i18, arrayCache), i11, i12, i13, i14, i16);
    }

    private boolean changePair(int i11, int i12) {
        return i11 < (i12 >>> 7);
    }

    public static int n(int i11, int i12, int i13) {
        return LZEncoder.getMemoryUsage(i11, Math.max(i12, 1), EXTRA_SIZE_AFTER, LZMA2Options.NICE_LEN_MAX, i13);
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int i() {
        /*
            r13 = this;
            int r0 = r13.f63470s
            r1 = -1
            if (r0 != r1) goto L_0x000b
            org.tukaani.xz.lz.Matches r0 = r13.h()
            r13.matches = r0
        L_0x000b:
            r13.f63468r = r1
            org.tukaani.xz.lz.LZEncoder r0 = r13.f63463m
            int r0 = r0.getAvail()
            r1 = 273(0x111, float:3.83E-43)
            int r0 = java.lang.Math.min(r0, r1)
            r1 = 2
            r2 = 1
            if (r0 >= r1) goto L_0x001e
            return r2
        L_0x001e:
            r3 = 0
            r4 = r3
            r5 = r4
            r6 = r5
        L_0x0022:
            r7 = 4
            if (r4 >= r7) goto L_0x0045
            org.tukaani.xz.lz.LZEncoder r7 = r13.f63463m
            int[] r8 = r13.f63438b
            r8 = r8[r4]
            int r7 = r7.getMatchLen(r8, r0)
            if (r7 >= r1) goto L_0x0032
            goto L_0x0042
        L_0x0032:
            int r8 = r13.f63467q
            if (r7 < r8) goto L_0x003e
            r13.f63468r = r4
            int r0 = r7 + -1
            r13.l(r0)
            return r7
        L_0x003e:
            if (r7 <= r5) goto L_0x0042
            r6 = r4
            r5 = r7
        L_0x0042:
            int r4 = r4 + 1
            goto L_0x0022
        L_0x0045:
            org.tukaani.xz.lz.Matches r4 = r13.matches
            int r8 = r4.count
            if (r8 <= 0) goto L_0x009a
            int[] r9 = r4.len
            int r10 = r8 + -1
            r9 = r9[r10]
            int[] r4 = r4.dist
            int r8 = r8 - r2
            r4 = r4[r8]
            int r8 = r13.f63467q
            if (r9 < r8) goto L_0x0063
            int r4 = r4 + r7
            r13.f63468r = r4
            int r0 = r9 + -1
        L_0x005f:
            r13.l(r0)
            return r9
        L_0x0063:
            org.tukaani.xz.lz.Matches r8 = r13.matches
            int r10 = r8.count
            if (r10 <= r2) goto L_0x0092
            int[] r11 = r8.len
            int r12 = r10 + -2
            r11 = r11[r12]
            int r11 = r11 + r2
            if (r9 != r11) goto L_0x0092
            int[] r8 = r8.dist
            int r10 = r10 + -2
            r8 = r8[r10]
            boolean r8 = r13.changePair(r8, r4)
            if (r8 != 0) goto L_0x007f
            goto L_0x0092
        L_0x007f:
            org.tukaani.xz.lz.Matches r4 = r13.matches
            int r8 = r4.count
            int r8 = r8 - r2
            r4.count = r8
            int[] r9 = r4.len
            int r10 = r8 + -1
            r9 = r9[r10]
            int[] r4 = r4.dist
            int r8 = r8 - r2
            r4 = r4[r8]
            goto L_0x0063
        L_0x0092:
            if (r9 != r1) goto L_0x009c
            r8 = 128(0x80, float:1.794E-43)
            if (r4 < r8) goto L_0x009c
            r9 = r2
            goto L_0x009c
        L_0x009a:
            r4 = r3
            r9 = r4
        L_0x009c:
            if (r5 < r1) goto L_0x00bb
            int r8 = r5 + 1
            if (r8 >= r9) goto L_0x00b3
            int r8 = r5 + 2
            if (r8 < r9) goto L_0x00aa
            r8 = 512(0x200, float:7.175E-43)
            if (r4 >= r8) goto L_0x00b3
        L_0x00aa:
            int r8 = r5 + 3
            if (r8 < r9) goto L_0x00bb
            r8 = 32768(0x8000, float:4.5918E-41)
            if (r4 < r8) goto L_0x00bb
        L_0x00b3:
            r13.f63468r = r6
            int r0 = r5 + -1
            r13.l(r0)
            return r5
        L_0x00bb:
            if (r9 < r1) goto L_0x0111
            if (r0 > r1) goto L_0x00c0
            goto L_0x0111
        L_0x00c0:
            org.tukaani.xz.lz.Matches r0 = r13.h()
            r13.matches = r0
            int r5 = r0.count
            if (r5 <= 0) goto L_0x00f2
            int[] r6 = r0.len
            int r8 = r5 + -1
            r6 = r6[r8]
            int[] r0 = r0.dist
            int r5 = r5 - r2
            r0 = r0[r5]
            if (r6 < r9) goto L_0x00d9
            if (r0 < r4) goto L_0x00f1
        L_0x00d9:
            int r5 = r9 + 1
            if (r6 != r5) goto L_0x00e3
            boolean r8 = r13.changePair(r4, r0)
            if (r8 == 0) goto L_0x00f1
        L_0x00e3:
            if (r6 > r5) goto L_0x00f1
            int r6 = r6 + r2
            if (r6 < r9) goto L_0x00f2
            r5 = 3
            if (r9 < r5) goto L_0x00f2
            boolean r0 = r13.changePair(r0, r4)
            if (r0 == 0) goto L_0x00f2
        L_0x00f1:
            return r2
        L_0x00f2:
            int r0 = r9 + -1
            int r0 = java.lang.Math.max(r0, r1)
        L_0x00f8:
            if (r3 >= r7) goto L_0x010a
            org.tukaani.xz.lz.LZEncoder r1 = r13.f63463m
            int[] r5 = r13.f63438b
            r5 = r5[r3]
            int r1 = r1.getMatchLen(r5, r0)
            if (r1 != r0) goto L_0x0107
            return r2
        L_0x0107:
            int r3 = r3 + 1
            goto L_0x00f8
        L_0x010a:
            int r4 = r4 + r7
            r13.f63468r = r4
            int r0 = r9 + -2
            goto L_0x005f
        L_0x0111:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.tukaani.xz.lzma.LZMAEncoderFast.i():int");
    }
}
