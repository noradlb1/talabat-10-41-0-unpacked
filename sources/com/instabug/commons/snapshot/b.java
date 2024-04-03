package com.instabug.commons.snapshot;

import com.instabug.library.util.threading.DefensiveRunnableKt;

public final class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f46341b;

    public b(d dVar) {
        this.f46341b = dVar;
    }

    public final void run() {
        try {
            this.f46341b.c();
        } catch (Throwable th2) {
            th = th2;
            DefensiveRunnableKt.defensiveLog$default(th, (String) null, 2, (Object) null);
            if (!(th instanceof OutOfMemoryError)) {
                th = null;
            }
            if (th != null) {
                DefensiveRunnableKt.reportOOM(th);
            }
        }
    }
}
