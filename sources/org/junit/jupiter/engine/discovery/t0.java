package org.junit.jupiter.engine.discovery;

import j$.util.function.Function;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.jupiter.engine.discovery.MethodSelectorResolver;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.UniqueId;

public final /* synthetic */ class t0 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodSelectorResolver.MethodType f62546a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UniqueId.Segment f62547b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ JupiterConfiguration f62548c;

    public /* synthetic */ t0(MethodSelectorResolver.MethodType methodType, UniqueId.Segment segment, JupiterConfiguration jupiterConfiguration) {
        this.f62546a = methodType;
        this.f62547b = segment;
        this.f62548c = jupiterConfiguration;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f62546a.lambda$resolveUniqueIdIntoTestDescriptor$4(this.f62547b, this.f62548c, (TestDescriptor) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
