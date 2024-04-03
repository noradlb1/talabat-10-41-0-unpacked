package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.annotation.Nullable;
import androidx.appcompat.R;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;

class AppCompatSeekBarHelper extends AppCompatProgressBarHelper {
    private boolean mHasTickMarkTint = false;
    private boolean mHasTickMarkTintMode = false;
    private Drawable mTickMark;
    private ColorStateList mTickMarkTintList = null;
    private PorterDuff.Mode mTickMarkTintMode = null;
    private final SeekBar mView;

    public AppCompatSeekBarHelper(SeekBar seekBar) {
        super(seekBar);
        this.mView = seekBar;
    }

    private void applyTickMarkTint() {
        Drawable drawable = this.mTickMark;
        if (drawable == null) {
            return;
        }
        if (this.mHasTickMarkTint || this.mHasTickMarkTintMode) {
            Drawable wrap = DrawableCompat.wrap(drawable.mutate());
            this.mTickMark = wrap;
            if (this.mHasTickMarkTint) {
                DrawableCompat.setTintList(wrap, this.mTickMarkTintList);
            }
            if (this.mHasTickMarkTintMode) {
                DrawableCompat.setTintMode(this.mTickMark, this.mTickMarkTintMode);
            }
            if (this.mTickMark.isStateful()) {
                this.mTickMark.setState(this.mView.getDrawableState());
            }
        }
    }

    public void b(AttributeSet attributeSet, int i11) {
        super.b(attributeSet, i11);
        Context context = this.mView.getContext();
        int[] iArr = R.styleable.AppCompatSeekBar;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i11, 0);
        SeekBar seekBar = this.mView;
        ViewCompat.saveAttributeDataForStyleable(seekBar, seekBar.getContext(), iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i11, 0);
        Drawable drawableIfKnown = obtainStyledAttributes.getDrawableIfKnown(R.styleable.AppCompatSeekBar_android_thumb);
        if (drawableIfKnown != null) {
            this.mView.setThumb(drawableIfKnown);
        }
        g(obtainStyledAttributes.getDrawable(R.styleable.AppCompatSeekBar_tickMark));
        int i12 = R.styleable.AppCompatSeekBar_tickMarkTintMode;
        if (obtainStyledAttributes.hasValue(i12)) {
            this.mTickMarkTintMode = DrawableUtils.parseTintMode(obtainStyledAttributes.getInt(i12, -1), this.mTickMarkTintMode);
            this.mHasTickMarkTintMode = true;
        }
        int i13 = R.styleable.AppCompatSeekBar_tickMarkTint;
        if (obtainStyledAttributes.hasValue(i13)) {
            this.mTickMarkTintList = obtainStyledAttributes.getColorStateList(i13);
            this.mHasTickMarkTint = true;
        }
        obtainStyledAttributes.recycle();
        applyTickMarkTint();
    }

    public void d(Canvas canvas) {
        int i11;
        if (this.mTickMark != null) {
            int max = this.mView.getMax();
            int i12 = 1;
            if (max > 1) {
                int intrinsicWidth = this.mTickMark.getIntrinsicWidth();
                int intrinsicHeight = this.mTickMark.getIntrinsicHeight();
                if (intrinsicWidth >= 0) {
                    i11 = intrinsicWidth / 2;
                } else {
                    i11 = 1;
                }
                if (intrinsicHeight >= 0) {
                    i12 = intrinsicHeight / 2;
                }
                this.mTickMark.setBounds(-i11, -i12, i11, i12);
                float width = ((float) ((this.mView.getWidth() - this.mView.getPaddingLeft()) - this.mView.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.mView.getPaddingLeft(), (float) (this.mView.getHeight() / 2));
                for (int i13 = 0; i13 <= max; i13++) {
                    this.mTickMark.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    public void e() {
        Drawable drawable = this.mTickMark;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.mView.getDrawableState())) {
            this.mView.invalidateDrawable(drawable);
        }
    }

    public void f() {
        Drawable drawable = this.mTickMark;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public void g(@Nullable Drawable drawable) {
        Drawable drawable2 = this.mTickMark;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.mTickMark = drawable;
        if (drawable != null) {
            drawable.setCallback(this.mView);
            DrawableCompat.setLayoutDirection(drawable, ViewCompat.getLayoutDirection(this.mView));
            if (drawable.isStateful()) {
                drawable.setState(this.mView.getDrawableState());
            }
            applyTickMarkTint();
        }
        this.mView.invalidate();
    }
}
