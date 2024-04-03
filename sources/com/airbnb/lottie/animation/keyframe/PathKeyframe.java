package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;

public class PathKeyframe extends Keyframe<PointF> {
    @Nullable
    private Path path;
    private final Keyframe<PointF> pointKeyFrame;

    public PathKeyframe(LottieComposition lottieComposition, Keyframe<PointF> keyframe) {
        super(lottieComposition, (PointF) keyframe.startValue, (PointF) keyframe.endValue, keyframe.interpolator, keyframe.xInterpolator, keyframe.yInterpolator, keyframe.startFrame, keyframe.endFrame);
        this.pointKeyFrame = keyframe;
        createPath();
    }

    @Nullable
    public Path a() {
        return this.path;
    }

    public void createPath() {
        boolean z11;
        T t11;
        T t12;
        T t13 = this.endValue;
        if (t13 == null || (t12 = this.startValue) == null || !((PointF) t12).equals(((PointF) t13).x, ((PointF) t13).y)) {
            z11 = false;
        } else {
            z11 = true;
        }
        T t14 = this.startValue;
        if (t14 != null && (t11 = this.endValue) != null && !z11) {
            Keyframe<PointF> keyframe = this.pointKeyFrame;
            this.path = Utils.createPath((PointF) t14, (PointF) t11, keyframe.pathCp1, keyframe.pathCp2);
        }
    }
}
