package com.github.chrisbanes.photoview;

import android.widget.ImageView;
import androidx.core.view.MotionEventCompat;

class Util {

    /* renamed from: com.github.chrisbanes.photoview.Util$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f33623a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f33623a = iArr;
            try {
                iArr[ImageView.ScaleType.MATRIX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static void a(float f11, float f12, float f13) {
        if (f11 >= f12) {
            throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        } else if (f12 >= f13) {
            throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
    }

    public static int b(int i11) {
        return (i11 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    public static boolean c(ImageView imageView) {
        return imageView.getDrawable() != null;
    }

    public static boolean d(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (AnonymousClass1.f33623a[scaleType.ordinal()] != 1) {
            return true;
        }
        throw new IllegalStateException("Matrix scale type is not supported");
    }
}
