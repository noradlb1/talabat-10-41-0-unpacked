package com.talabat.helpers;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.Log;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Array;

public class Blur {
    public static Bitmap fastBlur(Bitmap bitmap, int i11, Context context) {
        RenderScript create = RenderScript.create(context);
        Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
        Allocation createTyped = Allocation.createTyped(create, createFromBitmap.getType());
        try {
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            create2.setRadius((float) i11);
            create2.setInput(createFromBitmap);
            create2.forEach(createTyped);
            createTyped.copyTo(bitmap);
            return bitmap;
        } catch (Exception e11) {
            Log.i("ex", e11.getMessage());
            return null;
        }
    }

    public static Bitmap fastBlur2(Bitmap bitmap, int i11) {
        int[] iArr;
        int i12 = i11;
        Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
        if (i12 < 1) {
            return null;
        }
        int width = copy.getWidth();
        int height = copy.getHeight();
        int i13 = width * height;
        int[] iArr2 = new int[i13];
        StringBuilder sb2 = new StringBuilder();
        sb2.append(width);
        String str = " ";
        sb2.append(str);
        sb2.append(height);
        sb2.append(str);
        sb2.append(i13);
        Log.e("pix", sb2.toString());
        String str2 = "pix";
        copy.getPixels(iArr2, 0, width, 0, 0, width, height);
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
        Bitmap bitmap2 = copy;
        int[] iArr7 = new int[i19];
        int i21 = i13;
        for (int i22 = 0; i22 < i19; i22++) {
            iArr7[i22] = i22 / i18;
        }
        int[] iArr8 = new int[2];
        iArr8[1] = 3;
        iArr8[0] = i16;
        int[][] iArr9 = (int[][]) Array.newInstance(Integer.TYPE, iArr8);
        int i23 = i12 + 1;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        while (i24 < height) {
            String str3 = str;
            int i27 = -i12;
            int i28 = 0;
            int i29 = 0;
            int i31 = 0;
            int i32 = 0;
            int i33 = 0;
            int i34 = 0;
            int i35 = 0;
            int i36 = 0;
            int i37 = 0;
            while (i27 <= i12) {
                int i38 = i15;
                int i39 = height;
                int i41 = iArr2[i25 + Math.min(i14, Math.max(i27, 0))];
                int[] iArr10 = iArr9[i27 + i12];
                iArr10[0] = (i41 & 16711680) >> 16;
                iArr10[1] = (i41 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[2] = i41 & 255;
                int abs = i23 - Math.abs(i27);
                int i42 = iArr10[0];
                i28 += i42 * abs;
                int i43 = iArr10[1];
                i29 += i43 * abs;
                int i44 = iArr10[2];
                i31 += abs * i44;
                if (i27 > 0) {
                    i35 += i42;
                    i36 += i43;
                    i37 += i44;
                } else {
                    i32 += i42;
                    i33 += i43;
                    i34 += i44;
                }
                i27++;
                height = i39;
                i15 = i38;
            }
            int i45 = i15;
            int i46 = height;
            int i47 = i12;
            int i48 = 0;
            while (i48 < width) {
                iArr3[i25] = iArr7[i28];
                iArr4[i25] = iArr7[i29];
                iArr5[i25] = iArr7[i31];
                int i49 = i28 - i32;
                int i50 = i29 - i33;
                int i51 = i31 - i34;
                int[] iArr11 = iArr9[((i47 - i12) + i16) % i16];
                int i52 = i32 - iArr11[0];
                int i53 = i33 - iArr11[1];
                int i54 = i34 - iArr11[2];
                if (i24 == 0) {
                    iArr = iArr7;
                    iArr6[i48] = Math.min(i48 + i12 + 1, i14);
                } else {
                    iArr = iArr7;
                }
                int i55 = iArr2[i26 + iArr6[i48]];
                int i56 = (i55 & 16711680) >> 16;
                iArr11[0] = i56;
                int i57 = (i55 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr11[1] = i57;
                int i58 = i55 & 255;
                iArr11[2] = i58;
                int i59 = i35 + i56;
                int i60 = i36 + i57;
                int i61 = i37 + i58;
                i28 = i49 + i59;
                i29 = i50 + i60;
                i31 = i51 + i61;
                i47 = (i47 + 1) % i16;
                int[] iArr12 = iArr9[i47 % i16];
                int i62 = iArr12[0];
                i32 = i52 + i62;
                int i63 = iArr12[1];
                i33 = i53 + i63;
                int i64 = iArr12[2];
                i34 = i54 + i64;
                i35 = i59 - i62;
                i36 = i60 - i63;
                i37 = i61 - i64;
                i25++;
                i48++;
                iArr7 = iArr;
            }
            int[] iArr13 = iArr7;
            i26 += width;
            i24++;
            str = str3;
            height = i46;
            i15 = i45;
        }
        int[] iArr14 = iArr7;
        int i65 = i15;
        int i66 = height;
        String str4 = str;
        int i67 = 0;
        while (i67 < width) {
            int i68 = -i12;
            int i69 = i68 * width;
            int i70 = 0;
            int i71 = 0;
            int i72 = 0;
            int i73 = 0;
            int i74 = 0;
            int i75 = 0;
            int i76 = 0;
            int i77 = 0;
            int i78 = 0;
            while (i68 <= i12) {
                int[] iArr15 = iArr6;
                int max = Math.max(0, i69) + i67;
                int[] iArr16 = iArr9[i68 + i12];
                iArr16[0] = iArr3[max];
                iArr16[1] = iArr4[max];
                iArr16[2] = iArr5[max];
                int abs2 = i23 - Math.abs(i68);
                i70 += iArr3[max] * abs2;
                i71 += iArr4[max] * abs2;
                i72 += iArr5[max] * abs2;
                if (i68 > 0) {
                    i76 += iArr16[0];
                    i77 += iArr16[1];
                    i78 += iArr16[2];
                } else {
                    i73 += iArr16[0];
                    i74 += iArr16[1];
                    i75 += iArr16[2];
                }
                int i79 = i65;
                if (i68 < i79) {
                    i69 += width;
                }
                i68++;
                i65 = i79;
                iArr6 = iArr15;
            }
            int[] iArr17 = iArr6;
            int i80 = i65;
            int i81 = i12;
            int i82 = i67;
            int i83 = i66;
            int i84 = 0;
            while (i84 < i83) {
                iArr2[i82] = (iArr2[i82] & ViewCompat.MEASURED_STATE_MASK) | (iArr14[i70] << 16) | (iArr14[i71] << 8) | iArr14[i72];
                int i85 = i70 - i73;
                int i86 = i71 - i74;
                int i87 = i72 - i75;
                int[] iArr18 = iArr9[((i81 - i12) + i16) % i16];
                int i88 = i73 - iArr18[0];
                int i89 = i74 - iArr18[1];
                int i90 = i75 - iArr18[2];
                if (i67 == 0) {
                    iArr17[i84] = Math.min(i84 + i23, i80) * width;
                }
                int i91 = iArr17[i84] + i67;
                int i92 = iArr3[i91];
                iArr18[0] = i92;
                int i93 = iArr4[i91];
                iArr18[1] = i93;
                int i94 = iArr5[i91];
                iArr18[2] = i94;
                int i95 = i76 + i92;
                int i96 = i77 + i93;
                int i97 = i78 + i94;
                i70 = i85 + i95;
                i71 = i86 + i96;
                i72 = i87 + i97;
                i81 = (i81 + 1) % i16;
                int[] iArr19 = iArr9[i81];
                int i98 = iArr19[0];
                i73 = i88 + i98;
                int i99 = iArr19[1];
                i74 = i89 + i99;
                int i100 = iArr19[2];
                i75 = i90 + i100;
                i76 = i95 - i98;
                i77 = i96 - i99;
                i78 = i97 - i100;
                i82 += width;
                i84++;
                i12 = i11;
            }
            i67++;
            i12 = i11;
            i66 = i83;
            i65 = i80;
            iArr6 = iArr17;
        }
        int i101 = i66;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(width);
        String str5 = str4;
        sb3.append(str5);
        sb3.append(i101);
        sb3.append(str5);
        sb3.append(i21);
        Log.e(str2, sb3.toString());
        bitmap2.setPixels(iArr2, 0, width, 0, 0, width, i101);
        return bitmap2;
    }

    public static Bitmap takeScreenShot(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        decorView.setDrawingCacheEnabled(true);
        decorView.buildDrawingCache();
        Bitmap drawingCache = decorView.getDrawingCache();
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i11 = rect.top;
        Bitmap createBitmap = Bitmap.createBitmap(drawingCache, 0, i11, activity.getWindowManager().getDefaultDisplay().getWidth(), activity.getWindowManager().getDefaultDisplay().getHeight() - i11);
        decorView.destroyDrawingCache();
        return createBitmap;
    }
}
