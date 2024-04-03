package org.junit.jupiter.engine.extension;

import j$.util.function.Consumer;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtensionContext;

public final /* synthetic */ class k0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f62607b;

    public /* synthetic */ k0(ExtensionContext extensionContext) {
        this.f62607b = extensionContext;
    }

    public final void accept(Object obj) {
        this.f62607b.getStore(TimeoutExtension.NAMESPACE).put(TimeoutExtension.TESTABLE_METHOD_TIMEOUT_THREAD_MODE_KEY, (Timeout.ThreadMode) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
