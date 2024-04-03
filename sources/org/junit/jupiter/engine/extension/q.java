package org.junit.jupiter.engine.extension;

import j$.util.function.Function;

public final /* synthetic */ class q implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TimeoutConfiguration f62612a;

    public /* synthetic */ q(TimeoutConfiguration timeoutConfiguration) {
        this.f62612a = timeoutConfiguration;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f62612a.lambda$parseTimeoutDuration$2((String) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
