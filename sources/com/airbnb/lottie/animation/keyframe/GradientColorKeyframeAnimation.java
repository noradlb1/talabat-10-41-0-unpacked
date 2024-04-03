package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.value.Keyframe;
import java.util.List;

public class GradientColorKeyframeAnimation extends KeyframeAnimation<GradientColor> {
    private final GradientColor gradientColor;

    public GradientColorKeyframeAnimation(List<Keyframe<GradientColor>> list) {
        super(list);
        int i11 = 0;
        GradientColor gradientColor2 = (GradientColor) list.get(0).startValue;
        i11 = gradientColor2 != null ? gradientColor2.getSize() : i11;
        this.gradientColor = new GradientColor(new float[i11], new int[i11]);
    }

    /* renamed from: f */
    public GradientColor getValue(Keyframe<GradientColor> keyframe, float f11) {
        this.gradientColor.lerp((GradientColor) keyframe.startValue, (GradientColor) keyframe.endValue, f11);
        return this.gradientColor;
    }
}
