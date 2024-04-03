package org.junit.jupiter.engine.discovery;

import j$.util.function.Function;
import java.lang.reflect.Method;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.jupiter.engine.discovery.MethodSelectorResolver;
import org.junit.platform.engine.TestDescriptor;

public final /* synthetic */ class w0 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodSelectorResolver.MethodType f62562a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Method f62563b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Class f62564c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ JupiterConfiguration f62565d;

    public /* synthetic */ w0(MethodSelectorResolver.MethodType methodType, Method method, Class cls, JupiterConfiguration jupiterConfiguration) {
        this.f62562a = methodType;
        this.f62563b = method;
        this.f62564c = cls;
        this.f62565d = jupiterConfiguration;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f62562a.lambda$resolve$1(this.f62563b, this.f62564c, this.f62565d, (TestDescriptor) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
