package r30;

import org.junit.platform.engine.support.hierarchical.OpenTest4JAwareThrowableCollector;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public final /* synthetic */ class h implements ThrowableCollector.Factory {
    public final ThrowableCollector create() {
        return new OpenTest4JAwareThrowableCollector();
    }
}
