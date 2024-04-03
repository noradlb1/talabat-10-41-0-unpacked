package e30;

import org.junit.platform.engine.TestDescriptor;

public final /* synthetic */ class j implements TestDescriptor.Visitor {
    public final void visit(TestDescriptor testDescriptor) {
        testDescriptor.prune();
    }
}
