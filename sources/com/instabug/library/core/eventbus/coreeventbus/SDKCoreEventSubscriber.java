package com.instabug.library.core.eventbus.coreeventbus;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class SDKCoreEventSubscriber {
    public static Observable<SDKCoreEvent> getObservable() {
        return SDKCoreEventBus.c().observeEvents(SDKCoreEvent.class);
    }

    public static Disposable subscribe(Consumer<SDKCoreEvent> consumer) {
        return SDKCoreEventBus.c().subscribe(consumer);
    }
}
