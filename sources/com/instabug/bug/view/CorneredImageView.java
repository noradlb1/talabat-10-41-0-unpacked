package com.instabug.bug.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.instabug.bug.R;
import org.jetbrains.annotations.NotNull;

public class CorneredImageView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private final RectF f45793a;

    /* renamed from: b  reason: collision with root package name */
    private final Path f45794b;

    /* renamed from: c  reason: collision with root package name */
    private int f45795c;

    /* renamed from: d  reason: collision with root package name */
    private int f45796d;

    public static class a extends Drawable {

        /* renamed from: a  reason: collision with root package name */
        public Paint f45797a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public Rect f45798b;

        public a(int i11, int i12) {
            Paint paint = new Paint();
            this.f45797a = paint;
            paint.setColor(i11);
            this.f45797a.setStrokeWidth((float) i12);
            this.f45797a.setStyle(Paint.Style.STROKE);
        }

        public void draw(@NotNull Canvas canvas) {
            Rect rect = this.f45798b;
            if (rect != null) {
                canvas.drawRect(rect, this.f45797a);
            }
        }

        public int getOpacity() {
            return -1;
        }

        public void onBoundsChange(Rect rect) {
            this.f45798b = rect;
        }

        public void setAlpha(int i11) {
        }

        public void setColorFilter(@Nullable ColorFilter colorFilter) {
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public CorneredImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CorneredImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CorneredImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f45793a = new RectF();
        this.f45794b = new Path();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CorneredImageView);
        this.f45795c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CorneredImageView_ib_bug_cornerRadius, 0);
        this.f45796d = obtainStyledAttributes.getInt(R.styleable.CorneredImageView_ib_bug_roundedCorners, 0);
        obtainStyledAttributes.recycle();
    }

    private void a() {
        this.f45794b.rewind();
        if (((float) this.f45795c) >= 1.0f && this.f45796d != 0) {
            int width = getWidth();
            int height = getHeight();
            int i11 = this.f45795c;
            float f11 = (float) (i11 * 2);
            float f12 = (float) (-i11);
            float f13 = (float) i11;
            this.f45793a.set(f12, f12, f13, f13);
            if (a(1)) {
                this.f45793a.offsetTo(0.0f, 0.0f);
                this.f45794b.arcTo(this.f45793a, 180.0f, 90.0f);
            } else {
                this.f45794b.moveTo(0.0f, 0.0f);
            }
            if (a(2)) {
                this.f45793a.offsetTo(((float) width) - f11, 0.0f);
                this.f45794b.arcTo(this.f45793a, 270.0f, 90.0f);
            } else {
                this.f45794b.lineTo((float) width, 0.0f);
            }
            if (a(4)) {
                this.f45793a.offsetTo(((float) width) - f11, ((float) height) - f11);
                this.f45794b.arcTo(this.f45793a, 0.0f, 90.0f);
            } else {
                this.f45794b.lineTo((float) width, (float) height);
            }
            if (a(8)) {
                this.f45793a.offsetTo(0.0f, ((float) height) - f11);
                this.f45794b.arcTo(this.f45793a, 90.0f, 90.0f);
            } else {
                this.f45794b.lineTo(0.0f, (float) height);
            }
            this.f45794b.close();
        }
    }

    private boolean a(int i11) {
        return (this.f45796d & i11) == i11;
    }

    public int getRadius() {
        return this.f45795c;
    }

    public int getRoundedCorners() {
        return this.f45796d;
    }

    public void onDraw(Canvas canvas) {
        if (!this.f45794b.isEmpty()) {
            canvas.clipPath(this.f45794b);
        }
        super.onDraw(canvas);
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        a();
    }

    public void setCornerRadius(int i11) {
        this.f45795c = i11;
        a();
        invalidate();
    }

    public void setRoundedCorners(int i11) {
        this.f45796d = i11;
        a();
        setBackgroundDrawable(new a(0, 10));
        invalidate();
    }
}
