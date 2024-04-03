package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;

public class MotionTelltales extends MockView {
    private static final String TAG = "MotionTelltales";

    /* renamed from: c  reason: collision with root package name */
    public MotionLayout f11085c;

    /* renamed from: d  reason: collision with root package name */
    public float[] f11086d = new float[2];

    /* renamed from: e  reason: collision with root package name */
    public Matrix f11087e = new Matrix();

    /* renamed from: f  reason: collision with root package name */
    public int f11088f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f11089g = -65281;

    /* renamed from: h  reason: collision with root package name */
    public float f11090h = 0.25f;
    private Paint mPaintTelltales = new Paint();

    public MotionTelltales(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MotionTelltales);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R.styleable.MotionTelltales_telltales_tailColor) {
                    this.f11089g = obtainStyledAttributes.getColor(index, this.f11089g);
                } else if (index == R.styleable.MotionTelltales_telltales_velocityMode) {
                    this.f11088f = obtainStyledAttributes.getInt(index, this.f11088f);
                } else if (index == R.styleable.MotionTelltales_telltales_tailScale) {
                    this.f11090h = obtainStyledAttributes.getFloat(index, this.f11090h);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mPaintTelltales.setColor(this.f11089g);
        this.mPaintTelltales.setStrokeWidth(5.0f);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getMatrix().invert(this.f11087e);
        if (this.f11085c == null) {
            ViewParent parent = getParent();
            if (parent instanceof MotionLayout) {
                this.f11085c = (MotionLayout) parent;
                return;
            }
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float[] fArr = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        for (int i11 = 0; i11 < 5; i11++) {
            float f11 = fArr[i11];
            for (int i12 = 0; i12 < 5; i12++) {
                float f12 = fArr[i12];
                this.f11085c.getViewVelocity(this, f12, f11, this.f11086d, this.f11088f);
                this.f11087e.mapVectors(this.f11086d);
                float f13 = ((float) width) * f12;
                float f14 = ((float) height) * f11;
                float[] fArr2 = this.f11086d;
                float f15 = fArr2[0];
                float f16 = this.f11090h;
                float f17 = f14 - (fArr2[1] * f16);
                this.f11087e.mapVectors(fArr2);
                canvas.drawLine(f13, f14, f13 - (f15 * f16), f17, this.mPaintTelltales);
            }
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        postInvalidate();
    }

    public void setText(CharSequence charSequence) {
        this.f11064b = charSequence.toString();
        requestLayout();
    }

    public MotionTelltales(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public MotionTelltales(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context, attributeSet);
    }
}
