package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import com.airbnb.lottie.utils.MiscUtils;

public class LottieInterpolatedFloatValue extends LottieInterpolatedValue<Float> {
    public LottieInterpolatedFloatValue(Float f11, Float f12) {
        super(f11, f12);
    }

    /* renamed from: b */
    public Float a(Float f11, Float f12, float f13) {
        return Float.valueOf(MiscUtils.lerp(f11.floatValue(), f12.floatValue(), f13));
    }

    public /* bridge */ /* synthetic */ Object getValue(LottieFrameInfo lottieFrameInfo) {
        return super.getValue(lottieFrameInfo);
    }

    public LottieInterpolatedFloatValue(Float f11, Float f12, Interpolator interpolator) {
        super(f11, f12, interpolator);
    }
}
