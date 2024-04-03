package com.instabug.library.invocation.invoker;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.instabug.library.InstabugState;
import com.instabug.library.InstabugStateProvider;
import com.instabug.library.R;
import com.instabug.library._InstabugActivity;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.invocation.InvocationManager;
import com.instabug.library.invocation.util.InstabugFloatingButtonEdge;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.threading.PoolProvider;
import java.lang.ref.WeakReference;

public class FloatingButtonInvoker implements a, View.OnClickListener {
    private static final int LANDSCAPE_MODE = 2;
    private static final int MIN_TOP_LOCATION = 50;
    private static final int NAVIGATION_BAR_SIZE = 48;

    /* renamed from: b  reason: collision with root package name */
    public int f51311b;

    /* renamed from: c  reason: collision with root package name */
    public int f51312c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f51313d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f51314e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f51315f = 0;
    @Nullable
    private WeakReference<f> floatingButtonFrameLayoutWeakReference;
    /* access modifiers changed from: private */
    public int floatingButtonSize;
    @Nullable
    private WeakReference<e> floatingButtonWeakReference;

    /* renamed from: g  reason: collision with root package name */
    public float f51316g;
    /* access modifiers changed from: private */
    public int height = 0;
    private com.instabug.library.invocation.a invocationListener;
    /* access modifiers changed from: private */
    @Nullable
    public FrameLayout.LayoutParams layoutParams;
    /* access modifiers changed from: private */
    public int width;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f51317b;

        public a(Activity activity) {
            this.f51317b = activity;
        }

        public void run() {
            FloatingButtonInvoker.this.showFAB(this.f51317b);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            FloatingButtonInvoker.this.hideFAB();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            if (InstabugStateProvider.getInstance().getState() == InstabugState.ENABLED) {
                FloatingButtonInvoker.this.sleep();
                FrameLayout.LayoutParams unused = FloatingButtonInvoker.this.layoutParams = null;
                FloatingButtonInvoker.this.listen();
                return;
            }
            PoolProvider.postMainThreadTask(new b(this));
        }
    }

    public static class d extends GestureDetector.SimpleOnGestureListener {
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
            return Math.abs(motionEvent2.getX() - motionEvent.getX()) < 90.0f && motionEvent2.getY() - motionEvent.getY() > 90.0f;
        }
    }

    @SuppressLint({"AppCompatCustomView"})
    public class e extends ImageButton {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private GestureDetector f51321a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f51322b = true;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private a f51323c;

        /* renamed from: d  reason: collision with root package name */
        private long f51324d;

        /* renamed from: e  reason: collision with root package name */
        public float f51325e;

        /* renamed from: f  reason: collision with root package name */
        public float f51326f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f51327g = false;

        public e(Context context) {
            super(context);
            this.f51321a = new GestureDetector(context, new d());
            this.f51323c = new a(this, (a) null);
            setId(R.id.instabug_floating_button);
        }

        /* access modifiers changed from: private */
        public void a() {
            int i11;
            int i12;
            float f11;
            int i13;
            if (InvocationManager.getInstance().getCurrentInvocationSettings().getFloatingButtonParams().f51334a == InstabugFloatingButtonEdge.LEFT) {
                FloatingButtonInvoker floatingButtonInvoker = FloatingButtonInvoker.this;
                if (((float) floatingButtonInvoker.f51311b) >= ((float) floatingButtonInvoker.width) / 2.0f) {
                    f11 = (float) ((FloatingButtonInvoker.this.width - FloatingButtonInvoker.this.floatingButtonSize) + 10);
                } else {
                    f11 = -10.0f;
                }
                a aVar = this.f51323c;
                if (aVar != null) {
                    FloatingButtonInvoker floatingButtonInvoker2 = FloatingButtonInvoker.this;
                    if (floatingButtonInvoker2.f51312c > floatingButtonInvoker2.height - FloatingButtonInvoker.this.floatingButtonSize) {
                        i13 = FloatingButtonInvoker.this.height - (FloatingButtonInvoker.this.floatingButtonSize * 2);
                    } else {
                        i13 = FloatingButtonInvoker.this.f51312c;
                    }
                    aVar.a(f11, (float) i13);
                    return;
                }
                return;
            }
            FloatingButtonInvoker floatingButtonInvoker3 = FloatingButtonInvoker.this;
            if (((float) floatingButtonInvoker3.f51311b) >= ((float) floatingButtonInvoker3.width) / 2.0f) {
                i11 = FloatingButtonInvoker.this.width + 10;
            } else {
                i11 = FloatingButtonInvoker.this.floatingButtonSize - 10;
            }
            float f12 = (float) i11;
            a aVar2 = this.f51323c;
            if (aVar2 != null) {
                FloatingButtonInvoker floatingButtonInvoker4 = FloatingButtonInvoker.this;
                if (floatingButtonInvoker4.f51312c > floatingButtonInvoker4.height - FloatingButtonInvoker.this.floatingButtonSize) {
                    i12 = FloatingButtonInvoker.this.height - (FloatingButtonInvoker.this.floatingButtonSize * 2);
                } else {
                    i12 = FloatingButtonInvoker.this.f51312c;
                }
                aVar2.a(f12, (float) i12);
            }
        }

        public void b(float f11, float f12) {
            FloatingButtonInvoker floatingButtonInvoker = FloatingButtonInvoker.this;
            float f13 = ((float) floatingButtonInvoker.f51312c) + f12;
            if (f13 > 50.0f) {
                c((int) (((float) floatingButtonInvoker.f51311b) + f11), (int) f13);
            }
            if (FloatingButtonInvoker.this.layoutParams != null && this.f51322b && !this.f51327g && Math.abs(FloatingButtonInvoker.this.layoutParams.rightMargin) < 50 && Math.abs(FloatingButtonInvoker.this.layoutParams.topMargin - (getContext().getResources().getDisplayMetrics().heightPixels / 2)) < 250) {
                a();
            }
        }

        public void c(int i11, int i12) {
            FloatingButtonInvoker floatingButtonInvoker = FloatingButtonInvoker.this;
            floatingButtonInvoker.f51311b = i11;
            floatingButtonInvoker.f51312c = i12;
            if (floatingButtonInvoker.layoutParams != null) {
                FrameLayout.LayoutParams c11 = FloatingButtonInvoker.this.layoutParams;
                FloatingButtonInvoker floatingButtonInvoker2 = FloatingButtonInvoker.this;
                c11.leftMargin = floatingButtonInvoker2.f51311b;
                FrameLayout.LayoutParams c12 = floatingButtonInvoker2.layoutParams;
                int e11 = FloatingButtonInvoker.this.width;
                FloatingButtonInvoker floatingButtonInvoker3 = FloatingButtonInvoker.this;
                c12.rightMargin = e11 - floatingButtonInvoker3.f51311b;
                if (floatingButtonInvoker3.f51315f == 2 && floatingButtonInvoker3.f51313d > floatingButtonInvoker3.width) {
                    FloatingButtonInvoker.this.layoutParams.rightMargin = (int) (((float) FloatingButtonInvoker.this.layoutParams.rightMargin) + (FloatingButtonInvoker.this.f51316g * 48.0f));
                }
                FrameLayout.LayoutParams c13 = FloatingButtonInvoker.this.layoutParams;
                FloatingButtonInvoker floatingButtonInvoker4 = FloatingButtonInvoker.this;
                c13.topMargin = floatingButtonInvoker4.f51312c;
                FrameLayout.LayoutParams c14 = floatingButtonInvoker4.layoutParams;
                int g11 = FloatingButtonInvoker.this.height;
                FloatingButtonInvoker floatingButtonInvoker5 = FloatingButtonInvoker.this;
                c14.bottomMargin = g11 - floatingButtonInvoker5.f51312c;
                setLayoutParams(floatingButtonInvoker5.layoutParams);
            }
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z11;
            GestureDetector gestureDetector;
            if (!this.f51322b || (gestureDetector = this.f51321a) == null) {
                z11 = false;
            } else {
                z11 = gestureDetector.onTouchEvent(motionEvent);
            }
            if (z11) {
                a();
            } else {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.f51324d = System.currentTimeMillis();
                    a aVar = this.f51323c;
                    if (aVar != null) {
                        aVar.a();
                    }
                    this.f51327g = true;
                } else if (action == 1) {
                    if (System.currentTimeMillis() - this.f51324d < 200) {
                        performClick();
                    }
                    this.f51327g = false;
                    a();
                } else if (action == 2 && this.f51327g) {
                    b(rawX - this.f51325e, rawY - this.f51326f);
                }
                this.f51325e = rawX;
                this.f51326f = rawY;
            }
            return true;
        }

        public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            FrameLayout.LayoutParams unused = FloatingButtonInvoker.this.layoutParams = (FrameLayout.LayoutParams) layoutParams;
            super.setLayoutParams(layoutParams);
        }

        public class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            private Handler f51329a;

            /* renamed from: b  reason: collision with root package name */
            private float f51330b;

            /* renamed from: c  reason: collision with root package name */
            private float f51331c;

            /* renamed from: d  reason: collision with root package name */
            private long f51332d;

            private a() {
                this.f51329a = new Handler(Looper.getMainLooper());
            }

            /* access modifiers changed from: private */
            public void a(float f11, float f12) {
                this.f51330b = f11;
                this.f51331c = f12;
                this.f51332d = System.currentTimeMillis();
                this.f51329a.post(this);
            }

            public void run() {
                if (e.this.getParent() != null) {
                    float min = Math.min(1.0f, ((float) (System.currentTimeMillis() - this.f51332d)) / 400.0f);
                    float f11 = this.f51330b;
                    e eVar = e.this;
                    FloatingButtonInvoker floatingButtonInvoker = FloatingButtonInvoker.this;
                    float f12 = (float) floatingButtonInvoker.f51311b;
                    float f13 = this.f51331c;
                    float f14 = (float) floatingButtonInvoker.f51312c;
                    eVar.c((int) (f12 + ((f11 - f12) * min)), (int) (f14 + ((f13 - f14) * min)));
                    if (min < 1.0f) {
                        this.f51329a.post(this);
                    }
                }
            }

            public /* synthetic */ a(e eVar, a aVar) {
                this();
            }

            /* access modifiers changed from: private */
            public void a() {
                this.f51329a.removeCallbacks(this);
            }
        }
    }

    public static class f extends FrameLayout {
        public f(Context context) {
            super(context);
        }
    }

    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public InstabugFloatingButtonEdge f51334a = InstabugFloatingButtonEdge.RIGHT;

        /* renamed from: b  reason: collision with root package name */
        public int f51335b = 250;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public FloatingButtonInvoker(com.instabug.library.invocation.a aVar) {
        this.invocationListener = aVar;
    }

    /* access modifiers changed from: private */
    @MainThread
    public void hideFAB() {
        f fVar;
        WeakReference<f> weakReference = this.floatingButtonFrameLayoutWeakReference;
        if (weakReference != null && (fVar = weakReference.get()) != null) {
            fVar.removeAllViews();
            this.floatingButtonWeakReference = null;
            if (fVar.getParent() != null && (fVar.getParent() instanceof ViewGroup)) {
                ((ViewGroup) fVar.getParent()).removeView(fVar);
                this.floatingButtonFrameLayoutWeakReference = null;
            }
        }
    }

    /* access modifiers changed from: private */
    @MainThread
    public void showFAB(Activity activity) {
        hideFAB();
        f fVar = new f(activity);
        this.f51315f = activity.getResources().getConfiguration().orientation;
        fVar.setId(R.id.instabug_fab_container);
        this.f51316g = activity.getResources().getDisplayMetrics().density;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        int i11 = this.width;
        int i12 = this.height;
        this.height = activity.getResources().getDisplayMetrics().heightPixels;
        this.width = activity.getResources().getDisplayMetrics().widthPixels;
        activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        this.f51314e = displayMetrics.heightPixels;
        this.f51313d = displayMetrics.widthPixels;
        this.floatingButtonSize = (int) (this.f51316g * 56.0f);
        e eVar = new e(activity);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(new OvalShape());
        shapeDrawable2.getPaint().setColor(InstabugCore.getPrimaryColor());
        shapeDrawable.getPaint().setColor(InstabugCore.getPrimaryColor());
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable2, shapeDrawable});
        LayerDrawable layerDrawable2 = layerDrawable;
        layerDrawable2.setLayerInset(0, 0, 0, 0, 0);
        layerDrawable2.setLayerInset(1, 2, 2, 2, 2);
        eVar.setBackgroundDrawable(layerDrawable);
        eVar.setImageDrawable(activity.getResources().getDrawable(R.drawable.ibg_core_ic_floating_btn));
        eVar.setScaleType(ImageView.ScaleType.CENTER);
        eVar.setContentDescription(" ");
        if (this.layoutParams != null) {
            float f11 = ((float) (this.f51311b * this.width)) / ((float) i11);
            float f12 = ((float) (this.f51312c * this.height)) / ((float) i12);
            this.f51311b = Math.round(f11);
            int round = Math.round(f12);
            this.f51312c = round;
            FrameLayout.LayoutParams layoutParams2 = this.layoutParams;
            int i13 = this.f51311b;
            layoutParams2.leftMargin = i13;
            layoutParams2.rightMargin = this.width - i13;
            layoutParams2.topMargin = round;
            layoutParams2.bottomMargin = this.height - round;
            eVar.setLayoutParams(layoutParams2);
            eVar.a();
        } else if (InvocationManager.getInstance().getCurrentInvocationSettings().getFloatingButtonParams().f51334a == InstabugFloatingButtonEdge.LEFT) {
            int i14 = this.floatingButtonSize;
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(i14, i14, 51);
            this.layoutParams = layoutParams3;
            eVar.setLayoutParams(layoutParams3);
            eVar.c(-10, InvocationManager.getInstance().getCurrentInvocationSettings().getFloatingButtonParams().f51335b);
        } else {
            int i15 = this.floatingButtonSize;
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(i15, i15, 53);
            this.layoutParams = layoutParams4;
            eVar.setLayoutParams(layoutParams4);
            eVar.c(this.width + 10, InvocationManager.getInstance().getCurrentInvocationSettings().getFloatingButtonParams().f51335b);
        }
        eVar.setOnClickListener(this);
        eVar.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        fVar.addView(eVar);
        ((FrameLayout) activity.getWindow().getDecorView()).addView(fVar, new ViewGroup.LayoutParams(-1, -1));
        this.floatingButtonFrameLayoutWeakReference = new WeakReference<>(fVar);
        this.floatingButtonWeakReference = new WeakReference<>(eVar);
    }

    public Rect getButtonBounds() {
        WeakReference<e> weakReference = this.floatingButtonWeakReference;
        if (weakReference == null) {
            return new Rect();
        }
        e eVar = weakReference.get();
        if (eVar != null) {
            float f11 = eVar.f51325e;
            if (f11 != 0.0f) {
                float f12 = eVar.f51326f;
                if (f12 != 0.0f) {
                    return new Rect((int) f11, (int) f12, (int) (((float) eVar.getWidth()) + f11), (int) (eVar.f51326f + ((float) eVar.getHeight())));
                }
            }
        }
        return new Rect();
    }

    public void handle(Void voidR) {
    }

    public boolean isActive() {
        Activity currentActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
        if (currentActivity == null || currentActivity.getWindow().findViewById(R.id.instabug_fab_container) == null) {
            return false;
        }
        return true;
    }

    public void listen() {
        Activity currentRealActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentRealActivity();
        if (currentRealActivity != null && !(currentRealActivity instanceof _InstabugActivity) && !currentRealActivity.getClass().getName().contains("PlayCoreDialogWrapperActivity")) {
            PoolProvider.postMainThreadTask(new a(currentRealActivity));
        }
    }

    public void onClick(View view) {
        hideFAB();
        this.invocationListener.a();
        InvocationManager.getInstance().setLastUsedInvoker(this);
    }

    public void sleep() {
        PoolProvider.postMainThreadTask(new b());
    }

    public void updateButtonLocation() {
        PoolProvider.postMainThreadTask(new c());
    }
}
