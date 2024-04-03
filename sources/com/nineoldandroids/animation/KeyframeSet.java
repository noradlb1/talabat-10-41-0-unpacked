package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Keyframe;
import java.util.ArrayList;
import java.util.Arrays;

class KeyframeSet {

    /* renamed from: a  reason: collision with root package name */
    public int f52805a;

    /* renamed from: b  reason: collision with root package name */
    public Keyframe f52806b = this.f52809e.get(0);

    /* renamed from: c  reason: collision with root package name */
    public Keyframe f52807c;

    /* renamed from: d  reason: collision with root package name */
    public Interpolator f52808d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<Keyframe> f52809e;

    /* renamed from: f  reason: collision with root package name */
    public TypeEvaluator f52810f;

    public KeyframeSet(Keyframe... keyframeArr) {
        this.f52805a = keyframeArr.length;
        ArrayList<Keyframe> arrayList = new ArrayList<>();
        this.f52809e = arrayList;
        arrayList.addAll(Arrays.asList(keyframeArr));
        Keyframe keyframe = this.f52809e.get(this.f52805a - 1);
        this.f52807c = keyframe;
        this.f52808d = keyframe.getInterpolator();
    }

    public static KeyframeSet ofFloat(float... fArr) {
        int length = fArr.length;
        Keyframe.FloatKeyframe[] floatKeyframeArr = new Keyframe.FloatKeyframe[Math.max(length, 2)];
        if (length == 1) {
            floatKeyframeArr[0] = (Keyframe.FloatKeyframe) Keyframe.ofFloat(0.0f);
            floatKeyframeArr[1] = (Keyframe.FloatKeyframe) Keyframe.ofFloat(1.0f, fArr[0]);
        } else {
            floatKeyframeArr[0] = (Keyframe.FloatKeyframe) Keyframe.ofFloat(0.0f, fArr[0]);
            for (int i11 = 1; i11 < length; i11++) {
                floatKeyframeArr[i11] = (Keyframe.FloatKeyframe) Keyframe.ofFloat(((float) i11) / ((float) (length - 1)), fArr[i11]);
            }
        }
        return new FloatKeyframeSet(floatKeyframeArr);
    }

    public static KeyframeSet ofInt(int... iArr) {
        int length = iArr.length;
        Keyframe.IntKeyframe[] intKeyframeArr = new Keyframe.IntKeyframe[Math.max(length, 2)];
        if (length == 1) {
            intKeyframeArr[0] = (Keyframe.IntKeyframe) Keyframe.ofInt(0.0f);
            intKeyframeArr[1] = (Keyframe.IntKeyframe) Keyframe.ofInt(1.0f, iArr[0]);
        } else {
            intKeyframeArr[0] = (Keyframe.IntKeyframe) Keyframe.ofInt(0.0f, iArr[0]);
            for (int i11 = 1; i11 < length; i11++) {
                intKeyframeArr[i11] = (Keyframe.IntKeyframe) Keyframe.ofInt(((float) i11) / ((float) (length - 1)), iArr[i11]);
            }
        }
        return new IntKeyframeSet(intKeyframeArr);
    }

    public static KeyframeSet ofKeyframe(Keyframe... keyframeArr) {
        int i11 = 0;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        for (Keyframe keyframe : keyframeArr) {
            if (keyframe instanceof Keyframe.FloatKeyframe) {
                z11 = true;
            } else if (keyframe instanceof Keyframe.IntKeyframe) {
                z12 = true;
            } else {
                z13 = true;
            }
        }
        if (z11 && !z12 && !z13) {
            Keyframe.FloatKeyframe[] floatKeyframeArr = new Keyframe.FloatKeyframe[r0];
            while (i11 < r0) {
                floatKeyframeArr[i11] = keyframeArr[i11];
                i11++;
            }
            return new FloatKeyframeSet(floatKeyframeArr);
        } else if (!z12 || z11 || z13) {
            return new KeyframeSet(keyframeArr);
        } else {
            Keyframe.IntKeyframe[] intKeyframeArr = new Keyframe.IntKeyframe[r0];
            while (i11 < r0) {
                intKeyframeArr[i11] = keyframeArr[i11];
                i11++;
            }
            return new IntKeyframeSet(intKeyframeArr);
        }
    }

    public static KeyframeSet ofObject(Object... objArr) {
        int length = objArr.length;
        Keyframe.ObjectKeyframe[] objectKeyframeArr = new Keyframe.ObjectKeyframe[Math.max(length, 2)];
        if (length == 1) {
            objectKeyframeArr[0] = (Keyframe.ObjectKeyframe) Keyframe.ofObject(0.0f);
            objectKeyframeArr[1] = (Keyframe.ObjectKeyframe) Keyframe.ofObject(1.0f, objArr[0]);
        } else {
            objectKeyframeArr[0] = (Keyframe.ObjectKeyframe) Keyframe.ofObject(0.0f, objArr[0]);
            for (int i11 = 1; i11 < length; i11++) {
                objectKeyframeArr[i11] = (Keyframe.ObjectKeyframe) Keyframe.ofObject(((float) i11) / ((float) (length - 1)), objArr[i11]);
            }
        }
        return new KeyframeSet(objectKeyframeArr);
    }

    public Object getValue(float f11) {
        int i11 = this.f52805a;
        if (i11 == 2) {
            Interpolator interpolator = this.f52808d;
            if (interpolator != null) {
                f11 = interpolator.getInterpolation(f11);
            }
            return this.f52810f.evaluate(f11, this.f52806b.getValue(), this.f52807c.getValue());
        }
        int i12 = 1;
        if (f11 <= 0.0f) {
            Keyframe keyframe = this.f52809e.get(1);
            Interpolator interpolator2 = keyframe.getInterpolator();
            if (interpolator2 != null) {
                f11 = interpolator2.getInterpolation(f11);
            }
            float fraction = this.f52806b.getFraction();
            return this.f52810f.evaluate((f11 - fraction) / (keyframe.getFraction() - fraction), this.f52806b.getValue(), keyframe.getValue());
        } else if (f11 >= 1.0f) {
            Keyframe keyframe2 = this.f52809e.get(i11 - 2);
            Interpolator interpolator3 = this.f52807c.getInterpolator();
            if (interpolator3 != null) {
                f11 = interpolator3.getInterpolation(f11);
            }
            float fraction2 = keyframe2.getFraction();
            return this.f52810f.evaluate((f11 - fraction2) / (this.f52807c.getFraction() - fraction2), keyframe2.getValue(), this.f52807c.getValue());
        } else {
            Keyframe keyframe3 = this.f52806b;
            while (i12 < this.f52805a) {
                Keyframe keyframe4 = this.f52809e.get(i12);
                if (f11 < keyframe4.getFraction()) {
                    Interpolator interpolator4 = keyframe4.getInterpolator();
                    if (interpolator4 != null) {
                        f11 = interpolator4.getInterpolation(f11);
                    }
                    float fraction3 = keyframe3.getFraction();
                    return this.f52810f.evaluate((f11 - fraction3) / (keyframe4.getFraction() - fraction3), keyframe3.getValue(), keyframe4.getValue());
                }
                i12++;
                keyframe3 = keyframe4;
            }
            return this.f52807c.getValue();
        }
    }

    public void setEvaluator(TypeEvaluator typeEvaluator) {
        this.f52810f = typeEvaluator;
    }

    public String toString() {
        String str = " ";
        for (int i11 = 0; i11 < this.f52805a; i11++) {
            str = str + this.f52809e.get(i11).getValue() + "  ";
        }
        return str;
    }

    public KeyframeSet clone() {
        ArrayList<Keyframe> arrayList = this.f52809e;
        int size = arrayList.size();
        Keyframe[] keyframeArr = new Keyframe[size];
        for (int i11 = 0; i11 < size; i11++) {
            keyframeArr[i11] = arrayList.get(i11).clone();
        }
        return new KeyframeSet(keyframeArr);
    }
}
