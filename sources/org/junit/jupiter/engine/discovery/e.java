package org.junit.jupiter.engine.discovery;

import j$.util.function.Function;
import j$.util.function.Supplier;
import org.junit.platform.engine.TestDescriptor;

public final /* synthetic */ class e implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function f62497a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TestDescriptor f62498b;

    public /* synthetic */ e(Function function, TestDescriptor testDescriptor) {
        this.f62497a = function;
        this.f62498b = testDescriptor;
    }

    public final Object get() {
        return AbstractOrderingVisitor.lambda$doWithMatchingDescriptor$0(this.f62497a, this.f62498b);
    }
}
