package com.instabug.survey.ui.gestures;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.instabug.library.Instabug;
import com.instabug.library.internal.device.InstabugDeviceProperties;

public final class b extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a  reason: collision with root package name */
    private final a f52513a;

    public b(a aVar) {
        this.f52513a = aVar;
    }

    private float a() {
        return (Instabug.getApplicationContext() != null && InstabugDeviceProperties.isTablet(Instabug.getApplicationContext())) ? 3000.0f : 6000.0f;
    }

    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
        try {
            float y11 = motionEvent2.getY() - motionEvent.getY();
            float x11 = motionEvent2.getX() - motionEvent.getX();
            if (Math.abs(x11) > Math.abs(y11)) {
                if (Math.abs(x11) > 300.0f && Math.abs(f11) > 800.0f) {
                    if (x11 > 0.0f) {
                        this.f52513a.d();
                    } else {
                        this.f52513a.g();
                    }
                }
                return false;
            }
            if (Math.abs(y11) > 300.0f && Math.abs(f12) > 800.0f) {
                if (y11 > 0.0f) {
                    if (Math.abs(f12) > a()) {
                        this.f52513a.c();
                    }
                } else if (Math.abs(f12) > a()) {
                    this.f52513a.f();
                }
            }
            return false;
            return true;
        } catch (Exception unused) {
        }
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        this.f52513a.b();
        return super.onSingleTapConfirmed(motionEvent);
    }
}
