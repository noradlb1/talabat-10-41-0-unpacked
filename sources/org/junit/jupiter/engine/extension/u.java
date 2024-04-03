package org.junit.jupiter.engine.extension;

import j$.util.function.Function;

public final /* synthetic */ class u implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TimeoutConfiguration f62615a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f62616b;

    public /* synthetic */ u(TimeoutConfiguration timeoutConfiguration, String str) {
        this.f62615a = timeoutConfiguration;
        this.f62616b = str;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f62615a.lambda$parseTimeoutDuration$1(this.f62616b, (String) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
