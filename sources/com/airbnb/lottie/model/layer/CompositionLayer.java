package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

public class CompositionLayer extends BaseLayer {
    private boolean clipToCompositionBounds = true;
    @Nullable
    private Boolean hasMasks;
    @Nullable
    private Boolean hasMatte;
    private final Paint layerPaint = new Paint();
    private final List<BaseLayer> layers = new ArrayList();
    private final RectF newClipRect = new RectF();
    private final RectF rect = new RectF();
    @Nullable
    private BaseKeyframeAnimation<Float, Float> timeRemapping;

    /* renamed from: com.airbnb.lottie.model.layer.CompositionLayer$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f40673a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.airbnb.lottie.model.layer.Layer$MatteType[] r0 = com.airbnb.lottie.model.layer.Layer.MatteType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f40673a = r0
                com.airbnb.lottie.model.layer.Layer$MatteType r1 = com.airbnb.lottie.model.layer.Layer.MatteType.ADD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f40673a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.airbnb.lottie.model.layer.Layer$MatteType r1 = com.airbnb.lottie.model.layer.Layer.MatteType.INVERT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.CompositionLayer.AnonymousClass1.<clinit>():void");
        }
    }

    public CompositionLayer(LottieDrawable lottieDrawable, Layer layer, List<Layer> list, LottieComposition lottieComposition) {
        super(lottieDrawable, layer);
        int i11;
        BaseLayer baseLayer;
        AnimatableFloatValue q11 = layer.q();
        if (q11 != null) {
            BaseKeyframeAnimation<Float, Float> createAnimation = q11.createAnimation();
            this.timeRemapping = createAnimation;
            addAnimation(createAnimation);
            this.timeRemapping.addUpdateListener(this);
        } else {
            this.timeRemapping = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(lottieComposition.getLayers().size());
        int size = list.size() - 1;
        BaseLayer baseLayer2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            Layer layer2 = list.get(size);
            BaseLayer b11 = BaseLayer.b(this, layer2, lottieDrawable, lottieComposition);
            if (b11 != null) {
                longSparseArray.put(b11.c().getId(), b11);
                if (baseLayer2 != null) {
                    baseLayer2.g(b11);
                    baseLayer2 = null;
                } else {
                    this.layers.add(0, b11);
                    int i12 = AnonymousClass1.f40673a[layer2.d().ordinal()];
                    if (i12 == 1 || i12 == 2) {
                        baseLayer2 = b11;
                    }
                }
            }
            size--;
        }
        for (i11 = 0; i11 < longSparseArray.size(); i11++) {
            BaseLayer baseLayer3 = (BaseLayer) longSparseArray.get(longSparseArray.keyAt(i11));
            if (!(baseLayer3 == null || (baseLayer = (BaseLayer) longSparseArray.get(baseLayer3.c().f())) == null)) {
                baseLayer3.h(baseLayer);
            }
        }
    }

    public <T> void addValueCallback(T t11, @Nullable LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t11, lottieValueCallback);
        if (t11 != LottieProperty.TIME_REMAP) {
            return;
        }
        if (lottieValueCallback == null) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.timeRemapping;
            if (baseKeyframeAnimation != null) {
                baseKeyframeAnimation.setValueCallback((LottieValueCallback<Float>) null);
                return;
            }
            return;
        }
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
        this.timeRemapping = valueCallbackKeyframeAnimation;
        valueCallbackKeyframeAnimation.addUpdateListener(this);
        addAnimation(this.timeRemapping);
    }

    public void drawLayer(Canvas canvas, Matrix matrix, int i11) {
        boolean z11;
        boolean z12;
        boolean z13;
        L.beginSection("CompositionLayer#draw");
        this.newClipRect.set(0.0f, 0.0f, (float) this.f40667c.h(), (float) this.f40667c.g());
        matrix.mapRect(this.newClipRect);
        if (!this.f40666b.isApplyingOpacityToLayersEnabled() || this.layers.size() <= 1 || i11 == 255) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            this.layerPaint.setAlpha(i11);
            Utils.saveLayerCompat(canvas, this.newClipRect, this.layerPaint);
        } else {
            canvas.save();
        }
        if (z11) {
            i11 = 255;
        }
        for (int size = this.layers.size() - 1; size >= 0; size--) {
            if (this.clipToCompositionBounds || !"__container".equals(this.f40667c.e())) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (z12 || this.newClipRect.isEmpty()) {
                z13 = true;
            } else {
                z13 = canvas.clipRect(this.newClipRect);
            }
            if (z13) {
                this.layers.get(size).draw(canvas, matrix, i11);
            }
        }
        canvas.restore();
        L.endSection("CompositionLayer#draw");
    }

    public void f(KeyPath keyPath, int i11, List<KeyPath> list, KeyPath keyPath2) {
        for (int i12 = 0; i12 < this.layers.size(); i12++) {
            this.layers.get(i12).resolveKeyPath(keyPath, i11, list, keyPath2);
        }
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean z11) {
        super.getBounds(rectF, matrix, z11);
        for (int size = this.layers.size() - 1; size >= 0; size--) {
            this.rect.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.layers.get(size).getBounds(this.rect, this.f40665a, true);
            rectF.union(this.rect);
        }
    }

    public boolean hasMasks() {
        if (this.hasMasks == null) {
            for (int size = this.layers.size() - 1; size >= 0; size--) {
                BaseLayer baseLayer = this.layers.get(size);
                if (baseLayer instanceof ShapeLayer) {
                    if (baseLayer.d()) {
                        this.hasMasks = Boolean.TRUE;
                        return true;
                    }
                } else if ((baseLayer instanceof CompositionLayer) && ((CompositionLayer) baseLayer).hasMasks()) {
                    this.hasMasks = Boolean.TRUE;
                    return true;
                }
            }
            this.hasMasks = Boolean.FALSE;
        }
        return this.hasMasks.booleanValue();
    }

    public boolean hasMatte() {
        if (this.hasMatte == null) {
            if (e()) {
                this.hasMatte = Boolean.TRUE;
                return true;
            }
            for (int size = this.layers.size() - 1; size >= 0; size--) {
                if (this.layers.get(size).e()) {
                    this.hasMatte = Boolean.TRUE;
                    return true;
                }
            }
            this.hasMatte = Boolean.FALSE;
        }
        return this.hasMatte.booleanValue();
    }

    public void setClipToCompositionBounds(boolean z11) {
        this.clipToCompositionBounds = z11;
    }

    public void setOutlineMasksAndMattes(boolean z11) {
        super.setOutlineMasksAndMattes(z11);
        for (BaseLayer outlineMasksAndMattes : this.layers) {
            outlineMasksAndMattes.setOutlineMasksAndMattes(z11);
        }
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f11) {
        super.setProgress(f11);
        if (this.timeRemapping != null) {
            f11 = ((this.timeRemapping.getValue().floatValue() * this.f40667c.a().getFrameRate()) - this.f40667c.a().getStartFrame()) / (this.f40666b.getComposition().getDurationFrames() + 0.01f);
        }
        if (this.timeRemapping == null) {
            f11 -= this.f40667c.n();
        }
        if (this.f40667c.r() != 0.0f && !"__container".equals(this.f40667c.e())) {
            f11 /= this.f40667c.r();
        }
        for (int size = this.layers.size() - 1; size >= 0; size--) {
            this.layers.get(size).setProgress(f11);
        }
    }
}
