package com.instabug.library.util.threading;

public final class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Runnable f52101b;

    public a(Runnable runnable) {
        this.f52101b = runnable;
    }

    public final void run() {
        try {
            Runnable runnable = this.f52101b;
            if (runnable != null) {
                runnable.run();
            }
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
