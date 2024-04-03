package org.apache.commons.compress.compressors.bzip2;

import androidx.core.view.InputDeviceCompat;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import net.bytebuddy.jar.asm.Opcodes;
import org.apache.commons.compress.compressors.CompressorOutputStream;

public class BZip2CompressorOutputStream extends CompressorOutputStream implements BZip2Constants {
    private static final int GREATER_ICOST = 15;
    private static final int LESSER_ICOST = 0;
    public static final int MAX_BLOCKSIZE = 9;
    public static final int MIN_BLOCKSIZE = 1;
    private final int allowableBlockSize;
    private int blockCRC;
    private final int blockSize100k;
    private BlockSort blockSorter;
    private int bsBuff;
    private int bsLive;
    private volatile boolean closed;
    private int combinedCRC;
    private final CRC crc;
    private int currentChar;
    private Data data;
    private int last;
    private int nInUse;
    private int nMTF;
    private OutputStream out;
    private int runLength;

    public static final class Data {

        /* renamed from: a  reason: collision with root package name */
        public final boolean[] f27685a = new boolean[256];

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f27686b = new byte[256];

        /* renamed from: c  reason: collision with root package name */
        public final int[] f27687c = new int[BZip2Constants.MAX_ALPHA_SIZE];

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f27688d = new byte[BZip2Constants.MAX_SELECTORS];

        /* renamed from: e  reason: collision with root package name */
        public final byte[] f27689e = new byte[BZip2Constants.MAX_SELECTORS];

        /* renamed from: f  reason: collision with root package name */
        public final byte[] f27690f = new byte[256];

        /* renamed from: g  reason: collision with root package name */
        public final byte[][] f27691g = ((byte[][]) Array.newInstance(Byte.TYPE, new int[]{6, BZip2Constants.MAX_ALPHA_SIZE}));

        /* renamed from: h  reason: collision with root package name */
        public final int[][] f27692h;

        /* renamed from: i  reason: collision with root package name */
        public final int[] f27693i;

        /* renamed from: j  reason: collision with root package name */
        public final short[] f27694j;

        /* renamed from: k  reason: collision with root package name */
        public final int[][] f27695k;

        /* renamed from: l  reason: collision with root package name */
        public final byte[] f27696l;

        /* renamed from: m  reason: collision with root package name */
        public final boolean[] f27697m;

        /* renamed from: n  reason: collision with root package name */
        public final int[] f27698n;

        /* renamed from: o  reason: collision with root package name */
        public final int[] f27699o;

        /* renamed from: p  reason: collision with root package name */
        public final int[] f27700p;

        /* renamed from: q  reason: collision with root package name */
        public final byte[] f27701q;

        /* renamed from: r  reason: collision with root package name */
        public final int[] f27702r;

        /* renamed from: s  reason: collision with root package name */
        public final char[] f27703s;

        /* renamed from: t  reason: collision with root package name */
        public int f27704t;

        public Data(int i11) {
            int[] iArr = {6, BZip2Constants.MAX_ALPHA_SIZE};
            Class cls = Integer.TYPE;
            this.f27692h = (int[][]) Array.newInstance(cls, iArr);
            this.f27693i = new int[6];
            this.f27694j = new short[6];
            this.f27695k = (int[][]) Array.newInstance(cls, new int[]{6, BZip2Constants.MAX_ALPHA_SIZE});
            this.f27696l = new byte[6];
            this.f27697m = new boolean[16];
            this.f27698n = new int[260];
            this.f27699o = new int[516];
            this.f27700p = new int[516];
            int i12 = i11 * 100000;
            this.f27701q = new byte[(i12 + 1 + 20)];
            this.f27702r = new int[i12];
            this.f27703s = new char[(i12 * 2)];
        }
    }

    public BZip2CompressorOutputStream(OutputStream outputStream) throws IOException {
        this(outputStream, 9);
    }

    private void blockSort() {
        this.blockSorter.a(this.data, this.last);
    }

    private void bsFinishedWithStream() throws IOException {
        while (this.bsLive > 0) {
            this.out.write(this.bsBuff >> 24);
            this.bsBuff <<= 8;
            this.bsLive -= 8;
        }
    }

    private void bsPutInt(int i11) throws IOException {
        bsW(8, (i11 >> 24) & 255);
        bsW(8, (i11 >> 16) & 255);
        bsW(8, (i11 >> 8) & 255);
        bsW(8, i11 & 255);
    }

    private void bsPutUByte(int i11) throws IOException {
        bsW(8, i11);
    }

    private void bsW(int i11, int i12) throws IOException {
        OutputStream outputStream = this.out;
        int i13 = this.bsLive;
        int i14 = this.bsBuff;
        while (i13 >= 8) {
            outputStream.write(i14 >> 24);
            i14 <<= 8;
            i13 -= 8;
        }
        this.bsBuff = (i12 << ((32 - i13) - i11)) | i14;
        this.bsLive = i13 + i11;
    }

    public static int chooseBlockSize(long j11) {
        if (j11 > 0) {
            return (int) Math.min((j11 / 132000) + 1, 9);
        }
        return 9;
    }

    private void endBlock() throws IOException {
        int a11 = this.crc.a();
        this.blockCRC = a11;
        int i11 = this.combinedCRC;
        this.combinedCRC = a11 ^ ((i11 >>> 31) | (i11 << 1));
        if (this.last != -1) {
            blockSort();
            bsPutUByte(49);
            bsPutUByte(65);
            bsPutUByte(89);
            bsPutUByte(38);
            bsPutUByte(83);
            bsPutUByte(89);
            bsPutInt(this.blockCRC);
            bsW(1, 0);
            moveToFrontCodeAndSend();
        }
    }

    private void endCompression() throws IOException {
        bsPutUByte(23);
        bsPutUByte(114);
        bsPutUByte(69);
        bsPutUByte(56);
        bsPutUByte(80);
        bsPutUByte(Opcodes.D2F);
        bsPutInt(this.combinedCRC);
        bsFinishedWithStream();
    }

    private void generateMTFValues() {
        int i11;
        int i12 = this.last;
        Data data2 = this.data;
        boolean[] zArr = data2.f27685a;
        byte[] bArr = data2.f27701q;
        int[] iArr = data2.f27702r;
        char[] cArr = data2.f27703s;
        int[] iArr2 = data2.f27687c;
        byte[] bArr2 = data2.f27686b;
        byte[] bArr3 = data2.f27690f;
        int i13 = 0;
        for (int i14 = 0; i14 < 256; i14++) {
            if (zArr[i14]) {
                bArr2[i14] = (byte) i13;
                i13++;
            }
        }
        this.nInUse = i13;
        int i15 = i13 + 1;
        for (int i16 = i15; i16 >= 0; i16--) {
            iArr2[i16] = 0;
        }
        while (true) {
            i13--;
            if (i13 < 0) {
                break;
            }
            bArr3[i13] = (byte) i13;
        }
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 <= i12; i19++) {
            byte b11 = bArr2[bArr[iArr[i19]] & 255];
            byte b12 = bArr3[0];
            int i21 = 0;
            while (b11 != b12) {
                i21++;
                byte b13 = bArr3[i21];
                bArr3[i21] = b12;
                b12 = b13;
            }
            bArr3[0] = b12;
            if (i21 == 0) {
                i17++;
            } else {
                if (i17 > 0) {
                    int i22 = i17 - 1;
                    while (true) {
                        if ((i22 & 1) == 0) {
                            cArr[i18] = 0;
                            i18++;
                            iArr2[0] = iArr2[0] + 1;
                        } else {
                            cArr[i18] = 1;
                            i18++;
                            iArr2[1] = iArr2[1] + 1;
                        }
                        if (i22 < 2) {
                            break;
                        }
                        i22 = (i22 - 2) >> 1;
                    }
                    i17 = 0;
                }
                int i23 = i21 + 1;
                cArr[i18] = (char) i23;
                i18++;
                iArr2[i23] = iArr2[i23] + 1;
            }
        }
        if (i17 > 0) {
            int i24 = i17 - 1;
            while (true) {
                if ((i24 & 1) == 0) {
                    cArr[i18] = 0;
                    i11 = i18 + 1;
                    iArr2[0] = iArr2[0] + 1;
                } else {
                    cArr[i18] = 1;
                    i11 = i18 + 1;
                    iArr2[1] = iArr2[1] + 1;
                }
                if (i24 < 2) {
                    break;
                }
                i24 = (i24 - 2) >> 1;
            }
        }
        cArr[i18] = (char) i15;
        iArr2[i15] = iArr2[i15] + 1;
        this.nMTF = i18 + 1;
    }

    private static void hbAssignCodes(int[] iArr, byte[] bArr, int i11, int i12, int i13) {
        int i14 = 0;
        while (i11 <= i12) {
            for (int i15 = 0; i15 < i13; i15++) {
                if ((bArr[i15] & 255) == i11) {
                    iArr[i15] = i14;
                    i14++;
                }
            }
            i14 <<= 1;
            i11++;
        }
    }

    private static void hbMakeCodeLengths(byte[] bArr, int[] iArr, Data data2, int i11, int i12) {
        Data data3 = data2;
        int i13 = i11;
        int[] iArr2 = data3.f27698n;
        int[] iArr3 = data3.f27699o;
        int[] iArr4 = data3.f27700p;
        int i14 = i13;
        while (true) {
            i14--;
            int i15 = 1;
            if (i14 < 0) {
                break;
            }
            int i16 = i14 + 1;
            int i17 = iArr[i14];
            if (i17 != 0) {
                i15 = i17;
            }
            iArr3[i16] = i15 << 8;
        }
        boolean z11 = true;
        while (z11) {
            iArr2[0] = 0;
            iArr3[0] = 0;
            iArr4[0] = -2;
            int i18 = 0;
            for (int i19 = 1; i19 <= i13; i19++) {
                iArr4[i19] = -1;
                i18++;
                iArr2[i18] = i19;
                int i21 = i18;
                while (true) {
                    int i22 = iArr3[i19];
                    int i23 = i21 >> 1;
                    int i24 = iArr2[i23];
                    if (i22 >= iArr3[i24]) {
                        break;
                    }
                    iArr2[i21] = i24;
                    i21 = i23;
                }
                iArr2[i21] = i19;
            }
            int i25 = i13;
            while (i18 > 1) {
                int i26 = iArr2[1];
                int i27 = iArr2[i18];
                iArr2[1] = i27;
                int i28 = i18 - 1;
                int i29 = 1;
                while (true) {
                    int i31 = i29 << 1;
                    if (i31 > i28) {
                        break;
                    }
                    if (i31 < i28) {
                        int i32 = i31 + 1;
                        if (iArr3[iArr2[i32]] < iArr3[iArr2[i31]]) {
                            i31 = i32;
                        }
                    }
                    int i33 = iArr3[i27];
                    int i34 = iArr2[i31];
                    if (i33 < iArr3[i34]) {
                        break;
                    }
                    iArr2[i29] = i34;
                    i29 = i31;
                }
                iArr2[i29] = i27;
                int i35 = iArr2[1];
                int i36 = iArr2[i28];
                iArr2[1] = i36;
                int i37 = i28 - 1;
                int i38 = 1;
                while (true) {
                    int i39 = i38 << 1;
                    if (i39 > i37) {
                        break;
                    }
                    if (i39 < i37) {
                        int i41 = i39 + 1;
                        if (iArr3[iArr2[i41]] < iArr3[iArr2[i39]]) {
                            i39 = i41;
                        }
                    }
                    int i42 = iArr3[i36];
                    int i43 = iArr2[i39];
                    if (i42 < iArr3[i43]) {
                        break;
                    }
                    iArr2[i38] = i43;
                    i38 = i39;
                }
                iArr2[i38] = i36;
                i25++;
                iArr4[i35] = i25;
                iArr4[i26] = i25;
                int i44 = iArr3[i26];
                int i45 = iArr3[i35];
                int i46 = (i44 & InputDeviceCompat.SOURCE_ANY) + (i45 & InputDeviceCompat.SOURCE_ANY);
                int i47 = i44 & 255;
                int i48 = i45 & 255;
                if (i47 <= i48) {
                    i47 = i48;
                }
                iArr3[i25] = (i47 + 1) | i46;
                iArr4[i25] = -1;
                i18 = i37 + 1;
                iArr2[i18] = i25;
                int i49 = iArr3[i25];
                int i50 = i18;
                while (true) {
                    int i51 = i50 >> 1;
                    int i52 = iArr2[i51];
                    if (i49 >= iArr3[i52]) {
                        break;
                    }
                    iArr2[i50] = i52;
                    i50 = i51;
                }
                iArr2[i50] = i25;
            }
            z11 = false;
            for (int i53 = 1; i53 <= i13; i53++) {
                int i54 = i53;
                int i55 = 0;
                while (true) {
                    i54 = iArr4[i54];
                    if (i54 < 0) {
                        break;
                    }
                    i55++;
                }
                bArr[i53 - 1] = (byte) i55;
                if (i55 > i12) {
                    z11 = true;
                }
            }
            int i56 = i12;
            if (z11) {
                for (int i57 = 1; i57 < i13; i57++) {
                    iArr3[i57] = (((iArr3[i57] >> 8) >> 1) + 1) << 8;
                }
            }
        }
    }

    private void init() throws IOException {
        bsPutUByte(66);
        bsPutUByte(90);
        this.data = new Data(this.blockSize100k);
        this.blockSorter = new BlockSort(this.data);
        bsPutUByte(104);
        bsPutUByte(this.blockSize100k + 48);
        this.combinedCRC = 0;
        initBlock();
    }

    private void initBlock() {
        this.crc.b();
        this.last = -1;
        boolean[] zArr = this.data.f27685a;
        int i11 = 256;
        while (true) {
            i11--;
            if (i11 >= 0) {
                zArr[i11] = false;
            } else {
                return;
            }
        }
    }

    private void moveToFrontCodeAndSend() throws IOException {
        bsW(24, this.data.f27704t);
        generateMTFValues();
        sendMTFValues();
    }

    private void sendMTFValues() throws IOException {
        byte[][] bArr = this.data.f27691g;
        int i11 = 2;
        int i12 = this.nInUse + 2;
        int i13 = 6;
        while (true) {
            i13--;
            if (i13 < 0) {
                break;
            }
            byte[] bArr2 = bArr[i13];
            int i14 = i12;
            while (true) {
                i14--;
                if (i14 >= 0) {
                    bArr2[i14] = Ascii.SI;
                }
            }
        }
        int i15 = this.nMTF;
        if (i15 >= 200) {
            if (i15 < 600) {
                i11 = 3;
            } else if (i15 < 1200) {
                i11 = 4;
            } else if (i15 < 2400) {
                i11 = 5;
            } else {
                i11 = 6;
            }
        }
        sendMTFValues0(i11, i12);
        int sendMTFValues1 = sendMTFValues1(i11, i12);
        sendMTFValues2(i11, sendMTFValues1);
        sendMTFValues3(i11, i12);
        sendMTFValues4();
        sendMTFValues5(i11, sendMTFValues1);
        sendMTFValues6(i11, i12);
        sendMTFValues7();
    }

    private void sendMTFValues0(int i11, int i12) {
        Data data2 = this.data;
        byte[][] bArr = data2.f27691g;
        int[] iArr = data2.f27687c;
        int i13 = this.nMTF;
        int i14 = 0;
        for (int i15 = i11; i15 > 0; i15--) {
            int i16 = i13 / i15;
            int i17 = i14 - 1;
            int i18 = i12 - 1;
            int i19 = 0;
            while (i19 < i16 && i17 < i18) {
                i17++;
                i19 += iArr[i17];
            }
            if (!(i17 <= i14 || i15 == i11 || i15 == 1 || (1 & (i11 - i15)) == 0)) {
                i19 -= iArr[i17];
                i17--;
            }
            byte[] bArr2 = bArr[i15 - 1];
            int i21 = i12;
            while (true) {
                i21--;
                if (i21 < 0) {
                    break;
                } else if (i21 < i14 || i21 > i17) {
                    bArr2[i21] = Ascii.SI;
                } else {
                    bArr2[i21] = 0;
                }
            }
            i14 = i17 + 1;
            i13 -= i19;
        }
    }

    private int sendMTFValues1(int i11, int i12) {
        byte[] bArr;
        int i13;
        BZip2CompressorOutputStream bZip2CompressorOutputStream = this;
        int i14 = i11;
        Data data2 = bZip2CompressorOutputStream.data;
        int[][] iArr = data2.f27692h;
        int[] iArr2 = data2.f27693i;
        short[] sArr = data2.f27694j;
        char[] cArr = data2.f27703s;
        byte[] bArr2 = data2.f27688d;
        byte[][] bArr3 = data2.f27691g;
        int i15 = 0;
        byte[] bArr4 = bArr3[0];
        byte[] bArr5 = bArr3[1];
        byte[] bArr6 = bArr3[2];
        byte[] bArr7 = bArr3[3];
        int i16 = 4;
        byte[] bArr8 = bArr3[4];
        byte[] bArr9 = bArr3[5];
        int i17 = bZip2CompressorOutputStream.nMTF;
        int i18 = 0;
        int i19 = 0;
        while (i18 < i16) {
            int i21 = i14;
            while (true) {
                i21--;
                if (i21 < 0) {
                    break;
                }
                iArr2[i21] = i15;
                int[] iArr3 = iArr[i21];
                int i22 = i12;
                while (true) {
                    i22--;
                    if (i22 >= 0) {
                        iArr3[i22] = i15;
                    }
                }
            }
            int i23 = i15;
            i19 = i23;
            while (i23 < bZip2CompressorOutputStream.nMTF) {
                int i24 = i23;
                int min = Math.min((i23 + 50) - 1, i17 - 1);
                if (i14 == 6) {
                    int i25 = i24;
                    short s11 = 0;
                    short s12 = 0;
                    short s13 = 0;
                    short s14 = 0;
                    short s15 = 0;
                    short s16 = 0;
                    while (i25 <= min) {
                        char c11 = cArr[i25];
                        short s17 = (short) (s12 + (bArr5[c11] & 255));
                        short s18 = (short) (s13 + (bArr6[c11] & 255));
                        short s19 = (short) (s14 + (bArr7[c11] & 255));
                        short s21 = (short) (s15 + (bArr8[c11] & 255));
                        i25++;
                        s16 = (short) (s16 + (bArr9[c11] & 255));
                        s15 = s21;
                        bArr4 = bArr4;
                        s14 = s19;
                        s13 = s18;
                        s12 = s17;
                        s11 = (short) (s11 + (bArr4[c11] & 255));
                        i17 = i17;
                    }
                    bArr = bArr4;
                    i13 = i17;
                    sArr[0] = s11;
                    sArr[1] = s12;
                    sArr[2] = s13;
                    sArr[3] = s14;
                    sArr[4] = s15;
                    sArr[5] = s16;
                } else {
                    bArr = bArr4;
                    i13 = i17;
                    int i26 = i14;
                    while (true) {
                        i26--;
                        if (i26 < 0) {
                            break;
                        }
                        sArr[i26] = 0;
                    }
                    for (int i27 = i24; i27 <= min; i27++) {
                        char c12 = cArr[i27];
                        int i28 = i14;
                        while (true) {
                            i28--;
                            if (i28 < 0) {
                                break;
                            }
                            sArr[i28] = (short) (sArr[i28] + (bArr3[i28][c12] & 255));
                        }
                    }
                }
                short s22 = 999999999;
                int i29 = i14;
                int i31 = -1;
                while (true) {
                    i29--;
                    if (i29 < 0) {
                        break;
                    }
                    byte[] bArr10 = bArr5;
                    short s23 = sArr[i29];
                    if (s23 < s22) {
                        s22 = s23;
                        i31 = i29;
                    }
                    bArr5 = bArr10;
                }
                byte[] bArr11 = bArr5;
                iArr2[i31] = iArr2[i31] + 1;
                bArr2[i19] = (byte) i31;
                i19++;
                int[] iArr4 = iArr[i31];
                for (int i32 = i24; i32 <= min; i32++) {
                    char c13 = cArr[i32];
                    iArr4[c13] = iArr4[c13] + 1;
                }
                i23 = min + 1;
                bArr5 = bArr11;
                i17 = i13;
                bArr4 = bArr;
            }
            byte[] bArr12 = bArr4;
            byte[] bArr13 = bArr5;
            int i33 = i17;
            int i34 = 0;
            while (i34 < i14) {
                hbMakeCodeLengths(bArr3[i34], iArr[i34], bZip2CompressorOutputStream.data, i12, 20);
                i34++;
                bZip2CompressorOutputStream = this;
            }
            int i35 = i12;
            i18++;
            i15 = 0;
            bZip2CompressorOutputStream = this;
            i16 = 4;
            bArr5 = bArr13;
            i17 = i33;
            bArr4 = bArr12;
        }
        return i19;
    }

    private void sendMTFValues2(int i11, int i12) {
        Data data2 = this.data;
        byte[] bArr = data2.f27696l;
        while (true) {
            i11--;
            if (i11 < 0) {
                break;
            }
            bArr[i11] = (byte) i11;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            byte b11 = data2.f27688d[i13];
            byte b12 = bArr[0];
            int i14 = 0;
            while (b11 != b12) {
                i14++;
                byte b13 = bArr[i14];
                bArr[i14] = b12;
                b12 = b13;
            }
            bArr[0] = b12;
            data2.f27689e[i13] = (byte) i14;
        }
    }

    private void sendMTFValues3(int i11, int i12) {
        Data data2 = this.data;
        int[][] iArr = data2.f27695k;
        byte[][] bArr = data2.f27691g;
        for (int i13 = 0; i13 < i11; i13++) {
            byte[] bArr2 = bArr[i13];
            byte b11 = 32;
            int i14 = i12;
            byte b12 = 0;
            while (true) {
                i14--;
                if (i14 < 0) {
                    break;
                }
                byte b13 = bArr2[i14] & 255;
                if (b13 > b12) {
                    b12 = b13;
                }
                if (b13 < b11) {
                    b11 = b13;
                }
            }
            hbAssignCodes(iArr[i13], bArr[i13], b11, b12, i12);
        }
    }

    private void sendMTFValues4() throws IOException {
        Data data2 = this.data;
        boolean[] zArr = data2.f27685a;
        boolean[] zArr2 = data2.f27697m;
        int i11 = 16;
        while (true) {
            i11--;
            if (i11 < 0) {
                break;
            }
            zArr2[i11] = false;
            int i12 = i11 * 16;
            int i13 = 16;
            while (true) {
                i13--;
                if (i13 >= 0) {
                    if (zArr[i12 + i13]) {
                        zArr2[i11] = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        for (int i14 = 0; i14 < 16; i14++) {
            bsW(1, zArr2[i14] ? 1 : 0);
        }
        OutputStream outputStream = this.out;
        int i15 = this.bsLive;
        int i16 = this.bsBuff;
        for (int i17 = 0; i17 < 16; i17++) {
            if (zArr2[i17]) {
                int i18 = i17 * 16;
                for (int i19 = 0; i19 < 16; i19++) {
                    while (i15 >= 8) {
                        outputStream.write(i16 >> 24);
                        i16 <<= 8;
                        i15 -= 8;
                    }
                    if (zArr[i18 + i19]) {
                        i16 |= 1 << ((32 - i15) - 1);
                    }
                    i15++;
                }
            }
        }
        this.bsBuff = i16;
        this.bsLive = i15;
    }

    private void sendMTFValues5(int i11, int i12) throws IOException {
        bsW(3, i11);
        bsW(15, i12);
        OutputStream outputStream = this.out;
        byte[] bArr = this.data.f27689e;
        int i13 = this.bsLive;
        int i14 = this.bsBuff;
        for (int i15 = 0; i15 < i12; i15++) {
            byte b11 = bArr[i15] & 255;
            for (int i16 = 0; i16 < b11; i16++) {
                while (i13 >= 8) {
                    outputStream.write(i14 >> 24);
                    i14 <<= 8;
                    i13 -= 8;
                }
                i14 |= 1 << ((32 - i13) - 1);
                i13++;
            }
            while (i13 >= 8) {
                outputStream.write(i14 >> 24);
                i14 <<= 8;
                i13 -= 8;
            }
            i13++;
        }
        this.bsBuff = i14;
        this.bsLive = i13;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void sendMTFValues6(int r18, int r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream$Data r1 = r0.data
            byte[][] r1 = r1.f27691g
            java.io.OutputStream r2 = r0.out
            int r3 = r0.bsLive
            int r4 = r0.bsBuff
            r5 = 0
            r6 = r18
            r7 = r5
        L_0x0010:
            if (r7 >= r6) goto L_0x0080
            r8 = r1[r7]
            byte r9 = r8[r5]
            r9 = r9 & 255(0xff, float:3.57E-43)
        L_0x0018:
            r10 = 8
            if (r3 < r10) goto L_0x0026
            int r10 = r4 >> 24
            r2.write(r10)
            int r4 = r4 << 8
            int r3 = r3 + -8
            goto L_0x0018
        L_0x0026:
            int r11 = 32 - r3
            int r11 = r11 + -5
            int r11 = r9 << r11
            r4 = r4 | r11
            int r3 = r3 + 5
            r11 = r19
            r12 = r5
        L_0x0032:
            if (r12 >= r11) goto L_0x007d
            byte r13 = r8[r12]
            r13 = r13 & 255(0xff, float:3.57E-43)
        L_0x0038:
            r14 = 2
            if (r9 >= r13) goto L_0x0051
        L_0x003b:
            if (r3 < r10) goto L_0x0047
            int r15 = r4 >> 24
            r2.write(r15)
            int r4 = r4 << 8
            int r3 = r3 + -8
            goto L_0x003b
        L_0x0047:
            int r15 = 32 - r3
            int r15 = r15 - r14
            int r14 = r14 << r15
            r4 = r4 | r14
            int r3 = r3 + 2
            int r9 = r9 + 1
            goto L_0x0038
        L_0x0051:
            if (r9 <= r13) goto L_0x006c
        L_0x0053:
            if (r3 < r10) goto L_0x005f
            int r15 = r4 >> 24
            r2.write(r15)
            int r4 = r4 << 8
            int r3 = r3 + -8
            goto L_0x0053
        L_0x005f:
            int r15 = 32 - r3
            int r15 = r15 - r14
            r16 = 3
            int r15 = r16 << r15
            r4 = r4 | r15
            int r3 = r3 + 2
            int r9 = r9 + -1
            goto L_0x0051
        L_0x006c:
            if (r3 < r10) goto L_0x0078
            int r13 = r4 >> 24
            r2.write(r13)
            int r4 = r4 << 8
            int r3 = r3 + -8
            goto L_0x006c
        L_0x0078:
            int r3 = r3 + 1
            int r12 = r12 + 1
            goto L_0x0032
        L_0x007d:
            int r7 = r7 + 1
            goto L_0x0010
        L_0x0080:
            r0.bsBuff = r4
            r0.bsLive = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream.sendMTFValues6(int, int):void");
    }

    private void sendMTFValues7() throws IOException {
        Data data2 = this.data;
        byte[][] bArr = data2.f27691g;
        int[][] iArr = data2.f27695k;
        OutputStream outputStream = this.out;
        byte[] bArr2 = data2.f27688d;
        char[] cArr = data2.f27703s;
        int i11 = this.nMTF;
        int i12 = this.bsLive;
        int i13 = this.bsBuff;
        int i14 = 0;
        int i15 = 0;
        while (i14 < i11) {
            int min = Math.min((i14 + 50) - 1, i11 - 1);
            byte b11 = bArr2[i15] & 255;
            int[] iArr2 = iArr[b11];
            byte[] bArr3 = bArr[b11];
            while (i14 <= min) {
                char c11 = cArr[i14];
                while (i12 >= 8) {
                    outputStream.write(i13 >> 24);
                    i13 <<= 8;
                    i12 -= 8;
                }
                byte b12 = bArr3[c11] & 255;
                i13 |= iArr2[c11] << ((32 - i12) - b12);
                i12 += b12;
                i14++;
            }
            i14 = min + 1;
            i15++;
        }
        this.bsBuff = i13;
        this.bsLive = i12;
    }

    private void write0(int i11) throws IOException {
        int i12 = this.currentChar;
        if (i12 != -1) {
            int i13 = i11 & 255;
            if (i12 == i13) {
                int i14 = this.runLength + 1;
                this.runLength = i14;
                if (i14 > 254) {
                    writeRun();
                    this.currentChar = -1;
                    this.runLength = 0;
                    return;
                }
                return;
            }
            writeRun();
            this.runLength = 1;
            this.currentChar = i13;
            return;
        }
        this.currentChar = i11 & 255;
        this.runLength++;
    }

    private void writeRun() throws IOException {
        int i11 = this.last;
        if (i11 < this.allowableBlockSize) {
            int i12 = this.currentChar;
            Data data2 = this.data;
            data2.f27685a[i12] = true;
            byte b11 = (byte) i12;
            int i13 = this.runLength;
            this.crc.d(i12, i13);
            if (i13 == 1) {
                data2.f27701q[i11 + 2] = b11;
                this.last = i11 + 1;
            } else if (i13 == 2) {
                byte[] bArr = data2.f27701q;
                int i14 = i11 + 2;
                bArr[i14] = b11;
                bArr[i11 + 3] = b11;
                this.last = i14;
            } else if (i13 != 3) {
                int i15 = i13 - 4;
                data2.f27685a[i15] = true;
                byte[] bArr2 = data2.f27701q;
                bArr2[i11 + 2] = b11;
                bArr2[i11 + 3] = b11;
                bArr2[i11 + 4] = b11;
                int i16 = i11 + 5;
                bArr2[i16] = b11;
                bArr2[i11 + 6] = (byte) i15;
                this.last = i16;
            } else {
                byte[] bArr3 = data2.f27701q;
                bArr3[i11 + 2] = b11;
                int i17 = i11 + 3;
                bArr3[i17] = b11;
                bArr3[i11 + 4] = b11;
                this.last = i17;
            }
        } else {
            endBlock();
            initBlock();
            writeRun();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0011, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0012, code lost:
        if (r0 != null) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0018, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0019, code lost:
        r1.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001c, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() throws java.io.IOException {
        /*
            r3 = this;
            boolean r0 = r3.closed
            if (r0 != 0) goto L_0x001d
            java.io.OutputStream r0 = r3.out
            r3.finish()     // Catch:{ all -> 0x000f }
            if (r0 == 0) goto L_0x001d
            r0.close()
            goto L_0x001d
        L_0x000f:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0011 }
        L_0x0011:
            r2 = move-exception
            if (r0 == 0) goto L_0x001c
            r0.close()     // Catch:{ all -> 0x0018 }
            goto L_0x001c
        L_0x0018:
            r0 = move-exception
            r1.addSuppressed(r0)
        L_0x001c:
            throw r2
        L_0x001d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream.close():void");
    }

    public void finalize() throws Throwable {
        if (!this.closed) {
            System.err.println("Unclosed BZip2CompressorOutputStream detected, will *not* close it");
        }
        super.finalize();
    }

    public void finish() throws IOException {
        if (!this.closed) {
            this.closed = true;
            try {
                if (this.runLength > 0) {
                    writeRun();
                }
                this.currentChar = -1;
                endBlock();
                endCompression();
            } finally {
                this.out = null;
                this.blockSorter = null;
                this.data = null;
            }
        }
    }

    public void flush() throws IOException {
        OutputStream outputStream = this.out;
        if (outputStream != null) {
            outputStream.flush();
        }
    }

    public final int getBlockSize() {
        return this.blockSize100k;
    }

    public void write(int i11) throws IOException {
        if (!this.closed) {
            write0(i11);
            return;
        }
        throw new IOException("Closed");
    }

    public BZip2CompressorOutputStream(OutputStream outputStream, int i11) throws IOException {
        this.crc = new CRC();
        this.currentChar = -1;
        if (i11 < 1) {
            throw new IllegalArgumentException("blockSize(" + i11 + ") < 1");
        } else if (i11 <= 9) {
            this.blockSize100k = i11;
            this.out = outputStream;
            this.allowableBlockSize = (i11 * 100000) - 20;
            init();
        } else {
            throw new IllegalArgumentException("blockSize(" + i11 + ") > 9");
        }
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        if (i11 < 0) {
            throw new IndexOutOfBoundsException("offs(" + i11 + ") < 0.");
        } else if (i12 >= 0) {
            int i13 = i11 + i12;
            if (i13 > bArr.length) {
                throw new IndexOutOfBoundsException("offs(" + i11 + ") + len(" + i12 + ") > buf.length(" + bArr.length + ").");
            } else if (!this.closed) {
                while (i11 < i13) {
                    write0(bArr[i11]);
                    i11++;
                }
            } else {
                throw new IOException("Stream closed");
            }
        } else {
            throw new IndexOutOfBoundsException("len(" + i12 + ") < 0.");
        }
    }
}
