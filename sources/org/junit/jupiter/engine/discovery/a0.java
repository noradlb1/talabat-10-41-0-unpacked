package org.junit.jupiter.engine.discovery;

import j$.util.function.Function;
import org.junit.platform.engine.TestDescriptor;

public final /* synthetic */ class a0 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClassSelectorResolver f62492a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f62493b;

    public /* synthetic */ a0(ClassSelectorResolver classSelectorResolver, String str) {
        this.f62492a = classSelectorResolver;
        this.f62493b = str;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f62492a.lambda$resolve$9(this.f62493b, (TestDescriptor) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
