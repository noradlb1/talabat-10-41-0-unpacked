package com.instabug.library.usersteps;

import android.view.ScaleGestureDetector;
import com.instabug.library.model.StepType;

class f extends ScaleGestureDetector.SimpleOnScaleGestureListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f52006b;

    private f(g gVar) {
        this.f52006b = gVar;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        this.f52006b.d(StepType.PINCH, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
        return true;
    }

    public /* synthetic */ f(g gVar, a aVar) {
        this(gVar);
    }
}
