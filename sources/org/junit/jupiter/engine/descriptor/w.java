package org.junit.jupiter.engine.descriptor;

import j$.util.function.Consumer;
import java.lang.reflect.Method;

public final /* synthetic */ class w implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f62482b;

    public /* synthetic */ w(Class cls) {
        this.f62482b = cls;
    }

    public final void accept(Object obj) {
        LifecycleMethodUtils.assertVoid(this.f62482b, (Method) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
