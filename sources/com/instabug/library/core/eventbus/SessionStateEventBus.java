package com.instabug.library.core.eventbus;

import com.instabug.library.model.session.SessionState;

public class SessionStateEventBus extends EventBus<SessionState> {
    private static SessionStateEventBus instance;

    public static synchronized SessionStateEventBus getInstance() {
        SessionStateEventBus sessionStateEventBus;
        synchronized (SessionStateEventBus.class) {
            if (instance == null) {
                instance = new SessionStateEventBus();
            }
            sessionStateEventBus = instance;
        }
        return sessionStateEventBus;
    }
}
