package com.instabug.library.core.eventbus;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.InstabugState;

public class InstabugStateEventBus extends EventBus<InstabugState> {
    @Nullable
    private static InstabugStateEventBus instabugStateEventBus;

    private InstabugStateEventBus() {
    }

    public static synchronized InstabugStateEventBus getInstance() {
        InstabugStateEventBus instabugStateEventBus2;
        synchronized (InstabugStateEventBus.class) {
            if (instabugStateEventBus == null) {
                instabugStateEventBus = new InstabugStateEventBus();
            }
            instabugStateEventBus2 = instabugStateEventBus;
        }
        return instabugStateEventBus2;
    }

    @VisibleForTesting
    public static synchronized void reset() {
        synchronized (InstabugStateEventBus.class) {
            instabugStateEventBus = null;
        }
    }
}
