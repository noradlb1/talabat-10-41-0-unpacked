package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Keyframe;
import java.util.ArrayList;

class IntKeyframeSet extends KeyframeSet {
    private int deltaValue;
    private boolean firstTime = true;
    private int firstValue;
    private int lastValue;

    public IntKeyframeSet(Keyframe.IntKeyframe... intKeyframeArr) {
        super(intKeyframeArr);
    }

    public int getIntValue(float f11) {
        int i11 = this.f52805a;
        if (i11 == 2) {
            if (this.firstTime) {
                this.firstTime = false;
                this.firstValue = ((Keyframe.IntKeyframe) this.f52809e.get(0)).getIntValue();
                int intValue = ((Keyframe.IntKeyframe) this.f52809e.get(1)).getIntValue();
                this.lastValue = intValue;
                this.deltaValue = intValue - this.firstValue;
            }
            Interpolator interpolator = this.f52808d;
            if (interpolator != null) {
                f11 = interpolator.getInterpolation(f11);
            }
            TypeEvaluator typeEvaluator = this.f52810f;
            if (typeEvaluator == null) {
                return this.firstValue + ((int) (f11 * ((float) this.deltaValue)));
            }
            return ((Number) typeEvaluator.evaluate(f11, Integer.valueOf(this.firstValue), Integer.valueOf(this.lastValue))).intValue();
        } else if (f11 <= 0.0f) {
            Keyframe.IntKeyframe intKeyframe = (Keyframe.IntKeyframe) this.f52809e.get(0);
            Keyframe.IntKeyframe intKeyframe2 = (Keyframe.IntKeyframe) this.f52809e.get(1);
            int intValue2 = intKeyframe.getIntValue();
            int intValue3 = intKeyframe2.getIntValue();
            float fraction = intKeyframe.getFraction();
            float fraction2 = intKeyframe2.getFraction();
            Interpolator interpolator2 = intKeyframe2.getInterpolator();
            if (interpolator2 != null) {
                f11 = interpolator2.getInterpolation(f11);
            }
            float f12 = (f11 - fraction) / (fraction2 - fraction);
            TypeEvaluator typeEvaluator2 = this.f52810f;
            if (typeEvaluator2 == null) {
                return intValue2 + ((int) (f12 * ((float) (intValue3 - intValue2))));
            }
            return ((Number) typeEvaluator2.evaluate(f12, Integer.valueOf(intValue2), Integer.valueOf(intValue3))).intValue();
        } else if (f11 >= 1.0f) {
            Keyframe.IntKeyframe intKeyframe3 = (Keyframe.IntKeyframe) this.f52809e.get(i11 - 2);
            Keyframe.IntKeyframe intKeyframe4 = (Keyframe.IntKeyframe) this.f52809e.get(this.f52805a - 1);
            int intValue4 = intKeyframe3.getIntValue();
            int intValue5 = intKeyframe4.getIntValue();
            float fraction3 = intKeyframe3.getFraction();
            float fraction4 = intKeyframe4.getFraction();
            Interpolator interpolator3 = intKeyframe4.getInterpolator();
            if (interpolator3 != null) {
                f11 = interpolator3.getInterpolation(f11);
            }
            float f13 = (f11 - fraction3) / (fraction4 - fraction3);
            TypeEvaluator typeEvaluator3 = this.f52810f;
            if (typeEvaluator3 == null) {
                return intValue4 + ((int) (f13 * ((float) (intValue5 - intValue4))));
            }
            return ((Number) typeEvaluator3.evaluate(f13, Integer.valueOf(intValue4), Integer.valueOf(intValue5))).intValue();
        } else {
            Keyframe.IntKeyframe intKeyframe5 = (Keyframe.IntKeyframe) this.f52809e.get(0);
            int i12 = 1;
            while (true) {
                int i13 = this.f52805a;
                if (i12 >= i13) {
                    return ((Number) this.f52809e.get(i13 - 1).getValue()).intValue();
                }
                Keyframe.IntKeyframe intKeyframe6 = (Keyframe.IntKeyframe) this.f52809e.get(i12);
                if (f11 < intKeyframe6.getFraction()) {
                    Interpolator interpolator4 = intKeyframe6.getInterpolator();
                    if (interpolator4 != null) {
                        f11 = interpolator4.getInterpolation(f11);
                    }
                    float fraction5 = (f11 - intKeyframe5.getFraction()) / (intKeyframe6.getFraction() - intKeyframe5.getFraction());
                    int intValue6 = intKeyframe5.getIntValue();
                    int intValue7 = intKeyframe6.getIntValue();
                    TypeEvaluator typeEvaluator4 = this.f52810f;
                    if (typeEvaluator4 == null) {
                        return intValue6 + ((int) (fraction5 * ((float) (intValue7 - intValue6))));
                    }
                    return ((Number) typeEvaluator4.evaluate(fraction5, Integer.valueOf(intValue6), Integer.valueOf(intValue7))).intValue();
                }
                i12++;
                intKeyframe5 = intKeyframe6;
            }
        }
    }

    public Object getValue(float f11) {
        return Integer.valueOf(getIntValue(f11));
    }

    public IntKeyframeSet clone() {
        ArrayList<Keyframe> arrayList = this.f52809e;
        int size = arrayList.size();
        Keyframe.IntKeyframe[] intKeyframeArr = new Keyframe.IntKeyframe[size];
        for (int i11 = 0; i11 < size; i11++) {
            intKeyframeArr[i11] = (Keyframe.IntKeyframe) arrayList.get(i11).clone();
        }
        return new IntKeyframeSet(intKeyframeArr);
    }
}
