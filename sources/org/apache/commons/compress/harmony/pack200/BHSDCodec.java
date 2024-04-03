package org.apache.commons.compress.harmony.pack200;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public final class BHSDCodec extends Codec {

    /* renamed from: b  reason: collision with root package name */
    private final int f27727b;
    private long cardinality;

    /* renamed from: d  reason: collision with root package name */
    private final int f27728d;

    /* renamed from: h  reason: collision with root package name */
    private final int f27729h;

    /* renamed from: l  reason: collision with root package name */
    private final int f27730l;
    private final long largest;
    private final long[] powers;

    /* renamed from: s  reason: collision with root package name */
    private final int f27731s;
    private final long smallest;

    public BHSDCodec(int i11, int i12) {
        this(i11, i12, 0, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long calculateLargest() {
        /*
            r6 = this;
            int r0 = r6.f27728d
            r1 = 1
            if (r0 != r1) goto L_0x0013
            org.apache.commons.compress.harmony.pack200.BHSDCodec r0 = new org.apache.commons.compress.harmony.pack200.BHSDCodec
            int r1 = r6.f27727b
            int r2 = r6.f27729h
            r0.<init>(r1, r2)
            long r0 = r0.largest()
            return r0
        L_0x0013:
            int r0 = r6.f27731s
            r2 = 1
            if (r0 != 0) goto L_0x001f
            long r0 = r6.cardinality()
        L_0x001d:
            long r0 = r0 - r2
            goto L_0x0038
        L_0x001f:
            if (r0 != r1) goto L_0x0029
            long r0 = r6.cardinality()
            r4 = 2
            long r0 = r0 / r4
            goto L_0x001d
        L_0x0029:
            r1 = 2
            if (r0 != r1) goto L_0x004b
            r0 = 3
            long r4 = r6.cardinality()
            long r4 = r4 * r0
            r0 = 4
            long r4 = r4 / r0
            long r0 = r4 - r2
        L_0x0038:
            int r4 = r6.f27731s
            if (r4 != 0) goto L_0x0042
            r4 = 4294967294(0xfffffffe, double:2.12199579E-314)
            goto L_0x0045
        L_0x0042:
            r4 = 2147483647(0x7fffffff, double:1.060997895E-314)
        L_0x0045:
            long r4 = r4 - r2
            long r0 = java.lang.Math.min(r4, r0)
            return r0
        L_0x004b:
            java.lang.Error r0 = new java.lang.Error
            java.lang.String r1 = "Unknown s value"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.harmony.pack200.BHSDCodec.calculateLargest():long");
    }

    private long calculateSmallest() {
        if (this.f27728d != 1 && isSigned()) {
            return Math.max(-2147483648L, (-cardinality()) / ((long) (1 << this.f27731s)));
        }
        if (this.cardinality >= 4294967296L) {
            return -2147483648L;
        }
        return 0;
    }

    public long cardinality() {
        return this.cardinality;
    }

    public int decode(InputStream inputStream) throws IOException, Pack200Exception {
        if (this.f27728d == 0) {
            return decode(inputStream, 0);
        }
        throw new Pack200Exception("Delta encoding used without passing in last value; this is a coding error");
    }

    public int[] decodeInts(int i11, InputStream inputStream) throws IOException, Pack200Exception {
        int[] decodeInts = super.decodeInts(i11, inputStream);
        if (isDelta()) {
            for (int i12 = 0; i12 < decodeInts.length; i12++) {
                while (true) {
                    int i13 = decodeInts[i12];
                    if (((long) i13) <= this.largest) {
                        break;
                    }
                    decodeInts[i12] = (int) (((long) i13) - this.cardinality);
                }
                while (true) {
                    int i14 = decodeInts[i12];
                    if (((long) i14) >= this.smallest) {
                        break;
                    }
                    decodeInts[i12] = (int) (((long) i14) + this.cardinality);
                }
            }
        }
        return decodeInts;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] encode(int r8, int r9) throws org.apache.commons.compress.harmony.pack200.Pack200Exception {
        /*
            r7 = this;
            long r0 = (long) r8
            boolean r2 = r7.encodes(r0)
            if (r2 == 0) goto L_0x00b8
            boolean r8 = r7.isDelta()
            if (r8 == 0) goto L_0x000f
            long r8 = (long) r9
            long r0 = r0 - r8
        L_0x000f:
            boolean r8 = r7.isSigned()
            r2 = 0
            r4 = 4294967296(0x100000000, double:2.121995791E-314)
            if (r8 == 0) goto L_0x0049
            r8 = -2147483648(0xffffffff80000000, double:NaN)
            int r8 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r8 >= 0) goto L_0x0025
            long r0 = r0 + r4
            goto L_0x002d
        L_0x0025:
            r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r8 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r8 <= 0) goto L_0x002d
            long r0 = r0 - r4
        L_0x002d:
            int r8 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r8 >= 0) goto L_0x003a
            long r8 = -r0
            int r0 = r7.f27731s
            long r8 = r8 << r0
            r0 = 1
            long r0 = r8 - r0
            goto L_0x0056
        L_0x003a:
            int r8 = r7.f27731s
            r9 = 1
            if (r8 != r9) goto L_0x0041
            long r0 = r0 << r8
            goto L_0x0056
        L_0x0041:
            r8 = 3
            long r4 = r0 % r8
            long r4 = r0 - r4
            long r4 = r4 / r8
            goto L_0x0055
        L_0x0049:
            int r8 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r8 >= 0) goto L_0x0056
            long r8 = r7.cardinality
            int r6 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x0055
            long r0 = r0 + r8
            goto L_0x0056
        L_0x0055:
            long r0 = r0 + r4
        L_0x0056:
            int r8 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r8 < 0) goto L_0x00b0
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r9 = 0
            r2 = r9
        L_0x0061:
            int r3 = r7.f27727b
            if (r2 >= r3) goto L_0x0098
            int r3 = r7.f27730l
            long r3 = (long) r3
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x006e
            r3 = r0
            goto L_0x007f
        L_0x006e:
            int r3 = r7.f27729h
            long r3 = (long) r3
            long r3 = r0 % r3
        L_0x0073:
            int r5 = r7.f27730l
            long r5 = (long) r5
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 >= 0) goto L_0x007f
            int r5 = r7.f27729h
            long r5 = (long) r5
            long r3 = r3 + r5
            goto L_0x0073
        L_0x007f:
            int r5 = (int) r3
            byte r5 = (byte) r5
            java.lang.Byte r5 = java.lang.Byte.valueOf(r5)
            r8.add(r5)
            int r5 = r7.f27730l
            long r5 = (long) r5
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 >= 0) goto L_0x0090
            goto L_0x0098
        L_0x0090:
            long r0 = r0 - r3
            int r3 = r7.f27729h
            long r3 = (long) r3
            long r0 = r0 / r3
            int r2 = r2 + 1
            goto L_0x0061
        L_0x0098:
            int r0 = r8.size()
            byte[] r1 = new byte[r0]
        L_0x009e:
            if (r9 >= r0) goto L_0x00af
            java.lang.Object r2 = r8.get(r9)
            java.lang.Byte r2 = (java.lang.Byte) r2
            byte r2 = r2.byteValue()
            r1[r9] = r2
            int r9 = r9 + 1
            goto L_0x009e
        L_0x00af:
            return r1
        L_0x00b0:
            org.apache.commons.compress.harmony.pack200.Pack200Exception r8 = new org.apache.commons.compress.harmony.pack200.Pack200Exception
            java.lang.String r9 = "unable to encode"
            r8.<init>(r9)
            throw r8
        L_0x00b8:
            org.apache.commons.compress.harmony.pack200.Pack200Exception r9 = new org.apache.commons.compress.harmony.pack200.Pack200Exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "The codec "
            r0.append(r1)
            java.lang.String r1 = r7.toString()
            r0.append(r1)
            java.lang.String r1 = " does not encode the value "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r9.<init>(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.harmony.pack200.BHSDCodec.encode(int, int):byte[]");
    }

    public boolean encodes(long j11) {
        return j11 >= this.smallest && j11 <= this.largest;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BHSDCodec)) {
            return false;
        }
        BHSDCodec bHSDCodec = (BHSDCodec) obj;
        if (bHSDCodec.f27727b == this.f27727b && bHSDCodec.f27729h == this.f27729h && bHSDCodec.f27731s == this.f27731s && bHSDCodec.f27728d == this.f27728d) {
            return true;
        }
        return false;
    }

    public int getB() {
        return this.f27727b;
    }

    public int getH() {
        return this.f27729h;
    }

    public int getL() {
        return this.f27730l;
    }

    public int getS() {
        return this.f27731s;
    }

    public int hashCode() {
        return (((((this.f27727b * 37) + this.f27729h) * 37) + this.f27731s) * 37) + this.f27728d;
    }

    public boolean isDelta() {
        return this.f27728d != 0;
    }

    public boolean isSigned() {
        return this.f27731s != 0;
    }

    public long largest() {
        return this.largest;
    }

    public long smallest() {
        return this.smallest;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(11);
        stringBuffer.append('(');
        stringBuffer.append(this.f27727b);
        stringBuffer.append(AbstractJsonLexerKt.COMMA);
        stringBuffer.append(this.f27729h);
        if (!(this.f27731s == 0 && this.f27728d == 0)) {
            stringBuffer.append(AbstractJsonLexerKt.COMMA);
            stringBuffer.append(this.f27731s);
        }
        if (this.f27728d != 0) {
            stringBuffer.append(AbstractJsonLexerKt.COMMA);
            stringBuffer.append(this.f27728d);
        }
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public BHSDCodec(int i11, int i12, int i13) {
        this(i11, i12, i13, 0);
    }

    public BHSDCodec(int i11, int i12, int i13, int i14) {
        if (i11 < 1 || i11 > 5) {
            throw new IllegalArgumentException("1<=b<=5");
        } else if (i12 < 1 || i12 > 256) {
            throw new IllegalArgumentException("1<=h<=256");
        } else if (i13 < 0 || i13 > 2) {
            throw new IllegalArgumentException("0<=s<=2");
        } else if (i14 < 0 || i14 > 1) {
            throw new IllegalArgumentException("0<=d<=1");
        } else if (i11 == 1 && i12 != 256) {
            throw new IllegalArgumentException("b=1 -> h=256");
        } else if (i12 == 256 && i11 == 5) {
            throw new IllegalArgumentException("h=256 -> b!=5");
        } else {
            this.f27727b = i11;
            this.f27729h = i12;
            this.f27731s = i13;
            this.f27728d = i14;
            int i15 = 256 - i12;
            this.f27730l = i15;
            if (i12 == 1) {
                this.cardinality = (long) ((i11 * 255) + 1);
            } else {
                double d11 = (double) i12;
                double d12 = (double) i11;
                this.cardinality = (long) (((double) ((long) ((((double) i15) * (1.0d - Math.pow(d11, d12))) / ((double) (1 - i12))))) + Math.pow(d11, d12));
            }
            this.smallest = calculateSmallest();
            this.largest = calculateLargest();
            this.powers = new long[i11];
            for (int i16 = 0; i16 < i11; i16++) {
                this.powers[i16] = (long) Math.pow((double) i12, (double) i16);
            }
        }
    }

    public int decode(InputStream inputStream, long j11) throws IOException, Pack200Exception {
        long read;
        int i11 = 0;
        long j12 = 0;
        do {
            read = (long) inputStream.read();
            this.lastBandLength++;
            j12 += this.powers[i11] * read;
            i11++;
            if (read < ((long) this.f27730l) || i11 >= this.f27727b) {
            }
            read = (long) inputStream.read();
            this.lastBandLength++;
            j12 += this.powers[i11] * read;
            i11++;
            break;
        } while (i11 >= this.f27727b);
        if (read != -1) {
            if (isSigned()) {
                int i12 = this.f27731s;
                long j13 = (long) ((1 << i12) - 1);
                j12 = (j12 & j13) == j13 ? ~(j12 >>> i12) : j12 - (j12 >>> i12);
            }
            if (isDelta()) {
                j12 += j11;
            }
            return (int) j12;
        }
        throw new EOFException("End of stream reached whilst decoding");
    }

    public int[] decodeInts(int i11, InputStream inputStream, int i12) throws IOException, Pack200Exception {
        int[] decodeInts = super.decodeInts(i11, inputStream, i12);
        if (isDelta()) {
            for (int i13 = 0; i13 < decodeInts.length; i13++) {
                while (true) {
                    int i14 = decodeInts[i13];
                    if (((long) i14) <= this.largest) {
                        break;
                    }
                    decodeInts[i13] = (int) (((long) i14) - this.cardinality);
                }
                while (true) {
                    int i15 = decodeInts[i13];
                    if (((long) i15) >= this.smallest) {
                        break;
                    }
                    decodeInts[i13] = (int) (((long) i15) + this.cardinality);
                }
            }
        }
        return decodeInts;
    }

    public byte[] encode(int i11) throws Pack200Exception {
        return encode(i11, 0);
    }
}
