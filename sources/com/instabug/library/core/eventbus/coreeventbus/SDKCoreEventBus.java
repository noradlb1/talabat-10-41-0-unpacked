package com.instabug.library.core.eventbus.coreeventbus;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.core.eventbus.EventBus;

public class SDKCoreEventBus extends EventBus<SDKCoreEvent> {
    @Nullable
    private static SDKCoreEventBus instance;

    public static synchronized SDKCoreEventBus c() {
        SDKCoreEventBus sDKCoreEventBus;
        synchronized (SDKCoreEventBus.class) {
            if (instance == null) {
                instance = new SDKCoreEventBus();
            }
            sDKCoreEventBus = instance;
        }
        return sDKCoreEventBus;
    }

    @VisibleForTesting
    public static void reset() {
        instance = null;
    }
}
