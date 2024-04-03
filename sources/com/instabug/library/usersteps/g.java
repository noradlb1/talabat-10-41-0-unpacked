package com.instabug.library.usersteps;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.AbsSeekBar;
import android.widget.CompoundButton;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.widget.NestedScrollView;
import androidx.viewpager.widget.ViewPager;
import com.instabug.library.Feature;
import com.instabug.library.Instabug;
import com.instabug.library.core.eventbus.CurrentActivityLifeCycleEventBus;
import com.instabug.library.e0;
import com.instabug.library.invocation.e;
import com.instabug.library.model.StepType;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.tracking.n;
import com.instabug.library.util.StringUtility;
import com.instabug.library.visualusersteps.inspector.a;
import com.instabug.library.visualusersteps.j;
import com.instabug.library.visualusersteps.k;
import com.instabug.library.visualusersteps.l;
import java.lang.ref.WeakReference;

public class g {

    /* renamed from: m  reason: collision with root package name */
    private static g f52007m;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private GestureDetector f52008a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private WeakReference f52009b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private WeakReference f52010c;

    /* renamed from: d  reason: collision with root package name */
    private final int f52011d;

    /* renamed from: e  reason: collision with root package name */
    private final int f52012e;

    /* renamed from: f  reason: collision with root package name */
    private int f52013f = 200;

    /* renamed from: g  reason: collision with root package name */
    private float f52014g;

    /* renamed from: h  reason: collision with root package name */
    private float f52015h;

    /* renamed from: i  reason: collision with root package name */
    private long f52016i = -1;

    /* renamed from: j  reason: collision with root package name */
    private long f52017j = -1;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public boolean f52018k = false;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public boolean f52019l = false;

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    private g() {
        if (Build.VERSION.SDK_INT <= 29) {
            b();
        } else {
            h();
        }
        this.f52011d = ViewConfiguration.getLongPressTimeout();
        this.f52012e = 200;
    }

    /* access modifiers changed from: private */
    @RequiresApi(28)
    public void a() {
        Activity activity;
        WeakReference weakReference = this.f52010c;
        if (weakReference != null && (activity = (Activity) weakReference.get()) != null && activity.isDestroyed()) {
            this.f52008a = null;
            this.f52009b = null;
        }
    }

    /* access modifiers changed from: private */
    @RequiresApi(28)
    public void c() {
        Activity currentActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
        WeakReference weakReference = this.f52010c;
        if (currentActivity != (weakReference != null ? (Activity) weakReference.get() : null)) {
            this.f52008a = null;
            this.f52009b = null;
            if (currentActivity != null) {
                this.f52010c = new WeakReference(currentActivity);
                this.f52008a = new GestureDetector(currentActivity, new e(this, (a) null));
                this.f52009b = new WeakReference(new ScaleGestureDetector(currentActivity, new f(this, (a) null)));
            }
        }
    }

    public static g d() {
        if (f52007m == null) {
            f52007m = new g();
        }
        return f52007m;
    }

    private boolean e() {
        long j11 = this.f52017j - this.f52016i;
        return j11 > ((long) this.f52012e) && j11 < ((long) this.f52011d);
    }

    private boolean g() {
        return e0.c().b((Object) Feature.TRACK_USER_STEPS) == Feature.State.ENABLED;
    }

    private void b() {
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext != null) {
            this.f52008a = new GestureDetector(applicationContext, new e(this, (a) null));
            this.f52009b = new WeakReference(new ScaleGestureDetector(applicationContext, new f(this, (a) null)));
        }
    }

    private boolean f() {
        return e0.c().b((Object) Feature.REPRO_STEPS) == Feature.State.ENABLED;
    }

    @RequiresApi(28)
    private void h() {
        CurrentActivityLifeCycleEventBus.getInstance().subscribe(new a(this));
    }

    private boolean d(View view) {
        return (view instanceof ScrollView) || (view instanceof HorizontalScrollView) || (view instanceof GridView) || (view instanceof ListView) || (view instanceof WebView) || (view instanceof NestedScrollView) || view.getClass().getName().equals("androidx.recyclerview.widget.RecyclerView") || view.getClass().getName().equals("com.google.android.material.tabs.TabLayout");
    }

    private boolean e(View view) {
        return (view instanceof SwitchCompat) || (view instanceof AbsSeekBar) || (view instanceof ViewPager);
    }

    private void b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f52014g = motionEvent.getX();
            this.f52015h = motionEvent.getY();
            this.f52016i = System.currentTimeMillis();
            this.f52018k = false;
        } else if (action == 1) {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            this.f52017j = System.currentTimeMillis();
            if (a(this.f52014g, x11, this.f52015h, y11)) {
                if (e()) {
                    a(StepType.LONG_PRESS, motionEvent);
                } else if (!this.f52018k && !this.f52019l) {
                    a(StepType.TAP, motionEvent);
                }
                this.f52019l = false;
            }
        }
    }

    public void a(MotionEvent motionEvent) {
        GestureDetector gestureDetector = this.f52008a;
        WeakReference weakReference = this.f52009b;
        if (weakReference != null) {
            ScaleGestureDetector scaleGestureDetector = (ScaleGestureDetector) weakReference.get();
            if (gestureDetector != null) {
                gestureDetector.onTouchEvent(motionEvent);
            }
            if (scaleGestureDetector != null) {
                scaleGestureDetector.onTouchEvent(motionEvent);
            }
        }
        b(motionEvent);
    }

    @VisibleForTesting
    public void d(String str, float f11, float f12) {
        Activity targetActivity;
        View view;
        if (!e.a((int) f11, (int) f12) && (targetActivity = InstabugInternalTrackingDelegate.getInstance().getTargetActivity()) != null && (view = (View) new a().a(targetActivity).a(f11, f12).blockingGet()) != null) {
            if (str.equals(StepType.FLING)) {
                d b11 = b(view);
                if (b11 != null) {
                    View view2 = b11.f52002a;
                    c cVar = b11.f52003b;
                    if (cVar == c.SCROLLABLE) {
                        str = StepType.SCROLL;
                    } else if (cVar == c.SWIPEABLE) {
                        str = StepType.SWIPE;
                    }
                    view = view2;
                } else {
                    return;
                }
            }
            String c11 = view instanceof TextView ? c(view) : null;
            if (view != null) {
                String a11 = a((Context) targetActivity, view.getId());
                if (g()) {
                    n.a().a(str, h.a(str, view.getClass().getName(), a11, c11, targetActivity.getClass().getName()), view.getClass().getName(), c11, targetActivity.getClass().getName());
                }
                if (f()) {
                    if (l.i(view)) {
                        str = StepType.MOVE;
                    }
                    if (view instanceof CompoundButton) {
                        str = ((CompoundButton) view).isChecked() ? StepType.DISABLE : StepType.ENABLE;
                    }
                    k.b().a(view, (j) new b(this, view, str, targetActivity.getClass().getSimpleName()));
                }
            }
        }
    }

    @Nullable
    private String c(View view) {
        TextView textView = (TextView) view;
        if (!(textView.getText() instanceof String)) {
            return null;
        }
        String str = (String) textView.getText();
        String trimString = StringUtility.trimString(str, 15);
        if (trimString.length() >= str.length()) {
            return str;
        }
        return trimString + "...";
    }

    private boolean a(float f11, float f12, float f13, float f14) {
        float abs = Math.abs(f11 - f12);
        float abs2 = Math.abs(f13 - f14);
        float f15 = (float) this.f52013f;
        return abs <= f15 && abs2 <= f15;
    }

    /* access modifiers changed from: private */
    public void a(String str, @Nullable MotionEvent motionEvent) {
        if (motionEvent != null) {
            d(str, (float) ((int) motionEvent.getRawX()), (float) ((int) motionEvent.getRawY()));
        }
    }

    @Nullable
    private static String a(Context context, int i11) {
        if (i11 == -1 || context == null) {
            return null;
        }
        try {
            if (context.getResources() != null) {
                return context.getResources().getResourceEntryName(i11);
            }
            return null;
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    @Nullable
    private d a(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && (parent instanceof ViewGroup)) {
            View view2 = (View) parent;
            if (d(view2)) {
                return d.a(view2);
            }
            if (e(view2)) {
                return d.b(view2);
            }
            parent = parent.getParent();
        }
        return null;
    }

    @Nullable
    private d b(View view) {
        if (d(view)) {
            return d.a(view);
        }
        if (e(view)) {
            return d.b(view);
        }
        return a(view);
    }
}
