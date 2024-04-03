package com.instabug.library.core.eventbus;

import com.instabug.library.tracking.ActivityLifeCycleEvent;

public class CurrentActivityLifeCycleEventBus extends EventBus<ActivityLifeCycleEvent> {
    private static CurrentActivityLifeCycleEventBus instance;

    public static synchronized CurrentActivityLifeCycleEventBus getInstance() {
        CurrentActivityLifeCycleEventBus currentActivityLifeCycleEventBus;
        synchronized (CurrentActivityLifeCycleEventBus.class) {
            if (instance == null) {
                instance = new CurrentActivityLifeCycleEventBus();
            }
            currentActivityLifeCycleEventBus = instance;
        }
        return currentActivityLifeCycleEventBus;
    }
}
