package com.airbnb.lottie.value;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.utils.MiscUtils;

public class LottieInterpolatedPointValue extends LottieInterpolatedValue<PointF> {
    private final PointF point = new PointF();

    public LottieInterpolatedPointValue(PointF pointF, PointF pointF2) {
        super(pointF, pointF2);
    }

    /* renamed from: b */
    public PointF a(PointF pointF, PointF pointF2, float f11) {
        this.point.set(MiscUtils.lerp(pointF.x, pointF2.x, f11), MiscUtils.lerp(pointF.y, pointF2.y, f11));
        return this.point;
    }

    public /* bridge */ /* synthetic */ Object getValue(LottieFrameInfo lottieFrameInfo) {
        return super.getValue(lottieFrameInfo);
    }

    public LottieInterpolatedPointValue(PointF pointF, PointF pointF2, Interpolator interpolator) {
        super(pointF, pointF2, interpolator);
    }
}
