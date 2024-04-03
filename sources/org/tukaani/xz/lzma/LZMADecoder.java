package org.tukaani.xz.lzma;

import java.io.IOException;
import org.tukaani.xz.lz.LZDecoder;
import org.tukaani.xz.lzma.LZMACoder;
import org.tukaani.xz.rangecoder.RangeDecoder;

public final class LZMADecoder extends LZMACoder {
    private final LiteralDecoder literalDecoder;
    /* access modifiers changed from: private */

    /* renamed from: lz  reason: collision with root package name */
    public final LZDecoder f63458lz;
    private final LengthDecoder matchLenDecoder = new LengthDecoder();
    /* access modifiers changed from: private */

    /* renamed from: rc  reason: collision with root package name */
    public final RangeDecoder f63459rc;
    private final LengthDecoder repLenDecoder = new LengthDecoder();

    public class LengthDecoder extends LZMACoder.LengthCoder {
        private LengthDecoder() {
            super();
        }

        public int b(int i11) throws IOException {
            return LZMADecoder.this.f63459rc.decodeBit(this.f63449a, 0) == 0 ? LZMADecoder.this.f63459rc.decodeBitTree(this.f63450b[i11]) + 2 : LZMADecoder.this.f63459rc.decodeBit(this.f63449a, 1) == 0 ? LZMADecoder.this.f63459rc.decodeBitTree(this.f63451c[i11]) + 2 + 8 : LZMADecoder.this.f63459rc.decodeBitTree(this.f63452d) + 2 + 8 + 8;
        }
    }

    public class LiteralDecoder extends LZMACoder.LiteralCoder {
        private final LiteralSubdecoder[] subdecoders;

        public class LiteralSubdecoder extends LZMACoder.LiteralCoder.LiteralSubcoder {
            private LiteralSubdecoder() {
                super();
            }

            public void b() throws IOException {
                int i11 = 1;
                if (LZMADecoder.this.f63439c.b()) {
                    do {
                        i11 = LZMADecoder.this.f63459rc.decodeBit(this.f63456a, i11) | (i11 << 1);
                    } while (i11 < 256);
                } else {
                    int i12 = LZMADecoder.this.f63458lz.getByte(LZMADecoder.this.f63438b[0]);
                    int i13 = 256;
                    int i14 = 1;
                    do {
                        i12 <<= 1;
                        int i15 = i12 & i13;
                        int decodeBit = LZMADecoder.this.f63459rc.decodeBit(this.f63456a, i13 + i15 + i14);
                        i14 = (i14 << 1) | decodeBit;
                        i13 &= (~i15) ^ (0 - decodeBit);
                    } while (i14 < 256);
                    i11 = i14;
                }
                LZMADecoder.this.f63458lz.putByte((byte) i11);
                LZMADecoder.this.f63439c.e();
            }
        }

        public LiteralDecoder(int i11, int i12) {
            super(i11, i12);
            this.subdecoders = new LiteralSubdecoder[(1 << (i11 + i12))];
            int i13 = 0;
            while (true) {
                LiteralSubdecoder[] literalSubdecoderArr = this.subdecoders;
                if (i13 < literalSubdecoderArr.length) {
                    literalSubdecoderArr[i13] = new LiteralSubdecoder();
                    i13++;
                } else {
                    return;
                }
            }
        }

        public void b() throws IOException {
            this.subdecoders[a(LZMADecoder.this.f63458lz.getByte(0), LZMADecoder.this.f63458lz.getPos())].b();
        }

        public void c() {
            int i11 = 0;
            while (true) {
                LiteralSubdecoder[] literalSubdecoderArr = this.subdecoders;
                if (i11 < literalSubdecoderArr.length) {
                    literalSubdecoderArr[i11].a();
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    public LZMADecoder(LZDecoder lZDecoder, RangeDecoder rangeDecoder, int i11, int i12, int i13) {
        super(i13);
        this.f63458lz = lZDecoder;
        this.f63459rc = rangeDecoder;
        this.literalDecoder = new LiteralDecoder(i11, i12);
        reset();
    }

    private int decodeMatch(int i11) throws IOException {
        this.f63439c.g();
        int[] iArr = this.f63438b;
        iArr[3] = iArr[2];
        iArr[2] = iArr[1];
        iArr[1] = iArr[0];
        int b11 = this.matchLenDecoder.b(i11);
        int decodeBitTree = this.f63459rc.decodeBitTree(this.f63446j[LZMACoder.a(b11)]);
        if (decodeBitTree < 4) {
            this.f63438b[0] = decodeBitTree;
        } else {
            int i12 = (decodeBitTree >> 1) - 1;
            int[] iArr2 = this.f63438b;
            int i13 = (2 | (decodeBitTree & 1)) << i12;
            iArr2[0] = i13;
            if (decodeBitTree < 14) {
                iArr2[0] = this.f63459rc.decodeReverseBitTree(this.f63447k[decodeBitTree - 4]) | i13;
            } else {
                iArr2[0] = (this.f63459rc.decodeDirectBits(i12 - 4) << 4) | i13;
                int[] iArr3 = this.f63438b;
                iArr3[0] = iArr3[0] | this.f63459rc.decodeReverseBitTree(this.f63448l);
            }
        }
        return b11;
    }

    private int decodeRepMatch(int i11) throws IOException {
        int i12;
        if (this.f63459rc.decodeBit(this.f63442f, this.f63439c.a()) != 0) {
            if (this.f63459rc.decodeBit(this.f63443g, this.f63439c.a()) == 0) {
                i12 = this.f63438b[1];
            } else {
                if (this.f63459rc.decodeBit(this.f63444h, this.f63439c.a()) == 0) {
                    i12 = this.f63438b[2];
                } else {
                    int[] iArr = this.f63438b;
                    int i13 = iArr[3];
                    iArr[3] = iArr[2];
                    i12 = i13;
                }
                int[] iArr2 = this.f63438b;
                iArr2[2] = iArr2[1];
            }
            int[] iArr3 = this.f63438b;
            iArr3[1] = iArr3[0];
            iArr3[0] = i12;
        } else if (this.f63459rc.decodeBit(this.f63445i[this.f63439c.a()], i11) == 0) {
            this.f63439c.h();
            return 1;
        }
        this.f63439c.f();
        return this.repLenDecoder.b(i11);
    }

    public void decode() throws IOException {
        this.f63458lz.repeatPending();
        while (this.f63458lz.hasSpace()) {
            int pos = this.f63458lz.getPos() & this.f63437a;
            if (this.f63459rc.decodeBit(this.f63440d[this.f63439c.a()], pos) == 0) {
                this.literalDecoder.b();
            } else {
                this.f63458lz.repeat(this.f63438b[0], this.f63459rc.decodeBit(this.f63441e, this.f63439c.a()) == 0 ? decodeMatch(pos) : decodeRepMatch(pos));
            }
        }
        this.f63459rc.normalize();
    }

    public boolean endMarkerDetected() {
        return this.f63438b[0] == -1;
    }

    public void reset() {
        super.reset();
        this.literalDecoder.c();
        this.matchLenDecoder.a();
        this.repLenDecoder.a();
    }
}
