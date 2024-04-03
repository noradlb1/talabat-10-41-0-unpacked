package org.junit.jupiter.engine.extension;

import j$.util.function.Function;

public final /* synthetic */ class a0 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TimeoutExtension f62586a;

    public /* synthetic */ a0(TimeoutExtension timeoutExtension) {
        this.f62586a = timeoutExtension;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return Boolean.valueOf(this.f62586a.isTimeoutDisabled((String) obj));
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
