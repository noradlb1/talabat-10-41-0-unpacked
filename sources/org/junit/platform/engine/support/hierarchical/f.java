package org.junit.platform.engine.support.hierarchical;

import j$.util.function.Function;
import org.junit.platform.engine.support.hierarchical.DefaultParallelExecutionConfigurationStrategy;

public final /* synthetic */ class f implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f28080a;

    public /* synthetic */ f(String str) {
        this.f28080a = str;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return DefaultParallelExecutionConfigurationStrategy.AnonymousClass3.lambda$createConfiguration$3(this.f28080a, (Exception) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
