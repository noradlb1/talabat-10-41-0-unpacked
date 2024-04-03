package org.junit.jupiter.engine.descriptor;

import j$.util.function.Consumer;
import java.lang.reflect.Method;

public final /* synthetic */ class x implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f62483b;

    public /* synthetic */ x(Class cls) {
        this.f62483b = cls;
    }

    public final void accept(Object obj) {
        LifecycleMethodUtils.assertStatic(this.f62483b, (Method) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
