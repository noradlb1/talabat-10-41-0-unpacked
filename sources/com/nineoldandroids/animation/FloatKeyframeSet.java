package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Keyframe;
import java.util.ArrayList;

class FloatKeyframeSet extends KeyframeSet {
    private float deltaValue;
    private boolean firstTime = true;
    private float firstValue;
    private float lastValue;

    public FloatKeyframeSet(Keyframe.FloatKeyframe... floatKeyframeArr) {
        super(floatKeyframeArr);
    }

    public float getFloatValue(float f11) {
        int i11 = this.f52805a;
        if (i11 == 2) {
            if (this.firstTime) {
                this.firstTime = false;
                this.firstValue = ((Keyframe.FloatKeyframe) this.f52809e.get(0)).getFloatValue();
                float floatValue = ((Keyframe.FloatKeyframe) this.f52809e.get(1)).getFloatValue();
                this.lastValue = floatValue;
                this.deltaValue = floatValue - this.firstValue;
            }
            Interpolator interpolator = this.f52808d;
            if (interpolator != null) {
                f11 = interpolator.getInterpolation(f11);
            }
            TypeEvaluator typeEvaluator = this.f52810f;
            if (typeEvaluator == null) {
                return this.firstValue + (f11 * this.deltaValue);
            }
            return ((Number) typeEvaluator.evaluate(f11, Float.valueOf(this.firstValue), Float.valueOf(this.lastValue))).floatValue();
        } else if (f11 <= 0.0f) {
            Keyframe.FloatKeyframe floatKeyframe = (Keyframe.FloatKeyframe) this.f52809e.get(0);
            Keyframe.FloatKeyframe floatKeyframe2 = (Keyframe.FloatKeyframe) this.f52809e.get(1);
            float floatValue2 = floatKeyframe.getFloatValue();
            float floatValue3 = floatKeyframe2.getFloatValue();
            float fraction = floatKeyframe.getFraction();
            float fraction2 = floatKeyframe2.getFraction();
            Interpolator interpolator2 = floatKeyframe2.getInterpolator();
            if (interpolator2 != null) {
                f11 = interpolator2.getInterpolation(f11);
            }
            float f12 = (f11 - fraction) / (fraction2 - fraction);
            TypeEvaluator typeEvaluator2 = this.f52810f;
            if (typeEvaluator2 == null) {
                return floatValue2 + (f12 * (floatValue3 - floatValue2));
            }
            return ((Number) typeEvaluator2.evaluate(f12, Float.valueOf(floatValue2), Float.valueOf(floatValue3))).floatValue();
        } else if (f11 >= 1.0f) {
            Keyframe.FloatKeyframe floatKeyframe3 = (Keyframe.FloatKeyframe) this.f52809e.get(i11 - 2);
            Keyframe.FloatKeyframe floatKeyframe4 = (Keyframe.FloatKeyframe) this.f52809e.get(this.f52805a - 1);
            float floatValue4 = floatKeyframe3.getFloatValue();
            float floatValue5 = floatKeyframe4.getFloatValue();
            float fraction3 = floatKeyframe3.getFraction();
            float fraction4 = floatKeyframe4.getFraction();
            Interpolator interpolator3 = floatKeyframe4.getInterpolator();
            if (interpolator3 != null) {
                f11 = interpolator3.getInterpolation(f11);
            }
            float f13 = (f11 - fraction3) / (fraction4 - fraction3);
            TypeEvaluator typeEvaluator3 = this.f52810f;
            if (typeEvaluator3 == null) {
                return floatValue4 + (f13 * (floatValue5 - floatValue4));
            }
            return ((Number) typeEvaluator3.evaluate(f13, Float.valueOf(floatValue4), Float.valueOf(floatValue5))).floatValue();
        } else {
            Keyframe.FloatKeyframe floatKeyframe5 = (Keyframe.FloatKeyframe) this.f52809e.get(0);
            int i12 = 1;
            while (true) {
                int i13 = this.f52805a;
                if (i12 >= i13) {
                    return ((Number) this.f52809e.get(i13 - 1).getValue()).floatValue();
                }
                Keyframe.FloatKeyframe floatKeyframe6 = (Keyframe.FloatKeyframe) this.f52809e.get(i12);
                if (f11 < floatKeyframe6.getFraction()) {
                    Interpolator interpolator4 = floatKeyframe6.getInterpolator();
                    if (interpolator4 != null) {
                        f11 = interpolator4.getInterpolation(f11);
                    }
                    float fraction5 = (f11 - floatKeyframe5.getFraction()) / (floatKeyframe6.getFraction() - floatKeyframe5.getFraction());
                    float floatValue6 = floatKeyframe5.getFloatValue();
                    float floatValue7 = floatKeyframe6.getFloatValue();
                    TypeEvaluator typeEvaluator4 = this.f52810f;
                    if (typeEvaluator4 == null) {
                        return floatValue6 + (fraction5 * (floatValue7 - floatValue6));
                    }
                    return ((Number) typeEvaluator4.evaluate(fraction5, Float.valueOf(floatValue6), Float.valueOf(floatValue7))).floatValue();
                }
                i12++;
                floatKeyframe5 = floatKeyframe6;
            }
        }
    }

    public Object getValue(float f11) {
        return Float.valueOf(getFloatValue(f11));
    }

    public FloatKeyframeSet clone() {
        ArrayList<Keyframe> arrayList = this.f52809e;
        int size = arrayList.size();
        Keyframe.FloatKeyframe[] floatKeyframeArr = new Keyframe.FloatKeyframe[size];
        for (int i11 = 0; i11 < size; i11++) {
            floatKeyframeArr[i11] = (Keyframe.FloatKeyframe) arrayList.get(i11).clone();
        }
        return new FloatKeyframeSet(floatKeyframeArr);
    }
}
