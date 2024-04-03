package org.junit.jupiter.engine.discovery;

import j$.util.function.Consumer;
import java.util.List;
import org.junit.jupiter.api.ClassOrderer;

public final /* synthetic */ class i implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ClassOrderingVisitor f62508b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ClassOrderer f62509c;

    public /* synthetic */ i(ClassOrderingVisitor classOrderingVisitor, ClassOrderer classOrderer) {
        this.f62508b = classOrderingVisitor;
        this.f62509c = classOrderer;
    }

    public final void accept(Object obj) {
        this.f62508b.lambda$createDescriptorWrapperOrderer$3(this.f62509c, (List) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
