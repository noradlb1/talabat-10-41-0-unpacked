package org.junit.jupiter.engine.discovery;

import j$.util.function.Function;
import java.lang.reflect.Method;
import java.util.List;
import org.junit.jupiter.engine.discovery.MethodSelectorResolver;
import org.junit.platform.engine.support.discovery.SelectorResolver;

public final /* synthetic */ class n0 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodSelectorResolver f62521a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f62522b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Class f62523c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Method f62524d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ SelectorResolver.Context f62525e;

    public /* synthetic */ n0(MethodSelectorResolver methodSelectorResolver, List list, Class cls, Method method, SelectorResolver.Context context) {
        this.f62521a = methodSelectorResolver;
        this.f62522b = list;
        this.f62523c = cls;
        this.f62524d = method;
        this.f62525e = context;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f62521a.lambda$resolve$0(this.f62522b, this.f62523c, this.f62524d, this.f62525e, (MethodSelectorResolver.MethodType) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
