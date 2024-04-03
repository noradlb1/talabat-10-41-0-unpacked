package org.apache.commons.compress.harmony.pack200;

import java.io.IOException;
import java.io.InputStream;

public class PopulationCodec extends Codec {
    private int[] favoured;
    private final Codec favouredCodec;

    /* renamed from: l  reason: collision with root package name */
    private int f27749l;
    private Codec tokenCodec;
    private final Codec unfavouredCodec;

    public PopulationCodec(Codec codec, Codec codec2, Codec codec3) {
        this.favouredCodec = codec;
        this.tokenCodec = codec2;
        this.unfavouredCodec = codec3;
    }

    public int decode(InputStream inputStream) throws IOException, Pack200Exception {
        throw new Pack200Exception("Population encoding does not work unless the number of elements are known");
    }

    public int[] decodeInts(int i11, InputStream inputStream) throws IOException, Pack200Exception {
        this.lastBandLength = 0;
        this.favoured = new int[i11];
        int i12 = Integer.MAX_VALUE;
        int i13 = 0;
        int i14 = -1;
        while (true) {
            int decode = this.favouredCodec.decode(inputStream, (long) i13);
            if (i14 <= -1 || !(decode == i12 || decode == i13)) {
                i14++;
                this.favoured[i14] = decode;
                int abs = Math.abs(i12);
                int abs2 = Math.abs(decode);
                if (abs > abs2) {
                    i12 = decode;
                } else if (abs == abs2) {
                    i12 = abs;
                }
                i13 = decode;
            }
        }
        this.lastBandLength += i14;
        if (this.tokenCodec == null) {
            if (i14 < 256) {
                this.tokenCodec = Codec.BYTE1;
            } else {
                int i15 = 1;
                while (true) {
                    i15++;
                    if (i15 >= 5) {
                        break;
                    }
                    BHSDCodec bHSDCodec = new BHSDCodec(i15, 256 - this.f27749l, 0);
                    if (bHSDCodec.encodes((long) i14)) {
                        this.tokenCodec = bHSDCodec;
                        break;
                    }
                }
                if (this.tokenCodec == null) {
                    throw new Pack200Exception("Cannot calculate token codec from " + i14 + " and " + this.f27749l);
                }
            }
        }
        this.lastBandLength += i11;
        int[] decodeInts = this.tokenCodec.decodeInts(i11, inputStream);
        int i16 = 0;
        for (int i17 = 0; i17 < i11; i17++) {
            int i18 = decodeInts[i17];
            if (i18 == 0) {
                this.lastBandLength++;
                i16 = this.unfavouredCodec.decode(inputStream, (long) i16);
                decodeInts[i17] = i16;
            } else {
                decodeInts[i17] = this.favoured[i18 - 1];
            }
        }
        return decodeInts;
    }

    public byte[] encode(int i11, int i12) throws Pack200Exception {
        throw new Pack200Exception("Population encoding does not work unless the number of elements are known");
    }

    public int[] getFavoured() {
        return this.favoured;
    }

    public Codec getFavouredCodec() {
        return this.favouredCodec;
    }

    public Codec getTokenCodec() {
        return this.tokenCodec;
    }

    public Codec getUnfavouredCodec() {
        return this.unfavouredCodec;
    }

    public int decode(InputStream inputStream, long j11) throws IOException, Pack200Exception {
        throw new Pack200Exception("Population encoding does not work unless the number of elements are known");
    }

    public byte[] encode(int i11) throws Pack200Exception {
        throw new Pack200Exception("Population encoding does not work unless the number of elements are known");
    }

    public byte[] encode(int[] iArr, int[] iArr2, int[] iArr3) throws Pack200Exception {
        int length = iArr.length + 1;
        int[] iArr4 = new int[length];
        System.arraycopy(iArr, 0, iArr4, 0, iArr.length);
        iArr4[length - 1] = iArr[iArr.length - 1];
        byte[] encode = this.favouredCodec.encode(iArr4);
        byte[] encode2 = this.tokenCodec.encode(iArr2);
        byte[] encode3 = this.unfavouredCodec.encode(iArr3);
        byte[] bArr = new byte[(encode.length + encode2.length + encode3.length)];
        System.arraycopy(encode, 0, bArr, 0, encode.length);
        System.arraycopy(encode2, 0, bArr, encode.length, encode2.length);
        System.arraycopy(encode3, 0, bArr, encode.length + encode2.length, encode3.length);
        return bArr;
    }

    public PopulationCodec(Codec codec, int i11, Codec codec2) {
        if (i11 >= 256 || i11 <= 0) {
            throw new IllegalArgumentException("L must be between 1..255");
        }
        this.favouredCodec = codec;
        this.f27749l = i11;
        this.unfavouredCodec = codec2;
    }
}
