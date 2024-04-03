package wc;

import com.instabug.library.diagnostics.customtraces.IBGPendingTraceHandler;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IBGPendingTraceHandler f34775b;

    public /* synthetic */ a(IBGPendingTraceHandler iBGPendingTraceHandler) {
        this.f34775b = iBGPendingTraceHandler;
    }

    public final void run() {
        IBGPendingTraceHandler.m9024flushTraces$lambda2(this.f34775b);
    }
}
