package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.math.MathUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CircularRevealHelper {
    public static final int BITMAP_SHADER = 0;
    public static final int CLIP_PATH = 1;
    private static final boolean DEBUG = false;
    public static final int REVEAL_ANIMATOR = 2;
    public static final int STRATEGY = 2;
    private boolean buildingCircularRevealCache;
    private Paint debugPaint;
    private final Delegate delegate;
    private boolean hasCircularRevealCache;
    @Nullable
    private Drawable overlayDrawable;
    @Nullable
    private CircularRevealWidget.RevealInfo revealInfo;
    @NonNull
    private final Paint revealPaint = new Paint(7);
    @NonNull
    private final Path revealPath = new Path();
    @NonNull
    private final Paint scrimPaint;
    @NonNull
    private final View view;

    public interface Delegate {
        void actualDraw(Canvas canvas);

        boolean actualIsOpaque();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Strategy {
    }

    public CircularRevealHelper(Delegate delegate2) {
        this.delegate = delegate2;
        View view2 = (View) delegate2;
        this.view = view2;
        view2.setWillNotDraw(false);
        Paint paint = new Paint(1);
        this.scrimPaint = paint;
        paint.setColor(0);
    }

    private void drawDebugCircle(@NonNull Canvas canvas, int i11, float f11) {
        this.debugPaint.setColor(i11);
        this.debugPaint.setStrokeWidth(f11);
        CircularRevealWidget.RevealInfo revealInfo2 = this.revealInfo;
        canvas.drawCircle(revealInfo2.centerX, revealInfo2.centerY, revealInfo2.radius - (f11 / 2.0f), this.debugPaint);
    }

    private void drawDebugMode(@NonNull Canvas canvas) {
        this.delegate.actualDraw(canvas);
        if (shouldDrawScrim()) {
            CircularRevealWidget.RevealInfo revealInfo2 = this.revealInfo;
            canvas.drawCircle(revealInfo2.centerX, revealInfo2.centerY, revealInfo2.radius, this.scrimPaint);
        }
        if (shouldDrawCircularReveal()) {
            drawDebugCircle(canvas, ViewCompat.MEASURED_STATE_MASK, 10.0f);
            drawDebugCircle(canvas, -65536, 5.0f);
        }
        drawOverlayDrawable(canvas);
    }

    private void drawOverlayDrawable(@NonNull Canvas canvas) {
        if (shouldDrawOverlayDrawable()) {
            Rect bounds = this.overlayDrawable.getBounds();
            float width = this.revealInfo.centerX - (((float) bounds.width()) / 2.0f);
            float height = this.revealInfo.centerY - (((float) bounds.height()) / 2.0f);
            canvas.translate(width, height);
            this.overlayDrawable.draw(canvas);
            canvas.translate(-width, -height);
        }
    }

    private float getDistanceToFurthestCorner(@NonNull CircularRevealWidget.RevealInfo revealInfo2) {
        return MathUtils.distanceToFurthestCorner(revealInfo2.centerX, revealInfo2.centerY, 0.0f, 0.0f, (float) this.view.getWidth(), (float) this.view.getHeight());
    }

    private void invalidateRevealInfo() {
        if (STRATEGY == 1) {
            this.revealPath.rewind();
            CircularRevealWidget.RevealInfo revealInfo2 = this.revealInfo;
            if (revealInfo2 != null) {
                this.revealPath.addCircle(revealInfo2.centerX, revealInfo2.centerY, revealInfo2.radius, Path.Direction.CW);
            }
        }
        this.view.invalidate();
    }

    private boolean shouldDrawCircularReveal() {
        boolean z11;
        CircularRevealWidget.RevealInfo revealInfo2 = this.revealInfo;
        if (revealInfo2 == null || revealInfo2.isInvalid()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (STRATEGY != 0) {
            return !z11;
        }
        if (z11 || !this.hasCircularRevealCache) {
            return false;
        }
        return true;
    }

    private boolean shouldDrawOverlayDrawable() {
        return (this.buildingCircularRevealCache || this.overlayDrawable == null || this.revealInfo == null) ? false : true;
    }

    private boolean shouldDrawScrim() {
        return !this.buildingCircularRevealCache && Color.alpha(this.scrimPaint.getColor()) != 0;
    }

    public void buildCircularRevealCache() {
        if (STRATEGY == 0) {
            this.buildingCircularRevealCache = true;
            this.hasCircularRevealCache = false;
            this.view.buildDrawingCache();
            Bitmap drawingCache = this.view.getDrawingCache();
            if (!(drawingCache != null || this.view.getWidth() == 0 || this.view.getHeight() == 0)) {
                drawingCache = Bitmap.createBitmap(this.view.getWidth(), this.view.getHeight(), Bitmap.Config.ARGB_8888);
                this.view.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                Paint paint = this.revealPaint;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                paint.setShader(new BitmapShader(drawingCache, tileMode, tileMode));
            }
            this.buildingCircularRevealCache = false;
            this.hasCircularRevealCache = true;
        }
    }

    public void destroyCircularRevealCache() {
        if (STRATEGY == 0) {
            this.hasCircularRevealCache = false;
            this.view.destroyDrawingCache();
            this.revealPaint.setShader((Shader) null);
            this.view.invalidate();
        }
    }

    public void draw(@NonNull Canvas canvas) {
        if (shouldDrawCircularReveal()) {
            int i11 = STRATEGY;
            if (i11 == 0) {
                CircularRevealWidget.RevealInfo revealInfo2 = this.revealInfo;
                canvas.drawCircle(revealInfo2.centerX, revealInfo2.centerY, revealInfo2.radius, this.revealPaint);
                if (shouldDrawScrim()) {
                    CircularRevealWidget.RevealInfo revealInfo3 = this.revealInfo;
                    canvas.drawCircle(revealInfo3.centerX, revealInfo3.centerY, revealInfo3.radius, this.scrimPaint);
                }
            } else if (i11 == 1) {
                int save = canvas.save();
                canvas.clipPath(this.revealPath);
                this.delegate.actualDraw(canvas);
                if (shouldDrawScrim()) {
                    canvas.drawRect(0.0f, 0.0f, (float) this.view.getWidth(), (float) this.view.getHeight(), this.scrimPaint);
                }
                canvas.restoreToCount(save);
            } else if (i11 == 2) {
                this.delegate.actualDraw(canvas);
                if (shouldDrawScrim()) {
                    canvas.drawRect(0.0f, 0.0f, (float) this.view.getWidth(), (float) this.view.getHeight(), this.scrimPaint);
                }
            } else {
                throw new IllegalStateException("Unsupported strategy " + i11);
            }
        } else {
            this.delegate.actualDraw(canvas);
            if (shouldDrawScrim()) {
                canvas.drawRect(0.0f, 0.0f, (float) this.view.getWidth(), (float) this.view.getHeight(), this.scrimPaint);
            }
        }
        drawOverlayDrawable(canvas);
    }

    @Nullable
    public Drawable getCircularRevealOverlayDrawable() {
        return this.overlayDrawable;
    }

    @ColorInt
    public int getCircularRevealScrimColor() {
        return this.scrimPaint.getColor();
    }

    @Nullable
    public CircularRevealWidget.RevealInfo getRevealInfo() {
        CircularRevealWidget.RevealInfo revealInfo2 = this.revealInfo;
        if (revealInfo2 == null) {
            return null;
        }
        CircularRevealWidget.RevealInfo revealInfo3 = new CircularRevealWidget.RevealInfo(revealInfo2);
        if (revealInfo3.isInvalid()) {
            revealInfo3.radius = getDistanceToFurthestCorner(revealInfo3);
        }
        return revealInfo3;
    }

    public boolean isOpaque() {
        return this.delegate.actualIsOpaque() && !shouldDrawCircularReveal();
    }

    public void setCircularRevealOverlayDrawable(@Nullable Drawable drawable) {
        this.overlayDrawable = drawable;
        this.view.invalidate();
    }

    public void setCircularRevealScrimColor(@ColorInt int i11) {
        this.scrimPaint.setColor(i11);
        this.view.invalidate();
    }

    public void setRevealInfo(@Nullable CircularRevealWidget.RevealInfo revealInfo2) {
        if (revealInfo2 == null) {
            this.revealInfo = null;
        } else {
            CircularRevealWidget.RevealInfo revealInfo3 = this.revealInfo;
            if (revealInfo3 == null) {
                this.revealInfo = new CircularRevealWidget.RevealInfo(revealInfo2);
            } else {
                revealInfo3.set(revealInfo2);
            }
            if (MathUtils.geq(revealInfo2.radius, getDistanceToFurthestCorner(revealInfo2), 1.0E-4f)) {
                this.revealInfo.radius = Float.MAX_VALUE;
            }
        }
        invalidateRevealInfo();
    }
}
