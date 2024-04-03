package org.apache.commons.compress.compressors.bzip2;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.nio.ByteOrder;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.BitInputStream;
import org.apache.commons.compress.utils.CloseShieldFilterInputStream;
import org.apache.commons.compress.utils.InputStreamStatistics;

public class BZip2CompressorInputStream extends CompressorInputStream implements BZip2Constants, InputStreamStatistics {
    private static final int EOF = 0;
    private static final int NO_RAND_PART_A_STATE = 5;
    private static final int NO_RAND_PART_B_STATE = 6;
    private static final int NO_RAND_PART_C_STATE = 7;
    private static final int RAND_PART_A_STATE = 2;
    private static final int RAND_PART_B_STATE = 3;
    private static final int RAND_PART_C_STATE = 4;
    private static final int START_BLOCK_STATE = 1;
    private BitInputStream bin;
    private boolean blockRandomised;
    private int blockSize100k;
    private int computedBlockCRC;
    private int computedCombinedCRC;
    private final CRC crc;
    private int currentState;
    private Data data;
    private final boolean decompressConcatenated;
    private int last;
    private int nInUse;
    private int origPtr;
    private int storedBlockCRC;
    private int storedCombinedCRC;
    private int su_ch2;
    private int su_chPrev;
    private int su_count;
    private int su_i2;
    private int su_j2;
    private int su_rNToGo;
    private int su_rTPos;
    private int su_tPos;
    private char su_z;

    public static final class Data {

        /* renamed from: a  reason: collision with root package name */
        public final boolean[] f27670a = new boolean[256];

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f27671b = new byte[256];

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f27672c = new byte[BZip2Constants.MAX_SELECTORS];

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f27673d = new byte[BZip2Constants.MAX_SELECTORS];

        /* renamed from: e  reason: collision with root package name */
        public final int[] f27674e = new int[256];

        /* renamed from: f  reason: collision with root package name */
        public final int[][] f27675f;

        /* renamed from: g  reason: collision with root package name */
        public final int[][] f27676g;

        /* renamed from: h  reason: collision with root package name */
        public final int[][] f27677h;

        /* renamed from: i  reason: collision with root package name */
        public final int[] f27678i;

        /* renamed from: j  reason: collision with root package name */
        public final int[] f27679j;

        /* renamed from: k  reason: collision with root package name */
        public final char[] f27680k;

        /* renamed from: l  reason: collision with root package name */
        public final char[][] f27681l;

        /* renamed from: m  reason: collision with root package name */
        public final byte[] f27682m;

        /* renamed from: n  reason: collision with root package name */
        public int[] f27683n;

        /* renamed from: o  reason: collision with root package name */
        public final byte[] f27684o;

        public Data(int i11) {
            int[] iArr = {6, BZip2Constants.MAX_ALPHA_SIZE};
            Class cls = Integer.TYPE;
            this.f27675f = (int[][]) Array.newInstance(cls, iArr);
            this.f27676g = (int[][]) Array.newInstance(cls, new int[]{6, BZip2Constants.MAX_ALPHA_SIZE});
            this.f27677h = (int[][]) Array.newInstance(cls, new int[]{6, BZip2Constants.MAX_ALPHA_SIZE});
            this.f27678i = new int[6];
            this.f27679j = new int[257];
            this.f27680k = new char[256];
            this.f27681l = (char[][]) Array.newInstance(Character.TYPE, new int[]{6, BZip2Constants.MAX_ALPHA_SIZE});
            this.f27682m = new byte[6];
            this.f27684o = new byte[(i11 * 100000)];
        }

        public int[] a(int i11) {
            int[] iArr = this.f27683n;
            if (iArr != null && iArr.length >= i11) {
                return iArr;
            }
            int[] iArr2 = new int[i11];
            this.f27683n = iArr2;
            return iArr2;
        }
    }

    public BZip2CompressorInputStream(InputStream inputStream) throws IOException {
        this(inputStream, false);
    }

    private static boolean bsGetBit(BitInputStream bitInputStream) throws IOException {
        return bsR(bitInputStream, 1) != 0;
    }

    private static int bsGetInt(BitInputStream bitInputStream) throws IOException {
        return bsR(bitInputStream, 32);
    }

    private static char bsGetUByte(BitInputStream bitInputStream) throws IOException {
        return (char) bsR(bitInputStream, 8);
    }

    private static int bsR(BitInputStream bitInputStream, int i11) throws IOException {
        long readBits = bitInputStream.readBits(i11);
        if (readBits >= 0) {
            return (int) readBits;
        }
        throw new IOException("Unexpected end of stream");
    }

    private static void checkBounds(int i11, int i12, String str) throws IOException {
        if (i11 < 0) {
            throw new IOException("Corrupted input, " + str + " value negative");
        } else if (i11 >= i12) {
            throw new IOException("Corrupted input, " + str + " value too big");
        }
    }

    private boolean complete() throws IOException {
        int bsGetInt = bsGetInt(this.bin);
        this.storedCombinedCRC = bsGetInt;
        this.currentState = 0;
        this.data = null;
        if (bsGetInt != this.computedCombinedCRC) {
            throw new IOException("BZip2 CRC error");
        } else if (!this.decompressConcatenated || !init(false)) {
            return true;
        } else {
            return false;
        }
    }

    private void createHuffmanDecodingTables(int i11, int i12) throws IOException {
        Data data2 = this.data;
        char[][] cArr = data2.f27681l;
        int[] iArr = data2.f27678i;
        int[][] iArr2 = data2.f27675f;
        int[][] iArr3 = data2.f27676g;
        int[][] iArr4 = data2.f27677h;
        int i13 = i12;
        for (int i14 = 0; i14 < i13; i14++) {
            char[] cArr2 = cArr[i14];
            int i15 = 32;
            int i16 = i11;
            char c11 = 0;
            while (true) {
                i16--;
                if (i16 < 0) {
                    break;
                }
                char c12 = cArr2[i16];
                if (c12 > c11) {
                    c11 = c12;
                }
                if (c12 < i15) {
                    i15 = c12;
                }
            }
            hbCreateDecodeTables(iArr2[i14], iArr3[i14], iArr4[i14], cArr[i14], i15, c11, i11);
            iArr[i14] = i15;
        }
    }

    private void endBlock() throws IOException {
        int a11 = this.crc.a();
        this.computedBlockCRC = a11;
        int i11 = this.storedBlockCRC;
        if (i11 == a11) {
            int i12 = this.computedCombinedCRC;
            this.computedCombinedCRC = a11 ^ ((i12 >>> 31) | (i12 << 1));
            return;
        }
        int i13 = this.storedCombinedCRC;
        this.computedCombinedCRC = ((i13 >>> 31) | (i13 << 1)) ^ i11;
        throw new IOException("BZip2 CRC error");
    }

    private void getAndMoveToFrontDecode() throws IOException {
        int i11;
        String str;
        char c11;
        int i12;
        BZip2CompressorInputStream bZip2CompressorInputStream = this;
        BitInputStream bitInputStream = bZip2CompressorInputStream.bin;
        bZip2CompressorInputStream.origPtr = bsR(bitInputStream, 24);
        recvDecodingTables();
        Data data2 = bZip2CompressorInputStream.data;
        byte[] bArr = data2.f27684o;
        int[] iArr = data2.f27674e;
        byte[] bArr2 = data2.f27672c;
        byte[] bArr3 = data2.f27671b;
        char[] cArr = data2.f27680k;
        int[] iArr2 = data2.f27678i;
        int[][] iArr3 = data2.f27675f;
        int[][] iArr4 = data2.f27676g;
        int[][] iArr5 = data2.f27677h;
        int i13 = bZip2CompressorInputStream.blockSize100k * 100000;
        int i14 = 256;
        while (true) {
            i14--;
            if (i14 < 0) {
                break;
            }
            cArr[i14] = (char) i14;
            iArr[i14] = 0;
        }
        int i15 = bZip2CompressorInputStream.nInUse + 1;
        int andMoveToFrontDecode0 = getAndMoveToFrontDecode0();
        byte b11 = bArr2[0] & 255;
        checkBounds(b11, 6, "zt");
        int[] iArr6 = iArr4[b11];
        int[] iArr7 = iArr3[b11];
        int[] iArr8 = iArr5[b11];
        int i16 = iArr2[b11];
        int i17 = andMoveToFrontDecode0;
        int i18 = 49;
        int i19 = -1;
        int i21 = 0;
        while (i17 != i15) {
            int i22 = i15;
            String str2 = "groupNo";
            String str3 = "zvec";
            String str4 = " exceeds ";
            BitInputStream bitInputStream2 = bitInputStream;
            String str5 = "zn";
            if (i17 == 0 || i17 == 1) {
                int[] iArr9 = iArr2;
                String str6 = str3;
                String str7 = str4;
                String str8 = str5;
                int i23 = i17;
                int i24 = i13;
                BitInputStream bitInputStream3 = bitInputStream2;
                byte[] bArr4 = bArr;
                int i25 = i24;
                i17 = i23;
                int i26 = -1;
                int i27 = i18;
                int i28 = i21;
                int i29 = i16;
                int[] iArr10 = iArr8;
                int[] iArr11 = iArr7;
                int[] iArr12 = iArr6;
                int i31 = 1;
                while (true) {
                    if (i17 != 0) {
                        i11 = i19;
                        if (i17 != 1) {
                            break;
                        }
                        i26 += i31 << 1;
                    } else {
                        i26 += i31;
                        i11 = i19;
                    }
                    if (i27 == 0) {
                        int i32 = i28 + 1;
                        checkBounds(i32, BZip2Constants.MAX_SELECTORS, str2);
                        byte b12 = bArr2[i32] & 255;
                        str = str2;
                        checkBounds(b12, 6, "zt");
                        iArr12 = iArr4[b12];
                        iArr11 = iArr3[b12];
                        iArr10 = iArr5[b12];
                        i29 = iArr9[b12];
                        i28 = i32;
                        i27 = 49;
                    } else {
                        str = str2;
                        i27--;
                    }
                    int i33 = i29;
                    checkBounds(i33, BZip2Constants.MAX_ALPHA_SIZE, str8);
                    int bsR = bsR(bitInputStream3, i33);
                    int i34 = i33;
                    while (bsR > iArr11[i34]) {
                        int i35 = i34 + 1;
                        checkBounds(i35, BZip2Constants.MAX_ALPHA_SIZE, str8);
                        bsR = (bsR << 1) | bsR(bitInputStream3, 1);
                        i34 = i35;
                        iArr5 = iArr5;
                    }
                    int i36 = bsR - iArr12[i34];
                    checkBounds(i36, BZip2Constants.MAX_ALPHA_SIZE, str6);
                    i31 <<= 1;
                    i17 = iArr10[i36];
                    i29 = i33;
                    i19 = i11;
                    str2 = str;
                    iArr5 = iArr5;
                }
                bZip2CompressorInputStream = this;
                int[][] iArr13 = iArr5;
                checkBounds(i26, bZip2CompressorInputStream.data.f27684o.length, "s");
                char c12 = cArr[0];
                checkBounds(c12, 256, "yy");
                byte b13 = bArr3[c12];
                byte b14 = b13 & 255;
                iArr[b14] = iArr[b14] + i26 + 1;
                int i37 = i11 + 1;
                int i38 = i26 + i37;
                checkBounds(i38, bZip2CompressorInputStream.data.f27684o.length, "lastShadow");
                byte[] bArr5 = bArr4;
                Arrays.fill(bArr5, i37, i38 + 1, b13);
                int i39 = i25;
                if (i38 < i39) {
                    i19 = i38;
                    iArr6 = iArr12;
                    iArr7 = iArr11;
                    iArr8 = iArr10;
                    i16 = i29;
                    i21 = i28;
                    i15 = i22;
                    i18 = i27;
                    iArr2 = iArr9;
                    bArr = bArr5;
                    iArr5 = iArr13;
                    BitInputStream bitInputStream4 = bitInputStream3;
                    i13 = i39;
                    bitInputStream = bitInputStream4;
                } else {
                    throw new IOException("Block overrun while expanding RLE in MTF, " + i38 + str7 + i39);
                }
            } else {
                i19++;
                if (i19 < i13) {
                    int i41 = i13;
                    checkBounds(i17, 257, "nextSym");
                    int i42 = i17 - 1;
                    char c13 = cArr[i42];
                    int[] iArr14 = iArr2;
                    checkBounds(c13, 256, "yy");
                    byte b15 = bArr3[c13];
                    byte b16 = b15 & 255;
                    iArr[b16] = iArr[b16] + 1;
                    bArr[i19] = b15;
                    if (i17 <= 16) {
                        while (i42 > 0) {
                            int i43 = i42 - 1;
                            cArr[i42] = cArr[i43];
                            i42 = i43;
                        }
                        c11 = 0;
                    } else {
                        c11 = 0;
                        System.arraycopy(cArr, 0, cArr, 1, i42);
                    }
                    cArr[c11] = c13;
                    if (i18 == 0) {
                        int i44 = i21 + 1;
                        checkBounds(i44, BZip2Constants.MAX_SELECTORS, str2);
                        byte b17 = bArr2[i44] & 255;
                        checkBounds(b17, 6, "zt");
                        int[] iArr15 = iArr4[b17];
                        int[] iArr16 = iArr3[b17];
                        int[] iArr17 = iArr5[b17];
                        i12 = iArr14[b17];
                        i21 = i44;
                        iArr6 = iArr15;
                        iArr7 = iArr16;
                        iArr8 = iArr17;
                        i18 = 49;
                    } else {
                        i18--;
                        i12 = i16;
                    }
                    String str9 = str5;
                    checkBounds(i12, BZip2Constants.MAX_ALPHA_SIZE, str9);
                    BitInputStream bitInputStream5 = bitInputStream2;
                    int bsR2 = bsR(bitInputStream5, i12);
                    int i45 = i12;
                    while (bsR2 > iArr7[i45]) {
                        i45++;
                        checkBounds(i45, BZip2Constants.MAX_ALPHA_SIZE, str9);
                        bsR2 = (bsR2 << 1) | bsR(bitInputStream5, 1);
                    }
                    int i46 = bsR2 - iArr6[i45];
                    checkBounds(i46, BZip2Constants.MAX_ALPHA_SIZE, str3);
                    i17 = iArr8[i46];
                    i16 = i12;
                    bitInputStream = bitInputStream5;
                    i15 = i22;
                    i13 = i41;
                    iArr2 = iArr14;
                    bZip2CompressorInputStream = this;
                } else {
                    throw new IOException("Block overrun in MTF, " + i19 + str4 + i13);
                }
            }
        }
        bZip2CompressorInputStream.last = i19;
    }

    private int getAndMoveToFrontDecode0() throws IOException {
        Data data2 = this.data;
        byte b11 = data2.f27672c[0] & 255;
        checkBounds(b11, 6, "zt");
        int[] iArr = data2.f27675f[b11];
        int i11 = data2.f27678i[b11];
        checkBounds(i11, BZip2Constants.MAX_ALPHA_SIZE, "zn");
        int bsR = bsR(this.bin, i11);
        while (bsR > iArr[i11]) {
            i11++;
            checkBounds(i11, BZip2Constants.MAX_ALPHA_SIZE, "zn");
            bsR = (bsR << 1) | bsR(this.bin, 1);
        }
        int i12 = bsR - data2.f27676g[b11][i11];
        checkBounds(i12, BZip2Constants.MAX_ALPHA_SIZE, "zvec");
        return data2.f27677h[b11][i12];
    }

    private static void hbCreateDecodeTables(int[] iArr, int[] iArr2, int[] iArr3, char[] cArr, int i11, int i12, int i13) throws IOException {
        int i14 = 0;
        int i15 = 0;
        for (int i16 = i11; i16 <= i12; i16++) {
            for (int i17 = 0; i17 < i13; i17++) {
                if (cArr[i17] == i16) {
                    iArr3[i15] = i17;
                    i15++;
                }
            }
        }
        int i18 = 23;
        while (true) {
            i18--;
            if (i18 <= 0) {
                break;
            }
            iArr2[i18] = 0;
            iArr[i18] = 0;
        }
        for (int i19 = 0; i19 < i13; i19++) {
            char c11 = cArr[i19];
            checkBounds(c11, BZip2Constants.MAX_ALPHA_SIZE, "length");
            int i21 = c11 + 1;
            iArr2[i21] = iArr2[i21] + 1;
        }
        int i22 = iArr2[0];
        for (int i23 = 1; i23 < 23; i23++) {
            i22 += iArr2[i23];
            iArr2[i23] = i22;
        }
        int i24 = iArr2[i11];
        int i25 = i11;
        while (i25 <= i12) {
            int i26 = i25 + 1;
            int i27 = iArr2[i26];
            int i28 = i14 + (i27 - i24);
            iArr[i25] = i28 - 1;
            i14 = i28 << 1;
            i25 = i26;
            i24 = i27;
        }
        for (int i29 = i11 + 1; i29 <= i12; i29++) {
            iArr2[i29] = ((iArr[i29 - 1] + 1) << 1) - iArr2[i29];
        }
    }

    private boolean init(boolean z11) throws IOException {
        String str;
        BitInputStream bitInputStream = this.bin;
        if (bitInputStream != null) {
            if (!z11) {
                bitInputStream.clearBitCache();
            }
            int readNextByte = readNextByte(this.bin);
            if (readNextByte == -1 && !z11) {
                return false;
            }
            int readNextByte2 = readNextByte(this.bin);
            int readNextByte3 = readNextByte(this.bin);
            if (readNextByte == 66 && readNextByte2 == 90 && readNextByte3 == 104) {
                int readNextByte4 = readNextByte(this.bin);
                if (readNextByte4 < 49 || readNextByte4 > 57) {
                    throw new IOException("BZip2 block size is invalid");
                }
                this.blockSize100k = readNextByte4 - 48;
                this.computedCombinedCRC = 0;
                return true;
            }
            if (z11) {
                str = "Stream is not in the BZip2 format";
            } else {
                str = "Garbage after a valid BZip2 stream";
            }
            throw new IOException(str);
        }
        throw new IOException("No InputStream");
    }

    private void initBlock() throws IOException {
        BitInputStream bitInputStream = this.bin;
        do {
            char bsGetUByte = bsGetUByte(bitInputStream);
            char bsGetUByte2 = bsGetUByte(bitInputStream);
            char bsGetUByte3 = bsGetUByte(bitInputStream);
            char bsGetUByte4 = bsGetUByte(bitInputStream);
            char bsGetUByte5 = bsGetUByte(bitInputStream);
            char bsGetUByte6 = bsGetUByte(bitInputStream);
            if (bsGetUByte != 23 || bsGetUByte2 != 'r' || bsGetUByte3 != 'E' || bsGetUByte4 != '8' || bsGetUByte5 != 'P' || bsGetUByte6 != 144) {
                boolean z11 = false;
                if (bsGetUByte == '1' && bsGetUByte2 == 'A' && bsGetUByte3 == 'Y' && bsGetUByte4 == '&' && bsGetUByte5 == 'S' && bsGetUByte6 == 'Y') {
                    this.storedBlockCRC = bsGetInt(bitInputStream);
                    if (bsR(bitInputStream, 1) == 1) {
                        z11 = true;
                    }
                    this.blockRandomised = z11;
                    if (this.data == null) {
                        this.data = new Data(this.blockSize100k);
                    }
                    getAndMoveToFrontDecode();
                    this.crc.b();
                    this.currentState = 1;
                    return;
                }
                this.currentState = 0;
                throw new IOException("Bad block header");
            }
        } while (!complete());
    }

    private void makeMaps() {
        Data data2 = this.data;
        boolean[] zArr = data2.f27670a;
        byte[] bArr = data2.f27671b;
        int i11 = 0;
        for (int i12 = 0; i12 < 256; i12++) {
            if (zArr[i12]) {
                bArr[i11] = (byte) i12;
                i11++;
            }
        }
        this.nInUse = i11;
    }

    public static boolean matches(byte[] bArr, int i11) {
        return i11 >= 3 && bArr[0] == 66 && bArr[1] == 90 && bArr[2] == 104;
    }

    private int read0() throws IOException {
        switch (this.currentState) {
            case 0:
                return -1;
            case 1:
                return setupBlock();
            case 2:
                throw new IllegalStateException();
            case 3:
                return setupRandPartB();
            case 4:
                return setupRandPartC();
            case 5:
                throw new IllegalStateException();
            case 6:
                return setupNoRandPartB();
            case 7:
                return setupNoRandPartC();
            default:
                throw new IllegalStateException();
        }
    }

    private int readNextByte(BitInputStream bitInputStream) throws IOException {
        return (int) bitInputStream.readBits(8);
    }

    private void recvDecodingTables() throws IOException {
        int i11;
        BitInputStream bitInputStream = this.bin;
        Data data2 = this.data;
        boolean[] zArr = data2.f27670a;
        byte[] bArr = data2.f27682m;
        byte[] bArr2 = data2.f27672c;
        byte[] bArr3 = data2.f27673d;
        int i12 = 0;
        for (int i13 = 0; i13 < 16; i13++) {
            if (bsGetBit(bitInputStream)) {
                i12 |= 1 << i13;
            }
        }
        Arrays.fill(zArr, false);
        for (int i14 = 0; i14 < 16; i14++) {
            if (((1 << i14) & i12) != 0) {
                int i15 = i14 << 4;
                for (int i16 = 0; i16 < 16; i16++) {
                    if (bsGetBit(bitInputStream)) {
                        zArr[i15 + i16] = true;
                    }
                }
            }
        }
        makeMaps();
        int i17 = this.nInUse + 2;
        int bsR = bsR(bitInputStream, 3);
        int bsR2 = bsR(bitInputStream, 15);
        if (bsR2 >= 0) {
            checkBounds(i17, 259, "alphaSize");
            checkBounds(bsR, 7, "nGroups");
            for (int i18 = 0; i18 < bsR2; i18++) {
                int i19 = 0;
                while (bsGetBit(bitInputStream)) {
                    i19++;
                }
                if (i18 < 18002) {
                    bArr3[i18] = (byte) i19;
                }
            }
            if (bsR2 > 18002) {
                bsR2 = 18002;
            }
            int i21 = bsR;
            while (true) {
                i21--;
                if (i21 < 0) {
                    break;
                }
                bArr[i21] = (byte) i21;
            }
            for (int i22 = 0; i22 < bsR2; i22++) {
                int i23 = bArr3[i22] & 255;
                checkBounds(i23, 6, "selectorMtf");
                byte b11 = bArr[i23];
                while (i23 > 0) {
                    bArr[i23] = bArr[i23 - 1];
                    i23--;
                }
                bArr[0] = b11;
                bArr2[i22] = b11;
            }
            char[][] cArr = data2.f27681l;
            for (int i24 = 0; i24 < bsR; i24++) {
                int bsR3 = bsR(bitInputStream, 5);
                char[] cArr2 = cArr[i24];
                for (int i25 = 0; i25 < i17; i25++) {
                    while (bsGetBit(bitInputStream)) {
                        if (bsGetBit(bitInputStream)) {
                            i11 = -1;
                        } else {
                            i11 = 1;
                        }
                        bsR3 += i11;
                    }
                    cArr2[i25] = (char) bsR3;
                }
            }
            createHuffmanDecodingTables(i17, bsR);
            return;
        }
        throw new IOException("Corrupted input, nSelectors value negative");
    }

    private int setupBlock() throws IOException {
        Data data2;
        if (this.currentState == 0 || (data2 = this.data) == null) {
            return -1;
        }
        int[] iArr = data2.f27679j;
        int i11 = this.last + 1;
        int[] a11 = data2.a(i11);
        Data data3 = this.data;
        byte[] bArr = data3.f27684o;
        iArr[0] = 0;
        System.arraycopy(data3.f27674e, 0, iArr, 1, 256);
        int i12 = iArr[0];
        for (int i13 = 1; i13 <= 256; i13++) {
            i12 += iArr[i13];
            iArr[i13] = i12;
        }
        int i14 = this.last;
        for (int i15 = 0; i15 <= i14; i15++) {
            byte b11 = bArr[i15] & 255;
            int i16 = iArr[b11];
            iArr[b11] = i16 + 1;
            checkBounds(i16, i11, "tt index");
            a11[i16] = i15;
        }
        int i17 = this.origPtr;
        if (i17 < 0 || i17 >= a11.length) {
            throw new IOException("Stream corrupted");
        }
        this.su_tPos = a11[i17];
        this.su_count = 0;
        this.su_i2 = 0;
        this.su_ch2 = 256;
        if (!this.blockRandomised) {
            return setupNoRandPartA();
        }
        this.su_rNToGo = 0;
        this.su_rTPos = 0;
        return setupRandPartA();
    }

    private int setupNoRandPartA() throws IOException {
        if (this.su_i2 <= this.last) {
            this.su_chPrev = this.su_ch2;
            Data data2 = this.data;
            byte[] bArr = data2.f27684o;
            int i11 = this.su_tPos;
            byte b11 = bArr[i11] & 255;
            this.su_ch2 = b11;
            checkBounds(i11, data2.f27683n.length, "su_tPos");
            this.su_tPos = this.data.f27683n[this.su_tPos];
            this.su_i2++;
            this.currentState = 6;
            this.crc.c(b11);
            return b11;
        }
        this.currentState = 5;
        endBlock();
        initBlock();
        return setupBlock();
    }

    private int setupNoRandPartB() throws IOException {
        if (this.su_ch2 != this.su_chPrev) {
            this.su_count = 1;
            return setupNoRandPartA();
        }
        int i11 = this.su_count + 1;
        this.su_count = i11;
        if (i11 < 4) {
            return setupNoRandPartA();
        }
        checkBounds(this.su_tPos, this.data.f27684o.length, "su_tPos");
        Data data2 = this.data;
        byte[] bArr = data2.f27684o;
        int i12 = this.su_tPos;
        this.su_z = (char) (bArr[i12] & 255);
        this.su_tPos = data2.f27683n[i12];
        this.su_j2 = 0;
        return setupNoRandPartC();
    }

    private int setupNoRandPartC() throws IOException {
        if (this.su_j2 < this.su_z) {
            int i11 = this.su_ch2;
            this.crc.c(i11);
            this.su_j2++;
            this.currentState = 7;
            return i11;
        }
        this.su_i2++;
        this.su_count = 0;
        return setupNoRandPartA();
    }

    private int setupRandPartA() throws IOException {
        if (this.su_i2 <= this.last) {
            this.su_chPrev = this.su_ch2;
            Data data2 = this.data;
            byte[] bArr = data2.f27684o;
            int i11 = this.su_tPos;
            byte b11 = bArr[i11] & 255;
            checkBounds(i11, data2.f27683n.length, "su_tPos");
            this.su_tPos = this.data.f27683n[this.su_tPos];
            int i12 = this.su_rNToGo;
            byte b12 = 0;
            if (i12 == 0) {
                this.su_rNToGo = Rand.a(this.su_rTPos) - 1;
                int i13 = this.su_rTPos + 1;
                this.su_rTPos = i13;
                if (i13 == 512) {
                    this.su_rTPos = 0;
                }
            } else {
                this.su_rNToGo = i12 - 1;
            }
            if (this.su_rNToGo == 1) {
                b12 = 1;
            }
            byte b13 = b11 ^ b12;
            this.su_ch2 = b13;
            this.su_i2++;
            this.currentState = 3;
            this.crc.c(b13);
            return b13;
        }
        endBlock();
        initBlock();
        return setupBlock();
    }

    private int setupRandPartB() throws IOException {
        if (this.su_ch2 != this.su_chPrev) {
            this.currentState = 2;
            this.su_count = 1;
            return setupRandPartA();
        }
        int i11 = this.su_count + 1;
        this.su_count = i11;
        if (i11 < 4) {
            this.currentState = 2;
            return setupRandPartA();
        }
        Data data2 = this.data;
        byte[] bArr = data2.f27684o;
        int i12 = this.su_tPos;
        this.su_z = (char) (bArr[i12] & 255);
        checkBounds(i12, data2.f27683n.length, "su_tPos");
        this.su_tPos = this.data.f27683n[this.su_tPos];
        int i13 = this.su_rNToGo;
        if (i13 == 0) {
            this.su_rNToGo = Rand.a(this.su_rTPos) - 1;
            int i14 = this.su_rTPos + 1;
            this.su_rTPos = i14;
            if (i14 == 512) {
                this.su_rTPos = 0;
            }
        } else {
            this.su_rNToGo = i13 - 1;
        }
        this.su_j2 = 0;
        this.currentState = 4;
        if (this.su_rNToGo == 1) {
            this.su_z = (char) (this.su_z ^ 1);
        }
        return setupRandPartC();
    }

    private int setupRandPartC() throws IOException {
        if (this.su_j2 < this.su_z) {
            this.crc.c(this.su_ch2);
            this.su_j2++;
            return this.su_ch2;
        }
        this.currentState = 2;
        this.su_i2++;
        this.su_count = 0;
        return setupRandPartA();
    }

    public void close() throws IOException {
        BitInputStream bitInputStream = this.bin;
        if (bitInputStream != null) {
            try {
                bitInputStream.close();
            } finally {
                this.data = null;
                this.bin = null;
            }
        }
    }

    public long getCompressedCount() {
        return this.bin.getBytesRead();
    }

    public int read() throws IOException {
        if (this.bin != null) {
            int read0 = read0();
            count(read0 < 0 ? -1 : 1);
            return read0;
        }
        throw new IOException("Stream closed");
    }

    public BZip2CompressorInputStream(InputStream inputStream, boolean z11) throws IOException {
        this.crc = new CRC();
        this.currentState = 1;
        this.bin = new BitInputStream(inputStream == System.in ? new CloseShieldFilterInputStream(inputStream) : inputStream, ByteOrder.BIG_ENDIAN);
        this.decompressConcatenated = z11;
        init(true);
        initBlock();
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        if (i11 < 0) {
            throw new IndexOutOfBoundsException("offs(" + i11 + ") < 0.");
        } else if (i12 >= 0) {
            int i13 = i11 + i12;
            if (i13 > bArr.length) {
                throw new IndexOutOfBoundsException("offs(" + i11 + ") + len(" + i12 + ") > dest.length(" + bArr.length + ").");
            } else if (this.bin == null) {
                throw new IOException("Stream closed");
            } else if (i12 == 0) {
                return 0;
            } else {
                int i14 = i11;
                while (i14 < i13) {
                    int read0 = read0();
                    if (read0 < 0) {
                        break;
                    }
                    bArr[i14] = (byte) read0;
                    count(1);
                    i14++;
                }
                if (i14 == i11) {
                    return -1;
                }
                return i14 - i11;
            }
        } else {
            throw new IndexOutOfBoundsException("len(" + i12 + ") < 0.");
        }
    }
}
