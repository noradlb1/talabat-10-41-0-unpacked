package org.junit.jupiter.engine.discovery;

import j$.util.function.Function;
import org.junit.jupiter.engine.discovery.MethodSelectorResolver;
import org.junit.platform.engine.UniqueId;
import org.junit.platform.engine.support.discovery.SelectorResolver;

public final /* synthetic */ class q0 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodSelectorResolver f62535a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UniqueId f62536b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SelectorResolver.Context f62537c;

    public /* synthetic */ q0(MethodSelectorResolver methodSelectorResolver, UniqueId uniqueId, SelectorResolver.Context context) {
        this.f62535a = methodSelectorResolver;
        this.f62536b = uniqueId;
        this.f62537c = context;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f62535a.lambda$resolve$4(this.f62536b, this.f62537c, (MethodSelectorResolver.MethodType) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
