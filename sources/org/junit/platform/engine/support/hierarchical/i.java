package org.junit.platform.engine.support.hierarchical;

import j$.util.function.Function;

public final /* synthetic */ class i implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LockManager f28088a;

    public /* synthetic */ i(LockManager lockManager) {
        this.f28088a = lockManager;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f28088a.toLock((ExclusiveResource) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
