package org.junit.jupiter.engine.discovery;

import j$.util.function.Function;
import org.junit.jupiter.api.ClassOrderer;

public final /* synthetic */ class m implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClassOrderingVisitor f62518a;

    public /* synthetic */ m(ClassOrderingVisitor classOrderingVisitor) {
        this.f62518a = classOrderingVisitor;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f62518a.createDescriptorWrapperOrderer((ClassOrderer) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
