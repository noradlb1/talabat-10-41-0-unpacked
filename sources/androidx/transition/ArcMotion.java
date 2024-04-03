package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;

public class ArcMotion extends PathMotion {
    private static final float DEFAULT_MAX_ANGLE_DEGREES = 70.0f;
    private static final float DEFAULT_MAX_TANGENT = ((float) Math.tan(Math.toRadians(35.0d)));
    private static final float DEFAULT_MIN_ANGLE_DEGREES = 0.0f;
    private float mMaximumAngle = DEFAULT_MAX_ANGLE_DEGREES;
    private float mMaximumTangent = DEFAULT_MAX_TANGENT;
    private float mMinimumHorizontalAngle = 0.0f;
    private float mMinimumHorizontalTangent = 0.0f;
    private float mMinimumVerticalAngle = 0.0f;
    private float mMinimumVerticalTangent = 0.0f;

    public ArcMotion() {
    }

    private static float toTangent(float f11) {
        if (f11 >= 0.0f && f11 <= 90.0f) {
            return (float) Math.tan(Math.toRadians((double) (f11 / 2.0f)));
        }
        throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
    }

    public float getMaximumAngle() {
        return this.mMaximumAngle;
    }

    public float getMinimumHorizontalAngle() {
        return this.mMinimumHorizontalAngle;
    }

    public float getMinimumVerticalAngle() {
        return this.mMinimumVerticalAngle;
    }

    @NonNull
    public Path getPath(float f11, float f12, float f13, float f14) {
        boolean z11;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        Path path = new Path();
        path.moveTo(f11, f12);
        float f21 = f13 - f11;
        float f22 = f14 - f12;
        float f23 = (f21 * f21) + (f22 * f22);
        float f24 = (f11 + f13) / 2.0f;
        float f25 = (f12 + f14) / 2.0f;
        float f26 = 0.25f * f23;
        if (f12 > f14) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (Math.abs(f21) < Math.abs(f22)) {
            float abs = Math.abs(f23 / (f22 * 2.0f));
            if (z11) {
                f17 = abs + f14;
                f16 = f13;
            } else {
                f17 = abs + f12;
                f16 = f11;
            }
            f15 = this.mMinimumVerticalTangent;
        } else {
            float f27 = f23 / (f21 * 2.0f);
            if (z11) {
                f19 = f12;
                f18 = f27 + f11;
            } else {
                f18 = f13 - f27;
                f19 = f14;
            }
            f15 = this.mMinimumHorizontalTangent;
        }
        float f28 = f26 * f15 * f15;
        float f29 = f24 - f16;
        float f31 = f25 - f17;
        float f32 = (f29 * f29) + (f31 * f31);
        float f33 = this.mMaximumTangent;
        float f34 = f26 * f33 * f33;
        if (f32 >= f28) {
            if (f32 > f34) {
                f28 = f34;
            } else {
                f28 = 0.0f;
            }
        }
        if (f28 != 0.0f) {
            float sqrt = (float) Math.sqrt((double) (f28 / f32));
            f16 = ((f16 - f24) * sqrt) + f24;
            f17 = f25 + (sqrt * (f17 - f25));
        }
        path.cubicTo((f11 + f16) / 2.0f, (f12 + f17) / 2.0f, (f16 + f13) / 2.0f, (f17 + f14) / 2.0f, f13, f14);
        return path;
    }

    public void setMaximumAngle(float f11) {
        this.mMaximumAngle = f11;
        this.mMaximumTangent = toTangent(f11);
    }

    public void setMinimumHorizontalAngle(float f11) {
        this.mMinimumHorizontalAngle = f11;
        this.mMinimumHorizontalTangent = toTangent(f11);
    }

    public void setMinimumVerticalAngle(float f11) {
        this.mMinimumVerticalAngle = f11;
        this.mMinimumVerticalTangent = toTangent(f11);
    }

    @SuppressLint({"RestrictedApi"})
    public ArcMotion(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.f37789j);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        setMinimumVerticalAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        setMinimumHorizontalAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        setMaximumAngle(TypedArrayUtils.getNamedFloat(obtainStyledAttributes, xmlPullParser, "maximumAngle", 2, DEFAULT_MAX_ANGLE_DEGREES));
        obtainStyledAttributes.recycle();
    }
}
