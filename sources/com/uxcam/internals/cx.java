package com.uxcam.internals;

import com.uxcam.video.screen.codec.codecs.h264.io.model.MBType;
import java.lang.reflect.Array;

public class cx {

    /* renamed from: a  reason: collision with root package name */
    public final ev f13176a;

    /* renamed from: b  reason: collision with root package name */
    public ap[] f13177b;

    /* renamed from: c  reason: collision with root package name */
    public int[][] f13178c;

    /* renamed from: d  reason: collision with root package name */
    public int[][] f13179d;

    public cx(ev evVar) {
        this.f13176a = evVar;
    }

    public final void a(int[] iArr, int i11, int i12, int[] iArr2) {
        for (int i13 = 0; i13 < iArr2.length; i13++) {
            iArr2[i13] = iArr[i11];
            i11 += i12;
        }
    }

    public final int b(int i11, int i12, int i13) {
        int i14 = i13 & 7;
        if (i13 != 0) {
            return a(this.f13179d[i11], i12 + 4);
        }
        if (i12 != 0) {
            return a(this.f13178c[i11], i14);
        }
        return 128;
    }

    public final int c(int i11, int i12, int i13) {
        int i14 = i13 & 7;
        if (i12 != 0) {
            return a(this.f13178c[i11], i14 + 4);
        }
        if (i13 != 0) {
            return a(this.f13179d[i11], i12);
        }
        return 128;
    }

    public final int d(int i11, int i12, int i13) {
        int i14 = i13 & 7;
        if (i12 != 0 && i13 != 0) {
            return a(this.f13178c[i11], this.f13179d[i11], i14 + 4, i12 + 4);
        }
        if (i12 != 0) {
            return a(this.f13178c[i11], i14 + 4);
        }
        if (i13 != 0) {
            return a(this.f13179d[i11], i12 + 4);
        }
        return 128;
    }

    public final void a(int[] iArr, int i11, int i12, int i13, int[][] iArr2) {
        int i14 = i11;
        int i15 = i12;
        int i16 = i13;
        int[] iArr3 = iArr;
        a(iArr3, a(i11, i12, i13), iArr2[0], 3, 0, 0);
        a(iArr3, b(i11, i12, i13), iArr2[1], 3, 4, 0);
        a(iArr3, c(i11, i12, i13), iArr2[2], 3, 0, 4);
        a(iArr3, d(i11, i12, i13), iArr2[3], 3, 4, 4);
    }

    public final void a(int[] iArr, int i11, int[] iArr2, int i12, int i13, int i14) {
        int i15 = 1 << i12;
        int i16 = (i14 << i12) + i13;
        int i17 = 0;
        for (int i18 = 0; i18 < 4; i18++) {
            iArr[i16] = dv.a(iArr2[i17] + i11, 0, 255);
            iArr[i16 + 1] = dv.a(iArr2[i17 + 1] + i11, 0, 255);
            iArr[i16 + 2] = dv.a(iArr2[i17 + 2] + i11, 0, 255);
            iArr[i16 + 3] = dv.a(iArr2[i17 + 3] + i11, 0, 255);
            i17 += 4;
            i16 += i15;
        }
    }

    public final void a(int[] iArr, int[][] iArr2, int i11) {
        int[] iArr3 = iArr;
        int[][] iArr4 = iArr2;
        int i12 = i11;
        if (iArr3.length == 4) {
            ba.b(iArr);
            int i13 = i12 % 6;
            int i14 = i12 / 6;
            for (int i15 = 0; i15 < 4; i15++) {
                iArr3[i15] = ((iArr3[i15] * ba.f13043c[i13][0]) << i14) >> 1;
            }
        } else if (iArr3.length == 8) {
            int[][] iArr5 = ba.f13041a;
        } else {
            int[][] iArr6 = ba.f13041a;
            for (int i16 = 0; i16 < 16; i16 += 4) {
                int i17 = iArr3[i16];
                int i18 = i16 + 2;
                int i19 = iArr3[i18];
                int i21 = i17 + i19;
                int i22 = i17 - i19;
                int i23 = i16 + 1;
                int i24 = iArr3[i23];
                int i25 = i16 + 3;
                int i26 = iArr3[i25];
                int i27 = i24 - i26;
                int i28 = i24 + i26;
                iArr3[i16] = i21 + i28;
                iArr3[i23] = i22 + i27;
                iArr3[i18] = i22 - i27;
                iArr3[i25] = i21 - i28;
            }
            for (int i29 = 0; i29 < 4; i29++) {
                int i31 = iArr3[i29];
                int i32 = i29 + 8;
                int i33 = iArr3[i32];
                int i34 = i31 + i33;
                int i35 = i31 - i33;
                int i36 = i29 + 4;
                int i37 = iArr3[i36];
                int i38 = i29 + 12;
                int i39 = iArr3[i38];
                int i41 = i37 - i39;
                int i42 = i37 + i39;
                iArr3[i29] = i34 + i42;
                iArr3[i36] = i35 + i41;
                iArr3[i32] = i35 - i41;
                iArr3[i38] = i34 - i42;
            }
            int i43 = i12 % 6;
            if (i12 >= 36) {
                int i44 = (i12 / 6) - 2;
                for (int i45 = 0; i45 < 16; i45++) {
                    iArr3[i45] = (iArr3[i45] * ba.f13043c[i43][0]) << i44;
                }
            } else {
                int i46 = i12 / 6;
                int i47 = 6 - i46;
                int i48 = 1 << (5 - i46);
                for (int i49 = 0; i49 < 16; i49++) {
                    iArr3[i49] = ((iArr3[i49] * (ba.f13043c[i43][0] << 4)) + i48) >> i47;
                }
            }
            ba.c(iArr);
        }
        for (int i50 = 0; i50 < iArr4.length; i50++) {
            int[] iArr7 = iArr4[i50];
            int[][] iArr8 = ba.f13041a;
            int i51 = i12 % 6;
            if (i12 >= 24) {
                int i52 = i12 / 6;
                for (int i53 = 0; i53 < 16; i53++) {
                    iArr7[i53] = (iArr7[i53] * ba.f13043c[i51][i53]) << i52;
                }
            } else {
                int i54 = i12 / 6;
                int i55 = 4 - i54;
                int i56 = 1 << (3 - i54);
                for (int i57 = 0; i57 < 16; i57++) {
                    iArr7[i57] = ((iArr7[i57] * (ba.f13043c[i51][i57] << 4)) + i56) >> i55;
                }
            }
            int[] iArr9 = iArr4[i50];
            iArr9[0] = iArr3[i50];
            for (int i58 = 0; i58 < 16; i58 += 4) {
                int i59 = iArr9[i58];
                int i60 = i58 + 2;
                int i61 = iArr9[i60];
                int i62 = i59 + i61;
                int i63 = i59 - i61;
                int i64 = i58 + 1;
                int i65 = iArr9[i64];
                int i66 = i58 + 3;
                int i67 = iArr9[i66];
                int i68 = (i65 >> 1) - i67;
                int i69 = i65 + (i67 >> 1);
                iArr9[i58] = i62 + i69;
                iArr9[i64] = i63 + i68;
                iArr9[i60] = i63 - i68;
                iArr9[i66] = i62 - i69;
            }
            for (int i70 = 0; i70 < 4; i70++) {
                int i71 = iArr9[i70];
                int i72 = i70 + 8;
                int i73 = iArr9[i72];
                int i74 = i71 + i73;
                int i75 = i71 - i73;
                int i76 = i70 + 4;
                int i77 = iArr9[i76];
                int i78 = i70 + 12;
                int i79 = iArr9[i78];
                int i80 = (i77 >> 1) - i79;
                int i81 = i77 + (i79 >> 1);
                iArr9[i70] = i74 + i81;
                iArr9[i76] = i75 + i80;
                iArr9[i72] = i75 - i80;
                iArr9[i78] = i74 - i81;
            }
            for (int i82 = 0; i82 < 16; i82++) {
                iArr9[i82] = (iArr9[i82] + 32) >> 6;
            }
        }
    }

    public final int[] a(int[][] iArr) {
        int[] iArr2 = new int[iArr.length];
        for (int i11 = 0; i11 < iArr.length; i11++) {
            int[] iArr3 = iArr[i11];
            iArr2[i11] = iArr3[0];
            iArr3[0] = 0;
        }
        return iArr2;
    }

    public final void a(int i11, ak akVar, int i12, int i13, int[][] iArr, int i14) {
        int[][] iArr2 = iArr;
        int i15 = i14;
        for (int i16 = 0; i16 < iArr2.length; i16++) {
            int[] iArr3 = iArr2[i16];
            int[][] iArr4 = ba.f13041a;
            int i17 = i15 / 6;
            int i18 = i15 % 6;
            int i19 = 682 << (i17 + 4);
            int i21 = i17 + 15;
            if (i15 < 10) {
                for (int i22 = 1; i22 < 16; i22++) {
                    int i23 = iArr3[i22];
                    int i24 = i23 >> 31;
                    iArr3[i22] = (Math.min(((((i23 ^ i24) - i24) * ba.f13041a[i18][i22]) + i19) >> i21, 2063) ^ i24) - i24;
                }
            } else {
                for (int i25 = 1; i25 < 16; i25++) {
                    int i26 = iArr3[i25];
                    int i27 = i26 >> 31;
                    iArr3[i25] = ((((((i26 ^ i27) - i27) * ba.f13041a[i18][i25]) + i19) >> i21) ^ i27) - i27;
                }
            }
            ap apVar = this.f13177b[i11];
            int i28 = i12 + cw.f13174j[i16];
            int i29 = i13 + cw.f13175k[i16];
            MBType mBType = MBType.I_16x16;
            ap apVar2 = apVar;
            int a11 = apVar2.a(akVar, iArr2[i16], cw.f13169e, 1, 15, ba.f13042b, apVar2.a(i28 != 0, mBType, apVar.f13008c[apVar.f13010e & i29], i29 != 0, mBType, apVar.f13009d[i28]));
            apVar.f13008c[i29 & apVar.f13010e] = a11;
            apVar.f13009d[i28] = a11;
        }
    }

    public final void a(int i11, ak akVar, int i12, int i13, int i14, int[] iArr) {
        int i15 = i12;
        int[] iArr2 = iArr;
        if (iArr2.length == 4) {
            int[][] iArr3 = ba.f13041a;
            int i16 = i15 / 6;
            int i17 = i15 % 6;
            int i18 = 682 << (i16 + 5);
            int i19 = i16 + 16;
            if (i15 < 4) {
                for (int i21 = 0; i21 < 4; i21++) {
                    int i22 = iArr2[i21];
                    int i23 = i22 >> 31;
                    iArr2[i21] = (Math.min(((((i22 ^ i23) - i23) * ba.f13041a[i17][0]) + i18) >> i19, 2063) ^ i23) - i23;
                }
            } else {
                for (int i24 = 0; i24 < 4; i24++) {
                    int i25 = iArr2[i24];
                    int i26 = i25 >> 31;
                    iArr2[i24] = ((((((i25 ^ i26) - i26) * ba.f13041a[i17][0]) + i18) >> i19) ^ i26) - i26;
                }
            }
            ba.b(iArr);
            ap apVar = this.f13177b[i11];
            apVar.a(akVar, iArr, cw.f13170f, 0, iArr2.length, new int[]{0, 1, 2, 3}, apVar.f13007b);
        } else if (iArr2.length == 8) {
            int[][] iArr4 = ba.f13041a;
            ap apVar2 = this.f13177b[i11];
            apVar2.a(akVar, iArr, cw.f13171g, 0, iArr2.length, new int[]{0, 1, 2, 3, 4, 5, 6, 7}, apVar2.f13007b);
        } else {
            ba.c(iArr);
            int i27 = i15 / 6;
            int i28 = i15 % 6;
            int i29 = 682 << (i27 + 5);
            int i31 = i27 + 16;
            if (i15 < 10) {
                for (int i32 = 0; i32 < 16; i32++) {
                    int i33 = iArr2[i32];
                    int i34 = i33 >> 31;
                    iArr2[i32] = (Math.min(((((i33 ^ i34) - i34) * ba.f13041a[i28][0]) + i29) >> i31, 2063) ^ i34) - i34;
                }
            } else {
                for (int i35 = 0; i35 < 16; i35++) {
                    int i36 = iArr2[i35];
                    int i37 = i36 >> 31;
                    iArr2[i35] = ((((((i36 ^ i37) - i37) * ba.f13041a[i28][0]) + i29) >> i31) ^ i37) - i37;
                }
            }
            for (int i38 = 0; i38 < 16; i38 += 4) {
                int i39 = iArr2[i38];
                int i41 = i38 + 3;
                int i42 = iArr2[i41];
                int i43 = i39 + i42;
                int i44 = i38 + 1;
                int i45 = iArr2[i44];
                int i46 = i38 + 2;
                int i47 = iArr2[i46];
                int i48 = i45 + i47;
                int i49 = i45 - i47;
                int i50 = i39 - i42;
                iArr2[i38] = i43 + i48;
                iArr2[i44] = i50 + i49;
                iArr2[i46] = i43 - i48;
                iArr2[i41] = i50 - i49;
            }
            for (int i51 = 0; i51 < 4; i51++) {
                int i52 = iArr2[i51];
                int i53 = i51 + 12;
                int i54 = iArr2[i53];
                int i55 = i52 + i54;
                int i56 = i51 + 4;
                int i57 = iArr2[i56];
                int i58 = i51 + 8;
                int i59 = iArr2[i58];
                int i60 = i57 + i59;
                int i61 = i57 - i59;
                int i62 = i52 - i54;
                iArr2[i51] = (i55 + i60) >> 1;
                iArr2[i56] = (i61 + i62) >> 1;
                iArr2[i58] = (i55 - i60) >> 1;
                iArr2[i53] = (i62 - i61) >> 1;
            }
            ap apVar3 = this.f13177b[i11];
            MBType mBType = MBType.I_16x16;
            apVar3.a(akVar, iArr, cw.f13169e, 0, 16, ba.f13042b, apVar3.a(i13 != 0, mBType, apVar3.f13008c[i14 & apVar3.f13010e], i14 != 0, mBType, apVar3.f13009d[i13]));
        }
    }

    public final int[][] a(ek ekVar, int i11, int i12, int i13, int i14, int i15) {
        ek ekVar2 = ekVar;
        int i16 = i11;
        int i17 = i14;
        int i18 = i15;
        int[] iArr = new int[2];
        iArr[1] = 16;
        iArr[0] = 16 >> (i12 + i13);
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        int[] iArr3 = ekVar2.f13284d[i16];
        int i19 = ekVar2.f13282b;
        bc bcVar = ekVar2.f13281a;
        int i21 = i19 >> bcVar.f13059c[i16];
        int i22 = ekVar2.f13283c >> bcVar.f13060d[i16];
        int i23 = i15;
        a(iArr3, i21, i22, i14, i23, iArr2[0], a(i16, i17, i18));
        ba.a(iArr2[0]);
        int[] iArr4 = ekVar2.f13284d[i16];
        int i24 = ekVar2.f13282b;
        bc bcVar2 = ekVar2.f13281a;
        int i25 = i24 >> bcVar2.f13059c[i16];
        int i26 = ekVar2.f13283c >> bcVar2.f13060d[i16];
        int i27 = i17 + 4;
        a(iArr4, i25, i26, i27, i23, iArr2[1], b(i16, i17, i18));
        ba.a(iArr2[1]);
        int[] iArr5 = ekVar2.f13284d[i16];
        int i28 = ekVar2.f13282b;
        bc bcVar3 = ekVar2.f13281a;
        int i29 = i28 >> bcVar3.f13059c[i16];
        int i31 = ekVar2.f13283c >> bcVar3.f13060d[i16];
        int i32 = i18 + 4;
        a(iArr5, i29, i31, i14, i32, iArr2[2], c(i16, i17, i18));
        ba.a(iArr2[2]);
        int[] iArr6 = ekVar2.f13284d[i16];
        int i33 = ekVar2.f13282b;
        bc bcVar4 = ekVar2.f13281a;
        int i34 = i33 >> bcVar4.f13059c[i16];
        int i35 = ekVar2.f13283c >> bcVar4.f13060d[i16];
        a(iArr6, i34, i35, i27, i32, iArr2[3], d(i16, i17, i18));
        ba.a(iArr2[3]);
        return iArr2;
    }

    public final int a(int[] iArr, int i11) {
        return ((((iArr[i11] + iArr[i11 + 1]) + iArr[i11 + 2]) + iArr[i11 + 3]) + 2) >> 2;
    }

    public final int a(int[] iArr, int[] iArr2, int i11, int i12) {
        return ((((((((iArr[i11] + iArr[i11 + 1]) + iArr[i11 + 2]) + iArr[i11 + 3]) + iArr2[i12]) + iArr2[i12 + 1]) + iArr2[i12 + 2]) + iArr2[i12 + 3]) + 4) >> 3;
    }

    public final int a(int i11, int i12, int i13) {
        int i14 = i13 & 7;
        if (i12 != 0 && i13 != 0) {
            return a(this.f13178c[i11], this.f13179d[i11], i14, i12);
        }
        if (i12 != 0) {
            return a(this.f13178c[i11], i14);
        }
        if (i13 != 0) {
            return a(this.f13179d[i11], i12);
        }
        return 128;
    }

    public final int a(int i11, int i12) {
        if (i11 == 0 && i12 == 0) {
            return 128;
        }
        int i13 = 0;
        if (i12 == 0) {
            int[] iArr = this.f13178c[0];
            int i14 = 0;
            while (i13 < iArr.length) {
                i14 += iArr[i13];
                i13++;
            }
            return (i14 + 8) >> 4;
        } else if (i11 == 0) {
            int[] iArr2 = this.f13179d[0];
            for (int i15 = i11; i15 < i11 + 16; i15++) {
                i13 += iArr2[i15];
            }
            return (i13 + 8) >> 4;
        } else {
            int i16 = 0;
            for (int i17 : this.f13178c[0]) {
                i16 += i17;
            }
            int[] iArr3 = this.f13179d[0];
            for (int i18 = i11; i18 < i11 + 16; i18++) {
                i13 += iArr3[i18];
            }
            return ((i16 + i13) + 16) >> 5;
        }
    }

    public final void a(int[] iArr, int i11, int i12, int i13, int i14, int[] iArr2, int i15) {
        int i16;
        int i17 = i13 + 4;
        int i18 = 0;
        if (i17 >= i11 || i14 + 4 >= i12) {
            int i19 = i14;
            while (true) {
                i16 = i14 + 4;
                if (i19 >= Math.min(i16, i12)) {
                    break;
                }
                int min = Math.min(i13, i11) + (i19 * i11);
                int i21 = i13;
                while (i21 < Math.min(i17, i11)) {
                    iArr2[i18] = iArr[min] - i15;
                    i21++;
                    i18++;
                    min++;
                }
                int i22 = min - 1;
                while (i21 < i17) {
                    iArr2[i18] = iArr[i22] - i15;
                    i21++;
                    i18++;
                }
                i19++;
            }
            while (i19 < i16) {
                int min2 = Math.min(i13, i11) + ((i12 * i11) - i11);
                int i23 = i13;
                while (i23 < Math.min(i17, i11)) {
                    iArr2[i18] = iArr[min2] - i15;
                    i23++;
                    i18++;
                    min2++;
                }
                int i24 = min2 - 1;
                while (i23 < i17) {
                    iArr2[i18] = iArr[i24] - i15;
                    i23++;
                    i18++;
                }
                i19++;
            }
            return;
        }
        int i25 = (i14 * i11) + i13;
        int i26 = 0;
        while (i18 < 4) {
            iArr2[i26] = iArr[i25] - i15;
            iArr2[i26 + 1] = iArr[i25 + 1] - i15;
            iArr2[i26 + 2] = iArr[i25 + 2] - i15;
            iArr2[i26 + 3] = iArr[i25 + 3] - i15;
            i18++;
            i25 += i11;
            i26 += 4;
        }
    }
}
