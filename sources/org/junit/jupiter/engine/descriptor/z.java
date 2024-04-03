package org.junit.jupiter.engine.descriptor;

import j$.util.function.Consumer;
import java.lang.reflect.Method;

public final /* synthetic */ class z implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f62485b;

    public /* synthetic */ z(Class cls) {
        this.f62485b = cls;
    }

    public final void accept(Object obj) {
        LifecycleMethodUtils.lambda$findMethodsAndAssertNonStaticAndNonPrivate$2(this.f62485b, (Method) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
