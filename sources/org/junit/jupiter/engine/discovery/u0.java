package org.junit.jupiter.engine.discovery;

import j$.util.function.Function;
import java.lang.reflect.Method;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.jupiter.engine.discovery.MethodSelectorResolver;
import org.junit.platform.engine.TestDescriptor;

public final /* synthetic */ class u0 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MethodSelectorResolver.MethodType f62551a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TestDescriptor f62552b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Class f62553c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ JupiterConfiguration f62554d;

    public /* synthetic */ u0(MethodSelectorResolver.MethodType methodType, TestDescriptor testDescriptor, Class cls, JupiterConfiguration jupiterConfiguration) {
        this.f62551a = methodType;
        this.f62552b = testDescriptor;
        this.f62553c = cls;
        this.f62554d = jupiterConfiguration;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f62551a.lambda$resolveUniqueIdIntoTestDescriptor$3(this.f62552b, this.f62553c, this.f62554d, (Method) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
