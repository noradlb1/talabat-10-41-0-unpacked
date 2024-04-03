package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;

class PathInterpolatorApi14 implements Interpolator {
    private static final float PRECISION = 0.002f;
    private final float[] mX;
    private final float[] mY;

    private static Path createCubic(float f11, float f12, float f13, float f14) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f11, f12, f13, f14, 1.0f, 1.0f);
        return path;
    }

    private static Path createQuad(float f11, float f12) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f11, f12, 1.0f, 1.0f);
        return path;
    }

    public float getInterpolation(float f11) {
        if (f11 <= 0.0f) {
            return 0.0f;
        }
        if (f11 >= 1.0f) {
            return 1.0f;
        }
        int length = this.mX.length - 1;
        int i11 = 0;
        while (length - i11 > 1) {
            int i12 = (i11 + length) / 2;
            if (f11 < this.mX[i12]) {
                length = i12;
            } else {
                i11 = i12;
            }
        }
        float[] fArr = this.mX;
        float f12 = fArr[length];
        float f13 = fArr[i11];
        float f14 = f12 - f13;
        if (f14 == 0.0f) {
            return this.mY[i11];
        }
        float[] fArr2 = this.mY;
        float f15 = fArr2[i11];
        return f15 + (((f11 - f13) / f14) * (fArr2[length] - f15));
    }
}
