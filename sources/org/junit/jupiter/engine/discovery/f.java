package org.junit.jupiter.engine.discovery;

import j$.util.function.Consumer;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.engine.descriptor.JupiterEngineDescriptor;

public final /* synthetic */ class f implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ClassOrderingVisitor f62502b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ClassOrderer f62503c;

    public /* synthetic */ f(ClassOrderingVisitor classOrderingVisitor, ClassOrderer classOrderer) {
        this.f62502b = classOrderingVisitor;
        this.f62503c = classOrderer;
    }

    public final void accept(Object obj) {
        this.f62502b.lambda$visit$0(this.f62503c, (JupiterEngineDescriptor) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
