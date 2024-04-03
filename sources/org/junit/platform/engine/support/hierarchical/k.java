package org.junit.platform.engine.support.hierarchical;

import j$.util.function.Function;
import org.junit.platform.engine.TestDescriptor;

public final /* synthetic */ class k implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NodeExecutionAdvisor f28092a;

    public /* synthetic */ k(NodeExecutionAdvisor nodeExecutionAdvisor) {
        this.f28092a = nodeExecutionAdvisor;
    }

    public /* synthetic */ Function andThen(Function function) {
        return Function.CC.$default$andThen(this, function);
    }

    public final Object apply(Object obj) {
        return this.f28092a.lookupExecutionModeForcedByAncestor((TestDescriptor) obj);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function.CC.$default$compose(this, function);
    }
}
