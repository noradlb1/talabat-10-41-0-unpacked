package f7;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WorkInitializer f34465b;

    public /* synthetic */ o(WorkInitializer workInitializer) {
        this.f34465b = workInitializer;
    }

    public final void run() {
        this.f34465b.lambda$ensureContextsScheduled$1();
    }
}
