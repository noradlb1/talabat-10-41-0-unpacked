package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.cardview.R;

class RoundRectDrawableWithShadow extends Drawable {
    private static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    private static final float SHADOW_MULTIPLIER = 1.5f;

    /* renamed from: a  reason: collision with root package name */
    public static RoundRectHelper f1018a;
    private boolean mAddPaddingForCorners = true;
    private ColorStateList mBackground;
    private final RectF mCardBounds;
    private float mCornerRadius;
    private Paint mCornerShadowPaint;
    private Path mCornerShadowPath;
    private boolean mDirty = true;
    private Paint mEdgeShadowPaint;
    private final int mInsetShadow;
    private Paint mPaint;
    private boolean mPrintedShadowClipWarning = false;
    private float mRawMaxShadowSize;
    private float mRawShadowSize;
    private final int mShadowEndColor;
    private float mShadowSize;
    private final int mShadowStartColor;

    public interface RoundRectHelper {
        void drawRoundRect(Canvas canvas, RectF rectF, float f11, Paint paint);
    }

    public RoundRectDrawableWithShadow(Resources resources, ColorStateList colorStateList, float f11, float f12, float f13) {
        this.mShadowStartColor = resources.getColor(R.color.cardview_shadow_start_color);
        this.mShadowEndColor = resources.getColor(R.color.cardview_shadow_end_color);
        this.mInsetShadow = resources.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
        this.mPaint = new Paint(5);
        setBackground(colorStateList);
        Paint paint = new Paint(5);
        this.mCornerShadowPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mCornerRadius = (float) ((int) (f11 + 0.5f));
        this.mCardBounds = new RectF();
        Paint paint2 = new Paint(this.mCornerShadowPaint);
        this.mEdgeShadowPaint = paint2;
        paint2.setAntiAlias(false);
        setShadowSize(f12, f13);
    }

    public static float a(float f11, float f12, boolean z11) {
        return z11 ? (float) (((double) f11) + ((1.0d - COS_45) * ((double) f12))) : f11;
    }

    public static float b(float f11, float f12, boolean z11) {
        return z11 ? (float) (((double) (f11 * SHADOW_MULTIPLIER)) + ((1.0d - COS_45) * ((double) f12))) : f11 * SHADOW_MULTIPLIER;
    }

    private void buildComponents(Rect rect) {
        float f11 = this.mRawMaxShadowSize;
        float f12 = SHADOW_MULTIPLIER * f11;
        this.mCardBounds.set(((float) rect.left) + f11, ((float) rect.top) + f12, ((float) rect.right) - f11, ((float) rect.bottom) - f12);
        buildShadowCorners();
    }

    private void buildShadowCorners() {
        float f11 = this.mCornerRadius;
        RectF rectF = new RectF(-f11, -f11, f11, f11);
        RectF rectF2 = new RectF(rectF);
        float f12 = this.mShadowSize;
        rectF2.inset(-f12, -f12);
        Path path = this.mCornerShadowPath;
        if (path == null) {
            this.mCornerShadowPath = new Path();
        } else {
            path.reset();
        }
        this.mCornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
        this.mCornerShadowPath.moveTo(-this.mCornerRadius, 0.0f);
        this.mCornerShadowPath.rLineTo(-this.mShadowSize, 0.0f);
        this.mCornerShadowPath.arcTo(rectF2, 180.0f, 90.0f, false);
        this.mCornerShadowPath.arcTo(rectF, 270.0f, -90.0f, false);
        this.mCornerShadowPath.close();
        float f13 = this.mCornerRadius;
        float f14 = f13 / (this.mShadowSize + f13);
        Paint paint = this.mCornerShadowPaint;
        float f15 = this.mCornerRadius + this.mShadowSize;
        int i11 = this.mShadowStartColor;
        paint.setShader(new RadialGradient(0.0f, 0.0f, f15, new int[]{i11, i11, this.mShadowEndColor}, new float[]{0.0f, f14, 1.0f}, Shader.TileMode.CLAMP));
        Paint paint2 = this.mEdgeShadowPaint;
        float f16 = this.mCornerRadius;
        float f17 = this.mShadowSize;
        int i12 = this.mShadowStartColor;
        paint2.setShader(new LinearGradient(0.0f, (-f16) + f17, 0.0f, (-f16) - f17, new int[]{i12, i12, this.mShadowEndColor}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.mEdgeShadowPaint.setAntiAlias(false);
    }

    private void drawShadow(Canvas canvas) {
        boolean z11;
        boolean z12;
        float f11 = this.mCornerRadius;
        float f12 = (-f11) - this.mShadowSize;
        float f13 = f11 + ((float) this.mInsetShadow) + (this.mRawShadowSize / 2.0f);
        float f14 = f13 * 2.0f;
        if (this.mCardBounds.width() - f14 > 0.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (this.mCardBounds.height() - f14 > 0.0f) {
            z12 = true;
        } else {
            z12 = false;
        }
        int save = canvas.save();
        RectF rectF = this.mCardBounds;
        canvas.translate(rectF.left + f13, rectF.top + f13);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z11) {
            canvas.drawRect(0.0f, f12, this.mCardBounds.width() - f14, -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(save);
        int save2 = canvas.save();
        RectF rectF2 = this.mCardBounds;
        canvas.translate(rectF2.right - f13, rectF2.bottom - f13);
        canvas.rotate(180.0f);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z11) {
            canvas.drawRect(0.0f, f12, this.mCardBounds.width() - f14, (-this.mCornerRadius) + this.mShadowSize, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        RectF rectF3 = this.mCardBounds;
        canvas.translate(rectF3.left + f13, rectF3.bottom - f13);
        canvas.rotate(270.0f);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z12) {
            canvas.drawRect(0.0f, f12, this.mCardBounds.height() - f14, -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        RectF rectF4 = this.mCardBounds;
        canvas.translate(rectF4.right - f13, rectF4.top + f13);
        canvas.rotate(90.0f);
        canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
        if (z12) {
            canvas.drawRect(0.0f, f12, this.mCardBounds.height() - f14, -this.mCornerRadius, this.mEdgeShadowPaint);
        }
        canvas.restoreToCount(save4);
    }

    private void setBackground(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.mBackground = colorStateList;
        this.mPaint.setColor(colorStateList.getColorForState(getState(), this.mBackground.getDefaultColor()));
    }

    private void setShadowSize(float f11, float f12) {
        if (f11 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f11 + ". Must be >= 0");
        } else if (f12 >= 0.0f) {
            float even = (float) toEven(f11);
            float even2 = (float) toEven(f12);
            if (even > even2) {
                if (!this.mPrintedShadowClipWarning) {
                    this.mPrintedShadowClipWarning = true;
                }
                even = even2;
            }
            if (this.mRawShadowSize != even || this.mRawMaxShadowSize != even2) {
                this.mRawShadowSize = even;
                this.mRawMaxShadowSize = even2;
                this.mShadowSize = (float) ((int) ((even * SHADOW_MULTIPLIER) + ((float) this.mInsetShadow) + 0.5f));
                this.mDirty = true;
                invalidateSelf();
            }
        } else {
            throw new IllegalArgumentException("Invalid max shadow size " + f12 + ". Must be >= 0");
        }
    }

    private int toEven(float f11) {
        int i11 = (int) (f11 + 0.5f);
        return i11 % 2 == 1 ? i11 - 1 : i11;
    }

    public ColorStateList c() {
        return this.mBackground;
    }

    public float d() {
        return this.mCornerRadius;
    }

    public void draw(Canvas canvas) {
        if (this.mDirty) {
            buildComponents(getBounds());
            this.mDirty = false;
        }
        canvas.translate(0.0f, this.mRawShadowSize / 2.0f);
        drawShadow(canvas);
        canvas.translate(0.0f, (-this.mRawShadowSize) / 2.0f);
        f1018a.drawRoundRect(canvas, this.mCardBounds, this.mCornerRadius, this.mPaint);
    }

    public void e(Rect rect) {
        getPadding(rect);
    }

    public float f() {
        return this.mRawMaxShadowSize;
    }

    public float g() {
        float f11 = this.mRawMaxShadowSize;
        return (Math.max(f11, this.mCornerRadius + ((float) this.mInsetShadow) + ((f11 * SHADOW_MULTIPLIER) / 2.0f)) * 2.0f) + (((this.mRawMaxShadowSize * SHADOW_MULTIPLIER) + ((float) this.mInsetShadow)) * 2.0f);
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) b(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        int ceil2 = (int) Math.ceil((double) a(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public float h() {
        float f11 = this.mRawMaxShadowSize;
        return (Math.max(f11, this.mCornerRadius + ((float) this.mInsetShadow) + (f11 / 2.0f)) * 2.0f) + ((this.mRawMaxShadowSize + ((float) this.mInsetShadow)) * 2.0f);
    }

    public float i() {
        return this.mRawShadowSize;
    }

    public boolean isStateful() {
        ColorStateList colorStateList = this.mBackground;
        return (colorStateList != null && colorStateList.isStateful()) || super.isStateful();
    }

    public void j(boolean z11) {
        this.mAddPaddingForCorners = z11;
        invalidateSelf();
    }

    public void k(@Nullable ColorStateList colorStateList) {
        setBackground(colorStateList);
        invalidateSelf();
    }

    public void l(float f11) {
        if (f11 >= 0.0f) {
            float f12 = (float) ((int) (f11 + 0.5f));
            if (this.mCornerRadius != f12) {
                this.mCornerRadius = f12;
                this.mDirty = true;
                invalidateSelf();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid radius " + f11 + ". Must be >= 0");
    }

    public void m(float f11) {
        setShadowSize(this.mRawShadowSize, f11);
    }

    public void n(float f11) {
        setShadowSize(f11, this.mRawMaxShadowSize);
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mDirty = true;
    }

    public boolean onStateChange(int[] iArr) {
        ColorStateList colorStateList = this.mBackground;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.mPaint.getColor() == colorForState) {
            return false;
        }
        this.mPaint.setColor(colorForState);
        this.mDirty = true;
        invalidateSelf();
        return true;
    }

    public void setAlpha(int i11) {
        this.mPaint.setAlpha(i11);
        this.mCornerShadowPaint.setAlpha(i11);
        this.mEdgeShadowPaint.setAlpha(i11);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
