package com.instabug.library.core.eventbus.instabugeventbus;

public interface EventBusSubscriber<T> {
    void onNewEvent(T t11);
}
