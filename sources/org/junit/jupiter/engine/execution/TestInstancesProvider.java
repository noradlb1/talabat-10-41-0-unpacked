package org.junit.jupiter.engine.execution;

import org.apiguardian.api.API;
import org.junit.jupiter.api.extension.TestInstances;
import org.junit.jupiter.engine.extension.ExtensionRegistrar;
import org.junit.jupiter.engine.extension.ExtensionRegistry;
import org.junit.jupiter.engine.extension.MutableExtensionRegistry;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

@FunctionalInterface
@API(since = "5.0", status = API.Status.INTERNAL)
public interface TestInstancesProvider {
    TestInstances getTestInstances(ExtensionRegistry extensionRegistry, ExtensionRegistrar extensionRegistrar, ThrowableCollector throwableCollector);

    TestInstances getTestInstances(MutableExtensionRegistry mutableExtensionRegistry, ThrowableCollector throwableCollector);
}
