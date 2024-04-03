package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class IntegerKeyframeAnimation extends KeyframeAnimation<Integer> {
    public IntegerKeyframeAnimation(List<Keyframe<Integer>> list) {
        super(list);
    }

    /* renamed from: f */
    public Integer getValue(Keyframe<Integer> keyframe, float f11) {
        return Integer.valueOf(getIntValue(keyframe, f11));
    }

    public int getIntValue(Keyframe<Integer> keyframe, float f11) {
        if (keyframe.startValue == null || keyframe.endValue == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        LottieValueCallback<A> lottieValueCallback = this.f40465c;
        if (lottieValueCallback != null) {
            Integer num = (Integer) lottieValueCallback.getValueInternal(keyframe.startFrame, keyframe.endFrame.floatValue(), (Integer) keyframe.startValue, (Integer) keyframe.endValue, f11, d(), getProgress());
            if (num != null) {
                return num.intValue();
            }
        }
        return MiscUtils.lerp(keyframe.getStartValueInt(), keyframe.getEndValueInt(), f11);
    }

    public int getIntValue() {
        return getIntValue(a(), c());
    }
}
