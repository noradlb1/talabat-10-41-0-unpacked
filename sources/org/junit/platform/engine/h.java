package org.junit.platform.engine;

import j$.util.function.Function;

public final /* synthetic */ class h implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UniqueIdFormat f28052a;

    public /* synthetic */ h(UniqueIdFormat uniqueIdFormat) {
        this.f28052a = uniqueIdFormat;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f28052a.createSegment((String) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
