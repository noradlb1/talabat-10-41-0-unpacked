package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import net.bytebuddy.jar.asm.Opcodes;

public abstract class RoundedBitmapDrawable extends Drawable {
    private static final int DEFAULT_PAINT_FLAGS = 3;

    /* renamed from: a  reason: collision with root package name */
    public final Bitmap f11297a;

    /* renamed from: b  reason: collision with root package name */
    public final Rect f11298b = new Rect();
    private boolean mApplyGravity = true;
    private int mBitmapHeight;
    private final BitmapShader mBitmapShader;
    private int mBitmapWidth;
    private float mCornerRadius;
    private final RectF mDstRectF = new RectF();
    private int mGravity = 119;
    private boolean mIsCircular;
    private final Paint mPaint = new Paint(3);
    private final Matrix mShaderMatrix = new Matrix();
    private int mTargetDensity = Opcodes.IF_ICMPNE;

    public RoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
        if (resources != null) {
            this.mTargetDensity = resources.getDisplayMetrics().densityDpi;
        }
        this.f11297a = bitmap;
        if (bitmap != null) {
            computeBitmapSize();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.mBitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            return;
        }
        this.mBitmapHeight = -1;
        this.mBitmapWidth = -1;
        this.mBitmapShader = null;
    }

    private void computeBitmapSize() {
        this.mBitmapWidth = this.f11297a.getScaledWidth(this.mTargetDensity);
        this.mBitmapHeight = this.f11297a.getScaledHeight(this.mTargetDensity);
    }

    private static boolean isGreaterThanZero(float f11) {
        return f11 > 0.05f;
    }

    private void updateCircularCornerRadius() {
        this.mCornerRadius = (float) (Math.min(this.mBitmapHeight, this.mBitmapWidth) / 2);
    }

    public void a(int i11, int i12, int i13, Rect rect, Rect rect2) {
        throw new UnsupportedOperationException();
    }

    public void b() {
        if (this.mApplyGravity) {
            if (this.mIsCircular) {
                int min = Math.min(this.mBitmapWidth, this.mBitmapHeight);
                a(this.mGravity, min, min, getBounds(), this.f11298b);
                int min2 = Math.min(this.f11298b.width(), this.f11298b.height());
                this.f11298b.inset(Math.max(0, (this.f11298b.width() - min2) / 2), Math.max(0, (this.f11298b.height() - min2) / 2));
                this.mCornerRadius = ((float) min2) * 0.5f;
            } else {
                a(this.mGravity, this.mBitmapWidth, this.mBitmapHeight, getBounds(), this.f11298b);
            }
            this.mDstRectF.set(this.f11298b);
            if (this.mBitmapShader != null) {
                Matrix matrix = this.mShaderMatrix;
                RectF rectF = this.mDstRectF;
                matrix.setTranslate(rectF.left, rectF.top);
                this.mShaderMatrix.preScale(this.mDstRectF.width() / ((float) this.f11297a.getWidth()), this.mDstRectF.height() / ((float) this.f11297a.getHeight()));
                this.mBitmapShader.setLocalMatrix(this.mShaderMatrix);
                this.mPaint.setShader(this.mBitmapShader);
            }
            this.mApplyGravity = false;
        }
    }

    public void draw(@NonNull Canvas canvas) {
        Bitmap bitmap = this.f11297a;
        if (bitmap != null) {
            b();
            if (this.mPaint.getShader() == null) {
                canvas.drawBitmap(bitmap, (Rect) null, this.f11298b, this.mPaint);
                return;
            }
            RectF rectF = this.mDstRectF;
            float f11 = this.mCornerRadius;
            canvas.drawRoundRect(rectF, f11, f11, this.mPaint);
        }
    }

    public int getAlpha() {
        return this.mPaint.getAlpha();
    }

    @Nullable
    public final Bitmap getBitmap() {
        return this.f11297a;
    }

    public ColorFilter getColorFilter() {
        return this.mPaint.getColorFilter();
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    public int getGravity() {
        return this.mGravity;
    }

    public int getIntrinsicHeight() {
        return this.mBitmapHeight;
    }

    public int getIntrinsicWidth() {
        return this.mBitmapWidth;
    }

    public int getOpacity() {
        Bitmap bitmap;
        if (this.mGravity != 119 || this.mIsCircular || (bitmap = this.f11297a) == null || bitmap.hasAlpha() || this.mPaint.getAlpha() < 255 || isGreaterThanZero(this.mCornerRadius)) {
            return -3;
        }
        return -1;
    }

    @NonNull
    public final Paint getPaint() {
        return this.mPaint;
    }

    public boolean hasAntiAlias() {
        return this.mPaint.isAntiAlias();
    }

    public boolean hasMipMap() {
        throw new UnsupportedOperationException();
    }

    public boolean isCircular() {
        return this.mIsCircular;
    }

    public void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        if (this.mIsCircular) {
            updateCircularCornerRadius();
        }
        this.mApplyGravity = true;
    }

    public void setAlpha(int i11) {
        if (i11 != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(i11);
            invalidateSelf();
        }
    }

    public void setAntiAlias(boolean z11) {
        this.mPaint.setAntiAlias(z11);
        invalidateSelf();
    }

    public void setCircular(boolean z11) {
        this.mIsCircular = z11;
        this.mApplyGravity = true;
        if (z11) {
            updateCircularCornerRadius();
            this.mPaint.setShader(this.mBitmapShader);
            invalidateSelf();
            return;
        }
        setCornerRadius(0.0f);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setCornerRadius(float f11) {
        if (this.mCornerRadius != f11) {
            this.mIsCircular = false;
            if (isGreaterThanZero(f11)) {
                this.mPaint.setShader(this.mBitmapShader);
            } else {
                this.mPaint.setShader((Shader) null);
            }
            this.mCornerRadius = f11;
            invalidateSelf();
        }
    }

    public void setDither(boolean z11) {
        this.mPaint.setDither(z11);
        invalidateSelf();
    }

    public void setFilterBitmap(boolean z11) {
        this.mPaint.setFilterBitmap(z11);
        invalidateSelf();
    }

    public void setGravity(int i11) {
        if (this.mGravity != i11) {
            this.mGravity = i11;
            this.mApplyGravity = true;
            invalidateSelf();
        }
    }

    public void setMipMap(boolean z11) {
        throw new UnsupportedOperationException();
    }

    public void setTargetDensity(@NonNull Canvas canvas) {
        setTargetDensity(canvas.getDensity());
    }

    public void setTargetDensity(@NonNull DisplayMetrics displayMetrics) {
        setTargetDensity(displayMetrics.densityDpi);
    }

    public void setTargetDensity(int i11) {
        if (this.mTargetDensity != i11) {
            if (i11 == 0) {
                i11 = Opcodes.IF_ICMPNE;
            }
            this.mTargetDensity = i11;
            if (this.f11297a != null) {
                computeBitmapSize();
            }
            invalidateSelf();
        }
    }
}
