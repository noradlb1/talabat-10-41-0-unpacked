package com.instabug.library.core.eventbus;

public class OnSessionCrashedEventBus extends EventBus<NDKSessionCrashedEvent> {
    private static OnSessionCrashedEventBus onSessionCrashedEventBus;

    private OnSessionCrashedEventBus() {
    }

    public static synchronized OnSessionCrashedEventBus getInstance() {
        OnSessionCrashedEventBus onSessionCrashedEventBus2;
        synchronized (OnSessionCrashedEventBus.class) {
            if (onSessionCrashedEventBus == null) {
                onSessionCrashedEventBus = new OnSessionCrashedEventBus();
            }
            onSessionCrashedEventBus2 = onSessionCrashedEventBus;
        }
        return onSessionCrashedEventBus2;
    }
}
