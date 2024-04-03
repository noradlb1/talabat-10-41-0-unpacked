package r30;

import org.junit.platform.engine.support.hierarchical.Node;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public final /* synthetic */ class m implements ThrowableCollector.Executable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Node.DynamicTestExecutor f28176a;

    public /* synthetic */ m(Node.DynamicTestExecutor dynamicTestExecutor) {
        this.f28176a = dynamicTestExecutor;
    }

    public final void execute() {
        this.f28176a.awaitFinished();
    }
}
