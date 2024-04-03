package com.instabug.featuresrequest.ui.custom;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.instabug.featuresrequest.R;

public final class q {

    /* renamed from: g  reason: collision with root package name */
    public static final Interpolator f46715g = new FastOutSlowInInterpolator();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final Handler f46716h = new Handler(Looper.getMainLooper(), new g());

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f46717a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f46718b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final SnackbarLayout f46719c;

    /* renamed from: d  reason: collision with root package name */
    private int f46720d;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public p f46721e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final r f46722f = new i(this);

    private q(ViewGroup viewGroup) {
        this.f46717a = viewGroup;
        Context context = viewGroup.getContext();
        this.f46718b = context;
        this.f46719c = (SnackbarLayout) LayoutInflater.from(context).inflate(R.layout.ib_fr_insta_toast_layout, viewGroup, false);
    }

    public static float a(float f11, Context context) {
        return f11 * (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f);
    }

    private static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (drawable instanceof VectorDrawable) {
            return a((VectorDrawable) drawable);
        }
        throw new IllegalArgumentException("unsupported drawable type");
    }

    @TargetApi(21)
    private static Bitmap a(VectorDrawable vectorDrawable) {
        Bitmap createBitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        vectorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        vectorDrawable.draw(canvas);
        return createBitmap;
    }

    private Drawable a(Drawable drawable, int i11) {
        if (!(drawable.getIntrinsicWidth() == i11 && drawable.getIntrinsicHeight() == i11) && (drawable instanceof BitmapDrawable)) {
            drawable = new BitmapDrawable(this.f46718b.getResources(), Bitmap.createScaledBitmap(a(drawable), i11, i11, true));
        }
        drawable.setBounds(0, 0, i11, i11);
        return drawable;
    }

    @NonNull
    public static q a(View view, @NonNull CharSequence charSequence, int i11) {
        q qVar = new q((ViewGroup) view);
        qVar.a(charSequence);
        qVar.f(i11);
        return qVar;
    }

    private void a(int i11) {
        ViewCompat.animate(this.f46719c).translationY((float) (-this.f46719c.getHeight())).setInterpolator(f46715g).setDuration(250).setListener(new e(this, i11)).start();
    }

    /* access modifiers changed from: private */
    public void b() {
        SnackbarLayout snackbarLayout = this.f46719c;
        ViewCompat.setTranslationY(snackbarLayout, (float) (-snackbarLayout.getHeight()));
        ViewCompat.animate(this.f46719c).translationY(0.0f).setInterpolator(f46715g).setDuration(250).setListener(new n(this)).start();
    }

    /* access modifiers changed from: private */
    public void b(int i11) {
        t.c().a(this.f46722f, i11);
    }

    /* access modifiers changed from: private */
    public void d(int i11) {
        t.c().e(this.f46722f);
        ViewParent parent = this.f46719c.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f46719c);
        }
    }

    private boolean e() {
        ViewGroup.LayoutParams layoutParams = this.f46719c.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            return false;
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
        return (behavior instanceof SwipeDismissBehavior) && ((SwipeDismissBehavior) behavior).getDragState() != 0;
    }

    public q a(@DrawableRes int i11, float f11) {
        TextView messageView = this.f46719c.getMessageView();
        Drawable drawable = ContextCompat.getDrawable(this.f46718b, i11);
        if (drawable != null) {
            Drawable a11 = a(drawable, (int) a(f11, this.f46718b));
            if (messageView != null) {
                Drawable[] compoundDrawables = messageView.getCompoundDrawables();
                messageView.setCompoundDrawables(a11, compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
            }
            return this;
        }
        throw new IllegalArgumentException("resource_id is not a valid drawable!");
    }

    @NonNull
    public q a(@NonNull CharSequence charSequence) {
        TextView messageView = this.f46719c.getMessageView();
        if (messageView != null) {
            messageView.setText(charSequence);
        }
        return this;
    }

    public q b(@DrawableRes int i11, float f11) {
        TextView messageView = this.f46719c.getMessageView();
        Drawable drawable = ContextCompat.getDrawable(this.f46718b, i11);
        if (drawable != null) {
            Drawable a11 = a(drawable, (int) a(f11, this.f46718b));
            if (messageView != null) {
                Drawable[] compoundDrawables = messageView.getCompoundDrawables();
                messageView.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], a11, compoundDrawables[3]);
            }
            return this;
        }
        throw new IllegalArgumentException("resource_id is not a valid drawable!");
    }

    public void c() {
        b(3);
    }

    @NonNull
    public View d() {
        return this.f46719c;
    }

    @NonNull
    public q e(@ColorInt int i11) {
        Button actionView = this.f46719c.getActionView();
        if (actionView != null) {
            actionView.setTextColor(i11);
        }
        return this;
    }

    @NonNull
    public q f(int i11) {
        this.f46720d = i11;
        return this;
    }

    public boolean f() {
        return t.c().b(this.f46722f);
    }

    public q g(int i11) {
        this.f46719c.f46694c = i11;
        return this;
    }

    public void g() {
        t.c().a(this.f46720d, this.f46722f);
        d().setOnTouchListener(new h(this));
    }

    public final void n(int i11) {
        if (this.f46719c.getVisibility() != 0 || e()) {
            d(i11);
        } else {
            a(i11);
        }
    }

    public final void p() {
        if (this.f46719c.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f46719c.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                a aVar = new a(this.f46722f);
                aVar.setStartAlphaSwipeDistance(0.1f);
                aVar.setEndAlphaSwipeDistance(0.6f);
                aVar.setSwipeDirection(0);
                aVar.setListener(new j(this));
                ((CoordinatorLayout.LayoutParams) layoutParams).setBehavior(aVar);
            }
            this.f46717a.addView(this.f46719c);
        }
        this.f46719c.setOnAttachStateChangeListener(new l(this));
        if (ViewCompat.isLaidOut(this.f46719c)) {
            b();
        } else {
            this.f46719c.setOnLayoutChangeListener(new m(this));
        }
    }
}
