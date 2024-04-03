package com.apptimize;

import java.util.concurrent.ExecutorService;

public class ev {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f42350a = "ev";

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f42351b;

    public ev(ExecutorService executorService) {
        this.f42351b = executorService;
    }

    public void a(final fi fiVar) {
        this.f42351b.submit(new fi() {
            public void run() {
                fe.a(ev.f42350a, (fi) new fi() {
                    public void run() {
                        fiVar.run();
                    }
                }, "Unexpected exception in background thread: ");
            }
        });
    }
}
