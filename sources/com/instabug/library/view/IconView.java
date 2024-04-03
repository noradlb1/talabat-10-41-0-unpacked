package com.instabug.library.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;
import com.instabug.library.R;
import com.instabug.library.settings.e;

public class IconView extends AppCompatTextView {
    public static final int ANDROID_ACTIONBAR_ICON_SIZE_DP = 24;
    public static final int ANDROID_ACTIONBAR_ICON_SIZE_PADDING_DP = 1;
    @ColorInt

    /* renamed from: b  reason: collision with root package name */
    public int f52117b;

    /* renamed from: c  reason: collision with root package name */
    public float f52118c;
    @ColorInt

    /* renamed from: d  reason: collision with root package name */
    public int f52119d;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    public Paint f52120l;

    public IconView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void setActionBarPadding() {
        setPadding(ViewUtils.convertDpToPx(getContext(), 1.0f));
    }

    private void setActionBarSize() {
        setTextSize(1, 24.0f);
    }

    public void onDraw(Canvas canvas) {
        Paint paint = this.f52120l;
        if (paint != null) {
            paint.setColor(this.f52117b);
            this.f52120l.setStyle(Paint.Style.FILL);
            canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, Math.min(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f) - (this.f52118c / 2.0f), this.f52120l);
            this.f52120l.setStrokeWidth(this.f52118c);
            this.f52120l.setColor(this.f52119d);
            this.f52120l.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, Math.min(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f) - (this.f52118c / 2.0f), this.f52120l);
        }
        super.onDraw(canvas);
    }

    public void setBackgroundColor(@ColorInt int i11) {
        this.f52117b = i11;
        invalidate();
    }

    public void setPadding(int i11) {
        setPadding(i11, i11, i11, i11);
    }

    public void setStrokeColor(@ColorInt int i11) {
        this.f52119d = i11;
        invalidate();
    }

    public void setStrokeWidth(float f11) {
        this.f52118c = f11;
        invalidate();
    }

    public IconView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public IconView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f52117b = 0;
        this.f52118c = 0.0f;
        this.f52119d = 0;
        if (!isInEditMode()) {
            setTypeface(ResourcesCompat.getFont(context, R.font.ibg_font_icons));
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IconView);
            if (!obtainStyledAttributes.hasValue(R.styleable.IconView_android_textSize)) {
                setActionBarSize();
            }
            if (!obtainStyledAttributes.hasValue(R.styleable.IconView_android_padding)) {
                setActionBarPadding();
            }
            if (!obtainStyledAttributes.hasValue(R.styleable.IconView_android_textColor)) {
                setTextColor(e.j().r());
            }
            int i12 = obtainStyledAttributes.getInt(R.styleable.IconView_instabug_icon, -1);
            if (i12 != -1) {
                setText(a.a(i12));
            }
            obtainStyledAttributes.recycle();
            this.f52120l = new Paint(1);
        }
    }
}
