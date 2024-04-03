package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import org.xmlpull.v1.XmlPullParser;

public class PatternPathMotion extends PathMotion {
    private Path mOriginalPatternPath;
    private final Path mPatternPath;
    private final Matrix mTempMatrix;

    public PatternPathMotion() {
        Path path = new Path();
        this.mPatternPath = path;
        this.mTempMatrix = new Matrix();
        path.lineTo(1.0f, 0.0f);
        this.mOriginalPatternPath = path;
    }

    private static float distance(float f11, float f12) {
        return (float) Math.sqrt((double) ((f11 * f11) + (f12 * f12)));
    }

    @NonNull
    public Path getPath(float f11, float f12, float f13, float f14) {
        float f15 = f13 - f11;
        float f16 = f14 - f12;
        float distance = distance(f15, f16);
        double atan2 = Math.atan2((double) f16, (double) f15);
        this.mTempMatrix.setScale(distance, distance);
        this.mTempMatrix.postRotate((float) Math.toDegrees(atan2));
        this.mTempMatrix.postTranslate(f11, f12);
        Path path = new Path();
        this.mPatternPath.transform(this.mTempMatrix, path);
        return path;
    }

    public Path getPatternPath() {
        return this.mOriginalPatternPath;
    }

    public void setPatternPath(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, (float[]) null);
        float f11 = fArr[0];
        float f12 = fArr[1];
        pathMeasure.getPosTan(0.0f, fArr, (float[]) null);
        float f13 = fArr[0];
        float f14 = fArr[1];
        if (f13 == f11 && f14 == f12) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        this.mTempMatrix.setTranslate(-f13, -f14);
        float f15 = f11 - f13;
        float f16 = f12 - f14;
        float distance = 1.0f / distance(f15, f16);
        this.mTempMatrix.postScale(distance, distance);
        this.mTempMatrix.postRotate((float) Math.toDegrees(-Math.atan2((double) f16, (double) f15)));
        path.transform(this.mTempMatrix, this.mPatternPath);
        this.mOriginalPatternPath = path;
    }

    @SuppressLint({"RestrictedApi"})
    public PatternPathMotion(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        this.mPatternPath = new Path();
        this.mTempMatrix = new Matrix();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f37790k);
        try {
            String namedString = TypedArrayUtils.getNamedString(obtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (namedString != null) {
                setPatternPath(PathParser.createPathFromPathData(namedString));
                return;
            }
            throw new RuntimeException("pathData must be supplied for patternPathMotion");
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public PatternPathMotion(Path path) {
        this.mPatternPath = new Path();
        this.mTempMatrix = new Matrix();
        setPatternPath(path);
    }
}
