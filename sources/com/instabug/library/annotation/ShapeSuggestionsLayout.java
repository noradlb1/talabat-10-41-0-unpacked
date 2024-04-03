package com.instabug.library.annotation;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.exoplayer2.C;
import com.instabug.library.R;
import com.instabug.library.util.AccessibilityUtils;
import com.instabug.library.util.AttrResolver;

public class ShapeSuggestionsLayout extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public float f34084a;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public e f34085b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f34086c;

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f34087d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private Handler f34088e;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            ShapeSuggestionsLayout.this.c();
        }
    }

    public class b implements Animator.AnimatorListener {
        public b() {
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            ShapeSuggestionsLayout.this.setVisibility(4);
            ShapeSuggestionsLayout.this.removeAllViews();
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            int indexOfChild = ShapeSuggestionsLayout.this.indexOfChild(view);
            ShapeSuggestionsLayout.this.a(indexOfChild);
            if (ShapeSuggestionsLayout.this.f34085b != null) {
                ShapeSuggestionsLayout.this.f34085b.a(indexOfChild);
            }
            ShapeSuggestionsLayout.this.c();
        }
    }

    public class d extends AccessibilityDelegateCompat {
        public d(ShapeSuggestionsLayout shapeSuggestionsLayout) {
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setRoleDescription("Button");
        }
    }

    public interface e {
        void a(int i11);
    }

    public final class f extends View {

        /* renamed from: a  reason: collision with root package name */
        private Path f34092a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private Path f34093b;

        /* renamed from: c  reason: collision with root package name */
        private Paint f34094c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private RectF f34095d;
        @ColorInt

        /* renamed from: e  reason: collision with root package name */
        private int f34096e;
        @ColorInt

        /* renamed from: f  reason: collision with root package name */
        private int f34097f;

        public f(Context context, Path path, int i11) {
            super(context);
            this.f34092a = path;
            Paint paint = new Paint(1);
            this.f34094c = paint;
            paint.setStrokeWidth(4.0f);
            this.f34097f = i11;
        }

        public Path a(Path path, RectF rectF) {
            Path path2 = new Path(path);
            RectF rectF2 = new RectF();
            path2.computeBounds(rectF2, true);
            Matrix matrix = new Matrix();
            matrix.setRectToRect(rectF2, rectF, Matrix.ScaleToFit.CENTER);
            path2.transform(matrix);
            return path2;
        }

        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            this.f34094c.setColor(this.f34096e);
            this.f34094c.setStyle(Paint.Style.FILL);
            RectF rectF = this.f34095d;
            if (rectF != null) {
                canvas.drawRoundRect(rectF, ShapeSuggestionsLayout.this.f34084a, ShapeSuggestionsLayout.this.f34084a, this.f34094c);
            }
            this.f34094c.setColor(this.f34097f);
            this.f34094c.setStyle(Paint.Style.STROKE);
            Path path = this.f34093b;
            if (path != null) {
                canvas.drawPath(path, this.f34094c);
            }
        }

        public void onMeasure(int i11, int i12) {
            super.onMeasure(i11, i12);
            int dimension = (int) getResources().getDimension(R.dimen.instabug_path_view_margin);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
            layoutParams.setMargins(dimension, dimension, dimension, dimension);
            setLayoutParams(layoutParams);
            int dimension2 = (int) getResources().getDimension(R.dimen.instabug_path_view_dimen);
            setMeasuredDimension(dimension2, dimension2);
            float f11 = (float) dimension2;
            this.f34095d = new RectF(0.0f, 0.0f, f11, f11);
            RectF rectF = new RectF(this.f34095d);
            rectF.inset(8.0f, 8.0f);
            this.f34093b = a(this.f34092a, rectF);
        }

        public void setBackgroundColor(@ColorInt int i11) {
            this.f34096e = i11;
            invalidate();
        }
    }

    public ShapeSuggestionsLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void b() {
        if (this.f34086c) {
            this.f34086c = false;
            setVisibility(0);
            animate().alpha(1.0f).setDuration(400).setListener((Animator.AnimatorListener) null);
            if (this.f34088e != null && !AccessibilityUtils.isAccessibilityServiceEnabled()) {
                this.f34088e.postDelayed(this.f34087d, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
            }
        }
    }

    public void c() {
        Handler handler = this.f34088e;
        if (handler != null) {
            handler.removeCallbacks(this.f34087d);
        }
        if (!this.f34086c) {
            this.f34086c = true;
            animate().alpha(0.0f).setDuration(400).setListener(new b());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (!this.f34086c) {
            c();
            b();
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Handler handler = this.f34088e;
        if (handler != null) {
            handler.removeCallbacks(this.f34087d);
            this.f34088e = null;
        }
    }

    public void setOnShapeSelectedListener(e eVar) {
        this.f34085b = eVar;
    }

    public ShapeSuggestionsLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context) {
        setVisibility(4);
        setGravity(17);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f34084a = TypedValue.applyDimension(1, 4.0f, displayMetrics);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(AttrResolver.getBackgroundColor(getContext()));
        gradientDrawable.setCornerRadius(this.f34084a);
        gradientDrawable.setStroke((int) TypedValue.applyDimension(1, 1.5f, displayMetrics), AttrResolver.getDividerColor(getContext()));
        setBackground(gradientDrawable);
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public ShapeSuggestionsLayout(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f34087d = new a();
        this.f34088e = new Handler();
        a(context);
    }

    public void a(@StringRes int i11, Path path) {
        f fVar = new f(getContext(), path, AttrResolver.getTintingColor(getContext()));
        fVar.setOnClickListener(new c());
        fVar.setFocusable(true);
        fVar.setClickable(true);
        fVar.setContentDescription(getContext().getString(i11));
        ViewCompat.setAccessibilityDelegate(fVar, new d(this));
        addView(fVar);
        a(0);
    }

    /* access modifiers changed from: private */
    public void a(int i11) {
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            getChildAt(i12).setBackgroundColor(0);
        }
        getChildAt(i11).setBackgroundColor(AttrResolver.getDividerColor(getContext()));
    }
}
