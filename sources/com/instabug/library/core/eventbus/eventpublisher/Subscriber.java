package com.instabug.library.core.eventbus.eventpublisher;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public interface Subscriber<T> {

    public static final class DefaultImpls {
        public static <T> void onError(@NotNull Subscriber<T> subscriber, @NotNull Throwable th2) {
            Intrinsics.checkNotNullParameter(subscriber, "this");
            Intrinsics.checkNotNullParameter(th2, "throwable");
        }
    }

    void onError(@NotNull Throwable th2);

    void onNewEvent(T t11);
}
