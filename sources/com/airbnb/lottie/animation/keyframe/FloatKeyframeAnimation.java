package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class FloatKeyframeAnimation extends KeyframeAnimation<Float> {
    public FloatKeyframeAnimation(List<Keyframe<Float>> list) {
        super(list);
    }

    public float f(Keyframe<Float> keyframe, float f11) {
        if (keyframe.startValue == null || keyframe.endValue == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        LottieValueCallback<A> lottieValueCallback = this.f40465c;
        if (lottieValueCallback != null) {
            Float f12 = (Float) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), (Float) keyframe.startValue, (Float) keyframe.endValue, f11, d(), getProgress());
            if (f12 != null) {
                return f12.floatValue();
            }
        }
        return MiscUtils.lerp(keyframe.getStartValueFloat(), keyframe.getEndValueFloat(), f11);
    }

    /* renamed from: g */
    public Float getValue(Keyframe<Float> keyframe, float f11) {
        return Float.valueOf(f(keyframe, f11));
    }

    public float getFloatValue() {
        return f(a(), c());
    }
}
