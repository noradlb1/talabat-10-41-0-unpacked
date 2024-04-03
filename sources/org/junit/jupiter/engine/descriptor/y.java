package org.junit.jupiter.engine.descriptor;

import j$.util.function.Consumer;
import java.lang.reflect.Method;

public final /* synthetic */ class y implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f62484b;

    public /* synthetic */ y(Class cls) {
        this.f62484b = cls;
    }

    public final void accept(Object obj) {
        LifecycleMethodUtils.assertNonPrivate(this.f62484b, (Method) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
