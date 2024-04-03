package org.junit.platform.engine;

import j$.util.function.Function;
import org.junit.platform.engine.UniqueId;

public final /* synthetic */ class g implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UniqueIdFormat f28051a;

    public /* synthetic */ g(UniqueIdFormat uniqueIdFormat) {
        this.f28051a = uniqueIdFormat;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f28051a.describe((UniqueId.Segment) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
