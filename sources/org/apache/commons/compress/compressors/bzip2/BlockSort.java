package org.apache.commons.compress.compressors.bzip2;

import android.support.v4.media.session.PlaybackStateCompat;
import java.util.BitSet;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;

class BlockSort {
    private static final int CLEARMASK = -2097153;
    private static final int DEPTH_THRESH = 10;
    private static final int FALLBACK_QSORT_SMALL_THRESH = 10;
    private static final int FALLBACK_QSORT_STACK_SIZE = 100;
    private static final int[] INCS = {1, 4, 13, 40, 121, 364, 1093, 3280, 9841, 29524, 88573, 265720, 797161, 2391484};
    private static final int QSORT_STACK_SIZE = 1000;
    private static final int SETMASK = 2097152;
    private static final int SMALL_THRESH = 20;
    private static final int STACK_SIZE = 1000;
    private static final int WORK_FACTOR = 30;
    private int[] eclass;
    private boolean firstAttempt;
    private final int[] ftab = new int[65537];
    private final boolean[] mainSort_bigDone = new boolean[256];
    private final int[] mainSort_copy = new int[256];
    private final int[] mainSort_runningOrder = new int[256];
    private final char[] quadrant;
    private final int[] stack_dd = new int[1000];
    private final int[] stack_hh = new int[1000];
    private final int[] stack_ll = new int[1000];
    private int workDone;
    private int workLimit;

    public BlockSort(BZip2CompressorOutputStream.Data data) {
        this.quadrant = data.f27703s;
    }

    private void fallbackQSort3(int[] iArr, int[] iArr2, int i11, int i12) {
        int i13;
        int i14;
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        char c11 = 0;
        fpush(0, i11, i12);
        long j11 = 0;
        int i15 = 1;
        long j12 = 0;
        int i16 = 1;
        while (i16 > 0) {
            i16--;
            int[] fpop = fpop(i16);
            int i17 = fpop[c11];
            int i18 = fpop[i15];
            if (i18 - i17 < 10) {
                fallbackSimpleSort(iArr3, iArr4, i17, i18);
            } else {
                j12 = ((j12 * 7621) + 1) % PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                long j13 = j12 % 3;
                if (j13 == j11) {
                    i13 = iArr4[iArr3[i17]];
                } else if (j13 == 1) {
                    i13 = iArr4[iArr3[(i17 + i18) >>> i15]];
                } else {
                    i13 = iArr4[iArr3[i18]];
                }
                long j14 = (long) i13;
                int i19 = i18;
                int i21 = i19;
                int i22 = i17;
                int i23 = i22;
                while (true) {
                    if (i23 <= i19) {
                        int i24 = iArr4[iArr3[i23]] - ((int) j14);
                        if (i24 == 0) {
                            fswap(iArr3, i23, i22);
                            i22++;
                        } else if (i24 <= 0) {
                            int i25 = i15;
                        }
                        i23++;
                    }
                    i14 = i21;
                    while (i23 <= i19) {
                        int i26 = iArr4[iArr3[i19]] - ((int) j14);
                        if (i26 == 0) {
                            fswap(iArr3, i19, i14);
                            i14--;
                            i19--;
                        } else if (i26 < 0) {
                            break;
                        } else {
                            i19--;
                        }
                    }
                    if (i23 > i19) {
                        break;
                    }
                    fswap(iArr3, i23, i19);
                    i23++;
                    i19--;
                    i21 = i14;
                    i15 = 1;
                }
                if (i14 < i22) {
                    c11 = 0;
                    j11 = 0;
                    i15 = 1;
                } else {
                    int fmin = fmin(i22 - i17, i23 - i22);
                    fvswap(iArr3, i17, i23 - fmin, fmin);
                    int i27 = i18 - i14;
                    int i28 = i14 - i19;
                    int fmin2 = fmin(i27, i28);
                    fvswap(iArr3, i19 + 1, (i18 - fmin2) + 1, fmin2);
                    int i29 = ((i23 + i17) - i22) - 1;
                    int i31 = (i18 - i28) + 1;
                    if (i29 - i17 > i18 - i31) {
                        int i32 = i16 + 1;
                        fpush(i16, i17, i29);
                        fpush(i32, i31, i18);
                        i16 = i32 + 1;
                    } else {
                        int i33 = i16 + 1;
                        fpush(i16, i31, i18);
                        fpush(i33, i17, i29);
                        i16 = i33 + 1;
                    }
                    i15 = 1;
                    c11 = 0;
                    j11 = 0;
                }
            }
        }
    }

    private void fallbackSimpleSort(int[] iArr, int[] iArr2, int i11, int i12) {
        if (i11 != i12) {
            if (i12 - i11 > 3) {
                for (int i13 = i12 - 4; i13 >= i11; i13--) {
                    int i14 = iArr[i13];
                    int i15 = iArr2[i14];
                    int i16 = i13 + 4;
                    while (i16 <= i12) {
                        int i17 = iArr[i16];
                        if (i15 <= iArr2[i17]) {
                            break;
                        }
                        iArr[i16 - 4] = i17;
                        i16 += 4;
                    }
                    iArr[i16 - 4] = i14;
                }
            }
            for (int i18 = i12 - 1; i18 >= i11; i18--) {
                int i19 = iArr[i18];
                int i21 = iArr2[i19];
                int i22 = i18 + 1;
                while (i22 <= i12) {
                    int i23 = iArr[i22];
                    if (i21 <= iArr2[i23]) {
                        break;
                    }
                    iArr[i22 - 1] = i23;
                    i22++;
                }
                iArr[i22 - 1] = i19;
            }
        }
    }

    private int fmin(int i11, int i12) {
        return i11 < i12 ? i11 : i12;
    }

    private int[] fpop(int i11) {
        return new int[]{this.stack_ll[i11], this.stack_hh[i11]};
    }

    private void fpush(int i11, int i12, int i13) {
        this.stack_ll[i11] = i12;
        this.stack_hh[i11] = i13;
    }

    private void fswap(int[] iArr, int i11, int i12) {
        int i13 = iArr[i11];
        iArr[i11] = iArr[i12];
        iArr[i12] = i13;
    }

    private void fvswap(int[] iArr, int i11, int i12, int i13) {
        while (i13 > 0) {
            fswap(iArr, i11, i12);
            i11++;
            i12++;
            i13--;
        }
    }

    private int[] getEclass() {
        if (this.eclass == null) {
            this.eclass = new int[(this.quadrant.length / 2)];
        }
        return this.eclass;
    }

    private void mainQSort3(BZip2CompressorOutputStream.Data data, int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        BZip2CompressorOutputStream.Data data2 = data;
        int[] iArr = this.stack_ll;
        int[] iArr2 = this.stack_hh;
        int[] iArr3 = this.stack_dd;
        int[] iArr4 = data2.f27702r;
        byte[] bArr = data2.f27701q;
        iArr[0] = i11;
        iArr2[0] = i12;
        iArr3[0] = i13;
        int i17 = 1;
        int i18 = 1;
        while (true) {
            int i19 = i18 - 1;
            if (i19 >= 0) {
                int i21 = iArr[i19];
                int i22 = iArr2[i19];
                int i23 = iArr3[i19];
                if (i22 - i21 < 20 || i23 > 10) {
                    i15 = i17;
                    if (mainSimpleSort(data, i21, i22, i23, i14)) {
                        return;
                    }
                } else {
                    int i24 = i23 + 1;
                    byte med3 = med3(bArr[iArr4[i21] + i24], bArr[iArr4[i22] + i24], bArr[iArr4[(i21 + i22) >>> i17] + i24]) & 255;
                    int i25 = i21;
                    int i26 = i25;
                    int i27 = i22;
                    int i28 = i27;
                    while (true) {
                        if (i25 <= i27) {
                            int i29 = iArr4[i25];
                            int i31 = (bArr[i29 + i24] & 255) - med3;
                            if (i31 == 0) {
                                iArr4[i25] = iArr4[i26];
                                iArr4[i26] = i29;
                                i26++;
                                i25++;
                            } else if (i31 < 0) {
                                i25++;
                            }
                        }
                        i16 = i28;
                        while (i25 <= i27) {
                            int i32 = iArr4[i27];
                            int i33 = (bArr[i32 + i24] & 255) - med3;
                            if (i33 != 0) {
                                if (i33 <= 0) {
                                    break;
                                }
                                i27--;
                            } else {
                                iArr4[i27] = iArr4[i16];
                                iArr4[i16] = i32;
                                i16--;
                                i27--;
                            }
                            BZip2CompressorOutputStream.Data data3 = data;
                        }
                        if (i25 > i27) {
                            break;
                        }
                        int i34 = iArr4[i25];
                        iArr4[i25] = iArr4[i27];
                        iArr4[i27] = i34;
                        BZip2CompressorOutputStream.Data data4 = data;
                        i27--;
                        i28 = i16;
                        i25++;
                    }
                    if (i16 < i26) {
                        iArr[i19] = i21;
                        iArr2[i19] = i22;
                        iArr3[i19] = i24;
                        i18 = i19 + 1;
                        i15 = 1;
                        BZip2CompressorOutputStream.Data data5 = data;
                        i17 = i15;
                    } else {
                        int i35 = i26 - i21;
                        int i36 = i25 - i26;
                        if (i35 >= i36) {
                            i35 = i36;
                        }
                        vswap(iArr4, i21, i25 - i35, i35);
                        int i37 = i22 - i16;
                        int i38 = i16 - i27;
                        if (i37 >= i38) {
                            i37 = i38;
                        }
                        i15 = 1;
                        vswap(iArr4, i25, (i22 - i37) + 1, i37);
                        int i39 = ((i25 + i21) - i26) - 1;
                        int i41 = (i22 - i38) + 1;
                        iArr[i19] = i21;
                        iArr2[i19] = i39;
                        iArr3[i19] = i23;
                        int i42 = i19 + 1;
                        iArr[i42] = i39 + 1;
                        iArr2[i42] = i41 - 1;
                        iArr3[i42] = i24;
                        int i43 = i42 + 1;
                        iArr[i43] = i41;
                        iArr2[i43] = i22;
                        iArr3[i43] = i23;
                        i19 = i43 + 1;
                    }
                }
                i18 = i19;
                BZip2CompressorOutputStream.Data data52 = data;
                i17 = i15;
            } else {
                return;
            }
        }
    }

    private boolean mainSimpleSort(BZip2CompressorOutputStream.Data data, int i11, int i12, int i13, int i14) {
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        BZip2CompressorOutputStream.Data data2 = data;
        int i22 = i12;
        int i23 = (i22 - i11) + 1;
        if (i23 < 2) {
            return this.firstAttempt && this.workDone > this.workLimit;
        }
        int i24 = 0;
        while (INCS[i15] < i23) {
            i24 = i15 + 1;
        }
        int[] iArr = data2.f27702r;
        char[] cArr = this.quadrant;
        byte[] bArr = data2.f27701q;
        int i25 = i14 + 1;
        boolean z11 = this.firstAttempt;
        int i26 = this.workLimit;
        int i27 = this.workDone;
        loop1:
        while (true) {
            i15--;
            if (i15 < 0) {
                break;
            }
            int i28 = INCS[i15];
            int i29 = i11 + i28;
            int i31 = i29 - 1;
            while (i29 <= i22) {
                int i32 = 3;
                while (i29 <= i22) {
                    int i33 = i32 - 1;
                    if (i33 < 0) {
                        break;
                    }
                    int i34 = iArr[i29];
                    int i35 = i34 + i13;
                    int i36 = i29;
                    boolean z12 = false;
                    int i37 = 0;
                    while (true) {
                        if (z12) {
                            iArr[i36] = i37;
                            i21 = i36 - i28;
                            if (i21 <= i31) {
                                i19 = i15;
                                i17 = i28;
                                i16 = i31;
                                i18 = i33;
                                break;
                            }
                            i36 = i21;
                        } else {
                            z12 = true;
                        }
                        int i38 = iArr[i36 - i28];
                        int i39 = i38 + i13;
                        byte b11 = bArr[i39 + 1];
                        int i41 = i38;
                        byte b12 = bArr[i35 + 1];
                        if (b11 != b12) {
                            i19 = i15;
                            i17 = i28;
                            i16 = i31;
                            i18 = i33;
                            if ((b11 & 255) <= (b12 & 255)) {
                                break;
                            }
                        } else {
                            byte b13 = bArr[i39 + 2];
                            byte b14 = bArr[i35 + 2];
                            if (b13 != b14) {
                                i19 = i15;
                                i17 = i28;
                                i16 = i31;
                                i18 = i33;
                                if ((b13 & 255) <= (b14 & 255)) {
                                    break;
                                }
                            } else {
                                byte b15 = bArr[i39 + 3];
                                byte b16 = bArr[i35 + 3];
                                if (b15 != b16) {
                                    i19 = i15;
                                    i17 = i28;
                                    i16 = i31;
                                    i18 = i33;
                                    if ((b15 & 255) <= (b16 & 255)) {
                                        break;
                                    }
                                } else {
                                    byte b17 = bArr[i39 + 4];
                                    byte b18 = bArr[i35 + 4];
                                    if (b17 != b18) {
                                        i19 = i15;
                                        i17 = i28;
                                        i16 = i31;
                                        i18 = i33;
                                        if ((b17 & 255) <= (b18 & 255)) {
                                            break;
                                        }
                                    } else {
                                        byte b19 = bArr[i39 + 5];
                                        byte b21 = bArr[i35 + 5];
                                        if (b19 != b21) {
                                            i19 = i15;
                                            i17 = i28;
                                            i16 = i31;
                                            i18 = i33;
                                            if ((b19 & 255) <= (b21 & 255)) {
                                                break;
                                            }
                                        } else {
                                            int i42 = i39 + 6;
                                            byte b22 = bArr[i42];
                                            int i43 = i35 + 6;
                                            i19 = i15;
                                            byte b23 = bArr[i43];
                                            if (b22 != b23) {
                                                i17 = i28;
                                                i16 = i31;
                                                i18 = i33;
                                                if ((b22 & 255) <= (b23 & 255)) {
                                                    break;
                                                }
                                            } else {
                                                int i44 = i14;
                                                while (true) {
                                                    if (i44 <= 0) {
                                                        i17 = i28;
                                                        i16 = i31;
                                                        i18 = i33;
                                                        break;
                                                    }
                                                    int i45 = i42 + 1;
                                                    int i46 = i44 - 4;
                                                    byte b24 = bArr[i45];
                                                    int i47 = i43 + 1;
                                                    i17 = i28;
                                                    byte b25 = bArr[i47];
                                                    if (b24 != b25) {
                                                        i16 = i31;
                                                        i18 = i33;
                                                        if ((b24 & 255) <= (b25 & 255)) {
                                                            break;
                                                        }
                                                    } else {
                                                        char c11 = cArr[i42];
                                                        char c12 = cArr[i43];
                                                        if (c11 != c12) {
                                                            i16 = i31;
                                                            i18 = i33;
                                                            if (c11 <= c12) {
                                                                break;
                                                            }
                                                        } else {
                                                            int i48 = i42 + 2;
                                                            byte b26 = bArr[i48];
                                                            int i49 = i43 + 2;
                                                            i16 = i31;
                                                            byte b27 = bArr[i49];
                                                            if (b26 != b27) {
                                                                i18 = i33;
                                                                if ((b26 & 255) <= (b27 & 255)) {
                                                                    break;
                                                                }
                                                            } else {
                                                                char c13 = cArr[i45];
                                                                char c14 = cArr[i47];
                                                                if (c13 != c14) {
                                                                    i18 = i33;
                                                                    if (c13 <= c14) {
                                                                        break;
                                                                    }
                                                                } else {
                                                                    int i50 = i42 + 3;
                                                                    byte b28 = bArr[i50];
                                                                    int i51 = i43 + 3;
                                                                    i18 = i33;
                                                                    byte b29 = bArr[i51];
                                                                    if (b28 != b29) {
                                                                        if ((b28 & 255) <= (b29 & 255)) {
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        char c15 = cArr[i48];
                                                                        char c16 = cArr[i49];
                                                                        if (c15 != c16) {
                                                                            if (c15 <= c16) {
                                                                                break;
                                                                            }
                                                                        } else {
                                                                            int i52 = i42 + 4;
                                                                            byte b31 = bArr[i52];
                                                                            i43 += 4;
                                                                            byte b32 = bArr[i43];
                                                                            if (b31 != b32) {
                                                                                if ((b31 & 255) <= (b32 & 255)) {
                                                                                    break;
                                                                                }
                                                                            } else {
                                                                                char c17 = cArr[i50];
                                                                                char c18 = cArr[i51];
                                                                                if (c17 != c18) {
                                                                                    if (c17 <= c18) {
                                                                                        break;
                                                                                    }
                                                                                } else {
                                                                                    if (i52 >= i25) {
                                                                                        i52 -= i25;
                                                                                    }
                                                                                    i42 = i52;
                                                                                    if (i43 >= i25) {
                                                                                        i43 -= i25;
                                                                                    }
                                                                                    i27++;
                                                                                    i44 = i46;
                                                                                    i33 = i18;
                                                                                    i28 = i17;
                                                                                    i31 = i16;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i37 = i41;
                        i15 = i19;
                        i33 = i18;
                        i28 = i17;
                        i31 = i16;
                    }
                    i21 = i36;
                    iArr[i21] = i34;
                    i29++;
                    i15 = i19;
                    i32 = i18;
                    i28 = i17;
                    i31 = i16;
                }
                int i53 = i15;
                int i54 = i28;
                int i55 = i31;
                if (z11 && i29 <= i22 && i27 > i26) {
                    break loop1;
                }
                i15 = i53;
                i28 = i54;
                i31 = i55;
            }
            int i56 = i15;
        }
        this.workDone = i27;
        return z11 && i27 > i26;
    }

    private static byte med3(byte b11, byte b12, byte b13) {
        if (b11 < b12) {
            if (b12 >= b13) {
                if (b11 >= b13) {
                    return b11;
                }
                return b13;
            }
        } else if (b12 <= b13) {
            if (b11 <= b13) {
                return b11;
            }
            return b13;
        }
        return b12;
    }

    private static void vswap(int[] iArr, int i11, int i12, int i13) {
        int i14 = i13 + i11;
        while (i11 < i14) {
            int i15 = iArr[i11];
            iArr[i11] = iArr[i12];
            iArr[i12] = i15;
            i12++;
            i11++;
        }
    }

    public void a(BZip2CompressorOutputStream.Data data, int i11) {
        this.workLimit = i11 * 30;
        this.workDone = 0;
        this.firstAttempt = true;
        if (i11 + 1 < 10000) {
            b(data, i11);
        } else {
            d(data, i11);
            if (this.firstAttempt && this.workDone > this.workLimit) {
                b(data, i11);
            }
        }
        int[] iArr = data.f27702r;
        data.f27704t = -1;
        for (int i12 = 0; i12 <= i11; i12++) {
            if (iArr[i12] == 0) {
                data.f27704t = i12;
                return;
            }
        }
    }

    public final void b(BZip2CompressorOutputStream.Data data, int i11) {
        byte[] bArr = data.f27701q;
        int i12 = i11 + 1;
        bArr[0] = bArr[i12];
        c(data.f27702r, bArr, i12);
        for (int i13 = 0; i13 < i12; i13++) {
            int[] iArr = data.f27702r;
            iArr[i13] = iArr[i13] - 1;
        }
        for (int i14 = 0; i14 < i12; i14++) {
            int[] iArr2 = data.f27702r;
            if (iArr2[i14] == -1) {
                iArr2[i14] = i11;
                return;
            }
        }
    }

    public final void c(int[] iArr, byte[] bArr, int i11) {
        int i12;
        int[] iArr2 = new int[257];
        int[] eclass2 = getEclass();
        for (int i13 = 0; i13 < i11; i13++) {
            eclass2[i13] = 0;
        }
        for (int i14 = 0; i14 < i11; i14++) {
            byte b11 = bArr[i14] & 255;
            iArr2[b11] = iArr2[b11] + 1;
        }
        for (int i15 = 1; i15 < 257; i15++) {
            iArr2[i15] = iArr2[i15] + iArr2[i15 - 1];
        }
        for (int i16 = 0; i16 < i11; i16++) {
            byte b12 = bArr[i16] & 255;
            int i17 = iArr2[b12] - 1;
            iArr2[b12] = i17;
            iArr[i17] = i16;
        }
        BitSet bitSet = new BitSet(i11 + 64);
        for (int i18 = 0; i18 < 256; i18++) {
            bitSet.set(iArr2[i18]);
        }
        for (int i19 = 0; i19 < 32; i19++) {
            int i21 = (i19 * 2) + i11;
            bitSet.set(i21);
            bitSet.clear(i21 + 1);
        }
        int i22 = 1;
        do {
            int i23 = 0;
            for (int i24 = 0; i24 < i11; i24++) {
                if (bitSet.get(i24)) {
                    i23 = i24;
                }
                int i25 = iArr[i24] - i22;
                if (i25 < 0) {
                    i25 += i11;
                }
                eclass2[i25] = i23;
            }
            int i26 = -1;
            i12 = 0;
            while (true) {
                int nextClearBit = bitSet.nextClearBit(i26 + 1);
                int i27 = nextClearBit - 1;
                if (i27 < i11 && (i26 = bitSet.nextSetBit(nextClearBit + 1) - 1) < i11) {
                    if (i26 > i27) {
                        i12 += (i26 - i27) + 1;
                        fallbackQSort3(iArr, eclass2, i27, i26);
                        int i28 = -1;
                        while (i27 <= i26) {
                            int i29 = eclass2[iArr[i27]];
                            if (i28 != i29) {
                                bitSet.set(i27);
                                i28 = i29;
                            }
                            i27++;
                        }
                    }
                }
            }
            i22 *= 2;
            if (i22 > i11) {
                return;
            }
        } while (i12 != 0);
    }

    public final void d(BZip2CompressorOutputStream.Data data, int i11) {
        int i12;
        int[] iArr;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        BZip2CompressorOutputStream.Data data2 = data;
        int i18 = i11;
        int[] iArr2 = this.mainSort_runningOrder;
        int[] iArr3 = this.mainSort_copy;
        boolean[] zArr = this.mainSort_bigDone;
        int[] iArr4 = this.ftab;
        byte[] bArr = data2.f27701q;
        int[] iArr5 = data2.f27702r;
        char[] cArr = this.quadrant;
        int i19 = this.workLimit;
        boolean z11 = this.firstAttempt;
        int i21 = 65537;
        while (true) {
            i21--;
            if (i21 < 0) {
                break;
            }
            iArr4[i21] = 0;
        }
        for (int i22 = 0; i22 < 20; i22++) {
            bArr[i18 + i22 + 2] = bArr[(i22 % (i18 + 1)) + 1];
        }
        int i23 = i18 + 20 + 1;
        while (true) {
            i23--;
            if (i23 < 0) {
                break;
            }
            cArr[i23] = 0;
        }
        int i24 = i18 + 1;
        byte b11 = bArr[i24];
        bArr[0] = b11;
        boolean z12 = z11;
        int i25 = 255;
        byte b12 = b11 & 255;
        int i26 = 0;
        while (i26 <= i18) {
            i26++;
            byte b13 = bArr[i26] & 255;
            int i27 = (b12 << 8) + b13;
            iArr4[i27] = iArr4[i27] + 1;
            b12 = b13;
        }
        for (int i28 = 1; i28 <= 65536; i28++) {
            iArr4[i28] = iArr4[i28] + iArr4[i28 - 1];
        }
        boolean z13 = true;
        byte b14 = bArr[1] & 255;
        int i29 = 0;
        while (i29 < i18) {
            byte b15 = bArr[i29 + 2] & 255;
            int i31 = (b14 << 8) + b15;
            int i32 = iArr4[i31] - 1;
            iArr4[i31] = i32;
            iArr5[i32] = i29;
            i29++;
            b14 = b15;
            z13 = true;
        }
        int i33 = ((bArr[i24] & 255) << 8) + (bArr[z13] & 255);
        int i34 = iArr4[i33] - 1;
        iArr4[i33] = i34;
        iArr5[i34] = i18;
        int i35 = 256;
        while (true) {
            i35--;
            if (i35 < 0) {
                break;
            }
            zArr[i35] = false;
            iArr2[i35] = i35;
        }
        int i36 = 364;
        while (i36 != 1) {
            i36 /= 3;
            int i37 = i36;
            while (i37 <= i25) {
                int i38 = iArr2[i37];
                int i39 = iArr4[(i38 + 1) << 8] - iArr4[i38 << 8];
                int i41 = i36 - 1;
                int i42 = iArr2[i37 - i36];
                int i43 = i37;
                while (true) {
                    i17 = i19;
                    if (iArr4[(i42 + 1) << 8] - iArr4[i42 << 8] <= i39) {
                        break;
                    }
                    iArr2[i43] = i42;
                    int i44 = i43 - i36;
                    if (i44 <= i41) {
                        i43 = i44;
                        break;
                    }
                    i42 = iArr2[i44 - i36];
                    i43 = i44;
                    i19 = i17;
                }
                iArr2[i43] = i38;
                i37++;
                i19 = i17;
                i25 = 255;
            }
        }
        int i45 = i19;
        int i46 = 0;
        while (i46 <= i25) {
            int i47 = iArr2[i46];
            int i48 = 0;
            while (i48 <= i25) {
                int i49 = (i47 << 8) + i48;
                int i50 = iArr4[i49];
                if ((i50 & 2097152) != 2097152) {
                    int i51 = i50 & CLEARMASK;
                    int i52 = (iArr4[i49 + 1] & CLEARMASK) - 1;
                    if (i52 > i51) {
                        i16 = 2097152;
                        i13 = i48;
                        int i53 = i25;
                        i15 = i45;
                        iArr = iArr2;
                        i14 = i46;
                        mainQSort3(data, i51, i52, 2, i11);
                        if (z12 && this.workDone > i15) {
                            return;
                        }
                    } else {
                        i13 = i48;
                        i15 = i45;
                        i16 = 2097152;
                        iArr = iArr2;
                        i14 = i46;
                    }
                    iArr4[i49] = i50 | i16;
                } else {
                    i13 = i48;
                    i15 = i45;
                    iArr = iArr2;
                    i14 = i46;
                }
                i48 = i13 + 1;
                i46 = i14;
                iArr2 = iArr;
                i25 = 255;
                i45 = i15;
                BZip2CompressorOutputStream.Data data3 = data;
            }
            int i54 = i45;
            int[] iArr6 = iArr2;
            int i55 = i46;
            int i56 = 0;
            for (int i57 = i25; i56 <= i57; i57 = 255) {
                iArr3[i56] = iArr4[(i56 << 8) + i47] & CLEARMASK;
                i56++;
            }
            int i58 = i47 << 8;
            int i59 = iArr4[i58] & CLEARMASK;
            int i60 = (i47 + 1) << 8;
            int i61 = iArr4[i60] & CLEARMASK;
            while (i59 < i61) {
                int i62 = iArr5[i59];
                int i63 = i61;
                byte b16 = bArr[i62] & 255;
                if (!zArr[b16]) {
                    int i64 = iArr3[b16];
                    if (i62 == 0) {
                        i12 = i18;
                    } else {
                        i12 = i62 - 1;
                    }
                    iArr5[i64] = i12;
                    iArr3[b16] = iArr3[b16] + 1;
                }
                i59++;
                i61 = i63;
            }
            int i65 = 256;
            while (true) {
                i65--;
                if (i65 < 0) {
                    break;
                }
                int i66 = (i65 << 8) + i47;
                iArr4[i66] = iArr4[i66] | 2097152;
            }
            zArr[i47] = true;
            if (i55 < 255) {
                int i67 = iArr4[i58] & CLEARMASK;
                int i68 = (CLEARMASK & iArr4[i60]) - i67;
                int i69 = 0;
                while ((i68 >> i69) > 65534) {
                    i69++;
                }
                int i70 = 0;
                while (i70 < i68) {
                    int i71 = iArr5[i67 + i70];
                    char c11 = (char) (i70 >> i69);
                    cArr[i71] = c11;
                    int i72 = i67;
                    if (i71 < 20) {
                        cArr[i71 + i18 + 1] = c11;
                    }
                    i70++;
                    i67 = i72;
                }
            }
            i46 = i55 + 1;
            iArr2 = iArr6;
            i25 = 255;
            i45 = i54;
            BZip2CompressorOutputStream.Data data4 = data;
        }
    }
}
