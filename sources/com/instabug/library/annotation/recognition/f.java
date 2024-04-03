package com.instabug.library.annotation.recognition;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;

public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    private static final RectF f34136a = new RectF(0.0f, 0.0f, 28.0f, 28.0f);

    public static Path a(Path path) {
        Path path2 = new Path(path);
        RectF rectF = new RectF();
        path2.computeBounds(rectF, true);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(rectF, f34136a, Matrix.ScaleToFit.CENTER);
        path2.transform(matrix);
        return path2;
    }

    public static Path a(Path path, int i11) {
        Path path2 = new Path(path);
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i11, 14.0f, 14.0f);
        path2.transform(matrix);
        return a(path2);
    }
}
