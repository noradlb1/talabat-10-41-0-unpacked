package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.ProgressBar;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public abstract class BaseProgressIndicator<S extends BaseProgressIndicatorSpec> extends ProgressBar {
    static final float DEFAULT_OPACITY = 0.2f;
    static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_ProgressIndicator;
    public static final int HIDE_INWARD = 2;
    public static final int HIDE_NONE = 0;
    public static final int HIDE_OUTWARD = 1;
    static final int MAX_ALPHA = 255;
    static final int MAX_HIDE_DELAY = 1000;
    public static final int SHOW_INWARD = 2;
    public static final int SHOW_NONE = 0;
    public static final int SHOW_OUTWARD = 1;
    AnimatorDurationScaleProvider animatorDurationScaleProvider;
    private final Runnable delayedHide = new Runnable() {
        public void run() {
            BaseProgressIndicator.this.internalHide();
            long unused = BaseProgressIndicator.this.lastShowStartTime = -1;
        }
    };
    private final Runnable delayedShow = new Runnable() {
        public void run() {
            BaseProgressIndicator.this.internalShow();
        }
    };
    private final Animatable2Compat.AnimationCallback hideAnimationCallback = new Animatable2Compat.AnimationCallback() {
        public void onAnimationEnd(Drawable drawable) {
            super.onAnimationEnd(drawable);
            if (!BaseProgressIndicator.this.isIndeterminateModeChangeRequested) {
                BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
                baseProgressIndicator.setVisibility(baseProgressIndicator.visibilityAfterHide);
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean isIndeterminateModeChangeRequested = false;
    private boolean isParentDoneInitializing;
    /* access modifiers changed from: private */
    public long lastShowStartTime = -1;
    private final int minHideDelay;
    private final int showDelay;
    S spec;
    /* access modifiers changed from: private */
    public int storedProgress;
    /* access modifiers changed from: private */
    public boolean storedProgressAnimated;
    private final Animatable2Compat.AnimationCallback switchIndeterminateModeCallback = new Animatable2Compat.AnimationCallback() {
        public void onAnimationEnd(Drawable drawable) {
            BaseProgressIndicator.this.setIndeterminate(false);
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            baseProgressIndicator.setProgressCompat(baseProgressIndicator.storedProgress, BaseProgressIndicator.this.storedProgressAnimated);
        }
    };
    /* access modifiers changed from: private */
    public int visibilityAfterHide = 4;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface HideAnimationBehavior {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ShowAnimationBehavior {
    }

    public BaseProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i11, @StyleRes int i12) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i11, DEF_STYLE_RES), attributeSet, i11);
        Context context2 = getContext();
        this.spec = createSpec(context2, attributeSet);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R.styleable.BaseProgressIndicator, i11, i12, new int[0]);
        this.showDelay = obtainStyledAttributes.getInt(R.styleable.BaseProgressIndicator_showDelay, -1);
        this.minHideDelay = Math.min(obtainStyledAttributes.getInt(R.styleable.BaseProgressIndicator_minHideDelay, -1), 1000);
        obtainStyledAttributes.recycle();
        this.animatorDurationScaleProvider = new AnimatorDurationScaleProvider();
        this.isParentDoneInitializing = true;
    }

    @Nullable
    private DrawingDelegate<S> getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().getDrawingDelegate();
        } else if (getProgressDrawable() == null) {
            return null;
        } else {
            return getProgressDrawable().getDrawingDelegate();
        }
    }

    /* access modifiers changed from: private */
    public void internalHide() {
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).setVisible(false, false, true);
        if (isNoLongerNeedToBeVisible()) {
            setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    public void internalShow() {
        if (this.minHideDelay > 0) {
            this.lastShowStartTime = SystemClock.uptimeMillis();
        }
        setVisibility(0);
    }

    private boolean isNoLongerNeedToBeVisible() {
        if ((getProgressDrawable() == null || !getProgressDrawable().isVisible()) && (getIndeterminateDrawable() == null || !getIndeterminateDrawable().isVisible())) {
            return true;
        }
        return false;
    }

    private void registerAnimationCallbacks() {
        if (!(getProgressDrawable() == null || getIndeterminateDrawable() == null)) {
            getIndeterminateDrawable().getAnimatorDelegate().registerAnimatorsCompleteCallback(this.switchIndeterminateModeCallback);
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().registerAnimationCallback(this.hideAnimationCallback);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().registerAnimationCallback(this.hideAnimationCallback);
        }
    }

    private void unregisterAnimationCallbacks() {
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().unregisterAnimationCallback(this.hideAnimationCallback);
            getIndeterminateDrawable().getAnimatorDelegate().unregisterAnimatorsCompleteCallback();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().unregisterAnimationCallback(this.hideAnimationCallback);
        }
    }

    public void applyNewVisibility(boolean z11) {
        if (this.isParentDoneInitializing) {
            ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).setVisible(visibleToUser(), false, z11);
        }
    }

    public abstract S createSpec(@NonNull Context context, @NonNull AttributeSet attributeSet);

    @Nullable
    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.spec.hideAnimationBehavior;
    }

    @NonNull
    public int[] getIndicatorColor() {
        return this.spec.indicatorColors;
    }

    public int getShowAnimationBehavior() {
        return this.spec.showAnimationBehavior;
    }

    @ColorInt
    public int getTrackColor() {
        return this.spec.trackColor;
    }

    @Px
    public int getTrackCornerRadius() {
        return this.spec.trackCornerRadius;
    }

    @Px
    public int getTrackThickness() {
        return this.spec.trackThickness;
    }

    public void hide() {
        boolean z11;
        if (getVisibility() != 0) {
            removeCallbacks(this.delayedShow);
            return;
        }
        removeCallbacks(this.delayedHide);
        long uptimeMillis = SystemClock.uptimeMillis() - this.lastShowStartTime;
        int i11 = this.minHideDelay;
        if (uptimeMillis >= ((long) i11)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.delayedHide.run();
        } else {
            postDelayed(this.delayedHide, ((long) i11) - uptimeMillis);
        }
    }

    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    public boolean isEffectivelyVisible() {
        View view = this;
        while (view.getVisibility() == 0) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                if (getWindowVisibility() == 0) {
                    return true;
                }
                return false;
            } else if (!(parent instanceof View)) {
                return true;
            } else {
                view = (View) parent;
            }
        }
        return false;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        registerAnimationCallbacks();
        if (visibleToUser()) {
            internalShow();
        }
    }

    public void onDetachedFromWindow() {
        removeCallbacks(this.delayedHide);
        removeCallbacks(this.delayedShow);
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).hideNow();
        unregisterAnimationCallbacks();
        super.onDetachedFromWindow();
    }

    public synchronized void onDraw(@NonNull Canvas canvas) {
        int save = canvas.save();
        if (!(getPaddingLeft() == 0 && getPaddingTop() == 0)) {
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
        }
        if (!(getPaddingRight() == 0 && getPaddingBottom() == 0)) {
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
        }
        getCurrentDrawable().draw(canvas);
        canvas.restoreToCount(save);
    }

    public synchronized void onMeasure(int i11, int i12) {
        int i13;
        int i14;
        super.onMeasure(i11, i12);
        DrawingDelegate currentDrawingDelegate = getCurrentDrawingDelegate();
        if (currentDrawingDelegate != null) {
            int preferredWidth = currentDrawingDelegate.getPreferredWidth();
            int preferredHeight = currentDrawingDelegate.getPreferredHeight();
            if (preferredWidth < 0) {
                i13 = getMeasuredWidth();
            } else {
                i13 = preferredWidth + getPaddingLeft() + getPaddingRight();
            }
            if (preferredHeight < 0) {
                i14 = getMeasuredHeight();
            } else {
                i14 = preferredHeight + getPaddingTop() + getPaddingBottom();
            }
            setMeasuredDimension(i13, i14);
        }
    }

    public void onVisibilityChanged(@NonNull View view, int i11) {
        boolean z11;
        super.onVisibilityChanged(view, i11);
        if (i11 == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        applyNewVisibility(z11);
    }

    public void onWindowVisibilityChanged(int i11) {
        super.onWindowVisibilityChanged(i11);
        applyNewVisibility(false);
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setAnimatorDurationScaleProvider(@NonNull AnimatorDurationScaleProvider animatorDurationScaleProvider2) {
        this.animatorDurationScaleProvider = animatorDurationScaleProvider2;
        if (getProgressDrawable() != null) {
            getProgressDrawable().animatorDurationScaleProvider = animatorDurationScaleProvider2;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().animatorDurationScaleProvider = animatorDurationScaleProvider2;
        }
    }

    public void setHideAnimationBehavior(int i11) {
        this.spec.hideAnimationBehavior = i11;
        invalidate();
    }

    public synchronized void setIndeterminate(boolean z11) {
        if (z11 != isIndeterminate()) {
            DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange = (DrawableWithAnimatedVisibilityChange) getCurrentDrawable();
            if (drawableWithAnimatedVisibilityChange != null) {
                drawableWithAnimatedVisibilityChange.hideNow();
            }
            super.setIndeterminate(z11);
            DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange2 = (DrawableWithAnimatedVisibilityChange) getCurrentDrawable();
            if (drawableWithAnimatedVisibilityChange2 != null) {
                drawableWithAnimatedVisibilityChange2.setVisible(visibleToUser(), false, false);
            }
            if ((drawableWithAnimatedVisibilityChange2 instanceof IndeterminateDrawable) && visibleToUser()) {
                ((IndeterminateDrawable) drawableWithAnimatedVisibilityChange2).getAnimatorDelegate().startAnimator();
            }
            this.isIndeterminateModeChangeRequested = false;
        }
    }

    public void setIndeterminateDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable((Drawable) null);
        } else if (drawable instanceof IndeterminateDrawable) {
            ((DrawableWithAnimatedVisibilityChange) drawable).hideNow();
            super.setIndeterminateDrawable(drawable);
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
        }
    }

    public void setIndicatorColor(@ColorInt int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{MaterialColors.getColor(getContext(), R.attr.colorPrimary, -1)};
        }
        if (!Arrays.equals(getIndicatorColor(), iArr)) {
            this.spec.indicatorColors = iArr;
            getIndeterminateDrawable().getAnimatorDelegate().invalidateSpecValues();
            invalidate();
        }
    }

    public synchronized void setProgress(int i11) {
        if (!isIndeterminate()) {
            setProgressCompat(i11, false);
        }
    }

    public void setProgressCompat(int i11, boolean z11) {
        if (!isIndeterminate()) {
            super.setProgress(i11);
            if (getProgressDrawable() != null && !z11) {
                getProgressDrawable().jumpToCurrentState();
            }
        } else if (getProgressDrawable() != null) {
            this.storedProgress = i11;
            this.storedProgressAnimated = z11;
            this.isIndeterminateModeChangeRequested = true;
            if (!getIndeterminateDrawable().isVisible() || this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(getContext().getContentResolver()) == 0.0f) {
                this.switchIndeterminateModeCallback.onAnimationEnd(getIndeterminateDrawable());
            } else {
                getIndeterminateDrawable().getAnimatorDelegate().requestCancelAnimatorAfterCurrentCycle();
            }
        }
    }

    public void setProgressDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable((Drawable) null);
        } else if (drawable instanceof DeterminateDrawable) {
            DeterminateDrawable determinateDrawable = (DeterminateDrawable) drawable;
            determinateDrawable.hideNow();
            super.setProgressDrawable(determinateDrawable);
            determinateDrawable.setLevelByFraction(((float) getProgress()) / ((float) getMax()));
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
        }
    }

    public void setShowAnimationBehavior(int i11) {
        this.spec.showAnimationBehavior = i11;
        invalidate();
    }

    public void setTrackColor(@ColorInt int i11) {
        S s11 = this.spec;
        if (s11.trackColor != i11) {
            s11.trackColor = i11;
            invalidate();
        }
    }

    public void setTrackCornerRadius(@Px int i11) {
        S s11 = this.spec;
        if (s11.trackCornerRadius != i11) {
            s11.trackCornerRadius = Math.min(i11, s11.trackThickness / 2);
        }
    }

    public void setTrackThickness(@Px int i11) {
        S s11 = this.spec;
        if (s11.trackThickness != i11) {
            s11.trackThickness = i11;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i11) {
        if (i11 == 0 || i11 == 4 || i11 == 8) {
            this.visibilityAfterHide = i11;
            return;
        }
        throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
    }

    public void show() {
        if (this.showDelay > 0) {
            removeCallbacks(this.delayedShow);
            postDelayed(this.delayedShow, (long) this.showDelay);
            return;
        }
        this.delayedShow.run();
    }

    public boolean visibleToUser() {
        if (!ViewCompat.isAttachedToWindow(this) || getWindowVisibility() != 0 || !isEffectivelyVisible()) {
            return false;
        }
        return true;
    }

    @Nullable
    public IndeterminateDrawable<S> getIndeterminateDrawable() {
        return (IndeterminateDrawable) super.getIndeterminateDrawable();
    }

    @Nullable
    public DeterminateDrawable<S> getProgressDrawable() {
        return (DeterminateDrawable) super.getProgressDrawable();
    }
}
