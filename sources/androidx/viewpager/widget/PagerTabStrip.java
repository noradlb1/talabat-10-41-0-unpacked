package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;

public class PagerTabStrip extends PagerTitleStrip {
    private static final int FULL_UNDERLINE_HEIGHT = 1;
    private static final int INDICATOR_HEIGHT = 3;
    private static final int MIN_PADDING_BOTTOM = 6;
    private static final int MIN_STRIP_HEIGHT = 32;
    private static final int MIN_TEXT_SPACING = 64;
    private static final int TAB_PADDING = 16;
    private static final int TAB_SPACING = 32;
    private static final String TAG = "PagerTabStrip";
    private boolean mDrawFullUnderline;
    private boolean mDrawFullUnderlineSet;
    private int mFullUnderlineHeight;
    private boolean mIgnoreTap;
    private int mIndicatorColor;
    private int mIndicatorHeight;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private int mMinPaddingBottom;
    private int mMinStripHeight;
    private int mMinTextSpacing;
    private int mTabAlpha;
    private int mTabPadding;
    private final Paint mTabPaint;
    private final Rect mTempRect;
    private int mTouchSlop;

    public PagerTabStrip(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public boolean getDrawFullUnderline() {
        return this.mDrawFullUnderline;
    }

    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.mMinStripHeight);
    }

    @ColorInt
    public int getTabIndicatorColor() {
        return this.mIndicatorColor;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.mCurrText.getLeft() - this.mTabPadding;
        int right = this.mCurrText.getRight() + this.mTabPadding;
        this.mTabPaint.setColor((this.mTabAlpha << 24) | (this.mIndicatorColor & 16777215));
        float f11 = (float) height;
        canvas.drawRect((float) left, (float) (height - this.mIndicatorHeight), (float) right, f11, this.mTabPaint);
        if (this.mDrawFullUnderline) {
            this.mTabPaint.setColor((this.mIndicatorColor & 16777215) | ViewCompat.MEASURED_STATE_MASK);
            canvas.drawRect((float) getPaddingLeft(), (float) (height - this.mFullUnderlineHeight), (float) (getWidth() - getPaddingRight()), f11, this.mTabPaint);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.mIgnoreTap) {
            return false;
        }
        float x11 = motionEvent.getX();
        float y11 = motionEvent.getY();
        if (action == 0) {
            this.mInitialMotionX = x11;
            this.mInitialMotionY = y11;
            this.mIgnoreTap = false;
        } else if (action != 1) {
            if (action == 2 && (Math.abs(x11 - this.mInitialMotionX) > ((float) this.mTouchSlop) || Math.abs(y11 - this.mInitialMotionY) > ((float) this.mTouchSlop))) {
                this.mIgnoreTap = true;
            }
        } else if (x11 < ((float) (this.mCurrText.getLeft() - this.mTabPadding))) {
            ViewPager viewPager = this.mPager;
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        } else if (x11 > ((float) (this.mCurrText.getRight() + this.mTabPadding))) {
            ViewPager viewPager2 = this.mPager;
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
        return true;
    }

    public void setBackgroundColor(@ColorInt int i11) {
        boolean z11;
        super.setBackgroundColor(i11);
        if (!this.mDrawFullUnderlineSet) {
            if ((i11 & ViewCompat.MEASURED_STATE_MASK) == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.mDrawFullUnderline = z11;
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        boolean z11;
        super.setBackgroundDrawable(drawable);
        if (!this.mDrawFullUnderlineSet) {
            if (drawable == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.mDrawFullUnderline = z11;
        }
    }

    public void setBackgroundResource(@DrawableRes int i11) {
        boolean z11;
        super.setBackgroundResource(i11);
        if (!this.mDrawFullUnderlineSet) {
            if (i11 == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.mDrawFullUnderline = z11;
        }
    }

    public void setDrawFullUnderline(boolean z11) {
        this.mDrawFullUnderline = z11;
        this.mDrawFullUnderlineSet = true;
        invalidate();
    }

    public void setPadding(int i11, int i12, int i13, int i14) {
        int i15 = this.mMinPaddingBottom;
        if (i14 < i15) {
            i14 = i15;
        }
        super.setPadding(i11, i12, i13, i14);
    }

    public void setTabIndicatorColor(@ColorInt int i11) {
        this.mIndicatorColor = i11;
        this.mTabPaint.setColor(i11);
        invalidate();
    }

    public void setTabIndicatorColorResource(@ColorRes int i11) {
        setTabIndicatorColor(ContextCompat.getColor(getContext(), i11));
    }

    public void setTextSpacing(int i11) {
        int i12 = this.mMinTextSpacing;
        if (i11 < i12) {
            i11 = i12;
        }
        super.setTextSpacing(i11);
    }

    public void updateTextPositions(int i11, float f11, boolean z11) {
        Rect rect = this.mTempRect;
        int height = getHeight();
        int left = this.mCurrText.getLeft() - this.mTabPadding;
        int right = this.mCurrText.getRight() + this.mTabPadding;
        int i12 = height - this.mIndicatorHeight;
        rect.set(left, i12, right, height);
        super.updateTextPositions(i11, f11, z11);
        this.mTabAlpha = (int) (Math.abs(f11 - 0.5f) * 2.0f * 255.0f);
        rect.union(this.mCurrText.getLeft() - this.mTabPadding, i12, this.mCurrText.getRight() + this.mTabPadding, height);
        invalidate(rect);
    }

    public PagerTabStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.mTabPaint = paint;
        this.mTempRect = new Rect();
        this.mTabAlpha = 255;
        this.mDrawFullUnderline = false;
        this.mDrawFullUnderlineSet = false;
        int i11 = this.mTextColor;
        this.mIndicatorColor = i11;
        paint.setColor(i11);
        float f11 = context.getResources().getDisplayMetrics().density;
        this.mIndicatorHeight = (int) ((3.0f * f11) + 0.5f);
        this.mMinPaddingBottom = (int) ((6.0f * f11) + 0.5f);
        this.mMinTextSpacing = (int) (64.0f * f11);
        this.mTabPadding = (int) ((16.0f * f11) + 0.5f);
        this.mFullUnderlineHeight = (int) ((1.0f * f11) + 0.5f);
        this.mMinStripHeight = (int) ((f11 * 32.0f) + 0.5f);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.mPrevText.setFocusable(true);
        this.mPrevText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ViewPager viewPager = PagerTabStrip.this.mPager;
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
            }
        });
        this.mNextText.setFocusable(true);
        this.mNextText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ViewPager viewPager = PagerTabStrip.this.mPager;
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        });
        if (getBackground() == null) {
            this.mDrawFullUnderline = true;
        }
    }
}
