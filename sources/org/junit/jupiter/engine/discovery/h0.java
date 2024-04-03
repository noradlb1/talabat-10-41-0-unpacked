package org.junit.jupiter.engine.discovery;

import j$.util.function.Consumer;
import java.util.List;
import org.junit.jupiter.api.MethodOrderer;

public final /* synthetic */ class h0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodOrderingVisitor f62505b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MethodOrderer f62506c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Class f62507d;

    public /* synthetic */ h0(MethodOrderingVisitor methodOrderingVisitor, MethodOrderer methodOrderer, Class cls) {
        this.f62505b = methodOrderingVisitor;
        this.f62506c = methodOrderer;
        this.f62507d = cls;
    }

    public final void accept(Object obj) {
        this.f62505b.lambda$orderContainedMethods$3(this.f62506c, this.f62507d, (List) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
