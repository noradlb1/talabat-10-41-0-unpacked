package com.google.zxing;

import com.google.zxing.common.detector.MathUtils;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class ResultPoint {

    /* renamed from: x  reason: collision with root package name */
    private final float f47459x;

    /* renamed from: y  reason: collision with root package name */
    private final float f47460y;

    public ResultPoint(float f11, float f12) {
        this.f47459x = f11;
        this.f47460y = f12;
    }

    private static float crossProductZ(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        float f11 = resultPoint2.f47459x;
        float f12 = resultPoint2.f47460y;
        return ((resultPoint3.f47459x - f11) * (resultPoint.f47460y - f12)) - ((resultPoint3.f47460y - f12) * (resultPoint.f47459x - f11));
    }

    public static float distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.distance(resultPoint.f47459x, resultPoint.f47460y, resultPoint2.f47459x, resultPoint2.f47460y);
    }

    public static void orderBestPatterns(ResultPoint[] resultPointArr) {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        float distance = distance(resultPointArr[0], resultPointArr[1]);
        float distance2 = distance(resultPointArr[1], resultPointArr[2]);
        float distance3 = distance(resultPointArr[0], resultPointArr[2]);
        if (distance2 >= distance && distance2 >= distance3) {
            resultPoint3 = resultPointArr[0];
            resultPoint2 = resultPointArr[1];
            resultPoint = resultPointArr[2];
        } else if (distance3 < distance2 || distance3 < distance) {
            resultPoint3 = resultPointArr[2];
            resultPoint2 = resultPointArr[0];
            resultPoint = resultPointArr[1];
        } else {
            resultPoint3 = resultPointArr[1];
            resultPoint2 = resultPointArr[0];
            resultPoint = resultPointArr[2];
        }
        if (crossProductZ(resultPoint2, resultPoint3, resultPoint) < 0.0f) {
            ResultPoint resultPoint4 = resultPoint;
            resultPoint = resultPoint2;
            resultPoint2 = resultPoint4;
        }
        resultPointArr[0] = resultPoint2;
        resultPointArr[1] = resultPoint3;
        resultPointArr[2] = resultPoint;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ResultPoint) {
            ResultPoint resultPoint = (ResultPoint) obj;
            if (this.f47459x == resultPoint.f47459x && this.f47460y == resultPoint.f47460y) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final float getX() {
        return this.f47459x;
    }

    public final float getY() {
        return this.f47460y;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f47459x) * 31) + Float.floatToIntBits(this.f47460y);
    }

    public final String toString() {
        return "(" + this.f47459x + AbstractJsonLexerKt.COMMA + this.f47460y + ')';
    }
}
