package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.R;

public class MockView extends View {

    /* renamed from: b  reason: collision with root package name */
    public String f11064b = null;
    private int mDiagonalsColor = Color.argb(255, 0, 0, 0);
    private boolean mDrawDiagonals = true;
    private boolean mDrawLabel = true;
    private int mMargin = 4;
    private Paint mPaintDiagonals = new Paint();
    private Paint mPaintText = new Paint();
    private Paint mPaintTextBackground = new Paint();
    private int mTextBackgroundColor = Color.argb(255, 50, 50, 50);
    private Rect mTextBounds = new Rect();
    private int mTextColor = Color.argb(255, 200, 200, 200);

    public MockView(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MockView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R.styleable.MockView_mock_label) {
                    this.f11064b = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.MockView_mock_showDiagonals) {
                    this.mDrawDiagonals = obtainStyledAttributes.getBoolean(index, this.mDrawDiagonals);
                } else if (index == R.styleable.MockView_mock_diagonalsColor) {
                    this.mDiagonalsColor = obtainStyledAttributes.getColor(index, this.mDiagonalsColor);
                } else if (index == R.styleable.MockView_mock_labelBackgroundColor) {
                    this.mTextBackgroundColor = obtainStyledAttributes.getColor(index, this.mTextBackgroundColor);
                } else if (index == R.styleable.MockView_mock_labelColor) {
                    this.mTextColor = obtainStyledAttributes.getColor(index, this.mTextColor);
                } else if (index == R.styleable.MockView_mock_showLabel) {
                    this.mDrawLabel = obtainStyledAttributes.getBoolean(index, this.mDrawLabel);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.f11064b == null) {
            try {
                this.f11064b = context.getResources().getResourceEntryName(getId());
            } catch (Exception unused) {
            }
        }
        this.mPaintDiagonals.setColor(this.mDiagonalsColor);
        this.mPaintDiagonals.setAntiAlias(true);
        this.mPaintText.setColor(this.mTextColor);
        this.mPaintText.setAntiAlias(true);
        this.mPaintTextBackground.setColor(this.mTextBackgroundColor);
        this.mMargin = Math.round(((float) this.mMargin) * (getResources().getDisplayMetrics().xdpi / 160.0f));
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.mDrawDiagonals) {
            width--;
            height--;
            float f11 = (float) width;
            float f12 = (float) height;
            canvas.drawLine(0.0f, 0.0f, f11, f12, this.mPaintDiagonals);
            Canvas canvas2 = canvas;
            float f13 = f11;
            canvas2.drawLine(0.0f, f12, f13, 0.0f, this.mPaintDiagonals);
            canvas2.drawLine(0.0f, 0.0f, f13, 0.0f, this.mPaintDiagonals);
            float f14 = f11;
            float f15 = f12;
            canvas2.drawLine(f14, 0.0f, f13, f15, this.mPaintDiagonals);
            float f16 = f12;
            canvas2.drawLine(f14, f16, 0.0f, f15, this.mPaintDiagonals);
            canvas2.drawLine(0.0f, f16, 0.0f, 0.0f, this.mPaintDiagonals);
        }
        String str = this.f11064b;
        if (str != null && this.mDrawLabel) {
            this.mPaintText.getTextBounds(str, 0, str.length(), this.mTextBounds);
            float width2 = ((float) (width - this.mTextBounds.width())) / 2.0f;
            float height2 = (((float) (height - this.mTextBounds.height())) / 2.0f) + ((float) this.mTextBounds.height());
            this.mTextBounds.offset((int) width2, (int) height2);
            Rect rect = this.mTextBounds;
            int i11 = rect.left;
            int i12 = this.mMargin;
            rect.set(i11 - i12, rect.top - i12, rect.right + i12, rect.bottom + i12);
            canvas.drawRect(this.mTextBounds, this.mPaintTextBackground);
            canvas.drawText(this.f11064b, width2, height2, this.mPaintText);
        }
    }

    public MockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public MockView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context, attributeSet);
    }
}
