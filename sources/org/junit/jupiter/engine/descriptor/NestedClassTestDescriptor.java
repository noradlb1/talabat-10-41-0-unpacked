package org.junit.jupiter.engine.descriptor;

import d30.f1;
import j$.util.Optional;
import java.util.ArrayList;
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
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.TestTag;
import org.junit.platform.engine.UniqueId;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

@API(since = "5.0", status = API.Status.INTERNAL)
public class NestedClassTestDescriptor extends ClassBasedTestDescriptor {
    public static final String SEGMENT_TYPE = "nested-class";

    public NestedClassTestDescriptor(UniqueId uniqueId, Class<?> cls, JupiterConfiguration jupiterConfiguration) {
        super(uniqueId, cls, DisplayNameUtils.g(cls, jupiterConfiguration), jupiterConfiguration);
    }

    public TestInstances O(JupiterEngineExecutionContext jupiterEngineExecutionContext, ExtensionRegistry extensionRegistry, ExtensionRegistrar extensionRegistrar, ExtensionContext extensionContext, ThrowableCollector throwableCollector) {
        return N(Optional.of(jupiterEngineExecutionContext.getTestInstancesProvider().getTestInstances(jupiterEngineExecutionContext.getExtensionRegistry(), extensionRegistrar, throwableCollector)), extensionRegistry, extensionContext);
    }

    public List<Class<?>> getEnclosingTestClasses() {
        TestDescriptor orElse = getParent().orElse(null);
        if (!(orElse instanceof ClassBasedTestDescriptor)) {
            return Collections.emptyList();
        }
        ClassBasedTestDescriptor classBasedTestDescriptor = (ClassBasedTestDescriptor) orElse;
        ArrayList arrayList = new ArrayList(classBasedTestDescriptor.getEnclosingTestClasses());
        arrayList.add(classBasedTestDescriptor.getTestClass());
        return arrayList;
    }

    public final Set<TestTag> getTags() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.f62413c);
        getParent().ifPresent(new f1(linkedHashSet));
        return linkedHashSet;
    }
}
