package com.instabug.library.invocation.invoker;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugCustomTextPlaceHolder;
import com.instabug.library.R;
import com.instabug.library.core.eventbus.CurrentActivityLifeCycleEventBus;
import com.instabug.library.internal.video.InternalScreenRecordHelper;
import com.instabug.library.internal.view.floatingactionbutton.f;
import com.instabug.library.internal.view.floatingactionbutton.h;
import com.instabug.library.internal.view.floatingactionbutton.k;
import com.instabug.library.invocation.InvocationManager;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.AccessibilityUtils;
import com.instabug.library.util.PlaceHolderUtils;
import com.instabug.library.util.TimeUtils;
import com.instabug.library.util.j;
import com.instabug.library.util.l;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;

public class p implements View.OnClickListener {
    /* access modifiers changed from: private */
    @Nullable
    public n A;
    /* access modifiers changed from: private */
    public final a B;
    @Nullable
    private j C;
    /* access modifiers changed from: private */
    @Nullable
    public WeakReference D;
    /* access modifiers changed from: private */
    public boolean E = false;
    /* access modifiers changed from: private */
    public final Runnable F = new d(this);
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout.LayoutParams f51362a;

    /* renamed from: b  reason: collision with root package name */
    private final CompositeDisposable f51363b = new CompositeDisposable();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f51364c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f51365d = 0;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f51366e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f51367f = 0;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f51368g = 0;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f51369h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public float f51370i;

    /* renamed from: j  reason: collision with root package name */
    private int f51371j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public boolean f51372k = false;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public boolean f51373l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f51374m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public boolean f51375n = true;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    public f f51376o;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    public k f51377p;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: q  reason: collision with root package name */
    public com.instabug.library.internal.view.a f51378q;

    /* renamed from: r  reason: collision with root package name */
    private int f51379r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public int f51380s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public int f51381t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public int f51382u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public int f51383v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public final Handler f51384w = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public long f51385x;
    @Nullable

    /* renamed from: y  reason: collision with root package name */
    private FrameLayout f51386y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public int f51387z;

    public interface a {
        void start();

        void stop(int i11);
    }

    public p(a aVar) {
        this.B = aVar;
    }

    /* access modifiers changed from: private */
    public boolean a(float f11, float f12) {
        return !(f11 == 0.0f || f12 == 0.0f || f11 * f12 <= 1.0f) || f11 * f12 < -1.0f;
    }

    /* access modifiers changed from: private */
    public void m() {
        FrameLayout.LayoutParams layoutParams;
        int i11;
        int i12;
        int i13 = this.f51371j;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i13, i13);
        FrameLayout.LayoutParams layoutParams3 = this.f51362a;
        if (layoutParams3 != null) {
            int i14 = layoutParams3.leftMargin;
            int i15 = (this.f51387z - this.f51371j) / 2;
            layoutParams2.leftMargin = i14 + i15;
            layoutParams2.rightMargin = layoutParams3.rightMargin + i15;
        }
        if (this.f51377p == null || layoutParams3 == null) {
            layoutParams = null;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.f51377p.getWidth(), this.f51377p.getHeight());
            FrameLayout.LayoutParams layoutParams4 = this.f51362a;
            int i16 = layoutParams4.leftMargin;
            int i17 = (this.f51387z - this.f51371j) / 2;
            layoutParams.leftMargin = i16 + i17;
            layoutParams.rightMargin = layoutParams4.rightMargin + i17;
        }
        int i18 = this.f51371j;
        int i19 = this.f51379r;
        int i21 = ((i19 * 2) + i18) * 2;
        FrameLayout.LayoutParams layoutParams5 = this.f51362a;
        if (layoutParams5 != null) {
            int i22 = layoutParams5.topMargin;
            if (i22 > i21) {
                int i23 = i18 + i19;
                i11 = i22 - i23;
                i12 = i11 - i23;
            } else {
                i11 = i22 + this.f51387z + i19;
                i12 = i18 + i11 + i19;
            }
            if (layoutParams != null) {
                layoutParams.topMargin = i11;
            }
            layoutParams2.topMargin = i12;
        }
        f fVar = this.f51376o;
        if (fVar != null) {
            fVar.setLayoutParams(layoutParams2);
        }
        k kVar = this.f51377p;
        if (kVar != null && layoutParams != null) {
            kVar.setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: private */
    public void o() {
        com.instabug.library.internal.view.a aVar;
        FrameLayout.LayoutParams layoutParams = this.f51362a;
        if (layoutParams != null && !this.f51374m && layoutParams.leftMargin != this.f51380s) {
            this.f51374m = true;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            com.instabug.library.internal.view.a aVar2 = this.f51378q;
            if (aVar2 != null) {
                aVar2.setLayoutParams(layoutParams2);
                this.f51378q.postDelayed(new l(this, layoutParams2), 100);
            }
            FrameLayout frameLayout = this.f51386y;
            if (frameLayout != null && (aVar = this.f51378q) != null) {
                frameLayout.addView(aVar);
            }
        }
    }

    private void r() {
        this.f51363b.add(CurrentActivityLifeCycleEventBus.getInstance().subscribe(new k(this)));
    }

    private void s() {
        this.f51363b.add(com.instabug.library.core.eventbus.a.a().subscribe(new e(this)));
    }

    public void k() {
        r();
        s();
    }

    public void l() {
        g();
        this.f51363b.clear();
        q();
    }

    public void onClick(View view) {
        t();
        if (!this.f51372k) {
            n nVar = this.A;
            if (nVar != null) {
                nVar.a("00:00", true);
            }
            this.f51372k = true;
            a aVar = this.B;
            if (aVar != null) {
                aVar.start();
            }
            n nVar2 = this.A;
            if (nVar2 != null) {
                nVar2.setRecordingState(h.RECORDING);
            }
        }
        j();
    }

    public void p() {
        this.f51385x = System.currentTimeMillis();
        this.f51384w.removeCallbacks(this.F);
        this.f51384w.postDelayed(this.F, 0);
    }

    /* access modifiers changed from: private */
    public void a() {
        if (this.A != null) {
            AccessibilityUtils.sendTextEvent(a((long) d()));
        }
    }

    private static int b(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    /* access modifiers changed from: private */
    public boolean c(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        return inputMethodManager != null && inputMethodManager.isAcceptingText();
    }

    /* access modifiers changed from: private */
    public int d() {
        return TimeUtils.millisToSeconds(System.currentTimeMillis() - this.f51385x);
    }

    /* access modifiers changed from: private */
    public void e() {
        i();
        j();
    }

    /* access modifiers changed from: private */
    public void f() {
        Activity currentActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
        if (currentActivity != null) {
            this.f51367f = currentActivity.getResources().getDisplayMetrics().heightPixels;
            int i11 = currentActivity.getResources().getDisplayMetrics().widthPixels;
            this.f51366e = i11;
            a(currentActivity, i11, this.f51367f);
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        int[] iArr = {0, 0};
        n nVar = this.A;
        if (nVar != null) {
            nVar.getLocationOnScreen(iArr);
        }
        if (iArr[1] != this.f51382u && this.A != null) {
            WeakReference weakReference = this.D;
            if (!(weakReference == null || weakReference.get() == null)) {
                this.f51367f = ((Activity) this.D.get()).getResources().getDisplayMetrics().heightPixels;
            }
            int i11 = iArr[0];
            if (i11 == this.f51381t) {
                this.f51383v = this.f51367f - (this.f51387z + this.f51379r);
            }
            this.A.m(i11, this.f51383v);
            if (this.f51374m) {
                j();
            }
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        n nVar;
        WeakReference weakReference = this.D;
        Activity activity = weakReference != null ? (Activity) weakReference.get() : null;
        if (activity != null && (nVar = this.A) != null) {
            int a11 = a(activity);
            int[] iArr = {0, 0};
            nVar.getLocationOnScreen(iArr);
            int i11 = iArr[0];
            int i12 = iArr[1];
            int i13 = this.f51382u;
            if (i12 == i13) {
                a11 = i13;
            }
            nVar.m(i11, a11);
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    private void i() {
        u();
        FrameLayout frameLayout = this.f51386y;
        if (frameLayout != null) {
            frameLayout.setOnClickListener((View.OnClickListener) null);
            if (this.f51386y.getParent() != null && (this.f51386y.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.f51386y.getParent()).removeView(this.f51386y);
            }
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        com.instabug.library.internal.view.a aVar;
        if (this.f51374m) {
            this.f51374m = false;
            FrameLayout frameLayout = this.f51386y;
            if (frameLayout != null && (aVar = this.f51378q) != null) {
                frameLayout.removeView(aVar);
            }
        }
    }

    private void n() {
        h hVar = this.f51372k ? h.RECORDING : h.STOPPED;
        n nVar = this.A;
        if (nVar != null) {
            nVar.setRecordingState(hVar);
        }
    }

    private void t() {
        if (this.f51373l) {
            b();
        } else {
            c();
        }
    }

    private void u() {
        this.D = null;
        j jVar = this.C;
        if (jVar != null) {
            jVar.a();
        }
    }

    public void q() {
        this.f51372k = false;
        this.f51375n = true;
        this.f51373l = false;
        this.f51384w.removeCallbacks(this.F);
        i();
        this.A = null;
        this.f51386y = null;
        this.f51376o = null;
        this.f51377p = null;
        this.f51378q = null;
    }

    /* access modifiers changed from: private */
    public void c() {
        k kVar;
        f fVar;
        int i11 = this.f51382u;
        WeakReference weakReference = this.D;
        Activity activity = weakReference != null ? (Activity) weakReference.get() : null;
        int[] iArr = {0, 0};
        n nVar = this.A;
        if (nVar != null) {
            nVar.getLocationOnScreen(iArr);
        }
        if (!(!this.E || activity == null || iArr[1] == this.f51382u)) {
            i11 = a(activity);
        }
        FrameLayout.LayoutParams layoutParams = this.f51362a;
        if (layoutParams != null) {
            if (Math.abs(layoutParams.leftMargin - this.f51380s) > 20 && Math.abs(this.f51362a.leftMargin - this.f51381t) > 20) {
                return;
            }
            if (Math.abs(this.f51362a.topMargin - i11) > 20 && Math.abs(this.f51362a.topMargin - this.f51383v) > 20) {
                return;
            }
        }
        m();
        f fVar2 = this.f51376o;
        if (!(fVar2 == null || fVar2.getParent() == null)) {
            ((ViewGroup) this.f51376o.getParent()).removeView(this.f51376o);
        }
        FrameLayout frameLayout = this.f51386y;
        if (!(frameLayout == null || (fVar = this.f51376o) == null)) {
            frameLayout.addView(fVar);
            this.f51386y.setNextFocusForwardId(R.id.instabug_video_mute_button);
        }
        k kVar2 = this.f51377p;
        if (!(kVar2 == null || kVar2.getParent() == null)) {
            ((ViewGroup) this.f51377p.getParent()).removeView(this.f51377p);
        }
        FrameLayout frameLayout2 = this.f51386y;
        if (!(frameLayout2 == null || (kVar = this.f51377p) == null)) {
            frameLayout2.addView(kVar);
        }
        this.f51373l = true;
    }

    private String a(long j11) {
        n nVar = this.A;
        if (nVar == null) {
            return "";
        }
        return nVar.getContext().getResources().getString(R.string.ibg_screen_recording_duration_for_accessibility, new Object[]{Long.valueOf(j11)});
    }

    private void d(Activity activity) {
        this.D = new WeakReference(activity);
        this.C = new j(activity, new j(this));
    }

    /* access modifiers changed from: private */
    public void b() {
        k kVar;
        f fVar;
        FrameLayout frameLayout = this.f51386y;
        if (!(frameLayout == null || (fVar = this.f51376o) == null)) {
            frameLayout.removeView(fVar);
        }
        FrameLayout frameLayout2 = this.f51386y;
        if (!(frameLayout2 == null || (kVar = this.f51377p) == null)) {
            frameLayout2.removeView(kVar);
        }
        this.f51373l = false;
    }

    private void a(Activity activity, int i11, int i12) {
        FrameLayout frameLayout = this.f51386y;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.f51386y = new FrameLayout(activity);
        this.f51369h = activity.getResources().getConfiguration().orientation;
        int b11 = b(activity);
        this.f51370i = activity.getResources().getDisplayMetrics().density;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        this.f51368g = displayMetrics.widthPixels;
        this.f51387z = (int) activity.getResources().getDimension(R.dimen.instabug_fab_size_normal);
        this.f51371j = (int) activity.getResources().getDimension(R.dimen.instabug_fab_size_mini);
        int dimension = (int) activity.getResources().getDimension(R.dimen.instabug_fab_actions_spacing);
        this.f51379r = dimension;
        this.f51380s = 0;
        int i13 = this.f51387z + dimension;
        this.f51381t = i11 - i13;
        this.f51382u = b11;
        this.f51383v = i12 - i13;
        com.instabug.library.internal.view.a aVar = new com.instabug.library.internal.view.a(activity);
        this.f51378q = aVar;
        aVar.setText(PlaceHolderUtils.getPlaceHolder(Instabug.getApplicationContext(), InstabugCustomTextPlaceHolder.Key.VIDEO_RECORDING_FAB_BUBBLE_HINT, R.string.instabug_str_video_recording_hint));
        this.f51376o = new f(activity);
        if (!l.a() && this.f51376o.getVisibility() == 0) {
            this.f51376o.setVisibility(8);
        }
        if (this.f51375n) {
            this.f51376o.d();
        } else {
            this.f51376o.e();
        }
        this.f51376o.setOnClickListener(new f(this));
        this.f51377p = new k(activity);
        this.f51363b.add(InternalScreenRecordHelper.getInstance().getIsStoppableObservable().subscribe(new g(this)));
        k kVar = this.f51377p;
        if (kVar != null) {
            kVar.setOnClickListener(new h(this, activity));
        }
        this.A = new n(this, activity);
        if (this.f51362a == null) {
            int i14 = this.f51387z;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i14, i14, 51);
            this.f51362a = layoutParams;
            this.A.setLayoutParams(layoutParams);
            int i15 = c.f51337a[InvocationManager.getInstance().getCurrentInvocationSettings().getVideoRecordingButtonPosition().ordinal()];
            if (i15 == 1) {
                this.A.m(this.f51380s, this.f51383v);
            } else if (i15 == 2) {
                this.A.m(this.f51380s, this.f51382u);
            } else if (i15 != 3) {
                this.A.m(this.f51381t, this.f51383v);
            } else {
                this.A.m(this.f51381t, this.f51382u);
            }
        } else {
            this.f51364c = Math.round(((float) (this.f51364c * i11)) / ((float) i11));
            int round = Math.round(((float) (this.f51365d * i12)) / ((float) i12));
            this.f51365d = round;
            FrameLayout.LayoutParams layoutParams2 = this.f51362a;
            int i16 = this.f51364c;
            layoutParams2.leftMargin = i16;
            layoutParams2.rightMargin = i11 - i16;
            layoutParams2.topMargin = round;
            layoutParams2.bottomMargin = i12 - round;
            this.A.setLayoutParams(layoutParams2);
            this.A.d();
        }
        n nVar = this.A;
        if (nVar != null) {
            nVar.setOnClickListener(this);
            FrameLayout frameLayout2 = this.f51386y;
            if (frameLayout2 != null) {
                frameLayout2.addView(this.A);
            }
        }
        n();
        ((FrameLayout) activity.getWindow().getDecorView()).addView(this.f51386y, new ViewGroup.LayoutParams(-1, -1));
        new Handler(Looper.getMainLooper()).postDelayed(new i(this, activity), 100);
        d(activity);
    }

    /* access modifiers changed from: private */
    public int a(@NonNull Activity activity) {
        View rootView = activity.getWindow().getDecorView().getRootView();
        Rect rect = new Rect();
        rootView.getWindowVisibleDisplayFrame(rect);
        return (rect.height() - this.f51379r) - this.f51387z;
    }

    /* access modifiers changed from: private */
    public void a(Configuration configuration) {
        Activity currentActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
        if (currentActivity != null) {
            e();
            this.f51362a = null;
            this.f51366e = (int) a(currentActivity.getApplicationContext(), (float) configuration.screenWidthDp);
            int a11 = (int) a(currentActivity.getApplicationContext(), (float) configuration.screenHeightDp);
            this.f51367f = a11;
            a(currentActivity, this.f51366e, a11);
        }
    }

    private static float a(Context context, float f11) {
        return f11 * context.getResources().getDisplayMetrics().density;
    }
}
