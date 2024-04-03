package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.Collections;

public class SplitDimensionPathKeyframeAnimation extends BaseKeyframeAnimation<PointF, PointF> {
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public LottieValueCallback<Float> f40468d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public LottieValueCallback<Float> f40469e;
    private final PointF point = new PointF();
    private final PointF pointWithCallbackValues = new PointF();
    private final BaseKeyframeAnimation<Float, Float> xAnimation;
    private final BaseKeyframeAnimation<Float, Float> yAnimation;

    public SplitDimensionPathKeyframeAnimation(BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation, BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2) {
        super(Collections.emptyList());
        this.xAnimation = baseKeyframeAnimation;
        this.yAnimation = baseKeyframeAnimation2;
        setProgress(getProgress());
    }

    public void setProgress(float f11) {
        this.xAnimation.setProgress(f11);
        this.yAnimation.setProgress(f11);
        this.point.set(this.xAnimation.getValue().floatValue(), this.yAnimation.getValue().floatValue());
        for (int i11 = 0; i11 < this.f40463a.size(); i11++) {
            this.f40463a.get(i11).onValueChanged();
        }
    }

    public void setXValueCallback(@Nullable LottieValueCallback<Float> lottieValueCallback) {
        LottieValueCallback<Float> lottieValueCallback2 = this.f40468d;
        if (lottieValueCallback2 != null) {
            lottieValueCallback2.setAnimation((BaseKeyframeAnimation<?, ?>) null);
        }
        this.f40468d = lottieValueCallback;
        if (lottieValueCallback != null) {
            lottieValueCallback.setAnimation(this);
        }
    }

    public void setYValueCallback(@Nullable LottieValueCallback<Float> lottieValueCallback) {
        LottieValueCallback<Float> lottieValueCallback2 = this.f40469e;
        if (lottieValueCallback2 != null) {
            lottieValueCallback2.setAnimation((BaseKeyframeAnimation<?, ?>) null);
        }
        this.f40469e = lottieValueCallback;
        if (lottieValueCallback != null) {
            lottieValueCallback.setAnimation(this);
        }
    }

    public PointF getValue() {
        return getValue((Keyframe<PointF>) null, 0.0f);
    }

    public PointF getValue(Keyframe<PointF> keyframe, float f11) {
        Float f12;
        Keyframe<Float> a11;
        float f13;
        Keyframe<Float> a12;
        float f14;
        Float f15 = null;
        if (this.f40468d == null || (a12 = this.xAnimation.a()) == null) {
            f12 = null;
        } else {
            float c11 = this.xAnimation.c();
            Float f16 = a12.endFrame;
            LottieValueCallback<Float> lottieValueCallback = this.f40468d;
            float f17 = a12.startFrame;
            if (f16 == null) {
                f14 = f17;
            } else {
                f14 = f16.floatValue();
            }
            f12 = lottieValueCallback.getValueInternal(f17, f14, (Float) a12.startValue, (Float) a12.endValue, f11, f11, c11);
        }
        if (!(this.f40469e == null || (a11 = this.yAnimation.a()) == null)) {
            float c12 = this.yAnimation.c();
            Float f18 = a11.endFrame;
            LottieValueCallback<Float> lottieValueCallback2 = this.f40469e;
            float f19 = a11.startFrame;
            if (f18 == null) {
                f13 = f19;
            } else {
                f13 = f18.floatValue();
            }
            f15 = lottieValueCallback2.getValueInternal(f19, f13, (Float) a11.startValue, (Float) a11.endValue, f11, f11, c12);
        }
        if (f12 == null) {
            this.pointWithCallbackValues.set(this.point.x, 0.0f);
        } else {
            this.pointWithCallbackValues.set(f12.floatValue(), 0.0f);
        }
        if (f15 == null) {
            PointF pointF = this.pointWithCallbackValues;
            pointF.set(pointF.x, this.point.y);
        } else {
            PointF pointF2 = this.pointWithCallbackValues;
            pointF2.set(pointF2.x, f15.floatValue());
        }
        return this.pointWithCallbackValues;
    }
}
