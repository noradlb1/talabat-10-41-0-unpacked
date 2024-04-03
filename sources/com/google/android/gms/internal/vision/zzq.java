package com.google.android.gms.internal.vision;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public final class zzq {
    public static Bitmap zzb(Bitmap bitmap, zzp zzp) {
        int i11;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (zzp.rotation != 0) {
            Matrix matrix = new Matrix();
            int i12 = zzp.rotation;
            if (i12 == 0) {
                i11 = 0;
            } else if (i12 == 1) {
                i11 = 90;
            } else if (i12 == 2) {
                i11 = 180;
            } else if (i12 == 3) {
                i11 = 270;
            } else {
                throw new IllegalArgumentException("Unsupported rotation degree.");
            }
            matrix.postRotate((float) i11);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        }
        int i13 = zzp.rotation;
        if (i13 == 1 || i13 == 3) {
            zzp.width = height;
            zzp.height = width;
        }
        return bitmap;
    }
}
