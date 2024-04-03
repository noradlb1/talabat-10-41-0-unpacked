package f30;

import org.junit.jupiter.api.extension.TestInstances;
import org.junit.jupiter.engine.execution.TestInstancesProvider;
import org.junit.jupiter.engine.extension.MutableExtensionRegistry;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public final /* synthetic */ class u {
    public static TestInstances a(TestInstancesProvider testInstancesProvider, MutableExtensionRegistry mutableExtensionRegistry, ThrowableCollector throwableCollector) {
        return testInstancesProvider.getTestInstances(mutableExtensionRegistry, mutableExtensionRegistry, throwableCollector);
    }
}
