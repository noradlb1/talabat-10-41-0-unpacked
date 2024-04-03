package com.instabug.apm.uitrace;

import android.view.Choreographer;
import androidx.annotation.RequiresApi;
import com.instabug.apm.di.a;
import com.instabug.apm.handler.uitrace.c;
import com.instabug.library.core.InstabugCore;
import java.util.concurrent.TimeUnit;

@RequiresApi(api = 16)
public class b implements a, Choreographer.FrameCallback {

    /* renamed from: a  reason: collision with root package name */
    private Choreographer f45582a;

    /* renamed from: b  reason: collision with root package name */
    private long f45583b = -1;

    /* renamed from: c  reason: collision with root package name */
    private c f45584c;

    /* renamed from: d  reason: collision with root package name */
    private float f45585d;

    public b(c cVar, float f11) {
        this.f45584c = cVar;
        this.f45585d = f11;
        this.f45582a = Choreographer.getInstance();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(boolean z11, long j11) {
        try {
            c cVar = this.f45584c;
            if (cVar != null && z11 && ((float) j11) > this.f45585d) {
                cVar.a(j11);
            }
        } catch (Exception e11) {
            InstabugCore.reportError(e11, "couldn't call callback.onFrameDrop¬");
        }
    }

    public void a() {
        this.f45583b = -1;
        this.f45582a.postFrameCallback(this);
    }

    public void b() {
        this.f45582a.removeFrameCallback(this);
    }

    public void doFrame(long j11) {
        try {
            a.q().execute(new wb.a(this, this.f45583b > 0, TimeUnit.NANOSECONDS.toMicros(j11 - this.f45583b)));
            this.f45583b = j11;
        } catch (Throwable th2) {
            this.f45582a.postFrameCallback(this);
            throw th2;
        }
        this.f45582a.postFrameCallback(this);
    }
}
