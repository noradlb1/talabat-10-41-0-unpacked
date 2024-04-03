package androidx.transition;

import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

class PathProperty<T> extends Property<T, Float> {
    private float mCurrentFraction;
    private final float mPathLength;
    private final PathMeasure mPathMeasure;
    private final PointF mPointF;
    private final float[] mPosition;
    private final Property<T, PointF> mProperty;

    public Float get(T t11) {
        return Float.valueOf(this.mCurrentFraction);
    }

    public void set(T t11, Float f11) {
        this.mCurrentFraction = f11.floatValue();
        this.mPathMeasure.getPosTan(this.mPathLength * f11.floatValue(), this.mPosition, (float[]) null);
        PointF pointF = this.mPointF;
        float[] fArr = this.mPosition;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.mProperty.set(t11, pointF);
    }
}
