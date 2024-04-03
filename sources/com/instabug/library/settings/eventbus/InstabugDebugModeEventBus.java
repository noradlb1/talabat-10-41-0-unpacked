package com.instabug.library.settings.eventbus;

import com.instabug.library.core.eventbus.EventBus;

public class InstabugDebugModeEventBus extends EventBus<Boolean> {
    private static InstabugDebugModeEventBus instance;

    private InstabugDebugModeEventBus() {
    }

    public static synchronized InstabugDebugModeEventBus getInstance() {
        InstabugDebugModeEventBus instabugDebugModeEventBus;
        synchronized (InstabugDebugModeEventBus.class) {
            if (instance == null) {
                instance = new InstabugDebugModeEventBus();
            }
            instabugDebugModeEventBus = instance;
        }
        return instabugDebugModeEventBus;
    }
}
