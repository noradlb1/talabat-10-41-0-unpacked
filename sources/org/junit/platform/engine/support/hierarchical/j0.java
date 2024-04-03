package org.junit.platform.engine.support.hierarchical;

import j$.util.function.Consumer;
import org.junit.platform.engine.TestDescriptor;

public final /* synthetic */ class j0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NodeTreeWalker f28090b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Consumer f28091c;

    public /* synthetic */ j0(NodeTreeWalker nodeTreeWalker, Consumer consumer) {
        this.f28090b = nodeTreeWalker;
        this.f28091c = consumer;
    }

    public final void accept(Object obj) {
        this.f28090b.lambda$doForChildrenRecursively$6(this.f28091c, (TestDescriptor) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
