package jp.wasabeef.glide.transformations.internal;

import android.graphics.Bitmap;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Array;

public class FastBlur {
    public static Bitmap blur(Bitmap bitmap, int i11, boolean z11) {
        Bitmap bitmap2;
        int[] iArr;
        int i12 = i11;
        if (z11) {
            bitmap2 = bitmap;
        } else {
            bitmap2 = bitmap.copy(bitmap.getConfig(), true);
        }
        if (i12 < 1) {
            return null;
        }
        int width = bitmap2.getWidth();
        int height = bitmap2.getHeight();
        int i13 = width * height;
        int[] iArr2 = new int[i13];
        bitmap2.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i14 = width - 1;
        int i15 = height - 1;
        int i16 = i12 + i12 + 1;
        int[] iArr3 = new int[i13];
        int[] iArr4 = new int[i13];
        int[] iArr5 = new int[i13];
        int[] iArr6 = new int[Math.max(width, height)];
        int i17 = (i16 + 1) >> 1;
        int i18 = i17 * i17;
        int i19 = i18 * 256;
        int[] iArr7 = new int[i19];
        for (int i21 = 0; i21 < i19; i21++) {
            iArr7[i21] = i21 / i18;
        }
        int[] iArr8 = new int[2];
        iArr8[1] = 3;
        iArr8[0] = i16;
        int[][] iArr9 = (int[][]) Array.newInstance(Integer.TYPE, iArr8);
        int i22 = i12 + 1;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        while (i23 < height) {
            Bitmap bitmap3 = bitmap2;
            int i26 = height;
            int i27 = 0;
            int i28 = 0;
            int i29 = 0;
            int i31 = 0;
            int i32 = 0;
            int i33 = 0;
            int i34 = 0;
            int i35 = 0;
            int i36 = -i12;
            int i37 = 0;
            while (i36 <= i12) {
                int i38 = i15;
                int[] iArr10 = iArr6;
                int i39 = iArr2[i24 + Math.min(i14, Math.max(i36, 0))];
                int[] iArr11 = iArr9[i36 + i12];
                iArr11[0] = (i39 & 16711680) >> 16;
                iArr11[1] = (i39 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr11[2] = i39 & 255;
                int abs = i22 - Math.abs(i36);
                int i41 = iArr11[0];
                i37 += i41 * abs;
                int i42 = iArr11[1];
                i27 += i42 * abs;
                int i43 = iArr11[2];
                i28 += abs * i43;
                if (i36 > 0) {
                    i33 += i41;
                    i34 += i42;
                    i35 += i43;
                } else {
                    i29 += i41;
                    i31 += i42;
                    i32 += i43;
                }
                i36++;
                i15 = i38;
                iArr6 = iArr10;
            }
            int i44 = i15;
            int[] iArr12 = iArr6;
            int i45 = i12;
            int i46 = i37;
            int i47 = 0;
            while (i47 < width) {
                iArr3[i24] = iArr7[i46];
                iArr4[i24] = iArr7[i27];
                iArr5[i24] = iArr7[i28];
                int i48 = i46 - i29;
                int i49 = i27 - i31;
                int i50 = i28 - i32;
                int[] iArr13 = iArr9[((i45 - i12) + i16) % i16];
                int i51 = i29 - iArr13[0];
                int i52 = i31 - iArr13[1];
                int i53 = i32 - iArr13[2];
                if (i23 == 0) {
                    iArr = iArr7;
                    iArr12[i47] = Math.min(i47 + i12 + 1, i14);
                } else {
                    iArr = iArr7;
                }
                int i54 = iArr2[i25 + iArr12[i47]];
                int i55 = (i54 & 16711680) >> 16;
                iArr13[0] = i55;
                int i56 = (i54 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr13[1] = i56;
                int i57 = i54 & 255;
                iArr13[2] = i57;
                int i58 = i33 + i55;
                int i59 = i34 + i56;
                int i60 = i35 + i57;
                i46 = i48 + i58;
                i27 = i49 + i59;
                i28 = i50 + i60;
                i45 = (i45 + 1) % i16;
                int[] iArr14 = iArr9[i45 % i16];
                int i61 = iArr14[0];
                i29 = i51 + i61;
                int i62 = iArr14[1];
                i31 = i52 + i62;
                int i63 = iArr14[2];
                i32 = i53 + i63;
                i33 = i58 - i61;
                i34 = i59 - i62;
                i35 = i60 - i63;
                i24++;
                i47++;
                iArr7 = iArr;
            }
            int[] iArr15 = iArr7;
            i25 += width;
            i23++;
            bitmap2 = bitmap3;
            height = i26;
            i15 = i44;
            iArr6 = iArr12;
        }
        Bitmap bitmap4 = bitmap2;
        int i64 = i15;
        int[] iArr16 = iArr6;
        int i65 = height;
        int[] iArr17 = iArr7;
        int i66 = 0;
        while (i66 < width) {
            int i67 = -i12;
            int i68 = i16;
            int[] iArr18 = iArr2;
            int i69 = 0;
            int i70 = 0;
            int i71 = 0;
            int i72 = 0;
            int i73 = 0;
            int i74 = 0;
            int i75 = 0;
            int i76 = i67;
            int i77 = i67 * width;
            int i78 = 0;
            int i79 = 0;
            while (i76 <= i12) {
                int i80 = width;
                int max = Math.max(0, i77) + i66;
                int[] iArr19 = iArr9[i76 + i12];
                iArr19[0] = iArr3[max];
                iArr19[1] = iArr4[max];
                iArr19[2] = iArr5[max];
                int abs2 = i22 - Math.abs(i76);
                i78 += iArr3[max] * abs2;
                i79 += iArr4[max] * abs2;
                i69 += iArr5[max] * abs2;
                if (i76 > 0) {
                    i73 += iArr19[0];
                    i74 += iArr19[1];
                    i75 += iArr19[2];
                } else {
                    i70 += iArr19[0];
                    i71 += iArr19[1];
                    i72 += iArr19[2];
                }
                int i81 = i64;
                if (i76 < i81) {
                    i77 += i80;
                }
                i76++;
                i64 = i81;
                width = i80;
            }
            int i82 = width;
            int i83 = i64;
            int i84 = i12;
            int i85 = i66;
            int i86 = i65;
            int i87 = 0;
            while (i87 < i86) {
                iArr18[i85] = (iArr18[i85] & ViewCompat.MEASURED_STATE_MASK) | (iArr17[i78] << 16) | (iArr17[i79] << 8) | iArr17[i69];
                int i88 = i78 - i70;
                int i89 = i79 - i71;
                int i90 = i69 - i72;
                int[] iArr20 = iArr9[((i84 - i12) + i68) % i68];
                int i91 = i70 - iArr20[0];
                int i92 = i71 - iArr20[1];
                int i93 = i72 - iArr20[2];
                if (i66 == 0) {
                    iArr16[i87] = Math.min(i87 + i22, i83) * i82;
                }
                int i94 = iArr16[i87] + i66;
                int i95 = iArr3[i94];
                iArr20[0] = i95;
                int i96 = iArr4[i94];
                iArr20[1] = i96;
                int i97 = iArr5[i94];
                iArr20[2] = i97;
                int i98 = i73 + i95;
                int i99 = i74 + i96;
                int i100 = i75 + i97;
                i78 = i88 + i98;
                i79 = i89 + i99;
                i69 = i90 + i100;
                i84 = (i84 + 1) % i68;
                int[] iArr21 = iArr9[i84];
                int i101 = iArr21[0];
                i70 = i91 + i101;
                int i102 = iArr21[1];
                i71 = i92 + i102;
                int i103 = iArr21[2];
                i72 = i93 + i103;
                i73 = i98 - i101;
                i74 = i99 - i102;
                i75 = i100 - i103;
                i85 += i82;
                i87++;
                i12 = i11;
            }
            i66++;
            i12 = i11;
            i64 = i83;
            i65 = i86;
            i16 = i68;
            iArr2 = iArr18;
            width = i82;
        }
        int i104 = width;
        bitmap4.setPixels(iArr2, 0, i104, 0, 0, i104, i65);
        return bitmap4;
    }
}
