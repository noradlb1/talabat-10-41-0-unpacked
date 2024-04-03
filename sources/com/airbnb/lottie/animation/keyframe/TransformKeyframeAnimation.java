package com.airbnb.lottie.animation.keyframe;

import android.graphics.Matrix;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.Collections;

public class TransformKeyframeAnimation {
    @Nullable
    private BaseKeyframeAnimation<PointF, PointF> anchorPoint;
    @Nullable
    private BaseKeyframeAnimation<?, Float> endOpacity;
    private final Matrix matrix = new Matrix();
    @Nullable
    private BaseKeyframeAnimation<Integer, Integer> opacity;
    @Nullable
    private BaseKeyframeAnimation<?, PointF> position;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> rotation;
    @Nullable
    private BaseKeyframeAnimation<ScaleXY, ScaleXY> scale;
    @Nullable
    private FloatKeyframeAnimation skew;
    @Nullable
    private FloatKeyframeAnimation skewAngle;
    private final Matrix skewMatrix1;
    private final Matrix skewMatrix2;
    private final Matrix skewMatrix3;
    private final float[] skewValues;
    @Nullable
    private BaseKeyframeAnimation<?, Float> startOpacity;

    public TransformKeyframeAnimation(AnimatableTransform animatableTransform) {
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation;
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation2;
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation3;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation4;
        FloatKeyframeAnimation floatKeyframeAnimation;
        FloatKeyframeAnimation floatKeyframeAnimation2;
        if (animatableTransform.getAnchorPoint() == null) {
            baseKeyframeAnimation = null;
        } else {
            baseKeyframeAnimation = animatableTransform.getAnchorPoint().createAnimation();
        }
        this.anchorPoint = baseKeyframeAnimation;
        if (animatableTransform.getPosition() == null) {
            baseKeyframeAnimation2 = null;
        } else {
            baseKeyframeAnimation2 = animatableTransform.getPosition().createAnimation();
        }
        this.position = baseKeyframeAnimation2;
        if (animatableTransform.getScale() == null) {
            baseKeyframeAnimation3 = null;
        } else {
            baseKeyframeAnimation3 = animatableTransform.getScale().createAnimation();
        }
        this.scale = baseKeyframeAnimation3;
        if (animatableTransform.getRotation() == null) {
            baseKeyframeAnimation4 = null;
        } else {
            baseKeyframeAnimation4 = animatableTransform.getRotation().createAnimation();
        }
        this.rotation = baseKeyframeAnimation4;
        if (animatableTransform.getSkew() == null) {
            floatKeyframeAnimation = null;
        } else {
            floatKeyframeAnimation = (FloatKeyframeAnimation) animatableTransform.getSkew().createAnimation();
        }
        this.skew = floatKeyframeAnimation;
        if (floatKeyframeAnimation != null) {
            this.skewMatrix1 = new Matrix();
            this.skewMatrix2 = new Matrix();
            this.skewMatrix3 = new Matrix();
            this.skewValues = new float[9];
        } else {
            this.skewMatrix1 = null;
            this.skewMatrix2 = null;
            this.skewMatrix3 = null;
            this.skewValues = null;
        }
        if (animatableTransform.getSkewAngle() == null) {
            floatKeyframeAnimation2 = null;
        } else {
            floatKeyframeAnimation2 = (FloatKeyframeAnimation) animatableTransform.getSkewAngle().createAnimation();
        }
        this.skewAngle = floatKeyframeAnimation2;
        if (animatableTransform.getOpacity() != null) {
            this.opacity = animatableTransform.getOpacity().createAnimation();
        }
        if (animatableTransform.getStartOpacity() != null) {
            this.startOpacity = animatableTransform.getStartOpacity().createAnimation();
        } else {
            this.startOpacity = null;
        }
        if (animatableTransform.getEndOpacity() != null) {
            this.endOpacity = animatableTransform.getEndOpacity().createAnimation();
        } else {
            this.endOpacity = null;
        }
    }

    private void clearSkewValues() {
        for (int i11 = 0; i11 < 9; i11++) {
            this.skewValues[i11] = 0.0f;
        }
    }

    public void addAnimationsToLayer(BaseLayer baseLayer) {
        baseLayer.addAnimation(this.opacity);
        baseLayer.addAnimation(this.startOpacity);
        baseLayer.addAnimation(this.endOpacity);
        baseLayer.addAnimation(this.anchorPoint);
        baseLayer.addAnimation(this.position);
        baseLayer.addAnimation(this.scale);
        baseLayer.addAnimation(this.rotation);
        baseLayer.addAnimation(this.skew);
        baseLayer.addAnimation(this.skewAngle);
    }

    public void addListener(BaseKeyframeAnimation.AnimationListener animationListener) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.opacity;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.startOpacity;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.endOpacity;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.anchorPoint;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.position;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation6 = this.scale;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.addUpdateListener(animationListener);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.rotation;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.addUpdateListener(animationListener);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.skew;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.addUpdateListener(animationListener);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.skewAngle;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.addUpdateListener(animationListener);
        }
    }

    public <T> boolean applyValueCallback(T t11, @Nullable LottieValueCallback<T> lottieValueCallback) {
        if (t11 == LottieProperty.TRANSFORM_ANCHOR_POINT) {
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation = this.anchorPoint;
            if (baseKeyframeAnimation == null) {
                this.anchorPoint = new ValueCallbackKeyframeAnimation(lottieValueCallback, new PointF());
                return true;
            }
            baseKeyframeAnimation.setValueCallback(lottieValueCallback);
            return true;
        } else if (t11 == LottieProperty.TRANSFORM_POSITION) {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation2 = this.position;
            if (baseKeyframeAnimation2 == null) {
                this.position = new ValueCallbackKeyframeAnimation(lottieValueCallback, new PointF());
                return true;
            }
            baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
            return true;
        } else {
            if (t11 == LottieProperty.TRANSFORM_POSITION_X) {
                BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation3 = this.position;
                if (baseKeyframeAnimation3 instanceof SplitDimensionPathKeyframeAnimation) {
                    ((SplitDimensionPathKeyframeAnimation) baseKeyframeAnimation3).setXValueCallback(lottieValueCallback);
                    return true;
                }
            }
            if (t11 == LottieProperty.TRANSFORM_POSITION_Y) {
                BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation4 = this.position;
                if (baseKeyframeAnimation4 instanceof SplitDimensionPathKeyframeAnimation) {
                    ((SplitDimensionPathKeyframeAnimation) baseKeyframeAnimation4).setYValueCallback(lottieValueCallback);
                    return true;
                }
            }
            if (t11 == LottieProperty.TRANSFORM_SCALE) {
                BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation5 = this.scale;
                if (baseKeyframeAnimation5 == null) {
                    this.scale = new ValueCallbackKeyframeAnimation(lottieValueCallback, new ScaleXY());
                    return true;
                }
                baseKeyframeAnimation5.setValueCallback(lottieValueCallback);
                return true;
            } else if (t11 == LottieProperty.TRANSFORM_ROTATION) {
                BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation6 = this.rotation;
                if (baseKeyframeAnimation6 == null) {
                    this.rotation = new ValueCallbackKeyframeAnimation(lottieValueCallback, Float.valueOf(0.0f));
                    return true;
                }
                baseKeyframeAnimation6.setValueCallback(lottieValueCallback);
                return true;
            } else if (t11 == LottieProperty.TRANSFORM_OPACITY) {
                BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation7 = this.opacity;
                if (baseKeyframeAnimation7 == null) {
                    this.opacity = new ValueCallbackKeyframeAnimation(lottieValueCallback, 100);
                    return true;
                }
                baseKeyframeAnimation7.setValueCallback(lottieValueCallback);
                return true;
            } else if (t11 == LottieProperty.TRANSFORM_START_OPACITY) {
                BaseKeyframeAnimation<?, Float> baseKeyframeAnimation8 = this.startOpacity;
                if (baseKeyframeAnimation8 == null) {
                    this.startOpacity = new ValueCallbackKeyframeAnimation(lottieValueCallback, Float.valueOf(100.0f));
                    return true;
                }
                baseKeyframeAnimation8.setValueCallback(lottieValueCallback);
                return true;
            } else if (t11 == LottieProperty.TRANSFORM_END_OPACITY) {
                BaseKeyframeAnimation<?, Float> baseKeyframeAnimation9 = this.endOpacity;
                if (baseKeyframeAnimation9 == null) {
                    this.endOpacity = new ValueCallbackKeyframeAnimation(lottieValueCallback, Float.valueOf(100.0f));
                    return true;
                }
                baseKeyframeAnimation9.setValueCallback(lottieValueCallback);
                return true;
            } else if (t11 == LottieProperty.TRANSFORM_SKEW) {
                if (this.skew == null) {
                    this.skew = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
                }
                this.skew.setValueCallback(lottieValueCallback);
                return true;
            } else if (t11 != LottieProperty.TRANSFORM_SKEW_ANGLE) {
                return false;
            } else {
                if (this.skewAngle == null) {
                    this.skewAngle = new FloatKeyframeAnimation(Collections.singletonList(new Keyframe(Float.valueOf(0.0f))));
                }
                this.skewAngle.setValueCallback(lottieValueCallback);
                return true;
            }
        }
    }

    @Nullable
    public BaseKeyframeAnimation<?, Float> getEndOpacity() {
        return this.endOpacity;
    }

    public Matrix getMatrix() {
        float f11;
        float f12;
        float f13;
        PointF value;
        this.matrix.reset();
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.position;
        if (!(baseKeyframeAnimation == null || (value = baseKeyframeAnimation.getValue()) == null)) {
            float f14 = value.x;
            if (!(f14 == 0.0f && value.y == 0.0f)) {
                this.matrix.preTranslate(f14, value.y);
            }
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.rotation;
        if (baseKeyframeAnimation2 != null) {
            if (baseKeyframeAnimation2 instanceof ValueCallbackKeyframeAnimation) {
                f13 = baseKeyframeAnimation2.getValue().floatValue();
            } else {
                f13 = ((FloatKeyframeAnimation) baseKeyframeAnimation2).getFloatValue();
            }
            if (f13 != 0.0f) {
                this.matrix.preRotate(f13);
            }
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.skew;
        if (floatKeyframeAnimation != null) {
            FloatKeyframeAnimation floatKeyframeAnimation2 = this.skewAngle;
            if (floatKeyframeAnimation2 == null) {
                f11 = 0.0f;
            } else {
                f11 = (float) Math.cos(Math.toRadians((double) ((-floatKeyframeAnimation2.getFloatValue()) + 90.0f)));
            }
            FloatKeyframeAnimation floatKeyframeAnimation3 = this.skewAngle;
            if (floatKeyframeAnimation3 == null) {
                f12 = 1.0f;
            } else {
                f12 = (float) Math.sin(Math.toRadians((double) ((-floatKeyframeAnimation3.getFloatValue()) + 90.0f)));
            }
            float tan = (float) Math.tan(Math.toRadians((double) floatKeyframeAnimation.getFloatValue()));
            clearSkewValues();
            float[] fArr = this.skewValues;
            fArr[0] = f11;
            fArr[1] = f12;
            float f15 = -f12;
            fArr[3] = f15;
            fArr[4] = f11;
            fArr[8] = 1.0f;
            this.skewMatrix1.setValues(fArr);
            clearSkewValues();
            float[] fArr2 = this.skewValues;
            fArr2[0] = 1.0f;
            fArr2[3] = tan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.skewMatrix2.setValues(fArr2);
            clearSkewValues();
            float[] fArr3 = this.skewValues;
            fArr3[0] = f11;
            fArr3[1] = f15;
            fArr3[3] = f12;
            fArr3[4] = f11;
            fArr3[8] = 1.0f;
            this.skewMatrix3.setValues(fArr3);
            this.skewMatrix2.preConcat(this.skewMatrix1);
            this.skewMatrix3.preConcat(this.skewMatrix2);
            this.matrix.preConcat(this.skewMatrix3);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation3 = this.scale;
        if (baseKeyframeAnimation3 != null) {
            ScaleXY value2 = baseKeyframeAnimation3.getValue();
            if (!(value2.getScaleX() == 1.0f && value2.getScaleY() == 1.0f)) {
                this.matrix.preScale(value2.getScaleX(), value2.getScaleY());
            }
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.anchorPoint;
        if (baseKeyframeAnimation4 != null) {
            PointF value3 = baseKeyframeAnimation4.getValue();
            float f16 = value3.x;
            if (!(f16 == 0.0f && value3.y == 0.0f)) {
                this.matrix.preTranslate(-f16, -value3.y);
            }
        }
        return this.matrix;
    }

    public Matrix getMatrixForRepeater(float f11) {
        PointF pointF;
        ScaleXY scaleXY;
        float f12;
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.position;
        PointF pointF2 = null;
        if (baseKeyframeAnimation == null) {
            pointF = null;
        } else {
            pointF = baseKeyframeAnimation.getValue();
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation2 = this.scale;
        if (baseKeyframeAnimation2 == null) {
            scaleXY = null;
        } else {
            scaleXY = baseKeyframeAnimation2.getValue();
        }
        this.matrix.reset();
        if (pointF != null) {
            this.matrix.preTranslate(pointF.x * f11, pointF.y * f11);
        }
        if (scaleXY != null) {
            double d11 = (double) f11;
            this.matrix.preScale((float) Math.pow((double) scaleXY.getScaleX(), d11), (float) Math.pow((double) scaleXY.getScaleY(), d11));
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation3 = this.rotation;
        if (baseKeyframeAnimation3 != null) {
            float floatValue = baseKeyframeAnimation3.getValue().floatValue();
            BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.anchorPoint;
            if (baseKeyframeAnimation4 != null) {
                pointF2 = baseKeyframeAnimation4.getValue();
            }
            Matrix matrix2 = this.matrix;
            float f13 = floatValue * f11;
            float f14 = 0.0f;
            if (pointF2 == null) {
                f12 = 0.0f;
            } else {
                f12 = pointF2.x;
            }
            if (pointF2 != null) {
                f14 = pointF2.y;
            }
            matrix2.preRotate(f13, f12, f14);
        }
        return this.matrix;
    }

    @Nullable
    public BaseKeyframeAnimation<?, Integer> getOpacity() {
        return this.opacity;
    }

    @Nullable
    public BaseKeyframeAnimation<?, Float> getStartOpacity() {
        return this.startOpacity;
    }

    public void setProgress(float f11) {
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.opacity;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.setProgress(f11);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.startOpacity;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.setProgress(f11);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.endOpacity;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.setProgress(f11);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = this.anchorPoint;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.setProgress(f11);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.position;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.setProgress(f11);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation6 = this.scale;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.setProgress(f11);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = this.rotation;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.setProgress(f11);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.skew;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.setProgress(f11);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.skewAngle;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.setProgress(f11);
        }
    }
}
