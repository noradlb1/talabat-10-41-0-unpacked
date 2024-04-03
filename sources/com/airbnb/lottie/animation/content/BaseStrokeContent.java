package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.MaskFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseStrokeContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, DrawingContent {

    /* renamed from: a  reason: collision with root package name */
    public final BaseLayer f40442a;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f40443b;
    @Nullable
    private BaseKeyframeAnimation<Float, Float> blurAnimation;

    /* renamed from: c  reason: collision with root package name */
    public float f40444c;
    @Nullable
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final List<BaseKeyframeAnimation<?, Float>> dashPatternAnimations;
    @Nullable
    private final BaseKeyframeAnimation<?, Float> dashPatternOffsetAnimation;
    private final float[] dashPatternValues;
    @Nullable
    private DropShadowKeyframeAnimation dropShadowAnimation;
    private final LottieDrawable lottieDrawable;
    private final BaseKeyframeAnimation<?, Integer> opacityAnimation;
    private final Path path = new Path();
    private final List<PathGroup> pathGroups = new ArrayList();

    /* renamed from: pm  reason: collision with root package name */
    private final PathMeasure f40445pm = new PathMeasure();
    private final RectF rect = new RectF();
    private final Path trimPathPath = new Path();
    private final BaseKeyframeAnimation<?, Float> widthAnimation;

    public static final class PathGroup {
        /* access modifiers changed from: private */
        public final List<PathContent> paths;
        /* access modifiers changed from: private */
        @Nullable
        public final TrimPathContent trimPath;

        private PathGroup(@Nullable TrimPathContent trimPathContent) {
            this.paths = new ArrayList();
            this.trimPath = trimPathContent;
        }
    }

    public BaseStrokeContent(LottieDrawable lottieDrawable2, BaseLayer baseLayer, Paint.Cap cap, Paint.Join join, float f11, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue, List<AnimatableFloatValue> list, AnimatableFloatValue animatableFloatValue2) {
        LPaint lPaint = new LPaint(1);
        this.f40443b = lPaint;
        this.f40444c = 0.0f;
        this.lottieDrawable = lottieDrawable2;
        this.f40442a = baseLayer;
        lPaint.setStyle(Paint.Style.STROKE);
        lPaint.setStrokeCap(cap);
        lPaint.setStrokeJoin(join);
        lPaint.setStrokeMiter(f11);
        this.opacityAnimation = animatableIntegerValue.createAnimation();
        this.widthAnimation = animatableFloatValue.createAnimation();
        if (animatableFloatValue2 == null) {
            this.dashPatternOffsetAnimation = null;
        } else {
            this.dashPatternOffsetAnimation = animatableFloatValue2.createAnimation();
        }
        this.dashPatternAnimations = new ArrayList(list.size());
        this.dashPatternValues = new float[list.size()];
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.dashPatternAnimations.add(list.get(i11).createAnimation());
        }
        baseLayer.addAnimation(this.opacityAnimation);
        baseLayer.addAnimation(this.widthAnimation);
        for (int i12 = 0; i12 < this.dashPatternAnimations.size(); i12++) {
            baseLayer.addAnimation(this.dashPatternAnimations.get(i12));
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.dashPatternOffsetAnimation;
        if (baseKeyframeAnimation != null) {
            baseLayer.addAnimation(baseKeyframeAnimation);
        }
        this.opacityAnimation.addUpdateListener(this);
        this.widthAnimation.addUpdateListener(this);
        for (int i13 = 0; i13 < list.size(); i13++) {
            this.dashPatternAnimations.get(i13).addUpdateListener(this);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.dashPatternOffsetAnimation;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.addUpdateListener(this);
        }
        if (baseLayer.getBlurEffect() != null) {
            BaseKeyframeAnimation<Float, Float> createAnimation = baseLayer.getBlurEffect().getBlurriness().createAnimation();
            this.blurAnimation = createAnimation;
            createAnimation.addUpdateListener(this);
            baseLayer.addAnimation(this.blurAnimation);
        }
        if (baseLayer.getDropShadowEffect() != null) {
            this.dropShadowAnimation = new DropShadowKeyframeAnimation(this, baseLayer, baseLayer.getDropShadowEffect());
        }
    }

    private void applyDashPatternIfNeeded(Matrix matrix) {
        float f11;
        L.beginSection("StrokeContent#applyDashPattern");
        if (this.dashPatternAnimations.isEmpty()) {
            L.endSection("StrokeContent#applyDashPattern");
            return;
        }
        float scale = Utils.getScale(matrix);
        for (int i11 = 0; i11 < this.dashPatternAnimations.size(); i11++) {
            this.dashPatternValues[i11] = ((Float) this.dashPatternAnimations.get(i11).getValue()).floatValue();
            if (i11 % 2 == 0) {
                float[] fArr = this.dashPatternValues;
                if (fArr[i11] < 1.0f) {
                    fArr[i11] = 1.0f;
                }
            } else {
                float[] fArr2 = this.dashPatternValues;
                if (fArr2[i11] < 0.1f) {
                    fArr2[i11] = 0.1f;
                }
            }
            float[] fArr3 = this.dashPatternValues;
            fArr3[i11] = fArr3[i11] * scale;
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.dashPatternOffsetAnimation;
        if (baseKeyframeAnimation == null) {
            f11 = 0.0f;
        } else {
            f11 = scale * baseKeyframeAnimation.getValue().floatValue();
        }
        this.f40443b.setPathEffect(new DashPathEffect(this.dashPatternValues, f11));
        L.endSection("StrokeContent#applyDashPattern");
    }

    private void applyTrimPath(Canvas canvas, PathGroup pathGroup, Matrix matrix) {
        float f11;
        float f12;
        float f13;
        Canvas canvas2 = canvas;
        Matrix matrix2 = matrix;
        L.beginSection("StrokeContent#applyTrimPath");
        if (pathGroup.trimPath == null) {
            L.endSection("StrokeContent#applyTrimPath");
            return;
        }
        this.path.reset();
        for (int size = pathGroup.paths.size() - 1; size >= 0; size--) {
            this.path.addPath(((PathContent) pathGroup.paths.get(size)).getPath(), matrix2);
        }
        float floatValue = pathGroup.trimPath.getStart().getValue().floatValue() / 100.0f;
        float floatValue2 = pathGroup.trimPath.getEnd().getValue().floatValue() / 100.0f;
        float floatValue3 = pathGroup.trimPath.getOffset().getValue().floatValue() / 360.0f;
        if (floatValue >= 0.01f || floatValue2 <= 0.99f) {
            this.f40445pm.setPath(this.path, false);
            float length = this.f40445pm.getLength();
            while (this.f40445pm.nextContour()) {
                length += this.f40445pm.getLength();
            }
            float f14 = floatValue3 * length;
            float f15 = (floatValue * length) + f14;
            float min = Math.min((floatValue2 * length) + f14, (f15 + length) - 1.0f);
            float f16 = 0.0f;
            for (int size2 = pathGroup.paths.size() - 1; size2 >= 0; size2--) {
                this.trimPathPath.set(((PathContent) pathGroup.paths.get(size2)).getPath());
                this.trimPathPath.transform(matrix2);
                this.f40445pm.setPath(this.trimPathPath, false);
                float length2 = this.f40445pm.getLength();
                if (min > length) {
                    float f17 = min - length;
                    if (f17 < f16 + length2 && f16 < f17) {
                        if (f15 > length) {
                            f13 = (f15 - length) / length2;
                        } else {
                            f13 = 0.0f;
                        }
                        Utils.applyTrimPathIfNeeded(this.trimPathPath, f13, Math.min(f17 / length2, 1.0f), 0.0f);
                        canvas2.drawPath(this.trimPathPath, this.f40443b);
                        f16 += length2;
                    }
                }
                float f18 = f16 + length2;
                if (f18 >= f15 && f16 <= min) {
                    if (f18 > min || f15 >= f16) {
                        if (f15 < f16) {
                            f11 = 0.0f;
                        } else {
                            f11 = (f15 - f16) / length2;
                        }
                        if (min > f18) {
                            f12 = 1.0f;
                        } else {
                            f12 = (min - f16) / length2;
                        }
                        Utils.applyTrimPathIfNeeded(this.trimPathPath, f11, f12, 0.0f);
                        canvas2.drawPath(this.trimPathPath, this.f40443b);
                    } else {
                        canvas2.drawPath(this.trimPathPath, this.f40443b);
                    }
                }
                f16 += length2;
            }
            L.endSection("StrokeContent#applyTrimPath");
            return;
        }
        canvas2.drawPath(this.path, this.f40443b);
        L.endSection("StrokeContent#applyTrimPath");
    }

    @CallSuper
    public <T> void addValueCallback(T t11, @Nullable LottieValueCallback<T> lottieValueCallback) {
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation2;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation3;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation4;
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation5;
        if (t11 == LottieProperty.OPACITY) {
            this.opacityAnimation.setValueCallback(lottieValueCallback);
        } else if (t11 == LottieProperty.STROKE_WIDTH) {
            this.widthAnimation.setValueCallback(lottieValueCallback);
        } else if (t11 == LottieProperty.COLOR_FILTER) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
            if (baseKeyframeAnimation != null) {
                this.f40442a.removeAnimation(baseKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.colorFilterAnimation = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.colorFilterAnimation = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.addUpdateListener(this);
            this.f40442a.addAnimation(this.colorFilterAnimation);
        } else if (t11 == LottieProperty.BLUR_RADIUS) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.blurAnimation;
            if (baseKeyframeAnimation2 != null) {
                baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback);
            this.blurAnimation = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.addUpdateListener(this);
            this.f40442a.addAnimation(this.blurAnimation);
        } else if (t11 == LottieProperty.DROP_SHADOW_COLOR && (dropShadowKeyframeAnimation5 = this.dropShadowAnimation) != null) {
            dropShadowKeyframeAnimation5.setColorCallback(lottieValueCallback);
        } else if (t11 == LottieProperty.DROP_SHADOW_OPACITY && (dropShadowKeyframeAnimation4 = this.dropShadowAnimation) != null) {
            dropShadowKeyframeAnimation4.setOpacityCallback(lottieValueCallback);
        } else if (t11 == LottieProperty.DROP_SHADOW_DIRECTION && (dropShadowKeyframeAnimation3 = this.dropShadowAnimation) != null) {
            dropShadowKeyframeAnimation3.setDirectionCallback(lottieValueCallback);
        } else if (t11 == LottieProperty.DROP_SHADOW_DISTANCE && (dropShadowKeyframeAnimation2 = this.dropShadowAnimation) != null) {
            dropShadowKeyframeAnimation2.setDistanceCallback(lottieValueCallback);
        } else if (t11 == LottieProperty.DROP_SHADOW_RADIUS && (dropShadowKeyframeAnimation = this.dropShadowAnimation) != null) {
            dropShadowKeyframeAnimation.setRadiusCallback(lottieValueCallback);
        }
    }

    public void draw(Canvas canvas, Matrix matrix, int i11) {
        L.beginSection("StrokeContent#draw");
        if (Utils.hasZeroScaleAxis(matrix)) {
            L.endSection("StrokeContent#draw");
            return;
        }
        this.f40443b.setAlpha(MiscUtils.clamp((int) ((((((float) i11) / 255.0f) * ((float) ((IntegerKeyframeAnimation) this.opacityAnimation).getIntValue())) / 100.0f) * 255.0f), 0, 255));
        this.f40443b.setStrokeWidth(((FloatKeyframeAnimation) this.widthAnimation).getFloatValue() * Utils.getScale(matrix));
        if (this.f40443b.getStrokeWidth() <= 0.0f) {
            L.endSection("StrokeContent#draw");
            return;
        }
        applyDashPatternIfNeeded(matrix);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
        if (baseKeyframeAnimation != null) {
            this.f40443b.setColorFilter(baseKeyframeAnimation.getValue());
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.blurAnimation;
        if (baseKeyframeAnimation2 != null) {
            float floatValue = baseKeyframeAnimation2.getValue().floatValue();
            if (floatValue == 0.0f) {
                this.f40443b.setMaskFilter((MaskFilter) null);
            } else if (floatValue != this.f40444c) {
                this.f40443b.setMaskFilter(this.f40442a.getBlurMaskFilter(floatValue));
            }
            this.f40444c = floatValue;
        }
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation = this.dropShadowAnimation;
        if (dropShadowKeyframeAnimation != null) {
            dropShadowKeyframeAnimation.applyTo(this.f40443b);
        }
        for (int i12 = 0; i12 < this.pathGroups.size(); i12++) {
            PathGroup pathGroup = this.pathGroups.get(i12);
            if (pathGroup.trimPath != null) {
                applyTrimPath(canvas, pathGroup, matrix);
            } else {
                L.beginSection("StrokeContent#buildPath");
                this.path.reset();
                for (int size = pathGroup.paths.size() - 1; size >= 0; size--) {
                    this.path.addPath(((PathContent) pathGroup.paths.get(size)).getPath(), matrix);
                }
                L.endSection("StrokeContent#buildPath");
                L.beginSection("StrokeContent#drawPath");
                canvas.drawPath(this.path, this.f40443b);
                L.endSection("StrokeContent#drawPath");
            }
        }
        L.endSection("StrokeContent#draw");
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean z11) {
        L.beginSection("StrokeContent#getBounds");
        this.path.reset();
        for (int i11 = 0; i11 < this.pathGroups.size(); i11++) {
            PathGroup pathGroup = this.pathGroups.get(i11);
            for (int i12 = 0; i12 < pathGroup.paths.size(); i12++) {
                this.path.addPath(((PathContent) pathGroup.paths.get(i12)).getPath(), matrix);
            }
        }
        this.path.computeBounds(this.rect, false);
        float floatValue = ((FloatKeyframeAnimation) this.widthAnimation).getFloatValue();
        RectF rectF2 = this.rect;
        float f11 = floatValue / 2.0f;
        rectF2.set(rectF2.left - f11, rectF2.top - f11, rectF2.right + f11, rectF2.bottom + f11);
        rectF.set(this.rect);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        L.endSection("StrokeContent#getBounds");
    }

    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    public void resolveKeyPath(KeyPath keyPath, int i11, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i11, list, keyPath2, this);
    }

    public void setContents(List<Content> list, List<Content> list2) {
        TrimPathContent trimPathContent = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            Content content = list.get(size);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent2 = (TrimPathContent) content;
                if (trimPathContent2.b() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    trimPathContent = trimPathContent2;
                }
            }
        }
        if (trimPathContent != null) {
            trimPathContent.a(this);
        }
        PathGroup pathGroup = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            Content content2 = list2.get(size2);
            if (content2 instanceof TrimPathContent) {
                TrimPathContent trimPathContent3 = (TrimPathContent) content2;
                if (trimPathContent3.b() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    if (pathGroup != null) {
                        this.pathGroups.add(pathGroup);
                    }
                    pathGroup = new PathGroup(trimPathContent3);
                    trimPathContent3.a(this);
                }
            }
            if (content2 instanceof PathContent) {
                if (pathGroup == null) {
                    pathGroup = new PathGroup(trimPathContent);
                }
                pathGroup.paths.add((PathContent) content2);
            }
        }
        if (pathGroup != null) {
            this.pathGroups.add(pathGroup);
        }
    }
}
