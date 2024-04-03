package org.tukaani.xz.lzma;

import com.google.firebase.database.core.ValidationPath;
import java.lang.reflect.Array;
import org.tukaani.xz.rangecoder.RangeCoder;

abstract class LZMACoder {

    /* renamed from: a  reason: collision with root package name */
    public final int f63437a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f63438b = new int[4];

    /* renamed from: c  reason: collision with root package name */
    public final State f63439c = new State();

    /* renamed from: d  reason: collision with root package name */
    public final short[][] f63440d = ((short[][]) Array.newInstance(Short.TYPE, new int[]{12, 16}));

    /* renamed from: e  reason: collision with root package name */
    public final short[] f63441e = new short[12];

    /* renamed from: f  reason: collision with root package name */
    public final short[] f63442f = new short[12];

    /* renamed from: g  reason: collision with root package name */
    public final short[] f63443g = new short[12];

    /* renamed from: h  reason: collision with root package name */
    public final short[] f63444h = new short[12];

    /* renamed from: i  reason: collision with root package name */
    public final short[][] f63445i = ((short[][]) Array.newInstance(Short.TYPE, new int[]{12, 16}));

    /* renamed from: j  reason: collision with root package name */
    public final short[][] f63446j = ((short[][]) Array.newInstance(Short.TYPE, new int[]{4, 64}));

    /* renamed from: k  reason: collision with root package name */
    public final short[][] f63447k = {new short[2], new short[2], new short[4], new short[4], new short[8], new short[8], new short[16], new short[16], new short[32], new short[32]};

    /* renamed from: l  reason: collision with root package name */
    public final short[] f63448l = new short[16];

    public abstract class LengthCoder {

        /* renamed from: a  reason: collision with root package name */
        public final short[] f63449a = new short[2];

        /* renamed from: b  reason: collision with root package name */
        public final short[][] f63450b = ((short[][]) Array.newInstance(Short.TYPE, new int[]{16, 8}));

        /* renamed from: c  reason: collision with root package name */
        public final short[][] f63451c = ((short[][]) Array.newInstance(Short.TYPE, new int[]{16, 8}));

        /* renamed from: d  reason: collision with root package name */
        public final short[] f63452d = new short[256];

        public LengthCoder() {
        }

        public void a() {
            RangeCoder.initProbs(this.f63449a);
            int i11 = 0;
            while (true) {
                short[][] sArr = this.f63450b;
                if (i11 >= sArr.length) {
                    break;
                }
                RangeCoder.initProbs(sArr[i11]);
                i11++;
            }
            for (int i12 = 0; i12 < this.f63450b.length; i12++) {
                RangeCoder.initProbs(this.f63451c[i12]);
            }
            RangeCoder.initProbs(this.f63452d);
        }
    }

    public abstract class LiteralCoder {

        /* renamed from: lc  reason: collision with root package name */
        private final int f63455lc;
        private final int literalPosMask;

        public abstract class LiteralSubcoder {

            /* renamed from: a  reason: collision with root package name */
            public final short[] f63456a = new short[ValidationPath.MAX_PATH_LENGTH_BYTES];

            public LiteralSubcoder() {
            }

            public void a() {
                RangeCoder.initProbs(this.f63456a);
            }
        }

        public LiteralCoder(int i11, int i12) {
            this.f63455lc = i11;
            this.literalPosMask = (1 << i12) - 1;
        }

        public final int a(int i11, int i12) {
            int i13 = this.f63455lc;
            return (i11 >> (8 - i13)) + ((i12 & this.literalPosMask) << i13);
        }
    }

    public LZMACoder(int i11) {
        this.f63437a = (1 << i11) - 1;
    }

    public static final int a(int i11) {
        if (i11 < 6) {
            return i11 - 2;
        }
        return 3;
    }

    public void reset() {
        int[] iArr = this.f63438b;
        int i11 = 0;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        this.f63439c.c();
        int i12 = 0;
        while (true) {
            short[][] sArr = this.f63440d;
            if (i12 >= sArr.length) {
                break;
            }
            RangeCoder.initProbs(sArr[i12]);
            i12++;
        }
        RangeCoder.initProbs(this.f63441e);
        RangeCoder.initProbs(this.f63442f);
        RangeCoder.initProbs(this.f63443g);
        RangeCoder.initProbs(this.f63444h);
        int i13 = 0;
        while (true) {
            short[][] sArr2 = this.f63445i;
            if (i13 >= sArr2.length) {
                break;
            }
            RangeCoder.initProbs(sArr2[i13]);
            i13++;
        }
        int i14 = 0;
        while (true) {
            short[][] sArr3 = this.f63446j;
            if (i14 >= sArr3.length) {
                break;
            }
            RangeCoder.initProbs(sArr3[i14]);
            i14++;
        }
        while (true) {
            short[][] sArr4 = this.f63447k;
            if (i11 < sArr4.length) {
                RangeCoder.initProbs(sArr4[i11]);
                i11++;
            } else {
                RangeCoder.initProbs(this.f63448l);
                return;
            }
        }
    }
}
