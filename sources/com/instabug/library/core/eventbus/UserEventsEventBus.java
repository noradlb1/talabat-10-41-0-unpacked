package com.instabug.library.core.eventbus;

import com.instabug.library.user.UserEvent;

public class UserEventsEventBus extends EventBus<UserEvent> {
    private static UserEventsEventBus instance;

    public static synchronized UserEventsEventBus getInstance() {
        UserEventsEventBus userEventsEventBus;
        synchronized (UserEventsEventBus.class) {
            if (instance == null) {
                instance = new UserEventsEventBus();
            }
            userEventsEventBus = instance;
        }
        return userEventsEventBus;
    }
}
