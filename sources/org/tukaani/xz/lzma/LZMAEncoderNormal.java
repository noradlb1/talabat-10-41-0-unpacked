package org.tukaani.xz.lzma;

import org.apache.commons.compress.archivers.zip.UnixStat;
import org.tukaani.xz.ArrayCache;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.lz.LZEncoder;
import org.tukaani.xz.lz.Matches;
import org.tukaani.xz.rangecoder.RangeEncoder;

final class LZMAEncoderNormal extends LZMAEncoder {
    private static final int EXTRA_SIZE_AFTER = 4096;
    private static final int EXTRA_SIZE_BEFORE = 4096;
    private static final int OPTS = 4096;
    private Matches matches;
    private final State nextState;
    private int optCur;
    private int optEnd;
    private final Optimum[] opts = new Optimum[4096];
    private final int[] repLens;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LZMAEncoderNormal(RangeEncoder rangeEncoder, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, ArrayCache arrayCache) {
        super(rangeEncoder, LZEncoder.getInstance(i14, Math.max(i15, 4096), 4096, i16, LZMA2Options.NICE_LEN_MAX, i17, i18, arrayCache), i11, i12, i13, i14, i16);
        this.optCur = 0;
        this.optEnd = 0;
        this.repLens = new int[4];
        this.nextState = new State();
        for (int i19 = 0; i19 < 4096; i19++) {
            this.opts[i19] = new Optimum();
        }
    }

    private void calc1BytePrices(int i11, int i12, int i13, int i14) {
        boolean z11;
        int matchLen;
        int i15 = this.f63463m.getByte(0);
        int i16 = this.f63463m.getByte(this.opts[this.optCur].f63475b[0] + 1);
        int d11 = this.opts[this.optCur].f63476c + this.f63464n.d(i15, i16, this.f63463m.getByte(1), i11, this.opts[this.optCur].f63474a);
        Optimum[] optimumArr = this.opts;
        int i17 = this.optCur;
        if (d11 < optimumArr[i17 + 1].f63476c) {
            optimumArr[i17 + 1].b(d11, i17, -1);
            z11 = true;
        } else {
            z11 = false;
        }
        if (i16 == i15) {
            Optimum[] optimumArr2 = this.opts;
            int i18 = this.optCur;
            if (optimumArr2[i18 + 1].f63477d == i18 || optimumArr2[i18 + 1].f63478e != 0) {
                int k11 = k(i14, optimumArr2[i18].f63474a, i12);
                Optimum[] optimumArr3 = this.opts;
                int i19 = this.optCur;
                if (k11 <= optimumArr3[i19 + 1].f63476c) {
                    optimumArr3[i19 + 1].b(k11, i19, 0);
                    z11 = true;
                }
            }
        }
        if (!z11 && i16 != i15 && i13 > 2 && (matchLen = this.f63463m.getMatchLen(1, this.opts[this.optCur].f63475b[0], Math.min(this.f63467q, i13 - 1))) >= 2) {
            this.nextState.d(this.opts[this.optCur].f63474a);
            this.nextState.e();
            int e11 = d11 + e(0, matchLen, this.nextState, (i11 + 1) & this.f63437a);
            int i21 = this.optCur + 1 + matchLen;
            while (true) {
                int i22 = this.optEnd;
                if (i22 >= i21) {
                    break;
                }
                Optimum[] optimumArr4 = this.opts;
                int i23 = i22 + 1;
                this.optEnd = i23;
                optimumArr4[i23].a();
            }
            Optimum optimum = this.opts[i21];
            if (e11 < optimum.f63476c) {
                optimum.c(e11, this.optCur, 0);
            }
        }
    }

    private int calcLongRepPrices(int i11, int i12, int i13, int i14) {
        int i15;
        int i16 = i12;
        int i17 = i13;
        int min = Math.min(i17, this.f63467q);
        int i18 = 2;
        for (int i19 = 0; i19 < 4; i19++) {
            int matchLen = this.f63463m.getMatchLen(this.opts[this.optCur].f63475b[i19], min);
            if (matchLen < 2) {
                int i21 = i14;
            } else {
                while (true) {
                    int i22 = this.optEnd;
                    i15 = this.optCur;
                    if (i22 >= i15 + matchLen) {
                        break;
                    }
                    Optimum[] optimumArr = this.opts;
                    int i23 = i22 + 1;
                    this.optEnd = i23;
                    optimumArr[i23].a();
                }
                int f11 = f(i14, i19, this.opts[i15].f63474a, i16);
                for (int i24 = matchLen; i24 >= 2; i24--) {
                    int c11 = this.f63466p.c(i24, i16) + f11;
                    Optimum[] optimumArr2 = this.opts;
                    int i25 = this.optCur;
                    if (c11 < optimumArr2[i25 + i24].f63476c) {
                        optimumArr2[i25 + i24].b(c11, i25, i19);
                    }
                }
                if (i19 == 0) {
                    i18 = matchLen + 1;
                }
                int i26 = i18;
                int matchLen2 = this.f63463m.getMatchLen(matchLen + 1, this.opts[this.optCur].f63475b[i19], Math.min(this.f63467q, (i17 - matchLen) - 1));
                if (matchLen2 >= 2) {
                    int c12 = f11 + this.f63466p.c(matchLen, i16);
                    this.nextState.d(this.opts[this.optCur].f63474a);
                    this.nextState.f();
                    int i27 = i11 + matchLen;
                    int d11 = c12 + this.f63464n.d(this.f63463m.getByte(matchLen, 0), this.f63463m.getByte(0), this.f63463m.getByte(matchLen, 1), i27, this.nextState);
                    this.nextState.e();
                    int e11 = d11 + e(0, matchLen2, this.nextState, (i27 + 1) & this.f63437a);
                    int i28 = this.optCur + matchLen + 1 + matchLen2;
                    while (true) {
                        int i29 = this.optEnd;
                        if (i29 >= i28) {
                            break;
                        }
                        Optimum[] optimumArr3 = this.opts;
                        int i31 = i29 + 1;
                        this.optEnd = i31;
                        optimumArr3[i31].a();
                    }
                    Optimum optimum = this.opts[i28];
                    if (e11 < optimum.f63476c) {
                        optimum.d(e11, this.optCur, i19, matchLen, 0);
                    }
                }
                i18 = i26;
            }
        }
        return i18;
    }

    private void calcNormalMatchPrices(int i11, int i12, int i13, int i14, int i15) {
        int i16;
        Matches matches2;
        int[] iArr;
        int i17;
        int i18 = i13;
        int i19 = i15;
        Matches matches3 = this.matches;
        if (matches3.len[matches3.count - 1] > i18) {
            matches3.count = 0;
            while (true) {
                matches2 = this.matches;
                iArr = matches2.len;
                i17 = matches2.count;
                if (iArr[i17] >= i18) {
                    break;
                }
                matches2.count = i17 + 1;
            }
            matches2.count = i17 + 1;
            iArr[i17] = i18;
        }
        Matches matches4 = this.matches;
        if (matches4.len[matches4.count - 1] >= i19) {
            while (true) {
                int i21 = this.optEnd;
                i16 = this.optCur;
                Matches matches5 = this.matches;
                if (i21 >= matches5.len[matches5.count - 1] + i16) {
                    break;
                }
                Optimum[] optimumArr = this.opts;
                int i22 = i21 + 1;
                this.optEnd = i22;
                optimumArr[i22].a();
            }
            int j11 = j(i14, this.opts[i16].f63474a);
            int i23 = 0;
            while (i19 > this.matches.len[i23]) {
                i23++;
            }
            while (true) {
                int i24 = this.matches.dist[i23];
                int g11 = g(j11, i24, i19, i12);
                Optimum[] optimumArr2 = this.opts;
                int i25 = this.optCur;
                if (g11 < optimumArr2[i25 + i19].f63476c) {
                    optimumArr2[i25 + i19].b(g11, i25, i24 + 4);
                }
                if (i19 == this.matches.len[i23]) {
                    int matchLen = this.f63463m.getMatchLen(i19 + 1, i24, Math.min(this.f63467q, (i18 - i19) - 1));
                    if (matchLen >= 2) {
                        this.nextState.d(this.opts[this.optCur].f63474a);
                        this.nextState.g();
                        int i26 = i11 + i19;
                        int d11 = g11 + this.f63464n.d(this.f63463m.getByte(i19, 0), this.f63463m.getByte(0), this.f63463m.getByte(i19, 1), i26, this.nextState);
                        this.nextState.e();
                        int e11 = d11 + e(0, matchLen, this.nextState, (i26 + 1) & this.f63437a);
                        int i27 = this.optCur + i19 + 1 + matchLen;
                        while (true) {
                            int i28 = this.optEnd;
                            if (i28 >= i27) {
                                break;
                            }
                            Optimum[] optimumArr3 = this.opts;
                            int i29 = i28 + 1;
                            this.optEnd = i29;
                            optimumArr3[i29].a();
                        }
                        Optimum optimum = this.opts[i27];
                        if (e11 < optimum.f63476c) {
                            optimum.d(e11, this.optCur, i24 + 4, i19, 0);
                        }
                    }
                    i23++;
                    if (i23 == this.matches.count) {
                        return;
                    }
                }
                i19++;
            }
        }
    }

    private int convertOpts() {
        int i11 = this.optCur;
        this.optEnd = i11;
        int i12 = this.opts[i11].f63477d;
        while (true) {
            Optimum[] optimumArr = this.opts;
            int i13 = this.optCur;
            Optimum optimum = optimumArr[i13];
            if (optimum.f63479f) {
                Optimum optimum2 = optimumArr[i12];
                optimum2.f63477d = i13;
                optimum2.f63478e = -1;
                int i14 = i12 - 1;
                this.optCur = i12;
                if (optimum.f63480g) {
                    Optimum optimum3 = optimumArr[i14];
                    optimum3.f63477d = i14 + 1;
                    optimum3.f63478e = optimum.f63482i;
                    this.optCur = i14;
                    i12 = optimum.f63481h;
                } else {
                    i12 = i14;
                }
            }
            Optimum optimum4 = optimumArr[i12];
            int i15 = optimum4.f63477d;
            optimum4.f63477d = this.optCur;
            this.optCur = i12;
            if (i12 <= 0) {
                int i16 = optimumArr[0].f63477d;
                this.optCur = i16;
                this.f63468r = optimumArr[i16].f63478e;
                return i16;
            }
            i12 = i15;
        }
    }

    public static int n(int i11, int i12, int i13) {
        return LZEncoder.getMemoryUsage(i11, Math.max(i12, 4096), 4096, LZMA2Options.NICE_LEN_MAX, i13) + 256;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateOptStateAndReps() {
        /*
            r7 = this;
            org.tukaani.xz.lzma.Optimum[] r0 = r7.opts
            int r1 = r7.optCur
            r1 = r0[r1]
            int r2 = r1.f63477d
            boolean r3 = r1.f63479f
            r4 = 4
            if (r3 == 0) goto L_0x0047
            int r2 = r2 + -1
            boolean r3 = r1.f63480g
            if (r3 == 0) goto L_0x0032
            org.tukaani.xz.lzma.State r3 = r1.f63474a
            int r1 = r1.f63481h
            r0 = r0[r1]
            org.tukaani.xz.lzma.State r0 = r0.f63474a
            r3.d(r0)
            org.tukaani.xz.lzma.Optimum[] r0 = r7.opts
            int r1 = r7.optCur
            r0 = r0[r1]
            int r1 = r0.f63482i
            org.tukaani.xz.lzma.State r0 = r0.f63474a
            if (r1 >= r4) goto L_0x002e
            r0.f()
            goto L_0x003b
        L_0x002e:
            r0.g()
            goto L_0x003b
        L_0x0032:
            org.tukaani.xz.lzma.State r1 = r1.f63474a
            r0 = r0[r2]
            org.tukaani.xz.lzma.State r0 = r0.f63474a
            r1.d(r0)
        L_0x003b:
            org.tukaani.xz.lzma.Optimum[] r0 = r7.opts
            int r1 = r7.optCur
            r0 = r0[r1]
            org.tukaani.xz.lzma.State r0 = r0.f63474a
            r0.e()
            goto L_0x0050
        L_0x0047:
            org.tukaani.xz.lzma.State r1 = r1.f63474a
            r0 = r0[r2]
            org.tukaani.xz.lzma.State r0 = r0.f63474a
            r1.d(r0)
        L_0x0050:
            int r0 = r7.optCur
            int r1 = r0 + -1
            r3 = 0
            if (r2 != r1) goto L_0x0078
            org.tukaani.xz.lzma.Optimum[] r1 = r7.opts
            r0 = r1[r0]
            int r1 = r0.f63478e
            org.tukaani.xz.lzma.State r0 = r0.f63474a
            if (r1 != 0) goto L_0x0065
            r0.h()
            goto L_0x0068
        L_0x0065:
            r0.e()
        L_0x0068:
            org.tukaani.xz.lzma.Optimum[] r0 = r7.opts
            r1 = r0[r2]
            int[] r1 = r1.f63475b
            int r2 = r7.optCur
            r0 = r0[r2]
            int[] r0 = r0.f63475b
            java.lang.System.arraycopy(r1, r3, r0, r3, r4)
            goto L_0x00e6
        L_0x0078:
            org.tukaani.xz.lzma.Optimum[] r1 = r7.opts
            r0 = r1[r0]
            boolean r1 = r0.f63479f
            if (r1 == 0) goto L_0x008e
            boolean r1 = r0.f63480g
            if (r1 == 0) goto L_0x008e
            int r2 = r0.f63481h
            int r1 = r0.f63482i
            org.tukaani.xz.lzma.State r0 = r0.f63474a
        L_0x008a:
            r0.f()
            goto L_0x0098
        L_0x008e:
            int r1 = r0.f63478e
            org.tukaani.xz.lzma.State r0 = r0.f63474a
            if (r1 >= r4) goto L_0x0095
            goto L_0x008a
        L_0x0095:
            r0.g()
        L_0x0098:
            r0 = 1
            org.tukaani.xz.lzma.Optimum[] r5 = r7.opts
            int r6 = r7.optCur
            if (r1 >= r4) goto L_0x00d7
            r6 = r5[r6]
            int[] r6 = r6.f63475b
            r5 = r5[r2]
            int[] r5 = r5.f63475b
            r5 = r5[r1]
            r6[r3] = r5
        L_0x00ab:
            if (r0 > r1) goto L_0x00c2
            org.tukaani.xz.lzma.Optimum[] r3 = r7.opts
            int r5 = r7.optCur
            r5 = r3[r5]
            int[] r5 = r5.f63475b
            r3 = r3[r2]
            int[] r3 = r3.f63475b
            int r6 = r0 + -1
            r3 = r3[r6]
            r5[r0] = r3
            int r0 = r0 + 1
            goto L_0x00ab
        L_0x00c2:
            if (r0 >= r4) goto L_0x00e6
            org.tukaani.xz.lzma.Optimum[] r1 = r7.opts
            int r3 = r7.optCur
            r3 = r1[r3]
            int[] r3 = r3.f63475b
            r1 = r1[r2]
            int[] r1 = r1.f63475b
            r1 = r1[r0]
            r3[r0] = r1
            int r0 = r0 + 1
            goto L_0x00c2
        L_0x00d7:
            r6 = r5[r6]
            int[] r6 = r6.f63475b
            int r1 = r1 - r4
            r6[r3] = r1
            r1 = r5[r2]
            int[] r1 = r1.f63475b
            r2 = 3
            java.lang.System.arraycopy(r1, r3, r6, r0, r2)
        L_0x00e6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.tukaani.xz.lzma.LZMAEncoderNormal.updateOptStateAndReps():void");
    }

    public int i() {
        int i11;
        int i12 = this.optCur;
        if (i12 < this.optEnd) {
            Optimum[] optimumArr = this.opts;
            int i13 = optimumArr[i12].f63477d;
            int i14 = i13 - i12;
            this.optCur = i13;
            this.f63468r = optimumArr[i13].f63478e;
            return i14;
        }
        this.optCur = 0;
        this.optEnd = 0;
        this.f63468r = -1;
        if (this.f63470s == -1) {
            this.matches = h();
        }
        int min = Math.min(this.f63463m.getAvail(), LZMA2Options.NICE_LEN_MAX);
        if (min < 2) {
            return 1;
        }
        int i15 = 0;
        for (int i16 = 0; i16 < 4; i16++) {
            this.repLens[i16] = this.f63463m.getMatchLen(this.f63438b[i16], min);
            int[] iArr = this.repLens;
            int i17 = iArr[i16];
            if (i17 < 2) {
                iArr[i16] = 0;
            } else if (i17 > iArr[i15]) {
                i15 = i16;
            }
        }
        int i18 = this.repLens[i15];
        int i19 = this.f63467q;
        if (i18 >= i19) {
            this.f63468r = i15;
            l(i18 - 1);
            return this.repLens[i15];
        }
        Matches matches2 = this.matches;
        int i21 = matches2.count;
        if (i21 > 0) {
            i11 = matches2.len[i21 - 1];
            int i22 = matches2.dist[i21 - 1];
            if (i11 >= i19) {
                this.f63468r = i22 + 4;
                l(i11 - 1);
                return i11;
            }
        } else {
            i11 = 0;
        }
        int i23 = this.f63463m.getByte(0);
        int i24 = this.f63463m.getByte(this.f63438b[0] + 1);
        if (i11 < 2 && i23 != i24 && this.repLens[i15] < 2) {
            return 1;
        }
        int pos = this.f63463m.getPos();
        int i25 = pos & this.f63437a;
        int i26 = i25;
        this.opts[1].b(this.f63464n.d(i23, i24, this.f63463m.getByte(1), pos, this.f63439c), 0, -1);
        int c11 = c(this.f63439c, i26);
        int d11 = d(c11, this.f63439c);
        if (i24 == i23) {
            int k11 = k(d11, this.f63439c, i26);
            Optimum optimum = this.opts[1];
            if (k11 < optimum.f63476c) {
                optimum.b(k11, 0, 0);
            }
        }
        int max = Math.max(i11, this.repLens[i15]);
        this.optEnd = max;
        if (max < 2) {
            this.f63468r = this.opts[1].f63478e;
            return 1;
        }
        m();
        this.opts[0].f63474a.d(this.f63439c);
        System.arraycopy(this.f63438b, 0, this.opts[0].f63475b, 0, 4);
        for (int i27 = this.optEnd; i27 >= 2; i27--) {
            this.opts[i27].a();
        }
        int i28 = 0;
        for (int i29 = 4; i28 < i29; i29 = 4) {
            int i31 = this.repLens[i28];
            if (i31 >= 2) {
                int f11 = f(d11, i28, this.f63439c, i26);
                while (true) {
                    int c12 = this.f63466p.c(i31, i26) + f11;
                    Optimum optimum2 = this.opts[i31];
                    if (c12 < optimum2.f63476c) {
                        optimum2.b(c12, 0, i28);
                    }
                    i31--;
                    if (i31 < 2) {
                        break;
                    }
                }
            }
            i28++;
        }
        int max2 = Math.max(this.repLens[0] + 1, 2);
        if (max2 <= i11) {
            int j11 = j(c11, this.f63439c);
            int i32 = 0;
            while (max2 > this.matches.len[i32]) {
                i32++;
            }
            while (true) {
                int i33 = this.matches.dist[i32];
                int g11 = g(j11, i33, max2, i26);
                Optimum optimum3 = this.opts[max2];
                if (g11 < optimum3.f63476c) {
                    optimum3.b(g11, 0, i33 + 4);
                }
                Matches matches3 = this.matches;
                if (max2 == matches3.len[i32] && (i32 = i32 + 1) == matches3.count) {
                    break;
                }
                max2++;
            }
        }
        int min2 = Math.min(this.f63463m.getAvail(), UnixStat.PERM_MASK);
        while (true) {
            int i34 = this.optCur + 1;
            this.optCur = i34;
            if (i34 >= this.optEnd) {
                break;
            }
            Matches h11 = h();
            this.matches = h11;
            int i35 = h11.count;
            if (i35 > 0 && h11.len[i35 - 1] >= this.f63467q) {
                break;
            }
            int i36 = min2 - 1;
            int i37 = pos + 1;
            int i38 = i37 & this.f63437a;
            updateOptStateAndReps();
            Optimum optimum4 = this.opts[this.optCur];
            int c13 = optimum4.f63476c + c(optimum4.f63474a, i38);
            int d12 = d(c13, this.opts[this.optCur].f63474a);
            calc1BytePrices(i37, i38, i36, d12);
            if (i36 >= 2) {
                int calcLongRepPrices = calcLongRepPrices(i37, i38, i36, d12);
                if (this.matches.count > 0) {
                    calcNormalMatchPrices(i37, i38, i36, c13, calcLongRepPrices);
                }
            }
            min2 = i36;
            pos = i37;
        }
        return convertOpts();
    }

    public void reset() {
        this.optCur = 0;
        this.optEnd = 0;
        super.reset();
    }
}
