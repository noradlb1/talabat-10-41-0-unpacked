package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class PathKeyframeAnimation extends KeyframeAnimation<PointF> {
    private final PathMeasure pathMeasure = new PathMeasure();
    private PathKeyframe pathMeasureKeyframe;
    private final PointF point = new PointF();
    private final float[] pos = new float[2];

    public PathKeyframeAnimation(List<? extends Keyframe<PointF>> list) {
        super(list);
    }

    public PointF getValue(Keyframe<PointF> keyframe, float f11) {
        PathKeyframe pathKeyframe = (PathKeyframe) keyframe;
        Path a11 = pathKeyframe.a();
        if (a11 == null) {
            return (PointF) keyframe.startValue;
        }
        LottieValueCallback<A> lottieValueCallback = this.f40465c;
        if (lottieValueCallback != null) {
            PointF pointF = (PointF) lottieValueCallback.getValueInternal(pathKeyframe.startFrame, pathKeyframe.endFrame.floatValue(), (PointF) pathKeyframe.startValue, (PointF) pathKeyframe.endValue, d(), f11, getProgress());
            if (pointF != null) {
                return pointF;
            }
        }
        if (this.pathMeasureKeyframe != pathKeyframe) {
            this.pathMeasure.setPath(a11, false);
            this.pathMeasureKeyframe = pathKeyframe;
        }
        PathMeasure pathMeasure2 = this.pathMeasure;
        pathMeasure2.getPosTan(f11 * pathMeasure2.getLength(), this.pos, (float[]) null);
        PointF pointF2 = this.point;
        float[] fArr = this.pos;
        pointF2.set(fArr[0], fArr[1]);
        return this.point;
    }
}
