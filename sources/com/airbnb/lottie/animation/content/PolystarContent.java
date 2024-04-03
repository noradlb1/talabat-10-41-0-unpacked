package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public class PolystarContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {
    private static final float POLYGON_MAGIC_NUMBER = 0.25f;
    private static final float POLYSTAR_MAGIC_NUMBER = 0.47829f;
    private final boolean hidden;
    @Nullable
    private final BaseKeyframeAnimation<?, Float> innerRadiusAnimation;
    @Nullable
    private final BaseKeyframeAnimation<?, Float> innerRoundednessAnimation;
    private boolean isPathValid;
    private final boolean isReversed;
    private final LottieDrawable lottieDrawable;

    /* renamed from: name  reason: collision with root package name */
    private final String f40455name;
    private final BaseKeyframeAnimation<?, Float> outerRadiusAnimation;
    private final BaseKeyframeAnimation<?, Float> outerRoundednessAnimation;
    private final Path path = new Path();
    private final BaseKeyframeAnimation<?, Float> pointsAnimation;
    private final BaseKeyframeAnimation<?, PointF> positionAnimation;
    private final BaseKeyframeAnimation<?, Float> rotationAnimation;
    private final CompoundTrimPathContent trimPaths = new CompoundTrimPathContent();
    private final PolystarShape.Type type;

    /* renamed from: com.airbnb.lottie.animation.content.PolystarContent$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f40456a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.airbnb.lottie.model.content.PolystarShape$Type[] r0 = com.airbnb.lottie.model.content.PolystarShape.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f40456a = r0
                com.airbnb.lottie.model.content.PolystarShape$Type r1 = com.airbnb.lottie.model.content.PolystarShape.Type.STAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f40456a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.content.PolystarShape$Type r1 = com.airbnb.lottie.model.content.PolystarShape.Type.POLYGON     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.content.PolystarContent.AnonymousClass1.<clinit>():void");
        }
    }

    public PolystarContent(LottieDrawable lottieDrawable2, BaseLayer baseLayer, PolystarShape polystarShape) {
        this.lottieDrawable = lottieDrawable2;
        this.f40455name = polystarShape.getName();
        PolystarShape.Type type2 = polystarShape.getType();
        this.type = type2;
        this.hidden = polystarShape.isHidden();
        this.isReversed = polystarShape.isReversed();
        BaseKeyframeAnimation<Float, Float> createAnimation = polystarShape.getPoints().createAnimation();
        this.pointsAnimation = createAnimation;
        BaseKeyframeAnimation<PointF, PointF> createAnimation2 = polystarShape.getPosition().createAnimation();
        this.positionAnimation = createAnimation2;
        BaseKeyframeAnimation<Float, Float> createAnimation3 = polystarShape.getRotation().createAnimation();
        this.rotationAnimation = createAnimation3;
        BaseKeyframeAnimation<Float, Float> createAnimation4 = polystarShape.getOuterRadius().createAnimation();
        this.outerRadiusAnimation = createAnimation4;
        BaseKeyframeAnimation<Float, Float> createAnimation5 = polystarShape.getOuterRoundedness().createAnimation();
        this.outerRoundednessAnimation = createAnimation5;
        PolystarShape.Type type3 = PolystarShape.Type.STAR;
        if (type2 == type3) {
            this.innerRadiusAnimation = polystarShape.getInnerRadius().createAnimation();
            this.innerRoundednessAnimation = polystarShape.getInnerRoundedness().createAnimation();
        } else {
            this.innerRadiusAnimation = null;
            this.innerRoundednessAnimation = null;
        }
        baseLayer.addAnimation(createAnimation);
        baseLayer.addAnimation(createAnimation2);
        baseLayer.addAnimation(createAnimation3);
        baseLayer.addAnimation(createAnimation4);
        baseLayer.addAnimation(createAnimation5);
        if (type2 == type3) {
            baseLayer.addAnimation(this.innerRadiusAnimation);
            baseLayer.addAnimation(this.innerRoundednessAnimation);
        }
        createAnimation.addUpdateListener(this);
        createAnimation2.addUpdateListener(this);
        createAnimation3.addUpdateListener(this);
        createAnimation4.addUpdateListener(this);
        createAnimation5.addUpdateListener(this);
        if (type2 == type3) {
            this.innerRadiusAnimation.addUpdateListener(this);
            this.innerRoundednessAnimation.addUpdateListener(this);
        }
    }

    private void createPolygonPath() {
        double d11;
        double d12;
        double d13;
        double d14;
        int i11;
        int floor = (int) Math.floor((double) this.pointsAnimation.getValue().floatValue());
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.rotationAnimation;
        if (baseKeyframeAnimation == null) {
            d11 = 0.0d;
        } else {
            d11 = (double) baseKeyframeAnimation.getValue().floatValue();
        }
        double radians = Math.toRadians(d11 - 90.0d);
        double d15 = (double) floor;
        float floatValue = this.outerRoundednessAnimation.getValue().floatValue() / 100.0f;
        float floatValue2 = this.outerRadiusAnimation.getValue().floatValue();
        double d16 = (double) floatValue2;
        float cos = (float) (Math.cos(radians) * d16);
        float sin = (float) (Math.sin(radians) * d16);
        this.path.moveTo(cos, sin);
        double d17 = (double) ((float) (6.283185307179586d / d15));
        double d18 = radians + d17;
        double ceil = Math.ceil(d15);
        int i12 = 0;
        while (((double) i12) < ceil) {
            float cos2 = (float) (Math.cos(d18) * d16);
            double d19 = ceil;
            float sin2 = (float) (d16 * Math.sin(d18));
            if (floatValue != 0.0f) {
                d14 = d16;
                i11 = i12;
                d13 = d18;
                double atan2 = (double) ((float) (Math.atan2((double) sin, (double) cos) - 1.5707963267948966d));
                float cos3 = (float) Math.cos(atan2);
                d12 = d17;
                double atan22 = (double) ((float) (Math.atan2((double) sin2, (double) cos2) - 1.5707963267948966d));
                float f11 = floatValue2 * floatValue * POLYGON_MAGIC_NUMBER;
                float f12 = cos3 * f11;
                float sin3 = ((float) Math.sin(atan2)) * f11;
                float cos4 = ((float) Math.cos(atan22)) * f11;
                float sin4 = f11 * ((float) Math.sin(atan22));
                this.path.cubicTo(cos - f12, sin - sin3, cos2 + cos4, sin2 + sin4, cos2, sin2);
            } else {
                i11 = i12;
                d13 = d18;
                d14 = d16;
                d12 = d17;
                this.path.lineTo(cos2, sin2);
            }
            d18 = d13 + d12;
            i12 = i11 + 1;
            sin = sin2;
            cos = cos2;
            ceil = d19;
            d16 = d14;
            d17 = d12;
        }
        PointF value = this.positionAnimation.getValue();
        this.path.offset(value.x, value.y);
        this.path.close();
    }

    private void createStarPath() {
        double d11;
        float f11;
        float f12;
        int i11;
        float f13;
        float f14;
        float f15;
        float f16;
        double d12;
        float f17;
        float f18;
        float f19;
        double d13;
        float f21;
        double d14;
        float f22;
        float f23;
        float f24;
        float f25;
        float f26;
        float f27;
        float floatValue = this.pointsAnimation.getValue().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.rotationAnimation;
        if (baseKeyframeAnimation == null) {
            d11 = 0.0d;
        } else {
            d11 = (double) baseKeyframeAnimation.getValue().floatValue();
        }
        double radians = Math.toRadians(d11 - 90.0d);
        double d15 = (double) floatValue;
        float f28 = (float) (6.283185307179586d / d15);
        if (this.isReversed) {
            f28 *= -1.0f;
        }
        float f29 = f28 / 2.0f;
        float f31 = floatValue - ((float) ((int) floatValue));
        int i12 = (f31 > 0.0f ? 1 : (f31 == 0.0f ? 0 : -1));
        if (i12 != 0) {
            radians += (double) ((1.0f - f31) * f29);
        }
        float floatValue2 = this.outerRadiusAnimation.getValue().floatValue();
        float floatValue3 = this.innerRadiusAnimation.getValue().floatValue();
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.innerRoundednessAnimation;
        if (baseKeyframeAnimation2 != null) {
            f11 = baseKeyframeAnimation2.getValue().floatValue() / 100.0f;
        } else {
            f11 = 0.0f;
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.outerRoundednessAnimation;
        if (baseKeyframeAnimation3 != null) {
            f12 = baseKeyframeAnimation3.getValue().floatValue() / 100.0f;
        } else {
            f12 = 0.0f;
        }
        if (i12 != 0) {
            f13 = ((floatValue2 - floatValue3) * f31) + floatValue3;
            i11 = i12;
            double d16 = (double) f13;
            float f32 = f29;
            float cos = (float) (d16 * Math.cos(radians));
            f15 = (float) (d16 * Math.sin(radians));
            this.path.moveTo(cos, f15);
            d12 = radians + ((double) ((f28 * f31) / 2.0f));
            f14 = cos;
            f16 = f32;
        } else {
            float f33 = f29;
            i11 = i12;
            double d17 = (double) floatValue2;
            float cos2 = (float) (Math.cos(radians) * d17);
            float sin = (float) (d17 * Math.sin(radians));
            this.path.moveTo(cos2, sin);
            f14 = cos2;
            f16 = f33;
            d12 = radians + ((double) f16);
            f15 = sin;
            f13 = 0.0f;
        }
        double ceil = Math.ceil(d15) * 2.0d;
        int i13 = 0;
        float f34 = f16;
        float f35 = f14;
        float f36 = floatValue2;
        float f37 = floatValue3;
        boolean z11 = false;
        while (true) {
            double d18 = (double) i13;
            if (d18 < ceil) {
                if (z11) {
                    f17 = f36;
                } else {
                    f17 = f37;
                }
                int i14 = (f13 > 0.0f ? 1 : (f13 == 0.0f ? 0 : -1));
                if (i14 == 0 || d18 != ceil - 2.0d) {
                    f18 = f28;
                    f19 = f34;
                } else {
                    f18 = f28;
                    f19 = (f28 * f31) / 2.0f;
                }
                if (i14 == 0 || d18 != ceil - 1.0d) {
                    d13 = d18;
                    f21 = f13;
                    f13 = f17;
                } else {
                    d13 = d18;
                    f21 = f13;
                }
                double d19 = (double) f13;
                double d21 = ceil;
                float cos3 = (float) (d19 * Math.cos(d12));
                float sin2 = (float) (d19 * Math.sin(d12));
                if (f11 == 0.0f && f12 == 0.0f) {
                    this.path.lineTo(cos3, sin2);
                    d14 = d12;
                    f22 = f11;
                    f23 = f12;
                } else {
                    f22 = f11;
                    double atan2 = (double) ((float) (Math.atan2((double) f15, (double) f35) - 1.5707963267948966d));
                    float cos4 = (float) Math.cos(atan2);
                    float sin3 = (float) Math.sin(atan2);
                    f23 = f12;
                    d14 = d12;
                    double atan22 = (double) ((float) (Math.atan2((double) sin2, (double) cos3) - 1.5707963267948966d));
                    float cos5 = (float) Math.cos(atan22);
                    float sin4 = (float) Math.sin(atan22);
                    if (z11) {
                        f24 = f22;
                    } else {
                        f24 = f23;
                    }
                    if (z11) {
                        f25 = f23;
                    } else {
                        f25 = f22;
                    }
                    if (z11) {
                        f26 = f37;
                    } else {
                        f26 = f36;
                    }
                    if (z11) {
                        f27 = f36;
                    } else {
                        f27 = f37;
                    }
                    float f38 = f26 * f24 * POLYSTAR_MAGIC_NUMBER;
                    float f39 = cos4 * f38;
                    float f41 = f38 * sin3;
                    float f42 = f27 * f25 * POLYSTAR_MAGIC_NUMBER;
                    float f43 = cos5 * f42;
                    float f44 = f42 * sin4;
                    if (i11 != 0) {
                        if (i13 == 0) {
                            f39 *= f31;
                            f41 *= f31;
                        } else if (d13 == d21 - 1.0d) {
                            f43 *= f31;
                            f44 *= f31;
                        }
                    }
                    this.path.cubicTo(f35 - f39, f15 - f41, cos3 + f43, sin2 + f44, cos3, sin2);
                }
                d12 = d14 + ((double) f19);
                z11 = !z11;
                i13++;
                f35 = cos3;
                f15 = sin2;
                f12 = f23;
                f11 = f22;
                f13 = f21;
                f28 = f18;
                ceil = d21;
            } else {
                PointF value = this.positionAnimation.getValue();
                this.path.offset(value.x, value.y);
                this.path.close();
                return;
            }
        }
    }

    private void invalidate() {
        this.isPathValid = false;
        this.lottieDrawable.invalidateSelf();
    }

    public <T> void addValueCallback(T t11, @Nullable LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t11 == LottieProperty.POLYSTAR_POINTS) {
            this.pointsAnimation.setValueCallback(lottieValueCallback);
        } else if (t11 == LottieProperty.POLYSTAR_ROTATION) {
            this.rotationAnimation.setValueCallback(lottieValueCallback);
        } else if (t11 == LottieProperty.POSITION) {
            this.positionAnimation.setValueCallback(lottieValueCallback);
        } else if (t11 == LottieProperty.POLYSTAR_INNER_RADIUS && (baseKeyframeAnimation2 = this.innerRadiusAnimation) != null) {
            baseKeyframeAnimation2.setValueCallback(lottieValueCallback);
        } else if (t11 == LottieProperty.POLYSTAR_OUTER_RADIUS) {
            this.outerRadiusAnimation.setValueCallback(lottieValueCallback);
        } else if (t11 == LottieProperty.POLYSTAR_INNER_ROUNDEDNESS && (baseKeyframeAnimation = this.innerRoundednessAnimation) != null) {
            baseKeyframeAnimation.setValueCallback(lottieValueCallback);
        } else if (t11 == LottieProperty.POLYSTAR_OUTER_ROUNDEDNESS) {
            this.outerRoundednessAnimation.setValueCallback(lottieValueCallback);
        }
    }

    public String getName() {
        return this.f40455name;
    }

    public Path getPath() {
        if (this.isPathValid) {
            return this.path;
        }
        this.path.reset();
        if (this.hidden) {
            this.isPathValid = true;
            return this.path;
        }
        int i11 = AnonymousClass1.f40456a[this.type.ordinal()];
        if (i11 == 1) {
            createStarPath();
        } else if (i11 == 2) {
            createPolygonPath();
        }
        this.path.close();
        this.trimPaths.apply(this.path);
        this.isPathValid = true;
        return this.path;
    }

    public void onValueChanged() {
        invalidate();
    }

    public void resolveKeyPath(KeyPath keyPath, int i11, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.resolveKeyPath(keyPath, i11, list, keyPath2, this);
    }

    public void setContents(List<Content> list, List<Content> list2) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            Content content = list.get(i11);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.b() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.trimPaths.a(trimPathContent);
                    trimPathContent.a(this);
                }
            }
        }
    }
}
