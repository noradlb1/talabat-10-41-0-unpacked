package org.junit.jupiter.engine.descriptor;

import f30.u;
import org.junit.jupiter.api.extension.TestInstances;
import org.junit.jupiter.engine.execution.JupiterEngineExecutionContext;
import org.junit.jupiter.engine.execution.TestInstancesProvider;
import org.junit.jupiter.engine.extension.ExtensionRegistrar;
import org.junit.jupiter.engine.extension.ExtensionRegistry;
import org.junit.jupiter.engine.extension.MutableExtensionRegistry;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public final /* synthetic */ class a implements TestInstancesProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClassBasedTestDescriptor f62420a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ClassExtensionContext f62421b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ JupiterEngineExecutionContext f62422c;

    public /* synthetic */ a(ClassBasedTestDescriptor classBasedTestDescriptor, ClassExtensionContext classExtensionContext, JupiterEngineExecutionContext jupiterEngineExecutionContext) {
        this.f62420a = classBasedTestDescriptor;
        this.f62421b = classExtensionContext;
        this.f62422c = jupiterEngineExecutionContext;
    }

    public final TestInstances getTestInstances(ExtensionRegistry extensionRegistry, ExtensionRegistrar extensionRegistrar, ThrowableCollector throwableCollector) {
        return this.f62420a.lambda$testInstancesProvider$5(this.f62421b, this.f62422c, extensionRegistry, extensionRegistrar, throwableCollector);
    }

    public /* synthetic */ TestInstances getTestInstances(MutableExtensionRegistry mutableExtensionRegistry, ThrowableCollector throwableCollector) {
        return u.a(this, mutableExtensionRegistry, throwableCollector);
    }
}
