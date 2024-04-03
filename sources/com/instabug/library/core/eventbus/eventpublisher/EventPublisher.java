package com.instabug.library.core.eventbus.eventpublisher;

import org.jetbrains.annotations.NotNull;

public interface EventPublisher<T> {
    void post(T t11);

    void postError(@NotNull Throwable th2);

    @NotNull
    Unsubscribable subscribe(@NotNull Subscriber<T> subscriber);
}
