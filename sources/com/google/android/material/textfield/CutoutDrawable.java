package com.google.android.material.textfield;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

class CutoutDrawable extends MaterialShapeDrawable {
    @NonNull
    private final RectF cutoutBounds;
    @NonNull
    private final Paint cutoutPaint;
    private int savedLayer;

    public CutoutDrawable() {
        this((ShapeAppearanceModel) null);
    }

    private void postDraw(@NonNull Canvas canvas) {
        if (!useHardwareLayer(getCallback())) {
            canvas.restoreToCount(this.savedLayer);
        }
    }

    private void preDraw(@NonNull Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (useHardwareLayer(callback)) {
            View view = (View) callback;
            if (view.getLayerType() != 2) {
                view.setLayerType(2, (Paint) null);
                return;
            }
            return;
        }
        saveCanvasLayer(canvas);
    }

    private void saveCanvasLayer(@NonNull Canvas canvas) {
        this.savedLayer = canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (Paint) null);
    }

    private void setPaintStyles() {
        this.cutoutPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.cutoutPaint.setColor(-1);
        this.cutoutPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    private boolean useHardwareLayer(Drawable.Callback callback) {
        return callback instanceof View;
    }

    public void draw(@NonNull Canvas canvas) {
        preDraw(canvas);
        super.draw(canvas);
        postDraw(canvas);
    }

    public void drawStrokeShape(@NonNull Canvas canvas) {
        if (this.cutoutBounds.isEmpty()) {
            super.drawStrokeShape(canvas);
            return;
        }
        Bitmap createBitmap = Bitmap.createBitmap(canvas.getWidth(), canvas.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        super.drawStrokeShape(canvas2);
        canvas2.drawRect(this.cutoutBounds, this.cutoutPaint);
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, (Paint) null);
    }

    public boolean hasCutout() {
        return !this.cutoutBounds.isEmpty();
    }

    public void removeCutout() {
        setCutout(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void setCutout(float f11, float f12, float f13, float f14) {
        RectF rectF = this.cutoutBounds;
        if (f11 != rectF.left || f12 != rectF.top || f13 != rectF.right || f14 != rectF.bottom) {
            rectF.set(f11, f12, f13, f14);
            invalidateSelf();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CutoutDrawable(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        super(shapeAppearanceModel == null ? new ShapeAppearanceModel() : shapeAppearanceModel);
        this.cutoutPaint = new Paint(1);
        setPaintStyles();
        this.cutoutBounds = new RectF();
    }

    public void setCutout(@NonNull RectF rectF) {
        setCutout(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }
}
