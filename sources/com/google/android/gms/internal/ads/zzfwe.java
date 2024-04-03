package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

enum zzfwe implements Executor {
    INSTANCE;

    public final void execute(Runnable runnable) {
        runnable.run();
    }

    public final String toString() {
        return "MoreExecutors.directExecutor()";
    }
}
