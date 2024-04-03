package androidx.interpolator.view.animation;

import android.view.animation.Interpolator;

abstract class LookupTableInterpolator implements Interpolator {
    private final float mStepSize;
    private final float[] mValues;

    public LookupTableInterpolator(float[] fArr) {
        this.mValues = fArr;
        this.mStepSize = 1.0f / ((float) (fArr.length - 1));
    }

    public float getInterpolation(float f11) {
        if (f11 >= 1.0f) {
            return 1.0f;
        }
        if (f11 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.mValues;
        int min = Math.min((int) (((float) (fArr.length - 1)) * f11), fArr.length - 2);
        float f12 = this.mStepSize;
        float f13 = (f11 - (((float) min) * f12)) / f12;
        float[] fArr2 = this.mValues;
        float f14 = fArr2[min];
        return f14 + (f13 * (fArr2[min + 1] - f14));
    }
}
