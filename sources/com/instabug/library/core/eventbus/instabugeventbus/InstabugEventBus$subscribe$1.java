package com.instabug.library.core.eventbus.instabugeventbus;

import com.instabug.library.core.eventbus.eventpublisher.Subscriber;
import com.instabug.library.util.InstabugSDKLogger;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class InstabugEventBus$subscribe$1 implements Subscriber<T> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EventBusSubscriber<T> f34195a;

    public InstabugEventBus$subscribe$1(EventBusSubscriber<? super T> eventBusSubscriber) {
        this.f34195a = eventBusSubscriber;
    }

    public void onError(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "throwable");
        InstabugSDKLogger.e("IBG-Core", Intrinsics.stringPlus("Error while receiving event: ", th2.getMessage()), th2);
    }

    public void onNewEvent(T t11) {
        this.f34195a.onNewEvent(t11);
    }
}
