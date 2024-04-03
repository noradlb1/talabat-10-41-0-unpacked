package org.junit.jupiter.engine.discovery;

import j$.util.function.Function;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.discovery.NestedClassSelector;

public final /* synthetic */ class t implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClassSelectorResolver f62544a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NestedClassSelector f62545b;

    public /* synthetic */ t(ClassSelectorResolver classSelectorResolver, NestedClassSelector nestedClassSelector) {
        this.f62544a = classSelectorResolver;
        this.f62545b = nestedClassSelector;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f62544a.lambda$resolve$4(this.f62545b, (TestDescriptor) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
