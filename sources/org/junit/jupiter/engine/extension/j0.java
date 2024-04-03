package org.junit.jupiter.engine.extension;

import j$.util.function.Consumer;
import org.junit.jupiter.api.extension.ExtensionContext;

public final /* synthetic */ class j0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f62604b;

    public /* synthetic */ j0(ExtensionContext extensionContext) {
        this.f62604b = extensionContext;
    }

    public final void accept(Object obj) {
        this.f62604b.getStore(TimeoutExtension.NAMESPACE).put(TimeoutExtension.TESTABLE_METHOD_TIMEOUT_KEY, (TimeoutDuration) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
