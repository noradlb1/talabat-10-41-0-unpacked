package org.junit.jupiter.engine.descriptor;

import d30.g0;
import j$.util.Optional;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.apiguardian.api.API;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstances;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.jupiter.engine.execution.JupiterEngineExecutionContext;
import org.junit.jupiter.engine.extension.ExtensionRegistrar;
import org.junit.jupiter.engine.extension.ExtensionRegistry;
import org.junit.platform.engine.TestTag;
import org.junit.platform.engine.UniqueId;
import org.junit.platform.engine.support.hierarchical.Node;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

@API(since = "5.0", status = API.Status.INTERNAL)
public class ClassTestDescriptor extends ClassBasedTestDescriptor {
    public static final String SEGMENT_TYPE = "class";

    public ClassTestDescriptor(UniqueId uniqueId, Class<?> cls, JupiterConfiguration jupiterConfiguration) {
        super(uniqueId, cls, DisplayNameUtils.f(cls, jupiterConfiguration), jupiterConfiguration);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Node.ExecutionMode lambda$getExecutionMode$0() {
        return JupiterTestDescriptor.toExecutionMode(this.f62416b.getDefaultClassesExecutionMode());
    }

    public TestInstances O(JupiterEngineExecutionContext jupiterEngineExecutionContext, ExtensionRegistry extensionRegistry, ExtensionRegistrar extensionRegistrar, ExtensionContext extensionContext, ThrowableCollector throwableCollector) {
        return N(Optional.empty(), extensionRegistry, extensionContext);
    }

    public List<Class<?>> getEnclosingTestClasses() {
        return Collections.emptyList();
    }

    public Node.ExecutionMode getExecutionMode() {
        return i().orElseGet(new g0(this));
    }

    public Set<TestTag> getTags() {
        return new LinkedHashSet(this.f62413c);
    }
}
