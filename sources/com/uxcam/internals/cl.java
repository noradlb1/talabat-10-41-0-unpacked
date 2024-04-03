package com.uxcam.internals;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Array;
import java.util.concurrent.Executors;
import mz.a;

public class cl implements ck {
    public static void a(float f11, Bitmap bitmap, cj cjVar) {
        int[] iArr;
        int round = Math.round(f11);
        if (round >= 1) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i11 = width * height;
            int[] iArr2 = new int[i11];
            bitmap.getPixels(iArr2, 0, width, 0, 0, width, height);
            int i12 = width - 1;
            int i13 = height - 1;
            int i14 = round + round + 1;
            int[] iArr3 = new int[i11];
            int[] iArr4 = new int[i11];
            int[] iArr5 = new int[i11];
            int[] iArr6 = new int[Math.max(width, height)];
            int i15 = (i14 + 1) >> 1;
            int i16 = i15 * i15;
            int i17 = i16 * 256;
            int[] iArr7 = new int[i17];
            for (int i18 = 0; i18 < i17; i18++) {
                iArr7[i18] = i18 / i16;
            }
            int[] iArr8 = new int[2];
            iArr8[1] = 3;
            iArr8[0] = i14;
            int[][] iArr9 = (int[][]) Array.newInstance(Integer.TYPE, iArr8);
            int i19 = round + 1;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            while (i21 < height) {
                int i24 = height;
                int i25 = 0;
                int i26 = 0;
                int i27 = 0;
                int i28 = 0;
                int i29 = 0;
                int i31 = 0;
                int i32 = 0;
                int i33 = 0;
                int i34 = -round;
                int i35 = 0;
                while (i34 <= round) {
                    int i36 = i13;
                    int[] iArr10 = iArr6;
                    int i37 = iArr2[Math.min(i12, Math.max(i34, 0)) + i22];
                    int[] iArr11 = iArr9[i34 + round];
                    iArr11[0] = (i37 & 16711680) >> 16;
                    iArr11[1] = (i37 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                    iArr11[2] = i37 & 255;
                    int abs = i19 - Math.abs(i34);
                    int i38 = iArr11[0];
                    i35 += i38 * abs;
                    int i39 = iArr11[1];
                    i25 = (i39 * abs) + i25;
                    int i41 = iArr11[2];
                    i26 = (abs * i41) + i26;
                    if (i34 > 0) {
                        i33 += i38;
                        i32 += i39;
                        i31 += i41;
                    } else {
                        i29 += i38;
                        i28 += i39;
                        i27 += i41;
                    }
                    i34++;
                    i13 = i36;
                    iArr6 = iArr10;
                }
                int i42 = i13;
                int[] iArr12 = iArr6;
                int i43 = round;
                int i44 = i35;
                int i45 = 0;
                while (i45 < width) {
                    iArr3[i22] = iArr7[i44];
                    iArr4[i22] = iArr7[i25];
                    iArr5[i22] = iArr7[i26];
                    int i46 = i44 - i29;
                    int i47 = i25 - i28;
                    int i48 = i26 - i27;
                    int[] iArr13 = iArr9[((i43 - round) + i14) % i14];
                    int i49 = i29 - iArr13[0];
                    int i50 = i28 - iArr13[1];
                    int i51 = i27 - iArr13[2];
                    if (i21 == 0) {
                        iArr = iArr7;
                        iArr12[i45] = Math.min(i45 + round + 1, i12);
                    } else {
                        iArr = iArr7;
                    }
                    int i52 = iArr2[i23 + iArr12[i45]];
                    int i53 = (i52 & 16711680) >> 16;
                    iArr13[0] = i53;
                    int i54 = (i52 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                    iArr13[1] = i54;
                    int i55 = i52 & 255;
                    iArr13[2] = i55;
                    int i56 = i33 + i53;
                    int i57 = i32 + i54;
                    int i58 = i31 + i55;
                    i44 = i46 + i56;
                    i25 = i47 + i57;
                    i26 = i48 + i58;
                    i43 = (i43 + 1) % i14;
                    int[] iArr14 = iArr9[i43 % i14];
                    int i59 = iArr14[0];
                    i29 = i49 + i59;
                    int i60 = iArr14[1];
                    i28 = i50 + i60;
                    int i61 = iArr14[2];
                    i27 = i51 + i61;
                    i33 = i56 - i59;
                    i32 = i57 - i60;
                    i31 = i58 - i61;
                    i22++;
                    i45++;
                    iArr7 = iArr;
                }
                int[] iArr15 = iArr7;
                i23 += width;
                i21++;
                height = i24;
                i13 = i42;
                iArr6 = iArr12;
            }
            int i62 = i13;
            int[] iArr16 = iArr6;
            int i63 = height;
            int[] iArr17 = iArr7;
            int i64 = 0;
            while (i64 < width) {
                int i65 = -round;
                int i66 = i14;
                int[] iArr18 = iArr2;
                int i67 = 0;
                int i68 = 0;
                int i69 = 0;
                int i70 = 0;
                int i71 = 0;
                int i72 = 0;
                int i73 = 0;
                int i74 = i65;
                int i75 = i65 * width;
                int i76 = 0;
                int i77 = 0;
                while (i74 <= round) {
                    int i78 = width;
                    int max = Math.max(0, i75) + i64;
                    int[] iArr19 = iArr9[i74 + round];
                    iArr19[0] = iArr3[max];
                    iArr19[1] = iArr4[max];
                    iArr19[2] = iArr5[max];
                    int abs2 = i19 - Math.abs(i74);
                    i76 = (iArr3[max] * abs2) + i76;
                    i77 = (iArr4[max] * abs2) + i77;
                    i67 = (iArr5[max] * abs2) + i67;
                    if (i74 > 0) {
                        i71 += iArr19[0];
                        i73 += iArr19[1];
                        i72 += iArr19[2];
                    } else {
                        i70 += iArr19[0];
                        i69 += iArr19[1];
                        i68 += iArr19[2];
                    }
                    int i79 = i62;
                    if (i74 < i79) {
                        i75 += i78;
                    }
                    i74++;
                    i62 = i79;
                    width = i78;
                }
                int i80 = width;
                int i81 = i62;
                int i82 = round;
                int i83 = i64;
                int i84 = i63;
                int i85 = 0;
                while (i85 < i84) {
                    iArr18[i83] = (iArr18[i83] & ViewCompat.MEASURED_STATE_MASK) | (iArr17[i76] << 16) | (iArr17[i77] << 8) | iArr17[i67];
                    int i86 = i76 - i70;
                    int i87 = i77 - i69;
                    int i88 = i67 - i68;
                    int[] iArr20 = iArr9[((i82 - round) + i66) % i66];
                    int i89 = i70 - iArr20[0];
                    int i90 = i69 - iArr20[1];
                    int i91 = i68 - iArr20[2];
                    int i92 = round;
                    if (i64 == 0) {
                        iArr16[i85] = Math.min(i85 + i19, i81) * i80;
                    }
                    int i93 = iArr16[i85] + i64;
                    int i94 = iArr3[i93];
                    iArr20[0] = i94;
                    int i95 = iArr4[i93];
                    iArr20[1] = i95;
                    int i96 = iArr5[i93];
                    iArr20[2] = i96;
                    int i97 = i71 + i94;
                    int i98 = i73 + i95;
                    int i99 = i72 + i96;
                    i76 = i86 + i97;
                    i77 = i87 + i98;
                    i67 = i88 + i99;
                    i82 = (i82 + 1) % i66;
                    int[] iArr21 = iArr9[i82];
                    int i100 = iArr21[0];
                    i70 = i89 + i100;
                    int i101 = iArr21[1];
                    i69 = i90 + i101;
                    int i102 = iArr21[2];
                    i68 = i91 + i102;
                    i71 = i97 - i100;
                    i73 = i98 - i101;
                    i72 = i99 - i102;
                    i83 += i80;
                    i85++;
                    round = i92;
                }
                int i103 = round;
                i64++;
                i62 = i81;
                i63 = i84;
                i14 = i66;
                iArr2 = iArr18;
                width = i80;
            }
            int i104 = width;
            bitmap.setPixels(iArr2, 0, i104, 0, 0, i104, i63);
        }
        cjVar.a();
    }

    public final void a(int i11, Bitmap bitmap, Context context, cj cjVar) {
        Executors.newSingleThreadExecutor().submit(new a((((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f) * ((float) i11), bitmap, cjVar));
    }
}
