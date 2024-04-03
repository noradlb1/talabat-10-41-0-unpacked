package com.instabug.library.core;

import com.instabug.library.core.eventbus.EventBus;
import com.instabug.library.tracking.FragmentLifeCycleEvent;

public class CurrentFragmentLifeCycleEventBus extends EventBus<FragmentLifeCycleEvent> {
    private static CurrentFragmentLifeCycleEventBus instance;

    public static synchronized CurrentFragmentLifeCycleEventBus getInstance() {
        CurrentFragmentLifeCycleEventBus currentFragmentLifeCycleEventBus;
        synchronized (CurrentFragmentLifeCycleEventBus.class) {
            if (instance == null) {
                instance = new CurrentFragmentLifeCycleEventBus();
            }
            currentFragmentLifeCycleEventBus = instance;
        }
        return currentFragmentLifeCycleEventBus;
    }
}
