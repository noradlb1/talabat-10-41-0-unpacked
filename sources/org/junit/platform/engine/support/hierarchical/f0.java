package org.junit.platform.engine.support.hierarchical;

import j$.util.function.Consumer;
import java.util.Set;
import org.junit.platform.engine.TestDescriptor;

public final /* synthetic */ class f0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NodeTreeWalker f28081b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Set f28082c;

    public /* synthetic */ f0(NodeTreeWalker nodeTreeWalker, Set set) {
        this.f28081b = nodeTreeWalker;
        this.f28082c = set;
    }

    public final void accept(Object obj) {
        this.f28081b.lambda$walk$2(this.f28082c, (TestDescriptor) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
