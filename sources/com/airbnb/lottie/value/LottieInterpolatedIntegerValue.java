package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import com.airbnb.lottie.utils.MiscUtils;

public class LottieInterpolatedIntegerValue extends LottieInterpolatedValue<Integer> {
    public LottieInterpolatedIntegerValue(Integer num, Integer num2) {
        super(num, num2);
    }

    /* renamed from: b */
    public Integer a(Integer num, Integer num2, float f11) {
        return Integer.valueOf(MiscUtils.lerp(num.intValue(), num2.intValue(), f11));
    }

    public /* bridge */ /* synthetic */ Object getValue(LottieFrameInfo lottieFrameInfo) {
        return super.getValue(lottieFrameInfo);
    }

    public LottieInterpolatedIntegerValue(Integer num, Integer num2, Interpolator interpolator) {
        super(num, num2, interpolator);
    }
}
