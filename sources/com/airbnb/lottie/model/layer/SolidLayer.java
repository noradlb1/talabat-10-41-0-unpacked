package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.value.LottieValueCallback;

public class SolidLayer extends BaseLayer {
    @Nullable
    private BaseKeyframeAnimation<ColorFilter, ColorFilter> colorFilterAnimation;
    private final Layer layerModel;
    private final Paint paint;
    private final Path path;
    private final float[] points;
    private final RectF rect = new RectF();

    public SolidLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        LPaint lPaint = new LPaint();
        this.paint = lPaint;
        this.points = new float[8];
        this.path = new Path();
        this.layerModel = layer;
        lPaint.setAlpha(0);
        lPaint.setStyle(Paint.Style.FILL);
        lPaint.setColor(layer.k());
    }

    public <T> void addValueCallback(T t11, @Nullable LottieValueCallback<T> lottieValueCallback) {
        super.addValueCallback(t11, lottieValueCallback);
        if (t11 != LottieProperty.COLOR_FILTER) {
            return;
        }
        if (lottieValueCallback == null) {
            this.colorFilterAnimation = null;
        } else {
            this.colorFilterAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback);
        }
    }

    public void drawLayer(Canvas canvas, Matrix matrix, int i11) {
        int i12;
        int alpha = Color.alpha(this.layerModel.k());
        if (alpha != 0) {
            if (this.f40668d.getOpacity() == null) {
                i12 = 100;
            } else {
                i12 = this.f40668d.getOpacity().getValue().intValue();
            }
            int i13 = (int) ((((float) i11) / 255.0f) * (((((float) alpha) / 255.0f) * ((float) i12)) / 100.0f) * 255.0f);
            this.paint.setAlpha(i13);
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.colorFilterAnimation;
            if (baseKeyframeAnimation != null) {
                this.paint.setColorFilter(baseKeyframeAnimation.getValue());
            }
            if (i13 > 0) {
                float[] fArr = this.points;
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[2] = (float) this.layerModel.m();
                float[] fArr2 = this.points;
                fArr2[3] = 0.0f;
                fArr2[4] = (float) this.layerModel.m();
                this.points[5] = (float) this.layerModel.l();
                float[] fArr3 = this.points;
                fArr3[6] = 0.0f;
                fArr3[7] = (float) this.layerModel.l();
                matrix.mapPoints(this.points);
                this.path.reset();
                Path path2 = this.path;
                float[] fArr4 = this.points;
                path2.moveTo(fArr4[0], fArr4[1]);
                Path path3 = this.path;
                float[] fArr5 = this.points;
                path3.lineTo(fArr5[2], fArr5[3]);
                Path path4 = this.path;
                float[] fArr6 = this.points;
                path4.lineTo(fArr6[4], fArr6[5]);
                Path path5 = this.path;
                float[] fArr7 = this.points;
                path5.lineTo(fArr7[6], fArr7[7]);
                Path path6 = this.path;
                float[] fArr8 = this.points;
                path6.lineTo(fArr8[0], fArr8[1]);
                this.path.close();
                canvas.drawPath(this.path, this.paint);
            }
        }
    }

    public void getBounds(RectF rectF, Matrix matrix, boolean z11) {
        super.getBounds(rectF, matrix, z11);
        this.rect.set(0.0f, 0.0f, (float) this.layerModel.m(), (float) this.layerModel.l());
        this.f40665a.mapRect(this.rect);
        rectF.set(this.rect);
    }
}
