package com.talabat.designhelpers.UnifiedTracking;

import android.os.Handler;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.talabat.maps.domain.LatLngFactory;
import com.talabat.maps.domain.model.LatLng;
import com.talabat.maps.domain.model.Marker;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006\u0013"}, d2 = {"com/talabat/designhelpers/UnifiedTracking/MarkerAnimation$animateMarkerToGB$1", "Ljava/lang/Runnable;", "elapsed", "", "getElapsed", "()J", "setElapsed", "(J)V", "t", "", "getT", "()F", "setT", "(F)V", "v", "getV", "setV", "run", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MarkerAnimation$animateMarkerToGB$1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f58268b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f58269c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AccelerateDecelerateInterpolator f58270d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Marker f58271e;
    private long elapsed;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ LatLngInterpolator f58272f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LatLng f58273g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ LatLng f58274h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LatLngFactory f58275i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Handler f58276j;

    /* renamed from: t  reason: collision with root package name */
    private float f58277t;

    /* renamed from: v  reason: collision with root package name */
    private float f58278v;

    public MarkerAnimation$animateMarkerToGB$1(long j11, float f11, AccelerateDecelerateInterpolator accelerateDecelerateInterpolator, Marker marker, LatLngInterpolator latLngInterpolator, LatLng latLng, LatLng latLng2, LatLngFactory latLngFactory, Handler handler) {
        this.f58268b = j11;
        this.f58269c = f11;
        this.f58270d = accelerateDecelerateInterpolator;
        this.f58271e = marker;
        this.f58272f = latLngInterpolator;
        this.f58273g = latLng;
        this.f58274h = latLng2;
        this.f58275i = latLngFactory;
        this.f58276j = handler;
    }

    public final long getElapsed() {
        return this.elapsed;
    }

    public final float getT() {
        return this.f58277t;
    }

    public final float getV() {
        return this.f58278v;
    }

    public void run() {
        long uptimeMillis = SystemClock.uptimeMillis() - this.f58268b;
        this.elapsed = uptimeMillis;
        float f11 = ((float) uptimeMillis) / this.f58269c;
        this.f58277t = f11;
        float interpolation = this.f58270d.getInterpolation(f11);
        this.f58278v = interpolation;
        this.f58271e.setPosition(this.f58272f.interpolate(interpolation, this.f58273g, this.f58274h, this.f58275i));
        if (this.f58277t < 1.0f) {
            this.f58276j.postDelayed(this, 16);
        }
    }

    public final void setElapsed(long j11) {
        this.elapsed = j11;
    }

    public final void setT(float f11) {
        this.f58277t = f11;
    }

    public final void setV(float f11) {
        this.f58278v = f11;
    }
}
