package com.adyen.checkout.ui.internal.card;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import com.adyen.checkout.ui.R;
import com.adyen.checkout.ui.internal.common.util.TextViewUtil;
import com.adyen.checkout.ui.internal.common.util.ThemeUtil;

public class CodeView extends AppCompatEditText {
    private static final int DEFAULT_LENGTH = 4;
    private static final String STATE_LENGTH = "STATE_LENGTH";
    private static final String STATE_SUPER_STATE = "STATE_SUPER_STATE";
    private int mLength;
    private InputFilter.LengthFilter mLengthFilter;
    private RectF mRectF;
    private Paint mRectPaint;
    private Paint mTintedRectPaint;
    private boolean mTouching;

    public CodeView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void initRectPaints(@NonNull Context context) {
        Paint paint = new Paint();
        this.mRectPaint = paint;
        paint.setAntiAlias(true);
        this.mRectPaint.setColor(ContextCompat.getColor(context, R.color.code_view_rect));
        this.mRectPaint.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.mTintedRectPaint = paint2;
        paint2.setAntiAlias(true);
        this.mTintedRectPaint.setColor(ThemeUtil.getPrimaryThemeColor(context));
        this.mTintedRectPaint.setStyle(Paint.Style.STROKE);
    }

    public void onDraw(@NonNull Canvas canvas) {
        boolean z11;
        Paint paint;
        TextPaint paint2 = getPaint();
        float ascent = paint2.ascent();
        float descent = paint2.descent();
        float textSize = getTextSize();
        float f11 = textSize / 4.0f;
        float f12 = textSize / 20.0f;
        float f13 = textSize / 10.0f;
        char[] charArray = getText().toString().toCharArray();
        float f14 = f12 / 2.0f;
        float height = (float) ((int) (((float) (getHeight() / 2)) - ((descent + ascent) / 2.0f)));
        this.mRectF.set(f14, ascent + height, textSize + f14, descent + height);
        this.mRectPaint.setStrokeWidth(f12);
        this.mTintedRectPaint.setStrokeWidth(f12);
        for (int i11 = 0; i11 < this.mLength; i11++) {
            if (i11 < charArray.length || this.mTouching) {
                z11 = true;
            } else {
                z11 = false;
            }
            RectF rectF = this.mRectF;
            if (z11) {
                paint = this.mTintedRectPaint;
            } else {
                paint = this.mRectPaint;
            }
            canvas.drawRoundRect(rectF, f13, f13, paint);
            if (i11 < charArray.length) {
                canvas.drawText(String.valueOf(charArray[i11]), this.mRectF.left + f11, height, paint2);
            }
            this.mRectF.offset(textSize + f13, 0.0f);
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null && layoutParams.width == -2) {
            float textSize = getTextSize();
            setMeasuredDimension((int) Math.ceil((double) (((float) this.mLength) * (textSize + (textSize / 10.0f)))), getMeasuredHeight());
        }
    }

    public void onRestoreInstanceState(@NonNull Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable(STATE_SUPER_STATE));
            setLength(bundle.getInt(STATE_LENGTH));
        }
        invalidate();
    }

    @Nullable
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            return onSaveInstanceState;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(STATE_SUPER_STATE, onSaveInstanceState);
        bundle.putInt(STATE_LENGTH, this.mLength);
        return bundle;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        boolean z11 = true;
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            z11 = false;
        }
        if (this.mTouching != z11) {
            this.mTouching = z11;
            invalidate();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setLength(int i11) {
        if (i11 != this.mLength) {
            Editable text = getText();
            int length = text.length();
            if (length > i11) {
                text.delete(length, i11);
            }
            InputFilter.LengthFilter lengthFilter = this.mLengthFilter;
            if (lengthFilter != null) {
                TextViewUtil.removeInputFilter((TextView) this, lengthFilter);
            }
            InputFilter.LengthFilter lengthFilter2 = new InputFilter.LengthFilter(i11);
            this.mLengthFilter = lengthFilter2;
            TextViewUtil.addInputFilter(this, lengthFilter2);
            this.mLength = i11;
            invalidate();
        }
    }

    public CodeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public CodeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        getPaint().setColor(ThemeUtil.getAttributeColor(context, 16842806));
        this.mRectF = new RectF();
        initRectPaints(context);
        setBackgroundColor(0);
        setInputType(2);
        setCursorVisible(false);
        setMovementMethod((MovementMethod) null);
        setImeOptions(getImeOptions() | 268435456);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CodeView);
            setLength(obtainStyledAttributes.getInt(R.styleable.CodeView_codeView_length, 4));
            obtainStyledAttributes.recycle();
            return;
        }
        setLength(4);
    }
}
