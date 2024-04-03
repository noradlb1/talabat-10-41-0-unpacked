package org.apache.commons.compress.harmony.pack200;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class RunCodec extends Codec {
    private final Codec aCodec;
    private final Codec bCodec;

    /* renamed from: k  reason: collision with root package name */
    private int f27750k;
    private int last;

    public RunCodec(int i11, Codec codec, Codec codec2) throws Pack200Exception {
        if (i11 <= 0) {
            throw new Pack200Exception("Cannot have a RunCodec for a negative number of numbers");
        } else if (codec == null || codec2 == null) {
            throw new Pack200Exception("Must supply both codecs for a RunCodec");
        } else {
            this.f27750k = i11;
            this.aCodec = codec;
            this.bCodec = codec2;
        }
    }

    private int normalise(int i11, Codec codec) {
        if (codec instanceof BHSDCodec) {
            BHSDCodec bHSDCodec = (BHSDCodec) codec;
            if (bHSDCodec.isDelta()) {
                long cardinality = bHSDCodec.cardinality();
                while (true) {
                    long j11 = (long) i11;
                    if (j11 <= bHSDCodec.largest()) {
                        break;
                    }
                    i11 = (int) (j11 - cardinality);
                }
                while (true) {
                    long j12 = (long) i11;
                    if (j12 >= bHSDCodec.smallest()) {
                        break;
                    }
                    i11 = (int) (j12 + cardinality);
                }
            }
        }
        return i11;
    }

    public int decode(InputStream inputStream) throws IOException, Pack200Exception {
        return decode(inputStream, (long) this.last);
    }

    public int[] decodeInts(int i11, InputStream inputStream) throws IOException, Pack200Exception {
        int[] iArr = new int[i11];
        int[] decodeInts = this.aCodec.decodeInts(this.f27750k, inputStream);
        normalise(decodeInts, this.aCodec);
        int[] decodeInts2 = this.bCodec.decodeInts(i11 - this.f27750k, inputStream);
        normalise(decodeInts2, this.bCodec);
        System.arraycopy(decodeInts, 0, iArr, 0, this.f27750k);
        int i12 = this.f27750k;
        System.arraycopy(decodeInts2, 0, iArr, i12, i11 - i12);
        this.lastBandLength = this.aCodec.lastBandLength + this.bCodec.lastBandLength;
        return iArr;
    }

    public byte[] encode(int i11, int i12) throws Pack200Exception {
        throw new Pack200Exception("Must encode entire band at once with a RunCodec");
    }

    public Codec getACodec() {
        return this.aCodec;
    }

    public Codec getBCodec() {
        return this.bCodec;
    }

    public int getK() {
        return this.f27750k;
    }

    public String toString() {
        return "RunCodec[k=" + this.f27750k + ";aCodec=" + this.aCodec + "bCodec=" + this.bCodec + "]";
    }

    public int decode(InputStream inputStream, long j11) throws IOException, Pack200Exception {
        int i11 = this.f27750k - 1;
        this.f27750k = i11;
        if (i11 >= 0) {
            int decode = this.aCodec.decode(inputStream, (long) this.last);
            this.last = this.f27750k == 0 ? 0 : decode;
            return normalise(decode, this.aCodec);
        }
        int decode2 = this.bCodec.decode(inputStream, (long) this.last);
        this.last = decode2;
        return normalise(decode2, this.bCodec);
    }

    public byte[] encode(int i11) throws Pack200Exception {
        throw new Pack200Exception("Must encode entire band at once with a RunCodec");
    }

    private void normalise(int[] iArr, Codec codec) {
        if (codec instanceof BHSDCodec) {
            BHSDCodec bHSDCodec = (BHSDCodec) codec;
            if (bHSDCodec.isDelta()) {
                long cardinality = bHSDCodec.cardinality();
                for (int i11 = 0; i11 < iArr.length; i11++) {
                    while (((long) iArr[i11]) > bHSDCodec.largest()) {
                        iArr[i11] = (int) (((long) iArr[i11]) - cardinality);
                    }
                    while (((long) iArr[i11]) < bHSDCodec.smallest()) {
                        iArr[i11] = (int) (((long) iArr[i11]) + cardinality);
                    }
                }
            }
        } else if (codec instanceof PopulationCodec) {
            PopulationCodec populationCodec = (PopulationCodec) codec;
            int[] iArr2 = (int[]) populationCodec.getFavoured().clone();
            Arrays.sort(iArr2);
            for (int i12 = 0; i12 < iArr.length; i12++) {
                Codec favouredCodec = Arrays.binarySearch(iArr2, iArr[i12]) > -1 ? populationCodec.getFavouredCodec() : populationCodec.getUnfavouredCodec();
                if (favouredCodec instanceof BHSDCodec) {
                    BHSDCodec bHSDCodec2 = (BHSDCodec) favouredCodec;
                    if (bHSDCodec2.isDelta()) {
                        long cardinality2 = bHSDCodec2.cardinality();
                        while (((long) iArr[i12]) > bHSDCodec2.largest()) {
                            iArr[i12] = (int) (((long) iArr[i12]) - cardinality2);
                        }
                        while (((long) iArr[i12]) < bHSDCodec2.smallest()) {
                            iArr[i12] = (int) (((long) iArr[i12]) + cardinality2);
                        }
                    }
                }
            }
        }
    }
}
