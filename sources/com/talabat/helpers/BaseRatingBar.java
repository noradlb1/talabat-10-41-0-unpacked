package com.talabat.helpers;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.talabat.R;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BaseRatingBar extends LinearLayout {
    private static final int MAX_CLICK_DISTANCE = 5;
    private static final int MAX_CLICK_DURATION = 200;
    public static final String TAG = "SimpleRatingBar";

    /* renamed from: b  reason: collision with root package name */
    public List<PartialView> f60779b;
    private boolean mClearRatingEnabled;
    private final DecimalFormat mDecimalFormat;
    private Drawable mEmptyDrawable;
    private Drawable mFilledDrawable;
    private boolean mIsTouchable;
    private int mNumStars;
    private OnRatingChangeListener mOnRatingChangeListener;
    private boolean mOnlyClick;
    private int mPadding;
    private float mPreviousRating;
    private float mRating;
    private boolean mRelativePadding;
    private int mSpaceBetweenStars;
    private int mStarHeight;
    private int mStarWidth;
    private float mStartX;
    private float mStartY;
    private float mStepSize;

    public interface OnRatingChangeListener {
        void onRatingChange(BaseRatingBar baseRatingBar, float f11);
    }

    public BaseRatingBar(Context context) {
        this(context, (AttributeSet) null);
    }

    private float calculateRating(float f11, PartialView partialView) {
        return Float.parseFloat(this.mDecimalFormat.format((double) (((float) ((Integer) partialView.getTag()).intValue()) - (1.0f - (((float) Math.round(Float.parseFloat(this.mDecimalFormat.format((double) ((f11 - ((float) partialView.getLeft())) / ((float) partialView.getWidth())))) / this.mStepSize)) * this.mStepSize)))));
    }

    private PartialView getPartialView(int i11, Drawable drawable, Drawable drawable2) {
        PartialView partialView = new PartialView(getContext());
        partialView.setTag(Integer.valueOf(i11));
        if (!this.mRelativePadding) {
            int i12 = this.mPadding;
            partialView.setPadding(i12, i12, i12, i12);
        } else if (i11 == 1) {
            int i13 = this.mPadding;
            partialView.setPaddingRelative(0, i13, i13, i13);
        } else {
            int i14 = this.mPadding;
            partialView.setPaddingRelative(i14, i14, i14, i14);
        }
        partialView.setFilledDrawable(drawable);
        partialView.setEmptyDrawable(drawable2);
        return partialView;
    }

    private void handleClickEvent(float f11) {
        float f12;
        for (PartialView next : this.f60779b) {
            if (isPositionInRatingView(f11, next)) {
                if (this.mStepSize == 1.0f) {
                    f12 = (float) ((Integer) next.getTag()).intValue();
                } else {
                    f12 = calculateRating(f11, next);
                }
                if (this.mPreviousRating != f12 || !isClearRatingEnabled()) {
                    setRating(f12);
                    return;
                } else {
                    setRating(0.0f);
                    return;
                }
            }
        }
    }

    private void handleMoveEvent(float f11) {
        for (PartialView next : this.f60779b) {
            if (f11 < ((float) next.getWidth()) / 10.0f) {
                setRating(0.0f);
                return;
            } else if (isPositionInRatingView(f11, next)) {
                float calculateRating = calculateRating(f11, next);
                if (this.mRating != calculateRating) {
                    setRating(calculateRating);
                }
            }
        }
    }

    private void initRatingView() {
        this.f60779b = new ArrayList();
        int i11 = this.mStarWidth;
        int i12 = -2;
        if (i11 == 0) {
            i11 = -2;
        }
        int i13 = this.mStarHeight;
        if (i13 != 0) {
            i12 = i13;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i11, i12);
        for (int i14 = 1; i14 <= this.mNumStars; i14++) {
            PartialView partialView = getPartialView(i14, this.mFilledDrawable, this.mEmptyDrawable);
            this.f60779b.add(partialView);
            if (!(i14 == 1 || i14 == this.mNumStars)) {
                layoutParams.setMarginStart(this.mSpaceBetweenStars);
            }
            addView(partialView, layoutParams);
        }
    }

    private boolean isClickEvent(float f11, float f12, MotionEvent motionEvent) {
        if (((float) (motionEvent.getEventTime() - motionEvent.getDownTime())) > 200.0f) {
            return false;
        }
        float abs = Math.abs(f11 - motionEvent.getX());
        float abs2 = Math.abs(f12 - motionEvent.getY());
        if (abs > 5.0f || abs2 > 5.0f) {
            return false;
        }
        return true;
    }

    private boolean isPositionInRatingView(float f11, View view) {
        return f11 > ((float) view.getLeft()) && f11 < ((float) view.getRight());
    }

    private void verifyParamsValue() {
        if (this.mNumStars <= 0) {
            this.mNumStars = 5;
        }
        if (this.mPadding < 0) {
            this.mPadding = 0;
        }
        if (this.mSpaceBetweenStars < 0) {
            this.mSpaceBetweenStars = 6;
        }
        if (this.mEmptyDrawable == null) {
            Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.ds_star_filled);
            this.mEmptyDrawable = drawable;
            Drawable wrap = DrawableCompat.wrap(drawable.mutate());
            DrawableCompat.setTint(wrap, ContextCompat.getColor(getContext(), R.color.ds_neutral_10));
            this.mEmptyDrawable = wrap;
        }
        if (this.mFilledDrawable == null) {
            Drawable drawable2 = ContextCompat.getDrawable(getContext(), R.drawable.ds_star_filled);
            this.mFilledDrawable = drawable2;
            Drawable wrap2 = DrawableCompat.wrap(drawable2.mutate());
            DrawableCompat.setTint(wrap2, ContextCompat.getColor(getContext(), R.color.ds_alert_100));
            this.mFilledDrawable = wrap2;
        }
        float f11 = this.mStepSize;
        if (f11 > 1.0f) {
            this.mStepSize = 1.0f;
        } else if (f11 < 0.1f) {
            this.mStepSize = 0.1f;
        }
    }

    public void a(float f11) {
        for (PartialView next : this.f60779b) {
            int i11 = (((double) ((Integer) next.getTag()).intValue()) > Math.ceil((double) f11) ? 1 : (((double) ((Integer) next.getTag()).intValue()) == Math.ceil((double) f11) ? 0 : -1));
            if (i11 > 0) {
                next.setEmpty();
            } else if (i11 == 0) {
                next.setPartialFilled(f11);
            } else {
                next.setFilled();
            }
        }
    }

    public float getRating() {
        return this.mRating;
    }

    public boolean isClearRatingEnabled() {
        return this.mClearRatingEnabled;
    }

    public boolean isTouchable() {
        return this.mIsTouchable;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isTouchable()) {
            return false;
        }
        float x11 = motionEvent.getX();
        float y11 = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mStartX = x11;
            this.mStartY = y11;
            this.mPreviousRating = this.mRating;
        } else if (action != 1) {
            if (action == 2 && !this.mOnlyClick) {
                handleMoveEvent(x11);
            }
        } else if (!isClickEvent(this.mStartX, this.mStartY, motionEvent) && !this.mOnlyClick) {
            return false;
        } else {
            handleClickEvent(x11);
        }
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    }

    public void setOnRatingChangeListener(OnRatingChangeListener onRatingChangeListener) {
        this.mOnRatingChangeListener = onRatingChangeListener;
    }

    public void setRating(float f11) {
        int i11 = this.mNumStars;
        if (f11 > ((float) i11)) {
            f11 = (float) i11;
        }
        if (f11 < 0.0f) {
            f11 = 0.0f;
        }
        if (this.mRating != f11) {
            this.mRating = f11;
            OnRatingChangeListener onRatingChangeListener = this.mOnRatingChangeListener;
            if (onRatingChangeListener != null) {
                onRatingChangeListener.onRatingChange(this, f11);
            }
            a(f11);
        }
    }

    public void setTouchable(boolean z11) {
        this.mIsTouchable = z11;
    }

    public BaseRatingBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseRatingBar(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mPadding = 0;
        this.mSpaceBetweenStars = 0;
        this.mRating = -1.0f;
        this.mStepSize = 1.0f;
        this.mPreviousRating = 0.0f;
        this.mIsTouchable = true;
        this.mClearRatingEnabled = true;
        this.mRelativePadding = false;
        this.mOnlyClick = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.talabat.talabatcommon.R.styleable.RatingBarAttributes);
        float f11 = obtainStyledAttributes.getFloat(5, this.mRating);
        this.mNumStars = obtainStyledAttributes.getInt(3, this.mNumStars);
        if (obtainStyledAttributes.hasValue(8)) {
            this.mRelativePadding = true;
            this.mPadding = obtainStyledAttributes.getDimensionPixelSize(8, this.mPadding);
        } else {
            this.mRelativePadding = false;
            this.mPadding = obtainStyledAttributes.getDimensionPixelSize(9, this.mPadding);
        }
        this.mStarWidth = obtainStyledAttributes.getDimensionPixelSize(10, 0);
        this.mStarHeight = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        this.mSpaceBetweenStars = obtainStyledAttributes.getDimensionPixelSize(6, 6);
        this.mStepSize = obtainStyledAttributes.getFloat(11, this.mStepSize);
        Drawable drawable = null;
        this.mEmptyDrawable = obtainStyledAttributes.hasValue(1) ? ContextCompat.getDrawable(context, obtainStyledAttributes.getResourceId(1, -1)) : null;
        this.mFilledDrawable = obtainStyledAttributes.hasValue(2) ? ContextCompat.getDrawable(context, obtainStyledAttributes.getResourceId(2, -1)) : drawable;
        this.mIsTouchable = obtainStyledAttributes.getBoolean(12, this.mIsTouchable);
        this.mOnlyClick = obtainStyledAttributes.getBoolean(4, this.mOnlyClick);
        this.mClearRatingEnabled = obtainStyledAttributes.getBoolean(0, this.mClearRatingEnabled);
        obtainStyledAttributes.recycle();
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.US);
        decimalFormatSymbols.setDecimalSeparator('.');
        this.mDecimalFormat = new DecimalFormat("#.##", decimalFormatSymbols);
        verifyParamsValue();
        initRatingView();
        setRating(f11);
    }
}
