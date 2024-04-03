package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
class RoundRectDrawable extends Drawable {
    private ColorStateList mBackground;
    private final RectF mBoundsF;
    private final Rect mBoundsI;
    private boolean mInsetForPadding = false;
    private boolean mInsetForRadius = true;
    private float mPadding;
    private final Paint mPaint;
    private float mRadius;
    private ColorStateList mTint;
    private PorterDuffColorFilter mTintFilter;
    private PorterDuff.Mode mTintMode = PorterDuff.Mode.SRC_IN;

    public RoundRectDrawable(ColorStateList colorStateList, float f11) {
        this.mRadius = f11;
        this.mPaint = new Paint(5);
        setBackground(colorStateList);
        this.mBoundsF = new RectF();
        this.mBoundsI = new Rect();
    }

    private PorterDuffColorFilter createTintFilter(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void setBackground(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.mBackground = colorStateList;
        this.mPaint.setColor(colorStateList.getColorForState(getState(), this.mBackground.getDefaultColor()));
    }

    private void updateBounds(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.mBoundsF.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.mBoundsI.set(rect);
        if (this.mInsetForPadding) {
            float b11 = RoundRectDrawableWithShadow.b(this.mPadding, this.mRadius, this.mInsetForRadius);
            this.mBoundsI.inset((int) Math.ceil((double) RoundRectDrawableWithShadow.a(this.mPadding, this.mRadius, this.mInsetForRadius)), (int) Math.ceil((double) b11));
            this.mBoundsF.set(this.mBoundsI);
        }
    }

    public float a() {
        return this.mPadding;
    }

    public void b(float f11, boolean z11, boolean z12) {
        if (f11 != this.mPadding || this.mInsetForPadding != z11 || this.mInsetForRadius != z12) {
            this.mPadding = f11;
            this.mInsetForPadding = z11;
            this.mInsetForRadius = z12;
            updateBounds((Rect) null);
            invalidateSelf();
        }
    }

    public void c(float f11) {
        if (f11 != this.mRadius) {
            this.mRadius = f11;
            updateBounds((Rect) null);
            invalidateSelf();
        }
    }

    public void draw(Canvas canvas) {
        boolean z11;
        Paint paint = this.mPaint;
        if (this.mTintFilter == null || paint.getColorFilter() != null) {
            z11 = false;
        } else {
            paint.setColorFilter(this.mTintFilter);
            z11 = true;
        }
        RectF rectF = this.mBoundsF;
        float f11 = this.mRadius;
        canvas.drawRoundRect(rectF, f11, f11, paint);
        if (z11) {
            paint.setColorFilter((ColorFilter) null);
        }
    }

    public ColorStateList getColor() {
        return this.mBackground;
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.mBoundsI, this.mRadius);
    }

    public float getRadius() {
        return this.mRadius;
    }

    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.mTint;
        if ((colorStateList2 == null || !colorStateList2.isStateful()) && (((colorStateList = this.mBackground) == null || !colorStateList.isStateful()) && !super.isStateful())) {
            return false;
        }
        return true;
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        updateBounds(rect);
    }

    public boolean onStateChange(int[] iArr) {
        boolean z11;
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.mBackground;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (colorForState != this.mPaint.getColor()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.mPaint.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.mTint;
        if (colorStateList2 == null || (mode = this.mTintMode) == null) {
            return z11;
        }
        this.mTintFilter = createTintFilter(colorStateList2, mode);
        return true;
    }

    public void setAlpha(int i11) {
        this.mPaint.setAlpha(i11);
    }

    public void setColor(@Nullable ColorStateList colorStateList) {
        setBackground(colorStateList);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.mTint = colorStateList;
        this.mTintFilter = createTintFilter(colorStateList, this.mTintMode);
        invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.mTintMode = mode;
        this.mTintFilter = createTintFilter(this.mTint, mode);
        invalidateSelf();
    }
}
