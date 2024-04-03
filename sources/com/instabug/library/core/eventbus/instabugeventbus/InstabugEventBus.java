package com.instabug.library.core.eventbus.instabugeventbus;

import com.instabug.library.core.eventbus.eventpublisher.EventPublisher;
import com.instabug.library.core.eventbus.eventpublisher.Subscriber;
import com.instabug.library.core.eventbus.eventpublisher.Unsubscribable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public abstract class InstabugEventBus<T> {
    @NotNull
    private final EventPublisher<T> eventPublisher = new EventBusEventPublisher();

    public final <E extends T> void post(E e11) {
        this.eventPublisher.post(e11);
    }

    @NotNull
    public final Unsubscribable subscribe(@NotNull Subscriber<T> subscriber) {
        Intrinsics.checkNotNullParameter(subscriber, "subscriber");
        return this.eventPublisher.subscribe(subscriber);
    }

    @NotNull
    public final Unsubscribable subscribe(@NotNull EventBusSubscriber<? super T> eventBusSubscriber) {
        Intrinsics.checkNotNullParameter(eventBusSubscriber, "subscriber");
        return this.eventPublisher.subscribe(new InstabugEventBus$subscribe$1(eventBusSubscriber));
    }
}
