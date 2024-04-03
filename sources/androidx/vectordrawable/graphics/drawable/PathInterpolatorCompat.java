package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class PathInterpolatorCompat implements Interpolator {
    public static final double EPSILON = 1.0E-5d;
    public static final int MAX_NUM_POINTS = 3000;
    private static final float PRECISION = 0.002f;
    private float[] mX;
    private float[] mY;

    public PathInterpolatorCompat(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    private void initCubic(float f11, float f12, float f13, float f14) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f11, f12, f13, f14, 1.0f, 1.0f);
        initPath(path);
    }

    private void initPath(Path path) {
        int i11 = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min(3000, ((int) (length / 0.002f)) + 1);
        if (min > 0) {
            this.mX = new float[min];
            this.mY = new float[min];
            float[] fArr = new float[2];
            for (int i12 = 0; i12 < min; i12++) {
                pathMeasure.getPosTan((((float) i12) * length) / ((float) (min - 1)), fArr, (float[]) null);
                this.mX[i12] = fArr[0];
                this.mY[i12] = fArr[1];
            }
            if (((double) Math.abs(this.mX[0])) <= 1.0E-5d && ((double) Math.abs(this.mY[0])) <= 1.0E-5d) {
                int i13 = min - 1;
                if (((double) Math.abs(this.mX[i13] - 1.0f)) <= 1.0E-5d && ((double) Math.abs(this.mY[i13] - 1.0f)) <= 1.0E-5d) {
                    float f11 = 0.0f;
                    int i14 = 0;
                    while (i11 < min) {
                        float[] fArr2 = this.mX;
                        int i15 = i14 + 1;
                        float f12 = fArr2[i14];
                        if (f12 >= f11) {
                            fArr2[i11] = f12;
                            i11++;
                            f11 = f12;
                            i14 = i15;
                        } else {
                            throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f12);
                        }
                    }
                    if (pathMeasure.nextContour()) {
                        throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                    }
                    return;
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("The Path must start at (0,0) and end at (1,1) start: ");
            sb2.append(this.mX[0]);
            sb2.append(",");
            sb2.append(this.mY[0]);
            sb2.append(" end:");
            int i16 = min - 1;
            sb2.append(this.mX[i16]);
            sb2.append(",");
            sb2.append(this.mY[i16]);
            throw new IllegalArgumentException(sb2.toString());
        }
        throw new IllegalArgumentException("The Path has a invalid length " + length);
    }

    private void initQuad(float f11, float f12) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f11, f12, 1.0f, 1.0f);
        initPath(path);
    }

    private void parseInterpolatorFromTypeArray(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
            String namedString = TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "pathData", 4);
            Path createPathFromPathData = PathParser.createPathFromPathData(namedString);
            if (createPathFromPathData != null) {
                initPath(createPathFromPathData);
                return;
            }
            throw new InflateException("The path is null, which is created from " + namedString);
        } else if (!TypedArrayUtils.hasAttribute(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        } else if (TypedArrayUtils.hasAttribute(xmlPullParser, "controlY1")) {
            float namedFloat = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
            float namedFloat2 = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
            boolean hasAttribute = TypedArrayUtils.hasAttribute(xmlPullParser, "controlX2");
            if (hasAttribute != TypedArrayUtils.hasAttribute(xmlPullParser, "controlY2")) {
                throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
            } else if (!hasAttribute) {
                initQuad(namedFloat, namedFloat2);
            } else {
                initCubic(namedFloat, namedFloat2, TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlX2", 2, 0.0f), TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
            }
        } else {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
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

    public PathInterpolatorCompat(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.STYLEABLE_PATH_INTERPOLATOR);
        parseInterpolatorFromTypeArray(obtainAttributes, xmlPullParser);
        obtainAttributes.recycle();
    }
}
