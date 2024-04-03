package com.talabat.designhelpers.PinEntryEditText;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.talabat.R;
import org.apache.commons.compress.archivers.zip.UnixStat;

public class PinView extends AppCompatEditText {
    private static final int BLINK = 500;
    private static final boolean DBG = false;
    private static final int DEFAULT_COUNT = 4;
    private static final int[] HIGHLIGHT_STATES = {16842913};
    private static final InputFilter[] NO_FILTERS = new InputFilter[0];
    private static final String TAG = "PinView";
    private static final int VIEW_TYPE_LINE = 1;
    private static final int VIEW_TYPE_NONE = 2;
    private static final int VIEW_TYPE_RECTANGLE = 0;
    /* access modifiers changed from: private */
    public boolean drawCursor;
    private boolean isAnimationEnable;
    private boolean isCursorVisible;
    /* access modifiers changed from: private */
    public final TextPaint mAnimatorTextPaint;
    private Blink mBlink;
    private int mCurLineColor;
    private int mCursorColor;
    private float mCursorHeight;
    private int mCursorWidth;
    private ValueAnimator mDefaultAddAnimator;
    private boolean mHideLineWhenFilled;
    private Drawable mItemBackground;
    private int mItemBackgroundResource;
    private final RectF mItemBorderRect;
    private final PointF mItemCenterPoint;
    private final RectF mItemLineRect;
    private ColorStateList mLineColor;
    private int mLineWidth;
    private final Paint mPaint;
    private final Path mPath;
    private int mPinItemCount;
    private int mPinItemHeight;
    private int mPinItemRadius;
    private int mPinItemSpacing;
    private int mPinItemWidth;
    private final Rect mTextRect;
    private int mViewType;

    public class Blink implements Runnable {
        private boolean mCancelled;

        private Blink() {
        }

        /* access modifiers changed from: private */
        public void cancel() {
            if (!this.mCancelled) {
                PinView.this.removeCallbacks(this);
                this.mCancelled = true;
            }
        }

        public void b() {
            this.mCancelled = false;
        }

        public void run() {
            if (!this.mCancelled) {
                PinView.this.removeCallbacks(this);
                if (PinView.this.shouldBlink()) {
                    PinView pinView = PinView.this;
                    pinView.invalidateCursor(!pinView.drawCursor);
                    PinView.this.postDelayed(this, 500);
                }
            }
        }
    }

    public PinView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void checkItemRadius() {
        int i11 = this.mViewType;
        if (i11 == 1) {
            if (((float) this.mPinItemRadius) > ((float) this.mLineWidth) / 2.0f) {
                throw new IllegalArgumentException("The itemRadius can not be greater than lineWidth when viewType is line");
            }
        } else if (i11 == 0) {
            if (((float) this.mPinItemRadius) > ((float) this.mPinItemWidth) / 2.0f) {
                throw new IllegalArgumentException("The itemRadius can not be greater than itemWidth");
            }
        }
    }

    private int dpToPx(float f11) {
        return (int) ((f11 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void drawAnchorLine(Canvas canvas) {
        PointF pointF = this.mItemCenterPoint;
        float f11 = pointF.x;
        float f12 = pointF.y;
        this.mPaint.setStrokeWidth(1.0f);
        float strokeWidth = f11 - (this.mPaint.getStrokeWidth() / 2.0f);
        float strokeWidth2 = f12 - (this.mPaint.getStrokeWidth() / 2.0f);
        this.mPath.reset();
        this.mPath.moveTo(strokeWidth, this.mItemBorderRect.top);
        Path path = this.mPath;
        RectF rectF = this.mItemBorderRect;
        path.lineTo(strokeWidth, rectF.top + Math.abs(rectF.height()));
        canvas.drawPath(this.mPath, this.mPaint);
        this.mPath.reset();
        this.mPath.moveTo(this.mItemBorderRect.left, strokeWidth2);
        Path path2 = this.mPath;
        RectF rectF2 = this.mItemBorderRect;
        path2.lineTo(rectF2.left + Math.abs(rectF2.width()), strokeWidth2);
        canvas.drawPath(this.mPath, this.mPaint);
        this.mPath.reset();
        this.mPaint.setStrokeWidth((float) this.mLineWidth);
    }

    private void drawCircle(Canvas canvas, int i11) {
        Paint paintByIndex = getPaintByIndex(i11);
        PointF pointF = this.mItemCenterPoint;
        canvas.drawCircle(pointF.x, pointF.y, paintByIndex.getTextSize() / 2.0f, paintByIndex);
    }

    private void drawCursor(Canvas canvas) {
        if (this.drawCursor) {
            PointF pointF = this.mItemCenterPoint;
            float f11 = pointF.x;
            float f12 = pointF.y - (this.mCursorHeight / 2.0f);
            int color = this.mPaint.getColor();
            float strokeWidth = this.mPaint.getStrokeWidth();
            this.mPaint.setColor(this.mCursorColor);
            this.mPaint.setStrokeWidth((float) this.mCursorWidth);
            canvas.drawLine(f11, f12, f11, f12 + this.mCursorHeight, this.mPaint);
            this.mPaint.setColor(color);
            this.mPaint.setStrokeWidth(strokeWidth);
        }
    }

    private void drawHint(Canvas canvas, int i11) {
        Paint paintByIndex = getPaintByIndex(i11);
        paintByIndex.setColor(getCurrentHintTextColor());
        drawTextAtBox(canvas, paintByIndex, getHint(), i11);
    }

    private void drawItemBackground(Canvas canvas, boolean z11) {
        int[] iArr;
        if (this.mItemBackground != null) {
            float f11 = ((float) this.mLineWidth) / 2.0f;
            this.mItemBackground.setBounds(Math.round(this.mItemBorderRect.left - f11), Math.round(this.mItemBorderRect.top - f11), Math.round(this.mItemBorderRect.right + f11), Math.round(this.mItemBorderRect.bottom + f11));
            Drawable drawable = this.mItemBackground;
            if (z11) {
                iArr = HIGHLIGHT_STATES;
            } else {
                iArr = getDrawableState();
            }
            drawable.setState(iArr);
            this.mItemBackground.draw(canvas);
        }
    }

    private void drawPinBox(Canvas canvas, int i11) {
        if (!this.mHideLineWhenFilled || i11 >= getText().length()) {
            canvas.drawPath(this.mPath, this.mPaint);
        }
    }

    private void drawPinLine(Canvas canvas, int i11) {
        boolean z11;
        boolean z12;
        int i12;
        if (!this.mHideLineWhenFilled || i11 >= getText().length()) {
            if (this.mPinItemSpacing != 0 || (i12 = this.mPinItemCount) <= 1) {
                z12 = true;
            } else {
                if (i11 == 0) {
                    z12 = true;
                    z11 = false;
                } else if (i11 == i12 - 1) {
                    z11 = true;
                    z12 = false;
                } else {
                    z12 = false;
                }
                this.mPaint.setStyle(Paint.Style.FILL);
                this.mPaint.setStrokeWidth(((float) this.mLineWidth) / 10.0f);
                float f11 = ((float) this.mLineWidth) / 2.0f;
                RectF rectF = this.mItemLineRect;
                RectF rectF2 = this.mItemBorderRect;
                float f12 = rectF2.bottom;
                rectF.set(rectF2.left - f11, f12 - f11, rectF2.right + f11, f12 + f11);
                RectF rectF3 = this.mItemLineRect;
                int i13 = this.mPinItemRadius;
                updateRoundRectPath(rectF3, (float) i13, (float) i13, z12, z11);
                canvas.drawPath(this.mPath, this.mPaint);
            }
            z11 = z12;
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setStrokeWidth(((float) this.mLineWidth) / 10.0f);
            float f112 = ((float) this.mLineWidth) / 2.0f;
            RectF rectF4 = this.mItemLineRect;
            RectF rectF22 = this.mItemBorderRect;
            float f122 = rectF22.bottom;
            rectF4.set(rectF22.left - f112, f122 - f112, rectF22.right + f112, f122 + f112);
            RectF rectF32 = this.mItemLineRect;
            int i132 = this.mPinItemRadius;
            updateRoundRectPath(rectF32, (float) i132, (float) i132, z12, z11);
            canvas.drawPath(this.mPath, this.mPaint);
        }
    }

    private void drawPinView(Canvas canvas) {
        boolean z11;
        int i11;
        int length = getText().length();
        for (int i12 = 0; i12 < this.mPinItemCount; i12++) {
            if (!isFocused() || length != i12) {
                z11 = false;
            } else {
                z11 = true;
            }
            Paint paint = this.mPaint;
            if (z11) {
                i11 = getLineColorForState(HIGHLIGHT_STATES);
            } else {
                i11 = this.mCurLineColor;
            }
            paint.setColor(i11);
            updateItemRectF(i12);
            updateCenterPoint();
            canvas.save();
            if (this.mViewType == 0) {
                updatePinBoxPath(i12);
                canvas.clipPath(this.mPath);
            }
            drawItemBackground(canvas, z11);
            canvas.restore();
            if (z11) {
                drawCursor(canvas);
            }
            int i13 = this.mViewType;
            if (i13 == 0) {
                drawPinBox(canvas, i12);
            } else if (i13 == 1) {
                drawPinLine(canvas, i12);
            }
            if (getText().length() > i12) {
                if (isPasswordInputType(getInputType())) {
                    drawCircle(canvas, i12);
                } else {
                    drawText(canvas, i12);
                }
            } else if (!TextUtils.isEmpty(getHint()) && getHint().length() == this.mPinItemCount) {
                drawHint(canvas, i12);
            }
        }
        if (isFocused() && getText().length() != this.mPinItemCount && this.mViewType == 0) {
            int length2 = getText().length();
            updateItemRectF(length2);
            updateCenterPoint();
            updatePinBoxPath(length2);
            this.mPaint.setColor(getLineColorForState(HIGHLIGHT_STATES));
            drawPinBox(canvas, length2);
        }
    }

    private void drawText(Canvas canvas, int i11) {
        drawTextAtBox(canvas, getPaintByIndex(i11), getText(), i11);
    }

    private void drawTextAtBox(Canvas canvas, Paint paint, CharSequence charSequence, int i11) {
        int i12 = i11 + 1;
        paint.getTextBounds(charSequence.toString(), i11, i12, this.mTextRect);
        PointF pointF = this.mItemCenterPoint;
        float f11 = pointF.x;
        float f12 = pointF.y;
        float abs = f11 - (Math.abs((float) this.mTextRect.width()) / 2.0f);
        Rect rect = this.mTextRect;
        canvas.drawText(charSequence, i11, i12, abs - ((float) rect.left), (f12 + (Math.abs((float) rect.height()) / 2.0f)) - ((float) this.mTextRect.bottom), paint);
    }

    private int getLineColorForState(int... iArr) {
        ColorStateList colorStateList = this.mLineColor;
        if (colorStateList != null) {
            return colorStateList.getColorForState(iArr, this.mCurLineColor);
        }
        return this.mCurLineColor;
    }

    private Paint getPaintByIndex(int i11) {
        if (!this.isAnimationEnable || i11 != getText().length() - 1) {
            return getPaint();
        }
        this.mAnimatorTextPaint.setColor(getPaint().getColor());
        return this.mAnimatorTextPaint;
    }

    /* access modifiers changed from: private */
    public void invalidateCursor(boolean z11) {
        if (this.drawCursor != z11) {
            this.drawCursor = z11;
            invalidate();
        }
    }

    private static boolean isPasswordInputType(int i11) {
        int i12 = i11 & UnixStat.PERM_MASK;
        return i12 == 129 || i12 == 225 || i12 == 18;
    }

    private void makeBlink() {
        if (shouldBlink()) {
            if (this.mBlink == null) {
                this.mBlink = new Blink();
            }
            removeCallbacks(this.mBlink);
            this.drawCursor = false;
            postDelayed(this.mBlink, 500);
            return;
        }
        Blink blink = this.mBlink;
        if (blink != null) {
            removeCallbacks(blink);
        }
    }

    private void moveSelectionToEnd() {
        setSelection(getText().length());
    }

    private void resumeBlink() {
        Blink blink = this.mBlink;
        if (blink != null) {
            blink.b();
            makeBlink();
        }
    }

    private void setMaxLength(int i11) {
        if (i11 >= 0) {
            setFilters(new InputFilter[]{new InputFilter.LengthFilter(i11)});
            return;
        }
        setFilters(NO_FILTERS);
    }

    private void setupAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.5f, 1.0f});
        this.mDefaultAddAnimator = ofFloat;
        ofFloat.setDuration(150);
        this.mDefaultAddAnimator.setInterpolator(new DecelerateInterpolator());
        this.mDefaultAddAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                PinView.this.mAnimatorTextPaint.setTextSize(PinView.this.getTextSize() * floatValue);
                PinView.this.mAnimatorTextPaint.setAlpha((int) (255.0f * floatValue));
                PinView.this.postInvalidate();
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean shouldBlink() {
        return isCursorVisible() && isFocused();
    }

    private void suspendBlink() {
        Blink blink = this.mBlink;
        if (blink != null) {
            blink.cancel();
            invalidateCursor(false);
        }
    }

    private void updateCenterPoint() {
        RectF rectF = this.mItemBorderRect;
        float abs = rectF.left + (Math.abs(rectF.width()) / 2.0f);
        RectF rectF2 = this.mItemBorderRect;
        this.mItemCenterPoint.set(abs, rectF2.top + (Math.abs(rectF2.height()) / 2.0f));
    }

    private void updateColors() {
        int i11;
        ColorStateList colorStateList = this.mLineColor;
        boolean z11 = false;
        if (colorStateList != null) {
            i11 = colorStateList.getColorForState(getDrawableState(), 0);
        } else {
            i11 = getCurrentTextColor();
        }
        if (i11 != this.mCurLineColor) {
            this.mCurLineColor = i11;
            z11 = true;
        }
        if (z11) {
            invalidate();
        }
    }

    private void updateCursorHeight() {
        float f11;
        float dpToPx = (float) (dpToPx(2.0f) * 2);
        if (((float) this.mPinItemHeight) - getTextSize() > dpToPx) {
            f11 = getTextSize() + dpToPx;
        } else {
            f11 = getTextSize();
        }
        this.mCursorHeight = f11;
    }

    private void updateItemRectF(int i11) {
        float f11 = ((float) this.mLineWidth) / 2.0f;
        int scrollX = getScrollX() + ViewCompat.getPaddingStart(this);
        int i12 = this.mPinItemSpacing;
        int i13 = this.mPinItemWidth;
        float f12 = ((float) (scrollX + ((i12 + i13) * i11))) + f11;
        if (i12 == 0 && i11 > 0) {
            f12 -= (float) (this.mLineWidth * i11);
        }
        float f13 = (((float) i13) + f12) - ((float) this.mLineWidth);
        float scrollY = ((float) (getScrollY() + getPaddingTop())) + f11;
        this.mItemBorderRect.set(f12, scrollY, f13, (((float) this.mPinItemHeight) + scrollY) - ((float) this.mLineWidth));
    }

    private void updatePaints() {
        this.mPaint.setColor(this.mCurLineColor);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth((float) this.mLineWidth);
        getPaint().setColor(getCurrentTextColor());
    }

    private void updatePinBoxPath(int i11) {
        boolean z11;
        boolean z12;
        boolean z13;
        if (this.mPinItemSpacing != 0) {
            z12 = true;
            z11 = true;
        } else {
            if (i11 != 0 || i11 == this.mPinItemCount - 1) {
                z13 = false;
            } else {
                z13 = true;
            }
            if (i11 != this.mPinItemCount - 1 || i11 == 0) {
                z11 = false;
            } else {
                z11 = true;
            }
            z12 = z13;
        }
        RectF rectF = this.mItemBorderRect;
        int i12 = this.mPinItemRadius;
        updateRoundRectPath(rectF, (float) i12, (float) i12, z12, z11);
    }

    private void updateRoundRectPath(RectF rectF, float f11, float f12, boolean z11, boolean z12) {
        updateRoundRectPath(rectF, f11, f12, z11, z12, z12, z11);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        ColorStateList colorStateList = this.mLineColor;
        if (colorStateList == null || colorStateList.isStateful()) {
            updateColors();
        }
    }

    @ColorInt
    public int getCurrentLineColor() {
        return this.mCurLineColor;
    }

    public int getCursorColor() {
        return this.mCursorColor;
    }

    public int getCursorWidth() {
        return this.mCursorWidth;
    }

    public MovementMethod getDefaultMovementMethod() {
        return DefaultMovementMethod.getInstance();
    }

    public int getItemCount() {
        return this.mPinItemCount;
    }

    public int getItemHeight() {
        return this.mPinItemHeight;
    }

    public int getItemRadius() {
        return this.mPinItemRadius;
    }

    @Px
    public int getItemSpacing() {
        return this.mPinItemSpacing;
    }

    public int getItemWidth() {
        return this.mPinItemWidth;
    }

    public ColorStateList getLineColors() {
        return this.mLineColor;
    }

    public int getLineWidth() {
        return this.mLineWidth;
    }

    public boolean isCursorVisible() {
        return this.isCursorVisible;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resumeBlink();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        suspendBlink();
    }

    public void onDraw(Canvas canvas) {
        canvas.save();
        updatePaints();
        drawPinView(canvas);
        canvas.restore();
    }

    public void onFocusChanged(boolean z11, int i11, Rect rect) {
        super.onFocusChanged(z11, i11, rect);
        if (z11) {
            moveSelectionToEnd();
            makeBlink();
        }
    }

    public void onMeasure(int i11, int i12) {
        int mode = View.MeasureSpec.getMode(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i11);
        int size2 = View.MeasureSpec.getSize(i12);
        int i13 = this.mPinItemHeight;
        if (mode != 1073741824) {
            int i14 = this.mPinItemCount;
            size = ViewCompat.getPaddingStart(this) + ((i14 - 1) * this.mPinItemSpacing) + (i14 * this.mPinItemWidth) + ViewCompat.getPaddingEnd(this);
            if (this.mPinItemSpacing == 0) {
                size -= (this.mPinItemCount - 1) * this.mLineWidth;
            }
        }
        if (mode2 != 1073741824) {
            size2 = getPaddingBottom() + i13 + getPaddingTop();
        }
        setMeasuredDimension(size, size2);
    }

    public void onScreenStateChanged(int i11) {
        super.onScreenStateChanged(i11);
        if (i11 == 0) {
            suspendBlink();
        } else if (i11 == 1) {
            resumeBlink();
        }
    }

    public void onSelectionChanged(int i11, int i12) {
        super.onSelectionChanged(i11, i12);
        if (i12 != getText().length()) {
            moveSelectionToEnd();
        }
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        boolean z11;
        ValueAnimator valueAnimator;
        if (i11 != charSequence.length()) {
            moveSelectionToEnd();
        }
        makeBlink();
        if (this.isAnimationEnable) {
            if (i13 - i12 > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11 && (valueAnimator = this.mDefaultAddAnimator) != null) {
                valueAnimator.end();
                this.mDefaultAddAnimator.start();
            }
        }
    }

    public void setAnimationEnable(boolean z11) {
        this.isAnimationEnable = z11;
    }

    public void setCursorColor(@ColorInt int i11) {
        this.mCursorColor = i11;
        if (isCursorVisible()) {
            invalidateCursor(true);
        }
    }

    public void setCursorVisible(boolean z11) {
        if (this.isCursorVisible != z11) {
            this.isCursorVisible = z11;
            invalidateCursor(z11);
            makeBlink();
        }
    }

    public void setCursorWidth(@Px int i11) {
        this.mCursorWidth = i11;
        if (isCursorVisible()) {
            invalidateCursor(true);
        }
    }

    public void setHideLineWhenFilled(boolean z11) {
        this.mHideLineWhenFilled = z11;
    }

    public void setItemBackground(Drawable drawable) {
        this.mItemBackgroundResource = 0;
        this.mItemBackground = drawable;
        invalidate();
    }

    public void setItemBackgroundColor(@ColorInt int i11) {
        Drawable drawable = this.mItemBackground;
        if (drawable instanceof ColorDrawable) {
            ((ColorDrawable) drawable.mutate()).setColor(i11);
            this.mItemBackgroundResource = 0;
            return;
        }
        setItemBackground(new ColorDrawable(i11));
    }

    public void setItemBackgroundResources(@DrawableRes int i11) {
        if (i11 == 0 || this.mItemBackgroundResource == i11) {
            Drawable drawable = ResourcesCompat.getDrawable(getResources(), i11, getContext().getTheme());
            this.mItemBackground = drawable;
            setItemBackground(drawable);
            this.mItemBackgroundResource = i11;
        }
    }

    public void setItemCount(int i11) {
        this.mPinItemCount = i11;
        setMaxLength(i11);
        requestLayout();
    }

    public void setItemHeight(@Px int i11) {
        this.mPinItemHeight = i11;
        updateCursorHeight();
        requestLayout();
    }

    public void setItemRadius(@Px int i11) {
        this.mPinItemRadius = i11;
        checkItemRadius();
        requestLayout();
    }

    public void setItemSpacing(@Px int i11) {
        this.mPinItemSpacing = i11;
        requestLayout();
    }

    public void setItemWidth(@Px int i11) {
        this.mPinItemWidth = i11;
        checkItemRadius();
        requestLayout();
    }

    public void setLineColor(@ColorInt int i11) {
        this.mLineColor = ColorStateList.valueOf(i11);
        updateColors();
    }

    public void setLineWidth(@Px int i11) {
        this.mLineWidth = i11;
        checkItemRadius();
        requestLayout();
    }

    public void setTextSize(float f11) {
        super.setTextSize(f11);
        updateCursorHeight();
    }

    public void setTypeface(Typeface typeface, int i11) {
        super.setTypeface(typeface, i11);
    }

    public PinView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.pinViewStyle);
    }

    private void updateRoundRectPath(RectF rectF, float f11, float f12, boolean z11, boolean z12, boolean z13, boolean z14) {
        this.mPath.reset();
        float f13 = rectF.left;
        float f14 = rectF.top;
        float f15 = (rectF.right - f13) - (f11 * 2.0f);
        float f16 = (rectF.bottom - f14) - (2.0f * f12);
        this.mPath.moveTo(f13, f14 + f12);
        if (z11) {
            float f17 = -f12;
            this.mPath.rQuadTo(0.0f, f17, f11, f17);
        } else {
            this.mPath.rLineTo(0.0f, -f12);
            this.mPath.rLineTo(f11, 0.0f);
        }
        this.mPath.rLineTo(f15, 0.0f);
        if (z12) {
            this.mPath.rQuadTo(f11, 0.0f, f11, f12);
        } else {
            this.mPath.rLineTo(f11, 0.0f);
            this.mPath.rLineTo(0.0f, f12);
        }
        this.mPath.rLineTo(0.0f, f16);
        if (z13) {
            this.mPath.rQuadTo(0.0f, f12, -f11, f12);
        } else {
            this.mPath.rLineTo(0.0f, f12);
            this.mPath.rLineTo(-f11, 0.0f);
        }
        this.mPath.rLineTo(-f15, 0.0f);
        if (z14) {
            float f18 = -f11;
            this.mPath.rQuadTo(f18, 0.0f, f18, -f12);
        } else {
            this.mPath.rLineTo(-f11, 0.0f);
            this.mPath.rLineTo(0.0f, -f12);
        }
        this.mPath.rLineTo(0.0f, -f16);
        this.mPath.close();
    }

    public void setTypeface(Typeface typeface) {
        super.setTypeface(typeface);
        TextPaint textPaint = this.mAnimatorTextPaint;
        if (textPaint != null) {
            textPaint.set(getPaint());
        }
    }

    public PinView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        TextPaint textPaint = new TextPaint();
        this.mAnimatorTextPaint = textPaint;
        this.mCurLineColor = ViewCompat.MEASURED_STATE_MASK;
        this.mTextRect = new Rect();
        this.mItemBorderRect = new RectF();
        this.mItemLineRect = new RectF();
        this.mPath = new Path();
        this.mItemCenterPoint = new PointF();
        this.isAnimationEnable = false;
        Resources resources = getResources();
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        textPaint.set(getPaint());
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, com.talabat.talabatcommon.R.styleable.PinView, i11, 0);
        this.mViewType = obtainStyledAttributes.getInt(12, 0);
        this.mPinItemCount = obtainStyledAttributes.getInt(5, 4);
        this.mPinItemHeight = (int) obtainStyledAttributes.getDimension(6, (float) resources.getDimensionPixelSize(R.dimen.pv_pin_view_item_size));
        this.mPinItemWidth = (int) obtainStyledAttributes.getDimension(9, (float) resources.getDimensionPixelSize(R.dimen.pv_pin_view_item_size));
        this.mPinItemSpacing = obtainStyledAttributes.getDimensionPixelSize(8, resources.getDimensionPixelSize(R.dimen.pv_pin_view_item_spacing));
        this.mPinItemRadius = (int) obtainStyledAttributes.getDimension(7, 0.0f);
        this.mLineWidth = (int) obtainStyledAttributes.getDimension(11, (float) resources.getDimensionPixelSize(R.dimen.pv_pin_view_item_line_width));
        this.mLineColor = obtainStyledAttributes.getColorStateList(10);
        this.isCursorVisible = obtainStyledAttributes.getBoolean(1, true);
        this.mCursorColor = obtainStyledAttributes.getColor(2, getCurrentTextColor());
        this.mCursorWidth = obtainStyledAttributes.getDimensionPixelSize(3, resources.getDimensionPixelSize(R.dimen.pv_pin_view_cursor_width));
        this.mItemBackground = obtainStyledAttributes.getDrawable(0);
        this.mHideLineWhenFilled = obtainStyledAttributes.getBoolean(4, false);
        obtainStyledAttributes.recycle();
        ColorStateList colorStateList = this.mLineColor;
        if (colorStateList != null) {
            this.mCurLineColor = colorStateList.getDefaultColor();
        }
        updateCursorHeight();
        checkItemRadius();
        setMaxLength(this.mPinItemCount);
        paint.setStrokeWidth((float) this.mLineWidth);
        setupAnimator();
        super.setCursorVisible(false);
        setTextIsSelectable(false);
    }

    public void setLineColor(ColorStateList colorStateList) {
        colorStateList.getClass();
        this.mLineColor = colorStateList;
        updateColors();
    }

    public void setTextSize(int i11, float f11) {
        super.setTextSize(i11, f11);
        updateCursorHeight();
    }
}
