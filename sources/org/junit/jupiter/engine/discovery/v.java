package org.junit.jupiter.engine.discovery;

import j$.util.function.Function;
import java.util.List;
import org.junit.platform.engine.discovery.DiscoverySelectors;

public final /* synthetic */ class v implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f62555a;

    public /* synthetic */ v(List list) {
        this.f62555a = list;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return DiscoverySelectors.selectNestedClass((List<Class<?>>) this.f62555a, (Class<?>) (Class) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
