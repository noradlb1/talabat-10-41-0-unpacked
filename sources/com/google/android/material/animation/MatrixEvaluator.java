package com.google.android.material.animation;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import androidx.annotation.NonNull;

public class MatrixEvaluator implements TypeEvaluator<Matrix> {
    private final float[] tempEndValues = new float[9];
    private final Matrix tempMatrix = new Matrix();
    private final float[] tempStartValues = new float[9];

    @NonNull
    public Matrix evaluate(float f11, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
        matrix.getValues(this.tempStartValues);
        matrix2.getValues(this.tempEndValues);
        for (int i11 = 0; i11 < 9; i11++) {
            float[] fArr = this.tempEndValues;
            float f12 = fArr[i11];
            float f13 = this.tempStartValues[i11];
            fArr[i11] = f13 + ((f12 - f13) * f11);
        }
        this.tempMatrix.setValues(this.tempEndValues);
        return this.tempMatrix;
    }
}
