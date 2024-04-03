package b30;

import org.junit.jupiter.engine.support.JupiterThrowableCollectorFactory;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public final /* synthetic */ class a implements ThrowableCollector.Factory {
    public final ThrowableCollector create() {
        return JupiterThrowableCollectorFactory.createThrowableCollector();
    }
}
