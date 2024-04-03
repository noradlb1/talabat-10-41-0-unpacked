package com.deliveryhero.performance.core.tapresponse;

import android.view.Choreographer;
import android.view.View;
import com.deliveryhero.performance.core.screenmetric.ScreenMetricParent;

public final /* synthetic */ class a implements Choreographer.FrameCallback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f30383b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ScreenMetricParent.Builder f30384c;

    public /* synthetic */ a(View view, ScreenMetricParent.Builder builder) {
        this.f30383b = view;
        this.f30384c = builder;
    }

    public final void doFrame(long j11) {
        ActionTracker$reportScreenStartMetrics$1.m8237invoke$lambda0(this.f30383b, this.f30384c, j11);
    }
}
