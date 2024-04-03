package com.instabug.library.invocation.invoker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.core.view.GestureDetectorCompat;
import com.instabug.library.invocation.InvocationManager;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;

public class x implements a {
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public GestureDetectorCompat f51407a;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public a f51408b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Context f51409c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f51410d = false;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public com.instabug.library.invocation.a f51411e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f51412f;

    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
            if (x.this.a(motionEvent, motionEvent2) && x.this.f51410d) {
                InstabugSDKLogger.d("IBG-Core", "Two fingers swiped left, invoking SDK");
                InvocationManager.getInstance().setLastUsedInvoker(x.this);
                x.this.f51411e.a();
            }
            boolean unused = x.this.f51410d = false;
            return false;
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public x(Context context, com.instabug.library.invocation.a aVar) {
        this.f51409c = context;
        this.f51411e = aVar;
    }

    public boolean isActive() {
        return this.f51412f;
    }

    public synchronized void listen() {
        PoolProvider.postMainThreadTask(new w(this));
    }

    public synchronized void sleep() {
        this.f51408b = null;
        this.f51407a = null;
        this.f51412f = false;
    }

    /* renamed from: a */
    public synchronized void handle(MotionEvent motionEvent) {
        if (this.f51407a != null) {
            if ((motionEvent.getAction() & 255) == 2) {
                if (motionEvent.getPointerCount() >= 2) {
                    this.f51410d = true;
                } else {
                    return;
                }
            }
            this.f51407a.onTouchEvent(motionEvent);
        }
    }

    /* access modifiers changed from: private */
    public boolean a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        return motionEvent != null && motionEvent2 != null && motionEvent.getX() > motionEvent2.getX() && motionEvent.getX() - motionEvent2.getX() >= Math.abs(motionEvent.getY() - motionEvent2.getY());
    }
}
