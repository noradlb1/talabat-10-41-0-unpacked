package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.R;

public class MotionButton extends AppCompatButton {

    /* renamed from: b  reason: collision with root package name */
    public ViewOutlineProvider f11065b;

    /* renamed from: c  reason: collision with root package name */
    public RectF f11066c;
    private Path mPath;
    /* access modifiers changed from: private */
    public float mRound = Float.NaN;
    /* access modifiers changed from: private */
    public float mRoundPercent = 0.0f;

    public MotionButton(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R.styleable.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getRound() {
        return this.mRound;
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    @RequiresApi(21)
    public void setRound(float f11) {
        boolean z11;
        if (Float.isNaN(f11)) {
            this.mRound = f11;
            float f12 = this.mRoundPercent;
            this.mRoundPercent = -1.0f;
            setRoundPercent(f12);
            return;
        }
        if (this.mRound != f11) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.mRound = f11;
        if (f11 != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.f11066c == null) {
                this.f11066c = new RectF();
            }
            if (this.f11065b == null) {
                AnonymousClass2 r52 = new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, MotionButton.this.getWidth(), MotionButton.this.getHeight(), MotionButton.this.mRound);
                    }
                };
                this.f11065b = r52;
                setOutlineProvider(r52);
            }
            setClipToOutline(true);
            this.f11066c.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.mPath.reset();
            Path path = this.mPath;
            RectF rectF = this.f11066c;
            float f13 = this.mRound;
            path.addRoundRect(rectF, f13, f13, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z11) {
            invalidateOutline();
        }
    }

    @RequiresApi(21)
    public void setRoundPercent(float f11) {
        boolean z11;
        if (this.mRoundPercent != f11) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.mRoundPercent = f11;
        if (f11 != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.f11066c == null) {
                this.f11066c = new RectF();
            }
            if (this.f11065b == null) {
                AnonymousClass1 r62 = new ViewOutlineProvider() {
                    public void getOutline(View view, Outline outline) {
                        int width = MotionButton.this.getWidth();
                        int height = MotionButton.this.getHeight();
                        outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * MotionButton.this.mRoundPercent) / 2.0f);
                    }
                };
                this.f11065b = r62;
                setOutlineProvider(r62);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.mRoundPercent) / 2.0f;
            this.f11066c.set(0.0f, 0.0f, (float) width, (float) height);
            this.mPath.reset();
            this.mPath.addRoundRect(this.f11066c, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z11) {
            invalidateOutline();
        }
    }

    public MotionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public MotionButton(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context, attributeSet);
    }
}
