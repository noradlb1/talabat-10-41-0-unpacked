package com.instabug.library.usersteps;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import com.instabug.library.model.StepType;
import com.instabug.library.visualusersteps.y;

class e extends GestureDetector.SimpleOnGestureListener {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private MotionEvent f52004a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f52005b;

    private e(g gVar) {
        this.f52005b = gVar;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.f52005b.f52019l) {
            return false;
        }
        y.d().k();
        this.f52005b.a(StepType.DOUBLE_TAP, motionEvent);
        boolean unused = this.f52005b.f52019l = true;
        return false;
    }

    public boolean onDown(MotionEvent motionEvent) {
        this.f52004a = motionEvent;
        return super.onDown(motionEvent);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
        if (motionEvent2 == null) {
            motionEvent2 = this.f52004a;
        }
        this.f52005b.a(StepType.FLING, motionEvent2);
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
        if (!this.f52005b.f52018k) {
            this.f52005b.a(StepType.LONG_PRESS, motionEvent);
            boolean unused = this.f52005b.f52018k = true;
        }
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    public /* synthetic */ e(g gVar, a aVar) {
        this(gVar);
    }
}
