package org.junit.jupiter.engine.discovery;

import j$.util.function.Consumer;
import j$.util.function.Function;
import org.junit.jupiter.engine.discovery.AbstractOrderingVisitor;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbstractOrderingVisitor f62488b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AbstractOrderingVisitor.DescriptorWrapperOrderer f62489c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Class f62490d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Function f62491e;

    public /* synthetic */ a(AbstractOrderingVisitor abstractOrderingVisitor, AbstractOrderingVisitor.DescriptorWrapperOrderer descriptorWrapperOrderer, Class cls, Function function) {
        this.f62488b = abstractOrderingVisitor;
        this.f62489c = descriptorWrapperOrderer;
        this.f62490d = cls;
        this.f62491e = function;
    }

    public final void accept(Object obj) {
        this.f62488b.lambda$orderChildrenTestDescriptors$2(this.f62489c, this.f62490d, this.f62491e, (AbstractAnnotatedDescriptorWrapper) obj);
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
