package org.tukaani.xz.lzma;

import java.io.IOException;
import java.lang.reflect.Array;
import org.tukaani.xz.ArrayCache;
import org.tukaani.xz.lz.LZEncoder;
import org.tukaani.xz.lz.Matches;
import org.tukaani.xz.lzma.LZMACoder;
import org.tukaani.xz.rangecoder.RangeEncoder;

public abstract class LZMAEncoder extends LZMACoder {
    private static final int ALIGN_PRICE_UPDATE_INTERVAL = 16;
    private static final int DIST_PRICE_UPDATE_INTERVAL = 128;
    private static final int LZMA2_COMPRESSED_LIMIT = 65510;
    private static final int LZMA2_UNCOMPRESSED_LIMIT = 2096879;
    public static final int MODE_FAST = 1;
    public static final int MODE_NORMAL = 2;
    private int alignPriceCount = 0;
    private final int[] alignPrices;
    private int distPriceCount = 0;
    private final int[][] distSlotPrices;
    private final int distSlotPricesSize;
    private final int[][] fullDistPrices;

    /* renamed from: m  reason: collision with root package name */
    public final LZEncoder f63463m;

    /* renamed from: n  reason: collision with root package name */
    public final LiteralEncoder f63464n;

    /* renamed from: o  reason: collision with root package name */
    public final LengthEncoder f63465o;

    /* renamed from: p  reason: collision with root package name */
    public final LengthEncoder f63466p;

    /* renamed from: q  reason: collision with root package name */
    public final int f63467q;

    /* renamed from: r  reason: collision with root package name */
    public int f63468r;
    /* access modifiers changed from: private */

    /* renamed from: rc  reason: collision with root package name */
    public final RangeEncoder f63469rc;

    /* renamed from: s  reason: collision with root package name */
    public int f63470s;
    private int uncompressedSize;

    public class LengthEncoder extends LZMACoder.LengthCoder {
        private static final int PRICE_UPDATE_INTERVAL = 32;
        private final int[] counters;
        private final int[][] prices;

        public LengthEncoder(int i11, int i12) {
            super();
            int i13 = 1 << i11;
            this.counters = new int[i13];
            int[] iArr = new int[2];
            iArr[1] = Math.max((i12 - 2) + 1, 16);
            iArr[0] = i13;
            this.prices = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        }

        private void updatePrices(int i11) {
            int bitPrice = RangeEncoder.getBitPrice(this.f63449a[0], 0);
            int i12 = 0;
            while (i12 < 8) {
                this.prices[i11][i12] = RangeEncoder.getBitTreePrice(this.f63450b[i11], i12) + bitPrice;
                i12++;
            }
            int bitPrice2 = RangeEncoder.getBitPrice(this.f63449a[0], 1);
            int bitPrice3 = RangeEncoder.getBitPrice(this.f63449a[1], 0);
            while (i12 < 16) {
                this.prices[i11][i12] = bitPrice2 + bitPrice3 + RangeEncoder.getBitTreePrice(this.f63451c[i11], i12 - 8);
                i12++;
            }
            int bitPrice4 = RangeEncoder.getBitPrice(this.f63449a[1], 1);
            while (true) {
                int[] iArr = this.prices[i11];
                if (i12 < iArr.length) {
                    iArr[i12] = bitPrice2 + bitPrice4 + RangeEncoder.getBitTreePrice(this.f63452d, (i12 - 8) - 8);
                    i12++;
                } else {
                    return;
                }
            }
        }

        public void a() {
            super.a();
            int i11 = 0;
            while (true) {
                int[] iArr = this.counters;
                if (i11 < iArr.length) {
                    iArr[i11] = 0;
                    i11++;
                } else {
                    return;
                }
            }
        }

        public void b(int i11, int i12) throws IOException {
            int i13 = i11 - 2;
            if (i13 < 8) {
                LZMAEncoder.this.f63469rc.encodeBit(this.f63449a, 0, 0);
                LZMAEncoder.this.f63469rc.encodeBitTree(this.f63450b[i12], i13);
            } else {
                LZMAEncoder.this.f63469rc.encodeBit(this.f63449a, 0, 1);
                int i14 = i13 - 8;
                if (i14 < 8) {
                    LZMAEncoder.this.f63469rc.encodeBit(this.f63449a, 1, 0);
                    LZMAEncoder.this.f63469rc.encodeBitTree(this.f63451c[i12], i14);
                } else {
                    LZMAEncoder.this.f63469rc.encodeBit(this.f63449a, 1, 1);
                    LZMAEncoder.this.f63469rc.encodeBitTree(this.f63452d, i14 - 8);
                }
            }
            int[] iArr = this.counters;
            iArr[i12] = iArr[i12] - 1;
        }

        public int c(int i11, int i12) {
            return this.prices[i12][i11 - 2];
        }

        public void d() {
            int i11 = 0;
            while (true) {
                int[] iArr = this.counters;
                if (i11 < iArr.length) {
                    if (iArr[i11] <= 0) {
                        iArr[i11] = 32;
                        updatePrices(i11);
                    }
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    public class LiteralEncoder extends LZMACoder.LiteralCoder {
        private final LiteralSubencoder[] subencoders;

        public class LiteralSubencoder extends LZMACoder.LiteralCoder.LiteralSubcoder {
            private LiteralSubencoder() {
                super();
            }

            public void b() throws IOException {
                LZMAEncoder lZMAEncoder = LZMAEncoder.this;
                int i11 = 256;
                int i12 = lZMAEncoder.f63463m.getByte(lZMAEncoder.f63470s) | 256;
                if (LZMAEncoder.this.f63439c.b()) {
                    do {
                        LZMAEncoder.this.f63469rc.encodeBit(this.f63456a, i12 >>> 8, (i12 >>> 7) & 1);
                        i12 <<= 1;
                    } while (i12 < 65536);
                } else {
                    LZMAEncoder lZMAEncoder2 = LZMAEncoder.this;
                    int i13 = lZMAEncoder2.f63463m.getByte(lZMAEncoder2.f63438b[0] + 1 + lZMAEncoder2.f63470s);
                    do {
                        i13 <<= 1;
                        LZMAEncoder.this.f63469rc.encodeBit(this.f63456a, (i13 & i11) + i11 + (i12 >>> 8), (i12 >>> 7) & 1);
                        i12 <<= 1;
                        i11 &= ~(i13 ^ i12);
                    } while (i12 < 65536);
                }
                LZMAEncoder.this.f63439c.e();
            }

            public int c(int i11, int i12) {
                int i13 = 256;
                int i14 = i11 | 256;
                int i15 = 0;
                do {
                    i12 <<= 1;
                    i15 += RangeEncoder.getBitPrice(this.f63456a[(i12 & i13) + i13 + (i14 >>> 8)], (i14 >>> 7) & 1);
                    i14 <<= 1;
                    i13 &= ~(i12 ^ i14);
                } while (i14 < 65536);
                return i15;
            }

            public int d(int i11) {
                int i12 = i11 | 256;
                int i13 = 0;
                do {
                    i13 += RangeEncoder.getBitPrice(this.f63456a[i12 >>> 8], (i12 >>> 7) & 1);
                    i12 <<= 1;
                } while (i12 < 65536);
                return i13;
            }
        }

        public LiteralEncoder(int i11, int i12) {
            super(i11, i12);
            this.subencoders = new LiteralSubencoder[(1 << (i11 + i12))];
            int i13 = 0;
            while (true) {
                LiteralSubencoder[] literalSubencoderArr = this.subencoders;
                if (i13 < literalSubencoderArr.length) {
                    literalSubencoderArr[i13] = new LiteralSubencoder();
                    i13++;
                } else {
                    return;
                }
            }
        }

        public void b() throws IOException {
            LZMAEncoder lZMAEncoder = LZMAEncoder.this;
            this.subencoders[a(lZMAEncoder.f63463m.getByte(lZMAEncoder.f63470s + 1), LZMAEncoder.this.f63463m.getPos() - LZMAEncoder.this.f63470s)].b();
        }

        public void c() throws IOException {
            this.subencoders[0].b();
        }

        public int d(int i11, int i12, int i13, int i14, State state) {
            int bitPrice = RangeEncoder.getBitPrice(LZMAEncoder.this.f63440d[state.a()][LZMAEncoder.this.f63437a & i14], 0);
            int a11 = a(i13, i14);
            return bitPrice + (state.b() ? this.subencoders[a11].d(i11) : this.subencoders[a11].c(i11, i12));
        }

        public void e() {
            int i11 = 0;
            while (true) {
                LiteralSubencoder[] literalSubencoderArr = this.subencoders;
                if (i11 < literalSubencoderArr.length) {
                    literalSubencoderArr[i11].a();
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    public LZMAEncoder(RangeEncoder rangeEncoder, LZEncoder lZEncoder, int i11, int i12, int i13, int i14, int i15) {
        super(i13);
        Class cls = Integer.TYPE;
        this.fullDistPrices = (int[][]) Array.newInstance(cls, new int[]{4, 128});
        this.alignPrices = new int[16];
        this.f63468r = 0;
        this.f63470s = -1;
        this.uncompressedSize = 0;
        this.f63469rc = rangeEncoder;
        this.f63463m = lZEncoder;
        this.f63467q = i15;
        this.f63464n = new LiteralEncoder(i11, i12);
        this.f63465o = new LengthEncoder(i13, i15);
        this.f63466p = new LengthEncoder(i13, i15);
        int distSlot = getDistSlot(i14 - 1) + 1;
        this.distSlotPricesSize = distSlot;
        int[] iArr = new int[2];
        iArr[1] = distSlot;
        iArr[0] = 4;
        this.distSlotPrices = (int[][]) Array.newInstance(cls, iArr);
        reset();
    }

    private boolean encodeInit() throws IOException {
        if (!this.f63463m.hasEnoughData(0)) {
            return false;
        }
        l(1);
        this.f63469rc.encodeBit(this.f63440d[this.f63439c.a()], 0, 0);
        this.f63464n.c();
        this.f63470s--;
        this.uncompressedSize++;
        return true;
    }

    private void encodeMatch(int i11, int i12, int i13) throws IOException {
        this.f63439c.g();
        this.f63465o.b(i12, i13);
        int distSlot = getDistSlot(i11);
        this.f63469rc.encodeBitTree(this.f63446j[LZMACoder.a(i12)], distSlot);
        if (distSlot >= 4) {
            int i14 = (distSlot >>> 1) - 1;
            int i15 = i11 - (((distSlot & 1) | 2) << i14);
            if (distSlot < 14) {
                this.f63469rc.encodeReverseBitTree(this.f63447k[distSlot - 4], i15);
            } else {
                this.f63469rc.encodeDirectBits(i15 >>> 4, i14 - 4);
                this.f63469rc.encodeReverseBitTree(this.f63448l, i15 & 15);
                this.alignPriceCount--;
            }
        }
        int[] iArr = this.f63438b;
        iArr[3] = iArr[2];
        iArr[2] = iArr[1];
        iArr[1] = iArr[0];
        iArr[0] = i11;
        this.distPriceCount--;
    }

    private void encodeRepMatch(int i11, int i12, int i13) throws IOException {
        int i14 = 0;
        if (i11 == 0) {
            this.f63469rc.encodeBit(this.f63442f, this.f63439c.a(), 0);
            RangeEncoder rangeEncoder = this.f63469rc;
            short[] sArr = this.f63445i[this.f63439c.a()];
            if (i12 != 1) {
                i14 = 1;
            }
            rangeEncoder.encodeBit(sArr, i13, i14);
        } else {
            int i15 = this.f63438b[i11];
            this.f63469rc.encodeBit(this.f63442f, this.f63439c.a(), 1);
            if (i11 == 1) {
                this.f63469rc.encodeBit(this.f63443g, this.f63439c.a(), 0);
            } else {
                this.f63469rc.encodeBit(this.f63443g, this.f63439c.a(), 1);
                this.f63469rc.encodeBit(this.f63444h, this.f63439c.a(), i11 - 2);
                if (i11 == 3) {
                    int[] iArr = this.f63438b;
                    iArr[3] = iArr[2];
                }
                int[] iArr2 = this.f63438b;
                iArr2[2] = iArr2[1];
            }
            int[] iArr3 = this.f63438b;
            iArr3[1] = iArr3[0];
            iArr3[0] = i15;
        }
        if (i12 == 1) {
            this.f63439c.h();
            return;
        }
        this.f63466p.b(i12, i13);
        this.f63439c.f();
    }

    private boolean encodeSymbol() throws IOException {
        if (!this.f63463m.hasEnoughData(this.f63470s + 1)) {
            return false;
        }
        int i11 = i();
        int pos = (this.f63463m.getPos() - this.f63470s) & this.f63437a;
        if (this.f63468r == -1) {
            this.f63469rc.encodeBit(this.f63440d[this.f63439c.a()], pos, 0);
            this.f63464n.b();
        } else {
            this.f63469rc.encodeBit(this.f63440d[this.f63439c.a()], pos, 1);
            if (this.f63468r < 4) {
                this.f63469rc.encodeBit(this.f63441e, this.f63439c.a(), 1);
                encodeRepMatch(this.f63468r, i11, pos);
            } else {
                this.f63469rc.encodeBit(this.f63441e, this.f63439c.a(), 0);
                encodeMatch(this.f63468r - 4, i11, pos);
            }
        }
        this.f63470s -= i11;
        this.uncompressedSize += i11;
        return true;
    }

    public static int getDistSlot(int i11) {
        int i12;
        int i13;
        if (i11 <= 4 && i11 >= 0) {
            return i11;
        }
        if ((-65536 & i11) == 0) {
            i13 = i11 << 16;
            i12 = 15;
        } else {
            i12 = 31;
            i13 = i11;
        }
        if ((-16777216 & i13) == 0) {
            i13 <<= 8;
            i12 -= 8;
        }
        if ((-268435456 & i13) == 0) {
            i13 <<= 4;
            i12 -= 4;
        }
        if ((-1073741824 & i13) == 0) {
            i13 <<= 2;
            i12 -= 2;
        }
        if ((i13 & Integer.MIN_VALUE) == 0) {
            i12--;
        }
        return (i12 << 1) + ((i11 >>> (i12 - 1)) & 1);
    }

    public static LZMAEncoder getInstance(RangeEncoder rangeEncoder, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, ArrayCache arrayCache) {
        int i21 = i14;
        if (i21 == 1) {
            return new LZMAEncoderFast(rangeEncoder, i11, i12, i13, i15, i16, i17, i18, i19, arrayCache);
        }
        if (i21 == 2) {
            return new LZMAEncoderNormal(rangeEncoder, i11, i12, i13, i15, i16, i17, i18, i19, arrayCache);
        }
        throw new IllegalArgumentException();
    }

    public static int getMemoryUsage(int i11, int i12, int i13, int i14) {
        int i15;
        if (i11 == 1) {
            i15 = LZMAEncoderFast.n(i12, i13, i14);
        } else if (i11 == 2) {
            i15 = LZMAEncoderNormal.n(i12, i13, i14);
        } else {
            throw new IllegalArgumentException();
        }
        return i15 + 80;
    }

    private void updateAlignPrices() {
        this.alignPriceCount = 16;
        for (int i11 = 0; i11 < 16; i11++) {
            this.alignPrices[i11] = RangeEncoder.getReverseBitTreePrice(this.f63448l, i11);
        }
    }

    private void updateDistPrices() {
        this.distPriceCount = 128;
        int i11 = 0;
        while (true) {
            if (i11 >= 4) {
                break;
            }
            for (int i12 = 0; i12 < this.distSlotPricesSize; i12++) {
                this.distSlotPrices[i11][i12] = RangeEncoder.getBitTreePrice(this.f63446j[i11], i12);
            }
            for (int i13 = 14; i13 < this.distSlotPricesSize; i13++) {
                int[] iArr = this.distSlotPrices[i11];
                iArr[i13] = iArr[i13] + RangeEncoder.getDirectBitsPrice(((i13 >>> 1) - 1) - 4);
            }
            for (int i14 = 0; i14 < 4; i14++) {
                this.fullDistPrices[i11][i14] = this.distSlotPrices[i11][i14];
            }
            i11++;
        }
        int i15 = 4;
        for (int i16 = 4; i16 < 14; i16++) {
            int i17 = ((i16 & 1) | 2) << ((i16 >>> 1) - 1);
            int i18 = i16 - 4;
            int length = this.f63447k[i18].length;
            for (int i19 = 0; i19 < length; i19++) {
                int reverseBitTreePrice = RangeEncoder.getReverseBitTreePrice(this.f63447k[i18], i15 - i17);
                for (int i21 = 0; i21 < 4; i21++) {
                    this.fullDistPrices[i21][i15] = this.distSlotPrices[i21][i16] + reverseBitTreePrice;
                }
                i15++;
            }
        }
    }

    public int c(State state, int i11) {
        return RangeEncoder.getBitPrice(this.f63440d[state.a()][i11], 1);
    }

    public int d(int i11, State state) {
        return i11 + RangeEncoder.getBitPrice(this.f63441e[state.a()], 1);
    }

    public int e(int i11, int i12, State state, int i13) {
        return f(d(c(state, i13), state), i11, state, i13) + this.f63466p.c(i12, i13);
    }

    public void encodeForLZMA1() throws IOException {
        if (this.f63463m.isStarted() || encodeInit()) {
            do {
            } while (encodeSymbol());
        }
    }

    public boolean encodeForLZMA2() {
        try {
            if (!this.f63463m.isStarted() && !encodeInit()) {
                return false;
            }
            while (this.uncompressedSize <= LZMA2_UNCOMPRESSED_LIMIT && this.f63469rc.getPendingSize() <= LZMA2_COMPRESSED_LIMIT) {
                if (!encodeSymbol()) {
                    return false;
                }
            }
            return true;
        } catch (IOException unused) {
            throw new Error();
        }
    }

    public void encodeLZMA1EndMarker() throws IOException {
        int pos = (this.f63463m.getPos() - this.f63470s) & this.f63437a;
        this.f63469rc.encodeBit(this.f63440d[this.f63439c.a()], pos, 1);
        this.f63469rc.encodeBit(this.f63441e, this.f63439c.a(), 0);
        encodeMatch(-1, 2, pos);
    }

    public int f(int i11, int i12, State state, int i13) {
        int bitPrice;
        if (i12 == 0) {
            bitPrice = RangeEncoder.getBitPrice(this.f63442f[state.a()], 0) + RangeEncoder.getBitPrice(this.f63445i[state.a()][i13], 1);
        } else {
            i11 += RangeEncoder.getBitPrice(this.f63442f[state.a()], 1);
            if (i12 != 1) {
                return i11 + RangeEncoder.getBitPrice(this.f63443g[state.a()], 1) + RangeEncoder.getBitPrice(this.f63444h[state.a()], i12 - 2);
            }
            bitPrice = RangeEncoder.getBitPrice(this.f63443g[state.a()], 0);
        }
        return i11 + bitPrice;
    }

    public int g(int i11, int i12, int i13, int i14) {
        int c11 = i11 + this.f63465o.c(i13, i14);
        int a11 = LZMACoder.a(i13);
        if (i12 < 128) {
            return c11 + this.fullDistPrices[a11][i12];
        }
        return c11 + this.distSlotPrices[a11][getDistSlot(i12)] + this.alignPrices[i12 & 15];
    }

    public LZEncoder getLZEncoder() {
        return this.f63463m;
    }

    public int getUncompressedSize() {
        return this.uncompressedSize;
    }

    public Matches h() {
        this.f63470s++;
        return this.f63463m.getMatches();
    }

    public abstract int i();

    public int j(int i11, State state) {
        return i11 + RangeEncoder.getBitPrice(this.f63441e[state.a()], 0);
    }

    public int k(int i11, State state, int i12) {
        return i11 + RangeEncoder.getBitPrice(this.f63442f[state.a()], 0) + RangeEncoder.getBitPrice(this.f63445i[state.a()][i12], 0);
    }

    public void l(int i11) {
        this.f63470s += i11;
        this.f63463m.skip(i11);
    }

    public void m() {
        if (this.distPriceCount <= 0) {
            updateDistPrices();
        }
        if (this.alignPriceCount <= 0) {
            updateAlignPrices();
        }
        this.f63465o.d();
        this.f63466p.d();
    }

    public void putArraysToCache(ArrayCache arrayCache) {
        this.f63463m.putArraysToCache(arrayCache);
    }

    public void reset() {
        super.reset();
        this.f63464n.e();
        this.f63465o.a();
        this.f63466p.a();
        this.distPriceCount = 0;
        this.alignPriceCount = 0;
        this.uncompressedSize += this.f63470s + 1;
        this.f63470s = -1;
    }

    public void resetUncompressedSize() {
        this.uncompressedSize = 0;
    }
}
