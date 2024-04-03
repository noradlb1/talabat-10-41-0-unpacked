package com.bumptech.glide.request.target;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.util.Preconditions;

public class FixedSizeDrawable extends Drawable {
    private final RectF bounds;
    private final Matrix matrix;
    private boolean mutated;
    private State state;
    private Drawable wrapped;
    private final RectF wrappedRect;

    public static final class State extends Drawable.ConstantState {
        final int height;
        final int width;
        private final Drawable.ConstantState wrapped;

        public State(State state) {
            this(state.wrapped, state.width, state.height);
        }

        public int getChangingConfigurations() {
            return 0;
        }

        @NonNull
        public Drawable newDrawable() {
            return new FixedSizeDrawable(this, this.wrapped.newDrawable());
        }

        public State(Drawable.ConstantState constantState, int i11, int i12) {
            this.wrapped = constantState;
            this.width = i11;
            this.height = i12;
        }

        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new FixedSizeDrawable(this, this.wrapped.newDrawable(resources));
        }
    }

    public FixedSizeDrawable(Drawable drawable, int i11, int i12) {
        this(new State(drawable.getConstantState(), i11, i12), drawable);
    }

    private void updateMatrix() {
        this.matrix.setRectToRect(this.wrappedRect, this.bounds, Matrix.ScaleToFit.CENTER);
    }

    public void clearColorFilter() {
        this.wrapped.clearColorFilter();
    }

    public void draw(@NonNull Canvas canvas) {
        canvas.save();
        canvas.concat(this.matrix);
        this.wrapped.draw(canvas);
        canvas.restore();
    }

    @RequiresApi(19)
    public int getAlpha() {
        return this.wrapped.getAlpha();
    }

    public Drawable.Callback getCallback() {
        return this.wrapped.getCallback();
    }

    public int getChangingConfigurations() {
        return this.wrapped.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        return this.state;
    }

    @NonNull
    public Drawable getCurrent() {
        return this.wrapped.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.state.height;
    }

    public int getIntrinsicWidth() {
        return this.state.width;
    }

    public int getMinimumHeight() {
        return this.wrapped.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.wrapped.getMinimumWidth();
    }

    public int getOpacity() {
        return this.wrapped.getOpacity();
    }

    public boolean getPadding(@NonNull Rect rect) {
        return this.wrapped.getPadding(rect);
    }

    public void invalidateSelf() {
        super.invalidateSelf();
        this.wrapped.invalidateSelf();
    }

    @NonNull
    public Drawable mutate() {
        if (!this.mutated && super.mutate() == this) {
            this.wrapped = this.wrapped.mutate();
            this.state = new State(this.state);
            this.mutated = true;
        }
        return this;
    }

    public void scheduleSelf(@NonNull Runnable runnable, long j11) {
        super.scheduleSelf(runnable, j11);
        this.wrapped.scheduleSelf(runnable, j11);
    }

    public void setAlpha(int i11) {
        this.wrapped.setAlpha(i11);
    }

    public void setBounds(int i11, int i12, int i13, int i14) {
        super.setBounds(i11, i12, i13, i14);
        this.bounds.set((float) i11, (float) i12, (float) i13, (float) i14);
        updateMatrix();
    }

    public void setChangingConfigurations(int i11) {
        this.wrapped.setChangingConfigurations(i11);
    }

    public void setColorFilter(int i11, @NonNull PorterDuff.Mode mode) {
        this.wrapped.setColorFilter(i11, mode);
    }

    @Deprecated
    public void setDither(boolean z11) {
        this.wrapped.setDither(z11);
    }

    public void setFilterBitmap(boolean z11) {
        this.wrapped.setFilterBitmap(z11);
    }

    public boolean setVisible(boolean z11, boolean z12) {
        return this.wrapped.setVisible(z11, z12);
    }

    public void unscheduleSelf(@NonNull Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.wrapped.unscheduleSelf(runnable);
    }

    public FixedSizeDrawable(State state2, Drawable drawable) {
        this.state = (State) Preconditions.checkNotNull(state2);
        this.wrapped = (Drawable) Preconditions.checkNotNull(drawable);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.matrix = new Matrix();
        this.wrappedRect = new RectF(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
        this.bounds = new RectF();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.wrapped.setColorFilter(colorFilter);
    }

    public void setBounds(@NonNull Rect rect) {
        super.setBounds(rect);
        this.bounds.set(rect);
        updateMatrix();
    }
}
